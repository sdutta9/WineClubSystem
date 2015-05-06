import java.time.Year;
import org.junit.Test;
import static org.junit.Assert.*;

public class ARTest {
    
    public ARTest() {
    }
    
    @Test
    public void testAddWine() {
        System.out.println("addWine");
        Wine w = new Wine();
        MonthlySelection instance = new AR();
        instance.addWine(w);
        System.out.println(instance.hasWines());
        boolean result = true;
        assertEquals(result, instance.hasWines());
    }
    @Test
    public void testAddWine2() {
        System.out.println("addWine");
        Wine w = new Wine();
        MonthlySelection instance = new AR("2015-04", 0);
        instance.addWine(w);
        System.out.println(instance.hasWines());
        boolean result = true;
        assertEquals(result, instance.hasWines());
    }
    @Test
    public void testAddWine3() {
        System.out.println("addWine");
        WineVariety wv = WineVariety.ROSE;
        WineType wt = WineType.TABLE;
        String labelName = "The Mission";
        String grape = "Cabernet Sauvignon";
        String region = "Napa";
        String country = "USA";
        String maker = "Sterling";
        Year year = Year.parse("2011");
        Wine w = new Wine(wv,wt,labelName,grape,region,country,maker,year);
        MonthlySelection instance = new AR("2015-04", 0);
        instance.addWine(w);
        System.out.println(instance.hasWines());
        boolean result = true;
        assertEquals(result, instance.hasWines());
    }
}
