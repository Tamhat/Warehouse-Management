package com.warehouse.management.service.outbound;

public class ShipmentService {

    public void dispatchShipment() {}
    // RBAC: WarehouseManager

    public void updateTrackingStatus() {}
    // RBAC: DeliveryDriver

    public void confirmDelivery() {}
    // RBAC: DeliveryDriver, Customer
}
