
import java.util.Iterator;

public class ViewDeliveryTime extends ViewDeliveryTimeRequest {
    public ViewDeliveryTime(String id) {
	super(id);
    }
    @Override
    public ObjectResponse viewDeliveryTime(Data_Store ds) {
        if(Validator.missingValue(sub_id))
            return new ObjectResponse(1033,false,"Subscriber ID must be provided");
        
        int subid =Validator.isValidNumber(sub_id);
        
        Iterator<Subscriber> it = ds.subs.iterator();
        while (it.hasNext()) {
            Subscriber sub = it.next();
            if ((sub.getID() == subid)&& (!sub.isDeactivated())){
                
                String result = "{\n";
                result += "\t\"dow\": \"" + sub.getDow().substring(0,3) + "\",\n";
                result += "\t\"tod\": \"" + sub.getTod() + "\"\n";
                result += "}\n";
                
                return new ObjectResponse(sub.getID(), true, result);
            }   
        }
        return new ObjectResponse(1013,false,"Invalid Subscriber ID");
    }
}
