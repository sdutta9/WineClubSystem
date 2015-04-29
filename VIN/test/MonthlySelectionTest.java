import java.time.YearMonth;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shouvik
 */
public class MonthlySelectionTest {
    
    public MonthlySelectionTest() {
    }
    
    @Test
    public void testAddWine() {
        System.out.println("addWine");
        Wine w = null;
        MonthlySelection instance = new MonthlySelectionImpl();
        instance.addWine(w);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSameYearMonth method, of class MonthlySelection.
     */
    @Test
    public void testIsSameYearMonth() {
        System.out.println("isSameYearMonth");
        YearMonth yr = null;
        MonthlySelection instance = new MonthlySelectionImpl();
        boolean expResult = false;
        boolean result = instance.isSameYearMonth(yr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isMatchMST method, of class MonthlySelection.
     */
    @Test
    public void testIsMatchMST() {
        System.out.println("isMatchMST");
        String ym = "";
        String mstype = "";
        MonthlySelection instance = new MonthlySelectionImpl();
        boolean expResult = false;
        boolean result = instance.isMatchMST(ym, mstype);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isMatch method, of class MonthlySelection.
     */
    @Test
    public void testIsMatch() {
        System.out.println("isMatch");
        String kw = "";
        MonthlySelection instance = new MonthlySelectionImpl();
        boolean expResult = false;
        boolean result = instance.isMatch(kw);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class MonthlySelection.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        MonthlySelection instance = new MonthlySelectionImpl();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasWines method, of class MonthlySelection.
     */
    @Test
    public void testHasWines() {
        System.out.println("hasWines");
        MonthlySelection instance = new MonthlySelectionImpl();
        boolean expResult = false;
        boolean result = instance.hasWines();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWines method, of class MonthlySelection.
     */
    @Test
    public void testGetWines() {
        System.out.println("getWines");
        MonthlySelection instance = new MonthlySelectionImpl();
        List<Wine> expResult = null;
        List<Wine> result = instance.getWines();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMst method, of class MonthlySelection.
     */
    @Test
    public void testSetMst() {
        System.out.println("setMst");
        MonthlySelectionType mst = null;
        MonthlySelection instance = new MonthlySelectionImpl();
        instance.setMst(mst);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMST method, of class MonthlySelection.
     */
    @Test
    public void testGetMST() {
        System.out.println("getMST");
        MonthlySelection instance = new MonthlySelectionImpl();
        MonthlySelectionType expResult = null;
        MonthlySelectionType result = instance.getMST();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreationDate method, of class MonthlySelection.
     */
    @Test
    public void testGetCreationDate() {
        System.out.println("getCreationDate");
        MonthlySelection instance = new MonthlySelectionImpl();
        String expResult = "";
        String result = instance.getCreationDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelectionMonth method, of class MonthlySelection.
     */
    @Test
    public void testGetSelectionMonth() {
        System.out.println("getSelectionMonth");
        MonthlySelection instance = new MonthlySelectionImpl();
        String expResult = "";
        String result = instance.getSelectionMonth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedBy method, of class MonthlySelection.
     */
    @Test
    public void testGetCreatedBy() {
        System.out.println("getCreatedBy");
        MonthlySelection instance = new MonthlySelectionImpl();
        int expResult = 0;
        int result = instance.getCreatedBy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class MonthlySelectionImpl extends MonthlySelection {

        public void addWine(Wine w) {
        }
    }
    
}
