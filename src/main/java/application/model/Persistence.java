package application.model;

public enum Persistence {
	
	ELING("Eling");
	
	private String persistence;
	
	Persistence(String persist){
		this.persistence = persist;
	}

	public String getPersistence() {
		return persistence;
	}
	

}
