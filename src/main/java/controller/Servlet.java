package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EtudiantDao;
import model.Etudiant;

/**
 * Servlet implementation class Servlet
 */
//@WebServlet("/campus_mangement/search")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EtudiantDao etudiantDao;
	public ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();

	/**
	 * Default constructor.
	 */
	public Servlet() {
		// TODO Auto-generated constructor stub
		etudiantDao = new EtudiantDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("template/index.jsp").forward(request, response);
		//response.sendRedirect();
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 * response.setContentType("text/html");
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long matriculeParameter=0L;
		try {
			if (request.getParameter("matricule").length()>1) {
				matriculeParameter = Long.parseLong(request.getParameter("matricule"));
			}
			String nomParameter = request.getParameter("nom");
			String prenomParameter = request.getParameter("prenom");
			etudiants = getEtudiant(request, response, matriculeParameter, nomParameter, prenomParameter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("data", etudiants);
		//response.sendRedirect("template/search-result.jsp");
		request.getRequestDispatcher("template/search-result.jsp").forward(request, response);
		etudiants.clear();
		//responseWriter(response);
	}

	private ArrayList<Etudiant> getEtudiant(HttpServletRequest request, HttpServletResponse response, Long matriculeParameter,
			String nomParameter, String prenomParameter) throws SQLException, IOException, ServletException {
		EtudiantDao dao = new EtudiantDao();
		Etudiant etudiant = null ;

		if (!(matriculeParameter == 0L)) {
			etudiant = dao.getStudentByMatricule(matriculeParameter);
			if (etudiant!=null) {
				etudiants.add(etudiant);
			}
		} else if (!(nomParameter.isEmpty()) && !(prenomParameter.isEmpty())) {
			etudiant = dao.getStudentByNomEtPrenom(nomParameter, prenomParameter);
			if (etudiant!=null) {
				etudiants.add(etudiant);
			}
		} else if (nomParameter != null) {
			etudiants = dao.getStudentByNom(nomParameter);
		}
		return etudiants;
	}
	
	private void responseWriter(HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		String htmlRespone = "<html>";
		htmlRespone +="<h2>Resultat : </h2>";
		if (!etudiants.isEmpty()) {
			htmlRespone +="<table class='table'>";
			
			for (int i = 0; i < etudiants.size(); i++) {
				htmlRespone +="<tbody>";
				htmlRespone +="<tr>";
				htmlRespone +="<th></th>";
				htmlRespone +="<td><b>etudiant "+(i+1)+"</b></td>";
				htmlRespone +="</tr>";
				htmlRespone +="<tr>";
				htmlRespone +="<th>Matricule </th>";
				htmlRespone +="<td> "+etudiants.get(i).getMatricule()+"</td>";
				htmlRespone +="</tr>";
				htmlRespone +="<tr>";
				htmlRespone +="<th>Nom </th>";
				htmlRespone +="<td> "+etudiants.get(i).getNom()+"</td>";
				htmlRespone +="</tr>";
				htmlRespone +="<tr>";
				htmlRespone +="<th>Prenom </th>";
				htmlRespone +="<td> "+etudiants.get(i).getPrenom()+"</td>";
				htmlRespone +="</tr>";
				htmlRespone +="<tr>";
				htmlRespone +="<th>Email </th>";
				htmlRespone +="<td> "+etudiants.get(i).getEmail()+"</td>";
				htmlRespone +="</tr>";
				htmlRespone +="<tr>";
				htmlRespone +="<th>Sexe </th>";
				htmlRespone +="<td> "+etudiants.get(i).getSexe()+"</td>";
				htmlRespone +="</tr>";
				htmlRespone +="<tr>";
				htmlRespone +="<th>Date de naissance </th>";
				htmlRespone +="<td> "+etudiants.get(i).getBirth_date()+"</td>";
				htmlRespone +="</tr>";
				htmlRespone +="<tr>";
				htmlRespone +="<th>Prenom de pere </th>";
				htmlRespone +="<td> "+etudiants.get(i).getPrenom_pere()+"</td>";
				htmlRespone +="</tr>";
				htmlRespone +="<tr>";
				htmlRespone +="<th>nom de mere </th>";
				htmlRespone +="<td> "+etudiants.get(i).getNom_mere()+"</td>";
				htmlRespone +="</tr>";
				htmlRespone +="<tr>";
				htmlRespone +="<th>Prenom de mere </th>";
				htmlRespone +="<td> "+etudiants.get(i).getPrenom_mere()+"</td>";
				htmlRespone +="</tr>";
				htmlRespone +="<tr>";
				htmlRespone +="<th>Faculté </th>";
				htmlRespone +="<td> "+etudiants.get(i).getFaculté_id()+"</td>";
				htmlRespone +="</tr>";
				htmlRespone +="<tr>";
				htmlRespone +="<th>Departement </th>";
				htmlRespone +="<td> "+etudiants.get(i).getDepartement_id()+"</td>";
				htmlRespone +="</tr>";
				htmlRespone +="<tr>";
				htmlRespone +="<th>Specialité </th>";
				htmlRespone +="<td> "+etudiants.get(i).getSpecialité_id()+"</td>";
				htmlRespone +="</tr>";
				htmlRespone +="<tr>";
				htmlRespone +="<th>Niveau </th>";
				htmlRespone +="<td> "+etudiants.get(i).getNiveau()+"</td>";
				htmlRespone +="</tr>";
				htmlRespone +="<tr>";
				htmlRespone +="<th>Formation </th>";
				htmlRespone +="<td> "+etudiants.get(i).getFormation()+"</td>";
				htmlRespone +="</tr>";
				htmlRespone +="<tr>";
				htmlRespone +="<th>Dernié inscription </th>";
				htmlRespone +="<td> "+etudiants.get(i).getDerniere_inscription()+"</td>";
				htmlRespone +="</tr>";
				htmlRespone += "</tbody>";
			}
			htmlRespone += "</table>";

			writer.println(htmlRespone);
		} else {
			htmlRespone += "<h4> Aucun étudiant trouvé!!</h4>";

			writer.println(htmlRespone);
		}
		htmlRespone += "</html>";
		etudiants.clear();
	}

}
