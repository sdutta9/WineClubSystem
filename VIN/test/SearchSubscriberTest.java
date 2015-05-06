
import java.time.Year;
import java.time.YearMonth;
import org.junit.Test;
import static org.junit.Assert.*;

public class SearchSubscriberTest {
    
    public SearchSubscriberTest() {
    }
    
    @Test
    public void testSearchAccount() {
        System.out.println("SearchAccount_SubId_missing");
        Data_Store ds = new Data_Store();
        SearchSubscriber instance = new SearchSubscriber(null, null);
        boolean expResult = false;
        ObjectResponse result = instance.searchAccount(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testSearchAccount1() {
        System.out.println("SearchAccount_Subid_invalid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        SearchSubscriber instance = new SearchSubscriber("-1", null);
        boolean expResult = false;
        ObjectResponse result = instance.searchAccount(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testSearchAccount2() {
        System.out.println("SearchAccount_Subid_valid_query_string present");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        SearchSubscriber instance = new SearchSubscriber(Integer.toString(sub.getID()), "query");
        boolean expResult = true;
        ObjectResponse result = instance.searchAccount(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testSearchAccount3() {
        System.out.println("SearchAccount_Subid_valid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        SearchSubscriber instance = new SearchSubscriber(Integer.toString(sub.getID()), null);
        boolean expResult = true;
        ObjectResponse result = instance.searchAccount(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testSearchAccount4() {
        System.out.println("SearchAccount_Subid_valid");
        Data_Store ds = new Data_Store();
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        MonthlySelection ms = new RW(YearMonth.now().toString(),0);
        Wine w =new Wine(WineVariety.RED,WineType.SPARKLING,"lbl","a","r","c","m",Year.now());
        ms.addWine(w);
        ds.winelist.add(w);
        ds.mselections.add(ms);
        Shipment s=new Shipment(sub.getID(),sub.getDeliveryDt(),MonthlySelectionType.RW);
        ds.shipments.add(s); 
        Note n =new Note(s.getSubID(),s.getShipID(),"good shipment");
        ds.notes.add(n);
        SearchSubscriber instance = new SearchSubscriber(Integer.toString(sub.getID()), null);
        boolean expResult = true;
        ObjectResponse result = instance.searchAccount(ds);
        assertEquals(expResult, result.getStatus());
    }
}
