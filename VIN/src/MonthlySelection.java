
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

public abstract class MonthlySelection implements java.io.Serializable {
    protected MonthlySelectionType mst;
    private YearMonth ym;
    private int ID, createdBy;
    private Date creationDate;
    
    protected List<Wine> ms = new ArrayList<Wine>();

    abstract void addWine(Wine w);

    public boolean isSameYearMonth(YearMonth yr){
        return ym.equals(yr);
    }
    public boolean isMatchMST(String ym, String mstype){
        if((isSameYearMonth(YearMonth.parse(ym)))&&(mst.name().equalsIgnoreCase(mstype)))
            return true;
        else
            return false;
    }

    public MonthlySelection() {
            this.ym = YearMonth.now().plusMonths(1);	// next month's selection
            this.ID = -1;
            this.creationDate = new Date();
            this.createdBy =-1;
            this.mst = null;
            this.ms = new ArrayList<>();
    }

    public MonthlySelection(String ym, int aid) {	// Must be in the yyyy-mm format
            this.ym = YearMonth.parse(ym);
            this.ID = IdGenerator.newID();
            this.creationDate = new Date();
            this.createdBy = aid;
            this.ms = new ArrayList<>();
    }
    public int getID() {
    	return this.ID;
    }
    public boolean hasWines(){
        Iterator<Wine> it= this.ms.iterator();
        return it.hasNext();
    }
    public List<Wine> getWines(){
        return this.ms;
    }

    public void setMst(MonthlySelectionType mst) {
        this.mst = mst;
    }
    
    public MonthlySelectionType getMST(){
        return this.mst;
    }
    public String getCreationDate(){
        String DATE_FORMAT = "yyyyMMdd";
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(creationDate);
    }
    public String getSelectionMonth(){
        String sm =ym.getMonth().name().substring(0, 3)+"/"+ym.getYear();
        return sm;
    }

    public int getCreatedBy() {
        return createdBy;
    }
}
