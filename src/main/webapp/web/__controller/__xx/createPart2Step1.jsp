

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
    Step1 step1 = (Step1) session.getAttribute("step1");

    String immediate_actions = request.getParameter("immediate_actions");
    String sort1 = request.getParameter("sort");
    String sort_criterion = request.getParameter("sort_criterion");

    boolean sort;
    if (sort1 != null) {
        sort = true;
    } else {
        sort = false;
    }

    step1.setImmediate_actions(immediate_actions);
    step1.setSort(sort);
    step1.setSort_criterion(sort_criterion);

    session.setAttribute("step1", step1);
    response.sendRedirect(application.getContextPath() + "/user/page/S1P3Form.jsp");

%>