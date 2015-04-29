
public abstract class ViewDeliveryTimeRequest {
    String sub_id;

    public ViewDeliveryTimeRequest(String id) {
        this.sub_id = id;    
    }

    public abstract ObjectResponse viewDeliveryTime(Data_Store ds);
}
