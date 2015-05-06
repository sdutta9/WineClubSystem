import org.junit.Test;
import static org.junit.Assert.*;

public class ViewReceiptTest {
    
    public ViewReceiptTest() {
    }
    
    @Test
    public void testViewReceipt() {
        System.out.println("viewReceipt");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Receipt r =new Receipt(sub.getID(), sub.getName(), "sd");
        ds.receipts.add(r);
        ViewReceipt instance = new ViewReceipt(null);
        boolean expResult = true;
        ObjectResponse result = instance.viewReceipt(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewReceipt1() {
        System.out.println("viewReceipt_with receipt id");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Receipt r =new Receipt(sub.getID(), sub.getName(), "sd");
        ds.receipts.add(r);
        ViewReceipt instance = new ViewReceipt(Integer.toString(r.getReceiptID()));
        boolean expResult = true;
        ObjectResponse result = instance.viewReceipt(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewReceipt2() {
        System.out.println("viewReceipt_with invalid receipt id");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        ViewReceipt instance = new ViewReceipt("-1");
        boolean expResult = false;
        ObjectResponse result = instance.viewReceipt(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
}
