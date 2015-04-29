
public enum MonthlySelectionType implements java.io.Serializable{
	AW ("All whites"),
	AR ("All reds"),
	RW ("Reds and Whites");
	
	private String description;
        public String getDescription(){     //added
            return this.description;
        }
	private MonthlySelectionType(String ms) {
		this.description = ms;
	}
}
