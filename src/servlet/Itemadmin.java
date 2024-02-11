package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
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
        LocalDateTime addedDate = LocalDateTime.now();
        LocalDateTime updateDate = LocalDateTime.now();

        ItemDAO dao = new ItemDAO();
        String result = dao.insertItem(productName, price, stock, featuredProducts, description, imageUrl, productType, newItem);

        if (result != null) {
            response.sendRedirect("item-list.jsp"); // or another success page
        } else {
            response.sendRedirect("error.jsp"); // or another error handling page
        }
    }
}
