
import java.util.Iterator;

public class ViewWines extends ViewWinesRequest {
    public ViewWines(String id) {
	super(id);
    }
    @Override
    public ObjectResponse viewWine(Data_Store ds) {
        if(Validator.missingValue(wid))
            return new ObjectResponse(1031, false, "Wine ID must be provided");
        int wineid =Validator.isValidNumber(wid);
        if(wineid == -1)
            return new ObjectResponse(1032,false, "Invalid Wine ID");
        
        Iterator<Wine> it = ds.winelist.iterator();
        while (it.hasNext()) {
            Wine w = it.next();
            if (w.getID() == wineid){
                String result = "{\n";
                result += "\t\"id\": " + w.getID() + ",\n";
                result += "\t\"variety\": \"" + w.getVariety().name() + "\",\n";
                result += "\t\"wine_type\": \"" + w.getType().name() + "\",\n";
                result += "\t\"label_name\": \"" + w.getLabelName() + "\",\n";
                result += "\t\"grape\": \"" + w.getGrape() + "\",\n";
                result += "\t\"region\": \"" + w.getRegion() + "\",\n";
                result += "\t\"country\": \"" + w.getCountry() + "\",\n";
                result += "\t\"maker\": \"" + w.getMaker() + "\",\n";
                result += "\t\"year\": \"" + w.getYear() + "\",\n";
                result += "\t\"rating_count\": " + w.getNumberOfRatings() + ",\n";
                result += "\t\"rating\": " + w.getRating()+ "\n}\n";
                
                return new ObjectResponse(wineid, true, result);
            }   
        }
        return new ObjectResponse(1032,false, "Invalid Wine ID");
    }
}
