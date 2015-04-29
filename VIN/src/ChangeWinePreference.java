
import java.util.Collection;
import java.util.Iterator;

public class ChangeWinePreference extends ChangeWinePreferenceRequest {
	
    public ChangeWinePreference(String id, String m) {
            super(id, m);
    }

    @Override
    public ObjectResponse changeWinePreference(Data_Store ds) {
        if(Validator.missingValue(sub_id))
            return new ObjectResponse(1033,false,"Subscriber ID must be provided");
        if(Validator.missingValue(this.mst))
            return new ObjectResponse(1018, false, "Type must be provided");
        if(!Validator.isValidMSType(this.mst))
            return new ObjectResponse(1019, false,"Type can be either RW, AW, AR.");
        
        int subid = Validator.isValidNumber(sub_id);
        
        Iterator<Subscriber> it = ds.subs.iterator();
        while (it.hasNext()) {
            Subscriber sub = it.next();
            if ((sub.getID() == subid) && (!sub.isDeactivated())){
                               
                sub.setPreference(MonthlySelectionType.valueOf(this.mst.toUpperCase()));
                String output="{\n\t\"uid\": "+subid+",\n";
                output+="\t\"type\": \""+sub.getPreference().name()+"\"\n}\n";
                return new ObjectResponse(sub.getID(), true,output);
            }   
        }
        return new ObjectResponse(1013,false,"Invalid Subscriber ID");
    }	
}
