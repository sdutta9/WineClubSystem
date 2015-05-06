
import java.time.Year;
import org.junit.Test;
import static org.junit.Assert.*;

public class ViewWinesTest {
    
    public ViewWinesTest() {
    }    
    @Test
    public void testViewWine() {
        System.out.println("viewWine_wineid_missing");
        Data_Store ds = new Data_Store();
        ViewWines instance = new ViewWines(null);
        boolean expResult = false;
        ObjectResponse result = instance.viewWine(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewWine1() {
        System.out.println("viewWine_wineid_invalid");
        Data_Store ds = new Data_Store();
        ViewWines instance = new ViewWines("24");
        boolean expResult = false;
        ObjectResponse result = instance.viewWine(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
     @Test
    public void testViewWine2() {
        System.out.println("viewWine_wineid_valid");
        Data_Store ds = new Data_Store();
        Wine w =new Wine(WineVariety.RED,WineType.SPARKLING,"lbl","a","r","c","m",Year.now());
        ds.winelist.add(w);
        ViewWines instance = new ViewWines(Integer.toString(w.getID()));
        boolean expResult = true;
        ObjectResponse result = instance.viewWine(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
}
