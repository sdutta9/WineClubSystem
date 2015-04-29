
public class RW extends MonthlySelection implements java.io.Serializable{

    public RW() {
        super.mst = MonthlySelectionType.RW;
    }
    public RW(String ym,int aid){   // Must be in the yyyy-mm format
        super(ym,aid);
        super.mst = MonthlySelectionType.RW;
    }
    @Override
    void addWine(Wine w) {
        // Make sure all kind of wines are added
        ms.add(w);
    } 
}
