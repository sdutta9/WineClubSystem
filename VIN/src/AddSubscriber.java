
import java.util.HashSet;
import java.util.Iterator;

public class AddSubscriber extends AddSubscriberRequest {
    private Address a;
    private Subscriber s;

    public AddSubscriber(String street, String city, String state, String zip,
                    String name, String email, String phone, String tw, String fb) {
        super(street, city, state, zip, name, email, phone, tw, fb);
    }


    @Override
    public ObjectResponse addAccount(Data_Store ds) {
        String error="{\n\t\"errors\": [\n";
        int flag =0;
        if(Validator.missingValue(this.name)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1000,\n";
            error+="\t\t\t\"message\": \"Name must be provided\"\n\t\t}\n";
            flag = 1;
        }
        if(Validator.missingValue(this.email)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1002,\n";
            error+="\t\t\t\"message\": \"Email address must be provided\"\n\t\t}\n";
            flag = 1;
        }
        if(Validator.missingValue(this.street)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1004,\n";
            error+="\t\t\t\"message\": \"Address must be provided\"\n\t\t}\n";
            flag = 1;
        }        
        if(Validator.missingValue(this.city)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1006,\n";
            error+="\t\t\t\"message\": \"City must be provided\"\n\t\t}\n";
            flag = 1;
        } 
        if(Validator.missingValue(this.state)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1008,\n";
            error+="\t\t\t\"message\": \"State must be provided\"\n\t\t}\n";
            flag = 1;
        }
        if(Validator.missingValue(this.zip)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1010,\n";
            error+="\t\t\t\"message\": \"ZIP code must be provided\"\n\t\t}\n";
            flag = 1;
        }
        if(Validator.missingValue(this.phone)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1012,\n";
            error+="\t\t\t\"message\": \"Phone number must be provided\"\n\t\t}\n";
            flag = 1;
        }
        if(flag == 1){
            error+="]\n}\n";
            return new ObjectResponse(-1, false,error);
        }
        if(!Validator.isValidName(this.name)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1001,\n";
            error+="\t\t\t\"message\": \"Bad name\"\n\t\t}\n";
            flag = 1;
        }
        if(!Validator.isValidEmail(this.email)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1003,\n";
            error+="\t\t\t\"message\": \"Invalid email address\"\n\t\t}\n";
            flag = 1;
        }       
        if(!Validator.isValidAddress(this.street)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1005,\n";
            error+="\t\t\t\"message\": \"Bad address\"\n\t\t}\n";
            flag = 1;
        }        
        if(!Validator.isValidCity(this.city)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1007,\n";
            error+="\t\t\t\"message\": \"Bad city\"\n\t\t}\n";
            flag = 1;
        }
        if (Validator.addressInBannedState(this.state)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1009,\n";
            error+="\t\t\t\"message\": \"We may not ship to this state\"\n\t\t}\n";
            flag = 1;
        } 
        if(!Validator.isValidZip(this.zip)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1011,\n";
            error+="\t\t\t\"message\": \"Bad ZIP code\"\n\t\t}\n";
            flag = 1;
        }
        if(flag == 1){
            error+="]\n}\n";
            return new ObjectResponse(-1, false,error);
        }
        if (userHasAccount(ds.subs, this.email)) {
            return new ObjectResponse(1014, false, "An account with this email address exists");
        } else {
            a = new Address(this.street, this.city, this.state, this.zip);
            s = new Subscriber (this.name, this.email, this.phone, a, this.facebook, this.twitter);
            ds.subs.add(s);
            
            Iterator<MonthlySelection> it = ds.mselections.iterator();
            while(it.hasNext()){
                MonthlySelection ms = it.next();

                if(ms.isMatchMST(s.getDeliveryYearMonth().toString(), s.getPreference().name())){
                    Shipment shipment = new Shipment(s.getID(),s.getDeliveryDt(),s.getPreference());
                    ds.shipments.add(shipment);
                }
            }
            
            String output = "{\n\t\"uid\": "+s.getID()+"\n}";
            return new ObjectResponse(s.getID(), true, output);
        }
    }
    public boolean userHasAccount(HashSet<Subscriber> subs, String e) {
        Iterator<Subscriber> it = subs.iterator();
        while (it.hasNext()) {
            Subscriber sub = it.next();
            if (sub.isMatch(e)) 
                return true;                                    
        }
        return false;
    }
}
