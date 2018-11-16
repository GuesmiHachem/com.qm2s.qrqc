/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.*;
import java.util.Date;
import service.ServiceNotification;
import service.ServiceProblem;
import service.ServiceStep1;
import service.ServiceStep1ActionFollowed;
import service.ServiceStep1SecurityPlan;
import service.ServiceUser;

/**
 *
 * @author Hachem
 */
public class CreateS1P2 extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String S1P1Form = "/user/page/S1P1Form.jsp";
    public String S1P2Form = "/user/page/S1P2Form.jsp";
    public String S1P3Form = "/user/page/S1P3Form.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();
        //--------------------------------------------------------

        entity.Problem problem = (entity.Problem) session.getAttribute("problem");
        if (problem == null) {
            response.sendRedirect(application.getContextPath() + "/CreateS1P1");
        } else {
            Step1 step1 = (Step1) session.getAttribute("step1");
            if (step1 == null) {
                response.sendRedirect(application.getContextPath() + "/CreateS1P1");
            } else {
                application.getRequestDispatcher(S1P2Form).forward(request, response);
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        application = request.getServletContext();

        entity.Problem problem = (entity.Problem) session.getAttribute("problem");

        //--------------------------------------------------------
        String S1P2 = request.getParameter("S1P2");
        Step1 step1 = (Step1) session.getAttribute("step1");
        entity.User user = (entity.User) session.getAttribute("user");
        user = ServiceUser.find(user.getId());
        List<Step1Securisation> listStep1SecurityPlan = (List<Step1Securisation>) session.getAttribute("listSecurityPlan");

        if (listStep1SecurityPlan == null) {
            listStep1SecurityPlan = new ArrayList<Step1Securisation>();
            session.setAttribute("listSecurityPlan", listStep1SecurityPlan);
        }

        //--------------------------------------------------------
        if (S1P2 != null) {

            String immediate_actions = request.getParameter("immediate_actions");
            String sort_string = request.getParameter("sort");
            String sort_criterion = request.getParameter("sort_criterion");
            String start_validation_string = request.getParameter("start_validation");

            boolean sort;
            if (sort_string != null) {
                sort = true;
            } else {
                sort = false;
            }

            boolean start_validation;
            if (start_validation_string != null) {
                start_validation = true;
            } else {
                start_validation = false;
            }

            step1.setImmediateActions(immediate_actions);
            step1.setSort(sort);
            step1.setSortCriterion(sort_criterion);
            step1.setStartValidation(start_validation);
            if (start_validation) {
                step1.setUserValidation(user);
                step1.setDateValidation(new Date());
            }
            ServiceStep1.edit(step1);
            step1 = ServiceStep1.find(step1.getId());
            //session.setAttribute("step1", step1);
            for (Step1Securisation step1SecurityPlan : listStep1SecurityPlan) {
                step1SecurityPlan.setIdStep1(step1);
                ServiceStep1SecurityPlan.create(step1SecurityPlan);
                
                entity.Notification n=new entity.Notification();
                n.setTitle(problem.getIdUser().getFirstName()+" "+problem.getIdUser().getName()+" a mentionné votre nom dans le plan de securité de "+problem.getCode());
                n.setIdProblem(problem);
                n.setDateCreation(new Date(new Date().getTime()));
                n.setIdUser(step1SecurityPlan.getAffectedTo());
                ServiceNotification.create(n);
                
            }
            ServiceStep1ActionFollowed.doStep1ActionFollowed(step1, user.getIdLevel0());
            session.removeAttribute("problem");
            session.removeAttribute("step1");
            session.removeAttribute("listSecurityPlan");
            ServiceNotification.doNotification(problem);

            response.sendRedirect(application.getContextPath() + "/Problem?id=" + problem.getId());

        } else {
            response.sendRedirect(application.getContextPath() + "/CreateS1P2");

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
