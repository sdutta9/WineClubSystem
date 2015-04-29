
public abstract class ViewReceiptRequest {
    String receipt_id;
    public ViewReceiptRequest(String recid) {
        this.receipt_id = recid;
    }

    public abstract ObjectResponse viewReceipt(Data_Store ds);
}
