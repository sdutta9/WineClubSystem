
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shouvik
 */
public class WineTest {
    
    public WineTest() {
    }
    
    @Test
    public void testGetVariety() {
        System.out.println("getVariety");
        Wine instance = new Wine();
        WineVariety expResult = WineVariety.RED;
        WineVariety result = instance.getVariety();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetID() {
        System.out.println("getID");
        Wine instance = new Wine();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetType() {
        System.out.println("getType");
        Wine instance = new Wine();
        WineType expResult = WineType.TABLE;
        WineType result = instance.getType();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLabelName() {
        System.out.println("getLabelName");
        Wine instance = new Wine();
        String expResult = "The Mission";
        String result = instance.getLabelName();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testGetGrape() {
        System.out.println("getGrape");
        Wine instance = new Wine();
        String expResult = "Cabernet Sauvignon";
        String result = instance.getGrape();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testGetRegion() {
        System.out.println("getRegion");
        Wine instance = new Wine();
        String expResult = "Napa";
        String result = instance.getRegion();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCountry() {
        System.out.println("getCountry");
        Wine instance = new Wine();
        String expResult = "USA";
        String result = instance.getCountry();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMaker() {
        System.out.println("getMaker");
        Wine instance = new Wine();
        String expResult = "Sterling";
        String result = instance.getMaker();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Wine instance = new Wine();
        String expResult = "2011";
        String result = instance.getYear();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNumberOfRatings() {
        System.out.println("getNumberOfRatings");
        Wine instance = new Wine();
        int expResult = 0;
        int result = instance.getNumberOfRatings();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRating() {
        System.out.println("getRating");
        Wine instance = new Wine();
        float expResult = 0.0F;
        float result = instance.getRating();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of addRating method, of class Wine.
     */
    @Test
    public void testAddRating() {
        System.out.println("addRating");
        int r = 0;
        Wine instance = new Wine();
        instance.addRating(5);
    }

    @Test
    public void testIsMatch() {
        System.out.println("isMatch");
        String kw = "RED";
        Wine instance = new Wine();
        boolean expResult = true;
        boolean result = instance.isMatch(kw);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsMatch1() {
        System.out.println("isMatch");
        String kw = "TABLE";
        Wine instance = new Wine();
        boolean expResult = true;
        boolean result = instance.isMatch(kw);
        assertEquals(expResult, result);
    }
    public void testIsMatch2() {
        System.out.println("isMatch");
        String kw = "The Mission";
        Wine instance = new Wine();
        boolean expResult = true;
        boolean result = instance.isMatch(kw);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsMatch4() {
        System.out.println("isMatch");
        String kw = "SWEET";
        Wine instance = new Wine();
        boolean expResult = false;
        boolean result = instance.isMatch(kw);
        assertEquals(expResult, result);
    }
}
