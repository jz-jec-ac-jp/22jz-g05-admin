package servlet;

import java.io.IOException;
import java.time.LocalDateTime; // 必要に応じてインポート

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDAO;
import model.Item;

@WebServlet("/ItemUpdate")
public class ItemUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text.html; charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/update.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    
	    System.out.println(request.getParameter("productName"));
	    System.out.println(request.getParameter("price"));
	    System.out.println(request.getParameter("stock"));
	    System.out.println(request.getParameter("description"));
	    System.out.println(request.getParameter("productType"));
	    System.out.println(request.getParameter("productImage"));
	    System.out.println(request.getParameter("featuredProducts"));
	    // フォームからの情報を取得
	    String productName = request.getParameter("productName");
	    int price = Integer.parseInt(request.getParameter("price"));
	    int stock = Integer.parseInt(request.getParameter("stock"));
	    String description = request.getParameter("description");
	    String imageUrl = request.getParameter("productImage");
	    int productType = Integer.parseInt(request.getParameter("productType"));
	    int newItem = Integer.parseInt(request.getParameter("new_item"));
	    int featuredProducts = Integer.parseInt(request.getParameter("featuredProducts"));
	    
        // Itemオブジェクトの作成
        Item item = new Item(0,productName, price, stock, description, imageUrl, productType, newItem, featuredProducts, LocalDateTime.now(), LocalDateTime.now());

        // DAOを使用して商品情報を更新
        ItemDAO dao = new ItemDAO();
        boolean result = dao.updateItem(item);

        if (result) {
            // 更新成功時の処理（例: 商品一覧ページへリダイレクト）
            response.sendRedirect("itemList.jsp");
        } else {
            // 更新失敗時の処理（例: エラーページへリダイレクト）
            response.sendRedirect("error.jsp");
        }
    }
}
