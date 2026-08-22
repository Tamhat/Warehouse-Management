package com.warehouse.management.service;

public class OutboundOrderService {

    public void placeOrder() {}
    // RBAC: Customer

    public void confirmOrder() {}
    // RBAC: WarehouseManager

    public void cancelOrder() {}
    // RBAC: Customer, WarehouseManager
}
