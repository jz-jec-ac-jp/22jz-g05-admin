package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PurchaseHistoryDAO;
import model.Ph;

/**
 * Servlet implementation class Itemadmin
 */
@WebServlet("/Orderadmin")
public class Orderadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // フォワード先のJSPのパスを指定
	    String forward = "/WEB-INF/jsp/order-admin.jsp"; 

	    PurchaseHistoryDAO phDAO = new PurchaseHistoryDAO();
	    List<Ph> ph = phDAO.get();
	
	    request.setAttribute("ph", ph);
	    // フォワードを行う
	    RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
	    dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
