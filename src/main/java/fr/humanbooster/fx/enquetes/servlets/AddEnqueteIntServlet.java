package fr.humanbooster.fx.enquetes.servlets;

import fr.humanbooster.fx.enquetes.Service.EnqueteService;
import fr.humanbooster.fx.enquetes.Service.SiteIntService;
import fr.humanbooster.fx.enquetes.ServiceImpl.EnqueteServiceImpl;
import fr.humanbooster.fx.enquetes.ServiceImpl.SiteIntServiceImpl;
import fr.humanbooster.fx.enquetes.business.SiteInt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Human Booster on 17/02/2017.
 */
public class AddEnqueteIntServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EnqueteService es = new EnqueteServiceImpl();
        SiteIntService ss = new SiteIntServiceImpl();

        int idSite = Integer.parseInt(request.getParameter("idSite"));
        List<SiteInt> sites = new ArrayList<>();
        sites.add(ss.recupereSiteInt(idSite));

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
                sites);
    }

    //recupère toutes les enquêtes et les fait apparaitre
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EnqueteService es = new EnqueteServiceImpl();
        es.recupereEnquetes();
        response.sendRedirect("addint.jsp");
    }
}
