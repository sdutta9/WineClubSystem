
import java.time.YearMonth;
import java.util.Iterator;

public class ViewUndeliveredList extends ViewUndeliveredListRequest {
    public ViewUndeliveredList() {
    }
    
    @Override
    public ObjectResponse viewUndeliveredList(Data_Store ds) {
        
        YearMonth currYM = YearMonth.now();
        
        Iterator<Shipment> ship_it = ds.shipments.iterator();
        Subscriber sub =null;
        String output ="{\n\t\"deliver_to\": [";
        while(ship_it.hasNext()){
            Shipment s= ship_it.next();
            if((s.getDeliveryYearMonth().equals(currYM)&&(s.getStatus()==ShipmentStatus.UNDELIVERED))){
                int subid = s.getSubID();
                Iterator<Subscriber> sub_it = ds.subs.iterator();
                while(sub_it.hasNext()){
                    sub = sub_it.next();
                    if(sub.getID() == subid){
                        Address addr=sub.getAddress();
                        output+="\t{\n";
                        output+="\t\t\"sid\": "+s.getShipID()+",\n";
                        output+="\t\t\"name\": \""+sub.getName()+"\",\n";
                        output+="\t\t\"phone\": \""+sub.getPhone()+"\",\n";
                        output+="\t\t\"email\": \""+sub.getEmail()+"\",\n";
                        output+="\t\t\"address\": {\n";
                        output+="\t\t\t\"street\": \""+addr.getStreet()+"\",\n";
                        output+="\t\t\t\"city\": \""+addr.getCity()+"\",\n";
                        output+="\t\t\t\"state\": \""+addr.getState()+"\",\n";
                        output+="\t\t\t\"zip\": \""+addr.getZip()+"\"\n\t\t},\n";
                        output+="\t\t\"dow\": \""+sub.getDow().substring(0, 3)+"\",\n";
                        output+="\t\t\"tod\": \""+sub.getTod()+"\",\n";
                        output+="\t\t\"type\": \""+sub.getPreference().name()+"\"\n\t}\n";
                        break;
                    }
                } //end of inner while               
            }
        }//end of outer while
        output+="\t]\n}\n";
        if(sub == null)
           return new ObjectResponse(1030, false, "No Shipment remaining to be delivered");
        else
            return new ObjectResponse(sub.getID(), true, output);
    }
}
