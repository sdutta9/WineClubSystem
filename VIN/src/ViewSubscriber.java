
import java.util.Iterator;

public class ViewSubscriber extends ViewSubscriberRequest {
    public ViewSubscriber(String id) {
	super(id);
    }
    @Override
    public ObjectResponse viewAccount(Data_Store ds) {
        if(Validator.missingValue(sub_id))
            return new ObjectResponse(1033,false,"Subscriber ID must be provided");
        
        int subid =Validator.isValidNumber(sub_id);
        
        Iterator<Subscriber> it = ds.subs.iterator();
        while (it.hasNext()) {
            Subscriber sub = it.next();
            if ((sub.getID() == subid)&& (!sub.isDeactivated())){
                Address a=sub.getAddress();
                String result = "{\n";
                result += "\t\"id\": " + sub.getID() + ",\n";
                result += "\t\"date_created\": \"" + sub.getJoinDate() + "\",\n";
                result += "\t\"type\": \"" + sub.getPreference().name() + "\",\n";
                result += "\t\"dow\": \"" + sub.getDow() + "\",\n";
                result += "\t\"tod\": \"" + sub.getTod() + "\",\n";
                result += "\t\"name\": \"" + sub.getName() + "\",\n";
                result += "\t\"email\": \"" + sub.getEmail() + "\",\n";
                result += "\t\"phone\": \"" + sub.getPhone() + "\",\n";
                result += "\t\"address\": {\n";
                result += "\t\t\"street\": \"" + a.getStreet() + "\",\n";
                result += "\t\t\"city\": \"" + a.getCity() + "\",\n";
                result += "\t\t\"state\": \"" + a.getState()+ "\",\n";
                result += "\t\t\"zip\": \"" + a.getZip() + "\",\n\t},\n";
                result += "\t\"facebook\": \"" + sub.getFacebook() + "\",\n";
                result += "\t\"twitter\": \"" + sub.getTwitter()+ "\"\n}\n";
                
                return new ObjectResponse(sub.getID(), true, result);
            }   
        }
        return new ObjectResponse(1013,false,"Invalid Subscriber ID");
    }
}
