
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shouvik
 */
public class NoShipListTest {
    
    public NoShipListTest() {
    }
    
    @Test
    public void testCheckState() {
        System.out.println("checkState");
        String state = "delaware";
        NoShipList instance = new NoShipList();
        boolean expResult = true;
        boolean result = instance.checkState(state);
        assertEquals(expResult, result);
    }
    
}
