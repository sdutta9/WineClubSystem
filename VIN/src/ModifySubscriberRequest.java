
public abstract class ModifySubscriberRequest {
    
    String sub_id,name, email, phone, twitter, facebook;

    public ModifySubscriberRequest(String id, String n, String e, String p, String tw, String fb) {
        this.sub_id = id;    
        this.name = n;
        this.email = e;
        this.phone = p;
        this.twitter = tw;
        this.facebook = fb;
    }

    public abstract ObjectResponse modifyAccount(Data_Store ds);
}
