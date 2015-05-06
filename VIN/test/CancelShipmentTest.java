import org.junit.Test;
import static org.junit.Assert.*;

public class CancelShipmentTest {
    
    public CancelShipmentTest() {
    }
    @Test
    public void testCancelShipment() {
        System.out.println("cancelShipment_bothparameters_null");
        Data_Store ds = new Data_Store();
        CancelShipment instance = new CancelShipment(null, null);
        boolean expResult = false;
        ObjectResponse result = instance.cancelShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testCancelShipment1() {
        System.out.println("cancelShipment_bothparameters_invalid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s);
        CancelShipment instance = new CancelShipment("-1", "-1");
        boolean expResult = false;
        ObjectResponse result = instance.cancelShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testCancelShipment3() {
        System.out.println("cancelShipment_bothparameters_valid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s);
        CancelShipment instance = new CancelShipment(Integer.toString(sub.getID()), Integer.toString(s.getShipID()));
        boolean expResult = true;
        ObjectResponse result = instance.cancelShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testCancelShipment4() {
        System.out.println("cancelShipment_bothparameters_valid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s);
        s.setStatus(ShipmentStatus.DELIVERED);
        CancelShipment instance = new CancelShipment(Integer.toString(sub.getID()), Integer.toString(s.getShipID()));
        boolean expResult = false;
        ObjectResponse result = instance.cancelShipment(ds);
        assertEquals(expResult, result.getStatus());
    }
}
