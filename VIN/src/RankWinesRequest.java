
public abstract class RankWinesRequest {
    String subid,wid,rating;

    public RankWinesRequest(String subid,String wid, String rating) {
        this.subid = subid;
        this.wid = wid;    
        this.rating = rating;
    }

    public abstract ObjectResponse rankWine(Data_Store ds);
}
