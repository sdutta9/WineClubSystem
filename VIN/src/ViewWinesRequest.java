
public abstract class ViewWinesRequest {
    String wid;

    public ViewWinesRequest(String id) {
        this.wid = id;    
    }

    public abstract ObjectResponse viewWine(Data_Store ds);
}
