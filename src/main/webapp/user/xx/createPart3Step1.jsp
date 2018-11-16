

<%@page import="dao.DaoNotification"%>
<%@page import="dao.DaoStep1Part3"%>
<%@page import="model.Step1Part3"%>
<%@page import="dao.DaoSecurityPlan"%>
<%@page import="dao.DaoWhoCanBeAlerted"%>
<%@page import="dao.DaoWhoShouldBeAlerted"%>
<%@page import="model.WhoShouldBeAlerted"%>
<%@page import="model.WhoCanBeAlerted"%>
<%@page import="dao.DaoStep1"%>
<%@page import="dao.DaoProblem"%>
<%@page import="model.SecurityPlan"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="model.Step1"%>
<%@page import="model.Problem"%>
<%
    DaoProblem daoProblem = new DaoProblem();
    DaoStep1 daoStep1 = new DaoStep1();
    DaoSecurityPlan daoSecurityPlan = new DaoSecurityPlan();
    DaoStep1Part3 daoStep1Part3 = new DaoStep1Part3();
    DaoWhoCanBeAlerted daoWhoCanBeAlerted = new DaoWhoCanBeAlerted();
    DaoWhoShouldBeAlerted daoWhoShouldBeAlerted = new DaoWhoShouldBeAlerted();

    Problem problem = (Problem) session.getAttribute("problem");
    Step1 step1 = (Step1) session.getAttribute("step1");
    List<SecurityPlan> listSecurityPlan = (List<SecurityPlan>) session.getAttribute("listSecurityPlan");
    List<WhoCanBeAlerted> listWhoCanBeAlerted = (List<WhoCanBeAlerted>) session.getAttribute("listWhoCanBeAlerted");
    List<WhoShouldBeAlerted> listWhoShouldBeAlerted = (List<WhoShouldBeAlerted>) session.getAttribute("listWhoShouldBeAlerted");
    List<Step1Part3> listStep1part3 = (List<Step1Part3>) session.getAttribute("listStep1part3");
%>

<%
    daoProblem.update(problem);
    step1.setId_problem(problem.getId());
    step1 = daoStep1.insert(step1);

    for (WhoCanBeAlerted whoCanBeAlerted : listWhoCanBeAlerted) {
        
        whoCanBeAlerted.setId_step1(step1.getId());
        whoCanBeAlerted=daoWhoCanBeAlerted.insert(whoCanBeAlerted);
    }
    for (WhoShouldBeAlerted whoShouldBeAlerted : listWhoShouldBeAlerted) {
        whoShouldBeAlerted.setId_step1(step1.getId());
        daoWhoShouldBeAlerted.insert(whoShouldBeAlerted);
    }
    for (SecurityPlan securityPlan : listSecurityPlan) {
        securityPlan.setId_step1(step1.getId());
        daoSecurityPlan.insert(securityPlan);
    }
    for (Step1Part3 step1part3 : listStep1part3) {
        step1part3.setId_step1(step1.getId());
        daoStep1Part3.insert(step1part3);
    }
    new DaoNotification().doNotification(problem.getId());
    
    
    session.removeAttribute("problem");
    session.removeAttribute("step1");
    session.removeAttribute("listSecurityPlan");
    session.removeAttribute("listWhoCanBeAlerted");
    session.removeAttribute("listWhoShouldBeAlerted");
    session.removeAttribute("listStep1part3");

    response.sendRedirect(application.getContextPath() + "/user/page/listQrqc.jsp");
%>