
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class CancelShipment extends CancelShipmentRequest {
    public CancelShipment(String sid,String shipid) {
	super(sid,shipid);
    }
    @Override
    public ObjectResponse cancelShipment(Data_Store ds) {
        String error="{\n\t\"errors\": [\n";
        int flag =0;
        if(Validator.missingValue(sub_id)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1033,\n";
            error+="\t\t\t\"message\": \"Subscriber ID must be provided\"\n\t\t}\n";
            flag = 1;
        }       
        if(Validator.missingValue(ship_id)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1044,\n";
            error+="\t\t\t\"message\": \"Shipment ID must be provided\"\n\t\t}\n";
            flag = 1;
        }
        if(flag == 1){
            error+="]\n}\n";
            return new ObjectResponse(-1, false,error);
        }
        
        int subid = Validator.isValidNumber(sub_id);
        int shipid = Validator.isValidNumber(ship_id);
        
        if(!Validator.isValidSubscriber(subid, ds.subs)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1013,\n";
            error+="\t\t\t\"message\": \"Invalid Subscriber ID\"\n\t\t}\n";
            flag = 1;
        }       
        if(!Validator.isValidShipment(shipid, ds.shipments)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1025,\n";
            error+="\t\t\t\"message\": \"Invalid Shipment ID\"\n\t\t}\n";
            flag = 1;
        }
        if(flag == 1){
            error+="]\n}\n";
            return new ObjectResponse(-1, false,error);
        }
        
        Iterator<Shipment> ship_it = ds.shipments.iterator();
        String output=null;
        while(ship_it.hasNext()){
            Shipment s= ship_it.next();
            if((s.isMatchID(shipid))&&(s.isMatchSubID(subid))){
                if(s.getStatus() == ShipmentStatus.UNDELIVERED){
                    s.setStatus(ShipmentStatus.CANCELLED);
                    s.setCancelDate(new Date());
                    output= "{\n\t\"uid\": "+subid+",\n";
                    output+="\t\"sid\": "+shipid+",\n";
                    output+= "\t\"status\": \""+ShipmentStatus.CANCELLED.name().toLowerCase()+"\"\n";
                    output+= "}\n";                    
                }
                else if(s.getStatus() == ShipmentStatus.DELIVERED)
                    return new ObjectResponse(1026,false,"Shipment already delivered cannot cancel");
                else
                    return new ObjectResponse(1027,false,"Shipment has already cancelled");
                break;
            }
        }
        return new ObjectResponse(shipid,true,output);        
    }
}
