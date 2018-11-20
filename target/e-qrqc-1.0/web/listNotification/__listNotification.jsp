<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.*"%>
<%@page import="service.*"%>
<%@page import="domaine.Design"%>
<%@page import="java.util.List"%>

<%
    User userContent = (User) session.getAttribute("user");
    DateFormat sdf_date = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat sdf_time = new SimpleDateFormat("HH:mm");
%>



<div class="card bg-light mb-3" >
    <div class="card-header w3-padding-small">
        <div class="w3-left">
            <span> <i class="fa fa-bars"></i> List Notification </span>
        </div>
        <div class="w3-right">
            <form action="<%=application.getContextPath()%>/removeNotification" method="post">
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
        <%
            List<Notification> listNotification = userContent.getNotificationList();
            for (Notification notification : listNotification) {
                User u = notification.getIdUser();
                Problem problem = notification.getIdProblem();
                Step1 step1 = problem.getIdStep1();
                TypeProblem typeProblem = problem.getIdTypeProblem();
                User userProblem = problem.getIdUser();
        %>
        <div class="row">
            <div class="col-lg-12">
                <div class="card mb-3 w3-light-grey1 bg-light ">
                    <div class="card-body">
                        <div class="row w3-padding-small">
                            <div class="col-lg-1 mb-2">
                                <img class="w3-border w3-border-dark-gray w3-round" width="60px" height="60px" src="<%=application.getContextPath()%>/img/profile/<%=userProblem.getPicture()%>" alt="...">
                            </div>
                            <div class="col-lg-1 mb-2">
                                <%=userProblem.getFirstName() + " " + userProblem.getName()%>
                            </div>
                            <div class="col-lg-2 mb-2 w3-text-blue">
                                <%=notification.getTitle()%>
                            </div>
                            <div class="col-lg-1 mb-2">
                                <img class="w3-border w3-border-dark-gray w3-round" width="60px" height="60px" src="<%=application.getContextPath()%>/upload/<%=step1.getBadPiece()%>" alt="...">
                            </div>
                            <div class="col-lg-1 mb-2">
                                <img class="w3-border w3-border-dark-gray w3-round" width="60px" height="60px" src="<%=application.getContextPath()%>/upload/<%=step1.getGoodPiece()%>" alt="...">
                            </div>
                            <div class="col-lg-2 mb-2">
                                <%=problem.getCode()%>
                            </div>
                            <div class="col-lg-1 mb-2">
                                <p style="color: <%=typeProblem.getColor()%>;"><%=typeProblem.getName()%></p>
                            </div>
                            <div class="col-lg-2 mb-2">
                               <%=sdf_date.format(notification.getDateCreation())%>  
                               <%=sdf_time.format(notification.getDateCreation())%>  
                            </div>
                            <div class="col-lg-1 mb-2">
                                <a href="<%=application.getContextPath()%>/Notification?id=<%=notification.getId()%>" class="btn btn-success fa fa-external-link"> 
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%
            }
        %>
    </div>    
</div>

