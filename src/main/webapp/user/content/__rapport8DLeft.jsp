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

    User _userContent = (User) session.getAttribute("user");
    String _permission = (String) session.getAttribute("permission");
    String _id_problem = request.getParameter("id");
    Problem _problem = ServiceProblem.find(Integer.parseInt(_id_problem));
    TypeProblem _typeProblem = _problem.getIdTypeProblem();
    Step1 _step1 = _problem.getIdStep1();
    User _user = _problem.getIdUser();

    DateFormat sdf_date = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat sdf_time = new SimpleDateFormat("HH:mm");

%>


<div class="row">
    <div class="col-lg-12">

        <div class="card bg-light mb-3" >
            <div class="card-header bg-danger w3-text-white font-weight-bold">
                <i class="fa fa-warning"></i>
                Probléme
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item w3-dark-gray ">
                    <a class="w3-text-light-gray " href="<%=application.getContextPath()%>/Problem?id=<%=_id_problem%>">
                        code :  <%= _problem.getCode()%>
                    </a> 
                </li>
                <li class="list-group-item">
                    <i class="fa fa-barcode"></i>
                    <%= _problem.getReference()%>
                </li>
                <li class="list-group-item">
                    <i class="fa fa-flag "></i>
                    <span><%=_problem.getStatus()%></span>
                </li>
                <li class="list-group-item">
                    <i style="color : <%=_problem.getIdTypeProblem().getColor()%>" class="fa fa-warning"></i>
                    <%=_problem.getIdTypeProblem().getName()%>
                </li>
                <li class="list-group-item">
                    <i class="fa fa-user"></i>
                    <%= _problem.getCode()%>
                </li>
            </ul>
            <div class="card-footer ">
                <i class="fa fa-calendar"></i>
                <%= sdf_date.format(_problem.getDateCreation())%>

                <i class="ti-time"></i>
                <%= sdf_time.format(_problem.getDateCreation())%>
            </div>
        </div>

    </div>
</div>


<div class="row">
    <div class="col-lg-12">
        <div class="card bg-light mb-3" >
            <div class="card-header bg-info font-weight-bold">
                <a class="w3-text-white " href="<%=application.getContextPath()%>/Rapport8D?id=<%=_id_problem%>">
                    <i class="fa fa-archive"></i>
                    Rapport 8D
                </a>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">
                    <a class="w3-text-dark-blue " href="<%=application.getContextPath()%>/D1D3?id=<%=_id_problem%>">
                        D1+D3 Quick Response
                    </a> 
                </li>
                <li class="list-group-item">
                    <a class="w3-text-dark-blue " href="<%=application.getContextPath()%>/D4A?id=<%=_id_problem%>">
                        D4a : Analyse occurence
                    </a> 
                </li>
                <li class="list-group-item">
                    <a class="w3-text-dark-blue " href="<%=application.getContextPath()%>/D4B?id=<%=_id_problem%>">
                        D4b : Analyse non détection
                    </a> 
                </li>
                <li class="list-group-item">
                    <a class="w3-text-dark-blue " href="<%=application.getContextPath()%>/D5?id=<%=_id_problem%>">
                        D5 : Plan d'actions
                    </a> 
                </li>
            </ul>
        </div>

    </div>
</div>
