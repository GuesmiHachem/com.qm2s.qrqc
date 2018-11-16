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
import service.ServiceTypeProblem;

/**
 *
 * @author Hachem
 */
public class ListTypeProblem extends HttpServlet {

  public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/listTypeProblem.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();

        application.getRequestDispatcher(pageweb).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        application = request.getServletContext();

        //--------------------------------------------------------
        String nameTypeProblem = request.getParameter("nameTypeProblem");
        String colorTypeProblem = request.getParameter("colorTypeProblem");
        String idTypeProblem = request.getParameter("idTypeProblem");
        //--------------------------------------------------------
        String addTypeProblem = request.getParameter("addTypeProblem");
        String deleteTypeProblem = request.getParameter("deleteTypeProblem");
        String destroyAll = request.getParameter("destroyAll");

        //--------------------------------------------------------
        if (addTypeProblem != null) {
            entity.TypeProblem typeProblem = new entity.TypeProblem();
            typeProblem.setName(nameTypeProblem);
            typeProblem.setColor(colorTypeProblem);
            
            ServiceTypeProblem.create(typeProblem);
        }

        //--------------------------------------------------------
        if (deleteTypeProblem != null) {
            ServiceTypeProblem.destroy(Integer.parseInt(idTypeProblem));
        }
        //--------------------------------------------------------

        //--------------------------------------------------------
        if (destroyAll != null) {
           ServiceTypeProblem.destroyAll();
        }

        response.sendRedirect(application.getContextPath() + "/ListTypeProblem");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
