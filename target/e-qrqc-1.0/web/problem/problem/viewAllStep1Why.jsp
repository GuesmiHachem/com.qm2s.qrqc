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
    Step1 step1 = problem_ajax.getIdStep1();
    List<Step1Why> listStep1Why_ajax = step1.getStep1WhyList();


%>

<div class="row">
    <br>
    <div class="col-lg-12">
        <div class="<%=Design.cadreTable%>">
            <table  class="<%=Design.table%>" cellspacing="0" width="100%" style="width:100%">
                <thead>
                    <tr class="">
                        <th  scope="col">#</th>
                        <th  scope="col">pourquoi</th>
                        <th  scope="col">Commentaire</th>
                        <th  scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (int i = 0; i < listStep1Why_ajax.size(); i++) {
                            Step1Why step1Why = listStep1Why_ajax.get(i);
                    %>
                    <tr>
                        <td><%=(i + 1)%></td>
                        <td><%=step1Why.getWhy()%></td>
                        <td><%=step1Why.getComment()%></td>
                        <td>
                            
                            <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {

                                            _deleteStep1Why(<%=step1Why.getId()%>);
                                            return true;
                                        } else {
                                            return false;
                                        }" name="destroyWhy" type="button" class="<%=Design.btn%> w3-hover-pink ti-close"> 
                            </button>
                            <button
                                type="button" class="<%=Design.btn%> w3-hover-blue ti-pencil-alt" data-toggle="modal" data-target="#why<%=step1Why.getId()%>" > 
                            </button>

                        </td>
                    </tr>
                    <%}%>
                    <%
                        for (int i = listStep1Why_ajax.size(); i < 5; i++) {
                    %>
                    <tr>
                        <td><%=(i + 1)%></td>
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
