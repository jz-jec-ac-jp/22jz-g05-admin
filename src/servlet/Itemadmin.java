package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDAO;
import model.Item;

@WebServlet("/Itemadmin")
public class Itemadmin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "/WEB-INF/jsp/item-admin.jsp";
        ItemDAO dao = new ItemDAO();
        List<Item> list = dao.get();
        request.setAttribute("item_list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        
        if ("insert".equals(action)) {
            insertItem(request, response);
        }
    }

    private void insertItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String imageUrl = request.getParameter("imageUrl");
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        int productType = Integer.parseInt(request.getParameter("productType"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int newItem = Integer.parseInt(request.getParameter("newItem"));
        int featuredProducts = Integer.parseInt(request.getParameter("featuredProducts"));

        // Itemオブジェクトの作成
        Item item = new Item(0, productName, price, stock, description, imageUrl, productType, newItem, featuredProducts, null, null); // addedDateとupdateDateはDBで自動生成されることを想定

        ItemDAO dao = new ItemDAO();
        // 正しいメソッド名を使用
        boolean result = dao.insertItem1(item);

        if (result) {
            response.sendRedirect("Itemadmin"); // 成功した場合のリダイレクト先を指定
        } else {
            response.sendRedirect("error.jsp"); // エラー時のページ
        }
    }
}
