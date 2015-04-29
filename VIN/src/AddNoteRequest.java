
public abstract class AddNoteRequest {
	String sub_id, ship_id, wine_id, content;

	public AddNoteRequest(String subid,String shipid,String wineid, String note) {
           sub_id = subid;
           ship_id = shipid;
           wine_id = wineid;
           content = note;
	}
	
	public abstract ObjectResponse addNote(Data_Store ds);
}
