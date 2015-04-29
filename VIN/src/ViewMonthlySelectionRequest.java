
public abstract class ViewMonthlySelectionRequest {

    String m_id;
    public ViewMonthlySelectionRequest(String mid) {  
        this.m_id = mid;
    }

    public abstract ObjectResponse viewMonthlySelection(Data_Store ds);
}
