



<%@page import="dao.DaoProblem"%>
<%@page import="model.Problem"%>
<%@page import="dao.DaoNotification"%>
<%@page import="model.Notification"%>
<%@page import="model.Step1Part3"%>
<%@page import="model.SecurityPlan"%>
<%@page import="java.util.List"%>
<%

    String id = request.getParameter("id");
    
    Notification not=new DaoNotification().find(Integer.parseInt(id));
    Problem problem=new DaoProblem().find(not.getId_problem());
    //not.setVue(true);
    new DaoNotification().delete(not.getId());
    response.sendRedirect(application.getContextPath() + "/user/page/problem.jsp?id="+problem.getId());
%>