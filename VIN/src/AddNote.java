
import java.util.Iterator;

public class AddNote extends AddNoteRequest {
    
    public AddNote(String subid, String shipid, String wineid, String content) {
            super(subid,shipid,wineid,content);
    }

    @Override
    public ObjectResponse addNote(Data_Store ds) {
        String error="{\n\t\"errors\": [\n";
        int flag =0;
        if(Validator.missingValue(sub_id)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1033,\n";
            error+="\t\t\t\"message\": \"Subscriber ID must be provided\"\n\t\t}\n";
            flag = 1;
        }
        
        if(Validator.missingValue(ship_id)&& Validator.missingValue(wine_id)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1038,\n";
            error+="\t\t\t\"message\": \"Either ShipmentID or Wine ID must be provided\"\n\t\t}\n";
            flag = 1;
        }
        if(Validator.missingValue(content)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1041,\n";
            error+="\t\t\t\"message\": \"Note content must be provided\"\n\t\t}\n";
            flag = 1;
        }
        if(flag == 1){
            error+="]\n}\n";
            return new ObjectResponse(-1, false,error);
        }
        
        int subid = Validator.isValidNumber(sub_id);
        if(!Validator.isValidSubscriber(subid, ds.subs)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1013,\n";
            error+="\t\t\t\"message\": \"Invalid Subscriber ID\"\n\t\t}\n";
            flag = 1;
        }
        
        int shipid = Validator.isValidNumber(ship_id);
        int wineid = Validator.isValidNumber(wine_id);
        
        if((wineid == -1)&&(!Validator.isValidShipment(shipid, ds.shipments))){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1025,\n";
            error+="\t\t\t\"message\": \"Invalid Shipment ID\"\n\t\t}\n";
            flag = 1;
        }
        if((shipid == -1)&&(!Validator.isValidWine(wineid, ds.winelist))){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1032,\n";
            error+="\t\t\t\"message\": \"Invalid Wine ID\"\n\t\t}\n";
            flag = 1;
        }
        if(flag == 1){
            error+="]\n}\n";
            return new ObjectResponse(-1, false,error);
        }  
        
        if(shipid != -1){
            Note tempNote =new Note(subid,shipid,this.content);
            ds.notes.add(tempNote);
            String output = "{\n\t\"noteID\": "+tempNote.getNoteID()+"\n}\n";
            return new ObjectResponse(tempNote.getNoteID(), true, output);
        }
        else{
            Iterator<Wine> itw = ds.winelist.iterator();
            Wine wine = null;
            while(itw.hasNext()){
                wine = itw.next();
                if(wine.getID() == wineid)
                    break;
            }
            Note tempNote =new Note(subid,wineid, wine.getVariety(), this.content);
            ds.notes.add(tempNote);
            String output = "{\n\t\"noteID\": "+tempNote.getNoteID()+"\n}\n";
            return new ObjectResponse(tempNote.getNoteID(), true, output);
        }
    }        
}
