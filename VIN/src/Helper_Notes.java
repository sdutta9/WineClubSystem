public class Helper_Notes {
    public static void addNote(Data_Store ds, String[] args) {
        String uid=null, sid=null, wid=null, content=null;
        
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){
                case "-uid":uid = args[++i];
                            break;
                case "-sid":sid = args[++i];
                            break;
                case "-wid":wid = args[++i];
                            break;    
                case "-c":  content = args[++i];
                            for(;;){
                                if(i<args.length-1){
                                    if(Validator.isCommand(args[i+1]))
                                        break;
                                    else
                                        content+=" "+args[++i];
                                }
                                else
                                    break;                            
                            }
                            break;
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            }
        }
        AddNoteRequest a = new AddNote(uid, sid, wid, content);
        ObjectResponse r = a.addNote(ds);
        r.printResponse(); 
    }
    public static void viewNote(Data_Store ds, String[] args) {
        String uid=null, sid=null, wid=null, nid=null;
        
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){
                case "-uid":uid = args[++i];
                            break;
                case "-sid":sid = args[++i];
                            break;
                case "-wid":wid = args[++i];
                            break;    
                case "-nid":nid = args[++i];
                            break;
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            }
        }
        ViewNoteRequest a = new ViewNote(uid, sid, wid, nid);
        ObjectResponse r = a.viewNote(ds);
        r.printResponse(); 
    }
    public static void modifyNote(Data_Store ds, String[] args) {
        String uid=null, nid=null, content=null;
        
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){
                case "-uid":uid = args[++i];
                            break;
                case "-nid":nid = args[++i];
                            break;
                case "-c":  content = args[++i];
                            for(;;){
                                if(i<args.length-1){
                                    if(Validator.isCommand(args[i+1]))
                                        break;
                                    else
                                        content+=" "+args[++i];
                                }
                                else
                                    break;                            
                            }
                            break;
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            }
        }
        ModifyNoteRequest a = new ModifyNote(uid, nid, content);
        ObjectResponse r = a.modifyNote(ds);
        r.printResponse(); 
    }
    public static void deleteNote(Data_Store ds, String[] args) {
        String uid=null, nid=null;
        
        for(int i=2; i<args.length-1;i++){
            switch(args[i].toLowerCase()){
                case "-uid":uid = args[++i];
                            break;
                case "-nid":nid = args[++i];
                            break;
                default:    System.out.println("Error: Cannot recognize ["+args[i]+"] command");
                            System.exit(0);
            }
        }
        DeleteNoteRequest a = new DeleteNote(uid, nid);
        ObjectResponse r = a.deleteNote(ds);
        r.printResponse(); 
    }
    
}
