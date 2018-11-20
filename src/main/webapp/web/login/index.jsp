<%-- 
    Document   : index
    Created on : 17 juin 2018, 15:07:19
    Author     : Hachem
--%>
<%@page import="entity.Level1"%>
<%@page import="entity.Hardware"%> 
<%@page import="service.ServiceLevel1"%>
<%@page import="domaine.Design"%>
<%@page import="entity.User"%>
<%
    //User user = (User) session.getAttribute("user");
    // if (user == null) {
%>
<!doctype html>
<html lang="en">
    <head>
        <%@include file="../../web/include/__css.jsp" %>
    </head>

    <body class="w3-dark-gray w3-text-black" >

        <div class="container">
            <div class="row  align-items-center">
                <div class="col-md-8 offset-md-2">
                    <br><br><br>
                    <div id="contenu">
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../../web/include/__js.jsp" %>

        <script>

            $(document).ready(function () {
                showIndex();
                //addHardwareInSession();
                // redirectHome();
                //document.execCommand('Stop');
                //window.stop();
                //addHardwareInSession();
                //setTimeout(function(){document.execCommand('Start'); },4000);


            });
        </script>


        <script>

            /*    function removeHardware()
             {
             localStorage.removeItem("ligne");
             localStorage.removeItem("nameH");
             window.location.href = "<%=application.getContextPath()%>";
             }
             */
            function getIdHardware()
            {
                return localStorage.getItem("IdHardware");
            }

            /*  function isHardwareExist()
             {
             if (localStorage.getItem("IdHardware") == null) {
             return false;
             } else {
             return true;
             }
             }
             */
           
            function showIndex() {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("contenu").innerHTML =
                                this.responseText;
                        
                        addHardwareInSession();
                    }
                };
                xmlhttp.open("GET", "<%=application.getContextPath()%>/web/login/_index.jsp?idHardware=" + getIdHardware(), true);
                xmlhttp.send();
            }

            function addHardware() {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        localStorage.setItem("IdHardware", this.responseText);
                        showIndex();
                    }
                };
                var idLigne = document.f_index2.idLigne.value;
                var name = document.f_index2.name.value;
                xmlhttp.open("GET", "<%=application.getContextPath()%>/AddHardware?idLigne=" + idLigne + "&name=" + name, true);
                xmlhttp.send();
            }

            function addHardwareInSession() {

                var xmlhttp = new XMLHttpRequest();
                xmlhttp.open("GET", "<%=application.getContextPath()%>/AddHardwareInSession?idHardware=" + getIdHardware(), true);
                xmlhttp.send();

            }

        </script>
    </body>
</html>

<script>
    //console.log("bonjour");
</script>