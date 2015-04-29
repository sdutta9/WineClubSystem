
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LoadSubscriber extends LoadSubscriberRequest {
    public LoadSubscriber(String filename) {
	super(filename);
    }
    @Override
    public ObjectResponse loadAccount(Data_Store ds) {
        if(Validator.missingValue(this.filename))
            return new ObjectResponse(1015,false,"File name must be provided");
        
        File file=new File(this.filename);
        if(!file.exists())
            return new ObjectResponse(1016,false,"File not found");        

        try{            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            
            Element docele=doc.getDocumentElement();
            NodeList memberlist=docele.getElementsByTagName("subscriber");
            //System.out.println("Total Subscribers: "+memberlist.getLength());
            
            String name, street, city, state, zip, email, phone, tw, fb;
            for(int i=0;i<memberlist.getLength();i++){
                Node node=memberlist.item(i);

                if(node.getNodeType()==Node.ELEMENT_NODE){
                    //System.out.println("----------------------");
                    Element e=(Element)node;

                    NodeList nodelist=e.getElementsByTagName("name");
                    //System.out.println("Name: "+nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    name = nodelist.item(0).getChildNodes().item(0).getNodeValue();

                    nodelist=e.getElementsByTagName("street");
                    //System.out.println("street: "+nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    street = nodelist.item(0).getChildNodes().item(0).getNodeValue();

                    nodelist=e.getElementsByTagName("city");
                    //System.out.println("City: "+nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    city = nodelist.item(0).getChildNodes().item(0).getNodeValue();

                    nodelist=e.getElementsByTagName("state");
                    //System.out.println("State: "+nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    state = nodelist.item(0).getChildNodes().item(0).getNodeValue();

                    nodelist=e.getElementsByTagName("zip");
                    //System.out.println("zip: "+nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    zip = nodelist.item(0).getChildNodes().item(0).getNodeValue();

                    nodelist=e.getElementsByTagName("email");
                    //System.out.println("Email: "+nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    email = nodelist.item(0).getChildNodes().item(0).getNodeValue();

                    nodelist=e.getElementsByTagName("phone");
                    //System.out.println("phone: "+nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    phone = nodelist.item(0).getChildNodes().item(0).getNodeValue();

                    try{
                    nodelist=e.getElementsByTagName("twitter");
                    //System.out.println("twitter: "+nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    tw = nodelist.item(0).getChildNodes().item(0).getNodeValue();
                    }catch(NullPointerException ne){tw = " "; }

                    try{
                    nodelist=e.getElementsByTagName("facebook");
                    //System.out.println("facebook: "+nodelist.item(0).getChildNodes().item(0).getNodeValue());
                    fb = nodelist.item(0).getChildNodes().item(0).getNodeValue();
                    }catch(NullPointerException ne){fb = " ";   }
                    
                    AddSubscriberRequest a = new AddSubscriber(street, city, state, zip, name, email, phone, tw, fb);
                    ObjectResponse r = a.addAccount(ds);
                    r.printResponse();                    
                }
            }//end of for
            return new ObjectResponse(memberlist.getLength(),true,"\nFile loaded successfully\n");    
        }catch(Exception e){
            System.out.println(e);
        } 
        return new ObjectResponse(1022,false,"File contains error.Cannot load.");
    }
}
