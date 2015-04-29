
public class AW extends MonthlySelection implements java.io.Serializable {

    public AW() {
        super.mst = MonthlySelectionType.AW;
    }
    public AW(String ym,int aid){   // Must be in the yyyy-mm format
        super(ym,aid);
        super.mst = MonthlySelectionType.AW;
    }
    @Override
    void addWine(Wine w) {
            // Make sure only white wines are added
        if(w.getVariety() == WineVariety.WHITE)
            ms.add(w);
    }
}
