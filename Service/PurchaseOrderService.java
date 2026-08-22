public class PurchaseOrderService {

    public void createOrder() {}
    // RBAC: ProcurementOfficer

    public void approveOrder() {}
    // RBAC: WarehouseManager

    public void sendOrder() {}
    // RBAC: ProcurementOfficer

    public void cancelOrder() {}
    // RBAC: ProcurementOfficer
}
