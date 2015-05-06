
import org.junit.Test;
import static org.junit.Assert.*;

public class IdGeneratorTest {
    
    public IdGeneratorTest() {
    }

    @Test
    public void testNewID() {
        System.out.println("newID");
        int expResult = 0;
        int result = IdGenerator.newID();
        System.out.println("Result: "+result);
        for(int i=0;i<10;i++){
            int result2 = IdGenerator.newID();
            System.out.println("result "+(i+1)+": "+result2);
        }
        IdGenerator.setID(22);
        for(int i=0;i<5;i++){
            int result2 = IdGenerator.newID();
            System.out.println("result "+(i+1)+": "+result2);
        }
        System.out.println("NextID: "+IdGenerator.getID());
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testSetID() {
        System.out.println("setID");
        int x = 0;
        IdGenerator.setID(x);
        assertEquals(x, IdGenerator.getID());
    }

    @Test
    public void testGetID() {
        System.out.println("getID");
        int expResult = 3;
        IdGenerator.setID(expResult);
        int result = IdGenerator.getID();
        assertEquals(expResult, result);
        
    }
    
}
