<%-- 
    Document   : demo
    Created on : 2 août 2018, 11:15:39
    Author     : Hachem
--%>

<%@page import="service.*"%>
<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%
    String idTypeUser = request.getParameter("idTypeUser");
%>
<%
    User user_nav = (User) session.getAttribute("user");
    List<Notification> listNotification = new ArrayList();
    if (user_nav != null) {
        listNotification = ServiceNotification.filterByUser(user_nav.getId());

%>

<a href="#notifications" class="dropdown-toggle btn-rotate" data-toggle="dropdown">
    <%if (listNotification.size() == 0) {%>
    <i class="w3-text-dark-gray fa fa-bell"></i>
    <span class="notification"></span>
    <%} else {%>
    <i class="w3-text-red fa fa-bell"></i>
    <span class="notification"><%= listNotification.size()%></span>
    <input type="text" value="<%= listNotification.size()%>" oncuechange="alert('dddd');" onfocus="alert('dddd');" onclick="alert('dddd');">
    <%}%>
    <p class="w3-text-dark-gray w3-medium  hidden-md hidden-lg ">
        Notifications
        <b class="w3-text-dark-gray caret "></b>
    </p>
</a>
<ul class="dropdown-menu" style="height: <%=(listNotification.size() < 5) ? listNotification.size() * 90 + 40 : 490%>px; overflow: auto">
    <li class="w3-light-gray w3-hover-light-gray">
        <a href="Notifications">
            Supprimer tout
        </a>
    </li>
    <%
        for (int i = listNotification.size() - 1; i >= 0; i--) {
            Notification not = listNotification.get(i);

            Problem p = ServiceProblem.find(not.getId_problem());
            Step1 s = p.getStep1();
            User u = ServiceUser.find(s.getId_user());
    %>
    <li class="w3-border-bottom">
        <a class="w3-hover-light-gray" href="<%=application.getContextPath()%>/Notification?id=<%=not.getId()%>">
            <div class="w3-row " >
                <div class="w3-col l12" >
                    <p class="w3-text-black w3-round w3-hover-light-gray" >
                        <img class="w3-border w3-border-black w3-round" width="40px" height="40px" src="<%=application.getContextPath()%>/img/profile/<%=u.getPicture()%>" alt="...">
                        <img class="w3-border w3-border-dark-gray w3-round" width="40px" height="40px" src="<%=application.getContextPath()%>/upload/<%=ServiceProblem.find(not.getId_problem()).getStep1().getBad_piece()%>" alt="...">

                        Code : <%=ServiceProblem.find(not.getId_problem()).getCode()%>  Reference : <%=ServiceProblem.find(not.getId_problem()).getReference()%>  Probleme : <%=ServiceTypeProblem.find(ServiceProblem.find(not.getId_problem()).getStep1().getId_type_problem()).getName()%> 
                    </p>
                    <small><%=not.getDate_creation()%></small>
                </div>
            </div>
        </a>
    </li>

    <%

        }

    %>
    <li class="w3-light-gray w3-hover-light-gray">
        <a href="Notifications">
            Voir tout les notification
        </a>
    </li>

</ul>

<%    }
%>