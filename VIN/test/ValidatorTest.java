
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shouvik
 */
public class ValidatorTest {
    
    public ValidatorTest() {
    }

    @Test
    public void testMissingValue() {
        System.out.println("missingValue");
        String str = null;
        boolean expResult = true;
        boolean result = Validator.missingValue(str);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidName() {
        System.out.println("isValidName");
        String name = "shouvik dutta";
        boolean expResult = true;
        boolean result = Validator.isValidName(name);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsValidName1() {
        System.out.println("isValidName");
        String name = "shouvik12";
        boolean expResult = false;
        boolean result = Validator.isValidName(name);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsValidEmail() {
        System.out.println("isValidEmail");
        String email = "shouvik@example.com";
        boolean expResult = true;
        boolean result = Validator.isValidEmail(email);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidAddress() {
        System.out.println("isValidAddress");
        String street = "2951 south";
        boolean expResult = true;
        boolean result = Validator.isValidAddress(street);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidCity() {
        System.out.println("isValidCity");
        String city = "chicago";
        boolean expResult = true;
        boolean result = Validator.isValidCity(city);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidZip() {
        System.out.println("isValidZip");
        String zip = "60616";
        boolean expResult = true;
        boolean result = Validator.isValidZip(zip);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddressInBannedState() {
        System.out.println("addressInBannedState");
        String state = "delaware";
        boolean expResult = true;
        boolean result = Validator.addressInBannedState(state);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsValidMSType() {
        System.out.println("isValidMSType");
        String mst = "RW";
        boolean expResult = true;
        boolean result = Validator.isValidMSType(mst);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidYearMonth() {
        System.out.println("isValidYearMonth");
        String ym = "2015-04";
        boolean expResult = true;
        boolean result = Validator.isValidYearMonth(ym);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidNumber() {
        System.out.println("isValidNumber");
        String id = "56";
        int expResult = 56;
        int result = Validator.isValidNumber(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidAdmin() {
        System.out.println("isValidAdmin");
        int aid = -1;
        HashSet<Admin> admins = new HashSet<>();
        Admin a = new Admin();
        admins.add(a);
        boolean expResult = true;
        boolean result = Validator.isValidAdmin(aid, admins);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidSubscriber() {
        System.out.println("isValidSubscriber");
        int sid = -1;
        HashSet<Subscriber> subs = new HashSet<>();
        Subscriber s = new Subscriber();
        subs.add(s);
        boolean expResult = true;
        boolean result = Validator.isValidSubscriber(sid, subs);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidShipment() {
        System.out.println("isValidShipment");
        int sid = -1;
        HashSet<Shipment> shipments = new HashSet<>();
        Shipment s =new Shipment();
        shipments.add(s);
        boolean expResult = true;
        boolean result = Validator.isValidShipment(sid, shipments);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidMonthlySelection() {
        System.out.println("isValidMonthlySelection");
        int mid = -1;
        HashSet<MonthlySelection> ms = new HashSet<>();
        MonthlySelection mso=new AR();
        ms.add(mso);
        boolean expResult = true;
        boolean result = Validator.isValidMonthlySelection(mid, ms);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidWine() {
        System.out.println("isValidWine");
        int wid = -1;
        HashSet<Wine> wines = new HashSet<>();
        Wine w =new Wine();
        wines.add(w);
        boolean expResult = true;
        boolean result = Validator.isValidWine(wid, wines);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidNote() {
        System.out.println("isValidNote");
        int nid = -1;
        HashSet<Note> notes = new HashSet<>();
        Note n = new Note();
        notes.add(n);
        boolean expResult = true;
        boolean result = Validator.isValidNote(nid, notes);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidDate() {
        System.out.println("isValidDate");
        String dt = "20150425";
        boolean expResult = true;
        boolean result = Validator.isValidDate(dt);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsCommand() {
        System.out.println("isCommand");
        String str = "-uid";
        boolean expResult = true;
        boolean result = Validator.isCommand(str);
        assertEquals(expResult, result);
    }
    
}
