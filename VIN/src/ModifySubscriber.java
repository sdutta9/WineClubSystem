
import java.util.Iterator;

public class ModifySubscriber extends ModifySubscriberRequest {
    public ModifySubscriber(String id,String name, String email, String phone, String tw, String fb) {
	super(id, name, email, phone, tw, fb);
    }
    @Override
    public ObjectResponse modifyAccount(Data_Store ds) {
        if(Validator.missingValue(sub_id))
            return new ObjectResponse(1033,false,"Subscriber ID must be provided");
        
        int subid =Validator.isValidNumber(sub_id);
        
        Iterator<Subscriber> it = ds.subs.iterator();
        while (it.hasNext()) {
            Subscriber sub = it.next();
            if ((sub.getID() == subid)&& (!sub.isDeactivated())){
                String error="{\n\t\"errors\": [\n";
                int flag =0;
                if((!Validator.missingValue(this.name))&&(!Validator.isValidName(this.name))){
                    error+="\t\t{\n";
                    error+="\t\t\t\"code\": 1001,\n";
                    error+="\t\t\t\"message\": \"Bad name\"\n\t\t}\n";
                    flag = 1;
                }
                if((!Validator.missingValue(this.email))&&(!Validator.isValidEmail(this.email))){
                    error+="\t\t{\n";
                    error+="\t\t\t\"code\": 1003,\n";
                    error+="\t\t\t\"message\": \"Invalid email address\"\n\t\t}\n";
                    flag = 1;
                }       
                if(flag == 1){
                    error+="]\n}\n";
                    return new ObjectResponse(-1, false,error);
                }
                        
                sub.updateInfo(name, email, phone, facebook, twitter);
                String output = "{\n\t\"uid\": "+sub.getID()+",\n";
                output+= "\t\"msg\": \"User details has been modified\"\n}\n";
                return new ObjectResponse(sub.getID(), true, output);
            }   
        }
        return new ObjectResponse(1013,false,"Invalid Subscriber ID");
    }
}
