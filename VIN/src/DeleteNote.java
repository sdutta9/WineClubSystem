
import java.util.Iterator;

public class DeleteNote extends DeleteNoteRequest {
    
    public DeleteNote(String subid, String noteid) {
            super(subid,noteid);
    }

    @Override
    public ObjectResponse deleteNote(Data_Store ds) {
        String error="{\n\t\"errors\": [\n";
        int flag =0;
        if(Validator.missingValue(sub_id)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1033,\n";
            error+="\t\t\t\"message\": \"Subscriber ID must be provided\"\n\t\t}\n";
            flag = 1;
        }
        if(Validator.missingValue(note_id)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1039,\n";
            error+="\t\t\t\"message\": \"Note ID must be provided\"\n\t\t}\n";
            flag = 1;
        }
        if(flag == 1){
            error+="]\n}\n";
            return new ObjectResponse(-1, false,error);
        }
        
        int subid = Validator.isValidNumber(sub_id);
        int noteid = Validator.isValidNumber(note_id);
        
        if(!Validator.isValidSubscriber(subid, ds.subs)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1013,\n";
            error+="\t\t\t\"message\": \"Invalid Subscriber ID\"\n\t\t}\n";
            flag = 1;
        }
        if(!Validator.isValidNote(noteid, ds.notes)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1040,\n";
            error+="\t\t\t\"message\": \"Invalid Note ID\"\n\t\t}\n";
            flag = 1;
        }
        if(flag == 1){
            error+="]\n}\n";
            return new ObjectResponse(-1, false,error);
        }
        
        Iterator<Note> it = ds.notes.iterator();
        Note note = null;
        while(it.hasNext()){
            note = it.next();
            if(note.getNoteID() == noteid){
                break;
            }
        }
        ds.notes.remove(note);
        String output = "{\n\t\"noteID\": "+note.getNoteID()+",\n";
        output+="\t\"msg\": Note Deleted.\n}\n";
        
        return new ObjectResponse(note.getNoteID(), true, output);
    }        
}
