package com.warehouse.management.service;

public class BarcodeTagService {

    public void generateTag() {}
    // RBAC: InventoryClerk

    public void scanTag() {}
    // RBAC: Picker, Packer, ForkliftOperator

    public void retireTag() {}
    // RBAC: InventoryClerk
}
