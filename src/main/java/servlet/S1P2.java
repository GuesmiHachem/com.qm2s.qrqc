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
import service.ServiceProblem;

/**
 *
 * @author Hachem
 */
public class S1P2 extends HttpServlet {

    
    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/updateS1P2.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();
        //--------------------------------------------------------
        String idProblem = request.getParameter("id");
        entity.Problem problem =  ServiceProblem.find(Integer.parseInt(idProblem));
        //--------------------------------------------------------
        //request.setAttribute("problem", problem);
        //--------------------------------------------------------
        application.getRequestDispatcher(pageweb).forward(request, response);
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        application = request.getServletContext();
        //--------------------------------------------------------

        //--------------------------------------------------------
        String id_problem = request.getParameter("id");
        entity.Problem problem = ServiceProblem.find(Integer.parseInt(id_problem));
        //--------------------------------------------------------

        response.sendRedirect(application.getContextPath() + "/S1P2?id=" + problem.getId());

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
