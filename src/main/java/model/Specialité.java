package model;

public class Specialité {

	private String id;
	private String name;
	private String departement_id;

	// Getter Methods

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDepartement_id() {
		return departement_id;
	}

	// Setter Methods

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartement_id(String departement_id) {
		this.departement_id = departement_id;
	}

}
