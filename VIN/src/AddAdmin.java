
import java.util.HashSet;
import java.util.Iterator;

public class AddAdmin extends AddAdminRequest {	
    public AddAdmin(String name) {
        super(name);
    }
    @Override
    public ObjectResponse addAdmin(Data_Store ds) {
        if(Validator.missingValue(this.name))
            return new ObjectResponse(1000, false,"Name must be provided");
        if(!Validator.isValidName(this.name))
            return new ObjectResponse(1001, false,"Bad name");
        
        if (userHasAccount(ds.adms, this.name)) {
            return new ObjectResponse(1017, false, "An admin with this name exists");
        } else {
            Admin a = new Admin(this.name);
            ds.adms.add(a);
            String output = "{\n\t\"aid\": "+a.getID()+"\n}";
            return new ObjectResponse(a.getID(), true, output);
        }
    }                

    private boolean userHasAccount(HashSet<Admin> admins, String name) {
        Iterator<Admin> it = admins.iterator();
        while (it.hasNext()) {
            Admin admin = it.next();
            if (admin.isMatch(name))
                return true;                    
        }
        return false;
    }
}
