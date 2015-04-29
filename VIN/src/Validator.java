
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.HashSet;
import java.util.Iterator;

public class Validator {
    public static boolean missingValue(String str){
        if(str == null)
            return true;
        else
            return false;
    }
    public static boolean isValidName(String name){
        String expression = "^[a-zA-Z\\s]+"; 
        return name.matches(expression);
    }

    public static boolean isValidEmail(String email){
        String expression = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(expression);
    }
    public static boolean isValidAddress(String street){
        String expression = "^[a-zA-Z0-9\\s]+"; 
        return street.matches(expression);
    }
    public static boolean isValidCity(String city){
        String expression = "^[a-zA-Z\\s]+"; 
        return city.matches(expression);
    }
    public static boolean isValidZip(String zip){
        String expression = "\\d{5}(-\\d{4})?";
        return zip.matches(expression);
    }
    public static boolean addressInBannedState(String state) {
        NoShipList nsl = new NoShipList();
        return nsl.checkState(state);
    } 
    public static boolean isValidMSType(String mst){
        if(mst.equalsIgnoreCase("RW") || mst.equalsIgnoreCase("AW") || mst.equalsIgnoreCase("AR"))
            return true;
        else
            return false;            
    }

    public static boolean isValidYearMonth(String ym) {
        try{
            YearMonth.parse(ym);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public static int isValidNumber(String id){
        int number;
        try{
            number =Integer.parseInt(id);
        }catch(NumberFormatException ne){
            number = -1;
        } 
        return number;
    }
    public static boolean isValidAdmin(int aid, HashSet<Admin> admins){
        Iterator<Admin> it = admins.iterator();
        while(it.hasNext()){
            Admin temp = it.next();
            if(aid == temp.getID())
                return true;
        }   
        return false;
    }
    public static boolean isValidSubscriber(int sid, HashSet<Subscriber> subs){
        Iterator<Subscriber> it = subs.iterator();
        while(it.hasNext()){
            Subscriber temp = it.next();
            if(sid == temp.getID())
                return true;
        }   
        return false;
    }    
    public static boolean isValidShipment(int sid, HashSet<Shipment> shipments){
        Iterator<Shipment> it = shipments.iterator();
        while(it.hasNext()){
            Shipment temp = it.next();
            if(sid == temp.getShipID())
                return true;
        }   
        return false;
    }
    public static boolean isValidMonthlySelection(int mid, HashSet<MonthlySelection> ms){
        Iterator<MonthlySelection> it = ms.iterator();
        while(it.hasNext()){
            MonthlySelection temp = it.next();
            if(mid == temp.getID())
                return true;
        }   
        return false;
    }
    public static boolean isValidWine(int wid, HashSet<Wine> wines){
        Iterator<Wine> it = wines.iterator();
        while(it.hasNext()){
            Wine temp = it.next();
            if(wid == temp.getID())
                return true;
        }   
        return false;
    }
    public static boolean isValidNote(int nid, HashSet<Note> notes){
        Iterator<Note> it = notes.iterator();
        while(it.hasNext()){
            Note temp = it.next();
            if(nid == temp.getNoteID())
                return true;
        }   
        return false;
    }
    
    public static boolean isValidDate(String dt){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        try {
            sdf1.parse(dt);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    public static boolean isCommand(String str){
        return str.startsWith("-");
    }
}
