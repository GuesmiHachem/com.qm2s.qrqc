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

                <%@include file="../content/__S1P3Form.jsp" %>
                <%@include file="../include/__footer.jsp" %>
            </div>
        </div>
        <%@include file="../include/__param.jsp" %>
    </body>
    <%@include file="../include/__js.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {

            $('#datatables').DataTable({
                "pagingType": "full_numbers",
                "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
                responsive: true,
                language: {
                    search: "_INPUT_",
                    searchPlaceholder: "Search records",
                },
            });


            var table = $('#datatables').DataTable();
            // Edit record
            table.on('click', '.edit', function () {
                $tr = $(this).closest('tr');

                var data = table.row($tr).data();
                alert('You press on Row: ' + data[0] + ' ' + data[1] + ' ' + data[2] + '\'s row.');
            });

            // Delete a record
            table.on('click', '.remove', function (e) {
                $tr = $(this).closest('tr');
                table.row($tr).remove().draw();
                e.preventDefault();
            });

            //Like record
            table.on('click', '.like', function () {
                alert('You clicked on Like button');
            });
            
             demo.initFormExtendedDatetimepickers();

        });
    </script>

</html>

<%
}else{
response.sendRedirect(application.getContextPath());
}
%>
