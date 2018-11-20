<%-- 
    Document   : demo
    Created on : 2 août 2018, 11:15:39
    Author     : Hachem
--%>


<%@page import="service.ServiceTypeUser"%>
<%@page import="service.ServiceUser"%>
<%@page import="entity.User"%>
<%@page import="java.util.List"%>
<%
    String idTypeUser = request.getParameter("idTypeUser");
    entity.TypeUser typeUser=ServiceTypeUser.find(Integer.parseInt(idTypeUser));
%>

<div class="form-group">
    <select style="border-radius: 5px;" name="idUser" class="selectpickers w3-input w3-border w3-border-grey w3-round " title="" data-size="7"  required>
        <% List<User> listUser = typeUser.getUserList();
            for (User user : listUser) {
                String value = user.getFirstName() + " " + user.getName();
        %>
        <option class="" draggable value="<%=user.getId()%>"><%=value%></option>    
        <%}%>
    </select>
</div>