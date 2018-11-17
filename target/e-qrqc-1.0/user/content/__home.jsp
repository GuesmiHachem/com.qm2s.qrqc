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
                                        <p>Probléme</p>
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
                            <th> Référence&nbsp;</th>
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
                            <th style=" white-space: nowrap;"> Référence&nbsp;&nbsp;</th>
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
                            <th style=" white-space: nowrap;" class="" >Code QRQC</th>
                            <th style=" white-space: nowrap;" class="" >Non de l'action</th>
                            <th style=" white-space: nowrap;" class="" >Priorité</th>
                            <th style=" white-space: nowrap;" class="" >État</th>                           
                            <th style=" white-space: nowrap;" class="" >Date de début</th>
                            <th style=" white-space: nowrap;" class="" >Échéance</th>
                            <th style=" white-space: nowrap;" class="" >Pourcentage achevé %</th>
                            <th style=" white-space: nowrap;" class="" >Affecté à</th>
                            <th style=" white-space: nowrap;" class="" >Description</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Step1 step11 : ServiceStep1.findAll()) {
                        %>

                        <%
                            for (Step1Securisation step1Securisation : step11.getStep1SecurisationList()) {
                        %>

                        <tr>
                            <td style=" white-space: nowrap;" class="" ><%=step1Securisation.getIdStep1().getIdProblem().getCode()%></td>
                            <td style=" white-space: nowrap;" class="" >Plan de sécurisation</td>
                            <td style=" white-space: nowrap;" class="" ><%=step1Securisation.getPriority()%></td>
                            <td style=" white-space: nowrap;" class="" ><%=step1Securisation.getState()%></td>

                            <td style=" white-space: nowrap;" class="" ><%=new SimpleDateFormat("MM/dd/yyyy").format(step1Securisation.getStartDate())%></td>
                            <td style=" white-space: nowrap;" class="" ><%=new SimpleDateFormat("MM/dd/yyyy").format(step1Securisation.getDeadline())%></td>
                            <td style=" white-space: nowrap;" class="" ><%=step1Securisation.getPercentageCompleted()%>%</td>
                            <td style=" white-space: nowrap;" class="" ><%=step1Securisation.getAffectedTo().getFirstName() + " " + step1Securisation.getAffectedTo().getName()%></td>
                            <td style=" white-space: nowrap;" class="" ><%=step1Securisation.getDescription()%></td>
                        </tr>
                        <%
                            }

                        %>

                        <%                            for (Step1Action step1Action : step11.getStep1ActionList()) {
                        %>

                        <tr>
                            <td style=" white-space: nowrap;" class="" ><%=step1Action.getId()%></td>
                            <td style=" white-space: nowrap;" class="" >Plan de sécurisation</td>
                            <td style=" white-space: nowrap;" class="" ><%=step1Action.getPriority()%></td>
                            <td style=" white-space: nowrap;" class="" ><%=step1Action.getState()%></td>
                            <td style=" white-space: nowrap;" class="" ><%=new SimpleDateFormat("MM/dd/yyyy").format(step1Action.getStartDate())%></td>
                            <td style=" white-space: nowrap;" class="" ><%=new SimpleDateFormat("MM/dd/yyyy").format(step1Action.getDeadline())%></td>
                            <td style=" white-space: nowrap;" class="" ><%=step1Action.getPercentageCompleted()%>%</td>
                            <td style=" white-space: nowrap;" class="" ><%=step1Action.getAffectedTo().getFirstName() + " " + step1Action.getAffectedTo().getName()%></td>
                            <td style=" white-space: nowrap;" class="" ><%=step1Action.getDescription()%></td>
                        </tr>
                        <%
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

