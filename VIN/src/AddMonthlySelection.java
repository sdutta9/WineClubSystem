
import java.io.File;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AddMonthlySelection extends AddMonthlySelectionRequest {
    private MonthlySelection ms;
    
    public AddMonthlySelection(String aid, String mstype,String ymonth, String filename) {
	super(aid,mstype,ymonth,filename);
    }
    @Override
    public ObjectResponse addMonthlySelection(Data_Store ds) {
        if(Validator.missingValue(a_id))
            return new ObjectResponse(1043,false,"Admin ID must be provided");
        if(Validator.missingValue(this.mst))
            return new ObjectResponse(1018, false, "Type must be provided");
        if(Validator.missingValue(this.ym))
            return new ObjectResponse(1020, false,"Selection month and year must be provided");
        if(Validator.missingValue(this.filename))
            return new ObjectResponse(1015, false,"File name must be provided");
        
        int aid =Validator.isValidNumber(a_id);
        if(!Validator.isValidAdmin(aid, ds.adms))
            return new ObjectResponse(1023, false,"Invalid Admin ID");
        
        if(!Validator.isValidMSType(this.mst))
            return new ObjectResponse(1019, false,"Type can be either RW, AW, AR.");
        if(!Validator.isValidYearMonth(this.ym))
            return new ObjectResponse(1021, false,"Selection month and year must be yyyy-mm format");
        
        Iterator<MonthlySelection> it_ms = ds.mselections.iterator();
        while(it_ms.hasNext()){
            MonthlySelection tempMS = it_ms.next();
            if(tempMS.isMatchMST(ym, mst))
                return new ObjectResponse(1045,false,"Monthly Selection already added for the given wine type");
        }
        
        if(this.mst.equalsIgnoreCase("AR"))
            ms = new AR(this.ym,aid);
        
        else if(this.mst.equalsIgnoreCase("AW"))
            ms = new AW(this.ym,aid);
        else
            ms = new RW(this.ym,aid);
        
        File file=new File(this.filename);
        if(!file.exists())
            return new ObjectResponse(1016,false,"File not found");
        try{            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            
            Element docele=doc.getDocumentElement();
            NodeList memberlist=docele.getElementsByTagName("Wine");
            //System.out.println("Total Subscribers: "+memberlist.getLength());
           
            WineVariety wv=null;
            WineType wt=null;
            String variety=null, type=null, lbl=null, grape=null, region=null, country=null, maker=null;
            Year year=null;
            for(int i=0;i<memberlist.getLength();i++){
                Node node=memberlist.item(i);

                if(node.getNodeType()==Node.ELEMENT_NODE){
                    //System.out.println("----------------------");
                    Element e=(Element)node;

                    NodeList nodelist=e.getElementsByTagName("variety");
                    //System.out.println("variety: "+nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    variety = nodelist.item(0).getChildNodes().item(0).getNodeValue();
                    if(variety.equalsIgnoreCase("red"))
                        wv=WineVariety.RED;
                    else if(variety.equalsIgnoreCase("white"))
                        wv= WineVariety.WHITE;
                    else
                        wv =WineVariety.ROSE;
                    
                    nodelist=e.getElementsByTagName("wine_type");
                    //System.out.println("type: "+nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    type = nodelist.item(0).getChildNodes().item(0).getNodeValue();
                    if(type.equalsIgnoreCase("table"))
                        wt =WineType.TABLE;
                    else if(type.equalsIgnoreCase("sparkling"))
                        wt = WineType.SPARKLING;
                    else
                        wt = WineType.SWEET;
                    
                    nodelist=e.getElementsByTagName("label_name");
                    //System.out.println("label: "+nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    lbl = nodelist.item(0).getChildNodes().item(0).getNodeValue();

                    nodelist=e.getElementsByTagName("grape");
                    //System.out.println("grape: "+nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    grape = nodelist.item(0).getChildNodes().item(0).getNodeValue();

                    nodelist=e.getElementsByTagName("region");
                    //System.out.println("region: "+nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    region = nodelist.item(0).getChildNodes().item(0).getNodeValue();

                    nodelist=e.getElementsByTagName("country");
                    //System.out.println("country: "+nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    country = nodelist.item(0).getChildNodes().item(0).getNodeValue();

                    nodelist=e.getElementsByTagName("maker");
                    //System.out.println("maker: "+nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    maker = nodelist.item(0).getChildNodes().item(0).getNodeValue();

                    try{
                    nodelist=e.getElementsByTagName("year");
                    //System.out.println("Year: "+nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    year = Year.parse(nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    }
                    catch(DateTimeParseException dpe){
                        year = Year.parse("2011"); 
                    }
                    
                    Iterator<Wine> it =ds.winelist.iterator();
                    int flag = 0;
                    Wine temp=null;
                    while(it.hasNext()){
                        temp = it.next();
                        if(temp.isMatch(lbl)){
                            flag = 1;
                            break;
                        }
                    }                    
                    if(flag == 0){
                        Wine w = new Wine(wv,wt,lbl,grape,region,country,maker,year);
                        ds.winelist.add(w);
                        ms.addWine(w);
                    }else
                        ms.addWine(temp);
                }                
            }//end of for
            ds.mselections.add(ms);
            
            //adding all shipments
            addShipments(ds);
            String output = "{\n\t\"id\": "+ms.getID()+"\n}\n";
            return new ObjectResponse(ms.getID(),true,output);    
        }catch(Exception e){
            System.out.println(e);
        } 
        return new ObjectResponse(1022,false,"File contains error.Cannot load.");
    }
    
    private void addShipments(Data_Store ds){
        
        YearMonth ymonth = YearMonth.parse(this.ym);
        
        Iterator<Subscriber> sub_itr = ds.subs.iterator();
        while(sub_itr.hasNext()){
            Subscriber sub =sub_itr.next();
            if(!ymonth.equals(sub.getDeliveryYearMonth()))
                continue;
            if(!sub.getPreference().name().equalsIgnoreCase(this.mst))
                continue;
            Iterator<Shipment> ship_itr = ds.shipments.iterator();
            boolean shipmentPresent = false;
            while(ship_itr.hasNext()){
                Shipment s = ship_itr.next();
                if(s.isMatch(sub.getID(), sub.getDeliveryDt())){
                    shipmentPresent = true;
                    break;
                }
            }
            if(shipmentPresent)
                continue;
            else{
                Shipment temp = new Shipment(sub.getID(),sub.getDeliveryDt(),sub.getPreference());
                ds.shipments.add(temp);
            }                
        }
    }
}
