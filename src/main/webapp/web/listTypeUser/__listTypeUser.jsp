<%@page import="domaine.Design"%>
<%@page import="domaine.Design"%>
<%@page import="entity.*"%>
<%@page import="service.*"%>

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
                                        <h3 class="<%=Design.textNormal%>">Liste des types d'utilisateur</h3>
                                    </div>
                                    <div class="w3-right">
                                        <button data-toggle="modal" data-target="#addTypeUser" style="border-radius: 5px;margin:3px;" name="addTypeProblem" type="button" class="<%=Design.btn%> w3-hover-white ti-plus"> 
                                        </button>
                                    </div>
                                    <div class=" w3-right">
                                        <form action="<%=application.getContextPath()%>/ListTypeUser" method="post">
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
                                    <table  class="<%=Design.table%>" cellspacing="0" width="100%" style="width:100%">
                                        <thead>
                                            <tr class="w3-light-gray">
                                                <th>#</th>
                                                <th>Nom</th>
                                                <td class="disabled-sorting" ></td>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                List<TypeUser> listTypeUser = ServiceTypeUser.findAll();
                                                for (TypeUser typeUser : listTypeUser) {
                                            %>
                                            <tr>
                                                <td><%=typeUser.getId()%></td>
                                                <td><%=typeUser.getName()%></td>
                                                <td>
                                                    <form class="form-horizontal " action="" method="post">
                                                        <input hidden style="margin:3px;" name="idTypeUser" type="text" class="w3-hide" placeholder="" value="<%=typeUser.getId()%>">
                                                        <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                                    return true;
                                                                } else {
                                                                    return false;
                                                                }" name="deleteTypeUser" type="submit" class="<%=Design.btn%> w3-hover-pink ti-minus"> 
                                                        </button>
                                                        <a href="TypeUser?id=<%=typeUser.getId()%>" class="<%=Design.btn%> w3-hover-light-green ti-eye"> 
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
                        <br>

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
                <br><br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">Ajouter un Type d'utilisateur</h3>
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form  name="f1" action="" method="post" >

                        <div class="card-content">
                            <p class="<%=Design.textNormal%>">Nom </p>
                            <div class="form-group">
                                <input class="w3-input w3-border w3-border-grey w3-round" name="nameTypeUser" type="text" required="true" email="true" autocomplete="off" aria-required="true">
                            </div>
                        </div>

                        <button style="border-radius: 5px;" name="addTypeUser" type="submit" class="<%=Design.btn%>">Ajouter</button>
                        <button style="border-radius: 5px;" type="reset" class="<%=Design.btn%>">Annuler</button>


                    </form>
                    <br>
                </div>


            </div> 
        </div>
    </div>
</div>  

