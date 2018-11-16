<%-- 
    Document   : left
    Created on : 23 oct. 2018, 14:39:47
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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<div class="row">


    <div class="col-lg-12">
        <div class="card mb-3" >
            <div class="card-header font-weight-bold">
                Mon Profile    
            </div>
            <%                String src1 = "";
                if (user_nav.getPicture() == null) {
                    src1 = application.getContextPath() + "/img/profile/user.png";
                } else if (user_nav.getPicture().equals("")) {
                    src1 = application.getContextPath() + "/img/profile/user.png";
                } else {
                    src1 = application.getContextPath() + "/img/profile/" + user_nav.getPicture();
                }
            %> 
            <a href="<%=application.getContextPath()%>/MyProfile">
                <img class="card-img-top ui medium image rounded" src="<%=src1%>" alt="...">
            </a>

            <div class="card-body">
                <a href="<%=application.getContextPath()%>/MyProfile" class="header"><h3 class="card-title"><%=user_nav.getName() + " " + user_nav.getFirstName()%></h3></a>               
            </div>

        </div>
    </div>   

    <div class="col-lg-12 ">
        <div class="row">
            <div class="col-lg-12 col-md-6">
                <div class="list-group">
                    <a href="#" class="list-group-item list-group-item-action">
                        <i class="fa fa-briefcase"></i>
                        <%=user_nav.getIdTypeUser().getName()%>
                    </a>
                    <a href="#" class="list-group-item list-group-item-action">
                        <i class="fa fa-group"></i>
                        <%
                            if (user_nav.getIdLevel0() != null) {
                                out.print(user_nav.getIdLevel0().getName());
                            }
                        %>
                    </a>
                    <a href="#" class="list-group-item list-group-item-action">
                        <i class="ti-time"></i>
                        <% if (rankTeamNow.equals(user_nav.getIdLevel0().getIdRankTeam())) {%>

                        <span class="w3-text-green font-weight-bold"><%=sdf_nav.format(rankteam.getStartTime()) + " <i class='fa fa-arrows-h'></i> " + sdf_nav.format(rankteam.getEndTime())%></span>
                        <% } else {%>
                        <span class="w3-text-red font-weight-bold"><%=sdf_nav.format(rankteam.getStartTime()) + " <i class='fa fa-arrows-h'></i> " + sdf_nav.format(rankteam.getEndTime())%></span>
                        <% }%>
                    </a>

                    <%
                        String permission_left = (String) session.getAttribute("permission");
                        if (permission_left.equals("yes")) {
                    %>
                    <a href="#" class="list-group-item list-group-item-action w3-green">
                        Tous les droits 
                        <i class="fa fa-check w3-text-white w3-meduim"></i>
                    </a>
                    <% } else {%>
                    <a href="#" class="list-group-item list-group-item-action w3-pink">
                        Lecture seule 
                        <i class="fa fa-times w3-text-white w3-meduim"></i>
                    </a>
                    <% }%>
                </div>
                <br>
            </div>               
            <div class="col-lg-12 col-md-6">
                <% if (user_nav.getIdLevel0() != null) {%>
                <div class="list-group">
                    <a href="#" class="list-group-item list-group-item-action w3-light-grey">
                        <i class="fa fa-map-marker w3-meduim"></i>
                        Ma position actuelle
                    </a>
                    <a href="#" class="list-group-item list-group-item-action ">
                        <i class="fa fa-chevron-circle-right w3-meduim"></i>
                        <%=user_nav.getIdLevel0().getName()%>
                    </a>
                    <a href="#" class="list-group-item list-group-item-action ">
                        <i class="fa fa-chevron-circle-right w3-meduim"></i>
                        <%=user_nav.getIdLevel0().getIdLevel1().getName()%>
                    </a>
                    <a href="#" class="list-group-item list-group-item-action ">
                        <i class="fa fa-chevron-circle-right w3-meduim"></i>
                        <%=user_nav.getIdLevel0().getIdLevel1().getIdLevel2().getName()%>
                    </a>
                    <a href="#" class="list-group-item list-group-item-action">
                        <i class="fa fa-chevron-circle-right w3-meduim"></i>
                        <%=user_nav.getIdLevel0().getIdLevel1().getIdLevel2().getIdLevel3().getName()%>
                    </a>
                </div>
                <% }%> 
            </div>
        </div>
    </div>
</div>
