
import java.util.HashSet;

public class Data_Store implements java.io.Serializable{
    public HashSet<Subscriber> subs;
    public HashSet<Admin> adms;
    public HashSet<MonthlySelection> mselections;
    public HashSet<Wine> winelist;
    public HashSet<Shipment> shipments;
    public HashSet<Receipt> receipts;
    public HashSet<Note> notes;
    int lastid;
    Data_Store(){
        lastid =0;
        subs = new HashSet<>();
        adms = new HashSet<>();
        mselections = new HashSet<>(); 
        winelist = new HashSet<>();
        shipments = new HashSet<>();
        receipts = new HashSet<>();
        notes = new HashSet<>();
    }
}
