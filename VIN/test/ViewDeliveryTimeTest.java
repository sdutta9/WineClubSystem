import org.junit.Test;
import static org.junit.Assert.*;

public class ViewDeliveryTimeTest {
    
    public ViewDeliveryTimeTest() {
    }
    
    @Test
    public void testViewDeliveryTime() {
        System.out.println("viewDeliveryTime_subid_missing");
        Data_Store ds = new Data_Store();
        ViewDeliveryTime instance = new ViewDeliveryTime(null);
        boolean expResult = false;
        ObjectResponse result = instance.viewDeliveryTime(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewDeliveryTime1() {
        System.out.println("viewDeliveryTime_subid_invalid");
        Data_Store ds = new Data_Store();
        ViewDeliveryTime instance = new ViewDeliveryTime("0");
        boolean expResult = false;
        ObjectResponse result = instance.viewDeliveryTime(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewDeliveryTime2() {
        System.out.println("viewDeliveryTime_subid_invalid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        ViewDeliveryTime instance = new ViewDeliveryTime(Integer.toString(sub.getID()));
        boolean expResult = true;
        ObjectResponse result = instance.viewDeliveryTime(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
}
