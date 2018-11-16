<%-- 
    Document   : problem_comment
    Created on : 28 sept. 2018, 13:48:23
    Author     : Hachem
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="entity.*"%>
<%@page import="service.*"%>


<%@page import="domaine.Design"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>




<%
    String id_problem_ajax = request.getParameter("id");
    Problem problem_ajax = ServiceProblem.find(Integer.parseInt(id_problem_ajax));
    String permission = (String) session.getAttribute("permission");
    Step1 step1 = problem_ajax.getIdStep1();
    List<Step1Action> listStep1Action_ajax = step1.getStep1ActionList();


%>
<div class="row">
    <br>
    <div class="col-lg-12">
        <div class="<%=Design.cadreTable%>">
            <table  class="<%=Design.table%>" cellspacing="0" width="100%" style="width:100%">
                <thead>
                    <tr class="">
                        <th  scope="col">#</th>
                        <th  scope="col">Action</th>
                        <th  scope="col">Qui</th>
                        <th  scope="col">Quand</th>
                        <th  scope="col">Commentaire</th>
                        <th  scope="col">
                            <%if (ServiceStep1Action.isAllActionDoing(step1)) {%>
                            <span class="w3-medium w3-text-white w3-tag w3-round w3-green">Status</span>
                            <%} else {%>
                            <span class="w3-medium w3-text-white w3-tag w3-round w3-pink">Status</span>
                            <%}%>
                        </th>
                        <th  scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (int i = 0; i < listStep1Action_ajax.size(); i++) {
                            Step1Action step1Action = listStep1Action_ajax.get(i);
                    %>
                    <tr>
                        <td><%=(i + 1)%></td>
                        <td><%=step1Action.getAction()%></td>
                        <td><%=step1Action.getWho()%></td>
                        <td><%=step1Action.getWhen()%></td>
                        <td><%=step1Action.getComment()%></td>
                        <td>
                            <% if (step1Action.getStatus() == 100) {%>
                            <span class="w3-medium w3-text-white w3-tag w3-round w3-green"><%=step1Action.getStatus()%>%</span>
                            <% } else if (step1Action.getStatus() >= 80) {%>
                            <span class="w3-medium w3-text-white w3-tag w3-round w3-light-green"><%=step1Action.getStatus()%>%</span>
                            <% } else if (step1Action.getStatus() >= 60) {%>
                            <span class="w3-medium w3-text-white w3-tag w3-round w3-lime"><%=step1Action.getStatus()%>%</span>
                            <% } else {%>
                            <span class="w3-text-pink "><%=step1Action.getStatus()%>%</span>
                            <% }%>
                        </td>
                        <td>

                            <%if (permission.equals("yes")) {%>   
                            <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {

                                        _deleteStep1Action(<%=step1Action.getId()%>);
                                        return true;
                                    } else {
                                        return false;
                                    }" name="destroyAction" type="button" class="<%=Design.btn%> w3-hover-pink ti-close"> 
                            </button>
                            <button
                                type="button" class="<%=Design.btn%> w3-hover-blue ti-pencil-alt" data-toggle="modal" data-target="#action<%=step1Action.getId()%>" > 
                            </button>
                            <button onclick="_addStep1ActionStatus(<%=step1Action.getId()%>);"
                                    type="button" class="<%=Design.btn%> ti-plus"> 
                            </button>
                            <button onclick="_minusStep1ActionStatus(<%=step1Action.getId()%>);"
                                    type="button" class="<%=Design.btn%> ti-minus"> 
                            </button>
                            <%} else {%>   

                            <%}%>




                        </td>

                    </tr>

                    <%}%>
                    <%
                        for (int i = listStep1Action_ajax.size(); i < 5; i++) {
                    %>
                    <tr>
                        <td><%=(i + 1)%></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>

            </table>
        </div>
        <br>
    </div>
</div>

