
<%@page import="domaine.Design"%>
<%@page import="entity.User"%>
<%@page import="entity.Nature"%>
<%@page import="entity.Processus"%>
<%@page import="service.*"%>

<%@page import="java.util.List"%>

<%
    Processus processus = (Processus) request.getAttribute("processus");
%>


<% try {%>

<div class="content w3-light-gray">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">

                <div class="card w3-white w3-border-grey w3-border">
                    <div class="card-content">

                        <div class="<%=Design.containerTitle%>">
                            <div class="col-xs-5">
                                <h3 class="<%=Design.textNormal%>">Modifier processus</h3>
                            </div>
                            <div class="w3-right">
                                <button  onclick="document.location.href = 'ListProcessus'" style="border-radius: 5px;margin:3px;"  type="button" class="<%=Design.btn%> ti-view-list"> 
                                </button>
                            </div>

                        </div>
                        <div class="<%=Design.container%>">
                            <br>
                            <form  name="f1" action="" method="post" >

                                <div class="card-content">
                                    <div class="form-group">
                                        <h5 class="">
                                            Nom de processus
                                        </h5>
                                        <input class="w3-input w3-border w3-border-grey w3-round " name="nameProcessus" type="text" required="true" value="<%=processus.getName()%>">
                                    </div>
                                    <div class="form-group">
                                        <h5 class="">
                                            Nature
                                        </h5>
                                        <select style="border-radius: 5px;" id="idNature" name="idNature" class="selectpickers w3-input w3-border w3-border-grey w3-round" title="" data-size="7"   onchange="loadDoc()" required>
                                            <% List<Nature> listNature = ServiceNature.findAll();
                                                for (Nature nature : listNature) {
                                                    String value = nature.getName();
                                                    if (processus.getIdNature().getId() == nature.getId()) {
                                            %>
                                            <option class="" selected value="<%=nature.getId()%>"><%=value%></option>   
                                            <%} else {%>
                                            <option class=""  value="<%=nature.getId()%>"><%=value%></option>   
                                            <%}
                                                }%>

                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <h5 class="">
                                            Responsable
                                        </h5>
                                        <%
                                            if (processus.getIdUser() == null) {
                                        %>
                                        <select style="border-radius: 5px;" id="idUser" name="idUser" class="selectpickers w3-input w3-border w3-border-grey w3-round" title="" data-size="7"   onchange="loadDoc()" required>
                                            <option class="" ></option>   
                                            <% List<User> listUser = ServiceUser.findAll();
                                                for (User u : listUser) {
                                                    String value = u.getName() + " " + u.getFirstName();
                                            %>
                                            <option class=""  value="<%=u.getId()%>"><%=value%></option>   
                                            <%}%>

                                        </select>
                                        <%
                                        } else {
                                        %>
                                        <select style="border-radius: 5px;" id="idUser" name="idUser" class="selectpickers w3-input w3-border w3-border-grey w3-round" title="" data-size="7"   onchange="loadDoc()" required>
                                            <% List<User> listUser = ServiceUser.findAll();
                                                for (User u : listUser) {
                                                    String value = u.getName() + " " + u.getFirstName();
                                                    if (processus.getIdUser().getId() == u.getId()) {
                                            %>
                                            <option class="" selected value="<%=u.getId()%>"><%=value%></option>   
                                            <%} else {%>
                                            <option class=""  value="<%=u.getId()%>"><%=value%></option>   
                                            <%}
                                                }%>

                                        </select>
                                        <%
                                            }
                                        %>
                                    </div>            
                                </div>

                                <button style="border-radius: 5px;" name="updateProcessus" type="submit" class="<%=Design.btn%>">Modifier</button>
                                <button style="border-radius: 5px;" type="reset" class="<%=Design.btn%>">Annuler</button>


                            </form>
                            <br>
                        </div>       

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%} catch (Exception ex) {
        response.sendRedirect("listUser.jsp");
    }%>
