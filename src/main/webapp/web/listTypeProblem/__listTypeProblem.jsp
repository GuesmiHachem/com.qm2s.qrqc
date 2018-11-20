<%@page import="domaine.Design"%>
<%@page import="entity.*"%>
<%@page import="service.*"%>
<%@page import="java.util.List"%>



<%
    //--------------------------------------------------------
    String nameTypeUser = request.getParameter("nameTypeProblem");
    String idTypeUser = request.getParameter("idTypeProblem");
    //--------------------------------------------------------
    String addTypeUser = request.getParameter("addTypeProblem");
    String deleteTypeUser = request.getParameter("deleteTypeProblem");
    //--------------------------------------------------------

    //--------------------------------------------------------
    if (addTypeUser != null) {
        TypeProblem typeProblem = new TypeProblem();
        typeProblem.setName(nameTypeUser);

        ServiceTypeProblem.create(typeProblem);
    }
    //--------------------------------------------------------
    if (deleteTypeUser != null) {
        ServiceTypeProblem.destroy(Integer.parseInt(idTypeUser));
    }

%>




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
                                        <h3 class="<%=Design.textNormal%>">Liste des types de problémes</h3>
                                    </div>
                                    <div class="w3-right">
                                        <button data-toggle="modal" data-target="#addTypeProblem" style="border-radius: 5px;margin:3px;" name="addTypeProblem" type="button" class="<%=Design.btn%> w3-hover-white ti-plus"> 
                                        </button>
                                    </div>
                                    <div class=" w3-right">
                                        <form action="<%=application.getContextPath()%>/ListTypeProblem" method="post">
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
                                    <table class="<%=Design.table%>" cellspacing="0" width="100%" style="width:100%">
                                        <thead>
                                            <tr class="w3-light-gray">
                                                <th>#</th>
                                                <th>Nom</th>
                                                <th>Couleur</th>
                                                <td class="disabled-sorting" ></td>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%                                                List<TypeProblem> listTypeProblem = ServiceTypeProblem.findAll();
                                                for (TypeProblem typeProblem : listTypeProblem) {
                                            %>
                                            <tr >
                                                <td><%=typeProblem.getId()%></td>
                                                <td><%=typeProblem.getName()%></td>
                                                <td>
                                                    <div style="background-color: <%=typeProblem.getColor()%>" class="w3-round w3-padding"></div>
                                                </td>
                                                <td>
                                                    <form class="form-horizontal " action="<%=application.getContextPath()%>/ListTypeProblem"  method="post">
                                                        <input hidden style="margin:3px;" name="idTypeProblem" type="text" class="w3-hide" placeholder="" value="<%=typeProblem.getId()%>">
                                                        <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                                    return true;
                                                                } else {
                                                                    return false;
                                                                }" name="deleteTypeProblem" type="submit" class="<%=Design.btn%> w3-hover-pink  ti-minus"> 
                                                        </button>
                                                        <a href="TypeProblem?id=<%=typeProblem.getId()%>" class="<%=Design.btn%> w3-hover-light-green ti-eye"> 
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

<div class="modal fade" id="addTypeProblem" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog  modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body bg-white">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br><br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">Ajouter un Type de probléme</h3>
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form  name="f1" action="<%=application.getContextPath()%>/ListTypeProblem" method="post" >

                        <div class="card-content">
                            <div class="form-group">
                                <p class="<%=Design.textNormal%>">Nom </p>
                                <input class="<%=Design.inputText%>" name="nameTypeProblem" type="text" required="true" email="true" autocomplete="off" aria-required="true">
                            </div>
                        </div>
                        <div class="card-content">
                            <div class="form-group">
                               <p class="<%=Design.textNormal%>">Couleur </p>
                                <input class="form-control w3-padding w3-border w3-border-grey w3-round " name="colorTypeProblem" type="color" required="true" value="#123654">
                            </div>
                        </div>

                        <button style="border-radius: 5px;" name="addTypeProblem" type="submit" class="<%=Design.btn%>">Ajouter</button>
                        <button style="border-radius: 5px;" type="reset" class="<%=Design.btn%>">Annuler</button>


                    </form>
                    <br>
                </div>


            </div> 
        </div>
    </div>
</div>  

