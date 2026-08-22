package com.warehouse.management.service;

public class ReturnRMAService {

    public void requestRMA() {}
    // RBAC: Customer, Supplier

    public void approveRMA() {}
    // RBAC: WarehouseManager

    public void processReturn() {}
    // RBAC: ReceivingClerk
}
