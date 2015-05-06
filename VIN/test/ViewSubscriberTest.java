
import org.junit.Test;
import static org.junit.Assert.*;

public class ViewSubscriberTest {
    
    public ViewSubscriberTest() {
    }  
    @Test
    public void testViewAccount() {
        System.out.println("viewAccount_subid_missing");
        Data_Store ds = new Data_Store();
        ViewSubscriber instance = new ViewSubscriber(null);
        boolean expResult = false;
        ObjectResponse result = instance.viewAccount(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewAccount1() {
        System.out.println("viewAccount_subid_invalid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        ViewSubscriber instance = new ViewSubscriber("-1");
        boolean expResult = false;
        ObjectResponse result = instance.viewAccount(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewAccount2() {
        System.out.println("viewAccount_subid_invalid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        ViewSubscriber instance = new ViewSubscriber(Integer.toString(sub.getID()));
        boolean expResult = true;
        ObjectResponse result = instance.viewAccount(ds);
        assertEquals(expResult, result.getStatus());
    }
}
