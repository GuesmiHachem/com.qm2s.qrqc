/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.ServiceTypeProblem;

/**
 *
 * @author Hachem
 */
public class TypeProblem extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/typeProblem.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();

        String idTypeProblem = request.getParameter("id");
        entity.TypeProblem typeUser = ServiceTypeProblem.find(Integer.parseInt(idTypeProblem));
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
        String idTypeProblem = request.getParameter("id");
        entity.TypeProblem typeProblem = ServiceTypeProblem.find(Integer.parseInt(idTypeProblem));
        //--------------------------------------------------------
        String nameTypeProblem = request.getParameter("nameTypeProblem");
        String colorTypeProblem = request.getParameter("colorTypeProblem");
        //--------------------------------------------------------
        String updateTypeProblem = request.getParameter("updateTypeProblem");
        //--------------------------------------------------------
        if (updateTypeProblem != null) {

            typeProblem.setName(nameTypeProblem);
            typeProblem.setColor(colorTypeProblem);
            ServiceTypeProblem.edit(typeProblem);
        }
        //--------------------------------------------------------
        response.sendRedirect(application.getContextPath() + "/TypeProblem?id=" + typeProblem.getId());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
