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

public class servletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private databasePassingDAO databaseDAO;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	//simple send and save to mysql
	
	public void init() throws ServletException{
		databaseDAO = new databasePassingDAO();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}
	/**
	 * this doGet goes to a two system servlet mapping
	 * by accessing listView it allows for servlet to retrieve data from mysql
	 * and listing them to html while giving the user the ability to delete
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/listView":
                	listView(request, response);
                    break;
                case "/delete":
                    deleteList(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
    
    private void listView(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
		try {
			List < databasePassing > listData = databaseDAO.list();
	        request.setAttribute("listData", listData);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("deleteList.jsp");
	        dispatcher.forward(request, response);
		}catch(HibernateException e) {
			throw new ServletException("Cannot Retrieve database", e);
		}
    }
	
    private void deleteList(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException {
    	        int id = Integer.parseInt(request.getParameter("id"));
    	        databaseDAO.deleteList(id);
    	        response.sendRedirect("http://localhost:8080/CEN-4025C-Module-7/");
    	    }
}
