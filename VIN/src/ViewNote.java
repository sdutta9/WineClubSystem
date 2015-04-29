
import java.util.Iterator;

public class ViewNote extends ViewNoteRequest {

    public ViewNote(String subid, String shipid, String wineid, String noteid) {
        super(subid, shipid, wineid, noteid);
    }

    @Override
    public ObjectResponse viewNote(Data_Store ds) {
        if (Validator.missingValue(sub_id)) {
            return new ObjectResponse(1033, false, "Subscriber ID must be provided");
        }

        int subid = Validator.isValidNumber(sub_id);

        if (!Validator.isValidSubscriber(subid, ds.subs)) {
            return new ObjectResponse(1013, false, "Invalid Subscriber ID");
        }

        if (Validator.missingValue(ship_id) && Validator.missingValue(wine_id) && Validator.missingValue(note_id)) {
            //logic to show all notes for the subId
            Iterator<Note> it = ds.notes.iterator();
            int flag = 0;
            String output = "{\n\t\"notes\": [";
            while (it.hasNext()) {
                Note note = it.next();
                if (note.getSubID() == subid) {
                    output += "\n\t\t{";
                    output += "\n\t\t\t\"id\": " + note.getNoteID() + ",";
                    if (note.getShipID() != -1) {
                        output += "\n\t\t\t\"sid\": " + note.getShipID() + ",";
                    } else {
                        output += "\n\t\t\t\"wid\": " + note.getWineID() + ",";
                        output += "\n\t\t\t\"wineVareity\": \"" + note.getWineVariety().name() + "\",";
                    }
                    output += "\n\t\t\t\"date\": \"" + note.getCreationDate() + "\",";
                    output += "\n\t\t\t\"content\": \"" + note.getContent() + "\"";
                    output += "\n\t\t}";
                    flag = 1;
                }
            }
            if (flag == 0) {
                output += "]\n}\n";
            } else {
                output += "\n\t]\n}\n";
            }
            return new ObjectResponse(subid, true, output);
        } else {
            int shipid = Validator.isValidNumber(ship_id);
            int wineid = Validator.isValidNumber(wine_id);
            int noteid = Validator.isValidNumber(note_id);

            if ((wineid == -1) && (noteid == 1) && (!Validator.isValidShipment(shipid, ds.shipments))) {
                return new ObjectResponse(1025, false, "Invalid Shipment ID");
            }
            if ((shipid == -1) && (noteid == 1) && (!Validator.isValidWine(wineid, ds.winelist))) {
                return new ObjectResponse(1032, false, "Invalid Wine ID");
            }
            if ((shipid == -1) && (wineid == 1) && (!Validator.isValidNote(noteid, ds.notes))) {
                return new ObjectResponse(1040, false, "Invalid Note ID");
            }

            if ((shipid != -1) && (wineid == -1) && (noteid == -1)) {
                //logic for displaying user's all shipment related notes
                Iterator<Note> it = ds.notes.iterator();
                int flag = 0;
                String output = "{\n\t\"notes\": [";
                while (it.hasNext()) {
                    Note note = it.next();
                    if ((note.getSubID() == subid) && (note.getShipID() == shipid)) {
                        output += "\n\t\t{";
                        output += "\n\t\t\t\"id\": " + note.getNoteID() + ",";
                        output += "\n\t\t\t\"date\": \"" + note.getCreationDate() + "\",";
                        output += "\n\t\t\t\"content\": \"" + note.getContent() + "\"";
                        output += "\n\t\t}";
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    output += "]\n}\n";
                } else {
                    output += "\n\t]\n}\n";
                }
                return new ObjectResponse(shipid, true, output);
            } else if ((shipid == -1) && (wineid != -1) && (noteid == -1)) {
                //logic for displaying user's all wine related notes
                Iterator<Note> it = ds.notes.iterator();
                int flag = 0;
                String output = "{\n\t\"notes\": [";
                while (it.hasNext()) {
                    Note note = it.next();
                    if ((note.getSubID() == subid) && (note.getWineID() == wineid)) {
                        output += "\n\t\t{";
                        output += "\n\t\t\t\"id\": " + note.getNoteID() + ",";
                        output += "\n\t\t\t\"variety\": \"" + note.getWineVariety().name() + "\",";
                        output += "\n\t\t\t\"date\": \"" + note.getCreationDate() + "\",";
                        output += "\n\t\t\t\"content\": \"" + note.getContent() + "\"";
                        output += "\n\t\t}";
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    output += "]\n}\n";
                } else {
                    output += "\n\t]\n}\n";
                }
                return new ObjectResponse(shipid, true, output);
            } else if ((shipid == -1) && (wineid == -1) && (noteid != -1)) {
                //logic for displaying user's note based on note number.
                Iterator<Note> it = ds.notes.iterator();
                int flag = 0;
                String output = "{";
                while (it.hasNext()) {
                    Note note = it.next();
                    if ((note.getSubID() == subid) && (note.getNoteID() == noteid)) {
                        output += "\n\t\"id\": " + note.getNoteID() + ",";
                        if (note.getShipID() != -1) {
                            output += "\n\t\"sid\": " + note.getShipID() + ",";
                        } else {
                            output += "\n\t\"wid\": " + note.getWineID() + ",";
                            output += "\n\t\"variety\": \"" + note.getWineVariety().name() + "\",";
                        }
                        output += "\n\t\"date\": \"" + note.getCreationDate() + "\",";
                        output += "\n\t\"content\": \"" + note.getContent() + "\"";
                        output += "\n}\n";
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    return new ObjectResponse(1040, false, "Invalid Note ID");
                } else {
                    return new ObjectResponse(noteid, true, output);
                }
            } else {
                return new ObjectResponse(1038, false, "Either Shipment ID, Wine ID or Note ID should be provided");
            }
        }
    }
}
