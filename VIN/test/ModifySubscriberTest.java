
import org.junit.Test;
import static org.junit.Assert.*;

public class ModifySubscriberTest {
    
    public ModifySubscriberTest() {
    }
    
    @Test
    public void testModifyAccount() {
        System.out.println("modifyAccount_Subid_missing");
        Data_Store ds = new Data_Store();
        ModifySubscriber instance = new ModifySubscriber(null, null, null, null, null, null);
        boolean expResult = false;
        ObjectResponse result = instance.modifyAccount(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testModifyAccount1() {
        System.out.println("modifyAccount_Subid_invalid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        ModifySubscriber instance = new ModifySubscriber("-1", null, null, null, null, null);
        boolean expResult = false;
        ObjectResponse result = instance.modifyAccount(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testModifyAccount2() {
        System.out.println("modifyAccount_Subid_valid_but invalid name, email");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        ModifySubscriber instance = new ModifySubscriber(Integer.toString(sub.getID()),"a2","a@b", "345a", null, null);
        boolean expResult = false;
        ObjectResponse result = instance.modifyAccount(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    
    @Test
    public void testModifyAccount3() {
        System.out.println("modifyAccount_Subid_valid_but invalid name, email");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        ModifySubscriber instance = new ModifySubscriber(Integer.toString(sub.getID()),"a","a@b.com", "3454671234", null, null);
        boolean expResult = true;
        ObjectResponse result = instance.modifyAccount(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
}
