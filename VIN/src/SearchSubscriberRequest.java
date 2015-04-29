
public abstract class SearchSubscriberRequest {
    String sub_id,query;

    public SearchSubscriberRequest(String id, String query) {
        this.sub_id = id;    
        this.query = query;
    }

    public abstract ObjectResponse searchAccount(Data_Store ds);
}
