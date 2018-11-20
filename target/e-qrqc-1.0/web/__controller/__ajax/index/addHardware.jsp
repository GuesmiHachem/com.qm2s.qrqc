<%@page import="java.util.Date"%>
<%@page import="entity.Level1"%>
<%@page import="service.ServiceLevel1"%>
<%@page import="service.ServiceHardware"%>
<%@page import="entity.Hardware"%>
<%

    String idLigne = request.getParameter("idLigne");
    String name = request.getParameter("name");

    Level1 level1 = ServiceLevel1.find(Integer.parseInt(idLigne));
    Hardware h = new Hardware();
    h.setActive(false);
    h.setDateCreation(new Date(new Date().getTime()));
    h.setIdLevel1(level1);
    h.setName(name);
    h = ServiceHardware.create(h);
    session.setAttribute("hardware", h);
    out.println(h.getId());
    //response.sendRedirect(application.getContextPath());

//out.println("hello");
%>