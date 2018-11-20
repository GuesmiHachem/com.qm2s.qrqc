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
            </div>
            <div class="card-body w3-white">
                <div class="row">

                    
                    <div class="col-lg-3">
                        <button type="button" class="btn btn-success btn-lg btn-block w3-padding-24" onclick="document.location.href = 'D1D3?id=<%=problem.getId()%>'">
                            <span class="w3-xlarge">D1+D3</span>
                            <br>
                            <span class="w3-large w3-text-dark-gray">Quick Response</span>
                        </button>
                    </div>

                    <div class="col-lg-3">
                        <button type="button" class="btn btn-success btn-lg btn-block w3-padding-24" onclick="document.location.href = 'D4A?id=<%=problem.getId()%>'">
                            <span class="w3-xlarge">D4a</span>
                            <br>
                            <span class="w3-large w3-text-dark-gray">Analyse occurence</span>
                            
                        </button>
                    </div>
                    <div class="col-lg-3">
                        <button type="button" class="btn btn-success btn-lg btn-block w3-padding-24" onclick="document.location.href = 'D4B?id=<%=problem.getId()%>'">
                            <span class="w3-xlarge">D4b</span>
                            <br>
                            <span class="w3-large w3-text-dark-gray">Analyse non détection</span>
                        </button>
                    </div>

                    <div class="col-lg-3">
                        <button type="button" class="btn btn-success btn-lg btn-block w3-padding-24" onclick="document.location.href = 'D5?id=<%=problem.getId()%>'">
                           <span class="w3-xlarge">D5</span>
                           <br>
                            <span class="w3-large w3-text-dark-gray">Plan d'actions</span>
                           
                        </button>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

