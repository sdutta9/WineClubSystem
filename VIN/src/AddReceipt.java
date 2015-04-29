
import java.util.Iterator;

public class AddReceipt extends AddReceiptRequest {
    
    public AddReceipt(String shipid, String receiverName) {
            super(shipid,receiverName);
    }

    @Override
    public ObjectResponse addReceipt(Data_Store ds) {
        if(Validator.missingValue(ship_ID))
            return new ObjectResponse(1044, false, "Shipment ID must be provided");
        if(Validator.missingValue(receiverNm))
            return new ObjectResponse(1046, false, "Receiver Name must be provided");
        
        int shipID = Validator.isValidNumber(ship_ID);
        
        Iterator<Shipment> it_ship = ds.shipments.iterator();
        Shipment s=null;
        while(it_ship.hasNext()){
            s = it_ship.next();
            if(s.getShipID() == shipID)
                break;
        }
        if(s == null)
            return new ObjectResponse(1025,false,"Invalid Shipment ID"); 
        else if(s.getStatus() != ShipmentStatus.UNDELIVERED)
            return new ObjectResponse(1028,false,"Cannot add receipt as Shipment either Delivered or Cancelled");
        else{
            int subid =s.getSubID();
            Subscriber sub =null;
            String subname=null;
            Iterator<Subscriber> it_sub = ds.subs.iterator();
            while(it_sub.hasNext()){
                sub = it_sub.next();
                if(sub.getID()== subid){
                    subname = sub.getName();
                    break;
                }
            }
            Receipt tempreceipt = new Receipt(subid,subname,this.receiverNm);
            s.setReceiptID(tempreceipt.getReceiptID());
            s.setStatus(ShipmentStatus.DELIVERED);
            
            sub.setNextDeliveryDt();
            Iterator<MonthlySelection> it_ms = ds.mselections.iterator();
            while(it_ms.hasNext()){
                MonthlySelection ms =it_ms.next();
                if(ms.isMatchMST(sub.getDeliveryYearMonth().toString(), sub.getPreference().name())){
                    Shipment temp = new Shipment(sub.getID(),sub.getDeliveryDt(),sub.getPreference());
                    ds.shipments.add(temp);
                    break;
                }                    
            }
            ds.receipts.add(tempreceipt);
            String output ="{\n\t\"id\": "+tempreceipt.getReceiptID()+"\n}\n";
            return new ObjectResponse(tempreceipt.getReceiptID(),true,output);
        }               
    }        
}
