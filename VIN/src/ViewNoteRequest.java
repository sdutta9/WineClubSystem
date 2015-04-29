
public abstract class ViewNoteRequest {
	String sub_id, ship_id, wine_id, note_id;

	public ViewNoteRequest(String subid,String shipid,String wineid, String nodeid) {
           sub_id = subid;
           ship_id = shipid;
           wine_id = wineid;
           note_id = nodeid;
	}
	
	public abstract ObjectResponse viewNote(Data_Store ds);
}
