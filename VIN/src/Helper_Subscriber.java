
public class Helper_Subscriber {

    public static void addSubscriber(Data_Store ds, String[] args) {
        String str =null, city=null, state=null, zip=null, name=null, email=null;
        String phone=null,tw=" ", fb=" ";
        
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){
                case "-n":  name=args[++i];
                            for(;;){
                                if(i<args.length-1){
                                    if(Validator.isCommand(args[i+1]))
                                        break;
                                    else
                                        name+=" "+args[++i];
                                }
                                else
                                    break;                            
                            }
                            break;
                case "-e":  email = args[++i];
                            break;
                case "-a":  str = args[++i];
                            for(;;){
                                if(i<args.length-1){
                                    if(Validator.isCommand(args[i+1]))
                                        break;
                                    else
                                        str+=" "+args[++i];
                                }
                                else
                                    break;                            
                            }
                            break;
                case "-c":  city = args[++i];
                            break;
                case "-s":  state = args[++i];
                            break;
                case "-z":  zip = args[++i];
                            break;
                case "-h":  phone = args[++i];
                            for(;;){
                                if(i<args.length-1){
                                    if(Validator.isCommand(args[i+1]))
                                        break;
                                    else
                                        phone+=" "+args[++i];
                                }
                                else
                                    break;                            
                            }
                            break;
                case "-f":  fb = args[++i];
                            break;
                case "-t":  tw = args[++i];
                            break;
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            }
        }
        AddSubscriberRequest a = new AddSubscriber(str, city, state, zip, name, email, phone, tw, fb);
        ObjectResponse r = a.addAccount(ds);
        r.printResponse(); 
    }
   
    public static void viewSubscriber(Data_Store ds, String[] args) {
        String uid=null;
        if(args.length > 3){
            if("-uid".equals(args[2].toLowerCase()))
                uid = args[3];
            else{
                System.out.println("Error: Cannot recognize ["+args[2]+"] command");
                System.exit(0);
            }
            ViewSubscriberRequest a = new ViewSubscriber(uid);
            ObjectResponse r = a.viewAccount(ds);
            r.printResponse();
        }
        else{          
            System.out.println("Error: Invalid command");
            System.exit(0);
        }
    }
    public static void modifySubscriber(Data_Store ds, String[] args) {
        
        String uid = null, name=null, email=null, phone=null,tw=null, fb=null;
        
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){
                case "-uid":uid = args[++i];
                            break;                            
                case "-n":  name=args[++i];
                            for(;;){
                                if(i<args.length-1){
                                    if(Validator.isCommand(args[i+1]))
                                        break;
                                    else
                                        name+=" "+args[++i];
                                }
                                else
                                    break;                            
                            }
                            break;
                case "-e":  email = args[++i];
                            break;
                case "-h":  phone = args[++i];
                            for(;;){
                                if(i<args.length-1){
                                    if(Validator.isCommand(args[i+1]))
                                        break;
                                    else
                                        phone+=" "+args[++i];
                                }
                                else
                                    break;                            
                            }
                            break;
                case "-f":  fb = args[++i];
                            break;
                case "-t":  tw = args[++i];
                            break;
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            } //end of switch           
        }//end of for
        ModifySubscriberRequest a = new ModifySubscriber(uid,name, email, phone, tw, fb);
        ObjectResponse r = a.modifyAccount(ds);
        r.printResponse();
    }

    public static void loadSubscriber(Data_Store ds, String[] args) {
        String filename=null;
        if(args.length > 3){
            if("-f".equals(args[2].toLowerCase())){
                filename =args[3];
            }
            else{
                System.out.println("Error: Cannot recognize ["+args[2]+"] command");
                System.exit(0);
            }
            LoadSubscriberRequest a = new LoadSubscriber(filename);
            ObjectResponse r = a.loadAccount(ds);
            r.printResponse();
        }
        else{          
            System.out.println("Error: Missing values in function argument");
            System.exit(0);
        }
    }
    public static void changeWineMix(Data_Store ds, String[] args){
        String subid=null, type=null;
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){
                case "-uid": subid = args[++i];
                            break;                            
                case "-wt":  type=args[++i];
                            break;                
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            } //end of switch           
        }//end of for
        ChangeWinePreferenceRequest a = new ChangeWinePreference(subid, type);
        ObjectResponse r = a.changeWinePreference(ds);
        r.printResponse();
    }
    public static void searchAccount(Data_Store ds, String[] args){
        String subid=null, type=null;
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){
                case "-uid": subid = args[++i];
                            break;                            
                case "-wt":  type=args[++i];
                            break;                
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            } //end of switch           
        }//end of for
        SearchSubscriberRequest a = new SearchSubscriber(subid, type);
        ObjectResponse r = a.searchAccount(ds);
        r.printResponse();
    }
}
