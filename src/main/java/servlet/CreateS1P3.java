/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
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
import service.ServiceStep1SecurityPlan;
import service.ServiceStep1;
import service.ServiceStep1Action;
import service.ServiceStep1AlertCan;
import service.ServiceStep1AlertShould;
import service.ServiceUser;

/**
 *
 * @author Hachem
 */
public class CreateS1P3 extends HttpServlet {

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
        String S1P3 = request.getParameter("S1P3");
        String addAction = request.getParameter("addAction");
        String updateAction = request.getParameter("updateAction");
        String destroyAction = request.getParameter("destroyAction");
        String destroyAll = request.getParameter("destroyAll");
        String addStep1ActionStatus = request.getParameter("addStep1ActionStatus");
        String minusStep1ActionStatus = request.getParameter("minusStep1ActionStatus");

        //--------------------------------------------------------
        if (destroyAll != null) {

            List<Step1Action> listStep1Action = step1.getStep1ActionList();

            for (int i = 0; i < listStep1Action.size(); i++) {
                Step1Action step1Action = listStep1Action.get(i);
                ServiceStep1Action.destroy(step1Action.getId());
            }
            response.sendRedirect(application.getContextPath() + "/Problem?id=" + problem.getId());

        } else if (addAction != null) {
            String action = request.getParameter("action");
            String qui = request.getParameter("qui");
            String quand = request.getParameter("quand");
            String commentaire = request.getParameter("commentaire");
            Step1Action step1Action = new Step1Action();

            step1Action.setIdStep1(step1);
            step1Action.setComment(commentaire);
            step1Action.setWho(service.ServiceUser.find(Integer.parseInt(qui)));
            step1Action.setAction(action);
            step1Action.setWhen(quand);
            ServiceStep1Action.create(step1Action);
            
            //*************************************************
            entity.Notification n = new entity.Notification();
            n.setTitle(problem.getIdUser().getFirstName()+" "+problem.getIdUser().getName()+" a mentionné votre nom dans la liste des actions de "+problem.getCode());
            n.setIdProblem(problem);
            n.setDateCreation(new Date(new Date().getTime()));
            n.setIdUser(step1Action.getWho());
            ServiceNotification.create(n);
            //*************************************************
            
            //response.sendRedirect(application.getContextPath() + "/Problem?id=" + problem.getId());
        } else if (updateAction != null) {
            String idStep1Action = request.getParameter("idStep1Action");
            String action = request.getParameter("action");
            String qui = request.getParameter("qui");
            String quand = request.getParameter("quand");
            String commentaire = request.getParameter("commentaire");
            Step1Action step1Action = ServiceStep1Action.find(Integer.parseInt(idStep1Action));

            //step1Action.setIdStep1(step1);
            step1Action.setComment(commentaire);
            step1Action.setWho(service.ServiceUser.find(Integer.parseInt(qui)));
            step1Action.setAction(action);
            step1Action.setWhen(quand);
            ServiceStep1Action.edit(step1Action);

            //response.sendRedirect(application.getContextPath() + "/Problem?id=" + problem.getId());
        } else if (addStep1ActionStatus != null) {
            String idStep1Action = request.getParameter("idStep1Action");

            Step1Action step1Action = ServiceStep1Action.find(Integer.parseInt(idStep1Action));

            //step1Action.setIdStep1(step1);
            if (step1Action.getStatus() + 5 <= 100) {
                step1Action.setStatus(step1Action.getStatus() + 5);
                ServiceStep1Action.edit(step1Action);
            }

            //response.sendRedirect(application.getContextPath() + "/Problem?id=" + problem.getId());
        } else if (minusStep1ActionStatus != null) {
            String idStep1Action = request.getParameter("idStep1Action");

            Step1Action step1Action = ServiceStep1Action.find(Integer.parseInt(idStep1Action));

            //step1Action.setIdStep1(step1);
            if (step1Action.getStatus() - 5 >= 0) {
                step1Action.setStatus(step1Action.getStatus() - 5);
                ServiceStep1Action.edit(step1Action);
            }

            //response.sendRedirect(application.getContextPath() + "/Problem?id=" + problem.getId());
        } else if (destroyAction != null) {

            String idStep1Action = request.getParameter("idStep1Action");
            ServiceStep1Action.destroy(Integer.parseInt(idStep1Action));

            // response.sendRedirect(application.getContextPath() + "/Problem?id=" + problem.getId());
        } else {
            application.getRequestDispatcher("Home").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
