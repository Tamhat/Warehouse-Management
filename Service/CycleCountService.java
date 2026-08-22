public class CycleCountService {

    public void scheduleCount() {}
    // RBAC: WarehouseManager

    public void performCount() {}
    // RBAC: InventoryClerk, Auditor

    public void reconcileDiscrepancy() {}
    // RBAC: WarehouseManager
}
