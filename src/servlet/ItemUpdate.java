package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDAO;

/**
 * Servlet implementation class ItemUpdate
 */
@WebServlet("/ItemUpdate")
public class ItemUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
        String productName = request.getParameter("productName");
		String productCode = request.getParameter("productCode");
		String price = request.getParameter("price");
		String stock = request.getParameter("stockQuantity");
		String FEATURED_PRODUCTS = request.getParameter("FEATURED_PRODUCTS");
		String description = request.getParameter("description");
		String size = request.getParameter("size");
		String color = request.getParameter("color");
		String image_url = request.getParameter("image_url");
		String PRODUCT_TYPE = request.getParameter("PRODUCT_TYPE");
		String new_item = request.getParameter("new_item");
		//
		ItemDAO dao = new ItemDAO();
		dao.updateItem(id ,productName, productCode, price, stock, FEATURED_PRODUCTS, description, size, color, image_url, PRODUCT_TYPE, new_item);

	}

}
