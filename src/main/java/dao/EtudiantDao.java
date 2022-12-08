package dao;

import java.util.ArrayList;

import model.Etudiant;
import utils.Callback;

public interface EtudiantDao {

	public void getStudentByMatricule(Long matricule,Callback<Etudiant> callback);
	public void getStudentByNomEtPrenom(String nom, String prenom,Callback<Etudiant> callback);
	public void getStudentByNom(String nom,Callback<ArrayList<Etudiant>> callback);
	public void getAllStudents(Callback<ArrayList<Etudiant>> callback);
	public Boolean addStudent(Etudiant etudiant);
	public Boolean updateStudent(Etudiant etudiant);
	public Boolean deleteStudent(Long matricule);
}
