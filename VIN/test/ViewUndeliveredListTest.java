import org.junit.Test;
import static org.junit.Assert.*;

public class ViewUndeliveredListTest {
    
    public ViewUndeliveredListTest() {
    }
    
    @Test
    public void testViewUndeliveredList() {
        System.out.println("viewUndeliveredList_no undelivered shipment left");
        Data_Store ds = new Data_Store();
        
        ViewUndeliveredList instance = new ViewUndeliveredList();
        boolean expResult = false;
        ObjectResponse result = instance.viewUndeliveredList(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewUndeliveredList1() {
        System.out.println("viewUndeliveredList");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s);
        ViewUndeliveredList instance = new ViewUndeliveredList();
        boolean expResult = true;
        ObjectResponse result = instance.viewUndeliveredList(ds);
        assertEquals(expResult, result.getStatus());
    }
    
}
