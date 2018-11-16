



<%@page import="dao.DaoProblem"%>
<%@page import="model.Step1Part3"%>
<%@page import="model.SecurityPlan"%>
<%@page import="java.util.List"%>
<%

    DaoProblem daoProblem=new DaoProblem();
    String idProblem = request.getParameter("idProblem");

    daoProblem.delete(Integer.parseInt(idProblem));
    response.sendRedirect(application.getContextPath() + "/user/page/listQrqc.jsp");
%>