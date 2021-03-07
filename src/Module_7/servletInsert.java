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
 * @Author: Jancarlo Sevilla
 * Servlet implementation class serverControl
 */

public class servletInsert extends HttpServlet {
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
	
	/*
	 * receives the parameters and saves them to mysql while returning you to the index
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String list = request.getParameter("list");
		databasePassing dataList = new databasePassing(list);
		
		try {
			databaseDAO.savelist(dataList);
			response.sendRedirect("http://localhost:8080/CEN-4025C-Module-7/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
