
public abstract class DeleteNoteRequest {
	String sub_id, note_id;

	public DeleteNoteRequest(String subid, String noteid) {
           sub_id = subid;
           note_id = noteid;
	}
	
	public abstract ObjectResponse deleteNote(Data_Store ds);
}
