package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDAO;

/**
 * Servlet implementation class ItemInfo
 */
@WebServlet("/ItemInfo")
public class ItemInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		ItemDAO itemDAO = new ItemDAO();
//		reqest.setAttribute("list",list);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text.html; charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/item-info-admin.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text.html; charset=UTF-8");
		
		String productName = request.getParameter("productName");
		String productCode = request.getParameter("productCode");
		int price = Integer.parseInt(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int featuredProducts = Integer.parseInt(request.getParameter("featuredProducts"));
//		String price = request.getParameter("price");
//		String stock = request.getParameter("stockQuantity");
//		String FEATURED_PRODUCTS = request.getParameter("FEATURED_PRODUCTS");
		String description = request.getParameter("description");
		String size = request.getParameter("size");
		String color = request.getParameter("color");
		String image_url = request.getParameter("image_url");
		int productType = Integer.parseInt(request.getParameter("productType"));
//		String PRODUCT_TYPE = request.getParameter("PRODUCT_TYPE");
		int new_item = Integer.parseInt(request.getParameter("new_item"));
		
		
        
        
        
		
		System.out.println("stock : " + stock);
		System.out.println("color : " + color);
		
		ItemDAO item = new ItemDAO();
		item.insertItem(image_url,productName,description,price,productType,stock,new_item,featuredProducts);
//		item.set(productName,productCode,price,stock,FEATURED_PRODUCTS,description,size,color,image_url, PRODUCT_TYPE, new_item);
		
		response.sendRedirect("Itemadmin");
	}

}
