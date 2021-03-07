package Module_7;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

/**
 * @author Jancarlo Sevilla
 * Servlet implementation class serverControl
 */

public class serverControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private databasePassingDAO databaseDAO;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	//simple view of mysql
	
	public void init() throws ServletException{
		databaseDAO = new databasePassingDAO();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}
	/**
	 * This doGet essentially retrieves the list taken from databaseDAO places its attribute and forward it to html
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List < databasePassing > listData = databaseDAO.list();
	        request.setAttribute("listData", listData);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("viewList.jsp");
	        dispatcher.forward(request, response);
		}catch(HibernateException e) {
			throw new ServletException("Cannot Retrieve database", e);
		}
		
	}

}
