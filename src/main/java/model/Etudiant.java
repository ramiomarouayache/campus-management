package model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="etudiant")
public class Etudiant implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy = GenerationType.)
	private Long matricule;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "email")
	private String email;
	@Column(name = "sexe")
	private String sexe;
	@Column(name = "birth_date")
	private Date birth_date;
	@Column(name = "prenom_pere")
	private String prenom_pere;
	@Column(name = "nom_mere")
	private String nom_mere;
	@Column(name = "prenom_mere")
	private String prenom_mere;
	@Column(name = "derniere_inscription")
	private int derniere_inscription;
	@Column(name = "faculté_id")
	private int faculté_id;
	@Column(name = "departement_id")
	private int departement_id;
	@Column(name = "specialite_id")
	private int specialite_id;
	@Column(name = "niveau")
	private String niveau;
	@Column(name = "formation")
	private String formation;

// Getter Methods

	public Long getMatricule() {
		return matricule;
	}

	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public String getSexe() {
		return sexe;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public String getPrenom_pere() {
		return prenom_pere;
	}

	public String getNom_mere() {
		return nom_mere;
	}
	
	public String getPrenom_mere() {
		return prenom_mere;
	}

	public int getDerniere_inscription() {
		return derniere_inscription;
	}

	public int getFaculté_id() {
		return faculté_id;
	}

	public int getDepartement_id() {
		return departement_id;
	}

	public int getSpecialite_id() {
		return specialite_id;
	}

	public String getNiveau() {
		return niveau;
	}

	public String getFormation() {
		return formation;
	}

	// Setter Methods

	public void setMatricule(Long matricule) {
		this.matricule = matricule;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public void setBirth_date(Date date) {
		this.birth_date = date;
	}

	public void setPrenom_pere(String prenom_pere) {
		this.prenom_pere = prenom_pere;
	}

	public void setNom_mere(String nom_mere) {
		this.nom_mere = nom_mere;
	}
	
	public void setPrenom_mere(String prenom_mere) {
		this.prenom_mere = prenom_mere;
	}

	public void setDerniere_inscription(int derniere_inscription) {
		this.derniere_inscription = derniere_inscription;
	}

	public void setFaculté_id(int i) {
		this.faculté_id = i;
	}

	public void setDepartement_id(int departement_id) {
		this.departement_id = departement_id;
	}

	public void setSpecialite_id(int specialite_id) {
		this.specialite_id = specialite_id;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

}
