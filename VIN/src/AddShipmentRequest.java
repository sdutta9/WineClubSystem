
public abstract class AddShipmentRequest {
	String mst,ym;
	
	public AddShipmentRequest(String type,String ymonth) {
            this.mst = type;
            this.ym = ymonth;
	}
	
	public abstract ObjectResponse addShipment(Data_Store ds);
}
