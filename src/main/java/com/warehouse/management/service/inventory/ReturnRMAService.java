package com.warehouse.management.service.inventory;

public class ReturnRMAService {

    public void requestRMA() {}
    // RBAC: Customer, Supplier

    public void approveRMA() {}
    // RBAC: WarehouseManager

    public void processReturn() {}
    // RBAC: ReceivingClerk
}
