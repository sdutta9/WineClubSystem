
import java.util.ArrayList;
public class NoShipList {
    private ArrayList<String> noShipLst;

    public NoShipList() {
        noShipLst =new ArrayList<String>();
        noShipLst.add("alabama");
        noShipLst.add("arkansas");
        noShipLst.add("delaware");
        noShipLst.add("kentuky");
        noShipLst.add("massachusetts");
        noShipLst.add("mississippi");
        noShipLst.add("oklahoma");
        noShipLst.add("pensilvania");
        noShipLst.add("south dakota");
        noShipLst.add("utah");  
    }
    
    public boolean checkState(String state){
        return noShipLst.contains(state.toLowerCase());
    }
}
