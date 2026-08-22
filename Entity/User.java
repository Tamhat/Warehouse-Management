public class User {

    private String userId;
    private String name;
    private UserRole role;
    private String warehouseId;
    private UserStatus status;

    public enum UserRole {
        WAREHOUSE_MANAGER,
        INVENTORY_CLERK,
        PICKER,
        PACKER,
        RECEIVING_CLERK,
        FORKLIFT_OPERATOR,
        QUALITY_CONTROL_INSPECTOR,
        SUPPLIER,
        CUSTOMER,
        DELIVERY_DRIVER,
        PROCUREMENT_OFFICER,
        WAREHOUSE_ADMIN,
        AUDITOR,
        MAINTENANCE_TECHNICIAN
    }

    public enum UserStatus {
        ACTIVE,
        SUSPENDED,
        DEACTIVATED
    }
}
