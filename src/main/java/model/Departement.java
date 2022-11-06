package model;

public class Departement {

	private String id;
	 private String name;
	 private String faculté_id;


	 // Getter Methods 

	 public String getId() {
	  return id;
	 }

	 public String getName() {
	  return name;
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

	 public void setFaculté_id(String faculté_id) {
	  this.faculté_id = faculté_id;
	 }
	
}
