import java.time.Year;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddNoteTest {
    
    public AddNoteTest() {
    }
    
    @Test
    public void testAddNote() {
        System.out.println("addNote");
        Data_Store ds = new Data_Store();
        AddNote instance = new AddNote(null,null,null, null);
        boolean expResult = false;
        ObjectResponse result = instance.addNote(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddNote1() {
        System.out.println("addNote");
        Data_Store ds = new Data_Store();
        AddNote instance = new AddNote("-1","-1","-1","hello note");
        boolean expResult = false;
        ObjectResponse result = instance.addNote(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddNote2() {
        System.out.println("addNote");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment ship = new Shipment(sub.getID(), new Date(), MonthlySelectionType.RW);
        ds.shipments.add(ship);
        AddNote instance = new AddNote(Integer.toString(sub.getID()),Integer.toString(ship.getShipID()),"-1","hello note");
        boolean expResult = true;
        ObjectResponse result = instance.addNote(ds);
        assertEquals(expResult, result.getStatus());
    }
    
    @Test
    public void testAddNote3() {
        System.out.println("addNote");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Wine w =new Wine(WineVariety.RED,WineType.SPARKLING,"lbl","a","r","c","m",Year.now());
        ds.winelist.add(w);
        AddNote instance = new AddNote(Integer.toString(sub.getID()),"-1",Integer.toString(w.getID()),"hello note");
        boolean expResult = true;
        ObjectResponse result = instance.addNote(ds);
        assertEquals(expResult, result.getStatus());
    }
}
