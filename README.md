## Warehouse Management — Actors & Objects

### Actors

| # | Actor | Role |
|---|---|---|
| 1 | **Warehouse Manager** | Oversees overall warehouse operations |
| 2 | **Inventory Clerk** | Manages stock counts and records |
| 3 | **Picker** | Picks items for outbound orders |
| 4 | **Packer** | Packs picked items for shipment |
| 5 | **Receiving Clerk** | Handles inbound goods receipt |
| 6 | **Forklift Operator** | Operates material-handling equipment |
| 7 | **Quality Control Inspector** | Inspects incoming/outgoing goods for defects |
| 8 | **Supplier/Vendor** | Sends inbound shipments of goods |
| 9 | **Customer/Buyer** | Places outbound orders |
| 10 | **Delivery Driver/Carrier** | Transports goods in/out of the warehouse |
| 11 | **Procurement Officer** | Orders replenishment stock |
| 12 | **Warehouse Admin/System Admin** | Configures zones, users, system settings |
| 13 | **Auditor** | Conducts stock audits and compliance checks |
| 14 | **Maintenance Technician** | Maintains equipment and facility infrastructure |

### Objects

| # | Object | Description |
|---|---|---|
| 1 | **Warehouse** | The overall facility entity |
| 2 | **Zone/Location** | A defined storage area (aisle, rack, bin) within the warehouse |
| 3 | **Product/SKU** | An item type tracked in the warehouse |
| 4 | **Inventory/Stock Record** | Quantity of a product at a specific location |
| 5 | **Inbound Shipment/Receipt** | Incoming goods delivery from a supplier |
| 6 | **Purchase Order** | Order placed to a supplier for replenishment |
| 7 | **Outbound Order/Sales Order** | Order to be fulfilled and shipped to a customer |
| 8 | **Pick List** | List of items to be picked for an order |
| 9 | **Pack List/Packing Slip** | Record of items packed for shipment |
| 10 | **Shipment/Delivery** | Outbound goods movement to a customer |
| 11 | **Stock Transfer** | Movement of inventory between zones/warehouses |
| 12 | **Stock Adjustment** | Correction to recorded inventory (damage, loss, count error) |
| 13 | **Cycle Count/Audit Record** | Periodic inventory verification record |
| 14 | **Equipment (Forklift/Conveyor/etc.)** | Material-handling machinery |
| 15 | **Equipment Maintenance Record** | Service/repair history for equipment |
| 16 | **Quality Inspection** | Inspection event for inbound/outbound goods |
| 17 | **Return/RMA (Return Merchandise Authorization)** | Customer or supplier return record |
| 18 | **Damage/Loss Report** | Record of damaged or lost inventory |
| 19 | **User/Access Role** | System user account with warehouse role permissions |
| 20 | **Barcode/RFID Tag Record** | Tracking identifier for items or pallets |
| 21 | **Invoice/Billing Record** | Billing document for outbound orders |

---
