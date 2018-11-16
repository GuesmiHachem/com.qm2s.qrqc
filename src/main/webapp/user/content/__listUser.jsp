<%@page import="entity.*"%>
<%@page import="service.*"%>

<%@page import="domaine.Design"%>
<%@page import="entity.User"%>
<%@page import="java.util.List"%>






<div class="content w3-light-gray">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">

                <div class="card w3-white w3-border-grey w3-border">
                    <div class="card-content">
                        <!--================================================-->
                        <div class="row">
                            <div class="col-lg-12">

                                <div class="<%=Design.containerTitle%>">
                                    <div class="col-xs-5">
                                        <h3 class="<%=Design.textNormal%>">Liste des utilisateurs</h3>
                                    </div>
                                    <div class="w3-right">
                                        <button data-toggle="modal" data-target="#addUser" style="border-radius: 5px;margin:3px;" name="addUser" type="button" class="<%=Design.btn%> w3-hover-white ti-plus"> 
                                        </button>
                                    </div>
                                    <div class=" w3-right">
                                        <form action="<%=application.getContextPath()%>/ListUser" method="post">
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
                                        <table id="datatables1" class="<%=Design.table%>" cellspacing="0" width="100%" style="width:100%">
                                            <thead>
                                                <tr class="">
                                                    <th>#</th>
                                                    <th>Photo</th>
                                                    <th>Prenom</th>
                                                    <th>Nom</th>
                                                    <th>Date_de_Naissance</th>
                                                    <th>Nom_d'utilisateur</th>
                                                    <th>Mot_de_passe</th>
                                                    <th>Type_d'utilisateur</th>
                                                    <th class="disabled-sorting" ></th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <%
                                                    List<User> listUser = ServiceUser.findAll();
                                                    for (User user : listUser) {
                                                %>
                                                <tr>
                                                    <td><%=user.getId()%></td>
                                                    <td>
                                                        <%if (user.getPicture() == null) {%>
                                                        <img class="w3-border w3-border-gray w3-round" width="60px" height="60px" src="<%=application.getContextPath()%>/img/profile/user.png" alt="...">
                                                        <%} else if (user.getPicture().equals("")) {%>
                                                        <img class="w3-border w3-border-gray w3-round" width="60px" height="60px" src="<%=application.getContextPath()%>/img/profile/user.png" alt="...">
                                                        <%} else {%> 
                                                        <img class="w3-border w3-border-gray w3-round" width="60px" height="60px" src="<%=application.getContextPath()%>/img/profile/<%=user.getPicture()%>" alt="...">
                                                        <%}%> 
                                                    </td>
                                                    <td><%=user.getFirstName()%></td>
                                                    <td><%=user.getName()%></td>
                                                    <td><%=user.getBirthday()%></td>
                                                    <td><%=user.getLogin()%></td>
                                                    <td><%=user.getPassword()%></td>
                                                    <td><%=(user.getIdTypeUser() == null) ? " " : user.getIdTypeUser().getName()%></td>
                                                    <td>
                                                        <form class="form-horizontal " action="" method="post">
                                                            <input hidden style="margin:3px;" name="idUser" type="text" class="w3-hide" placeholder="" value="<%=user.getId()%>">
                                                            <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                                        return true;
                                                                    } else {
                                                                        return false;
                                                                    }" name="deleteUser" type="submit" class="<%=Design.btn%> w3-hover-pink ti-minus"> 
                                                            </button>
                                                            <a href="<%=application.getContextPath()%>/User?id=<%=user.getId()%>" class="<%=Design.btn%> w3-hover-light-green ti-eye"> 
                                                            </a>
                                                        </form>

                                                    </td>
                                                </tr>
                                                <%
                                                    }
                                                %>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <!--================================================-->

                    </div>
                </div><!--  end card  -->
            </div> <!-- end col-md-12 -->
        </div> <!-- end row -->
    </div>
</div>

<div class="modal fade" id="addTypeUser" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog  modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body bg-white">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br>
                <br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">Ajouter un Type </h3>
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form  name="f1" action="<%=application.getContextPath()%>/ListUser" method="post" >

                        <div class="card-content">
                            <div class="form-group">
                                <p class="<%=Design.textNormal%>">Nom de type d'utilisateur <star> *</star></p>
                                <input class="<%=Design.inputText%>" name="nameTypeUser" type="text" required="true" email="true" autocomplete="off" aria-required="true">
                            </div>
                        </div>

                        <button  name="addTypeUser" type="submit" class="<%=Design.btn%>">Ajouter</button>
                        <button  type="reset" class="<%=Design.btn%>">Annuler</button>


                    </form>
                    <br>
                </div>


            </div> 
        </div>
    </div>
</div>  




<div class="modal fade" id="addUser" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body bg-white">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br><br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">Ajouter un utilisateur </h3>
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form id="registerFormValidation" action="<%=application.getContextPath()%>/ListUser" method="post">
                        <div class="card-content">
                            <div class="form-group">
                                <p class="<%=Design.textNormal%>">Prenom <star>*</star></p>
                                <input class="<%=Design.inputText%>" name="firstName" type="text" required>
                            </div>
                            <div class="form-group">
                                <p class="<%=Design.textNormal%>">Nom <star>*</star></p>
                                <input class="<%=Design.inputText%>" name="name" type="text" required>
                            </div>
                            <div class="form-group">
                                <p class="<%=Design.textNormal%>">Date de Naissance <star>*</star></p>
                                <input type="text" name="birthday" class="<%=Design.inputText%> datepicker" placeholder="" required> 
                            </div>
                            <div class="form-group">
                                <p class="<%=Design.textNormal%>">Nom d'utilisateur <star>*</star></p>
                                <input class="<%=Design.inputText%>" name="login" type="text" required>
                            </div>
                            <div class="form-group">
                                <p class="<%=Design.textNormal%>">Mot de passe <star>*</star></p>
                                <input class="<%=Design.inputText%>" name="password" type="password" required>
                            </div>
                            <div class="form-group">
                                <p class="<%=Design.textNormal%>">Type d'utilisateur <star>*</star></p>
                                <select id="idTypeUser" name="idTypeUser" class="selectpickers <%=Design.inputText%>" title="" data-size="7"  required>
                                    <%  List<TypeUser> listTypeUser = ServiceTypeUser.findAll();
                                        for (TypeUser typeUser : listTypeUser) {
                                            String value = typeUser.getName();
                                    %>
                                    <option class="" draggable value="<%=typeUser.getId()%>"><%=value%></option>   
                                    <%}%>
                                </select>
                            </div>
                            <br>
                            <div class="category"><star>*</star> Required fields</div>
                        </div>
                        <br>
                        <button  name="addUser" type="submit" class="<%=Design.btn%>">Ajouter</button>
                        <button  type="reset" class="<%=Design.btn%>">Annuler</button>
                    </form>
                    <br>
                </div>

            </div> 
        </div>
    </div>
</div>  