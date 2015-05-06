
import org.junit.Test;
import static org.junit.Assert.*;

public class ModifyNoteTest {
    
    public ModifyNoteTest() {
    }
    
    @Test
    public void testModifyNote() {
        System.out.println("modifyNote_allparam_null");
        Data_Store ds = new Data_Store();
        ModifyNote instance = new ModifyNote(null, null, null);
        boolean expResult = false;
        ObjectResponse result = instance.modifyNote(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testModifyNote1() {
        System.out.println("modifyNote_subid and noteid_invalid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s);
        Note n =new Note(s.getSubID(),s.getShipID(),"good shipment");
        ds.notes.add(n);
        ModifyNote instance = new ModifyNote("-1", "-1", "Shipment too good");
        boolean expResult = false;
        ObjectResponse result = instance.modifyNote(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testModifyNote2() {
        System.out.println("modifyNote_subid and noteid_valid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s);
        Note n =new Note(s.getSubID(),s.getShipID(),"good shipment");
        ds.notes.add(n);
        ModifyNote instance = new ModifyNote(Integer.toString(sub.getID()), Integer.toString(n.getNoteID()), "Shipment too good");
        boolean expResult = true;
        ObjectResponse result = instance.modifyNote(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
}
