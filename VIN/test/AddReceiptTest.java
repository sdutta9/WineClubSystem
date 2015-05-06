import java.time.YearMonth;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddReceiptTest {
    
    public AddReceiptTest() {
    }
    
    @Test
    public void testAddReceipt() {
        System.out.println("addReceipt");
        Data_Store ds = new Data_Store();
        AddReceipt instance = new AddReceipt(null, null);
        boolean expResult = false;
        ObjectResponse result = instance.addReceipt(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddReceipt1() {
        System.out.println("addReceipt");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment ship = new Shipment(sub.getID(), new Date(), MonthlySelectionType.RW);
        ds.shipments.add(ship);
        AddReceipt instance = new AddReceipt("2", null);
        boolean expResult = false;
        ObjectResponse result = instance.addReceipt(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddReceipt2() {
        System.out.println("addReceipt");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        AddReceipt instance = new AddReceipt("2", "Name");
        boolean expResult = false;
        ObjectResponse result = instance.addReceipt(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddReceipt3() {
        System.out.println("addReceipt");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment ship = new Shipment(sub.getID(), new Date(), MonthlySelectionType.RW);
        ship.setStatus(ShipmentStatus.DELIVERED);
        ds.shipments.add(ship);
        AddReceipt instance = new AddReceipt(Integer.toString(ship.getShipID()), "name");
        boolean expResult = false;
        ObjectResponse result = instance.addReceipt(ds);
        assertEquals(expResult, result.getStatus());
    }
     @Test
    public void testAddReceipt4() {
        System.out.println("addReceipt");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment ship = new Shipment(sub.getID(), new Date(), MonthlySelectionType.RW);
        ds.shipments.add(ship);
        
        MonthlySelection ms = new RW(YearMonth.now().toString(),0);
        MonthlySelection nextmonthselection = new RW("2015-06",0);
        ds.mselections.add(ms);
        ds.mselections.add(nextmonthselection);
        AddReceipt instance = new AddReceipt(Integer.toString(ship.getShipID()), "name");
        boolean expResult = true;
        ObjectResponse result = instance.addReceipt(ds);
        assertEquals(expResult, result.getStatus());
    }
     @Test
    public void testAddReceipt5() {
        System.out.println("addReceipt");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment ship = new Shipment(sub.getID(), new Date(), MonthlySelectionType.RW);
        ds.shipments.add(ship);
        
        MonthlySelection ms = new RW(YearMonth.now().toString(),0);
        MonthlySelection nextmonthselection = new AR("2015-06",0);
        ds.mselections.add(ms);
        ds.mselections.add(nextmonthselection);
        AddReceipt instance = new AddReceipt(Integer.toString(ship.getShipID()), "name");
        boolean expResult = true;
        ObjectResponse result = instance.addReceipt(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddReceipt6() {
        System.out.println("addReceipt");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment ship = new Shipment(sub.getID(), sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(ship);
        AddReceipt instance = new AddReceipt(Integer.toString(ship.getShipID()), "name");
        boolean expResult = true;
        ObjectResponse result = instance.addReceipt(ds);
        assertEquals(expResult, result.getStatus());
    }
}
