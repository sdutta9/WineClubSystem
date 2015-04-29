public class Helper_Wine {

    public static void viewWines(Data_Store ds, String[] args) {
        String wid=null;
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){                   
                case "-wid":    wid=args[++i];
                                break;
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            } //end of switch           
        }//end of for
        ViewWinesRequest a = new ViewWines(wid);
        ObjectResponse r = a.viewWine(ds);
        r.printResponse();    
    }
    public static void rateWine(Data_Store ds, String[] args) {
        
        String uid = null, wid=null, rating=null;
        
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){
                case "-uid":    uid = args[++i];
                                break;                            
                case "-wid":    wid=args[++i];
                                break;
                case "-r":      rating=args[++i];
                                break;
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            } //end of switch           
        }//end of for
        RankWinesRequest a = new RankWines(uid, wid,rating);
        ObjectResponse r = a.rankWine(ds);
        r.printResponse();
    }
}
