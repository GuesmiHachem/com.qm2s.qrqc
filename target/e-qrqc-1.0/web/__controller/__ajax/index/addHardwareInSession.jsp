<%@page import="java.util.Date"%>
<%@page import="entity.Level1"%>
<%@page import="service.ServiceLevel1"%>
<%@page import="service.ServiceHardware"%>
<%@page import="entity.Hardware"%>
<%

    String idHardware = request.getParameter("idHardware");
    Hardware hardware = ServiceHardware.find(Integer.parseInt(idHardware));
    session.setAttribute("hardware", hardware);
      
 //out.println("hello");
%>