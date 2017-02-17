package fr.humanbooster.fx.enquetes.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Human Booster on 17/02/2017.
 */
@WebServlet(name = "AddEnquete")
public class AddQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //recupère toutes les enquêtes et les fait apparaitre
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*EnqueteService es = new EnqueteServiceImpl();
        List<Enquete> enquetes = es.getAllEnquete();
        request.setParameter("enquetes", enquetes)*/
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
