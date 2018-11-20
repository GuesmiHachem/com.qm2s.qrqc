<%-- 
    Document   : aa
    Created on : 20 juin 2018, 11:59:12
    Author     : Hachem
--%>

<%@page import="java.util.ResourceBundle"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>


<%
    String lang2 = (String) session.getAttribute("lang");
    ResourceBundle bundle1;
    if (lang2 != null) {
        if (lang2.equals("fr")) {
            bundle1 = ResourceBundle.getBundle("langue_fr");
        } else {
            bundle1 = ResourceBundle.getBundle("langue_en");
        }
    } else {
        bundle1 = ResourceBundle.getBundle("langue_fr");
    }
    
    session.setAttribute("bundle",bundle1);
%>
