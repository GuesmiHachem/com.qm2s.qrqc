<%-- 
    Document   : __nav
    Created on : 16 juin 2018, 19:16:17
    Author     : Hachem
--%>

<nav class="navbar navbar-default">
    <div class="container-fluid">
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
        <div class="collapse navbar-collapse">
            <form class="navbar-form navbar-left navbar-search-form" role="search">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-search"></i></span>
                    <input type="text" value="" class="form-control" placeholder="Search...">
                </div>
            </form>


            <ul class="nav navbar-nav navbar-right">
                <li>
                <center>
                    <!--
                     <iframe src="https://www.zeitverschiebung.net/clock-widget-iframe-v2?language=en&size=small&timezone=Africa%2FTunis" width="100%" height="90" frameborder="0" seamless>

                     </iframe> 
                   
                    <iframe name="date du jour" id="date-du-jour" style="width:105px;height:75px;" src="https://www.mathieuweb.fr/calendrier/date-jour-noir2.html" scrolling="no" frameborder="0" allowtransparency="true"></iframe>
                    -->
                </center>
                </li>
                <li>
                    <a href="#stats" class="dropdown-toggle btn-magnify" data-toggle="dropdown">
                        <i class="ti-panel"></i>
                        <p>Stats</p>
                    </a>
                </li>
                <li class="dropdown">
                    <a href="#notifications" class="dropdown-toggle btn-rotate" data-toggle="dropdown">
                        <i class="ti-bell"></i>
                        <span class="notification">5</span>
                        <p class="hidden-md hidden-lg">
                            Notifications
                            <b class="caret"></b>
                        </p>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#not1">Notification 1</a></li>
                        <li><a href="#not2">Notification 2</a></li>
                        <li><a href="#not3">Notification 3</a></li>
                        <li><a href="#not4">Notification 4</a></li>
                        <li><a href="#another">Another notification</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#notifications" class="dropdown-toggle btn-rotate" data-toggle="dropdown">
                        <i class="ti-world"></i>
                        <p class="hidden-md hidden-lg">
                            Langue
                            <b class="caret"></b>
                        </p>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="javascript:window.location.reload()" onclick="changeLangue('en')">
                                <img width="30px" width="20px" src="<%=application.getContextPath()%>/assets/img/lang/en.png" alt=""/>
                                EN
                            </a>
                        </li>
                        <li >
                            <a href="javascript:window.location.reload()" onclick="changeLangue('fr')">
                                <img width="30px" width="20px" src="<%=application.getContextPath()%>/assets/img/lang/fr.png" alt=""/>
                                FR
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#settings" class="btn-rotate">
                        <i class="ti-settings"></i>
                        <p class="hidden-md hidden-lg">
                            Settings
                        </p>
                    </a>
                </li>
                <li>
                    <a href="<%=application.getContextPath()%>" class="btn-rotate">
                        <i class="ti-lock"></i>
                        <p class="hidden-md hidden-lg">
                            Logout
                        </p>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<script>
    
    function changeLangue(lang) {
        
        var xmlhttp = new XMLHttpRequest();
        
        xmlhttp.open("GET", "changeLangue.jsp?lang=" + lang, true);
        xmlhttp.send();
    }

</script>