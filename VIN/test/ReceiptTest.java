
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shouvik
 */
public class ReceiptTest {
    
    public ReceiptTest() {
    }
    
    @Test
    public void testGetCreationDate() {
        System.out.println("getCreationDate");
        Receipt instance = new Receipt();
        DateFormat ft=new SimpleDateFormat("yyyyMMdd"); 
        String expResult = ft.format(new Date());
        String result = instance.getCreationDate();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCreationTime() {
        System.out.println("getCreationTime");
        String n = "shouvik";
        String rn = "sukriti";
        Receipt instance = new Receipt(1,n,rn);
        DateFormat ft=new SimpleDateFormat("hh:mm a"); 
        String expResult = ft.format(new Date());
        String result = instance.getCreationTime();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Receipt instance = new Receipt();
        Date expResult = new Date();
        Date result = instance.getDate();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetReceiptID() {
        System.out.println("getReceiptID");
        Receipt instance = new Receipt();
        int expResult = -1;
        int result = instance.getReceiptID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSubID() {
        System.out.println("getSubID");
        Receipt instance = new Receipt();
        int expResult = -1;
        int result = instance.getSubID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSubName() {
        System.out.println("getSubName");
        String n = "shouvik";
        String rn = "sukriti";
        Receipt instance = new Receipt(1,n,rn);
        String expResult = n;
        String result = instance.getSubName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetReceiverName() {
        System.out.println("getReceiverName");
        String n = "shouvik";
        String rn = "sukriti";
        Receipt instance = new Receipt(1,n,rn);
        String expResult = rn;
        String result = instance.getReceiverName();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsMatch() {
        System.out.println("isMatch");
        int sid = -1;
        Date createDate = new Date();
        Receipt instance = new Receipt();
        boolean expResult = true;
        boolean result = instance.isMatch(sid, createDate);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsMatch1() {
        System.out.println("isMatch");
        int sid = 0;
        Date createDate = new Date();
        Receipt instance = new Receipt();
        boolean expResult = false;
        boolean result = instance.isMatch(sid, createDate);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsMatch2() {
        System.out.println("isMatch");
        int sid = -1;
        Date createDate = new Date(100);
        Receipt instance = new Receipt();
        boolean expResult = false;
        boolean result = instance.isMatch(sid, createDate);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsMatchID() {
        System.out.println("isMatchID");
        int receiptID = -1;
        Receipt instance = new Receipt();
        boolean expResult = true;
        boolean result = instance.isMatchID(receiptID);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsMatchID1() {
        System.out.println("isMatchID");
        int receiptID = 0;
        Receipt instance = new Receipt();
        boolean expResult = false;
        boolean result = instance.isMatchID(receiptID);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsMatchSubID() {
        System.out.println("isMatchSubID");
        int subID = -1;
        Receipt instance = new Receipt();
        boolean expResult = true;
        boolean result = instance.isMatchSubID(subID);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsMatchSubID1() {
        System.out.println("isMatchSubID");
        int subID = 0;
        Receipt instance = new Receipt();
        boolean expResult = false;
        boolean result = instance.isMatchSubID(subID);
        assertEquals(expResult, result);
    }
    
}
