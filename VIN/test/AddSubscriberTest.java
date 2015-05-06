import java.time.YearMonth;
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddSubscriberTest {
    
    public AddSubscriberTest() {
    } 
    @Test
    public void testAddAccount() {
        System.out.println("addAccount");
        Data_Store ds = new Data_Store();
        AddSubscriber instance = new AddSubscriber(null, null, null, null, null, null, null, null, null);
        boolean expResult = false;
        ObjectResponse result = instance.addAccount(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddAccount1() {
        System.out.println("addAccount");
        Data_Store ds = new Data_Store();
        AddSubscriber instance = new AddSubscriber("2951, SKing", "chicago21", "Delaware", "60616ab", "a1", "a@gmail", "3126470594", null, null);
        boolean expResult = false;
        ObjectResponse result = instance.addAccount(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddAccount2() {
        System.out.println("addAccount");
        Data_Store ds = new Data_Store();
        Subscriber s =new Subscriber("sd","a@gmail.com","3126470594",new Address());
        ds.subs.add(s); 
        AddSubscriber instance = new AddSubscriber("2951 SKing", "chicago", "IL", "60616", "sd", "a@gmail.com", "3126470594", null, null);
        boolean expResult = false;
        ObjectResponse result = instance.addAccount(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddAccount3() {
        System.out.println("addAccount");
        Data_Store ds = new Data_Store();
        Subscriber s =new Subscriber("sd","sd@gmail.com","3126470594",new Address());
        ds.subs.add(s);
        MonthlySelection ms =new RW(YearMonth.now().toString(),0);
        ds.mselections.add(ms);
        AddSubscriber instance = new AddSubscriber("2951 SKing", "chicago", "IL", "60616", "a", "a@gmail.com", "3126470594", null, null);
        boolean expResult = true;
        ObjectResponse result = instance.addAccount(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testUserHasAccount() {
        System.out.println("userHasAccount");
        HashSet<Subscriber> subs = new HashSet<>();          
        String e = "sd";
        AddSubscriber instance = new AddSubscriber("2951 SKing", "chicago", "IL", "60616", "sd", "a@gmail.com", "3126470594", null, null);
        boolean expResult = false;
        boolean result = instance.userHasAccount(subs, e);
        assertEquals(expResult, result);
    }
   /* @Test
    public void testUserHasAccount1() {
        System.out.println("userHasAccount");
        HashSet<Subscriber> subs = new HashSet<>();
        Subscriber s =new Subscriber("sd","a@gmail.com","3126470594",new Address());
        subs.add(s);                
        String e = "sd";
        AddSubscriber instance = new AddSubscriber("2951 SKing", "chicago", "IL", "60616", "sd", "a@gmail.com", "3126470594", null, null);
        boolean expResult = true;
        boolean result = instance.userHasAccount(subs, e);
        assertEquals(expResult, result);
    }*/
    
}
