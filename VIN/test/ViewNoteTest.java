import java.time.Year;
import org.junit.Test;
import static org.junit.Assert.*;

public class ViewNoteTest {
    
    public ViewNoteTest() {
    }
    
    @Test
    public void testViewNote() {
        System.out.println("viewNote_Subscriber_ID_null");
        Data_Store ds = new Data_Store();
        ViewNote instance = new ViewNote(null, null, null, null);
        boolean expResult = false;
        ObjectResponse result = instance.viewNote(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewNote1() {
        System.out.println("viewNote_InvalidSubscriber_ID");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        ViewNote instance = new ViewNote("23", null, null, null);
        boolean expResult = false;
        ObjectResponse result = instance.viewNote(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewNote2() {
        System.out.println("viewNote_shipID,WineID & noteid all missing");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        ViewNote instance = new ViewNote(Integer.toString(sub.getID()), null, null, null);
        boolean expResult = true;
        ObjectResponse result = instance.viewNote(ds);
        assertEquals(expResult, result.getStatus());
    } 
    @Test
    public void testViewNote3() {
        System.out.println("viewNote_shipID,WineID & noteid all missing");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s);
        Note n =new Note(s.getSubID(),s.getShipID(),"good shipment");
        ds.notes.add(n);
        Wine w =new Wine(WineVariety.RED,WineType.SPARKLING,"lbl","a","r","c","m",Year.now());
        ds.winelist.add(w);
        Note n1=new Note(sub.getID(),w.getID(),w.getVariety(),"Nice wine");
        ds.notes.add(n1);
        ViewNote instance = new ViewNote(Integer.toString(sub.getID()), null, null, null);
        boolean expResult = true;
        ObjectResponse result = instance.viewNote(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewNote4() {
        System.out.println("viewNote_shipID invalid and WineID,noteid all missing");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s);
        ViewNote instance = new ViewNote(Integer.toString(sub.getID()),"0", null, null);
        boolean expResult = false;
        ObjectResponse result = instance.viewNote(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewNote5() {
        System.out.println("viewNote_WineID invalid and shipID,noteid all missing");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Wine w =new Wine(WineVariety.RED,WineType.SPARKLING,"lbl","a","r","c","m",Year.now());
        ds.winelist.add(w);
        ViewNote instance = new ViewNote(Integer.toString(sub.getID()),null, "0", null);
        boolean expResult = false;
        ObjectResponse result = instance.viewNote(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewNote6() {
        System.out.println("viewNote_NoteID invalid and shipID,WineID all missing");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Wine w =new Wine(WineVariety.RED,WineType.SPARKLING,"lbl","a","r","c","m",Year.now());
        ds.winelist.add(w);
        Note n1=new Note(sub.getID(),w.getID(),w.getVariety(),"Nice wine");
        ds.notes.add(n1);
        ViewNote instance = new ViewNote(Integer.toString(sub.getID()),null, null, "0");
        boolean expResult = false;
        ObjectResponse result = instance.viewNote(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewNote7() {
        System.out.println("viewNote_shipID only provided");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s);
        ViewNote instance = new ViewNote(Integer.toString(sub.getID()),Integer.toString(s.getShipID()), null, null);
        boolean expResult = true;
        ObjectResponse result = instance.viewNote(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewNote8() {
        System.out.println("viewNote_shipID only provided");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s);
        Note n =new Note(s.getSubID(),s.getShipID(),"good shipment");
        ds.notes.add(n);
        ViewNote instance = new ViewNote(Integer.toString(sub.getID()),Integer.toString(s.getShipID()), null, null);
        boolean expResult = true;
        ObjectResponse result = instance.viewNote(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewNote9() {
        System.out.println("viewNote_wineID only provided");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Wine w =new Wine(WineVariety.RED,WineType.SPARKLING,"lbl","a","r","c","m",Year.now());
        ds.winelist.add(w);
        ViewNote instance = new ViewNote(Integer.toString(sub.getID()),null,Integer.toString(w.getID()) , null);
        boolean expResult = true;
        ObjectResponse result = instance.viewNote(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewNote10() {
        System.out.println("viewNote_wineID only provided");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Wine w =new Wine(WineVariety.RED,WineType.SPARKLING,"lbl","a","r","c","m",Year.now());
        ds.winelist.add(w);
        Note n1=new Note(sub.getID(),w.getID(),w.getVariety(),"Nice wine");
        ds.notes.add(n1);
        ViewNote instance = new ViewNote(Integer.toString(sub.getID()),null,Integer.toString(w.getID()) , null);
        boolean expResult = true;
        ObjectResponse result = instance.viewNote(ds);
        assertEquals(expResult, result.getStatus());
    }
    
    @Test
    public void testViewNote11() {
        System.out.println("viewNote_NoteID only provided");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Wine w =new Wine(WineVariety.RED,WineType.SPARKLING,"lbl","a","r","c","m",Year.now());
        ds.winelist.add(w);
        Note n1=new Note(sub.getID(),w.getID(),w.getVariety(),"Nice wine");
        ds.notes.add(n1);
        ViewNote instance = new ViewNote(Integer.toString(sub.getID()),null,null,Integer.toString(n1.getNoteID()));
        boolean expResult = true;
        ObjectResponse result = instance.viewNote(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewNote12() {
        System.out.println("viewNote_NoteID only provided");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s);
        Note n =new Note(s.getSubID(),s.getShipID(),"good shipment");
        ds.notes.add(n);
        ViewNote instance = new ViewNote(Integer.toString(sub.getID()),null,null,Integer.toString(n.getNoteID()));
        boolean expResult = true;
        ObjectResponse result = instance.viewNote(ds);
        assertEquals(expResult, result.getStatus());
    }
}
