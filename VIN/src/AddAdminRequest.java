
public abstract class AddAdminRequest {
	String name;
	
	public AddAdminRequest(String n) {
		this.name = n;
	}
	
	public abstract ObjectResponse addAdmin(Data_Store ds);
}
