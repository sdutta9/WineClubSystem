
public class Helper_Admin {

    public static void addAdmin(Data_Store ds, String[] args) {
        String name=null;               
        if(args.length>3){
            if("-n".equals(args[2].toLowerCase())){
                int i =2;
                name=args[++i];
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
                AddAdminRequest a = new AddAdmin(name);
                ObjectResponse r = a.addAdmin(ds);
                r.printResponse(); 
            }
            else{          
                System.out.println("Error: Cannot recognize ["+args[2]+"] command");
                System.exit(0);
            }
        }
        else{          
            System.out.println("Error: Invalid command");
            System.exit(0);
        }
        
    }

    public static void modifyAdmin(Data_Store ds, String[] args) {
        String aid = null, name = null;
        
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){
                case "-aid":aid =args[++i];
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
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            } //end of switch           
        }//end of for
        ModifyAdminRequest a = new ModifyAdmin(aid,name);
        ObjectResponse r = a.modifyAdmin(ds);
        r.printResponse();
    }

    public static void viewAdmin(Data_Store ds, String[] args) {
        String aid = null;
        if(args.length > 3){
            if("-aid".equals(args[2].toLowerCase()))
                aid =args[3];
            else{
                System.out.println("Error: Cannot recognize ["+args[2]+"] command");
                System.exit(0);
            }
            ViewAdminRequest a = new ViewAdmin(aid);
            ObjectResponse r = a.viewAdmin(ds);
            r.printResponse();
        }
        else{          
            System.out.println("Error: Invalid command");
            System.exit(0);
        }
    }

    public static void addMonthlySelection(Data_Store ds, String[] args) {
        
        String aid=null, type=null, ymonth = null,filename = null;
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){
                case "-aid":aid =args[++i];
                            break;                            
                case "-wt": type=args[++i];
                            break;
                case "-ym":  ymonth = args[++i];
                            break;
                case "-f":  filename = args[++i];
                            break;
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            } //end of switch           
        }//end of for
        AddMonthlySelectionRequest a = new AddMonthlySelection(aid, type, ymonth, filename);
        ObjectResponse r = a.addMonthlySelection(ds);
        r.printResponse();
    }

    public static void viewMonthlySelection(Data_Store ds, String[] args) {
        
        String mid=null;
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){                           
                case "-id":  mid=args[++i];
                            break;
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            } //end of switch           
        }//end of for
        ViewMonthlySelectionRequest a = new ViewMonthlySelection(mid);
        ObjectResponse r = a.viewMonthlySelection(ds);
        r.printResponse();
    }
    public static void viewRevenue(Data_Store ds, String[] args) {
        
        String sdt=null, edt=null;
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){                         
                case "-s":      sdt = args[++i];
                                break;
                case "-e":      edt = args[++i];
                                break;
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            } //end of switch           
        }//end of for
        ViewRevenueRequest a = new ViewRevenue(sdt, edt);
        ObjectResponse r = a.viewRevenue(ds);
        r.printResponse();
    }
}

