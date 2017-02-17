package fr.humanbooster.fx.enquetes.servlets;

import fr.humanbooster.fx.enquetes.Service.EnqueteService;
import fr.humanbooster.fx.enquetes.ServiceImpl.EnqueteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Human Booster on 17/02/2017.
 */
@WebServlet(name = "AddEnqueteTel")
public class AddEnqueteTelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EnqueteService es = new EnqueteServiceImpl();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String string = request.getParameter("date");
        Date date = null;
        try{
            date = sdf.parse(string);
        }catch (ParseException e){
            e.printStackTrace();
        }
        es.createEnquete(request.getParameter("name"),
                Float.parseFloat(request.getParameter("prix")),
                date,
                request.getParameter("accroche"));
    }

    //recupère toutes les enquêtes et les fait apparaitre
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("addtel.jsp");
    }
}
