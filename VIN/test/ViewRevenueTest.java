import org.junit.Test;
import static org.junit.Assert.*;

public class ViewRevenueTest {
    
    public ViewRevenueTest() {
    }
    
    @Test
    public void testViewRevenue() {
        System.out.println("viewRevenue_invalid start date");
        Data_Store ds = new Data_Store();
        ViewRevenue instance = new ViewRevenue("2015/03","2015-04");
        boolean expResult = false;
        ObjectResponse result = instance.viewRevenue(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewRevenue1() {
        System.out.println("viewRevenue_invalid end_date");
        Data_Store ds = new Data_Store();
        ViewRevenue instance = new ViewRevenue("2015-03","2015/04");
        boolean expResult = false;
        ObjectResponse result = instance.viewRevenue(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewRevenue2() {
        System.out.println("viewRevenue");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Receipt r =new Receipt(sub.getID(), sub.getName(), "sd");
        ds.receipts.add(r);
        ViewRevenue instance = new ViewRevenue(null,null);
        boolean expResult = true;
        ObjectResponse result = instance.viewRevenue(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
}
