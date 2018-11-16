<%-- 
    Document   : __overview
    Created on : 16 juin 2018, 19:41:16
    Author     : Hachem
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domaine.Design"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="entity.*"%>
<%@page import="service.*"%>

<%
    session = ServiceUser.refreshSessionUser(session);

    User userContent = (User) session.getAttribute("user");
    String permission = (String) session.getAttribute("permission");
    String id_problem = request.getParameter("id");
    Problem problem = ServiceProblem.find(Integer.parseInt(id_problem));
    TypeProblem typeProblem = problem.getIdTypeProblem();
    Step1 step1 = problem.getIdStep1();
    User user = problem.getIdUser();

%>


<div class="row">
    <div class="col-lg-12">

        <div class="card bg-light mb-3" >
            <div class="card-header font-weight-bold">
                <i class="fa fa-archive"></i>
                D1+D3 Quick Response
            </div>
            <div class="card-body w3-white">
                <div class="row">
                    <div class="col-lg-12">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

