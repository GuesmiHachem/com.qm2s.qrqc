<%-- 
    Document   : afficherUser
    Created on : 19 août 2018, 10:00:05
    Author     : Hachem
--%>

<%@page import="dao.DaoTypeUser"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dao.DaoUser"%>
<%@page import="model.Connex"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            new DaoUser().afficher();
            System.out.println("--------------------");
            try {
                Connex.getInstance().getC().close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoTypeUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("--------------------");
            new DaoUser().afficher();
            System.out.println("--------------------");
            
            

        %>
    </body>
</html>
