package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EtudiantDao;
import dao.EtudiantDaoImpl;
import model.Etudiant;
import utils.Callback;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EtudiantDao etudiantDaoImpl;
	private ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
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
			case "/search" -> {
				if (AuthServlet.session!=null) {
					request.getRequestDispatcher("template/index.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("template/login.jsp").forward(request, response);
				}
			}
			default -> {
				// LOGGER.trace("AuthApiServlet request not available : {}", path);
			}
			}
		} catch (ServletException e) {
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
		try {
			String path = request.getServletPath();
			if (AuthServlet.session!=null) {
				switch (path) {
				case "/result" -> {
					Long matriculeParameter = 0L;
					if (request.getParameter("matricule").length() > 1) {
						matriculeParameter = Long.parseLong(request.getParameter("matricule"));
					}
					getSearchResult(matriculeParameter, request.getParameter("nom"),
							request.getParameter("prenom"));
					if (etudiants != null) {
						request.setAttribute("data", etudiants);
						request.getRequestDispatcher("template/search-result.jsp").forward(request, response);
						etudiants.clear();
					} else {
						request.getRequestDispatcher("template/error.jsp").forward(request, response);
					}
				}
				default -> {
				}
				}
			} else {
				request.getRequestDispatcher("template/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getSearchResult(Long matriculeInput, String nomInput, String prenomInput) {
		if (!(matriculeInput == 0L)) {
			etudiantDaoImpl.getStudentByMatricule(matriculeInput, new Callback<Etudiant>() {
				@Override
				public void onSuccess(Etudiant data) {
					etudiants.add(data);
				}

				@Override
				public void onFailure(String message, Exception e) {
					// handle failure
				}
			});
		} else if (!(nomInput.isEmpty()) && !(prenomInput.isEmpty())) {
			etudiantDaoImpl.getStudentByNomEtPrenom(nomInput, prenomInput, new Callback<Etudiant>() {
				@Override
				public void onSuccess(Etudiant data) {
					etudiants.add(data);
				}

				@Override
				public void onFailure(String message, Exception e) {
					// handle retrieve failure
				}
			});
		} else if (nomInput != null) {
			etudiantDaoImpl.getStudentByNom(nomInput, new Callback<ArrayList<Etudiant>>() {

				@Override
				public void onSuccess(ArrayList<Etudiant> data) {
					etudiants = data;
				}

				@Override
				public void onFailure(String message, Exception e) {
					// handle retrieve failure
				}
			});
		}
	}


}
