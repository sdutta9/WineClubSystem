
import java.util.Date;
import java.text.SimpleDateFormat;

public class Note implements java.io.Serializable {
    private int ID;
    private Date creationDate;
    private int subID;
    private int shipID;
    private int wineID;
    private WineVariety winetype;
    private String content;
        
    public Note(){	    	
    	ID = -1;
        creationDate = new Date();
        subID =-1;
        shipID = -1;
        wineID = -1;
        winetype = null;
        content ="";
    }
    public Note(int subid, int ship_ID, String note) {
    	this.ID=IdGenerator.newID();
        creationDate = new Date();
        subID = subid;
        shipID = ship_ID;
        wineID = -1;
        winetype = null;
        content = note;
    }
    public Note(int subid, int wine_ID, WineVariety wv, String note) {
    	this.ID=IdGenerator.newID();
        creationDate = new Date();
        subID = subid;
        shipID = -1;
        wineID = wine_ID;
        winetype = wv;
        content = note;
    }
    
    public String getCreationDate(){
        String DATE_FORMAT = "dd-MMM-yyyy";
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(creationDate);
    }
    
    public int getNoteID() {
    	return this.ID;
    }         
    public int getSubID(){
        return this.subID;
    }   

    public int getShipID() {
        return shipID;
    }

    public int getWineID() {
        return wineID;
    }

    public WineVariety getWineVariety() {
        return winetype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public boolean isMatchWineType(int subID,WineVariety wt){
        if(isMatchSubID(subID)&& (winetype.equals(wt)))
            return true;
        else
            return false;
    }
    public boolean isMatchID(int noteID) {
        if(this.ID == noteID)
            return true;
        else
            return false;
    }
    public boolean isMatchSubID(int subID) {
        if(this.subID == subID)
            return true;
        else
            return false;
    }   
}
