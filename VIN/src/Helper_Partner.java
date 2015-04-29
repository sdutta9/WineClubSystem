public class Helper_Partner {
    public static void viewSubscriber_list(Data_Store ds, String[] args) {
        
        ViewUndeliveredListRequest a = new ViewUndeliveredList();
        ObjectResponse r = a.viewUndeliveredList(ds);
        r.printResponse();    
    }
    public static void AddReceipt(Data_Store ds, String[] args) {
        
        String sid = null, rname = null;
        
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){
                case "-sid":sid = args[++i];
                            break;                            
                case "-n":  rname=args[++i];
                            for(;;){
                                if(i<args.length-1){
                                    if(Validator.isCommand(args[i+1]))
                                        break;
                                    else
                                        rname+=" "+args[++i];
                                }
                                else
                                    break;                            
                            }
                            break;
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            } //end of switch           
        }//end of for
        AddReceiptRequest a = new AddReceipt(sid, rname);
        ObjectResponse r = a.addReceipt(ds);
        r.printResponse();
    }
    
    public static void ViewReceipt(Data_Store ds, String[] args) {
        
        String rid = null;
        
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){
                case "-rid":rid = args[++i];
                            break;                            
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            } //end of switch           
        }//end of for
        ViewReceiptRequest a = new ViewReceipt(rid);
        ObjectResponse r = a.viewReceipt(ds);
        r.printResponse();
    }
}
