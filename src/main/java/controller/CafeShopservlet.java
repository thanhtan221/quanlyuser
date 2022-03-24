package controller;

import model.CafeShop;
import service.CafeShopService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "cafeshop", value = "/product")
public class CafeShopservlet extends HttpServlet {
    DecimalFormat format = new DecimalFormat("###,###,###" + " đ");

    private CafeShopService cafeShopService = new CafeShopService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "addcaffe":
                    showNewForm(req, resp);
                    break;
                case "edit":
                    showEditForm(req, resp);
                    break;
                default:
                    listCafeShop(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "addcaffe":
                    insertcafeshop(req, resp);
                    break;
                case "edit":
                    updatecafeshop(req, resp);
                case "search":
                    search(req, resp);
                    break;

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCafeShop(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<CafeShop> listcafeshop = cafeShopService.selectAllcafeshop();
        request.setAttribute("listcafeshop", listcafeshop);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/product.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/AddProduct.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CafeShop existingUser = cafeShopService.selectcafeshop(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/EditProduct.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertcafeshop(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String drinks = request.getParameter("drinks");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        CafeShop newcafeshop = new CafeShop(drinks, price, quantity);
        cafeShopService.insertcafeshop(newcafeshop);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/AddProduct.jsp");
        dispatcher.forward(request, response);
    }

    private void updatecafeshop(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String drinks = request.getParameter("drinks");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt((request.getParameter("quantity")));
        CafeShop cafeShop = new CafeShop(id, drinks, price, quantity);
        cafeShopService.updatecafeshop(cafeShop);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/EditProduct.jsp");
        dispatcher.forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("key"));
        CafeShop cafeShop = cafeShopService.selectcafeshop(id);
        List<CafeShop> cafeShops = new ArrayList<>();
        cafeShops.add(cafeShop);
        if (cafeShop == null) {
            request.setAttribute("message", "Không Tìm Thấy drinks Với Id Là : " + id);
            request.setAttribute("listcafeshop", cafeShops);
        } else {
            request.setAttribute("message", "Đã Tìm Thấy drinks Với Id Là:" + id);
            request.setAttribute("listcafeshop", cafeShops);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/product.jsp");
        dispatcher.forward(request, response);

    }

}
