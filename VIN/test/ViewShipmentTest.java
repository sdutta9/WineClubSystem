import java.time.Year;
import java.time.YearMonth;
import org.junit.Test;
import static org.junit.Assert.*;

public class ViewShipmentTest {
    
    public ViewShipmentTest() {
    }
    @Test
    public void testViewShipment() {
        System.out.println("viewShipment");
        Data_Store ds = new Data_Store();
        ViewShipment instance = new ViewShipment(null, null);
        boolean expResult = false;
        ObjectResponse result = instance.viewShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewShipment1() {
        System.out.println("viewShipment_InvalidSubscriberID");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        ViewShipment instance = new ViewShipment("10", null);
        boolean expResult = false;
        ObjectResponse result = instance.viewShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewShipment2() {
        System.out.println("viewShipment_Valid_SubsriberID and ShipID missing");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s);
        ViewShipment instance = new ViewShipment(Integer.toString(sub.getID()), null);
        boolean expResult = true;
        ObjectResponse result = instance.viewShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewShipment3() {
        System.out.println("viewShipment_Valid SubscriberID and ShipID invalid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s);
        ViewShipment instance = new ViewShipment(Integer.toString(sub.getID()),"25" );
        boolean expResult = true;
        ObjectResponse result = instance.viewShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewShipment4() {
        System.out.println("viewShipment_Valid SubscriberID and ShipID valid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        MonthlySelection ms = new RW(YearMonth.now().toString(),0);
        Wine w =new Wine(WineVariety.RED,WineType.SPARKLING,"lbl","a","r","c","m",Year.now());
        ms.addWine(w);
        ds.mselections.add(ms);
        ds.winelist.add(w);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s);        
        ViewShipment instance = new ViewShipment(Integer.toString(sub.getID()), Integer.toString(s.getShipID()));
        boolean expResult = true;
        ObjectResponse result = instance.viewShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewShipment5() {
        System.out.println("viewShipment_Valid SubscriberID and ShipID invalid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);     
        ViewShipment instance = new ViewShipment(Integer.toString(sub.getID()), "0");
        boolean expResult = false;
        ObjectResponse result = instance.viewShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
    
}
