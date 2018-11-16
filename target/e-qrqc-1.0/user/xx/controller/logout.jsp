<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Enumeration"%>
<%
   
    //session.removeAttribute("errorConnexion");
    //session.setAttribute("user",null);
    //session.removeAttribute("user");
    session.invalidate();
    
    response.sendRedirect("../");

%>


