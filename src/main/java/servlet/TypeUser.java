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
import service.ServiceTypeUser;

/**
 *
 * @author Hachem
 */
public class TypeUser extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/typeUser.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();

        String idTypeUser = request.getParameter("id");
        entity.TypeUser typeUser = ServiceTypeUser.find(Integer.parseInt(idTypeUser));
        //--------------------------------------------------------
        request.setAttribute("typeUser", typeUser);
        application.getRequestDispatcher(pageweb).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        application = request.getServletContext();
        //--------------------------------------------------------
        String idTypeUser = request.getParameter("id");
        entity.TypeUser typeUser = ServiceTypeUser.find(Integer.parseInt(idTypeUser));
        //--------------------------------------------------------
        String nameTypeUser = request.getParameter("nameTypeUser");
        //--------------------------------------------------------
        String updateTypeUser = request.getParameter("updateTypeUser");
        //--------------------------------------------------------
        if (updateTypeUser != null) {

            typeUser.setName(nameTypeUser);
            ServiceTypeUser.edit(typeUser);
        }
        //--------------------------------------------------------
        response.sendRedirect(application.getContextPath() + "/TypeUser?id=" + typeUser.getId());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
