public class ShipmentService {

    public void dispatchShipment() {}
    // RBAC: WarehouseManager

    public void updateTrackingStatus() {}
    // RBAC: DeliveryDriver

    public void confirmDelivery() {}
    // RBAC: DeliveryDriver, Customer
}
