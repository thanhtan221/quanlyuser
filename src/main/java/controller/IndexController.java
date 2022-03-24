package controller;

import dao.UserDAO;
import model.Role;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/")
public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("signIn.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html/charset=UTF-8");
        try {
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            UserDAO userDAO = new UserDAO();
            User user = userDAO.checkloginuser(name, password);
            if (user == null) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("signIn.jsp");
                dispatcher.forward(req, resp);
            } if (user !=null && user.getRole()== Role.ADMIN){
                resp.sendRedirect("/user");
            }else {
                resp.sendRedirect("/product");
            }
        } catch (Exception e) {

        }
    }
}
