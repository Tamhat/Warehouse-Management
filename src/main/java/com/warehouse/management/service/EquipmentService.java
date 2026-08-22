package com.warehouse.management.service;

public class EquipmentService {

    public void registerEquipment() {}
    // RBAC: WarehouseAdmin

    public void assignEquipment() {}
    // RBAC: WarehouseManager

    public void scheduleMaintenance() {}
    // RBAC: MaintenanceTechnician

    public void retireEquipment() {}
    // RBAC: WarehouseAdmin
}
