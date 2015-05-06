import java.time.YearMonth;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddShipmentTest {
    
    public AddShipmentTest() {
    }
    
    @Test
    public void testAddShipment() {
        System.out.println("addShipment");
        Data_Store ds = new Data_Store();
        AddShipment instance = new AddShipment(null, null);
        boolean expResult = false;
        ObjectResponse result = instance.addShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddShipment1() {
        System.out.println("addShipment");
        Data_Store ds = new Data_Store();
        AddShipment instance = new AddShipment("AB", null);
        boolean expResult = false;
        ObjectResponse result = instance.addShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddShipment2() {
        System.out.println("addShipment");
        Data_Store ds = new Data_Store();
        AddShipment instance = new AddShipment("RW", null);
        boolean expResult = false;
        ObjectResponse result = instance.addShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddShipment3() {
        System.out.println("addShipment");
        Data_Store ds = new Data_Store();
        AddShipment instance = new AddShipment("RW", "2015/05");
        boolean expResult = false;
        ObjectResponse result = instance.addShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddShipment4() {
        System.out.println("addShipment");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment s=new Shipment(sub.getID(),new Date(100),MonthlySelectionType.RW);
        ds.shipments.add(s);
        AddShipment instance = new AddShipment("RW",YearMonth.now().toString());
        boolean expResult = true;
        ObjectResponse result = instance.addShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddShipment5(){
        System.out.println("addShipment");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        AddShipment instance = new AddShipment("AR", YearMonth.now().toString());
        boolean expResult = true;
        ObjectResponse result = instance.addShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddShipment6() {
        System.out.println("addShipment");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        AddShipment instance = new AddShipment("RW", "2015-03");
        boolean expResult = true;
        ObjectResponse result = instance.addShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddShipment7() {
        System.out.println("addShipment");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s);        
        AddShipment instance = new AddShipment("RW", YearMonth.now().toString());
        boolean expResult = true;
        ObjectResponse result = instance.addShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
}
