/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.ServiceNature;

/**
 *
 * @author Hachem
 */
public class Nature extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/nature.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();

        String idNature = request.getParameter("id");
        entity.Nature nature = ServiceNature.find(Integer.parseInt(idNature));
        //--------------------------------------------------------
        request.setAttribute("nature", nature);
        
        application.getRequestDispatcher(pageweb).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        application = request.getServletContext();
        //--------------------------------------------------------
        String idNature = request.getParameter("id");
        entity.Nature nature = ServiceNature.find(Integer.parseInt(idNature));
        //--------------------------------------------------------

        //--------------------------------------------------------
        String nameNature = request.getParameter("nameNature");
        String color = request.getParameter("color");
        //--------------------------------------------------------
        String updateNature = request.getParameter("updateNature");
        //--------------------------------------------------------
        if (updateNature != null) {

            nature.setName(nameNature);
            ServiceNature.edit(nature);
        }

        response.sendRedirect(application.getContextPath() + "/Nature?id=" + nature.getId());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
