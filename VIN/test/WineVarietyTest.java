import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shouvik
 */
public class WineVarietyTest {
    
    public WineVarietyTest() {
    }
    
    /**
     * Test of values method, of class WineVariety.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        WineVariety[] expResult = {WineVariety.RED,WineVariety.WHITE,WineVariety.ROSE};
        WineVariety[] result = WineVariety.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class WineVariety.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "RED";
        WineVariety expResult = WineVariety.RED;
        WineVariety result = WineVariety.valueOf(name);
        assertEquals(expResult, result);

    }
    
}
