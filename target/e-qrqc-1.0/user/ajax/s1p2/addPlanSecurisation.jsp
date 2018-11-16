<%-- 
    Document   : viewPlanSecurisation
    Created on : 2 nov. 2018, 09:11:01
    Author     : Hachem
--%>
<%@page import="entity.*"%>
<%@page import="service.*"%>
<%@page import="domaine.Design"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.List"%>

<%
    entity.Problem problem = (entity.Problem) session.getAttribute("problem");
    ResourceBundle bundle = (ResourceBundle) session.getAttribute("bundle");
    List<Step1SecurityPlan> listStep1SecurityPlan = (List<Step1SecurityPlan>) session.getAttribute("listSecurityPlan");

    String where = request.getParameter("where");
    String who = request.getParameter("who");
    String n1 = request.getParameter("n1");
    String n2 = request.getParameter("n2");

    Step1SecurityPlan sp = new Step1SecurityPlan();

    sp.setWhere(where);
    sp.setWho(ServiceUser.find(Integer.parseInt(who)));
    sp.setHowMuch(Integer.parseInt(n1));
    sp.setResult(Integer.parseInt(n2));

    listStep1SecurityPlan.add(sp);

    session.setAttribute("listSecurityPlan", listStep1SecurityPlan);
    //response.sendRedirect(application.getContextPath() + "/CreateS1P2");

%>

