
import java.time.YearMonth;
import java.util.Iterator;
import java.util.List;

public class ViewShipment extends ViewShipmentRequest {
    public ViewShipment(String sid,String shipid) {
	super(sid,shipid);
    }
    @Override
    public ObjectResponse viewShipment(Data_Store ds){
        if(Validator.missingValue(sub_id))
            return new ObjectResponse(1033,false,"Subscriber ID must be provided");
        
        int subid = Validator.isValidNumber(sub_id);
        int shipid = Validator.isValidNumber(ship_id);
        
        if(!Validator.isValidSubscriber(subid, ds.subs))
            return new ObjectResponse(1013,false,"Invalid Subscriber ID");
        if(shipid == -1){
            Iterator<Shipment> ship_it = ds.shipments.iterator();
            String output = "{\n\t\"uid\": "+subid+",\n\t\"shipments\": [\n";
            while(ship_it.hasNext()){
                Shipment s= ship_it.next();
                if(s.isMatchSubID(subid)){
                    YearMonth ym = s.getDeliveryYearMonth();
                    output += "\t\t{\n";
                    output += "\t\t\t\"sid\": "+s.getShipID()+",\n";
                    output += "\t\t\t\"selection_month\": \""+ym.getMonth().name().substring(0, 3)+"/"+ym.getYear()+"\",\n";
                    output += "\t\t\t\"status\": \""+s.getStatus().name().toLowerCase()+"\"\n";
                    output += "\t\t}\n";
                }
            }
            output+="\t]\n}\n";
            return new ObjectResponse(subid, true, output);
        }
        else{
            Iterator<Shipment> ship_it = ds.shipments.iterator();
            YearMonth ym=null;
            MonthlySelectionType mst=null;
            Shipment s=null;
            while(ship_it.hasNext()){
                s= ship_it.next();
                if(s.isMatchSubID(subid)){
                    ym = s.getDeliveryYearMonth();
                    mst= s.getMST();
                    break;
                }
            }
            if(s == null)
               return new ObjectResponse(1025, false, "Invalid Shipment ID");
            else{
                String output = "{\n\t\"uid\": "+subid+",\n";
                output+="\t\"sid\": "+shipid+",\n";
                output += "\t\"selection_month\": \""+ym.getMonth().name().substring(0, 3)+"/"+ym.getYear()+"\",\n";
                output += "\t\"status\": \""+s.getStatus().name().toLowerCase()+"\"\n";
                output +="\t\"date\": \""+s.getDeliveryDate()+"\",\n";
                output +="\t\"type\": \""+mst.name()+"\",\n";
                output +="\t\"wines\": [";
                Iterator<MonthlySelection> it = ds.mselections.iterator();
                List<Wine> wines = null;
                while(it.hasNext()){
                    MonthlySelection ms =it.next();
                    if(ms.isSameYearMonth(ym)&& mst.equals(ms.getMST())){
                        wines = ms.getWines();
                        break;
                    }
                }
                if(wines != null){
                    Iterator<Wine> it_w = wines.iterator();
                    while(it_w.hasNext()){
                        Wine w = it_w.next();
                        output += "\n\t\t{\n";
                        output += "\t\t\t\"id\": " + w.getID() + ",\n";
                        output += "\t\t\t\"label_name\": \"" + w.getLabelName() + "\",\n";
                        output +="\t\t}\n";
                    }
                    output+="\t]\n}\n";
                }
                else
                    output+="]\n}\n";
                return new ObjectResponse(subid, true, output);
            }
        }
    }
}
