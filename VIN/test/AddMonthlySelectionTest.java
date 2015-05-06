
import java.time.YearMonth;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddMonthlySelectionTest {
    
    public AddMonthlySelectionTest() {
    }
    @Test
    public void testAddMonthlySelection() {
        System.out.println("addMonthlySelection_aid missing");
        Data_Store ds = new Data_Store();
        AddMonthlySelection instance = new AddMonthlySelection(null,null,null,null);
        boolean expResult = false;
        ObjectResponse result = instance.addMonthlySelection(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddMonthlySelection1() {
        System.out.println("addMonthlySelection_Type missing");
        Data_Store ds = new Data_Store();
        AddMonthlySelection instance = new AddMonthlySelection("0",null,null,null);
        boolean expResult = false;
        ObjectResponse result = instance.addMonthlySelection(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddMonthlySelection2() {
        System.out.println("addMonthlySelection_ymonth missing");
        Data_Store ds = new Data_Store();
        AddMonthlySelection instance = new AddMonthlySelection("0","RW",null,null);
        boolean expResult = false;
        ObjectResponse result = instance.addMonthlySelection(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddMonthlySelection3() {
        System.out.println("addMonthlySelection_filename missing");
        Data_Store ds = new Data_Store();
        AddMonthlySelection instance = new AddMonthlySelection("0","RW","2015-05",null);
        boolean expResult = false;
        ObjectResponse result = instance.addMonthlySelection(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddMonthlySelection4() {
        System.out.println("addMonthlySelection_aid invalid");
        Data_Store ds = new Data_Store();
        Admin a=new Admin("Admin");
        ds.adms.add(a);
        AddMonthlySelection instance = new AddMonthlySelection("-1","RW","2015-05","../winelist_april2015.xml");
        boolean expResult = false;
        ObjectResponse result = instance.addMonthlySelection(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddMonthlySelection5() {
        System.out.println("addMonthlySelection_type invalid");
        Data_Store ds = new Data_Store();
        Admin a=new Admin("Admin");
        ds.adms.add(a);
        AddMonthlySelection instance = new AddMonthlySelection(Integer.toString(a.getID()),"TW","2015-05","../winelist_april2015.xml");
        boolean expResult = false;
        ObjectResponse result = instance.addMonthlySelection(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddMonthlySelection6() {
        System.out.println("addMonthlySelection_ymonth invalid");
        Data_Store ds = new Data_Store();
        Admin a=new Admin("Admin");
        ds.adms.add(a);
        AddMonthlySelection instance = new AddMonthlySelection(Integer.toString(a.getID()),"RW","2015/05","../winelist_april2015.xml");
        boolean expResult = false;
        ObjectResponse result = instance.addMonthlySelection(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddMonthlySelection7() {
        System.out.println("addMonthlySelection_MonthlySelection already added");
        Data_Store ds = new Data_Store();
        Admin a=new Admin("Admin");
        ds.adms.add(a);
        MonthlySelection ms = new RW(YearMonth.now().toString(),0);
        ds.mselections.add(ms);
        AddMonthlySelection instance = new AddMonthlySelection(Integer.toString(a.getID()),"RW",YearMonth.now().toString(),"../winelist_april2015.xml");
        boolean expResult = false;
        ObjectResponse result = instance.addMonthlySelection(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddMonthlySelection8() {
        System.out.println("addMonthlySelection_filename invalid");
        Data_Store ds = new Data_Store();
        Admin a=new Admin("Admin");
        ds.adms.add(a);
        AddMonthlySelection instance = new AddMonthlySelection(Integer.toString(a.getID()),"AR","2015-05","../winelist_apr.xml");
        boolean expResult = false;
        ObjectResponse result = instance.addMonthlySelection(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testAddMonthlySelection9() {
        System.out.println("addMonthlySelection_filename valid");
        Data_Store ds = new Data_Store();
        Admin a=new Admin("Admin");
        ds.adms.add(a);
        Subscriber sub = new Subscriber("a","a@gmail.com","3126470594",new Address());
        ds.subs.add(sub);
        AddMonthlySelection instance = new AddMonthlySelection(Integer.toString(a.getID()),"RW", YearMonth.now().toString(),"winelist_april2015.xml");
        boolean expResult = true;
        ObjectResponse result = instance.addMonthlySelection(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
}
