
import java.time.Year;
import org.junit.Test;
import static org.junit.Assert.*;

public class RankWinesTest {
    
    public RankWinesTest() {
    }
    @Test
    public void testRankWine() {
        System.out.println("rankWine_allParameters null");
        Data_Store ds = new Data_Store();
        RankWines instance = new RankWines(null, null, null);
        boolean expResult = false;
        ObjectResponse result = instance.rankWine(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testRankWine2() {
        System.out.println("rankWine_allParameters invalid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Wine w =new Wine(WineVariety.RED,WineType.SPARKLING,"lbl","a","r","c","m",Year.now());
        ds.winelist.add(w);
        RankWines instance = new RankWines("0","0","22");
        boolean expResult = false;
        ObjectResponse result = instance.rankWine(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testRankWine3() {
        System.out.println("rankWine_allParameters_valid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Wine w =new Wine(WineVariety.RED,WineType.SPARKLING,"lbl","a","r","c","m",Year.now());
        ds.winelist.add(w);
        RankWines instance = new RankWines(Integer.toString(sub.getID()),Integer.toString(w.getID()),"7");
        boolean expResult = true;
        ObjectResponse result = instance.rankWine(ds);
        assertEquals(expResult, result.getStatus());
        
    }
}
