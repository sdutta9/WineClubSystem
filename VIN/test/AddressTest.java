
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Shouvik
 */
public class AddressTest {
    
    public AddressTest() {
    }

    @Test
    public void testGetStreet() {
        System.out.println("getStreet");
        String street = "123 Main ST, Apt 2F";
        String city = "Anytown";
        String state = "Anystate";
        String zip = "12345";
        Address instance = new Address(street, city, state, zip);
        String expResult = "123 Main ST, Apt 2F";
        String result = instance.getStreet();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCity() {
        System.out.println("getCity");
        Address instance = new Address();
        String expResult = "Anytown";
        String result = instance.getCity();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetState() {
        System.out.println("getState");
        Address instance = new Address();
        String expResult = "Anystate";
        String result = instance.getState();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetZip() {
        System.out.println("getZip");
        Address instance = new Address();
        String expResult = "12345";
        String result = instance.getZip();
        assertEquals(expResult, result);
    }
    
}
