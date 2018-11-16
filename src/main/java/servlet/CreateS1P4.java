/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Step1Why;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.ServiceProblem;
import service.ServiceStep1Why;

/**
 *
 * @author Hachem
 */
public class CreateS1P4 extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();
        //--------------------------------------------------------
        String idProblem = request.getParameter("id");
        entity.Problem problem = ServiceProblem.find(Integer.parseInt(idProblem));
        response.sendRedirect(application.getContextPath() + "/Problem?id=" + problem.getId());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        application = request.getServletContext();

        String idProblem = request.getParameter("id");
        entity.Problem problem = ServiceProblem.find(Integer.parseInt(idProblem));
        entity.Step1 step1 = problem.getIdStep1();
        //--------------------------------------------------------
        String addWhy = request.getParameter("addWhy");
        String updateWhy = request.getParameter("updateWhy");
        String destroyWhy = request.getParameter("destroyWhy");
        String destroyAll = request.getParameter("destroyAll");

        //--------------------------------------------------------
        if (destroyAll != null) {

            List<Step1Why> listStep1Why = step1.getStep1WhyList();

            for (int i = 0; i < listStep1Why.size(); i++) {
                Step1Why step1Why = listStep1Why.get(i);
                ServiceStep1Why.destroy(step1Why.getId());
            }
            response.sendRedirect(application.getContextPath() + "/Problem?id=" + problem.getId());

        } else if (addWhy != null) {
            String pourquoi = request.getParameter("pourquoi");
            String commentaire = request.getParameter("commentaire");
            Step1Why step1Why = new Step1Why();

            step1Why.setIdStep1(step1);
            step1Why.setComment(commentaire);
            step1Why.setWhy(pourquoi);
            ServiceStep1Why.create(step1Why);

            //response.sendRedirect(application.getContextPath() + "/Problem?id=" + problem.getId());
        } else if (updateWhy != null) {
            String pourquoi = request.getParameter("pourquoi");
            String commentaire = request.getParameter("commentaire");
            String idStep1Why = request.getParameter("idStep1Why");
            Step1Why step1Why = ServiceStep1Why.find(Integer.parseInt(idStep1Why));

            step1Why.setComment(commentaire);
            step1Why.setWhy(pourquoi);
            ServiceStep1Why.edit(step1Why);

            //response.sendRedirect(application.getContextPath() + "/Problem?id=" + problem.getId());
        } else if (destroyWhy != null) {

            String idStep1Why = request.getParameter("idStep1Why");
            ServiceStep1Why.destroy(Integer.parseInt(idStep1Why));

            response.sendRedirect(application.getContextPath() + "/Problem?id=" + problem.getId());

        } else {
            application.getRequestDispatcher("Home").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
