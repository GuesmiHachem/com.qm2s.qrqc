/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import domaine.Config;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.Step1;
import service.ServiceProblem;

/**
 *
 * @author Hachem
 */
public class ListProblem extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/listQrqc.jsp";

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
        String id_problem = request.getParameter("id");
        entity.Problem problem = ServiceProblem.find(Integer.parseInt(id_problem));
        //--------------------------------------------------------
        String removeProblem = request.getParameter("removeProblem");
        if (removeProblem != null) {

            
            Step1 st1 = problem.getIdStep1();
            String filePath = new Config().pathPictureProblem;
            File f1 = new File(filePath + st1.getBadPiece());
            f1.delete();

            File f2 = new File(filePath + st1.getGoodPiece());
            f2.delete();

            ServiceProblem.destroy(Integer.parseInt(id_problem));

        }

        response.sendRedirect(application.getContextPath() + "/Problems");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
