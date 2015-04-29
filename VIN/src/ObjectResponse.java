
public class ObjectResponse {
	private int ID;
	private boolean status;
	private String description;
	
	public ObjectResponse(int id, boolean s, String f) {
		this.ID = id;
		this.status = s;
		this.description = f;
	}
	
	public void printResponse() {
            if(status)
                System.out.print("\n"+this.description);
            else{
                if(this.ID == -1)
                    System.out.print("\n"+this.description); 
                else{
                    String error="{\n\t\"errors\": [\n";
                    error+="\t\t{\n";
                    error+="\t\t\t\"code\":"+this.ID+",\n";
                    error+="\t\t\t\"message\": \""+this.description+"\"\n";
                    error+= "\t\t}\n";
                }
            }
	}
        public boolean getStatus(){
            return status;
        }
}
