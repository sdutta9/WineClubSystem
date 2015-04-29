

import java.util.HashSet;
import java.util.Iterator;

public class ViewAdmin extends ViewAdminRequest {
    public ViewAdmin(String id) {
	super(id);
    }
    @Override
    public ObjectResponse viewAdmin(Data_Store ds) {
        if(Validator.missingValue(a_id))
            return new ObjectResponse(1043,false,"Admin ID must be provided");
        
        int admid = Validator.isValidNumber(a_id);
        
        Iterator<Admin> it = ds.adms.iterator();
        while (it.hasNext()) {
            Admin adm = it.next();
            if (adm.getID() == admid){
                String result = "{\n";
                result += "\t\"id\": " + adm.getID() + ",\n";
                result += "\t\"name\": \"" + adm.getName() + "\",\n";
                result += "\t\"create_date\": \"" + adm.getCreateDate() + "\"\n";
                result += "}\n";
                
                return new ObjectResponse(adm.getID(), true, result);
            }   
        }
        return new ObjectResponse(1023,false,"Invalid Admin ID");
    }
}
