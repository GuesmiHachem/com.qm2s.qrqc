<%@page import="entity.*"%>
<%@page import="service.*"%>
<%@page import="domaine.Design"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ResourceBundle"%>



<%
    Level3 level3 = (Level3) request.getAttribute("level3");
    Level3 level3Next = (Level3) request.getAttribute("level3Next");
    Level3 level3Prev = (Level3) request.getAttribute("level3Prev");
%>


<% try {%>

<div class="content " >
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <!-- card  -->   
                <div class="<%=Design.card%>">
                    <div class="card-content ">
                        <!--================================================-->
                        <div class="row ">
                            <div class="col-lg-12 ">
                                <nav aria-label="breadcrumb" >
                                    <ol class="breadcrumb w3-green w3-text-white">
                                        <li class="breadcrumb-item"><a class="w3-text-white" href="<%=application.getContextPath()%>/Level">List des activités</a></li>
                                        <li class="breadcrumb-item"><a class="w3-text-white" href="<%=application.getContextPath()%>/L3?id=<%=level3.getId()%>"><%=level3.getName()%></a></li>
                                    </ol>

                                    <form action="<%=application.getContextPath()%>/L3?id=<%=level3.getId()%>" method="post">
                                        <a style="margin:3px;" href="<%=application.getContextPath()%>/L3?id=<%=level3Prev.getId()%>"><i  class="<%=Design.btn%> fa fa-chevron-circle-left"></i></a>
                                        <a style="margin:3px;" href="<%=application.getContextPath()%>/L3?id=<%=level3Next.getId()%>"><i  class="<%=Design.btn%> fa fa-chevron-circle-right"></i></a>

                                        <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                    return true;
                                                } else {
                                                    return false;
                                                }" style="border-radius: 5px;margin:3px;" name="deleteAll" type="submit" class="<%=Design.btn%> fa fa-trash"> 
                                        </button>
                                        <button  data-toggle="modal" data-target="#renameLevel" style="border-radius: 5px;margin:3px;" name="renameLevel" type="button" class="<%=Design.btn%> fa fa-edit"> 
                                        </button>
                                        <button data-toggle="modal" data-target="#addLevel" style="border-radius: 5px;margin:3px;" name="addLevel" type="button" class="<%=Design.btn%> fa fa-plus"> 
                                        </button>
                                        <button data-toggle="modal" data-target="#addUser" style="border-radius: 5px;margin:3px;" name="addUser" type="button" class="<%=Design.btn%> fa fa-user-plus"> 
                                        </button>
                                        <button data-toggle="modal" data-target="#addNature" style="border-radius: 5px;margin:3px;" name="addNature" type="button" class="<%=Design.btn%> fa fa-plus"> 
                                            Nature
                                        </button>
                                        <button data-toggle="modal" data-target="#addProcessus" style="border-radius: 5px;margin:3px;" name="addProcessus" type="button" class="<%=Design.btn%> fa fa-plus"> 
                                            Processus
                                        </button>
                                    </form>

                                </nav>
                                <!--====================================================================-->
                                <br>
                                <!--====================================================================-->
                                <!--====================================================================-->
                                <div class="<%=Design.containerTitle%>">
                                    <h3 class="<%=Design.textNormal%>">Utilisateurs</h3>
                                </div>
                                <div class="<%=Design.container%>">
                                    <br>
                                    <div class="<%=Design.cadreTable%>">
                                        <table class="<%=Design.table%>" cellspacing="0" width="100%" style="width:100%">
                                            <thead>
                                                <tr class="w3-light-gray w3-text-dark-gray">
                                                    <th>ID</th>
                                                    <th>Nom</th>
                                                    <th>Prenom</th>
                                                    <th>Type_d'utilisateur</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% List<User> listUser = level3.getUserList(); %>
                                                <% for (User user : listUser) {%>
                                                <tr>
                                                    <td><%=user.getId()%></td>
                                                    <td><%=user.getName()%></td>
                                                    <td><%=user.getFirstName()%></td>
                                                    <td><%=user.getIdTypeUser().getName()%></td>
                                                    <td>
                                                        <form class="form-horizontal " action="<%=application.getContextPath()%>/L3?id=<%=level3.getId()%>" method="post">
                                                            <input hidden style="margin:3px;" name="idUser" type="text" class="w3-hide" placeholder="" value="<%=user.getId()%>">
                                                            <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                                        return true;
                                                                    } else {
                                                                        return false;
                                                                    }" name="deleteUser" type="submit" class="<%=Design.btn%> w3-hover-red ti-trash"> 
                                                            </button>
                                                            <a href="<%=application.getContextPath()%>/User?id=<%=user.getId()%>" class="<%=Design.btn%> w3-hover-green ti-eye"> 
                                                            </a>
                                                        </form>
                                                    </td>
                                                </tr>
                                                <% }%>
                                            </tbody>
                                        </table>                                    
                                    </div>
                                    <br>
                                </div>
                                <!--====================================================================-->
                                <br>
                                <!--====================================================================-->
                                <div class="<%=Design.containerTitle%>">                  
                                    <h3 class="<%=Design.textNormal%>">Nature du processus</h3>
                                </div>
                                <div class="<%=Design.container%>">
                                    <br>
                                    <div class="<%=Design.cadreTable%>">
                                        <table class="<%=Design.table%>" cellspacing="0" width="100%" style="width:100%">
                                            <thead>
                                                <tr class="w3-light-gray w3-text-dark-gray">
                                                    <th>ID</th>
                                                    <th>Nom</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% List<Nature> listNature = ServiceNature.findAll(); %>
                                                <% for (Nature nature : listNature) {%>
                                                <tr>
                                                    <td ><%=nature.getId()%></td>
                                                    <td><%=nature.getName()%></td>
                                                    <td>
                                                        <form class="form-horizontal " action="<%=application.getContextPath()%>/L3?id=<%=level3.getId()%>" method="post">
                                                            <input hidden style="margin:3px;" name="idNature" type="text" class="w3-hide" placeholder="" value="<%=nature.getId()%>">
                                                            <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                                        return true;
                                                                    } else {
                                                                        return false;
                                                                    }" name="deleteNature" type="submit" class="<%=Design.btn%> w3-hover-red ti-trash"> 
                                                            </button>
                                                            <a href="<%=application.getContextPath()%>/Nature?id=<%=nature.getId()%>" class="<%=Design.btn%> w3-hover-green ti-eye"> 
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
                                <!--====================================================================-->
                                <br>
                                <!--====================================================================-->
                                <div class="<%=Design.containerTitle%>">
                                    <h3 class="<%=Design.textNormal%>">Processus</h3>
                                </div>
                                <div class="<%=Design.container%>">
                                    <br>
                                    <div class="<%=Design.cadreTable%>">
                                        <table class="<%=Design.table%>" cellspacing="0" width="100%" style="width:100%">
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
                                                <tr>
                                                    <td><%=processus.getId()%></td>
                                                    <td><%=processus.getName()%></td>
                                                    <td><%=processus.getName()%></td>
                                                    <%if (user != null) {%>
                                                    <td><a href="User?id=<%=user.getId()%>"><%=user.getFirstName() + " " + user.getName()%></a></td>
                                                        <%} else {%>
                                                    <td></td>
                                                    <%}%>
                                                    <td>
                                                        <form class="form-horizontal " action="<%=application.getContextPath()%>/L3?id=<%=level3.getId()%>" method="post">
                                                            <input hidden style="margin:3px;" name="idProcessus" type="text" class="w3-hide" placeholder="" value="<%=processus.getId()%>">
                                                            <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                                        return true;
                                                                    } else {
                                                                        return false;
                                                                    }" name="deleteProcessus" type="submit" class="<%=Design.btn%> w3-hover-red ti-trash"> 
                                                            </button>
                                                            <a href="processus.jsp?id=<%=processus.getId()%>" class="<%=Design.btn%> w3-hover-green ti-eye"> 
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
                                <!--====================================================================-->
                                <br>
                                <!--====================================================================-->
                                <div class="<%=Design.containerTitle%>">
                                    <h3 class="<%=Design.textNormal%>">Niveau 2</h3>
                                </div>
                                <div class="<%=Design.container%>">
                                    <br>
                                    <div class="<%=Design.cadreTable%>">
                                        <table class="<%=Design.table%>" cellspacing="0" width="100%" style="width:100%">
                                            <thead>
                                                <tr class="w3-light-gray w3-text-dark-gray">
                                                    <th>ID</th>
                                                    <th>Nom</th>
                                                    <th>Processus</th>
                                                    <th>Taille</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% List<Level2> listLevel2 = level3.getLevel2List(); %>
                                                <% for (Level2 l : listLevel2) {%>
                                                <tr>
                                                    <td><%=l.getId()%></td>
                                                    <td><%=l.getName()%></td>
                                                     <td><%=l.getIdProcessus().getName()%></td>
                                                    <td><%=l.getLevel1List().size()%></td>
                                                    <td>
                                                        <form class="form-horizontal " action="<%=application.getContextPath()%>/L3?id=<%=level3.getId()%>" method="post">
                                                            <input hidden style="margin:3px;" name="idLevel" type="text" class="w3-hide" placeholder="" value="<%=l.getId()%>">
                                                            <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                                        return true;
                                                                    } else {
                                                                        return false;
                                                                    }" name="deleteLevel" type="submit" class="<%=Design.btn%> w3-hover-red ti-trash"> 
                                                            </button>
                                                            <a href="<%=application.getContextPath()%>/L2?id=<%=l.getId()%>" class="<%=Design.btn%> w3-hover-green ti-eye"> 
                                                            </a>
                                                        </form>

                                                    </td>

                                                </tr>
                                                <% } %>
                                            </tbody>
                                        </table>
                                    </div>
                                    <br>
                                </div>            
                                <!--====================================================================-->


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
    #                        Ajouter un niveau                         #
    ####################################################################-->

<div class="modal fade" id="addLevel" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body bg-white">

                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br><br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">Ajouter un niveau </h3>    
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form  action="<%=application.getContextPath()%>/L3?id=<%=level3.getId()%>" method="post" >

                        <div class="card-content">
                            <div class="form-group">
                                <h5 class="">

                                </h5>
                                <p class="<%=Design.textNormal%>"> Nom de niveau <star>*</star> </p>    
                                <input class="<%=Design.inputText%>" name="nameLevel" type="text" required="true" >
                            </div>
                            <div class="form-group">
                                <p class="<%=Design.textNormal%>"> Processus<star>*</star> </p>    
                                <select style="border-radius: 5px;" id="idProcessus" name="idProcessus" class="selectpickers w3-input w3-border w3-border-grey w3-round" title="" data-size="7"   onchange="loadDoc()" required>
                                    <% List<Processus> listProcessus = ServiceProcessus.findAll();
                                        for (Processus processus : listProcessus) {
                                            String value = processus.getName();
                                    %>
                                    <option class="" value="<%=processus.getId()%>"><%=value%></option>   
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <button style="border-radius: 5px;" name="addLevel" type="submit" class="<%=Design.btn%>">Ajouter</button>
                        <button style="border-radius: 5px;" type="reset" class="<%=Design.btn%>">Annuler</button>

                    </form>
                    <br>
                </div>
            </div> 
        </div>
    </div>
</div>  

<!--####################################################################
    #                                                                  #
    #                         Renommer le niveau                       #
    ####################################################################-->

<div class="modal fade" id="renameLevel" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br><br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">Renommer le niveau</h3>    
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form  action="<%=application.getContextPath()%>/L3?id=<%=level3.getId()%>" method="post" >
                        <div class="card-content">
                            <div class="form-group">
                                <p class="<%=Design.textNormal%>">Nom de nuveau <star>*</star> </p>    
                                <input class="<%=Design.inputText%>" name="nameLevel" type="text" required="true" >
                            </div>
                        </div>
                        <button style="border-radius: 5px;" name="renameLevel" type="submit" class="<%=Design.btn%>">Renommer</button>
                        <button style="border-radius: 5px;" type="reset" class="<%=Design.btn%>">Annuler</button>
                    </form>
                    <br>
                </div> 
            </div> 
        </div>
    </div>
</div>  

<!--####################################################################
    #                                                                  #
    #                      Ajouter un pilote                           #
    ####################################################################-->

<div class="modal fade" id="addUser" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog  modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body ">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br><br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">Ajouter un pilote</h3>    
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form  name="f1" action="<%=application.getContextPath()%>/L3?id=<%=level3.getId()%>" method="post" >

                        <div class="card-content">
                            <div class="form-group">
                                <p class="<%=Design.textNormal%>">Type d'Utilisateur <star>*</star></p>    
                                <select style="border-radius: 5px;" id="idTypeUser1" name="idTypeUser" class="selectpickers w3-input w3-border w3-border-grey w3-round" title="" data-size="7"   onchange="listUser()" required>
                                    <% List<TypeUser> listTypeUser = ServiceTypeUser.findAll();
                                        for (TypeUser typeUser : listTypeUser) {
                                            String value = typeUser.getName();
                                    %>
                                    <option class="" draggable value="<%=typeUser.getId()%>"><%=value%></option>   
                                    <%}%>
                                </select>
                            </div>
                            <p class="<%=Design.textNormal%>">Utilisateur <star>*</star></p>    
                            <div id="listUser1"></div>
                        </div>

                        <button style="border-radius: 5px;" name="addUser" type="submit" class="<%=Design.btn%>">Ajouter</button>
                        <button style="border-radius: 5px;" type="reset" class="<%=Design.btn%>">Annuler</button>


                    </form>
                    <br>
                </div> 
            </div> 
        </div>
    </div>
</div>  

<!--####################################################################
    #                                                                  #
    #                        Ajouter Nature                            #
    ####################################################################-->

<div class="modal fade" id="addNature" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog  modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body bg-white">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br><br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">Ajouter Nature</h3>    
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form  name="f1" action="<%=application.getContextPath()%>/L3?id=<%=level3.getId()%>" method="post" >

                        <div class="card-content">
                            <div class="form-group">
                                <br>
                                <p class="<%=Design.textNormal%>">Nom du Nature</p>    
                                <input class="<%=Design.inputText%>" name="nameNature" type="text" required="true" >
                            </div>
                            <div class="form-group">
                                <p class="<%=Design.textNormal%>">Couleur du Nature</p>    
                                <input class="form-control w3-padding w3-border w3-border-grey w3-round " type="color" id="color" name="color" value="#3f87a6" />
                            </div>
                        </div>

                        <button style="border-radius: 5px;" name="addNature" type="submit" class="<%=Design.btn%>">Ajouter</button>
                        <button style="border-radius: 5px;" type="reset" class="<%=Design.btn%>">Annuler</button>


                    </form>
                    <br>
                </div>

            </div> 
        </div>
    </div>
</div> 

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
                    <form  name="f1" action="<%=application.getContextPath()%>/L3?id=<%=level3.getId()%>" method="post" >

                        <div class="card-content">
                            <div class="form-group ">
                                <p class="<%=Design.textNormal%>">Nom du processus</p>    
                                <input class="<%=Design.inputText%>" name="nameProcessus" type="text" required="true" >
                            </div>
                            <div class="form-group">
                                <p class="<%=Design.textNormal%>">Nature du processus</p>    
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
                                <select style="border-radius: 5px;" id="idTypeUser2" name="idTypeUser" class="selectpickers w3-input w3-border w3-border-grey w3-round" title="" data-size="7"   onchange="listUser2()" required>
                                    <% //List<TypeUser> listTypeUser1 = new DaoTypeUser().findAll();
                                        for (TypeUser typeUser : listTypeUser) {
                                            String value = typeUser.getName();
                                    %>
                                    <option class="" draggable value="<%=typeUser.getId()%>"><%=value%></option>   
                                    <%}%>
                                </select>
                            </div>
                            <p class="<%=Design.textNormal%>">Utilisateur</p>    
                            <div id="listUser2"></div>    
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

<!--####################################################################
    #                                                                  #
    #                                                                  #
    ####################################################################-->

<script>
    function listUser1() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("listUser1").innerHTML =
                        this.responseText;
            }
        };
        var idTypeUser = document.getElementById("idTypeUser1");
        var idTypeUser = idTypeUser.options[idTypeUser.selectedIndex].value;
        xhttp.open("GET", "<%=application.getContextPath()%>/user/ajax/listUser.jsp?idTypeUser=" + idTypeUser, true);
        xhttp.send();
    }
    function listUser2() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("listUser2").innerHTML =
                        this.responseText;
            }
        };
        var idTypeUser = document.getElementById("idTypeUser2");
        var idTypeUser = idTypeUser.options[idTypeUser.selectedIndex].value;
        xhttp.open("GET", "<%=application.getContextPath()%>/user/ajax/listUser.jsp?idTypeUser=" + idTypeUser, true);
        xhttp.send();
    }
</script>


