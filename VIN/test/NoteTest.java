
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shouvik
 */
public class NoteTest {
    
    public NoteTest() {
    }
    
    @Test
    public void testGetCreationDate() {
        System.out.println("getCreationDate");
        Note instance = new Note();
        SimpleDateFormat sdf =new SimpleDateFormat("dd-MMM-yyyy");       
        String expResult = sdf.format(new Date());
        String result = instance.getCreationDate();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNoteID() {
        System.out.println("getNoteID");
        Note instance = new Note(1,2,"this is shipment note");
        int expResult = IdGenerator.getID();
        expResult--;
        int result = instance.getNoteID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSubID() {
        System.out.println("getSubID");
        Note instance = new Note(1,2,"this is shipment note");
        int expResult = 1;
        int result = instance.getSubID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetShipID() {
        System.out.println("getShipID");
        Note instance = new Note(1,2,"this is shipment note");
        int expResult = 2;
        int result = instance.getShipID();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetWineID() {
        System.out.println("getWineID");
        Note instance = new Note(1,3,WineVariety.RED,"this is wine note");
        int expResult = 3;
        int result = instance.getWineID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetWineVariety() {
        System.out.println("getWineVariety");
        Note instance = new Note(1,3,WineVariety.RED,"this is wine note");
        WineVariety expResult = WineVariety.RED;
        WineVariety result = instance.getWineVariety();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetContent() {
        System.out.println("getContent");
        Note instance = new Note(1,3,WineVariety.RED,"this is wine note");
        String expResult = "this is wine note";
        String result = instance.getContent();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetContent() {
        System.out.println("setContent");
        String content = "my wine note";
        Note instance = new Note();
        instance.setContent(content);
        boolean expResult = true;
        assertEquals(expResult, instance.getContent().equals(content));
    }

    @Test
    public void testIsMatchWineType() {
        System.out.println("isMatchWineType");
        int subID = 1;
        WineVariety wt = WineVariety.RED;
        Note instance = new Note(1,2,WineVariety.RED,"this is wine note");
        boolean expResult = true;
        boolean result = instance.isMatchWineType(subID, wt);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsMatchWineType1() {
        System.out.println("isMatchWineType");
        int subID = 1;
        WineVariety wt = WineVariety.RED;
        Note instance = new Note(2,1,WineVariety.RED,"this is wine note");
        boolean expResult = false;
        boolean result = instance.isMatchWineType(subID, wt);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsMatchID() {
        System.out.println("isMatchID");
        int noteID = -1;
        Note instance = new Note();
        boolean expResult = true;
        boolean result = instance.isMatchID(noteID);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsMatchID1() {
        System.out.println("isMatchID");
        int noteID = 0;
        Note instance = new Note();
        boolean expResult = false;
        boolean result = instance.isMatchID(noteID);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsMatchSubID() {
        System.out.println("isMatchSubID");
        int subID = 1;
        Note instance = new Note(1,2,"this is shipment note");
        boolean expResult = true;
        boolean result = instance.isMatchSubID(subID);
        assertEquals(expResult, result);
    }
    
}
