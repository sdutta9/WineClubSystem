import java.time.Year;
import java.time.YearMonth;
import org.junit.Test;
import static org.junit.Assert.*;

public class ViewMonthlySelectionTest {
    
    public ViewMonthlySelectionTest() {
    }
    @Test
    public void testViewMonthlySelection() {
        System.out.println("viewMonthlySelection");
        Data_Store ds = new Data_Store();
        ViewMonthlySelection instance = new ViewMonthlySelection(null);
        
        boolean expResult = false;
        ObjectResponse result = instance.viewMonthlySelection(ds);
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewMonthlySelection1() {
        System.out.println("viewMonthlySelection");
        Data_Store ds = new Data_Store();
        ViewMonthlySelection instance = new ViewMonthlySelection(null);
        Admin a=new Admin("Admin");
        ds.adms.add(a);
        MonthlySelection ms = new RW(YearMonth.now().toString(),a.getID());
        ds.mselections.add(ms);
        MonthlySelection ms1 = new AW(YearMonth.now().toString(),a.getID());
        ds.mselections.add(ms1);
        boolean expResult = true;
        ObjectResponse result = instance.viewMonthlySelection(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewMonthlySelection2() {
        System.out.println("viewMonthlySelection_valid mid");
        Data_Store ds = new Data_Store();
        Admin a=new Admin("Admin");
        ds.adms.add(a);
        MonthlySelection ms = new RW(YearMonth.now().toString(),a.getID());
        Wine w =new Wine(WineVariety.RED,WineType.SPARKLING,"lbl","a","r","c","m",Year.now());
        ms.addWine(w);
        ds.winelist.add(w);
        ds.mselections.add(ms);
        ViewMonthlySelection instance = new ViewMonthlySelection(Integer.toString(ms.getID()));
        boolean expResult = true;
        ObjectResponse result = instance.viewMonthlySelection(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
    @Test
    public void testViewMonthlySelection3() {
        System.out.println("viewMonthlySelection_Invalid mid");
        Data_Store ds = new Data_Store();
        Admin a=new Admin("Admin");
        ds.adms.add(a);
        MonthlySelection ms = new RW(YearMonth.now().toString(),a.getID());
        Wine w =new Wine(WineVariety.RED,WineType.SPARKLING,"lbl","a","r","c","m",Year.now());
        ms.addWine(w);
        ds.winelist.add(w);
        ds.mselections.add(ms);
        ViewMonthlySelection instance = new ViewMonthlySelection("0");
        boolean expResult = false;
        ObjectResponse result = instance.viewMonthlySelection(ds);
        result.printResponse();
        assertEquals(expResult, result.getStatus());
    }
}
