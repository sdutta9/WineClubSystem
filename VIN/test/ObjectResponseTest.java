import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shouvik
 */
public class ObjectResponseTest {
    
    public ObjectResponseTest() {
    }
    
    @Test
    public void testPrintResponse() {
        System.out.println("printResponse");
        ObjectResponse instance = new ObjectResponse(1, true, "test");
        instance.printResponse();
    }
    @Test
    public void testPrintResponse2() {
        System.out.println("printResponse2");
        ObjectResponse instance = new ObjectResponse(1, false, "test2");
        instance.printResponse();
    }
    @Test
    public void testPrintResponse3() {
        System.out.println("printResponse");
        ObjectResponse instance = new ObjectResponse(-1, false, "test3");
        instance.printResponse();
    }
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        ObjectResponse instance = new ObjectResponse(1,false, "test");
        boolean expResult = false;
        boolean result = instance.getStatus();
        assertEquals(expResult, result);
    }
    
}
