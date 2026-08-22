package com.warehouse.management.service;

public class DamageLossReportService {

    public void reportDamageOrLoss() {}
    // RBAC: InventoryClerk, ForkliftOperator, Picker

    public void investigateReport() {}
    // RBAC: WarehouseManager

    public void closeReport() {}
    // RBAC: WarehouseManager
}
