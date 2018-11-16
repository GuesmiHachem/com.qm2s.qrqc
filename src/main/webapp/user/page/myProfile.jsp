<%-- 
    Document   : overview
    Created on : 16 juin 2018, 19:39:43
    Author     : Hachem
--%>
<%
    User userPage = (User) session.getAttribute("user");
    if (userPage != null) {
%>
<!doctype html>
<html lang="en">
    <head>
        <%@include file="../include/__langue.jsp" %>
        <%@include file="../include/__css.jsp" %>
    </head>

    <body >
        <%@include file="../include/top.jsp" %>
        <%@include file="../include/header.jsp" %>
        <div class="container-fluid">
            <div class="row mb-3"></div>
            <div class="row">
                <div class="col-lg-12">
                    <%@include file="../content/__myProfile.jsp" %>
                    <button onclick="ff()">ddd</button>
                </div>
            </div>
        </div>
    </body>
    <%@include file="../include/__js.jsp" %>
    <script type="text/javascript" src="<%=application.getContextPath()%>/assets/js/demo.js"></script>
    <script type="text/javascript">
                        $(document).ready(function () {
                            startTime();
          ff(); ff(); ff(); 
                         
       
                            $('table.display').DataTable({
                                responsive: true,
                                select: false
                            });

                            $("#input-id").fileinput();

// with plugin options
                            $("#input-id").fileinput({'showUpload': false, 'previewFileType': 'any'});
                           


                        });

                        function ff() {


                            var options = {
                                body: 'probleme de qualité creer par hachem',
                                icon: '<%=application.getContextPath()%>/img/profile/<%=user.getPicture()%>'
                                        }

                                        var n = new Notification('QRQC 20182523_03', options);
                                        n.onclick = function (event) {
                                            event.preventDefault(); // empêche le navigateur de donner le focus à l'onglet relatif à la notification
                                            window.open('http://localhost:8080/eq/Problem?id=1', '_blank');
                                            n.close();
                                        }

                                    }


    </script>

</html>


<%    } else {
        response.sendRedirect(application.getContextPath());
    }
%>
