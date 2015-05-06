import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shouvik
 */
public class AddAdminTest {
    
    public AddAdminTest() {
    }
    @Test
    public void testAddAdmin() {
        System.out.println("addAdmin");
        Data_Store ds = new Data_Store();
        AddAdmin instance = new AddAdmin(null);
        ObjectResponse result = instance.addAdmin(ds);
        boolean expResult = false;
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddAdmin1() {
        System.out.println("addAdmin");
        Data_Store ds = new Data_Store();
        AddAdmin instance = new AddAdmin("shouvik12");
        ObjectResponse result = instance.addAdmin(ds);
        boolean expResult = false;
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddAdmin2() {
        System.out.println("addAdmin");
        Data_Store ds = new Data_Store();
        ds.adms.add(new Admin("shouvik"));
        AddAdmin instance = new AddAdmin("shouvik");
        ObjectResponse result = instance.addAdmin(ds);
        boolean expResult = false;
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddAdmin3() {
        System.out.println("addAdmin");
        Data_Store ds = new Data_Store();
        AddAdmin instance = new AddAdmin("shouvik");
        ObjectResponse result = instance.addAdmin(ds);
        boolean expResult = true;
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddAdmin4() {
        System.out.println("addAdmin");
        Data_Store ds = new Data_Store();
        ds.adms.add(new Admin("shouvik"));
        AddAdmin instance = new AddAdmin("admin");
        ObjectResponse result = instance.addAdmin(ds);
        boolean expResult = true;
        assertEquals(expResult, result.getStatus());
    }
}
