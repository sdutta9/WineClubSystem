
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class ViewRevenue extends ViewRevenueRequest {
    public ViewRevenue(String sdt, String edt) {
	super(sdt,edt);
    }
    @Override
    public ObjectResponse viewRevenue(Data_Store ds) {       
        Date sdt=null, edt=new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
        if(startdt != null){
            try{
                sdt = sdf.parse(startdt);
            }catch(ParseException pe){
                return new ObjectResponse(1037,false,"Invalid Date. It must be in yyyymmdd format");
            }
        }
        else{
            try{
                sdt = sdf.parse("20140101");
            }catch(ParseException pe){
                return new ObjectResponse(1037,false,"Invalid Date. It must be in yyyymmdd format");
            }
        }
        if(enddt!=null){
            try{
                edt= sdf.parse(enddt);
            }catch(ParseException pe){
                return new ObjectResponse(1037,false,"Invalid Date. It must be in yyyymmdd format");
            }
        }
        else
            edt= new Date();
        
        int units_delivered =0;
        final double unit_price = 59.99;
        final double shipping_charge = 6.01;
        
        Iterator<Receipt> it= ds.receipts.iterator();
        while(it.hasNext()){
            Receipt recpt= it.next();
            Date rdt=recpt.getDate();
            if(rdt.after(sdt)&&rdt.before(edt))
                units_delivered++;
        }    
        String output = "{\n";
        output+="\t\"units_delivered\": "+units_delivered+",\n";
        output+="\t\"wine_revenue\": "+units_delivered*unit_price+",\n";
        output+="\t\"delivery_revenue\": "+units_delivered*shipping_charge+"\n}\n";
        
        return new ObjectResponse(units_delivered, true, output);
    }
}
