package fr.humanbooster.fx.enquetes.servlets;

import fr.humanbooster.fx.enquetes.Service.EnqueteService;
import fr.humanbooster.fx.enquetes.business.Enquete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Human Booster on 17/02/2017.
 */
@WebServlet(name = "Enquete")
public class EnqueteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //recupère toutes les enquêtes et les fait apparaitre
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EnqueteService es = null;//new EnqueteServiceImpl();
        List<Enquete> enquetes = es.recupereEnquetes();
        request.setAttribute("enquetes", enquetes);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
