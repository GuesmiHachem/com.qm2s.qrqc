<%-- 
    Document   : __nav
    Created on : 16 juin 2018, 19:16:17
    Author     : Hachem
--%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="service.*"%>
<%@page import="entity.*"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<style>
    /* width */
    ::-webkit-scrollbar {
        width: 10px;
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
</style>
<%
    User user_nav = (User) session.getAttribute("user");
    user_nav = ServiceUser.find(user_nav.getId());
    String username_nav = user_nav.getFirstName() + " " + user_nav.getName();
    String typeuser_nav = user_nav.getIdTypeUser().getName();
    Level0 level0_nav = user_nav.getIdLevel0();
    Level1 level1_nav = user_nav.getIdLevel1();
    Level2 level2_nav = user_nav.getIdLevel2();
    Level3 level3_nav = user_nav.getIdLevel3();
    RankTeam rankteam = null;
    String name_level0_nav = "";
    String name_level1_nav = "";
    String name_level2_nav = "";
    String name_level3_nav = "";
    DateFormat sdf_nav = new SimpleDateFormat("HH:mm");
    if (level0_nav != null) {
        name_level0_nav = level0_nav.getName();
        name_level1_nav = level0_nav.getIdLevel1().getName();
        name_level2_nav = level0_nav.getIdLevel1().getIdLevel2().getName();
        name_level3_nav = level0_nav.getIdLevel1().getIdLevel2().getIdLevel3().getName();
        rankteam = level0_nav.getIdRankTeam();
    }
    Date date_nav = new Date(new Date().getTime());
    RankTeam rankTeamNow = ServiceRankTeam.getRankTeam(date_nav);


%>
<% try {%>

<nav class="navbar navbar-default" >
    <div class="container-fluid w3-white">
        <div class="navbar-minimize">
            <button id="minimizeSidebar" class="btn btn-fill btn-icon"><i class="ti-more-alt"></i></button>
        </div>
        <div class="navbar-header">
            <button type="button" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar bar1"></span>
                <span class="icon-bar bar2"></span>
                <span class="icon-bar bar3"></span>
            </button>
        </div>
        <div class="col navbar-header1">
            <div  class="navbar-text">
                <p class="w3-badge w3-tag1 w3-round w3-white w3-border w3-padding"><%=typeuser_nav%></p>
                <%if (level0_nav != null) {%>
                <p class="w3-badge w3-tag w3-round w3-white w3-border w3-padding"><%=name_level0_nav%></p>
                <% if (rankTeamNow.equals(user_nav.getIdLevel0().getIdRankTeam())) {%>

                <p class="w3-badge w3-tag w3-round w3-border w3-white w3-border-green w3-text-green w3-padding"><%=sdf_nav.format(rankteam.getStartTime()) + " <i class='fa fa-arrows-h'></i> " + sdf_nav.format(rankteam.getEndTime())%></p>
                <% } else {%>
                <p class="w3-badge w3-tag w3-round w3-border w3-white w3-border-red w3-text-red w3-padding"><%=sdf_nav.format(rankteam.getStartTime()) + " <i class='fa fa-arrows-h'></i> " + sdf_nav.format(rankteam.getEndTime())%></p>
                <% }%>
                <p class="w3-badge w3-tag w3-round w3-white w3-border w3-padding">

                    <%=name_level1_nav + " "%>
                    <i class="fa fa-chevron-right"></i>
                    <%=name_level2_nav + " "%>
                    <i class="fa fa-chevron-right"></i>
                    <%=name_level3_nav + " "%>
                </p>
                <%}%>
                <%
                    String permission = (String) session.getAttribute("permission");
                    if (permission.equals("yes")) {
                %>
                <p class="w3-badge w3-tag w3-round w3-border w3-green w3-border-green w3-text-green w3-padding w3-text-white"> Tous les droits <i class="fa fa-check w3-text-white w3-meduim"></i></p>
                
                <% } else {%>
                <p class="w3-badge w3-tag w3-round w3-border w3-pink w3-border-pink w3-text-white w3-padding">Lecture seule <i class="fa fa-times w3-text-white w3-meduim"></i></p>
                <% }%>
            </div>
        </div>
        <div class="collapse navbar-collapse">
            <!--
            <form class="navbar-form navbar-left navbar-search-form" role="search">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-search"></i></span>
                    <input type="text" value="" class="form-control" placeholder="Search...">
                </div>
            </form>
            -->

            <ul class="nav navbar-nav navbar-right">

                <li>
                    <a href="#stats" class="dropdown-toggle btn-magnify" data-toggle="dropdown">
                        <i class="w3-text-dark-gray ti-panel"></i>
                        <p class="w3-text-dark-gray"></p>
                    </a>
                </li>



                <%
                    List<Notification> listNotification = new ArrayList();
                    if (user_nav != null) {

                        listNotification = user_nav.getNotificationList();

                %>
                <li class="dropdown">
                    <a href="#notifications" class="dropdown-toggle btn-rotate" data-toggle="dropdown">
                        <%if (listNotification.size() == 0) {%>
                        <i class="w3-text-dark-gray fa fa-bell"></i>
                        <span class="notification"></span>
                        <%} else {%>
                        <i class="w3-text-red fa fa-bell"></i>
                        <span class="notification w3-text-dark-gray"><%= listNotification.size()%></span>
                        <%}%>
                        <p class="w3-text-dark-gray w3-medium  hidden-md hidden-lg ">
                            Notifications
                            <b class="w3-text-dark-gray caret "></b>
                        </p>
                    </a>
                    <ul class="dropdown-menu" style="height: <%=(listNotification.size() < 5) ? listNotification.size() * 90 + 40 : 490%>px; overflow: auto; width: 600px;   
                        overflow: auto;    
                        scrollbar-base-color:#ffeaff">
                        <%
                            Notification not = null;
                            Problem p = null;
                            Step1 s = null;
                            User u = null;
                            for (int i = listNotification.size() - 1; i >= 0; i--) {
                                not = listNotification.get(i);
                                if (not.getIdUser().getId() == user_nav.getId()) {

                                    p = not.getIdProblem();
                                    s = not.getIdProblem().getIdStep1();
                                    u = p.getIdUser();
                        %>
                        <li class="w3-border-bottom">
                            <a class="w3-hover-light-gray" href="<%=application.getContextPath()%>/Notification?id=<%=not.getId()%>">
                                <div class="w3-row " >
                                    <div class="w3-col l12" >
                                        <p class="w3-small w3-text-black w3-round w3-hover-light-gray w3-text-gray" >
                                            <img class="w3-border w3-border w3-round " width="50px" height="50px" src="<%=application.getContextPath()%>/img/profile/<%=u.getPicture()%>" alt="...">

                                            <span ><label class="w3-text-black"> Code </label>  <%=p.getCode()%> </span> 
                                            <span class="hidden-md hidden-sm hidden-xs"><label class="w3-text-black ">Reference </label> <%=p.getReference()%></span>
                                            <small class="w3-tiny w3-text-gray w3-right hidden-md hidden-sm hidden-xs"><%=not.getDateCreation()%></small>
                                        </p>
                                    </div>
                                </div>
                            </a>
                        </li>

                        <%
                                }
                            }
                        %>
                        <li class="w3-light-gray w3-hover-light-gray">
                            <a href="ListNotification">
                                Voir tout les notification
                            </a>
                        </li>
                    </ul>
                </li>
                <%
                    }
                %>


                <li class="dropdown">
                    <a href="#notifications" class="dropdown-toggle btn-rotate" data-toggle="dropdown">
                        <i class="w3-text-dark-gray  ti-world"></i>
                        <p class="w3-text-dark-gray w3-medium hidden-md hidden-lg">
                            Langue
                            <b class="caret w3-text-dark-gray"></b>
                        </p>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a class="" href="javascript:window.location.reload()" onclick="changeLangue('en')" >
                                <img width="30px" width="20px" src="<%=application.getContextPath()%>/assets/img/lang/en.png" alt=""/>
                                EN
                            </a>
                        </li>
                        <li >
                            <a class="" href="javascript:window.location.reload()" onclick="changeLangue('fr')">
                                <img width="30px" width="20px" src="<%=application.getContextPath()%>/assets/img/lang/fr.png" alt=""/>
                                FR
                            </a>
                        </li>
                    </ul>
                </li>
                <%if (user_nav.getIdTypeUser().getName().equals("Administrateur")) {%>
                <li class="dropdown">
                    <a href="#notifications" class="dropdown-toggle btn-rotate" data-toggle="dropdown">
                        <i class="w3-text-dark-gray  ti-settings"></i>
                        <p class="w3-text-dark-gray w3-medium hidden-md hidden-lg">
                            Settings
                            <b class="caret w3-text-dark-gray"></b>
                        </p>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a class="">
                                Societe
                            </a>
                        </li>
                        <li>
                            <a href="<%=application.getContextPath()%>/ListRankTeam" >
                                Rang des equipes
                            </a>
                        </li>
                        <li>
                            <a href="<%=application.getContextPath()%>/ListUser" >
                                Utilisateur
                            </a>
                        </li>
                        <li>
                            <a href="<%=application.getContextPath()%>/ListNotification" >
                                Notifications
                            </a>
                        </li>
                        <li>
                            <a href="<%=application.getContextPath()%>/Level">
                                Architecture d'usine
                            </a>
                        </li>
                        <li>
                            <a href="<%=application.getContextPath()%>/ListTypeUser">
                                Type d'utilisateur
                            </a>
                        </li>
                        <li>
                            <a href="<%=application.getContextPath()%>/ListTypeProblem">
                                Type de problem
                            </a>
                        </li>
                        <li>
                            <a href="<%=application.getContextPath()%>/ListNature">
                                Nature de processus
                            </a>
                        </li>
                        <li>
                            <a href="<%=application.getContextPath()%>/ListProcessus">
                                Processus
                            </a>
                        </li>
                    </ul>
                </li>
                <%}%>
                <li>
                    <a href="<%=application.getContextPath()%>/Logout" class="btn-rotate">
                        <i class="w3-text-dark-gray ti-lock"></i>
                        <p class="w3-text-dark-gray w3-medium hidden-md hidden-lg">
                            Logout
                        </p>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<%
    listNotification = null;
    // s = null;
    //u = null;

%>
<% } catch (Exception ex) {%>
<% //response.sendRedirect("home.jsp");%>
<% }%>

<script>

    function changeLangue(lang) {

        var xmlhttp = new XMLHttpRequest();
        //beep();
        xmlhttp.open("GET", "changeLangue.jsp?lang=" + lang, true);
        xmlhttp.send();
    }
    /*
     
     window.onload = function () {
     loadNotification();
     beep();
     setInterval(loadNotification, 5000);
     }
     
     function beep() {
     var snd = new Audio("file.mp3"); // buffers automatically when created
     snd.play();
     }
     */
</script>


