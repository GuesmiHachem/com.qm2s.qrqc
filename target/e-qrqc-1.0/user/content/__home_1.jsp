<%-- 
    Document   : __overview
    Created on : 16 juin 2018, 19:41:16
    Author     : Hachem
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="domaine.Design"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="entity.*"%>
<%@page import="service.*"%>

<%
    session = ServiceUser.refreshSessionUser(session);
    User userContent = (User) session.getAttribute("user");

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
%>
<div class="content " >
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">

                <% if (userContent.getIdTypeUser().getName().equals("Administrateur")) {%>
                <div class="card w3-white w3-border-grey w3-border">
                    <div class="card-content">


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
                </div>
                <% } else {%>

                <div class="card w3-white w3-border-grey w3-border">
                    <div class="card-content ">  

                        <!--==================================-->
                        <div class="row">
                            <div class="col-lg-12 ">

                                <div class="<%=Design.containerTitle%> ">
                                    <h3 class="<%=Design.textTitle%>">Liste des problémes  (Niveau E) <b class=" w3-meduim w3-round w3-badge w3-pink"><%=listProblemNivE.size()%></b></h3>
                                </div>
                                <br>
                                <div class="">
                                    <div class="<%=Design.cadreTable%>">
                                        <table id="datatables1"  class="<%=Design.table%>" cellspacing="0" width="100%" >
                                            <thead >
                                                <tr class="w3-light-gray w3-text-dark-gray w3-small" >
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

                                                    //Iterator<Problem> it = userContent.getIdLevel0().getIdLevel1().getProblemList().iterator();
                                                    //Iterator<Problem> it = userContent.getProblemList().iterator();
                                                    // Iterator<Problem> it = ServiceProblem.findAll().iterator();
                                                    //List<Problem> listProblem = userContent.getIdLevel0().getIdLevel1().getProblemList();
                                                    //List<Problem> listProblemNivE = userContent.getProblemList();
                                                    // List<Problem> listProblem =ServiceProblem.findAll();
                                                    for (Problem p : listProblemNivE) {
                                                        //while (it.hasNext()) {
                                                        // problem = it.next();
                                                        typeProblem = p.getIdTypeProblem();
                                                        step1 = p.getIdStep1();
                                                        user = p.getIdUser();
                                                        if (step1 != null) {
                                                            if (user != null) {
                                                                typeuser = user.getIdTypeUser();
                                                            }

                                                %>
                                                <tr style="background-colodr: <%=typeProblem.getColor()%>">


                                                    <td ><span class="w3-tag w3-padding w3-round"  style="background-color: <%=typeProblem.getColor()%>"><%=p.getCode()%></span></td>
                                                    <td><%=p.getStatus()%> </td>



                                                    <td><%=p.getReference()%></td>
                                                    <td class=""><%=typeProblem.getName()%></td>
                                                    <td><%=p.getDateCreation().toLocaleString()%></td>

                                                    <td>
                                                        <form action="<%=application.getContextPath()%>/ListProblem" method="post">
                                                            <a href="Problem?id=<%=p.getId()%>" class="<%=Design.btn%> w3-text-green ti-eye " ></a>

                                                            <input hidden name="id" type="text" value="<%= p.getId()%>">
                                                            <button name="removeProblem" type="submit" class="<%=Design.btn%> w3-text-pink fa fa-trash"></button>
                                                            <a href="ProblemPdf?id=<%=p.getId()%>" class="<%=Design.btn%> w3-text-red fa fa-file-pdf-o " ></a>

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
                            </div>
                        </div>
                        <!--==================================-->  
                    </div>
                </div>
                <div class="card w3-white w3-border-grey w3-border">
                    <div class="card-content ">  
                        <div class="row">
                            <div class="col-lg-12 ">

                                <div class="<%=Design.containerTitle%> ">
                                    <h3 class="<%=Design.textTitle%>">Liste des problémes  (Niveau 1) <b class="w3-meduim w3-round w3-badge w3-pink"><%=listProblemNiv1.size()%></b></h3>
                                </div>
                                <br>
                                <div class="">
                                    <div class="<%=Design.cadreTable%>">
                                        <table id="datatables1"  class="<%=Design.table%>" cellspacing="0" width="100%" >
                                            <thead >
                                                <tr class="w3-light-gray w3-text-dark-gray w3-small" >
                                                    <th> Code&nbsp;</th>
                                                    <th> Status&nbsp;</th>

                                                    <th> Utilisateur&nbsp;</th>
                                                    <th> Niveau_E&nbsp;</th>
                                                    <th> Niveau_1&nbsp;</th>

                                                    <th> Référence&nbsp;</th>
                                                    <th> Type_de_problem&nbsp;</th>
                                                    <th> Date_creation&nbsp;</th>

                                                    <th class="disabled-sorting"> </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%

                                                    //Iterator<Problem> it = userContent.getIdLevel0().getIdLevel1().getProblemList().iterator();
                                                    //Iterator<Problem> it = userContent.getProblemList().iterator();
                                                    // Iterator<Problem> it = ServiceProblem.findAll().iterator();
                                                    // List<Problem> listProblemNiv1 = userContent.getIdLevel0().getIdLevel1().getProblemList();
                                                    //List<Problem> listProblem = userContent.getProblemList();
                                                    // List<Problem> listProblem =ServiceProblem.findAll();
                                                    for (Problem p : listProblemNiv1) {
                                                        //while (it.hasNext()) {
                                                        // problem = it.next();
                                                        typeProblem = p.getIdTypeProblem();
                                                        step1 = p.getIdStep1();
                                                        user = p.getIdUser();
                                                        if (step1 != null) {
                                                            if (user != null) {
                                                                typeuser = user.getIdTypeUser();
                                                            }

                                                %>
                                                <tr>


                                                    <td ><span class="w3-tag w3-padding w3-round"  style="background-color: <%=typeProblem.getColor()%>"><%=p.getCode()%></span></td>
                                                    <td><%=p.getStatus()%> </td>

                                                    <td><%=p.getIdUser().getFirstName() + " " + p.getIdUser().getName()%></td>
                                                    <td><%=p.getIdUser().getIdLevel0().getName()%> </td>
                                                    <td><%=p.getIdLevel1().getName()%> </td>



                                                    <td><%=p.getReference()%></td>
                                                    <td style="color: <%=typeProblem.getColor()%>" class=""><%=typeProblem.getName()%></td>
                                                    <td style=" white-space: nowrap;"><%=p.getDateCreation().toLocaleString()%></td>
                                                    <td>
                                                        <form action="<%=application.getContextPath()%>/ListProblem" method="post">
                                                            <a href="Problem?id=<%=p.getId()%>" class="w3-white w3-text-green ti-eye " ></a>
                                                            <input hidden name="id" type="text" value="<%= p.getId()%>">
                                                            <button name="removeProblem" type="submit" class="w3-white  w3-text-pink fa fa-trash"></button>
                                                            <a href="ProblemPdf?id=<%=p.getId()%>" class="w3-white  w3-text-red fa fa-file-pdf-o " ></a>
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
                            </div>
                        </div>
                        <!--==================================-->
                    </div>
                </div>

                <div class="card w3-white w3-border-grey w3-border">
                    <div class="card-content ">  

                        <!--==================================-->
                        <div class="row">
                            <div class="col-lg-12 ">

                                <div class="w3-container w3-round w3-green ">
                                    <h3 class="<%=Design.textTitle%>">Plan d'Action</h3>
                                </div>
                                <div class="">
                                    <br>
                                    <div class="<%=Design.cadreTable%>">
                                        <table id="datatables2"  class="<%=Design.table%>" cellspacing="0" width="100%" >
                                            <thead >
                                                <tr class="w3-light-gray w3-text-dark-gray w3-small" >

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

                                                    String color1 = "w3-lime";
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
                                                        50%
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
                            </div>
                        </div>
                        <!--==================================-->                    
                    </div>
                </div>
                <% }%>

            </div>
        </div>
    </div>
</div>