<%@page import="entity.*"%>
<%@page import="service.*"%>
<%@page import="domaine.Design"%>
<%@page import="java.util.List"%>

<%
    User userContent = (User) session.getAttribute("user");
%>



<div class="card bg-light mb-3" >
    <div class="card-header w3-padding-small">
        <div class="w3-left">
            <span> <i class="fa fa-bars"></i> List Notification </span>
        </div>
        <div class="w3-right">
            <form action="<%=application.getContextPath()%>/ListNotification" method="post">
                <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                            return true;
                        } else {
                            return false;
                        }" style="border-radius: 5px;margin:3px;" name="removeAll" type="submit" class="btn btn-danger ti-trash btn-sm"> 
                </button>
            </form> 
        </div>
    </div>
    <div class="card-body w3-white">
        <table id=""  class="w3-table table-sm display responsive no-wrap w3-round w3-border w3-border-blue-gray" style="width:100%">
            <thead class="w3-blue-gray">
                <tr>
                    <th>Photo&nbsp;&nbsp;</th>
                    <th>Utilisateur&nbsp;&nbsp;</th>
                    <th>Titre</th>
                    
                    
                    <th>Piece_Mauvaise&nbsp;&nbsp;</th>
                    <th>Piece_Bonne&nbsp;&nbsp; &nbsp;</th>
                    <th>Probleme&nbsp;&nbsp;&nbsp;</th>
                    <th>Type_de_probleme&nbsp;&nbsp;&nbsp;</th>
                    <th>Date&nbsp;&nbsp;</th>
                    <td class="disabled-sorting" >&nbsp;&nbsp;</td>

                </tr>
            </thead>
            <tbody>
                <%
                    List<Notification> listNotification = userContent.getNotificationList();
                    for (Notification notification : listNotification) {
                        User u = notification.getIdUser();
                        Problem problem = notification.getIdProblem();
                        Step1 step1 = problem.getIdStep1();
                        TypeProblem typeProblem = problem.getIdTypeProblem();
                        User userProblem = problem.getIdUser();
                %>
                <tr>
                    <td>
                        <img class="w3-border w3-border-dark-gray w3-round" width="40px" height="40px" src="<%=application.getContextPath()%>/img/profile/<%=userProblem.getPicture()%>" alt="...">
                    </td>
                    <td><%=userProblem.getFirstName() + " " + userProblem.getName()%></td>
                    <td><%=notification.getTitle()%></td>
                    
                    <td>
                        <img class="w3-border w3-border-dark-gray w3-round" width="40px" height="40px" src="<%=application.getContextPath()%>/upload/<%=step1.getBadPiece()%>" alt="...">
                    </td>
                    <td>
                        <img class="w3-border w3-border-dark-gray w3-round" width="40px" height="40px" src="<%=application.getContextPath()%>/upload/<%=step1.getGoodPiece()%>" alt="...">
                    </td>
                    <td><%=problem.getCode()%></td>
                    <td><%=typeProblem.getName()%></td>
                    <td><%=notification.getDateCreation()%></td>
                    <td>
                        <a href="<%=application.getContextPath()%>/Notification?id=<%=notification.getId()%>" class="btn w3-white  fa fa-external-link"> 
                        </a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

    </div>    
</div>


