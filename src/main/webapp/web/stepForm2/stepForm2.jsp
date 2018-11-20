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
        <link rel="stylesheet"  href="<%=application.getContextPath()%>/assets/css/demo.css">
    </head>
    <body>
        <%@include file="../content/__stepForm2.jsp" %>
        <%@include file="../include/__js.jsp" %>
        <script type="text/javascript" src="<%=application.getContextPath()%>/assets/js/demo.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                startTime();
                $('table.display').DataTable({
                    responsive: true,
                    select: false
                });

            });
        </script>
    </body>
</html>


