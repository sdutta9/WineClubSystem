
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shouvik
 */
public class AdminTest {
    
    public AdminTest() {
    }
    
    @Test
    public void testGetCreateDate() {
        System.out.println("getCreateDate");
        Admin instance = new Admin();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
        String expResult = sdf.format(new Date());
        String result = instance.getCreateDate();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Admin instance = new Admin();
        String expResult = "Jane Doe";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of isMatch method, of class Admin.
     */
    @Test
    public void testIsMatch() {
        System.out.println("isMatch");
        String kw = "Jane Doe";
        Admin instance = new Admin();
        boolean expResult = true;
        boolean result = instance.isMatch(kw);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetID() {
        System.out.println("getID");
        Admin instance = new Admin();
        int expResult = IdGenerator.getID() ;
        int result = instance.getID();
        expResult--;
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateInfo() {
        System.out.println("updateInfo");
        String name = "shouvik";
        Admin instance = new Admin();
        instance.updateInfo(name);
        boolean result = true;
        assertEquals(result, instance.getName().equals(name));
    }
    
}
