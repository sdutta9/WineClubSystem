
public class Helper_Delivery {

    public static void viewDeliveryTime(Data_Store ds, String[] args) {
        String uid=null;
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){                   
                case "-uid":    uid=args[++i];
                                break;
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            } //end of switch           
        }//end of for
        ViewDeliveryTimeRequest a = new ViewDeliveryTime(uid);
        ObjectResponse r = a.viewDeliveryTime(ds);
        r.printResponse();    
    }
}
