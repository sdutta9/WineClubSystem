
public abstract class ModifyAdminRequest {
    String a_id,name;

    public ModifyAdminRequest(String id, String n) {
        this.a_id = id;    
        this.name = n;
    }
    
    public abstract ObjectResponse modifyAdmin(Data_Store ds);
}
