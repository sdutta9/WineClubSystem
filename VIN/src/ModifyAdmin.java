
import java.util.Iterator;

public class ModifyAdmin extends ModifyAdminRequest {
    public ModifyAdmin(String id,String name) {
	super(id, name);
    }
    @Override
    public ObjectResponse modifyAdmin(Data_Store ds) {
        if(Validator.missingValue(a_id))
            return new ObjectResponse(1043,false,"Admin ID must be provided");
        
        int aid = Validator.isValidNumber(a_id);
        Iterator<Admin> it = ds.adms.iterator();
        while (it.hasNext()) {
            Admin adm = it.next();
            if (adm.getID() == aid){
                if((!Validator.missingValue(this.name)) && (!Validator.isValidName(this.name)))
                    return new ObjectResponse(1001, false,"Bad name");
                                
                adm.updateInfo(name);
                String output = "{\n\t\"aid\": "+adm.getID()+",\n";
                output+= "\t\"msg\": \"Admin details has been modified\"\n}\n";
                return new ObjectResponse(adm.getID(), true, output);
            }   
        }
        return new ObjectResponse(1023, false,"Invalid Admin ID");
    }
}
