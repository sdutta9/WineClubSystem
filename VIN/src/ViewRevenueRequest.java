
public abstract class ViewRevenueRequest {
    String startdt, enddt;
    public ViewRevenueRequest(String startdt, String enddt) {
        this.startdt = startdt;
        this.enddt = enddt;
    }

    public abstract ObjectResponse viewRevenue(Data_Store ds);
}
