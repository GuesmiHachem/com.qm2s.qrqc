<%@page import="entity.*"%>
<%@page import="service.*"%>

<%@page import="domaine.Design"%>
<%@page import="java.util.List"%>

<%
    String idUser = request.getParameter("id");
    entity.User user = ServiceUser.find(Integer.parseInt(idUser));

%>

<div class="content w3-light-gray">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">

                <div class="card w3-white w3-border-grey w3-border ">
                    <div class="card-content">


                        <div class="row">

                            <div class="col-lg-4">
                                <form id="registerFormValidation" action="<%=application.getContextPath()%>/User?id=<%=user.getId()%>" method="post">

                                    <div class="<%=Design.containerTitle%>">
                                        <div class="col-xs-8">
                                            <h3 class="<%=Design.textNormal%>">Photo de profile</h3>
                                        </div>
                                        <div class=" w3-right">
                                            <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                        return true;
                                                    } else {
                                                        return false;
                                                    }" style="border-radius: 5px;margin:3px;" name="removePhoto" type="submit" class="<%=Design.btn%> w3-hover-white ti-trash"> 
                                            </button>
                                        </div>
                                    </div>
                                </form>
                                <form id="registerFormValidation" action="<%=application.getContextPath()%>/User?id=<%=user.getId()%>" method="post" enctype="multipart/form-data" class="">
                                    <div class="<%=Design.container%>">
                                        <div class="fileinput fileinput-new text-center" data-provides="fileinput">
                                            <br>
                                            <div class="fileinput-new w3-margin">
                                                <%if (user == null) {%>
                                                <img class="w3-round" src="<%=application.getContextPath()%>/img/profile/user.png" alt="...">
                                                <%} else if (user.getPicture().equals("")) {%>
                                                <img class="w3-round" src="<%=application.getContextPath()%>/img/profile/user.png" alt="...">
                                                <%} else {%>                   
                                                <img class="w3-round"  src="<%=application.getContextPath()%>/img/profile/<%=user.getPicture()%>" alt="...">
                                                <%}%> 
                                            </div>

                                            <div class="fileinput-preview fileinput-exists thumbnail1"></div>
                                            <br>
                                            <div>
                                                <span class="<%=Design.btn%> btn-file" style="border-radius: 5px">
                                                    <span class=" fileinput-new">Select image</span>
                                                    <span class=" fileinput-exists">Change</span>
                                                    <input name="photo" type="file" accept="image/*" required/>
                                                </span>
                                                <a style="border-radius: 5px" href="#pablo" class="<%=Design.btn%> fileinput-exists" data-dismiss="fileinput"><i class="fa fa-filltimes"></i> Remove</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="<%=Design.containerTitle%>">
                                        <div class="w3-right">
                                            <button  style="border-radius: 5px;margin:3px;" name="updateUser" type="submit" class="<%=Design.btn%> w3-hover-white ti-pencil"> 
                                            </button>
                                        </div>
                                    </div>
                                </form>
                                <br>
                            </div>  


                            <div class="col-lg-8">
                                <div class="<%=Design.containerTitle%>">
                                    <div class="col-xs-8">
                                        <h3 class="<%=Design.textNormal%>">Profile d'utilisateur</h3>
                                    </div>
                                    <div class=" w3-right">
                                        <button  onclick="document.location.href = 'ListUser'" style="border-radius: 5px;margin:3px;"  type="button" class="<%=Design.btn%> ti-view-list"> 
                                        </button>
                                    </div>
                                </div>
                                <form id="registerFormValidation" action="<%=application.getContextPath()%>/User?id=<%=user.getId()%>" method="post" >

                                    <div class="<%=Design.container%>">
                                        <div class="card-content">
                                            <div class="form-group">
                                                <p class="<%=Design.textNormal%>">Prenom</p>
                                                <input class="<%=Design.inputText%>" name="firstName" type="text" value="<%=user.getFirstName()%>" required>
                                            </div>
                                            <div class="form-group">
                                                <p class="<%=Design.textNormal%>">Nom</p>
                                                <input class="<%=Design.inputText%>" name="name" value="<%=user.getName()%>" type="text" required>
                                            </div>
                                            <div class="form-group">
                                                <p class="<%=Design.textNormal%>">Date de Naissance </p>
                                                <input type="text" name="birthday" value="<%=user.getBirthday()%>" class="<%=Design.inputText%> datepicker" placeholder="" required> 
                                            </div>
                                            <div class="form-group">
                                                <p class="<%=Design.textNormal%>"> Nom d'utilisateur </p>
                                                <input class="<%=Design.inputText%>" name="login" value="<%=user.getLogin()%>" type="text" required>
                                            </div>
                                            <div class="form-group">
                                                <p class="<%=Design.textNormal%>">Mot de passe </p>
                                                <input class="<%=Design.inputText%>" name="password" value="<%=user.getPassword()%>" type="text" required>
                                            </div>
                                            <div class="form-group">
                                                <p class="<%=Design.textNormal%>">Type d'Utilisateur <star>*</star></p>    
                                                <select style="border-radius: 5px;" id="idTypeUser1" name="idTypeUser" class="selectpickers w3-input w3-border w3-border-grey w3-round" title="" data-size="7"  required>
                                                    <% List<TypeUser> listTypeUser = ServiceTypeUser.findAll();
                                                        for (TypeUser typeUser : listTypeUser) {
                                                            String value = typeUser.getName();
                                                            if (user.getIdTypeUser().getId() == typeUser.getId()) {
                                                    %>
                                                    <option class="" selected value="<%=typeUser.getId()%>"  ><%=value%></option>   
                                                    <%} else {%>
                                                    <option class="" draggable value="<%=typeUser.getId()%>"><%=value%></option>   
                                                    <%}
                                                        }%>
                                                </select>
                                            </div>
                                        </div>


                                    </div> 
                                    <div class="<%=Design.container%>">
                                        <button  name="updateUser" type="submit" class="<%=Design.btn%>">Modifier</button>
                                        <button  type="reset" class="<%=Design.btn%>">Annuler</button>
                                    </div>
                                </form>


                            </div>        

                        </div>       

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
