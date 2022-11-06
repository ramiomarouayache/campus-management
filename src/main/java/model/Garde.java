package model;


//@Entity
//@Table(name = "garde")
public class Garde {

	private String id;
	private String name;
	private String prenom;
	private String email;
	private String password;
	private String faculté_id;

	// Getter Methods

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getFaculté_id() {
		return faculté_id;
	}

	// Setter Methods

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFaculté_id(String faculté_id) {
		this.faculté_id = faculté_id;
	}

}
