import org.junit.Test;
import static org.junit.Assert.*;

public class ChangeWinePreferenceTest {
    
    public ChangeWinePreferenceTest() {
    }
    
    @Test
    public void testChangeWinePreference() {
        System.out.println("changeWinePreference_subid_missing");
        Data_Store ds = new Data_Store();
        ChangeWinePreference instance = new ChangeWinePreference(null, null);
        boolean expResult = false;
        ObjectResponse result = instance.changeWinePreference(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testChangeWinePreference1() {
        System.out.println("changeWinePreference_type_missing");
        Data_Store ds = new Data_Store();
        ChangeWinePreference instance = new ChangeWinePreference("-1", null);
        boolean expResult = false;
        ObjectResponse result = instance.changeWinePreference(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testChangeWinePreference2() {
        System.out.println("changeWinePreference_type_invalid");
        Data_Store ds = new Data_Store();
        ChangeWinePreference instance = new ChangeWinePreference("-1", "TW");
        boolean expResult = false;
        ObjectResponse result = instance.changeWinePreference(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testChangeWinePreference3() {
        System.out.println("changeWinePreference_subid_invalid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        ChangeWinePreference instance = new ChangeWinePreference("-1", "RW");
        boolean expResult = false;
        ObjectResponse result = instance.changeWinePreference(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testChangeWinePreference4() {
        System.out.println("changeWinePreference_subid_valid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        ChangeWinePreference instance = new ChangeWinePreference(Integer.toString(sub.getID()), "AR");
        boolean expResult = true;
        ObjectResponse result = instance.changeWinePreference(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
}
