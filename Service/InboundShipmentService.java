public class InboundShipmentService {

    public void scheduleReceipt() {}
    // RBAC: ReceivingClerk

    public void receiveShipment() {}
    // RBAC: ReceivingClerk

    public void inspectShipment() {}
    // RBAC: QualityControlInspector

    public void putawayStock() {}
    // RBAC: InventoryClerk, ForkliftOperator
}
