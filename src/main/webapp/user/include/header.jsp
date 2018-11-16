<%-- 
    Document   : header
    Created on : 23 oct. 2018, 10:43:53
    Author     : Hachem
--%>
<%@page import="entity.Problem"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="entity.Notification"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entity.User"%>
<style>
    body {margin:0;font-family:Arial}

    .topnav {
        overflow: hidden;
        background-color: #333;
    }

    .topnav a {
        float: left;
        display: block;
        color: #f2f2f2;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-size: 17px;
    }

    .active {
        background-color: #4CAF50;
        color: white;
    }

    .topnav .icon {
        display: none;
    }

    .dropdown1 {
        float: left;
        overflow: hidden;
    }

    .dropdown1 .dropbtn1 {
        font-size: 17px;    
        border: none;
        outline: none;
        color: white;
        padding: 14px 16px;
        background-color: inherit;
        font-family: inherit;
        margin: 0;
    }

    .dropdown-content1 {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
    }

    .dropdown-content1 a {
        float: none;
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
        text-align: left;
    }

    .topnav a:hover, .dropdown1:hover .dropbtn1 {
        background-color: #555;
        color: white;
    }

    .dropdown-content1 a:hover {
        background-color: #ddd;
        color: black;
    }

    .dropdown1:hover .dropdown-content1 {
        display: block;
    }

    @media screen and (max-width: 800px) {
        .topnav a:not(:first-child), .dropdown1 .dropbtn1 {
            display: none;
        }
        .topnav a.icon {
            float: right;
            display: block;
        }
    }

    @media screen and (max-width: 800px) {
        .topnav.responsive {position: relative;}
        .topnav.responsive .icon {
            position: absolute;
            right: 0;
            top: 0;
        }
        .topnav.responsive a {
            float: none;
            display: block;
            text-align: left;
        }
        .topnav.responsive .dropdown1 {float: none;}
        .topnav.responsive .dropdown-content1 {position: relative;}
        .topnav.responsive .dropdown1 .dropbtn1 {
            display: block;
            width: 100%;
            text-align: left;
        }
    }
    /* ============================================================= */
    /* width */
    ::-webkit-scrollbar {
        width: 5px;
    }

    /* Track */
    ::-webkit-scrollbar-track {
        background: #f1f1f1; 
    }

    /* Handle */
    ::-webkit-scrollbar-thumb {
        background: #888; 
    }

    /* Handle on hover */
    ::-webkit-scrollbar-thumb:hover {
        background: #555; 
    }
    /* ============================================================= */

    on personnalise le label comme on veut
    .label-file {
        cursor: pointer;
        color: #00b1ca;
        font-weight: bold;
    }
    .label-file:hover {
        color: #25a5c4;
    }

     et on masque le input
    .input-file {
        display: none;
    }

    
    
    
    .material-switch > input[type="checkbox"] {
    display: none;   
}

.material-switch > label {
    cursor: pointer;
    height: 0px;
    position: relative; 
    width: 40px;  
}

.material-switch > label::before {
    background: rgb(0, 0, 0);
    box-shadow: inset 0px 0px 10px rgba(0, 0, 0, 0.5);
    border-radius: 8px;
    content: '';
    height: 16px;
    margin-top: -8px;
    position:absolute;
    opacity: 0.3;
    transition: all 0.4s ease-in-out;
    width: 40px;
}
.material-switch > label::after {
    background: rgb(255, 255, 255);
    border-radius: 16px;
    box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
    content: '';
    height: 24px;
    left: -4px;
    margin-top: -8px;
    position: absolute;
    top: -4px;
    transition: all 0.3s ease-in-out;
    width: 24px;
}
.material-switch > input[type="checkbox"]:checked + label::before {
    background: inherit;
    opacity: 0.5;
}
.material-switch > input[type="checkbox"]:checked + label::after {
    background: inherit;
    left: 20px;
}
</style>

<%
    User user_header = (User) session.getAttribute("user");
    List<Notification> listNotification_header = new ArrayList();
    DateFormat sdf_nav_date = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat sdf_nav_time = new SimpleDateFormat("HH:mm");
    if (user_header != null) {
        listNotification_header = user_header.getNotificationList();
    }

%>


<div class="topnav  w3-margin1" id="myTopnav">
    <a href="<%=application.getContextPath()%>/Home" class="w3-light-gray w3-medium w3-text-dark-gray font-weight-bold">
        <i class="fa fa-home w3-medium "></i>
        Home
    </a>
    <a href="<%=application.getContextPath()%>/ListProblem" class="w3-medium">
        <i class="fa fa-warning w3-text-light-gray"></i>
        QRQC
    </a>
    <a href="<%=application.getContextPath()%>/PlanAction" class="w3-medium">
        <i class="fa fa-tasks w3-text-light-gray"></i>
        Plan d'action
    </a>






    <div class="dropdown1 w3-right1">
        <button class="dropbtn1 w3-medium">
            <i class="fa fa-user w3-text-light-gray"></i>
            <%= user_header.getFirstName()+" "+user_header.getName()%>
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content1">
            <a href="MyProfile" class="w3-medium">
                <i class="fa fa-id-badge"></i>
                Mon Profile
            </a>
            <a href="#" class="w3-medium">
                <i class="fa fa-pencil-square-o"></i>
                Editer mon Profile
            </a>
        </div>
    </div> 
    <div class="dropdown1 w3-right1 w3-dark-gray">
        <button class="dropbtn1 w3-medium">
            <i class="fa fa-bell w3-text-red"></i>
            &nbsp;
            <span class="badge badge-danger">+<%=listNotification_header.size()%></span>
            &nbsp;
        </button>
        <div class="dropdown-content1">
            <div class="">
                <a href="#" class="w3-padding w3-white">
                    <div class="row">
                        <div class="col-lg-12">
                            <span class="w3-small">Notification</span>
                        </div>
                    </div>
                </a>
                <%
                    if (listNotification_header.size() <= 4) {
                %>
                <%
                    for (int i = listNotification_header.size() - 1; i >= 0; i--) {
                        Notification notification = listNotification_header.get(i);
                        Problem problemNot=notification.getIdProblem();
                        User userNot = notification.getIdUser();
                %>
                <a href="Notification?id=<%=notification.getId()%>" class="w3-padding-small">
                    <div class="row">
                        <div class="col-3">
                            <img class="ui avatar image" src="<%=application.getContextPath()%>/img/profile/<%=problemNot.getIdUser().getPicture()%>">
                        </div>
                        <div class="col-5 " stylec=" white-space: nowrap;">
                            <span class="w3-small "><%=notification.getTitle()%></span>
                        </div>
                        <div class="col-4">
                            <span class="w3-tiny w3-text-gray">
                                <i class="fa fa-calendar"></i>
                                <%=sdf_nav_date.format(notification.getDateCreation())%>
                            </span>
                            <br>
                            <span class="w3-tiny w3-text-gray">
                                <i class="ti-time"></i>
                                <%=sdf_nav_time.format(notification.getDateCreation())%>
                            </span>
                        </div>
                    </div>
                </a>
                <%}
                } else {
                %>

                <%
                    for (int i = listNotification_header.size() - 1; i >= listNotification_header.size() - 4; i--) {
                         Notification notification = listNotification_header.get(i);
                        Problem problemNot=notification.getIdProblem();
                        User userNot = notification.getIdUser();
                %>
                <a href="Notification?id=<%=notification.getId()%>" class="w3-padding-small">
                    <div class="row">
                        <div class="col-3">
                             <img class="ui avatar image" src="<%=application.getContextPath()%>/img/profile/<%=problemNot.getIdUser().getPicture()%>">
                        </div>
                        <div class="col-5 " style=" white-space: nowrap;">
                            <span class="w3-small">
                                <%=userNot.getFirstName() + " " + userNot.getName()%>
                            </span>
                            <br>
                            <span class="w3-tiny w3-text-blue"> <%=notification.getIdProblem().getCode()%></span>
                            <span class="w3-tiny w3-text-dark-gray " >
                                <i class="fa fa-warning"></i>
                                <%=notification.getIdProblem().getIdTypeProblem().getName()%>
                            </span>
                            <br>
                            <span class="w3-tiny "><%=notification.getTitle()%></span>
                            
                        </div>
                        <div class="col-4">
                            <span class="w3-tiny w3-text-gray">
                                <i class="fa fa-calendar"></i>
                                <%=sdf_nav_date.format(notification.getDateCreation())%>
                            </span>
                            <br>
                            <span class="w3-tiny w3-text-gray">
                                <i class="ti-time"></i>
                                <%=sdf_nav_time.format(notification.getDateCreation())%>
                            </span>
                        </div>
                    </div>
                </a>
                <%}
                    }%>



                <a href="ListNotification" class="w3-padding w3-light-gray">
                    <div class="row">
                        <div class="col-lg-12">
                            <span class="w3-small">Voir tout</span>
                        </div>
                    </div>
                </a>
            </div>




        </div>
    </div> 

    <a href="<%=application.getContextPath()%>/Logout" class="w3-medium w3-right1">
        <i class="fa fa-sign-out  w3-medium"></i> 
        Déconnexion
    </a>  

    <a href="#" class="icon" onclick="myFunction();">
        <i class="fa fa-bars"></i>
    </a>
</div>

