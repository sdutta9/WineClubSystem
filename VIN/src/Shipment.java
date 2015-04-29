
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.YearMonth;

public class Shipment implements java.io.Serializable {
    private int ID;
    private int subID;
    private Date deliveryDate;
    private ShipmentStatus status;
    private int receiptID;
    private MonthlySelectionType mst;
    
    
    public Shipment() {
    	    	
    	this.ID = -1;
        this.subID =-1;
        this.deliveryDate = new Date();
        this.status = ShipmentStatus.UNDELIVERED;
        this.receiptID = -1;
        this.mst = MonthlySelectionType.RW;
    }
    public Shipment(int sid, Date deliDate, MonthlySelectionType mst) {
    	this.ID=IdGenerator.newID();
        this.subID = sid;
        this.deliveryDate = deliDate;
        this.status = ShipmentStatus.UNDELIVERED;
        this.receiptID = -1;
        this.mst = mst;
    }
    public YearMonth getDeliveryYearMonth(){
        String DATE_FORMAT = "yyyy-MM";
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT);
        YearMonth ym = YearMonth.parse(sdf.format(this.deliveryDate));
        return ym;
    }
    public String getDeliveryDate(){
        String DATE_FORMAT = "dd-MMM-yyyy";
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(deliveryDate);
    }
    public String getSelectionMonth(){
        String DATE_FORMAT = "MMM/yyyy";
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(deliveryDate);
    }
    public void setCancelDate(Date d){
        deliveryDate = d;
    }
    public int getShipID() {
    	return this.ID;
    }    
        
    public MonthlySelectionType getMST() {
    	return mst;
    }    
    public int getSubID(){
        return this.subID;
    }
    public ShipmentStatus getStatus(){
        return status;
    }
    public void setStatus(ShipmentStatus ss){
        this.status = ss;
    }
    public void setReceiptID(int receiptID){
        this.receiptID = receiptID;
    }
    private String getDow(){
        DateFormat ft=new SimpleDateFormat("EEEE"); 
        return ft.format(this.deliveryDate);
    }
    private String getTod(){
        if(Integer.parseInt(this.deliveryDate.toString().split(" ")[3].split(":")[0]) > 12){
            return "PM";
        }else
            return "AM";
    }
          
    public boolean isMatch(int sid, Date delDate) {
        return (isMatchSubID(sid) && this.deliveryDate.equals(delDate));
    }
    public boolean isMatchID(int shipID) {
        if(this.ID == shipID)
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
    public boolean isMatchReceiptID(int receiptID) {
        if(this.receiptID == receiptID)
            return true;
        else
            return false;
    }
}
