
public abstract class ViewSubscriberRequest {
    String sub_id;

    public ViewSubscriberRequest(String id) {
        this.sub_id = id;    
    }

    public abstract ObjectResponse viewAccount(Data_Store ds);
}
