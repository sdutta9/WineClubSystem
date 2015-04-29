
import java.util.Date;
import java.text.SimpleDateFormat;

public class Receipt implements java.io.Serializable {
    private int ID;
    private Date creationDate;
    private int subID;
    private String sub_name;
    private String receivedBy;
        
    public Receipt() {
    	    	
    	this.ID = -1;
        this.subID =-1;
        this.creationDate = new Date();
        this.sub_name = null;
        this.receivedBy = null;
    }
    public Receipt(int subid, String subName, String receiverName) {
    	this.ID=IdGenerator.newID();
        this.subID = subid;
        this.creationDate = new Date();
        this.sub_name = subName;
        this.receivedBy = receiverName;
    }
    public String getCreationDate(){
        String DATE_FORMAT = "yyyyMMdd";
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(creationDate);
    }
    public String getCreationTime(){
        String DATE_FORMAT = "hh:mm a";
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(creationDate);
    }

    public Date getDate() {
        return creationDate;
    }
    
    public int getReceiptID() {
    	return this.ID;
    }         
    public int getSubID(){
        return this.subID;
    }   
    public String getSubName(){
        return this.sub_name;
    } 
    public String getReceiverName(){
        return this.receivedBy;
    }
    public boolean isMatch(int sid, Date createDate) {
        return (isMatchSubID(sid) && this.creationDate.equals(createDate));
    }
    public boolean isMatchID(int receiptID) {
        if(this.ID == receiptID)
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
