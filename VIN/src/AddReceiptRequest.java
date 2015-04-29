
public abstract class AddReceiptRequest {
	String ship_ID, receiverNm;
	public AddReceiptRequest(String shipid, String recName) {
           this.ship_ID = shipid;
           this.receiverNm = recName;
	}
	
	public abstract ObjectResponse addReceipt(Data_Store ds);
}
