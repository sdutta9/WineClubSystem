import org.junit.Test;
import static org.junit.Assert.*;

public class ViewAdminTest {
    
    public ViewAdminTest() {
    }
    
    @Test
    public void testViewAdmin() {
        System.out.println("viewAdmin_ID_missing");
        Data_Store ds = new Data_Store();
        ViewAdmin instance = new ViewAdmin(null);
        boolean expResult = false;
        ObjectResponse result = instance.viewAdmin(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewAdmin1() {
        System.out.println("viewAdmin_ID_invalid");
        Data_Store ds = new Data_Store();
        Admin a = new Admin("default admin");
        ds.adms.add(a);
        ViewAdmin instance = new ViewAdmin("-1");
        boolean expResult = false;
        ObjectResponse result = instance.viewAdmin(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewAdmin2() {
        System.out.println("viewAdmin_ID_invalid");
        Data_Store ds = new Data_Store();
        Admin a = new Admin("default admin");
        ds.adms.add(a);
        ViewAdmin instance = new ViewAdmin(Integer.toString(a.getID()));
        boolean expResult = true;
        ObjectResponse result = instance.viewAdmin(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
}
