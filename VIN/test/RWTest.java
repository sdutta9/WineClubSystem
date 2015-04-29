
import java.time.Year;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shouvik
 */
public class RWTest {
    
    public RWTest() {
    }
    
    @Test
    public void testAddWine() {
        System.out.println("addWine");
        WineVariety wv = WineVariety.WHITE;
        WineType wt = WineType.TABLE;
        String labelName = "The Mission";
        String grape = "Cabernet Sauvignon";
        String region = "Napa";
        String country = "USA";
        String maker = "Sterling";
        Year year = Year.parse("2011");
        Wine w = new Wine(wv, wt, labelName, grape, region, country, maker, year);
        MonthlySelection instance = new AW();
        instance.addWine(w);
        System.out.println(instance.hasWines());
        boolean result = true;
        assertEquals(result, instance.hasWines());
    }
    public void testAddWine1() {
        System.out.println("addWine");
        WineVariety wv = WineVariety.WHITE;
        WineType wt = WineType.TABLE;
        String labelName = "The Mission";
        String grape = "Cabernet Sauvignon";
        String region = "Napa";
        String country = "USA";
        String maker = "Sterling";
        Year year = Year.parse("2011");
        Wine w = new Wine(wv, wt, labelName, grape, region, country, maker, year);
        String ym = "2015-04";
        MonthlySelection instance = new AW(ym,0);
        instance.addWine(w);
        System.out.println(instance.hasWines());
        boolean result = true;
        assertEquals(result, instance.hasWines());
    }
    
}
