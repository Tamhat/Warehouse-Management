package com.warehouse.management.service;

public class StockTransferService {

    public void requestTransfer() {}
    // RBAC: InventoryClerk

    public void approveTransfer() {}
    // RBAC: WarehouseManager

    public void executeTransfer() {}
    // RBAC: ForkliftOperator
}
