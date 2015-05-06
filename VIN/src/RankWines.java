
import java.util.Iterator;

public class RankWines extends RankWinesRequest {
    public RankWines(String sid,String wid, String rating) {
	super(sid,wid,rating);
    }
    @Override
    public ObjectResponse rankWine(Data_Store ds) {
        String error="{\n\t\"errors\": [\n";
        int flag =0;
        if(Validator.missingValue(subid)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1033,\n";
            error+="\t\t\t\"message\": \"Subscriber ID must be provided\"\n\t\t}\n";
            flag = 1;
        }
        if(Validator.missingValue(wid)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1031,\n";
            error+="\t\t\t\"message\": \"Wine ID must be provided\"\n\t\t}\n";
            flag = 1;
        }
        if(Validator.missingValue(rating)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1034,\n";
            error+="\t\t\t\"message\": \"Rating must be provided\"\n\t\t}\n";
            flag = 1;
        }
        if(flag == 1){
            error+="]\n}\n";
            return new ObjectResponse(-1, false,error);
        }
        
        int sid=Validator.isValidNumber(subid);
        if(!Validator.isValidSubscriber(sid, ds.subs)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1013,\n";
            error+="\t\t\t\"message\": \"Invalid Subscriber ID\"\n\t\t}\n";
            flag = 1;
        }                 
        int wineid =Validator.isValidNumber(wid);
        if(!Validator.isValidWine(wineid, ds.winelist)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1032,\n";
            error+="\t\t\t\"message\": \"Invalid Wine ID\"\n\t\t}\n";
            flag = 1;
        }        
        int rate=Validator.isValidNumber(rating);
        if((rate<1)||(rate>10)){
            error+="\t\t{\n";
            error+="\t\t\t\"code\": 1035,\n";
            error+="\t\t\t\"message\": \"Rating must be on a scale of 10 (excellent wine) to 1 (a tad above vinegar)\"\n\t\t}\n";
            flag = 1;
        }
        if(flag == 1){
            error+="]\n}\n";
            return new ObjectResponse(-1, false,error);
        }
        
        Iterator<Wine> it = ds.winelist.iterator();
        String result = "{\n";
        while (it.hasNext()) {
            Wine w = it.next();
            if (w.getID() == wineid){
                w.addRating(rate);
                result += "\t\"id\": " + w.getID() + ",\n";
                result += "\t\"rating_count\": " + w.getNumberOfRatings() + ",\n";
                result += "\t\"rating\": " + w.getRating()+ "\n}\n";               
            }   
        }
        return new ObjectResponse(wineid, true, result);
    }
}
