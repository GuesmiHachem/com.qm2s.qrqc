


<!doctype html>
<html lang="en">
    <head>


        <!-- Mirrored from demos.creative-tim.com/paper-dashboard-pro/examples/calendar.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 15 Jun 2018 08:04:19 GMT -->
        <!-- Added by HTTrack -->
        <meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="/str_1/assets/img/x.png">
        <link rel="icon" type="image/png" sizes="96x96" href="/str_1/assets/img/x.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>E-QRQC</title>

        <!-- Canonical SEO -->
        <link rel="canonical" href="https://www.creative-tim.com/product/paper-dashboard-pro"/>

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />


        <!-- Bootstrap core CSS     -->
        <link href="/str_1/assets/css/bootstrap.min.css" rel="stylesheet" />

        <!--  Paper Dashboard core CSS    -->
        <link href="/str_1/assets/css/paper-dashboard23cd.css?v=2.0.1" rel="stylesheet"/>


        <!--  CSS for Demo Purpose, don't include it in your project     -->
        <link href="/str_1/assets/css/demo.css" rel="stylesheet" />


        <!--  Fonts and icons     -->
        <link href="/str_1/assets/css/font-awesome.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
        <link href="/str_1/assets/css/themify-icons.css" rel="stylesheet">
        <link href="/str_1/assets/css/w3.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>

    <body>
        <div class="wrapper">




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
                            <em class="w3-text-blue">e</em>-QRQC
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

                            <img src="/str_1/img/profile/474615131.jpg" alt="...">

                        </div>
                        <div class="info">
                            <a data-toggle="collapse" href="#collapseExample" class="collapsed">
                                <span class="w3-text-black">
                                    Asma
                                    Asma
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
                            <a  href="/str_1/Home" class="btn-rotate">

                                <i class="w3-text-dark-gray ti-home"></i>
                                <p class="w3-text-dark-gray w3-medium ">
                                    Home
                                </p>
                            </a>
                        </li><!--=====================================================-->

                        <li class="">
                            <a href="/str_1/Problems" class="btn-rotate">
                                <i class="w3-text-dark-gray ti-alert"></i>
                                <p class="w3-text-dark-gray w3-medium ">
                                    Qrqc
                                </p>
                            </a>
                        </li>
                        <!--=====================================================-->
                        <li class="">
                            <a href="/str_1/PlanAction" class="btn-rotate">
                                <i class="w3-text-dark-gray ti-view-list"></i>
                                <p class="w3-text-dark-gray w3-medium ">
                                    Plan d'Action
                                </p>
                            </a>
                        </li>

                    </ul>
                </div>
            </div>
            <div class="main-panel" >














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



                <nav class="navbar navbar-default ">
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
                                <center>
                                    <!--
                                     <iframe src="https://www.zeitverschiebung.net/clock-widget-iframe-v2?language=en&size=small&timezone=Africa%2FTunis" width="100%" height="90" frameborder="0" seamless>
                
                                     </iframe> 
                                   
                                    <iframe name="date du jour" id="date-du-jour" style="width:105px;height:75px;" src="https://www.mathieuweb.fr/calendrier/date-jour-noir2.html" scrolling="no" frameborder="0" allowtransparency="true"></iframe>
                                    
                                     <iframe name="date du jour" id="date-du-jour" style="width:105px;height:75px;" src="https://www.mathieuweb.fr/calendrier/date-jour-noir2.html" scrolling="no" frameborder="0" allowtransparency="true"></iframe>
                
                                    -->

                                </center>
                                </li>
                                <li>
                                    <a href="#stats" class="dropdown-toggle btn-magnify" data-toggle="dropdown">
                                        <i class="w3-text-dark-gray ti-panel"></i>
                                        <p class="w3-text-dark-gray"></p>
                                    </a>
                                </li>

                                <li class="dropdown">



                                    <a href="#notifications" class="dropdown-toggle btn-rotate" data-toggle="dropdown">

                                        <i class="w3-text-red fa fa-bell"></i>
                                        <span class="notification w3-text-dark-gray">13</span>

                                        <p class="w3-text-dark-gray w3-medium  hidden-md hidden-lg ">
                                            Notifications
                                            <b class="w3-text-dark-gray caret "></b>
                                        </p>
                                    </a>
                                    <ul class="dropdown-menu" style="height: 490px; overflow: auto; width: 600px;   
                                        overflow: auto;    
                                        scrollbar-base-color:#ffeaff">




                                        <script>

                                            function changeLangue(lang) {

                                                var xmlhttp = new XMLHttpRequest();
                                                //beep();
                                                xmlhttp.open("GET", "changeLangue.jsp?lang=" + lang, true);
                                                xmlhttp.send();
                                            }
                                            /*
                                             function loadNotification() {
                                             var xhttp = new XMLHttpRequest();
                                             xhttp.onreadystatechange = function () {
                                             if (this.readyState == 4 && this.status == 200) {
                                             document.getElementById("demo").innerHTML =
                                             this.responseText;
                                             }
                                             };
                                             
                                             xhttp.open("GET", "/user/ajax/navNotification.jsp?idTypeUser=" + 3, true);
                                             xhttp.send();
                                             }
                                             
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















                                        <div class="content " >
                                            <div class="container-fluid">
                                                <div class="row">
                                                    <div class="col-lg-12">

                                                        <div class="card w3-white w3-border-grey w3-border">
                                                            <div class="card-content">


                                                                <div class="row">
                                                                    <div class="col-lg-3 col-sm-6">
                                                                        <div class="card w3-light-blue ">
                                                                            <div class="card-content">
                                                                                <div class="row ">
                                                                                    <div class="col-xs-5">
                                                                                        <div class="icon-big text-center">
                                                                                            <i class="fa fa-user w3-text-white"></i>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="col-xs-7">
                                                                                        <div class="numbers">
                                                                                            <p>Utilisateur</p>
                                                                                            13
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-lg-3 col-sm-6">
                                                                        <div class="card w3-pink">
                                                                            <div class="card-content">
                                                                                <div class="row">
                                                                                    <div class="col-xs-5">
                                                                                        <div class="icon-big text-center">
                                                                                            <i class="w3-text-white w3-xxlarge ti-alert"></i>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="col-xs-7">
                                                                                        <div class="numbers">
                                                                                            <p>Probléme</p>
                                                                                            80
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <div class="row">
                                                                    <!--====================================================================-->

                                                                    <!--====================================================================-->
                                                                    <div class="col-lg-3 col-sm-6">
                                                                        <div class="card w3-light-gray">
                                                                            <div class="card-content">
                                                                                <div class="row">
                                                                                    <div class="col-xs-5">
                                                                                        <div class=" text-center">
                                                                                            <i class="fa fa-star w3-text-orange"></i>
                                                                                            <i class="fa fa-star w3-text-orange"></i>
                                                                                            <i class="fa fa-star w3-text-orange"></i>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="col-xs-7">
                                                                                        <div class="numbers">
                                                                                            <p>Niveau 3</p>
                                                                                            0
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <!--====================================================================-->
                                                                    <div class="col-lg-3 col-sm-6">
                                                                        <div class="card w3-light-gray">
                                                                            <div class="card-content">
                                                                                <div class="row">
                                                                                    <div class="col-xs-5">
                                                                                        <div class=" icon-danger text-center">
                                                                                            <i class="fa fa-star w3-text-orange"></i>
                                                                                            <i class="fa fa-star w3-text-orange"></i>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="col-xs-7">
                                                                                        <div class="numbers">
                                                                                            <p>Niveau 2</p>
                                                                                            0
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <!--====================================================================-->
                                                                    <div class="col-lg-3 col-sm-6">
                                                                        <div class="card w3-light-gray">
                                                                            <div class="card-content">
                                                                                <div class="row">
                                                                                    <div class="col-xs-5">
                                                                                        <div class="icon-info text-center">
                                                                                            <i class="fa fa-star w3-text-orange"></i>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="col-xs-7">
                                                                                        <div class="numbers">
                                                                                            <p>Niveau 1</p>
                                                                                            0
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-lg-3 col-sm-6">
                                                                        <div class="card w3-light-gray">
                                                                            <div class="card-content">
                                                                                <div class="row">
                                                                                    <div class="col-xs-5">
                                                                                        <div class="icon-primary text-center">
                                                                                            <i class="fa fa-star w3-text-black"></i>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="col-xs-7">
                                                                                        <div class="numbers">
                                                                                            <p>Niveau E</p>
                                                                                            0
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <!--====================================================================-->

                                                                </div>


                                                            </div>
                                                        </div>


                                                        <div class="card w3-white w3-border-grey w3-border">
                                                            <div class="card-content">
                                                                <div class="row">



                                                                </div>
                                                            </div>
                                                        </div>




                                                    </div>
                                                </div>
                                            </div>
                                        </div>


                                        <footer class="footer w3-light-gray w3-border-grey">
                                            <div class="container-fluid">
                                                <div class="copyright pull-right w3-text-dark-gray">
                                                    &copy; <script>document.write(new Date().getFullYear())</script>, made by <a href="http://qm-2s.com/">QM2S</a>
                                                </div>
                                            </div>
                                        </footer>
                                        <!--
                                        <div class="w3-container   w3-dark-gray w3-right-align">
                                             &copy; <script>document.write(new Date().getFullYear())</script>, made by <a href="http://qm-2s.com/">QM2S</a>
                                                
                                        </div>
                                        -->

                                        </div>
                                        </div>


                                        <div class="fixed-plugin">
                                            <div class="dropdown ">
                                                <a href="#" data-toggle="dropdown">
                                                    <i class="fa fa-cog fa-2x"> </i>
                                                </a>
                                                <ul class="dropdown-menu ">
                                                    <li class="header-title">Sidebar Background</li>
                                                    <li class="adjustments-line text-center">
                                                        <a href="javascript:void(0)" class="switch-trigger background-color">
                                                            <span class="badge filter badge-brown active" data-color="brown"></span>
                                                            <span class="badge filter badge-white" data-color="white"></span>
                                                        </a>
                                                    </li>

                                                    <li class="header-title">Sidebar Active Color</li>
                                                    <li class="adjustments-line text-center">
                                                        <a href="javascript:void(0)" class="switch-trigger active-color">
                                                            <span class="badge filter badge-primary" data-color="primary"></span>
                                                            <span class="badge filter badge-info" data-color="info"></span>
                                                            <span class="badge filter badge-success" data-color="success"></span>
                                                            <span class="badge filter badge-warning" data-color="warning"></span>
                                                            <span class="badge filter badge-danger active" data-color="danger"></span>
                                                        </a>
                                                    </li>
                                                    <!--
                                                                <li class="button-container">
                                                                    <div class="">
                                                                        <a href="https://www.creative-tim.com/product/paper-dashboard?ref=pdp-free-demo" target="_blank" class="btn btn-info btn-block">Get Free Demo</a>
                                                                        <a href="https://www.creative-tim.com/product/paper-dashboard-pro" target="_blank" class="btn btn-danger btn-block btn-fill">Buy for $39</a>
                                                                    </div>
                                                                </li>
                                                    
                                                                <li class="header-title">Thank you for sharing!</li>
                                                    
                                                                <li class="button-container">
                                                                    <button id="twitter" class="btn btn-social btn-twitter btn-round"><i class="fa fa-twitter"></i> </button>
                                                                    <button id="facebook" class="btn btn-social btn-facebook btn-round"><i class="fa fa-facebook-square"></i></button>
                                                                </li>
                                                    -->
                                                </ul>
                                            </div>
                                        </div>

                                        </body>



                                        <!--   Core JS Files. Extra: TouchPunch for touch library inside jquery-ui.min.js   -->
                                        <script src="/str_1/assets/js/jquery-3.1.1.min.js" type="text/javascript"></script>
                                        <script src="/str_1/assets/js/jquery-ui.min.js" type="text/javascript"></script>
                                        <script src="/str_1/assets/js/perfect-scrollbar.min.js" type="text/javascript"></script>
                                        <script src="/str_1/assets/js/bootstrap.min.js" type="text/javascript"></script>

                                        <!--  Forms Validations Plugin -->
                                        <script src="/str_1/assets/js/jquery.validate.min.js"></script>

                                        <!-- Promise Library for SweetAlert2 working on IE -->
                                        <script src="/str_1/assets/js/es6-promise-auto.min.js"></script>

                                        <!--  Plugin for Date Time Picker and Full Calendar Plugin-->
                                        <script src="/str_1/assets/js/moment.min.js"></script>

                                        <!--  Date Time Picker Plugin is included in this js file -->
                                        <script src="/str_1/assets/js/bootstrap-datetimepicker.js"></script>

                                        <!--  Select Picker Plugin -->
                                        <script src="/str_1/assets/js/bootstrap-selectpicker.js"></script>

                                        <!--  Switch and Tags Input Plugins -->
                                        <script src="/str_1/assets/js/bootstrap-switch-tags.js"></script>

                                        <!-- Circle Percentage-chart -->
                                        <script src="/str_1/assets/js/jquery.easypiechart.min.js"></script>

                                        <!--  Charts Plugin -->
                                        <script src="/str_1/assets/js/chartist.min.js"></script>

                                        <!--  Notifications Plugin    -->
                                        <script src="/str_1/assets/js/bootstrap-notify.js"></script>

                                        <!-- Sweet Alert 2 plugin -->
                                        <script src="/str_1/assets/js/sweetalert2.js"></script>

                                        <!-- Vector Map plugin -->
                                        <script src="/str_1/assets/js/jquery-jvectormap.js"></script>

                                        <!--  Google Maps Plugin    -->
                                        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAFPQibxeDaLIUHsC6_KqDdFaUdhrbhZ3M"></script>

                                        <!-- Wizard Plugin    -->
                                        <script src="/str_1/assets/js/jquery.bootstrap.wizard.min.js"></script>

                                        <!--  Bootstrap Table Plugin    -->
                                        <script src="/str_1/assets/js/bootstrap-table.js"></script>

                                        <!--  Plugin for DataTables.net  -->
                                        <script src="/str_1/assets/js/jquery.datatables.js"></script>

                                        <!--  Full Calendar Plugin    -->
                                        <script src="/str_1/assets/js/fullcalendar.min.js"></script>

                                        <!-- Paper Dashboard PRO Core javascript and methods for Demo purpose -->
                                        <script src="/str_1/assets/js/paper-dashboard23cd.js?v=1.2.1"></script>

                                        <!--   Sharrre Library    -->
                                        <script src="/str_1/assets/js/jquery.sharrre.js"></script>

                                        <!-- Paper Dashboard PRO DEMO methods, don't include it in your project! -->
                                        <script src="/str_1/assets/js/demo.js"></script>


                                        <script src="/str_1/assets/js/jasny-bootstrap.min.js"></script>
                                        <script src="/str_1/assets/js/nouislider.min.js"></script>
                                        <script src="/str_1/assets/js/html2canvas.min.js"></script>



                                        <script type="text/javascript">
                                                        $(document).ready(function () {
                                                            demo.initOverviewDashboard();
                                                            demo.initCirclePercentage();

                                                        });
                                        </script>

                                        
                </html>



