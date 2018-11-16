/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Step1Comment;
import entity.Step1View;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.*;

/**
 *
 * @author Hachem
 */
public class Problem extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/problem.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();
        //--------------------------------------------------------
        String idProblem = request.getParameter("id");
        entity.Problem problem = ServiceProblem.find(Integer.parseInt(idProblem));
        //--------------------------------------------------------
        //request.setAttribute("problem", problem);
        entity.User userSession = (entity.User) ServiceUser.refreshSessionUser(session).getAttribute("user");
        if (userSession == null) {
         response.sendRedirect(application.getContextPath());
        }else if (!ServiceStep1.isStep1ViewByUser(problem.getIdStep1(), userSession)) {
            Step1View step1View=new Step1View();
            step1View.setDateCreation(new Date(new Date().getTime()));
            step1View.setIdStep1(problem.getIdStep1());
            step1View.setIdUser(userSession);
            ServiceStep1View.create(step1View);
            application.getRequestDispatcher(pageweb).forward(request, response);
        }else{
         application.getRequestDispatcher(pageweb).forward(request, response);
        }
        //--------------------------------------------------------
        

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
        entity.Step1 step1 = problem.getIdStep1();
        //--------------------------------------------------------
        String addComment = request.getParameter("addComment");
        String updateComment = request.getParameter("updateComment");
        String deleteComment = request.getParameter("deleteComment");
        String comment = request.getParameter("comment");
        String idComment = request.getParameter("idComment");

        if (addComment != null) {
            Step1Comment step1Comment = new Step1Comment();
            entity.User user = (entity.User) ServiceUser.refreshSessionUser(session).getAttribute("user");
            step1Comment.setComment(comment);
            step1Comment.setIdUser(user);
            step1Comment.setIdStep1(step1);
            step1Comment.setDateCreation(new Date(new Date().getTime()));

            ServiceStep1Comment.create(step1Comment);

        }

        if (updateComment != null) {
            Step1Comment step1Comment = ServiceStep1Comment.find(Integer.parseInt(idComment));
            step1Comment.setComment(comment);
            step1Comment.setDateCreation(new Date(new Date().getTime()));

            ServiceStep1Comment.edit(step1Comment);

        }

        if (deleteComment != null) {
            ServiceStep1Comment.destroy(Integer.parseInt(idComment));

            // ServiceStep1Comment.create(step1Comment);
        }

        response.sendRedirect(application.getContextPath() + "/Problem?id=" + problem.getId());

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    
    
    
}
