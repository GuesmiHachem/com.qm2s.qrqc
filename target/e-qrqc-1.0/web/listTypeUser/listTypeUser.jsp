<%-- 
    Document   : overview
    Created on : 16 juin 2018, 19:39:43
    Author     : Hachem
--%>

<%
User userPage=(User)session.getAttribute("user");
if(userPage!=null){
%>
<!doctype html>
<html lang="en">
    <head>
        <%@include file="../include/__langue.jsp" %>
        <%@include file="../include/__css.jsp" %>
    </head>

    <body>
        <div class="wrapper">
            <%@include file="../include/__sidebar.jsp" %>

            <div class="main-panel" >

                <%@include file="../include/__nav.jsp" %>

                <%@include file="../content/__listTypeUser.jsp" %>
                <%@include file="../include/__footer.jsp" %>
            </div>
        </div>
        <%@include file="../include/__param.jsp" %>
    </body>
    <%@include file="../include/__js.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {

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

            $().ready(function () {
                demo.initFormExtendedDatetimepickers();
            });

        });
    </script>

</html>


<%
}else{
response.sendRedirect(application.getContextPath());
}
%>


