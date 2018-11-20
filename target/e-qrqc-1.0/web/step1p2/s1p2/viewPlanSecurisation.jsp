<%-- 
    Document   : viewPlanSecurisation
    Created on : 2 nov. 2018, 09:11:01
    Author     : Hachem
--%>
<%@page import="entity.*"%>
<%@page import="service.*"%>
<%@page import="domaine.Design"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.List"%>

<%
    entity.Problem problem = (entity.Problem) session.getAttribute("problem");
    ResourceBundle bundle = (ResourceBundle) session.getAttribute("bundle");
    List<Step1Securisation> listStep1SecurityPlan = (List<Step1Securisation>) session.getAttribute("listSecurityPlan");
%>

<%
    if (listStep1SecurityPlan == null) {
        listStep1SecurityPlan = new ArrayList<Step1Securisation>();
        session.setAttribute("listSecurityPlan", listStep1SecurityPlan);
    }
%>


<% if (listStep1SecurityPlan != null) {%>

<table id=""  class="w3-table display responsive no-wrap w3-round w3-border w3-border-blue-gray" style="width:100%">
    <thead class="w3-blue-gray">
        <tr>
            <th style=" white-space: nowrap;" class="" >#</th>
            <th style=" white-space: nowrap;" class="" >Non de l'action</th>
            <th style=" white-space: nowrap;" class="" >Priorité</th>
            <th style=" white-space: nowrap;" class="" >État</th>
            <th style=" white-space: nowrap;" class="" >Description</th>
            <th style=" white-space: nowrap;" class="" >Date de début</th>
            <th style=" white-space: nowrap;" class="" >Échéance</th>
            <th style=" white-space: nowrap;" class="" >Pourcentage achevé %</th>
            <th style=" white-space: nowrap;" class="" >Affecté à</th>
            <th style=" white-space: nowrap;" class="" >Où</th>
            <th style=" white-space: nowrap;" class="" >Combien ?</th>
            <th style=" white-space: nowrap;" class="" >Resultat ?</th>
            <th style=" white-space: nowrap;" class="" >Supprimer</th>
        </tr>
    </thead>
    <tbody>
        <%
            Step1Securisation step1Securisation = null;
            for (int i = 0; i < listStep1SecurityPlan.size(); i++) {
                step1Securisation = listStep1SecurityPlan.get(i);

        %>

        <tr>

            <td style=" white-space: nowrap;" class="" ><%=(i + 1)%></td>
            <td style=" white-space: nowrap;" class="" >Plan de sécurisation</td>
            <td style=" white-space: nowrap;" class="" ><%=step1Securisation.getPriority()%></td>
            <td style=" white-space: nowrap;" class="" ><%=step1Securisation.getState()%></td>
            <td style=" white-space: nowrap;" class="" ><%=step1Securisation.getDescription()%></td>
            <td style=" white-space: nowrap;" class="" <%=step1Securisation.getStartDate()%></td>
            <td style=" white-space: nowrap;" class="" ><%=step1Securisation.getDeadline()%></td>
            <td style=" white-space: nowrap;" class="" ><%=step1Securisation.getPercentageCompleted()%>%</td>
            <td style=" white-space: nowrap;" class="" ><%=step1Securisation.getAffectedTo().getFirstName() + " " + step1Securisation.getAffectedTo().getName()%></td>
            <td style=" white-space: nowrap;" class="" ><%=step1Securisation.getWhere()%></td>
            <td style=" white-space: nowrap;" class="" ><%=step1Securisation.getHowMutch()%></td>
            <td style=" white-space: nowrap;" class="" ><%=step1Securisation.getResult()%></td>


            <td>

                <button type="button"  title="" class="btn btn-sm btn-danger" onclick="_deletePlanSecurisation(<%=i%>)">
                    <i class="ti-close"></i>
                </button>

            </td>
        </tr>
        <%

            }
        %>
        <%
            for (int i = listStep1SecurityPlan.size(); i < 3; i++) {
        %>
        <tr>
            <td><%=(i + 1)%></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>

        </tr>
        <%
                }
            }

        %>
    </tbody>
</table>



