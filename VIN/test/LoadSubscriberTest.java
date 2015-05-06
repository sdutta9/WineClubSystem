
import org.junit.Test;
import static org.junit.Assert.*;

public class LoadSubscriberTest {
    
    public LoadSubscriberTest() {
    }
    
    @Test
    public void testLoadAccount() {
        System.out.println("loadAccount_filename_missing");
        Data_Store ds = new Data_Store();
        LoadSubscriber instance = new LoadSubscriber(null);
        boolean expResult = false;
        ObjectResponse result = instance.loadAccount(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testLoadAccount1() {
        System.out.println("loadAccount_filename_invalid");
        Data_Store ds = new Data_Store();
        LoadSubscriber instance = new LoadSubscriber("subscribe.xml");
        boolean expResult = false;
        ObjectResponse result = instance.loadAccount(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testLoadAccount2() {
        System.out.println("loadAccount_filename_invalid");
        Data_Store ds = new Data_Store();
        LoadSubscriber instance = new LoadSubscriber("subscribers.xml");
        boolean expResult = true;
        ObjectResponse result = instance.loadAccount(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
}
