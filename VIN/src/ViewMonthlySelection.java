
import java.time.YearMonth;
import java.util.HashSet;
import java.util.Iterator;

public class ViewMonthlySelection extends ViewMonthlySelectionRequest {
    public ViewMonthlySelection(String mid) {
	super(mid);
    }
    @Override
    public ObjectResponse viewMonthlySelection(Data_Store ds) {
        
        int msid =Validator.isValidNumber(m_id);
        
        if(msid!= -1){
            Iterator<MonthlySelection> it = ds.mselections.iterator();
            while (it.hasNext()) {
                MonthlySelection ms = it.next();
                if (ms.getID()== msid){
                    String result = "{\n";
                    result += "\t\"id\": " + ms.getID() + ",\n";
                    result += "\t\"selection_month\": \"" + ms.getSelectionMonth()+ "\",\n";
                    result += "\t\"type\": \"" + ms.getMST().name() + "\",\n";
                    result += "\t\"create_date\": \"" + ms.getCreationDate() + "\",\n";
                    result += "\t\"created_by\": \"" + ms.getCreatedBy() + "\",\n";
                    result += "\t\"wines\": [\n";
                    Iterator<Wine> it_w = ms.getWines().iterator();
                    while (it_w.hasNext()) {
                        Wine wn = it_w.next();
                        result += "\t\t{\n";
                        result += "\t\t\t\"id\": " + wn.getID() + ",\n";
                        result += "\t\t\t\"label_name\": \"" + wn.getLabelName() + "\",\n";
                        result +="\t\t}\n";
                    }
                    result += "\t]\n}\n"; 
//                    
                    return new ObjectResponse(ms.getID(), true, result);
                }   
            }
            return new ObjectResponse(1024,false,"Invalid MonthlySelection ID");
        }
        else{  
            Iterator<MonthlySelection> it = ds.mselections.iterator();
            String result = "{\n\t\"monthly_selection\": [\n";
            MonthlySelection ms=null;
            while (it.hasNext()){
                 ms = it.next();
                result += "\t\t{\n";
                result += "\t\t\t\"id\": " + ms.getID() + ",\n";
                result += "\t\t\t\"selection_month\": \"" + ms.getSelectionMonth()+ "\",\n";
                result += "\t\t\t\"type\": \"" + ms.getMST().name() + "\"\n";
                result += "\t\t}\n";
            }
            result+="\t]\n}\n";
            return new ObjectResponse(ms.getID(), true, result);
        }
        
    }
}
