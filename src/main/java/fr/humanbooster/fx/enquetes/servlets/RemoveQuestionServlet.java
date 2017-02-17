package fr.humanbooster.fx.enquetes.servlets;

import fr.humanbooster.fx.enquetes.Service.QuestionService;
import fr.humanbooster.fx.enquetes.ServiceImpl.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Human Booster on 17/02/2017.
 */
@WebServlet(name = "RemoveEnquete")
public class RemoveQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionService qs = new QuestionServiceImpl();
        int id = Integer.parseInt(request.getParameter("idQuestion"));
        qs.suprQuestion(id);
        response.sendRedirect("index.jsp");
    }

    //recupère toutes les enquêtes et les fait apparaitre
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
}
