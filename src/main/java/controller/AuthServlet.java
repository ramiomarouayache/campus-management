package controller;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GestionnaireDao;
import dao.GestionnaireDaoImpl;
import model.Gestionnare;
import utils.Callback;

/**
 * Servlet implementation class StudentManagerServlet
 */
public class AuthServlet extends HttpServlet {
	private GestionnaireDao gestionnaireDaoImpl;
	public static HttpSession session = null;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthServlet() {
		gestionnaireDaoImpl = new GestionnaireDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			var path = request.getServletPath();
			System.out.println(path);
			switch (path) {
				case "/" -> {
					if (AuthServlet.session!=null) {
						request.getRequestDispatcher("template/index.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("template/login.jsp").forward(request, response);
					}
				}
				case "/login" -> {
					if (AuthServlet.session!=null) {
						request.getRequestDispatcher("template/index.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("template/login.jsp").forward(request, response);
					}
				}
				case "/logout" -> {
					request.getSession().removeAttribute("name");
					request.getSession().invalidate();
					session=null;
					request.getRequestDispatcher("template/login.jsp").forward(request, response);
				}
				default -> {
					// LOGGER.trace("AuthApiServlet request not available : {}", path);
					// WebGuiServletHelper.respondNotFound(req, resp);
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String path = request.getServletPath();
			switch (path) {
			case "/auth" -> {
				String emailParameter = request.getParameter("email");
				String passParameter = request.getParameter("password");
				gestionnaireDaoImpl.login(emailParameter, passParameter, new Callback<Gestionnare>() {

					@Override
					public void onSuccess(Gestionnare data) {
						session = request.getSession();
						session.setAttribute("id", data);
						try {
							request.getRequestDispatcher("template/index.jsp").forward(request, response);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("gestionnaire login successfully...");
					}

					@Override
					public void onFailure(String message, Exception exception) {
						System.out.println(message);
						exception.printStackTrace();
					}
				});
				// response.addCookie(new Cookie("email",emailParameter));
				// response.sendRedirect("template/index.jsp");
			}
			default -> {
				// LOGGER.trace("AuthApiServlet request not available : {}", path);
				// WebGuiServletHelper.respondNotFound(req, resp);
			}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
