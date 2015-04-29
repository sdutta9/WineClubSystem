
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class vin {
    public static void main(String[] args) {
        Data_Store datastore =null;
               
	try {
            datastore = restoreDataStoreState(datastore);            
	} catch (IOException e) {
            System.err.println("IOException caught when trying to restore state");
	}
        if(datastore == null)
            datastore = new Data_Store();
        else
            IdGenerator.setID(datastore.lastid);
        if(args.length == 0){
            System.out.println("Error: Please enter a valid command");
            System.exit(0);
        }       
        
        switch(args[0].toLowerCase()){
            case "subscriber":
                switch(args[1].toLowerCase()){
                    case "add": Helper_Subscriber.addSubscriber(datastore, args);
                                break;
                    case "modify":  Helper_Subscriber.modifySubscriber(datastore,args);
                                    break;
                    case "view":    Helper_Subscriber.viewSubscriber(datastore,args);
                                    break;
                    case "load":    Helper_Subscriber.loadSubscriber(datastore, args);
                                    break;
                    case "search":  Helper_Subscriber.searchAccount(datastore, args);
                                    break;
                    case "changemix":  
                                    Helper_Subscriber.changeWineMix(datastore, args);
                                    break;
                    default:
                        System.out.println("Error: Please enter a valid command");
                        System.exit(0); 
                }                
                break;
            case "admin":                
                switch(args[1].toLowerCase()){
                    case "add":     Helper_Admin.addAdmin(datastore,args);
                                    break;
                    case "modify":  Helper_Admin.modifyAdmin(datastore,args);
                                    break;
                    case "view":    Helper_Admin.viewAdmin(datastore,args);
                                    break;
                    case "add_monthly_selection":   //addMonthlySelection.java 
                                    Helper_Admin.addMonthlySelection(datastore,args);
                                    break;
                    case "view_monthly_selection":   //viewMonthlySelection.java
                                    Helper_Admin.viewMonthlySelection(datastore,args);
                                    break;
                    case "revenue": Helper_Admin.viewRevenue(datastore, args);
                                    break;          
                    default:
                        System.out.println("Error: Please enter a valid command");
                        System.exit(0); 
                }        
                break;
            case "shipments":
                switch(args[1].toLowerCase()){
                    case "view":    Helper_Shipment.viewShipment(datastore, args);
                                    break;
                    case "cancel":  Helper_Shipment.cancelShipment(datastore, args);
                                    break;
                    default:
                        System.out.println("Error: Please enter a valid command");
                        System.exit(0); 
                }                
                break;
            case "wines":
                switch(args[1].toLowerCase()){
                    case "view":    Helper_Wine.viewWines(datastore, args);
                                    break;
                    case "rate":    Helper_Wine.rateWine(datastore, args);
                                    break;
                    default:
                        System.out.println("Error: Please enter a valid command");
                        System.exit(0); 
                }                
                break; 
            case "delivery":
                switch(args[1].toLowerCase()){
                    case "view":    Helper_Delivery.viewDeliveryTime(datastore, args);
                                    break;
                    default:
                        System.out.println("Error: Please enter a valid command");
                        System.exit(0); 
                }
                break;    
            
            case "notes":
                 switch(args[1].toLowerCase()){
                    case "add":     Helper_Notes.addNote(datastore, args);
                                    break;
                    case "view":    Helper_Notes.viewNote(datastore, args);
                                    break;
                    case "modify":  Helper_Notes.modifyNote(datastore, args);
                                    break;
                    case "delete":  Helper_Notes.deleteNote(datastore, args);
                                    break;
                    default:
                        System.out.println("Error: Please enter a valid command");
                        System.exit(0); 
                }
                break;
            
            case "partner":
                switch(args[1].toLowerCase()){
                    case "subscriber_list": Helper_Partner.viewSubscriber_list(datastore, args);
                                            break;
                    case "add_receipt":     Helper_Partner.AddReceipt(datastore, args);
                                            break; 
                    case "view_receipt":    Helper_Partner.ViewReceipt(datastore, args);
                                            break;
                    default:
                        System.out.println("Error: Please enter a valid command");
                        System.exit(0);     
                }
                break;
            default:
               System.out.println("Error: Please enter a valid command");
               System.exit(0); 
        }
        
        try {
            datastore.lastid=IdGenerator.getID();
            saveDataStoreState(datastore);
	} catch (IOException e) {
            System.err.println("IOException caught when trying to save state.\n");
	}
        
    }//end of main function
    
    
    public static void saveDataStoreState(Data_Store ds) throws IOException {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {
            fout = new FileOutputStream("../Shouvik_Dutta.ser",false);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(ds);
            
        }catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(oos != null) 
                oos.close();
        }
    }
	
    public static Data_Store restoreDataStoreState(Data_Store ds) throws IOException {
        ObjectInputStream ois = null;
        try {
                FileInputStream fis = new FileInputStream("../Shouvik_Dutta.ser");
                ois = new ObjectInputStream(fis);
                ds=(Data_Store)ois.readObject();
                return ds;
        }catch(IOException e){
                System.err.println("Nothing to restore.");
        } 
        catch(ClassNotFoundException e) {
                System.err.println("ClassNotFoundException caught in restoreClubState()");
        }
        finally{
            if (ois != null)
                ois.close();
        }
        return ds;
    }  
}
