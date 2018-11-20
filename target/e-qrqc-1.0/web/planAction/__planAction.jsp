
<%@page import="entity.*"%>
<%@page import="service.*"%>

<%@page import="servlet.PlanAction"%>
<%@page import="java.io.ObjectOutputStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collections"%>
<%@page import="domaine.Design"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ResourceBundle"%>

<%

    ResourceBundle bundle = (ResourceBundle) session.getAttribute("bundle");

%>

<div class="card  mb-3" >
    <div class="card-header bg-light w3-padding-small">
        Plan d'Action
    </div>
    <div class="card-body w3-white">
        <div class="row">
            <div class="col-lg-12 ">

                <table id=""  class="w3-table display responsive no-wrap w3-round w3-border w3-border-blue-gray" style="width:100%">
                    <thead class="w3-blue-gray">
                        <tr>
                            <th style=" white-space: nowrap;"> Code_Problem</th>
                            <th style=" white-space: nowrap;"> Status</th>

                            <th class="w3-dark-gray" style=" white-space: nowrap;"> Action</th>
                            <th class="w3-dark-gray" style=" white-space: nowrap;"> Quand</th>
                            <th class="w3-dark-gray" style=" white-space: nowrap;"> Qui</th>
                            <th class="w3-dark-gray" style=" white-space: nowrap;"> Commentaire</th>

                        </tr>
                    </thead>
                    <tbody>
                        <%                            
                            Iterator<Step1> itStep1 = ServiceStep1.findAll().iterator();

                            String color1 = "w3-light-gray";
                            String color2 = "w3-white";
                            String color = color1;
                            while (itStep1.hasNext()) {

                                Step1 step1 = itStep1.next();
                                Problem problem = step1.getIdProblem();
                                if(problem==null){continue;}
                                User user = problem.getIdUser();
                                if(user==null){continue;}
                                TypeProblem typeProblem = problem.getIdTypeProblem();
                                 if(typeProblem==null){continue;}
                                Iterator<Step1Action> itPlanAction = step1.getStep1ActionList().iterator();

                                if (itPlanAction.hasNext()) {

                                    if (color.equals(color1)) {
                                        color = color2;
                                    } else {
                                        color = color1;
                                    }

                                    while (itPlanAction.hasNext()) {

                                        Step1Action step1Action = itPlanAction.next();

                        %>
                        <tr class="<%=color%>">


                            <td ><a href="Problem?id=<%=problem.getId()%>" ><span class="w3-tag w3-padding w3-round"  style="background-color: <%=typeProblem.getColor()%>"><%=problem.getCode()%></span></a></td>
                            <td><%=step1Action.getStatus()%>% </td>

                            <td ><%= step1Action.getAction()%> </td>
                            <td ><%= step1Action.getWhen()%></td>
                            <td ><%= step1Action.getWho().getFirstName()+" "+step1Action.getWho().getName()%> </td>
                            <td ><%= step1Action.getComment()%> </td>


                        </tr>
                        <%
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
