
public abstract class LoadSubscriberRequest {
    String filename;

    public LoadSubscriberRequest(String filename) {
        this.filename = filename;    
    }

    public abstract ObjectResponse loadAccount(Data_Store ds);
}
