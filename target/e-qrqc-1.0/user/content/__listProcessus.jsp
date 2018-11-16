<%@page import="domaine.Design"%>
<%@page import="entity.*"%>
<%@page import="service.*"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ResourceBundle"%>


<% try {%>


<%
    String idNature = request.getParameter("idNature");
    String nameProcessus = request.getParameter("nameProcessus");
    String idProcessus = request.getParameter("idProcessus");
    String addProcessus = request.getParameter("addProcessus");
    String deleteProcessus = request.getParameter("deleteProcessus");
    String idUser = request.getParameter("idUser");
    //--------------------------------------------------------

    //--------------------------------------------------------
    if (addProcessus != null) {
        Nature nat = ServiceNature.find(Integer.parseInt(idNature));
        User user = ServiceUser.find(Integer.parseInt(idUser));

        Processus proc = new Processus();
        proc.setName(nameProcessus);
        proc.setIdNature(nat);
        proc.setIdUser(user);

        ServiceProcessus.create(proc);
    }

    //--------------------------------------------------------
    if (deleteProcessus != null) {
        ServiceProcessus.destroy(Integer.parseInt(idProcessus));
    }
    //--------------------------------------------------------

%>



<div class="content " >
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <!-- card  -->   
                <div class="card w3-white w3-border-grey w3-border">
                    <div class="card-content ">
                        <!--================================================-->
                        <div class="row ">
                            <div class="col-lg-12 ">

                                <!--====================================================================-->
                                <div class="<%=Design.containerTitle%>">
                                    <div class="col-xs-5">
                                        <h3 class="<%=Design.textNormal%>">Liste des processus</h3>
                                    </div>
                                    <div class="w3-right">
                                        <button data-toggle="modal" data-target="#addProcessus" style="border-radius: 5px;margin:3px;" name="addProcessus" type="button" class="<%=Design.btn%> w3-hover-white ti-plus"> 
                                        </button>
                                    </div>
                                    <div class=" w3-right">
                                        <form action="<%=application.getContextPath()%>/ListProcessus" method="post">
                                            <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                        return true;
                                                    } else {
                                                        return false;
                                                    }" style="border-radius: 5px;margin:3px;" name="destroyAll" type="submit" class="<%=Design.btn%> w3-hover-white ti-trash"> 
                                            </button>
                                        </form>
                                    </div>

                                </div>
                                <div class="<%=Design.container%>">
                                    <br>
                                    <div class="<%=Design.cadreTable%>">
                                        <table class="<%=Design.table%> " cellspacing="0" width="100%" style="width:100%">
                                            <thead>
                                                <tr class="w3-light-gray w3-text-dark-gray">
                                                    <th>ID</th>
                                                    <th>Nom</th>
                                                    <th>Nature</th>
                                                    <th>Responsable</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% List<Processus> listProcessus = ServiceProcessus.findAll(); %>
                                                <% for (Processus processus : listProcessus) {%>
                                                <% Nature nature = processus.getIdNature();%>
                                                <% User user = processus.getIdUser();%>
                                                <tr class="w3-hover-light-gray">
                                                    <td><%=processus.getId()%></td>
                                                    <td><%=processus.getName()%></td>
                                                    <%if (nature != null) {%>
                                                    <td>
                                                        <a href="Nature?id=<%=nature.getId()%>"><%=nature.getName()%></a></td>
                                                        <%} else {%>
                                                    <td>

                                                    </td>
                                                    <%}%>

                                                    <%if (user != null) {%>
                                                    <td>
                                                        <a href="User?id=<%=user.getId()%>"><%=user.getFirstName() + " " + user.getName()%></a></td>
                                                        <%} else {%>
                                                    <td>

                                                    </td>
                                                    <%}%>


                                                    <td>
                                                        <form class="form-horizontal " action="<%=application.getContextPath()%>/ListProcessus" method="post">
                                                            <input hidden style="margin:3px;" name="idProcessus" type="text" class="w3-hide" placeholder="" value="<%=processus.getId()%>">
                                                            <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                                        return true;
                                                                    } else {
                                                                        return false;
                                                                    }" name="deleteProcessus" type="submit" class="<%=Design.btn%> w3-hover-pink ti-minus"> 
                                                            </button>
                                                            <a href="Processus?id=<%=processus.getId()%>" class="<%=Design.btn%> w3-hover-light-green ti-eye"> 
                                                            </a>
                                                        </form>
                                                    </td>
                                                </tr>
                                                <% }
                                                %>
                                            </tbody>
                                        </table>                                        
                                    </div>
                                    <br>
                                </div>

                            </div>
                        </div>


                    </div>
                </div>
                <!-- fin card  -->               
            </div>
        </div>
    </div> 
</div> 


<%} catch (Exception ex) {
        // response.sendRedirect("level.jsp");
    }%>


<!--####################################################################
    #                                                                  #
    #                     Ajouter un processus                         #
    ####################################################################-->

<div class="modal fade" id="addProcessus" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog  modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body bg-white">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br><br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">Ajouter un processus</h3>    
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form  name="f1" action="<%=application.getContextPath()%>/ListProcessus" method="post" >

                        <div class="card-content">
                            <div class="form-group ">
                                <p class="<%=Design.textNormal%>">Nom </p>    
                                <input class="<%=Design.inputText%>" name="nameProcessus" type="text" required="true" >
                            </div>
                            <div class="form-group">
                                <p class="<%=Design.textNormal%>">Nature</p>    
                                <select style="border-radius: 5px;" id="idNature" name="idNature" class="selectpickers w3-input w3-border w3-border-grey w3-round" title="" data-size="7"   onchange="listUser1()" required>
                                    <% List<Nature> listNature = ServiceNature.findAll();
                                        for (Nature nature : listNature) {
                                            String value = nature.getName();
                                    %>
                                    <option class="" value="<%=nature.getId()%>"><%=value%></option>   
                                    <%}%>
                                </select>
                            </div>
                            <div class="form-group">
                                <p class="<%=Design.textNormal%>">Type d'utilisateur</p>    
                                <select style="border-radius: 5px;" id="idTypeUser" name="idTypeUser" class="selectpickers w3-input w3-border w3-border-grey w3-round" title="" data-size="7"   onchange="listUser()" required>
                                    <% List<TypeUser> listTypeUser = ServiceTypeUser.findAll();
                                        for (TypeUser typeUser : listTypeUser) {
                                            String value = typeUser.getName();
                                    %>
                                    <option class="" draggable value="<%=typeUser.getId()%>"><%=value%></option>   
                                    <%}%>
                                </select>
                            </div>
                            <p class="<%=Design.textNormal%>">Utilisateur</p>    
                            <div id="listUser"></div>    
                        </div>
                        <button name="addProcessus" type="submit" class="<%=Design.btn%>">Ajouter</button>
                        <button  type="reset" class="<%=Design.btn%>">Annuler</button>

                    </form>
                    <br>
                </div>

            </div> 
        </div>
    </div>
</div> 
<script>
    function listUser() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("listUser").innerHTML =
                        this.responseText;
            }
        };
        var idTypeUser = document.getElementById("idTypeUser");
        var idTypeUser = idTypeUser.options[idTypeUser.selectedIndex].value;
        xhttp.open("GET", "<%=application.getContextPath()%>/user/ajax/listUser.jsp?idTypeUser=" + idTypeUser, true);
        xhttp.send();
    }
</script>


