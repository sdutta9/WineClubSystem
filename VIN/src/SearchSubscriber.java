
import java.time.YearMonth;
import java.util.HashSet;
import java.util.Iterator;

public class SearchSubscriber extends SearchSubscriberRequest {
    public SearchSubscriber(String id, String query) {
	super(id,query);
    }
    @Override
    public ObjectResponse searchAccount(Data_Store ds) {
        if(Validator.missingValue(sub_id))
            return new ObjectResponse(1033,false,"Subscriber ID must be provided");
        
        int subid =Validator.isValidNumber(sub_id);
        if(!Validator.isValidSubscriber(subid, ds.subs))
            return new ObjectResponse(1013,false,"Invalid Subscriber ID");
        String shipstr = "\t\"shipments\": [";
        String notestr = "\t\"notes\": [";
        String winestr = "\t\"wines\": [";
        HashSet<Wine> userWines = new HashSet<>();
        
        if(Validator.missingValue(query)){
            Shipment s =null;
            Iterator<Shipment> it_ship =ds.shipments.iterator();
            while(it_ship.hasNext()){
                s = it_ship.next();
                if(s.getSubID()==subid){
                    shipstr+="\n\t\t{";
                    shipstr+="\n\t\t\t\"id\": "+s.getShipID()+",";
                    shipstr+="\n\t\t\t\"selection_month\": \""+s.getSelectionMonth()+"\",";
                    shipstr+="\n\t\t\t\"status\": \""+s.getStatus().name()+"\"";
                    shipstr+="\n\t\t}";
                    if(s.getStatus() == ShipmentStatus.CANCELLED)
                        continue;
                    
                    YearMonth ym = s.getDeliveryYearMonth();
                    Iterator<MonthlySelection> it_ms= ds.mselections.iterator();
                    while(it_ms.hasNext()){
                        MonthlySelection ms = it_ms.next();
                        if(ms.isSameYearMonth(ym)&&ms.getMST().equals(s.getMST())){
                            
                            Iterator<Wine> it_wines = ms.getWines().iterator();
                            while(it_wines.hasNext()){
                                Wine w = it_wines.next();
                                if(!userWines.contains(w))
                                    userWines.add(w);
                            }
                            break;
                        }
                    }//end of ms while                    
                }//end of if
            }//end of shipment while
            if(s == null)
                shipstr+="]\n";
            else
                shipstr+="\n\t]\n";
            
            Iterator<Wine> it_userW =userWines.iterator();
            Wine w =null;
            while(it_userW.hasNext()){
                w=it_userW.next();
                winestr+="\n\t\t{";
                winestr+="\n\t\t\t\"id\": "+w.getID()+",";
                winestr+="\n\t\t\t\"label_name\": "+w.getLabelName()+"";
                winestr+="\n\t\t}";
            }
            if(w == null)
                winestr+="],\n";
            else
                winestr+="\n\t],\n";
            
            Iterator<Note> it_note = ds.notes.iterator();
            Note n = null;
            while(it_note.hasNext()){
                n = it_note.next();
                notestr+="\n\t\t{";
                notestr+="\n\t\t\t\"id\": "+n.getNoteID()+",";
                notestr+="\n\t\t\t\"content\": "+n.getContent()+"";
                notestr+="\n\t\t}";
            }
            if(n == null)
                notestr+="],\n";
            else
                notestr+="\n\t],\n";
            
            String output = "{\n"+winestr+notestr+shipstr+"}\n";
            return new ObjectResponse(subid, true, output);
            
        }//end of if where query string is missing
        else{
            return new ObjectResponse(subid, true, "{\n\t"+query+"\n}\n");
        }
    }
}
