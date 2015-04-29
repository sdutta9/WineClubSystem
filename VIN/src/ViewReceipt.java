
import java.util.Iterator;

public class ViewReceipt extends ViewReceiptRequest {
    public ViewReceipt(String rid) {
	super(rid);
    }
    @Override
    public ObjectResponse viewReceipt(Data_Store ds) {
        
        int receiptid = Validator.isValidNumber(receipt_id);
        
        if(receiptid == -1){
            Iterator<Receipt> it = ds.receipts.iterator();
            String output = "{\n\t\"receipts\": [\n";
            while(it.hasNext()){
                Receipt recpt= it.next();
                output += "\t\t{\n";
                output += "\t\t\t\"id\": "+recpt.getReceiptID()+",\n";
                output += "\t\t\t\"date\": \""+recpt.getCreationDate()+"\",\n";
                output += "\t\t\t\"subscriber\": "+recpt.getSubID()+",\n";
                output += "\t\t\t\"name\": \""+recpt.getSubName()+"\"\n";
                output += "\t\t}\n";
            }
            output+="\t]\n}\n";
            return new ObjectResponse(receiptid, true, output);
        }
        else{
            Iterator<Receipt> it = ds.receipts.iterator();
            
            Receipt recpt = null;
            while(it.hasNext()){
                recpt= it.next();
                if(recpt.getReceiptID()==receiptid)
                    break;
            }
            if(recpt == null)
                return new ObjectResponse(1029, false, "Invalid Receipt ID");
            else{
                String output = "{\n";
                output += "\t\"id\": "+recpt.getReceiptID()+",\n";
                output += "\t\"date\": \""+recpt.getCreationDate()+"\",\n";
                output += "\t\"time\": \""+recpt.getCreationTime()+"\",\n";
                output += "\t\"subscriber\": "+recpt.getSubID()+",\n";
                output += "\t\"name\": \""+recpt.getSubName()+"\",\n";
                output += "\t\"received_by\": \""+recpt.getReceiverName()+"\"\n";
                output += "}\n";
                return new ObjectResponse(receiptid, true, output);
            }            
        }
    }
}
