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

    Problem problem = null;
    Step1 step1 = null;
    User user = null;
    TypeUser typeuser = null;
    TypeProblem typeProblem = null;
    List<Problem> listProblemNivE = userContent.getProblemList();

    List<Problem> listProblemNiv1 = new ArrayList<Problem>();
    if (userContent.getIdLevel0() != null) {
        if (userContent.getIdLevel0().getIdLevel1() != null) {
            listProblemNiv1 = userContent.getIdLevel0().getIdLevel1().getProblemList();
        }
    }

    // userContent=ServiceUser.refreshUser(userContent);
    // session.setAttribute("user",userContent);
    Date actuelle = new Date();
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    String dat = dateFormat.format(actuelle);
%>


<div class="row">
    <div class="col-lg-12">

        <% if (userContent.getIdTypeUser().getName().equals("Administrateur")) {%>
        <div class="w3-container w3-white w3-border-grey w3-border1">



            <div class="row">
                <div class="col-lg-3 col-sm-6">
                    <div class="card w3-light-blue ">
                        <div class="card-content">
                            <div class="row ">
                                <div class="col-xs-5">
                                    <div class="icon-big text-center">
                                        <i class="fa fa-user w3-text-white"></i>
                                    </div>
                                </div>
                                <div class="col-xs-7">
                                    <div class="numbers">
                                        <p>Utilisateur</p>
                                        <%= ServiceUser.findAll().size()%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-6">
                    <div class="card w3-pink">
                        <div class="card-content">
                            <div class="row">
                                <div class="col-xs-5">
                                    <div class="icon-big text-center">
                                        <i class="w3-text-white w3-xxlarge ti-alert"></i>
                                    </div>
                                </div>
                                <div class="col-xs-7">
                                    <div class="numbers">
                                        <p>Probl�me</p>
                                        <%= ServiceProblem.findAll().size()%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <!--====================================================================-->

                <!--====================================================================-->
                <div class="col-lg-3 col-sm-6">
                    <div class="card w3-light-gray">
                        <div class="card-content">
                            <div class="row">
                                <div class="col-xs-5">
                                    <div class=" text-center">
                                        <i class="fa fa-star w3-text-orange"></i>
                                        <i class="fa fa-star w3-text-orange"></i>
                                        <i class="fa fa-star w3-text-orange"></i>
                                    </div>
                                </div>
                                <div class="col-xs-7">
                                    <div class="numbers">
                                        <p>Niveau 3</p>
                                        <%= ServiceLevel3.findAll().size()%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====================================================================-->
                <div class="col-lg-3 col-sm-6">
                    <div class="card w3-light-gray">
                        <div class="card-content">
                            <div class="row">
                                <div class="col-xs-5">
                                    <div class=" icon-danger text-center">
                                        <i class="fa fa-star w3-text-orange"></i>
                                        <i class="fa fa-star w3-text-orange"></i>
                                    </div>
                                </div>
                                <div class="col-xs-7">
                                    <div class="numbers">
                                        <p>Niveau 2</p>
                                        <%= ServiceLevel2.findAll().size()%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====================================================================-->
                <div class="col-lg-3 col-sm-6">
                    <div class="card w3-light-gray">
                        <div class="card-content">
                            <div class="row">
                                <div class="col-xs-5">
                                    <div class="icon-info text-center">
                                        <i class="fa fa-star w3-text-orange"></i>
                                    </div>
                                </div>
                                <div class="col-xs-7">
                                    <div class="numbers">
                                        <p>Niveau 1</p>
                                        <%= ServiceLevel1.findAll().size()%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-6">
                    <div class="card w3-light-gray">
                        <div class="card-content">
                            <div class="row">
                                <div class="col-xs-5">
                                    <div class="icon-primary text-center">
                                        <i class="fa fa-star w3-text-black"></i>
                                    </div>
                                </div>
                                <div class="col-xs-7">
                                    <div class="numbers">
                                        <p>Niveau E</p>
                                        <%=ServiceLevel0.findAll().size()%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--====================================================================-->

            </div>

        </div>
        <% } else {%>






        <div class="card bg-light mb-3" >
            <div class="card-header font-weight-bold">
                <i class="fa fa-bars"></i>
                Niveau <span class="w3-dark-gray w3-padding-small w3-round">Equipe</span>
            </div>
            <div class="card-body w3-white">
                <br>
                <%if (permission.equals("yes")) {%>                
                <button class="ui basic button mb-3" onclick="document.location.href = 'CreateS1P1'">
                    <i class="icon plus"></i>
                    Ajouter QRQC
                </button>
                <%} else {%> 
                <button disabled class="ui basic button mb-3" onclick="document.location.href = 'CreateS1P1'">
                    <i class="icon plus"></i>
                    Ajouter QRQC
                </button>
                <%}%> 
                <br>
                <table id=""  class="w3-table display responsive no-wrap w3-round w3-border w3-border-blue-gray" style="width:100%">
                    <thead class="w3-blue-gray">
                        <tr>
                            <th> Code&nbsp;</th>
                            <th> Status&nbsp;</th>
                            <th> R�f�rence&nbsp;</th>
                            <th> Type_de_problem&nbsp;</th>
                            <th style=" white-space: nowrap;"> Date_creation&nbsp;</th>
                            <th class="disabled-sorting"> </th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Problem p : listProblemNivE) {
                                typeProblem = p.getIdTypeProblem();
                                step1 = p.getIdStep1();
                                user = p.getIdUser();
                                if (step1 != null) {
                                    if (user != null) {
                                        typeuser = user.getIdTypeUser();
                                    }
                        %>
                        <tr style="background-colodr: <%=typeProblem.getColor()%>">
                            <td ><span class="w3-tag w3-padding-small w3-round"  style="background-color: <%=typeProblem.getColor()%>"><%=p.getCode()%></span></td>
                            <td><%=p.getStatus()%> </td>
                            <td><%=p.getReference()%></td>
                            <td class=""><%=typeProblem.getName()%></td>
                            <td><%=p.getDateCreation().toLocaleString()%></td>
                            <td>
                                <form action="<%=application.getContextPath()%>/ListProblem" method="post">
                                    <a href="Problem?id=<%=p.getId()%>" class="btn w3-white w3-text-green fa fa-external-link " ></a>
                                    <%if (permission.equals("yes")) {%>    
                                    <input hidden name="id" type="text" value="<%= p.getId()%>"/>
                                    <button onclick="document.location.href = 'removeProblem?id=<%=p.getId()%>'" type="button" class="btn w3-white  w3-text-pink fa fa-trash"></button>
                                    <button  onclick="document.location.href = 'ProblemPdf?id=<%=p.getId()%>'"  type="button" class="btn w3-white w3-text-red fa fa-file-pdf-o "> 
                                    </button>
                                    <%} else {%>    
                                    <input hidden name="id" type="text" value="<%= p.getId()%>"/>
                                    <button disabled onclick="document.location.href = 'removeProblem?id=<%=p.getId()%>'" type="button" class="btn w3-white  w3-text-pink fa fa-trash"></button>
                                    <button  disabled onclick="document.location.href = 'ProblemPdf?id=<%=p.getId()%>'"  type="button" class="btn w3-white w3-text-red fa fa-file-pdf-o "> 
                                    </button>
                                    <%}%>    
                                </form>
                            </td>
                        </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table> 
            </div>
        </div>

        <div class="card bg-light mb-3" >
            <div class="card-header font-weight-bold">
                <i class="fa fa-bars"></i>
                Niveau <span class="w3-dark-gray w3-padding-small w3-round">1</span>
            </div>
            <div class="card-body w3-white">
                <table id=""  class="w3-table display responsive no-wrap w3-round w3-border w3-border-blue-gray" style="width:100%">
                    <thead class="w3-blue-gray">
                        <tr>
                            <th style=" white-space: nowrap;"> Code&nbsp;&nbsp;</th>
                            <th style=" white-space: nowrap;"> Status&nbsp;&nbsp;</th>
                            <th style=" white-space: nowrap;"> Utilisateur&nbsp;&nbsp;</th>
                            <th style=" white-space: nowrap;"> Niveau_E&nbsp;&nbsp;</th>
                            <th style=" white-space: nowrap;"> Niveau_1&nbsp;&nbsp;</th>
                            <th style=" white-space: nowrap;"> R�f�rence&nbsp;&nbsp;</th>
                            <th style=" white-space: nowrap;"> Type_de_problem&nbsp;</th>
                            <th style=" white-space: nowrap;"> Date_creation &nbsp;&nbsp;</th>
                            <th  class="disabled-sorting">Actions&nbsp;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Problem p1 : listProblemNiv1) {
                                typeProblem = p1.getIdTypeProblem();
                                step1 = p1.getIdStep1();
                                user = p1.getIdUser();
                                if (step1 != null) {
                                    if (user != null) {
                                        typeuser = user.getIdTypeUser();
                                    }

                        %>
                        <tr>


                            <td ><span class="w3-tag w3-padding-small w3-round"  style="background-color: <%=typeProblem.getColor()%>"><%=p1.getCode()%></span></td>
                            <td><%=p1.getStatus()%> </td>

                            <td><%=p1.getIdUser().getFirstName() + " " + p1.getIdUser().getName()%></td>
                            <td><%=p1.getIdUser().getIdLevel0().getName()%> </td>
                            <td><%=p1.getIdLevel1().getName()%> </td>



                            <td><%=p1.getReference()%></td>
                            <td style="color: <%=typeProblem.getColor()%>" class=""><%=typeProblem.getName()%></td>
                            <td style=" white-space: nowrap;"><%=p1.getDateCreation().toLocaleString()%></td>

                            <td style=" white-space: nowrap;">
                                <form action="<%=application.getContextPath()%>/ListProblem" method="post">
                                    <a href="Problem?id=<%=p1.getId()%>" class="btn w3-white w3-text-green fa fa-external-link " ></a>

                                    <%if (permission.equals("yes")) {%>    
                                    <input hidden name="id" type="text" value="<%= p1.getId()%>"/>
                                    <button onclick="document.location.href = 'removeProblem?id=<%=p1.getId()%>'" type="button" class="btn w3-white  w3-text-pink fa fa-trash"></button>
                                    <button  onclick="document.location.href = 'ProblemPdf?id=<%=p1.getId()%>'"  type="button" class="btn w3-white  w3-text-red fa fa-file-pdf-o "> 
                                    </button>
                                    <%} else {%>    
                                    <input hidden name="id" type="text" value="<%= p1.getId()%>"/>
                                    <button disabled onclick="document.location.href = 'removeProblem?id=<%=p1.getId()%>'" type="button" class="btn w3-white  w3-text-pink fa fa-trash"></button>
                                    <button  disabled onclick="document.location.href = 'ProblemPdf?id=<%=p1.getId()%>'"  type="button" class="btn w3-white  w3-text-red fa fa-file-pdf-o "> 
                                    </button>
                                    <%}%> 


                                </form>

                            </td>


                        </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="card bg-light mb-3" >
            <div class="card-header font-weight-bold">
                <i class="fa fa-bars"></i>
                Plan d'action
            </div>
            <div class="card-body w3-white">
                <table id=""  class="w3-table display responsive no-wrap w3-round w3-border w3-border-blue-gray" style="width:100%">
                    <thead class="w3-blue-gray">
                        <tr>
                            <th> Problem</th>
                            <th> Date&nbsp;&nbsp;</th>
                            <th> Action</th>
                            <th> Qui</th>
                            <th> Quand</th>
                            <th> Statut&nbsp;&nbsp;&nbsp;</th>
                            <td class="disabled-sorting"> </td>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            Iterator<Problem> itProblem = userContent.getProblemList().iterator();

                            String color1 = "w3-light-green";
                            String color2 = "w3-white";
                            String color = color1;
                            while (itProblem.hasNext()) {
                                problem = itProblem.next();
                                step1 = problem.getIdStep1();
                                if (step1 != null) {
                                    Iterator<Step1Action> itStep1Action = step1.getStep1ActionList().iterator();
                                    user = problem.getIdUser();
                                    if (itStep1Action.hasNext()) {

                                        if (color.equals(color1)) {
                                            color = color2;
                                        } else {
                                            color = color1;
                                        }

                                        while (itStep1Action.hasNext()) {

                                            Step1Action s1p3 = itStep1Action.next();

                        %>
                        <tr class="<%=color%>">


                            <td><%= problem.getCode()%> </td>
                            <td><%= step1.getWhen()%></td>

                            <td><%= s1p3.getAction()%> </td>
                            <td><%= s1p3.getWho()%> </td>
                            <td><%= s1p3.getWhen()%> </td>


                            <td>
                                <% if (s1p3.getStatus() == 100) {%>
                                <span class="w3-medium w3-text-white w3-tag w3-round w3-green"><%=s1p3.getStatus()%>%</span>
                                <% } else if (s1p3.getStatus() >= 80) {%>
                                <span class="w3-medium w3-text-white w3-tag w3-round w3-light-green"><%=s1p3.getStatus()%>%</span>
                                <% } else if (s1p3.getStatus() >= 60) {%>
                                <span class="w3-medium w3-text-white w3-tag w3-round w3-lime"><%=s1p3.getStatus()%>%</span>
                                <% } else {%>
                                <span class="w3-text-pink "><%=s1p3.getStatus()%>%</span>
                                <% }%>
                            </td>

                            <td>
                                <a href="Problem?id=<%=problem.getId()%>" class="<%=Design.btn%> w3-text-green ti-eye " ></a>
                            </td>
                        </tr>
                        <%
                                        }
                                    }
                                }

                            }
                        %>

                    </tbody>
                </table>
            </div>
        </div>





        <% }%>

    </div>
</div>

