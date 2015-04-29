
import static org.junit.Assert.*;
import org.junit.Test;

public class MonthlySelectionTypeTest {
    
    public MonthlySelectionTypeTest() {
    }
    
    @Test
    public void testValues() {
        System.out.println("values");
        String expResult = "AR";
        MonthlySelectionType result = MonthlySelectionType.AR;
        System.out.println("Value: "+result.toString());
        assertEquals(expResult, result.name());        
    }

    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "RW";
        MonthlySelectionType expResult = MonthlySelectionType.RW;
        MonthlySelectionType result = MonthlySelectionType.valueOf(name);
        assertEquals(expResult, result);
    }
}
