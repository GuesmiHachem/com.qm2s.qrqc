/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Step1Securisation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.ServiceNotification;
import service.ServiceProblem;
import service.ServiceStep1;
import service.ServiceStep1SecurityPlan;
import service.ServiceUser;

/**
 *
 * @author Hachem
 */
public class UpdateS1P2 extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    //public String S1P1Form = "/user/page/S1P1Form.jsp";
    //public String S1P2Form = "/user/page/S1P2Form.jsp";
    //public String S1P3Form = "/user/page/S1P3Form.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();
        //--------------------------------------------------------

        String idProblem = request.getParameter("id");
        entity.Problem problem = ServiceProblem.find(Integer.parseInt(idProblem));
        response.sendRedirect(application.getContextPath() + "/S1P2?id=" + problem.getId());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        application = request.getServletContext();

        String idProblem = request.getParameter("id");
        entity.Problem problem = ServiceProblem.find(Integer.parseInt(idProblem));
        entity.Step1 step1 = problem.getIdStep1();

        entity.User user = (entity.User) session.getAttribute("user");
        user = ServiceUser.find(user.getId());
        //--------------------------------------------------------
        String S1P2 = request.getParameter("S1P2");
        String AddPlan = request.getParameter("AddPlan");
        String removePlan = request.getParameter("removePlan");
        String hashcode = request.getParameter("hashcode");
        //Step1 step1 = (Step1) session.getAttribute("step1");
        List<Step1Securisation> listStep1SecurityPlan = step1.getStep1SecurisationList();

        if (listStep1SecurityPlan == null) {
            listStep1SecurityPlan = new ArrayList<Step1Securisation>();
            // session.setAttribute("listSecurityPlan", listStep1SecurityPlan);
        }

        //--------------------------------------------------------
        if (S1P2 != null) {

            String immediate_actions = request.getParameter("immediate_actions");
            String sort_string = request.getParameter("sort");
            String sort_criterion = request.getParameter("sort_criterion");
            String start_validation_string = request.getParameter("start_validation");

            boolean sort = false;

            if (sort_string != null) {
                if (sort_string.equals("on")) {
                    sort = true;
                }

            }

            boolean start_validation = false;

            if (start_validation_string != null) {
                if (start_validation_string.equals("on")) {
                    start_validation = true;
                }

            }

            if (sort == false) {
                sort_criterion = "";
            }

            step1.setImmediateActions(immediate_actions);
            step1.setSort(sort);
            step1.setSortCriterion(sort_criterion);
            step1.setStartValidation(start_validation);
            if (start_validation) {
                step1.setUserValidation(user);
            }
            ServiceStep1.edit(step1);

            step1 = ServiceStep1.find(step1.getId());
            //session.setAttribute("step1", step1);

            //ServiceStep1.edit(step1);
            //step1 = ServiceStep1.find(step1.getId());
            //problem.setIdStep1(step1);
            // ServiceProblem.edit(problem);
            //step1 = null;
            //immediate_actions = null;
            //  sort1 = null;
            //sort_criterion = null;
            //ServiceNotification.doNotification(problem.getId());
            session.removeAttribute("problem");
            session.removeAttribute("step1");
            session.removeAttribute("listSecurityPlan");
            // session.removeAttribute("listWhoCanBeAlerted");
            // session.removeAttribute("listWhoShouldBeAlerted");
            //session.removeAttribute("listStep1part3");
            response.sendRedirect(application.getContextPath() + "/S1P2?id=" + problem.getId());
            //response.getWriter().print(step1+ "--");

        } else if (AddPlan != null) {

            String where = request.getParameter("where");
            String who = request.getParameter("who");
            String n1 = request.getParameter("n1");
            String n2 = request.getParameter("n2");

            Step1Securisation sp = new Step1Securisation();

            sp.setWhere(where);
            sp.setAffectedTo(service.ServiceUser.find(Integer.parseInt(who)));
            sp.setHowMutch(Integer.parseInt(n1));
            sp.setResult(Integer.parseInt(n2));
            sp.setIdStep1(step1);
            ServiceStep1SecurityPlan.create(sp);

            //**************************************
            entity.Notification n = new entity.Notification();
            n.setTitle(problem.getIdUser().getFirstName()+" "+problem.getIdUser().getName()+" a mentionné votre nom dans le plan de securité de "+problem.getCode());
            n.setIdProblem(problem);
            n.setDateCreation(new Date(new Date().getTime()));
            n.setIdUser(sp.getAffectedTo());
            ServiceNotification.create(n);
            //**************************************   

            //session.setAttribute("listSecurityPlan", listStep1SecurityPlan);
            response.sendRedirect(application.getContextPath() + "/S1P2?id=" + problem.getId());

        } else if (removePlan != null) {

            Step1Securisation step1Securisation = null;

            for (int i = 0; i < listStep1SecurityPlan.size(); i++) {
                step1Securisation = listStep1SecurityPlan.get(i);
                if ((step1Securisation.hashCode() + "").equals(hashcode)) {
                    ServiceStep1SecurityPlan.destroy(step1Securisation.getId());
                }
            }

            //step1.setStep1SecurityPlanList(listStep1SecurityPlan);
            /* for (Step1SecurityPlan step1SecurityPlan1 : listStep1SecurityPlan) {
                step1SecurityPlan1.setIdStep1(step1);
                ServiceStep1SecurityPlan.create(step1SecurityPlan1);
            }*/
            //session.setAttribute("listSecurityPlan", listStep1SecurityPlan);
            response.sendRedirect(application.getContextPath() + "/S1P2?id=" + problem.getId());

        } else {
            //application.getRequestDispatcher(S1P2Form).forward(request, response);
            application.getRequestDispatcher("/user/page/home.jsp").forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
