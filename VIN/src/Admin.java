
import java.util.Date;
import java.text.SimpleDateFormat;

public class Admin implements java.io.Serializable {
    private String name;
    private int ID;
    private Date createDate;
    
    public Admin() {
    	this.name = "Jane Doe";  	
    	this.ID = -1;
        this.createDate = new Date();   
    }
    public Admin (String name) {
    	this.name = name;
    	this.ID = IdGenerator.newID();
        this.createDate = new Date();
    }
    
    public String getCreateDate(){
        String DATE_FORMAT = "yyyyMMdd";
        SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(createDate);
    }

    public String getName() {
        return name;
    }
      
    public boolean isMatch(String kw) {
    	String regex = "(?i).*" + kw + ".*";
    	return this.name.matches(regex);
    }
    
    public int getID() {
    	return this.ID;
    }    
    public void updateInfo(String name) {
    	if(name != null)
            this.name = name;
    }    
}
