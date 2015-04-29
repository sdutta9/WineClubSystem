public class AR extends MonthlySelection implements java.io.Serializable {

    public AR() {
        super();
        super.mst = MonthlySelectionType.AR;
    }
    public AR(String ym,int aid){   // Must be in the yyyy-mm format
        super(ym,aid);
        super.mst = MonthlySelectionType.AR;
    }
    @Override
    void addWine(Wine w) {
            // Make sure only red and rose wines are added
        if((w.getVariety() == WineVariety.RED)||(w.getVariety() == WineVariety.ROSE))
            ms.add(w);
    }
}
