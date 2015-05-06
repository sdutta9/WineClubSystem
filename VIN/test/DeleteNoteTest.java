import org.junit.Test;
import static org.junit.Assert.*;

public class DeleteNoteTest {
    
    public DeleteNoteTest() {
    }
    
    @Test
    public void testDeleteNote() {
        System.out.println("deleteNote_allparam_null");
        Data_Store ds = new Data_Store();
        DeleteNote instance = new DeleteNote(null, null);
        boolean expResult = false;
        ObjectResponse result = instance.deleteNote(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testDeleteNote1() {
        System.out.println("deleteNote_allparam_invalid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s);
        Note n =new Note(s.getSubID(),s.getShipID(),"good shipment");
        ds.notes.add(n);
        DeleteNote instance = new DeleteNote("-1", "-1");
        boolean expResult = false;
        ObjectResponse result = instance.deleteNote(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testDeleteNote2() {
        System.out.println("deleteNote_allparam_valid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s);
        Note n =new Note(s.getSubID(),s.getShipID(),"good shipment");
        ds.notes.add(n);
        DeleteNote instance = new DeleteNote(Integer.toString(sub.getID()), Integer.toString(n.getNoteID()));
        boolean expResult = true;
        ObjectResponse result = instance.deleteNote(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
}
