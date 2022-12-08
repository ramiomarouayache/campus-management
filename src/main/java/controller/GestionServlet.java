package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EtudiantDao;
import dao.EtudiantDaoImpl;
import model.Etudiant;
import utils.Callback;

/**
 * Servlet implementation class Servlet
 */

public class GestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EtudiantDao etudiantDaoImpl;
	private ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();

	/**
	 * Default constructor.
	 */
	public GestionServlet() {
		// TODO Auto-generated constructor stub
		etudiantDaoImpl = new EtudiantDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			var path = request.getServletPath();
			//System.out.println(request.getSession(false).getAttribute("name").toString());
			switch (path) {
			case "/modifier" -> {
				if (AuthServlet.session!=null) {
					Long matriculeParameter = Long.parseLong(request.getParameter("matricule"));
					System.out.println(matriculeParameter);
					etudiantDaoImpl.getStudentByMatricule(matriculeParameter, new Callback<Etudiant>() {
						@Override
						public void onSuccess(Etudiant data) {
							//etudiants.add(data);
							request.setAttribute("data", data);
							try {
								request.getRequestDispatcher("template/update_student.jsp").forward(request, response);
							} catch (ServletException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						@Override
						public void onFailure(String message, Exception e) {
							// handle failure
						}
					});
					etudiants.clear();
				} else {
					request.getRequestDispatcher("template/login.jsp").forward(request, response);
				}
			}case "/list_students" -> {
				if (AuthServlet.session!=null) {
					etudiantDaoImpl.getAllStudents(new Callback<ArrayList<Etudiant>>() {
						@Override
						public void onSuccess(ArrayList<Etudiant> data) {
							System.out.println(data.get(0).toString());
							request.setAttribute("data", data);
							try {
								request.getRequestDispatcher("template/list_students.jsp").forward(request, response);
							} catch (ServletException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

						@Override
						public void onFailure(String message, Exception exception) {
							// TODO Auto-generated method stub
							
						}
					});
				} else {
					request.getRequestDispatcher("template/login.jsp").forward(request, response);
				}
				//etudiants = getAllStudents(request, response);
			}
			case "/add_student" -> {
				if (AuthServlet.session!=null) {
					request.getRequestDispatcher("template/create_student.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("template/login.jsp").forward(request, response);
				}
			}
			default -> {
				// LOGGER.trace("AuthApiServlet request not available : {}", path);
				// WebGuiServletHelper.respondNotFound(req, resp);
			}
			}
		} catch (

		ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * Long matriculeParameter = 0L; String nomParameter = null; String
		 * prenomParameter = null; String emailParameter = null; String sexeParameter =
		 * null; Date birthParameter = null; String prenomPereParameter = null; String
		 * nomMereParameter = null; String prenomMereParameter = null; int
		 * faculteParameter = 0; int departementParameter = 0; int specialiteParameter =
		 * 0; String niveauParameter = null; String formationParameter = null; int
		 * lastInscriptionParameter = 0;
		 */
		try {
			String path = request.getServletPath();
			switch (path) {
			case "/post_student" -> {
				AddStudent(request, response);
				request.setAttribute("info", "Student... added successfully");
				request.getRequestDispatcher("template/add_student.jsp").forward(request, response);
			}
			default -> {
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// request.getSession().invalidate();
	}

	private Boolean updateStudent(HttpServletRequest request, HttpServletResponse response, Long matricule,
			Etudiant etudiant) throws SQLException, IOException, ServletException {
		return etudiantDaoImpl.updateStudent(etudiant);
	}

	private Boolean AddStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ParseException {
		Etudiant etudiant = new Etudiant();
		etudiant.setMatricule(Long.parseLong(request.getParameter("matricule")));
		etudiant.setNom(request.getParameter("nom"));
		etudiant.setPrenom(request.getParameter("prenom"));
		etudiant.setEmail(request.getParameter("email"));
		etudiant.setSexe(request.getParameter("sexe"));
		etudiant.setBirth_date((Date) new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birth_date")));
		etudiant.setPrenom_pere(request.getParameter("prenom_pere"));
		etudiant.setNom_mere(request.getParameter("nom_mere"));
		etudiant.setPrenom_mere(request.getParameter("prenom_mere"));
		etudiant.setFaculté_id(Integer.parseInt(request.getParameter("faculté_id")));
		etudiant.setDepartement_id(Integer.parseInt(request.getParameter("departement_id")));
		etudiant.setSpecialite_id(Integer.parseInt(request.getParameter("specialité_id")));
		etudiant.setNiveau(request.getParameter("niveau"));
		etudiant.setFormation(request.getParameter("formation"));
		etudiant.setDerniere_inscription(Integer.parseInt(request.getParameter("derniere_inscription")));
		return etudiantDaoImpl.addStudent(etudiant);
	}
	

	/*
	 * private Boolean isSessionValid(HttpServletRequest request) { HttpSession
	 * session = request.getSession(false); return session != null; }
	 */

}
