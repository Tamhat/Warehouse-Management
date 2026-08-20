# Warehouse Management — Domain Model

---

## 1. Warehouse

```
══════════════════════════════════════════════
                 WAREHOUSE
══════════════════════════════════════════════

ATTRIBUTES

  warehouseId
  name
  address
  totalCapacity
  operatingHours


RELATIONSHIPS

CARDINALITY        OBJECT

1 : N               Zone
1 : N               InboundShipment
1 : N               OutboundOrder
1 : N               Equipment


CARDINALITY        ACTOR / USER

1 : N               WarehouseManager
1 : N               WarehouseAdmin


ACTIONS                         ACTORS / USERS

registerWarehouse()                → WarehouseAdmin
configureWarehouse()               → WarehouseAdmin
closeWarehouse()                   → WarehouseManager


STATE

  Active
  UnderMaintenance
  Closed


STATE TRANSITIONS

  Active → maintenanceScheduled → UnderMaintenance
  UnderMaintenance → complete → Active
  Active → close → Closed


BUSINESS RULES

  A warehouse must have at least one active Zone to receive inbound stock
```

---

## 2. Zone / Location

```
══════════════════════════════════════════════
                 ZONE / LOCATION
══════════════════════════════════════════════

ATTRIBUTES

  zoneId
  warehouseId
  zoneType (receiving/storage/picking/shipping)
  aisle
  rack
  bin
  capacity


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               Warehouse
1 : N               InventoryRecord


CARDINALITY        ACTOR / USER

N : 1               WarehouseAdmin
N : 1               InventoryClerk


ACTIONS                         ACTORS / USERS

createZone()                        → WarehouseAdmin
assignZone()                        → InventoryClerk
deactivateZone()                    → WarehouseAdmin


STATE

  Active
  Full
  Inactive


STATE TRANSITIONS

  Active → capacityReached → Full
  Full → spaceFreed → Active
  Active → deactivate → Inactive


BUSINESS RULES

  Stock cannot be placed into a Full or Inactive zone
```

---

## 3. Product / SKU

```
══════════════════════════════════════════════
                 PRODUCT / SKU
══════════════════════════════════════════════

ATTRIBUTES

  productId
  sku
  name
  category
  unitOfMeasure
  reorderThreshold


RELATIONSHIPS

CARDINALITY        OBJECT

1 : N               InventoryRecord
1 : N               BarcodeTag
N : N               PurchaseOrder
N : N               OutboundOrder


CARDINALITY        ACTOR / USER

N : 1               InventoryClerk
N : 1               ProcurementOfficer


ACTIONS                         ACTORS / USERS

registerProduct()                   → InventoryClerk
updateProductInfo()                 → InventoryClerk
discontinueProduct()                → WarehouseManager


STATE

  Active
  Discontinued


STATE TRANSITIONS

  Active → discontinue → Discontinued


BUSINESS RULES

  Discontinued products cannot appear on new Purchase Orders
```

---

## 4. Inventory / Stock Record

```
══════════════════════════════════════════════
                 INVENTORY / STOCK RECORD
══════════════════════════════════════════════

ATTRIBUTES

  inventoryId
  productId
  zoneId
  quantityOnHand
  quantityReserved
  lastCountedDate


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               Product
N : 1               Zone
1 : N               StockAdjustment
1 : N               CycleCount


CARDINALITY        ACTOR / USER

N : 1               InventoryClerk


ACTIONS                         ACTORS / USERS

updateQuantity()                    → InventoryClerk, System
reserveStock()                      → System (on order)
releaseStock()                      → System (on cancellation)


STATE

  InStock
  LowStock
  OutOfStock


STATE TRANSITIONS

  InStock → belowThreshold → LowStock
  LowStock → quantityZero → OutOfStock
  LowStock/OutOfStock → restock → InStock


BUSINESS RULES

  LowStock automatically triggers a suggested Purchase Order
  Reserved quantity cannot exceed quantityOnHand
```

---

## 5. Inbound Shipment / Receipt

```
══════════════════════════════════════════════
                 INBOUND SHIPMENT / RECEIPT
══════════════════════════════════════════════

ATTRIBUTES

  shipmentId
  purchaseOrderId
  supplierId
  expectedDate
  actualArrivalDate (nullable)
  status


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               PurchaseOrder
N : 1               Warehouse
1 : N               QualityInspection
1 : N               InventoryRecord (upon putaway)


CARDINALITY        ACTOR / USER

N : 1               ReceivingClerk
N : 1               Supplier


ACTIONS                         ACTORS / USERS

scheduleReceipt()                   → ReceivingClerk
receiveShipment()                   → ReceivingClerk
inspectShipment()                   → QualityInspector
putawayStock()                      → InventoryClerk, ForkliftOperator


STATE

  Scheduled
  Arrived
  Inspecting
  PutAway
  Rejected


STATE TRANSITIONS

  Scheduled → arrive → Arrived
  Arrived → inspect → Inspecting
  Inspecting → pass → PutAway
  Inspecting → fail → Rejected


BUSINESS RULES

  Rejected shipments trigger a Return/RMA back to the supplier
  Inventory is only updated once stock reaches PutAway
```

---

## 6. Purchase Order

```
══════════════════════════════════════════════
                 PURCHASE ORDER
══════════════════════════════════════════════

ATTRIBUTES

  orderId
  supplierId
  items[]
  orderDate
  expectedDeliveryDate
  status


RELATIONSHIPS

CARDINALITY        OBJECT

N : N               Product
1 : 1               InboundShipment (fulfillment)


CARDINALITY        ACTOR / USER

N : 1               ProcurementOfficer
N : 1               Supplier
N : 1               WarehouseManager (approves)


ACTIONS                         ACTORS / USERS

createOrder()                       → ProcurementOfficer
approveOrder()                      → WarehouseManager
sendOrder()                         → ProcurementOfficer
cancelOrder()                       → ProcurementOfficer


STATE

  Draft
  Approved
  Sent
  PartiallyReceived
  Received
  Cancelled


STATE TRANSITIONS

  Draft → approve → Approved
  Approved → send → Sent
  Sent → partialReceipt → PartiallyReceived
  Sent/PartiallyReceived → fullyReceived → Received
  Draft/Approved/Sent → cancel → Cancelled


BUSINESS RULES

  Orders above a set value require WarehouseManager approval
  PartiallyReceived orders remain open until all line items are fulfilled or the order is closed manually
```

---

## 7. Outbound Order / Sales Order

```
══════════════════════════════════════════════
                 OUTBOUND ORDER / SALES ORDER
══════════════════════════════════════════════

ATTRIBUTES

  orderId
  customerId
  items[]
  orderDate
  requestedShipDate
  status


RELATIONSHIPS

CARDINALITY        OBJECT

N : N               Product
1 : 1               PickList
1 : 1               PackList
1 : 1               Shipment
1 : 1               Invoice


CARDINALITY        ACTOR / USER

N : 1               Customer
N : 1               WarehouseManager


ACTIONS                         ACTORS / USERS

placeOrder()                        → Customer
confirmOrder()                      → WarehouseManager
cancelOrder()                       → Customer, WarehouseManager


STATE

  Placed
  Confirmed
  Picking
  Packed
  Shipped
  Delivered
  Cancelled


STATE TRANSITIONS

  Placed → confirm → Confirmed
  Confirmed → generatePickList → Picking
  Picking → allItemsPicked → Packed
  Packed → ship → Shipped
  Shipped → deliver → Delivered
  Placed/Confirmed → cancel → Cancelled


BUSINESS RULES

  Order cannot be Confirmed if reserved stock is insufficient
  Order cannot be cancelled once Shipped
```

---

## 8. Pick List

```
══════════════════════════════════════════════
                 PICK LIST
══════════════════════════════════════════════

ATTRIBUTES

  pickListId
  outboundOrderId
  items[]
  assignedPickerId
  createdDate
  status


RELATIONSHIPS

CARDINALITY        OBJECT

1 : 1               OutboundOrder
N : N               InventoryRecord (items picked from)


CARDINALITY        ACTOR / USER

N : 1               Picker


ACTIONS                         ACTORS / USERS

generatePickList()                  → System
assignPicker()                      → WarehouseManager
completePicking()                   → Picker


STATE

  Pending
  InProgress
  Completed
  Exception


STATE TRANSITIONS

  Pending → assign → InProgress
  InProgress → complete → Completed
  InProgress → itemMissing → Exception
  Exception → resolve → InProgress


BUSINESS RULES

  A missing item during picking raises a Stock Adjustment for investigation
```

---

## 9. Pack List / Packing Slip

```
══════════════════════════════════════════════
                 PACK LIST / PACKING SLIP
══════════════════════════════════════════════

ATTRIBUTES

  packListId
  outboundOrderId
  pickListId
  packedItems[]
  packedDate
  status


RELATIONSHIPS

CARDINALITY        OBJECT

1 : 1               OutboundOrder
1 : 1               PickList
1 : 1               Shipment


CARDINALITY        ACTOR / USER

N : 1               Packer


ACTIONS                         ACTORS / USERS

startPacking()                      → Packer
completePacking()                   → Packer
verifyPack()                        → QualityInspector


STATE

  Pending
  InProgress
  Completed


STATE TRANSITIONS

  Pending → start → InProgress
  InProgress → complete → Completed


BUSINESS RULES

  Packed item quantities must match the Pick List exactly before completion
```

---

## 10. Shipment / Delivery

```
══════════════════════════════════════════════
                 SHIPMENT / DELIVERY
══════════════════════════════════════════════

ATTRIBUTES

  shipmentId
  outboundOrderId
  carrier
  trackingNumber
  dispatchDate
  status


RELATIONSHIPS

CARDINALITY        OBJECT

1 : 1               OutboundOrder
1 : 1               PackList


CARDINALITY        ACTOR / USER

N : 1               DeliveryDriver/Carrier


ACTIONS                         ACTORS / USERS

dispatchShipment()                  → WarehouseManager
updateTrackingStatus()              → DeliveryDriver
confirmDelivery()                   → DeliveryDriver, Customer


STATE

  Pending
  Dispatched
  InTransit
  Delivered
  Failed


STATE TRANSITIONS

  Pending → dispatch → Dispatched
  Dispatched → transit → InTransit
  InTransit → deliver → Delivered
  InTransit → deliveryFails → Failed


BUSINESS RULES

  Failed deliveries trigger an automatic return-to-warehouse workflow
```

---

## 11. Stock Transfer

```
══════════════════════════════════════════════
                 STOCK TRANSFER
══════════════════════════════════════════════

ATTRIBUTES

  transferId
  productId
  fromZoneId (or fromWarehouseId)
  toZoneId (or toWarehouseId)
  quantity
  requestedDate
  status


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               Product
N : 1               Zone (source)
N : 1               Zone (destination)


CARDINALITY        ACTOR / USER

N : 1               InventoryClerk
N : 1               ForkliftOperator


ACTIONS                         ACTORS / USERS

requestTransfer()                   → InventoryClerk
approveTransfer()                   → WarehouseManager
executeTransfer()                   → ForkliftOperator


STATE

  Requested
  Approved
  InTransit
  Completed


STATE TRANSITIONS

  Requested → approve → Approved
  Approved → start → InTransit
  InTransit → complete → Completed


BUSINESS RULES

  Source zone quantity is decremented only once the transfer reaches Completed
```

---

## 12. Stock Adjustment

```
══════════════════════════════════════════════
                 STOCK ADJUSTMENT
══════════════════════════════════════════════

ATTRIBUTES

  adjustmentId
  inventoryId
  reason (damage/loss/countError/theft)
  quantityChange
  adjustmentDate
  status


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               InventoryRecord
0 : 1               DamageLossReport
0 : 1               CycleCount (source of discrepancy)


CARDINALITY        ACTOR / USER

N : 1               InventoryClerk
N : 1               WarehouseManager (approves)


ACTIONS                         ACTORS / USERS

createAdjustment()                  → InventoryClerk
approveAdjustment()                 → WarehouseManager
applyAdjustment()                   → System


STATE

  Pending
  Approved
  Rejected
  Applied


STATE TRANSITIONS

  Pending → approve → Approved
  Pending → reject → Rejected
  Approved → apply → Applied


BUSINESS RULES

  Adjustments above a set quantity/value threshold require WarehouseManager approval
```

---

## 13. Cycle Count / Audit Record

```
══════════════════════════════════════════════
                 CYCLE COUNT / AUDIT RECORD
══════════════════════════════════════════════

ATTRIBUTES

  countId
  zoneId
  scheduledDate
  countedQuantity
  systemQuantity
  discrepancy
  status


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               Zone
1 : N               InventoryRecord
0 : N               StockAdjustment (generated from discrepancies)


CARDINALITY        ACTOR / USER

N : 1               InventoryClerk
N : 1               Auditor


ACTIONS                         ACTORS / USERS

scheduleCount()                      → WarehouseManager
performCount()                       → InventoryClerk, Auditor
reconcileDiscrepancy()               → WarehouseManager


STATE

  Scheduled
  InProgress
  Completed
  Reconciled


STATE TRANSITIONS

  Scheduled → start → InProgress
  InProgress → complete → Completed
  Completed → discrepancyResolved → Reconciled


BUSINESS RULES

  Any discrepancy found in a count automatically generates a Stock Adjustment for review
```

---

## 14. Equipment (Forklift / Conveyor / etc.)

```
══════════════════════════════════════════════
                 EQUIPMENT
══════════════════════════════════════════════

ATTRIBUTES

  equipmentId
  warehouseId
  type (forklift/conveyor/scanner)
  purchaseDate
  status


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               Warehouse
1 : N               EquipmentMaintenanceRecord


CARDINALITY        ACTOR / USER

N : 1               ForkliftOperator
N : 1               MaintenanceTechnician


ACTIONS                         ACTORS / USERS

registerEquipment()                  → WarehouseAdmin
assignEquipment()                    → WarehouseManager
scheduleMaintenance()                → MaintenanceTechnician
retireEquipment()                    → WarehouseAdmin


STATE

  Available
  InUse
  UnderMaintenance
  OutOfService


STATE TRANSITIONS

  Available → assign → InUse
  InUse → release → Available
  Available/InUse → maintenanceDue → UnderMaintenance
  UnderMaintenance → complete → Available
  Any → breakdown → OutOfService


BUSINESS RULES

  OutOfService equipment cannot be assigned to any task
```

---

## 15. Equipment Maintenance Record

```
══════════════════════════════════════════════
                 EQUIPMENT MAINTENANCE RECORD
══════════════════════════════════════════════

ATTRIBUTES

  recordId
  equipmentId
  serviceDate
  description
  cost
  nextServiceDue


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               Equipment


CARDINALITY        ACTOR / USER

N : 1               MaintenanceTechnician


ACTIONS                         ACTORS / USERS

logMaintenance()                     → MaintenanceTechnician
scheduleNextService()                → MaintenanceTechnician


STATE

  Scheduled
  Completed


STATE TRANSITIONS

  Scheduled → serviceComplete → Completed


BUSINESS RULES

  Equipment cannot return to Available until the latest maintenance record is Completed
```

---

## 16. Quality Inspection

```
══════════════════════════════════════════════
                 QUALITY INSPECTION
══════════════════════════════════════════════

ATTRIBUTES

  inspectionId
  targetType (inboundShipment/outboundOrder)
  targetId
  inspectionDate
  result
  status


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               InboundShipment
N : 1               OutboundOrder


CARDINALITY        ACTOR / USER

N : 1               QualityControlInspector


ACTIONS                         ACTORS / USERS

conductInspection()                  → QualityControlInspector
recordFindings()                     → QualityControlInspector


STATE

  Scheduled
  Passed
  Failed


STATE TRANSITIONS

  Scheduled → inspect (pass) → Passed
  Scheduled → inspect (fail) → Failed


BUSINESS RULES

  A Failed inbound inspection blocks putaway and triggers a Return/RMA to the supplier
```

---

## 17. Return / RMA (Return Merchandise Authorization)

```
══════════════════════════════════════════════
                 RETURN / RMA
══════════════════════════════════════════════

ATTRIBUTES

  rmaId
  referenceType (inboundShipment/outboundOrder)
  referenceId
  reason
  requestDate
  status


RELATIONSHIPS

CARDINALITY        OBJECT

0 : 1               InboundShipment
0 : 1               OutboundOrder


CARDINALITY        ACTOR / USER

N : 1               Customer, Supplier
N : 1               WarehouseManager (approves)


ACTIONS                         ACTORS / USERS

requestRMA()                         → Customer, Supplier
approveRMA()                         → WarehouseManager
processReturn()                      → ReceivingClerk


STATE

  Requested
  Approved
  Rejected
  Processed


STATE TRANSITIONS

  Requested → approve → Approved
  Requested → reject → Rejected
  Approved → process → Processed


BUSINESS RULES

  Processed returns update Inventory once goods pass a Quality Inspection
```

---

## 18. Damage / Loss Report

```
══════════════════════════════════════════════
                 DAMAGE / LOSS REPORT
══════════════════════════════════════════════

ATTRIBUTES

  reportId
  inventoryId
  reportedBy
  description
  quantityAffected
  reportedDate
  status


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               InventoryRecord
1 : 1               StockAdjustment (resulting correction)


CARDINALITY        ACTOR / USER

N : 1               InventoryClerk, ForkliftOperator (reports)
N : 1               WarehouseManager (reviews)


ACTIONS                         ACTORS / USERS

reportDamageOrLoss()                  → InventoryClerk, ForkliftOperator, Picker
investigateReport()                   → WarehouseManager
closeReport()                         → WarehouseManager


STATE

  Reported
  UnderInvestigation
  Resolved


STATE TRANSITIONS

  Reported → investigate → UnderInvestigation
  UnderInvestigation → resolve → Resolved


BUSINESS RULES

  A Resolved report must generate a corresponding Stock Adjustment before closing
```

---

## 19. User / Access Role

```
══════════════════════════════════════════════
                 USER / ACCESS ROLE
══════════════════════════════════════════════

ATTRIBUTES

  userId
  name
  role
  warehouseId
  status


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               Warehouse


CARDINALITY        ACTOR / USER

1 : 1               (maps directly to any Actor — Picker, Packer, Clerk, etc.)


ACTIONS                         ACTORS / USERS

createUser()                          → WarehouseAdmin
assignRole()                          → WarehouseAdmin
deactivateUser()                      → WarehouseAdmin


STATE

  Active
  Suspended
  Deactivated


STATE TRANSITIONS

  Active → suspend → Suspended
  Suspended → reinstate → Active
  Active/Suspended → deactivate → Deactivated


BUSINESS RULES

  A deactivated user cannot log any warehouse actions (audit trail requirement)
```

---

## 20. Barcode / RFID Tag Record

```
══════════════════════════════════════════════
                 BARCODE / RFID TAG RECORD
══════════════════════════════════════════════

ATTRIBUTES

  tagId
  productId
  tagType (barcode/RFID)
  assignedDate
  currentLocationId


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               Product
0 : 1               Zone (current location)


CARDINALITY        ACTOR / USER

N : 1               InventoryClerk, ReceivingClerk


ACTIONS                         ACTORS / USERS

generateTag()                         → InventoryClerk
scanTag()                             → Picker, Packer, ForkliftOperator
retireTag()                           → InventoryClerk


STATE

  Active
  Retired


STATE TRANSITIONS

  Active → retire → Retired


BUSINESS RULES

  Every scan event updates the tag's currentLocationId in real time
```

---

## 21. Invoice / Billing Record

```
══════════════════════════════════════════════
                 INVOICE / BILLING RECORD
══════════════════════════════════════════════

ATTRIBUTES

  invoiceId
  outboundOrderId
  amount
  issueDate
  dueDate
  status


RELATIONSHIPS

CARDINALITY        OBJECT

1 : 1               OutboundOrder


CARDINALITY        ACTOR / USER

N : 1               Customer
N : 1               WarehouseManager


ACTIONS                         ACTORS / USERS

generateInvoice()                     → System
sendInvoice()                         → WarehouseManager
recordPayment()                       → WarehouseManager


STATE

  Issued
  Paid
  Overdue


STATE TRANSITIONS

  Issued → paymentReceived → Paid
  Issued → dueDatePassed → Overdue


BUSINESS RULES

  Order not considered fully closed until linked Invoice is Paid
```

---

## Actor Reference

| Actor | Primary Involvement |
|---|---|
| Warehouse Manager | Warehouse, Zone, PurchaseOrder approval, StockAdjustment approval |
| Inventory Clerk | InventoryRecord, StockTransfer, StockAdjustment, BarcodeTag |
| Picker | PickList |
| Packer | PackList |
| Receiving Clerk | InboundShipment |
| Forklift Operator | Equipment, StockTransfer, BarcodeTag scanning |
| Quality Control Inspector | QualityInspection |
| Supplier/Vendor | PurchaseOrder, InboundShipment, RMA |
| Customer/Buyer | OutboundOrder, Shipment, Invoice, RMA |
| Delivery Driver/Carrier | Shipment |
| Procurement Officer | PurchaseOrder |
| Warehouse Admin/System Admin | Warehouse config, Zone, Equipment registration, User |
| Auditor | CycleCount |
| Maintenance Technician | Equipment, EquipmentMaintenanceRecord |