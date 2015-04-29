
public class Helper_Shipment {

    public static void viewShipment(Data_Store ds, String[] args) {
        
        String uid = null, shipid=null;
        
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){
                case "-uid":    uid = args[++i];
                                break;                            
                case "-sid":    shipid=args[++i];
                                break;
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            } //end of switch           
        }//end of for
        ViewShipmentRequest a = new ViewShipment(uid, shipid);
        ObjectResponse r = a.viewShipment(ds);
        r.printResponse();
    }
    public static void cancelShipment(Data_Store ds, String[] args) {
        
        String uid = null, shipid=null;
        
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){
                case "-uid":    uid = args[++i];
                                break;                            
                case "-sid":    shipid=args[++i];
                                break;
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            } //end of switch           
        }//end of for
        CancelShipmentRequest a = new CancelShipment(uid, shipid);
        ObjectResponse r = a.cancelShipment(ds);
        r.printResponse();
    }
}
