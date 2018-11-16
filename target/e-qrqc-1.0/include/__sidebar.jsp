<%-- 
    Document   : sidebar
    Created on : 16 juin 2018, 19:09:51
    Author     : Hachem
--%>
<%
    String _page = request.getParameter("page");
%>
<div class="sidebar" data-background-color="brown" data-active-color="danger">
    <!--
                Tip 1: you can change the color of the sidebar's background using: data-background-color="white | brown"
                Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
    -->
    <div class="logo" >
        <a href="https://www.creative-tim.com/" class="simple-text logo-mini">
            <span class="fa-1x">
                QM
            </span>
        </a>

        <a href="https://www.creative-tim.com/" class="simple-text logo-normal">
            <span class="fa-2x">
                QM2S
            </span>
            <!--<img class="img img-no-padding img-responsive float-center img-container"  src="../assets/img/logo.png" />
       style="padding-bottom:180px;padding-top:0px;"
            -->
        </a>
    </div>
    <div class="sidebar-wrapper">


        <!--=====================================================-->
        <div class="user">
            <div class="photo">
                <img src="<%=application.getContextPath()%>/img/profile/002.jpg" />
            </div>
            <div class="info">
                <a data-toggle="collapse" href="#collapseExample" class="collapsed">
                    <span>
                        Guesmi Hachem
                        <b class="caret"></b>
                    </span>
                </a>
                <div class="clearfix"></div>
                <div class="collapse" id="collapseExample">
                    <ul class="nav">
                        <li>
                            <a href="myProfile.jsp">
                                <span class="sidebar-mini">Mp</span>
                                <span class="sidebar-normal">My Profile</span>
                            </a>
                        </li>
                        <li>
                            <a href="#edit">
                                <span class="sidebar-mini">Ep</span>
                                <span class="sidebar-normal">Edit Profile</span>
                            </a>
                        </li>
                        <li>
                            <a href="#settings">
                                <span class="sidebar-mini">S</span>
                                <span class="sidebar-normal">Settings</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!--=====================================================-->
        <ul class="nav">
            <!--=====================================================-->
            <li>
                <a href="home.jsp">
                    <i class="ti-home"></i>
                    <p>Home</p>
                </a>
            </li>
            <!--=====================================================-->
            <li class="">
                <a data-toggle="collapse" href="#formsExamples">
                    <i class="fa fa-cog"></i>
                    <p>
                        Management User
                        <b class="caret"></b>
                    </p>
                </a>
                <div class="collapse" id="formsExamples">
                    <ul class="nav">
                        <li>
                            <a href="listAllUser.jsp">
                                <span class="sidebar-mini">U</span>
                                <span class="sidebar-normal">List All Users</span>
                            </a>
                        </li>
                        <li>
                            <a href="listSupervisor.jsp">
                                <span class="sidebar-mini">S</span>
                                <span class="sidebar-normal">List Supervisor</span>
                            </a>
                        </li>
                        <li class="">
                            <a href="listQuality.jsp">
                                <span class="sidebar-mini">Q</span>
                                <span class="sidebar-normal">List Quality</span>
                            </a>
                        </li>
                        <li>
                            <a href="listTeamLeader.jsp">
                                <span class="sidebar-mini">TL</span>
                                <span class="sidebar-normal">List TeamLeader</span>
                            </a>
                        </li>
                        <li>
                            <a href="listOperator.jsp">
                                <span class="sidebar-mini">O</span>
                                <span class="sidebar-normal">List Operator</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </li>
            <!--=====================================================-->
            <li>
                <a href="listTeam.jsp">
                    <i class="fa fa-group"></i>
                    <p>List Team</p>
                </a>
            </li>
            <!--=====================================================-->
            <li>
                <a href="listLine.jsp">
                    <i class="ti-line-double"></i>
                    <p>List Line</p>
                </a>
            </li>
            <!--=====================================================-->
            <li class="">
                <a data-toggle="collapse" href="#formsQrqc">
                    <i class="fa fa-cog"></i>
                    <p>
                        Qrqc
                        <b class="caret"></b>
                    </p>
                </a>
                <div class="collapse" id="formsQrqc">
                    <ul class="nav">
                      
                        
                        <li>
                            <a href="listQrqc.jsp">
                                <span class="sidebar-mini">LQ</span>
                                <span class="sidebar-normal">List Qrqc</span>
                            </a>
                        </li>


                    </ul>
                </div>
            </li>
            <!--=====================================================-->


        </ul>
    </div>
</div>