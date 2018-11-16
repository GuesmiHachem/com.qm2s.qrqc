/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Step1Action;
import entity.Step1ActionFollowed;
import entity.Step1Why;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.ServiceProblem;
import service.ServiceStep1Action;
import service.ServiceStep1ActionFollowed;
import service.ServiceStep1Why;

/**
 *
 * @author Hachem
 */
public class CreateS1P5 extends HttpServlet {

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
        String S1P5 = request.getParameter("S1P5");

        //--------------------------------------------------------
        if (S1P5 != null) {
            String idStep1ActionFollowed = request.getParameter("idStep1ActionFollowed");
            String efficace_string = request.getParameter("efficace");
            boolean efficace = true;
            Step1ActionFollowed step1ActionFollowed = ServiceStep1ActionFollowed.find(Integer.parseInt(idStep1ActionFollowed));
            if (efficace_string == null) {
                efficace = false;
            }

            if (efficace) {
                step1ActionFollowed.setEffective(efficace);
                step1ActionFollowed.setToBeFollowed(true);
                step1ActionFollowed.setDateCreation(new Date(new Date().getTime()));
                ServiceStep1ActionFollowed.edit(step1ActionFollowed);
            } else {

                for (Step1ActionFollowed step1ActionFollowed1 : step1.getStep1ActionFollowedList()) {
                    ServiceStep1ActionFollowed.destroy(step1ActionFollowed1.getId());
                }
                for (Step1Action step1Action1 : step1.getStep1ActionList()) {
                    ServiceStep1Action.destroy(step1Action1.getId());
                }
                for (Step1Why step1Why1 : step1.getStep1WhyList()) {
                    ServiceStep1Why.destroy(step1Why1.getId());
                }
                entity.User user=(entity.User)session.getAttribute("user");
                ServiceStep1ActionFollowed.doStep1ActionFollowed(step1, user.getIdLevel0());
            }

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
