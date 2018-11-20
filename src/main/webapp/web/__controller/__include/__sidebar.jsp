<%-- 
    Document   : sidebar
    Created on : 16 juin 2018, 19:09:51
    Author     : Hachem
--%>
<%@page import="entity.User"%>
<%
    User user_sidebar = (User) session.getAttribute("user");
%>
<div class="sidebar" data-background-color="white" data-active-color="danger">
    <!--
                Tip 1: you can change the color of the sidebar's background using: data-background-color="white | brown"
                Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
    -->
    <div class="logo w3-white" >
        <a href="https://www.creative-tim.com/" class="simple-text1 logo-mini">
            <span class="fa-1x w3-text-blue">
                e-
            </span>
        </a>

        <a href="https://www.creative-tim.com/" class="simple-text1 logo-normal">
            <span class="w3-text-dark-gray fa-2x">
                <em class="w3-text-blue">e</em>-QRQC <em class="w3-medium">1.0</em>
            </span>
            <!--<img class="img img-no-padding img-responsive float-center img-container"  src="../assets/img/logo.png" />
       style="padding-bottom:180px;padding-top:0px;"
            -->
        </a>
    </div>
    <div class="sidebar-wrapper w3-white">


        <!--=====================================================-->
        <div class="user">
            <div class="photo">
                <%if (user_sidebar.getPicture() == null) {%>
                <img src="<%=application.getContextPath()%>/img/profile/user.png" alt="...">
                <%} else if (user_sidebar.getPicture().equals("")) {%>
                <img src="<%=application.getContextPath()%>/img/profile/user.png" alt="...">
                <%} else {%> 
                <img src="<%=application.getContextPath()%>/img/profile/<%=user_sidebar.getPicture()%>" alt="...">
                <%}%> 
            </div>
            <div class="info">
                <a data-toggle="collapse" href="#collapseExample" class="collapsed">
                    <span class="w3-text-black">
                        <%=(user_sidebar == null) ? " " : user_sidebar.getName()%>
                        <%=(user_sidebar == null) ? " " : user_sidebar.getFirstName()%>
                        <b class="caret"></b>
                    </span>
                </a>
                <div class="clearfix"></div>
                <div class="collapse" id="collapseExample">
                    <ul class="nav">
                        <li>
                            <a class="w3-text-black" href="MyProfile">
                                <span class="sidebar-mini">Mp</span>
                                <span class="sidebar-normal">My Profile</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!--=====================================================-->
        <ul class="nav">
            <!--=====================================================-->
            <li class="">
                <a  href="<%=application.getContextPath()%>/Home" class="btn-rotate">

                    <i class="w3-text-dark-gray ti-home"></i>
                    <p class="w3-text-dark-gray w3-medium ">
                        Home
                    </p>
                </a>
            </li><!--=====================================================-->

            <li class="">
                <a href="<%=application.getContextPath()%>/ListProblem" class="btn-rotate">
                    <i class="w3-text-dark-gray ti-alert"></i>
                    <p class="w3-text-dark-gray w3-medium ">
                        Qrqc
                    </p>
                </a>
            </li>
            <!--=====================================================-->
            <li class="">
                <a href="<%=application.getContextPath()%>/PlanAction" class="btn-rotate">
                    <i class="w3-text-dark-gray ti-view-list"></i>
                    <p class="w3-text-dark-gray w3-medium ">
                        Plan d'Action
                    </p>
                </a>
            </li>

        </ul>
    </div>
</div>