
public abstract class CancelShipmentRequest {
    String sub_id, ship_id;
    public CancelShipmentRequest(String subid,String shipid) {
        this.sub_id = subid;    
        this.ship_id = shipid;
    }

    public abstract ObjectResponse cancelShipment(Data_Store ds);
}
