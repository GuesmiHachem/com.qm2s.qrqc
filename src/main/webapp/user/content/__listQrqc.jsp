<%@page import="java.sql.Time"%>
<%@page import="entity.*"%>
<%@page import="service.*"%>
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
    User userContent = (User) session.getAttribute("user");
    String permission = (String) session.getAttribute("permission");
    Problem problem = null;
    Step1 step1 = null;
    User user = null;
    TypeUser typeuser = null;
    TypeProblem typeProblem = null;
    List<Problem> listProblem = ServiceProblem.findAll();

%>

<div class="card bg-light mb-3" >
    <div class="card-header w3-padding-small">
        <div class="w3-left">
            <span> <i class="fa fa-bars"></i> List des QRQC </span>
        </div>
        <div class="w3-right">
            <form action="<%=application.getContextPath()%>/ListNotification" method="post">
                <button  onclick="document.location.href = 'CreateS1P1'"  type="button" class="btn btn-info btn-sm ti-plus w3-right"> 
                </button>
            </form> 
        </div>
    </div>
    <div class="card-body w3-white">
        <table id=""  class="w3-table display responsive no-wrap w3-round w3-border w3-border-blue-gray" style="width:100%">
            <thead class="w3-blue-gray">
                <tr>
                    <th style=" white-space: nowrap;"> Code&nbsp;</th>
                    <th style=" white-space: nowrap;"> Status&nbsp;</th>

                    <th style=" white-space: nowrap;"> Utilisateur&nbsp;</th>
                    <th style=" white-space: nowrap;"> Niveau_E&nbsp;</th>
                    <th style=" white-space: nowrap;"> Niveau_1&nbsp;</th>

                    <th style=" white-space: nowrap;"> Référence&nbsp;</th>
                    <th style=" white-space: nowrap;"> Type_de_problem&nbsp;</th>
                    <th style=" white-space: nowrap;"> Date_creation&nbsp;</th>

                    <th style=" white-space: nowrap;"> Jour&nbsp;</th>
                    <th style=" white-space: nowrap;"> Mois&nbsp;</th>
                    <th style=" white-space: nowrap;"> Année&nbsp;</th>
                    <th style=" white-space: nowrap;"> Heure&nbsp;</th>

                    <th style=" white-space: nowrap;" class="disabled-sorting"> </th>
                </tr>
            </thead>
            <tbody class="w3-small">
                <%                                                    //Iterator<Problem> it = userContent.getIdLevel0().getIdLevel1().getProblemList().iterator();
                    //Iterator<Problem> it = userContent.getProblemList().iterator();
                    // Iterator<Problem> it = ServiceProblem.findAll().iterator();
                    // List<Problem> listProblemNiv1 = userContent.getIdLevel0().getIdLevel1().getProblemList();
                    //List<Problem> listProblem = userContent.getProblemList();
                    // List<Problem> listProblem =ServiceProblem.findAll();
                    for (Problem p : listProblem) {
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

                    <td style=" white-space: nowrap;"><%=p.getDateCreation().getDate()%></td>
                    <td style=" white-space: nowrap;"><%=p.getDateCreation().getMonth() + 1%></td>
                    <td style=" white-space: nowrap;"><%=p.getDateCreation().getYear() + 1900%></td>


                    <td style=" white-space: nowrap;"><%=new Time(p.getDateCreation().getTime())%></td>

                    <td>
                        <form action="<%=application.getContextPath()%>/ListProblem" method="post">
                            <a href="Problem?id=<%=p.getId()%>" class="<%=Design.btn%> w3-text-green ti-eye " ></a>

                            <%if (permission.equals("yes")) {%>    
                            <input hidden name="id" type="text" value="<%= p.getId()%>"/>
                            <button name="removeProblem" type="submit" class="<%=Design.btn%> w3-text-pink fa fa-trash"></button>
                            <button  onclick="document.location.href = 'ProblemPdf?id=<%=p.getId()%>'"  type="button" class="<%=Design.btn%> w3-text-red fa fa-file-pdf-o "> 
                            </button>
                            <%} else {%>    
                            <input hidden name="id" type="text" value="<%= p.getId()%>"/>
                            <button disabled name="removeProblem" type="submit" class="<%=Design.btn%> w3-text-pink fa fa-trash"></button>
                            <button  disabled onclick="document.location.href = 'ProblemPdf?id=<%=p.getId()%>'"  type="button" class="<%=Design.btn%> w3-text-red fa fa-file-pdf-o "> 
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


<!--####################################################################
    #                                                                  #
    #                                                                  #
    ####################################################################-->

<script>


</script>