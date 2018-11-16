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

    Step1SecurityPlan step1SecurityPlan = null;
    String id = request.getParameter("id");
    
    listStep1SecurityPlan.remove(Integer.parseInt(id));

    session.setAttribute("listSecurityPlan", listStep1SecurityPlan);

%>

