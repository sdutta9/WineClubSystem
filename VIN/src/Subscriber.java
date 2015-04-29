
import java.util.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Calendar;

public class Subscriber implements java.io.Serializable {
    private String name, email, phone, twitter, facebook;
    private Address address;
    private MonthlySelectionType mst;
    private int ID;
    private boolean deactivate;
    private Date joinDate;
    private Date deliveryDt;
    
    public Subscriber() {
    	this.name = "Jane Doe";
    	this.email = "jane.doe@example.com";
    	this.phone = "1234567890";
    	this.address = new Address();
    	this.mst = MonthlySelectionType.RW;
    	this.ID = -1;
        this.deactivate =  false;
        this.joinDate = new Date();
        Calendar cal =Calendar.getInstance();
        cal.setTime(this.joinDate);    
        cal.add( Calendar.DATE, 2 );         
        this.deliveryDt =  cal.getTime(); 
        this.twitter = " ";
    	this.facebook = " ";
    }
    public Subscriber (String name, String email, String phone, Address address) {
    	this.name = name;
    	this.email = email;
    	this.phone = phone.replaceAll("[\\s\\-()]", ""); // drop all non-digit characters
    	this.address = address;
    	this.mst = MonthlySelectionType.RW;
    	this.ID = IdGenerator.newID();
        this.twitter = " ";
    	this.facebook = " ";
        this.deactivate = false;
        this.joinDate = new Date();
        Calendar cal =Calendar.getInstance();
        cal.setTime(this.joinDate);    
        cal.add( Calendar.DATE, 2 );         
        this.deliveryDt =  cal.getTime(); 
    }
    public Subscriber (String name, String email, String phone, Address address, String fb, String tw) {
    	this.name = name;
    	this.email = email;
        if(phone!= null)
            this.phone = phone.replaceAll("[\\s\\-()]", ""); // drop all non-digit characters
    	
        this.address = address;
    	this.twitter = tw;
    	this.facebook = fb;
        this.mst = MonthlySelectionType.RW;
    	this.ID = IdGenerator.newID();
        this.deactivate = false;
        this.joinDate = new Date();
        Calendar cal =Calendar.getInstance();
        cal.setTime(this.joinDate);    
        cal.add( Calendar.DATE, 2 );         
        this.deliveryDt =  cal.getTime(); 
    }
    
    public String getDow(){
        DateFormat ft=new SimpleDateFormat("EEEE"); 
        return ft.format(this.deliveryDt);
    }
    public String getTod(){
        DateFormat ft=new SimpleDateFormat("a"); 
        return ft.format(this.deliveryDt);
    }
    public String getJoinDate(){
        String DATE_FORMAT = "yyyyMMdd";
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(joinDate);
    }
    
    public String getTwitter() {
        return this.twitter;
    }
    public String getFacebook() {
        return this.facebook;
    }
    
    public void setNextDeliveryDt(){
        Calendar cal =Calendar.getInstance();
        cal.setTime(this.deliveryDt);    
        cal.add( Calendar.MONTH, 1 );         
        this.deliveryDt =  cal.getTime(); 
    }
    public Date getDeliveryDt(){
        return this.deliveryDt;
    }
    public YearMonth getDeliveryYearMonth(){
        String DATE_FORMAT = "yyyy-MM";
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT);
        YearMonth ym = YearMonth.parse(sdf.format(this.deliveryDt));
        return ym;
    }
    public int getID() {
    	return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getEmail(){
        return this.email;
    }
    public Address getAddress(){
        return this.address;
    }
    public MonthlySelectionType getPreference() {
    	return mst;
    }    
    public void setPreference(MonthlySelectionType t) {
    	this.mst = t;
    }
         
    private boolean isMatchName(String kw) {
    	String regex = "(?i).*" + kw + ".*";
    	return this.name.matches(regex);
    }
    private boolean isMatchEmail(String kw) {
    	String regex = "(?i).*" + kw + ".*";
    	return this.email.matches(regex);
    }
    private boolean isMatchPhone(String kw) {
    	String s = kw.replaceAll("[\\s\\-()]", ""); // drop all non-digit characters from search string
    	String regex = "(?i).*" + s + ".*";
    	return this.phone.matches(regex);
    }
    public boolean isMatch(String kw) {
    	if (isMatchName(kw) || isMatchEmail(kw) || isMatchPhone(kw)) {
    		return true;
    	} else return false;
    }
    public boolean isMatch(Subscriber s) {
        if( isMatchEmail(s.email)|| isMatchPhone(s.phone))
            return true;
        else
            return false;
    }
    
    public void updateInfo(String name, String email, String phone, String fb, String tw) {
    	if(name != null)
            this.name = name;
    	if(email != null)
            this.email = email;
    	if(phone != null)
            this.phone = phone;
        if(tw !=null)
            this.twitter = tw;
    	if(fb!=null)
            this.facebook = fb;
    }    
        
    public boolean isDeactivated(){
        return this.deactivate;
    }
    public void deactivateSubscriber(){
        this.deactivate = true;
    }
}
