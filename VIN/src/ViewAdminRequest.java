
public abstract class ViewAdminRequest {
    String a_id;

    public ViewAdminRequest(String id) {
        this.a_id = id;    
    }

    public abstract ObjectResponse viewAdmin(Data_Store ds);
}
