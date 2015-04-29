
public abstract class ModifyNoteRequest {
	String sub_id, note_id, content;

	public ModifyNoteRequest(String subid, String noteid,String note) {
           sub_id = subid;
           note_id = noteid;
           content = note;
	}
	
	public abstract ObjectResponse modifyNote(Data_Store ds);
}
