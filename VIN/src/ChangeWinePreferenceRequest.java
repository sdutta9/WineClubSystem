
public abstract class ChangeWinePreferenceRequest {
    String sub_id;
    String mst;

    public ChangeWinePreferenceRequest(String id, String m) {
            this.sub_id = id;
            this.mst = m;
    }

    public abstract ObjectResponse changeWinePreference(Data_Store ds);
}
