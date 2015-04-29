
import java.util.HashSet;

// Boundary class for a request to remove a subscriber
public abstract class AddMonthlySelectionRequest {
    String a_id, mst, ym, filename;
    public AddMonthlySelectionRequest(String aid,String mstype, String yrmonth, String filename) {
        this.a_id =aid;
        this.mst = mstype;
        this.ym = yrmonth;
        this.filename = filename;
    }
    
    public abstract ObjectResponse addMonthlySelection(Data_Store ds);
}
