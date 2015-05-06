
import org.junit.Test;
import static org.junit.Assert.*;

public class ModifyAdminTest {
    
    public ModifyAdminTest() {
    }
    
    @Test
    public void testModifyAdmin() {
        System.out.println("modifyAdmin_adminid_missing");
        Data_Store ds = new Data_Store();
        ModifyAdmin instance = new ModifyAdmin(null, null);
        boolean expResult = false;
        ObjectResponse result = instance.modifyAdmin(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testModifyAdmin1() {
        System.out.println("modifyAdmin_adminid_invalid");
        Data_Store ds = new Data_Store();
        ModifyAdmin instance = new ModifyAdmin("-1", null);
        boolean expResult = false;
        ObjectResponse result = instance.modifyAdmin(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testModifyAdmin2() {
        System.out.println("modifyAdmin_new name_invalid");
        Data_Store ds = new Data_Store();
        Admin a =new Admin("default admin");
        ds.adms.add(a);
        ModifyAdmin instance = new ModifyAdmin(Integer.toString(a.getID()), "admin1");
        boolean expResult = false;
        ObjectResponse result = instance.modifyAdmin(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testModifyAdmin3() {
        System.out.println("modifyAdmin_new name_valid");
        Data_Store ds = new Data_Store();
        Admin a =new Admin("default admin");
        ds.adms.add(a);
        ModifyAdmin instance = new ModifyAdmin(Integer.toString(a.getID()), "admin");
        boolean expResult = true;
        ObjectResponse result = instance.modifyAdmin(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
}
