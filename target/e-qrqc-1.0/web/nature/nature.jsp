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
                <%@include file="../content/__nature.jsp" %>
                <%@include file="../include/__footer.jsp" %>
            </div>
        </div>
        <%@include file="../include/__param.jsp" %>
    </body>
    <%@include file="../include/__js.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {

          demo.initFormExtendedDatetimepickers();

        });
    </script>

</html>


<%
}else{
response.sendRedirect(application.getContextPath());
}
%>

