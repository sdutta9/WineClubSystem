
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shouvik
 */
public class SubscriberTest {
    
    public SubscriberTest() {
    }
    
    @Test
    public void testGetDow() {
        System.out.println("getDow");
        Subscriber instance = new Subscriber();
        DateFormat ft=new SimpleDateFormat("EEEE");
        Calendar cal =Calendar.getInstance();
        cal.setTime(new Date());    
        cal.add( Calendar.DATE, 2 );
        String expResult = ft.format(cal.getTime());
        String result = instance.getDow();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTod() {
        System.out.println("getTod");
        Subscriber instance = new Subscriber();
        DateFormat ft=new SimpleDateFormat("a"); 
        Calendar cal =Calendar.getInstance();
        cal.setTime(new Date());    
        cal.add( Calendar.DATE, 2 );
        String expResult = ft.format(cal.getTime());
        String result = instance.getTod();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetJoinDate() {
        System.out.println("getJoinDate");
        Subscriber instance = new Subscriber();
        DateFormat ft=new SimpleDateFormat("yyyyMMdd"); 
        String expResult = ft.format(new Date());
        String result = instance.getJoinDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTwitter method, of class Subscriber.
     */
    @Test
    public void testGetTwitter() {
        System.out.println("getTwitter");
        Subscriber instance = new Subscriber();
        String expResult = " ";
        String result = instance.getTwitter();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFacebook() {
        String name = "Jane Doe";
    	String email = "jane.doe@example.com";
    	String phone = "1234567890";
    	Address address = new Address();
    	MonthlySelectionType mst = MonthlySelectionType.RW; 
        String twitter = " ";
    	String facebook = " ";
        System.out.println("getFacebook");
        Subscriber instance = new Subscriber(name,email, phone, address, twitter, facebook);
        String expResult = " ";
        assertEquals(expResult,instance.getFacebook() );
    }

    @Test
    public void testSetNextDeliveryDt() {
        System.out.println("setNextDeliveryDt");
        Subscriber instance = new Subscriber();
        instance.setNextDeliveryDt();
    }

    @Test
    public void testGetDeliveryDt() {
        System.out.println("getDeliveryDt");
        Subscriber instance = new Subscriber();
        
        Calendar cal =Calendar.getInstance();
        cal.setTime(new Date());    
        cal.add( Calendar.DATE, 2 );
        Date expResult = cal.getTime();
        Date result = instance.getDeliveryDt();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDeliveryYearMonth() {
        System.out.println("getDeliveryYearMonth");
        Subscriber instance = new Subscriber();
        YearMonth expResult = YearMonth.now();
        YearMonth result = instance.getDeliveryYearMonth();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetID() {
        System.out.println("getID");
        Subscriber instance = new Subscriber();
        int expResult = -1;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Subscriber instance = new Subscriber();
        String expResult = "Jane Doe";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Subscriber instance = new Subscriber();
        String expResult = "1234567890";
        String result = instance.getPhone();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Subscriber instance = new Subscriber();
        String expResult = "jane.doe@example.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPreference() {
        System.out.println("getPreference");
        Subscriber instance = new Subscriber();
        MonthlySelectionType expResult = MonthlySelectionType.RW;
        MonthlySelectionType result = instance.getPreference();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetPreference() {
        System.out.println("setPreference");
        MonthlySelectionType t = MonthlySelectionType.AW;
        Subscriber instance = new Subscriber();
        instance.setPreference(t);
    }

    @Test
    public void testIsMatch_String() {
        System.out.println("isMatch");
        String kw = "Jane Doe";
        Subscriber instance = new Subscriber();
        boolean expResult = true;
        boolean result = instance.isMatch(kw);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsMatch_Subscriber() {
        System.out.println("isMatch");
        Subscriber s = new Subscriber();
        Subscriber instance = new Subscriber();
        boolean expResult = true;
        boolean result = instance.isMatch(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateInfo() {
        System.out.println("updateInfo");
        String name = "shouvik";
        String email = "";
        String phone = "";
        String fb = "";
        String tw = "";
        Subscriber instance = new Subscriber();
        instance.updateInfo(name, email, phone, fb, tw);
    }

    @Test
    public void testIsDeactivated() {
        System.out.println("isDeactivated");
        Subscriber instance = new Subscriber();
        boolean expResult = false;
        boolean result = instance.isDeactivated();
        assertEquals(expResult, result);
    }

    /**
     * Test of deactivateSubscriber method, of class Subscriber.
     */
    @Test
    public void testDeactivateSubscriber() {
        System.out.println("deactivateSubscriber");
        Subscriber instance = new Subscriber();
        instance.deactivateSubscriber();
        boolean expResult = true;
        boolean result = instance.isDeactivated();
        assertEquals(expResult, result);
    }
    
}
