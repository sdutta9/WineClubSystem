
public abstract class ViewShipmentRequest {
    String sub_id, ship_id;
    public ViewShipmentRequest(String subid,String shipid) {
        this.sub_id = subid;    
        this.ship_id = shipid;
    }

    public abstract ObjectResponse viewShipment(Data_Store ds);
}
