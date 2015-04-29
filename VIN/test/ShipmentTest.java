
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShipmentTest {
    
    public ShipmentTest() {
    }
    
    @Test
    public void testGetDeliveryYearMonth() {
        System.out.println("getDeliveryYearMonth");
        Shipment instance = new Shipment(1,new Date(),MonthlySelectionType.AR);
        YearMonth expResult = YearMonth.now();
        YearMonth result = instance.getDeliveryYearMonth();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetDeliveryDate() {
        System.out.println("getDeliveryDate");
        Shipment instance = new Shipment();
        SimpleDateFormat sdf =new SimpleDateFormat("dd-MMM-yyyy");
        String expResult = sdf.format(new Date());
        String result = instance.getDeliveryDate();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSelectionMonth() {
        System.out.println("getSelectionMonth");
        Shipment instance = new Shipment();
        SimpleDateFormat sdf =new SimpleDateFormat("MMM/yyyy");
        String expResult = sdf.format(new Date());
        String result = instance.getSelectionMonth();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCancelDate() {
        System.out.println("setCancelDate");
        Date d = new Date();
        Shipment instance = new Shipment();
        instance.setCancelDate(d);
    }

    @Test
    public void testGetShipID() {
        System.out.println("getShipID");
        Shipment instance = new Shipment();
        int expResult = -1;
        int result = instance.getShipID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMST() {
        System.out.println("getMST");
        Shipment instance = new Shipment();
        MonthlySelectionType expResult = MonthlySelectionType.RW;
        MonthlySelectionType result = instance.getMST();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSubID() {
        System.out.println("getSubID");
        Shipment instance = new Shipment();
        int expResult = -1;
        int result = instance.getSubID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Shipment instance = new Shipment();
        ShipmentStatus expResult = ShipmentStatus.UNDELIVERED;
        ShipmentStatus result = instance.getStatus();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        ShipmentStatus ss = ShipmentStatus.DELIVERED;
        Shipment instance = new Shipment();
        instance.setStatus(ss);
        ShipmentStatus expResult = ShipmentStatus.DELIVERED;
        ShipmentStatus result = instance.getStatus();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetReceiptID() {
        System.out.println("setReceiptID");
        int receiptID = -1;
        Shipment instance = new Shipment();
        instance.setReceiptID(receiptID);
    }

    @Test
    public void testIsMatch() {
        System.out.println("isMatch");
        int sid = -1;
        Date delDate = new Date();
        Shipment instance = new Shipment();
        boolean expResult = true;
        boolean result = instance.isMatch(sid, delDate);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsMatchID() {
        System.out.println("isMatchID");
        int shipID = -1;
        Shipment instance = new Shipment();
        boolean expResult = true;
        boolean result = instance.isMatchID(shipID);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsMatchSubID() {
        System.out.println("isMatchSubID");
        int subID = -1;
        Shipment instance = new Shipment();
        boolean expResult = true;
        boolean result = instance.isMatchSubID(subID);
        assertEquals(expResult, result);
    }

    /**
     * Test of isMatchReceiptID method, of class Shipment.
     */
    @Test
    public void testIsMatchReceiptID() {
        System.out.println("isMatchReceiptID");
        int receiptID = -1;
        Shipment instance = new Shipment();
        boolean expResult = true;
        boolean result = instance.isMatchReceiptID(receiptID);
        assertEquals(expResult, result);
    }
    
}
