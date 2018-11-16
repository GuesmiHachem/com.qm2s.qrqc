<%-- 
    Document   : overview
    Created on : 16 juin 2018, 19:39:43
    Author     : Hachem
--%>

<!doctype html>
<html lang="en">
    <head>
        <%@include file="../include/__langue.jsp" %>
        <%@include file="../include/__css.jsp" %>

        <style>
            /* ============================================================= */
            body {
                margin: 0;
                font-family: Arial, Helvetica, sans-serif;
            }

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

            .topnav a:hover {
                background-color: #ddd;
                color: black;
            }

            .active {
                background-color: #4CAF50;
                color: white;
            }

            .topnav .icon {
                display: none;
            }

            @media screen and (max-width: 600px) {
                .topnav a:not(:first-child) {display: none;}
                .topnav a.icon {
                    float: right;
                    display: block;
                }
            }

            @media screen and (max-width: 600px) {
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
            }
            /* ============================================================= */
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
            /* ============================================================= */

        </style>
    </head>

    <body>

        <div class="topnav w3-round w3-margin" id="myTopnav">
            <a href="#home" class="w3-pink w3-medium ">
                <i class="fa fa-home w3-large w3-text-light-gray "></i>
                Home
            </a>
            <a href="#contact" class="w3-pink1 w3-medium" >Contact</a>
            <a href="#about" class="w3-pink1 w3-medium">About</a>
            <a href="#about" class="w3-pink1 w3-medium">About</a>                       
            <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                <i class="fa fa-bars"></i>
            </a>
        </div>
        <div class="w3-container">
            <div class="w3-row">
                <div class="w3-col l2 " ><br></div>
                <div class="w3-col l8 " >
                    <br>
                    <%@include file="../content/__sadmin.jsp" %>
                </div>
                <div class="w3-col l2 " ><br></div>

            </div>
        </div>
    </body>
    <%@include file="../include/__js.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {
            demo.initOverviewDashboard();
            demo.initCirclePercentage();

            $('#datatables1').DataTable({
                "pagingType": "full_numbers",
                "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
                responsive: true,
                language: {
                    search: "_INPUT_",
                    searchPlaceholder: "Search records",
                },
            });

            $('#datatables2').DataTable({
                "pagingType": "full_numbers",
                "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
                responsive: true,

                language: {
                    search: "_INPUT_",
                    searchPlaceholder: "Search records",
                },
            });

            $('#datatables3').DataTable({
                "pagingType": "full_numbers",
                "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
                responsive: true,

                language: {
                    search: "_INPUT_",
                    searchPlaceholder: "Search records",
                },
            });

            $().ready(function () {
                demo.initFormExtendedDatetimepickers();
            });

            $('.menu.item').tab();

        });

        function myFunction() {
            var x = document.getElementById("myTopnav");
            if (x.className === "topnav") {
                x.className += " responsive";
            } else {
                x.className = "topnav";
            }
        }
    </script>

</html>
