package servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDAO;
import model.Item;

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
	    request.setCharacterEncoding("UTF-8");
	    
	    // フォームからの情報を取得
	    String productName = request.getParameter("productName");
	    int price = Integer.parseInt(request.getParameter("price"));
	    int stock = Integer.parseInt(request.getParameter("stock"));
	    String description = request.getParameter("description");
	    String imageUrl = request.getParameter("image_url");
	    int productType = Integer.parseInt(request.getParameter("productType"));
	    int newItem = Integer.parseInt(request.getParameter("new_item"));
	    int featuredProducts = Integer.parseInt(request.getParameter("featuredProducts"));
	    
	    // Itemオブジェクトの作成
	    Item item = new Item(0, productName, price, stock, description, imageUrl, productType, newItem, featuredProducts, LocalDateTime.now(), LocalDateTime.now());
	    
	    // DAOを使用してデータベースに商品を登録
	    ItemDAO dao = new ItemDAO();
	    boolean result = dao.insertItem1(item);
	    
	    if (result) {
	        // 登録成功時の処理
	        response.sendRedirect("itemList");
	    } else {
	        // 登録失敗時の処理
	        request.setAttribute("errorMessage", "商品の登録に失敗しました。");
	        request.getRequestDispatcher("/errorPage").forward(request, response);
	    }
	}
}