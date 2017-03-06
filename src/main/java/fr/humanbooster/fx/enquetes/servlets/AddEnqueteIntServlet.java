package fr.humanbooster.fx.enquetes.servlets;

import fr.humanbooster.fx.enquetes.business.Departement;
import fr.humanbooster.fx.enquetes.business.Fait;
import fr.humanbooster.fx.enquetes.business.SiteInt;
import fr.humanbooster.fx.enquetes.service.DepartementService;
import fr.humanbooster.fx.enquetes.service.EnqueteService;
import fr.humanbooster.fx.enquetes.service.FaitService;
import fr.humanbooster.fx.enquetes.service.SiteIntService;
import fr.humanbooster.fx.enquetes.service.impl.DepartementImpl;
import fr.humanbooster.fx.enquetes.service.impl.EnqueteServiceImpl;
import fr.humanbooster.fx.enquetes.service.impl.FaitServiceImpl;
import fr.humanbooster.fx.enquetes.service.impl.SiteIntServiceImpl;

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
        response.sendRedirect("index.jsp");
    }

    //recupère toutes les enquêtes et les fait apparaitre
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SiteIntService ss = new SiteIntServiceImpl();
        FaitService fs = new FaitServiceImpl();
        DepartementService ds = new DepartementImpl();
        List<Fait> faits =  fs.recupereFait();
        List<Departement> departements = ds.recupereDepartement();
        List<SiteInt> sites = ss.recupereSiteInt();

        request.setAttribute("faits", faits);
        request.setAttribute("sites", sites);
        request.setAttribute("departements", departements);
        request.getRequestDispatcher("addint.jsp").forward(request,response);
    }
}
