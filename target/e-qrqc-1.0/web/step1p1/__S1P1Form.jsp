
<%@page import="entity.*"%>
<%@page import="service.*"%>
<%@page import="domaine.Design"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ResourceBundle"%>
<%
    entity.Problem problem = (entity.Problem) session.getAttribute("problem");
    //ResourceBundle bundle = (ResourceBundle) session.getAttribute("bundle");
%>

<div class="row ">
    <div class="col-lg-3 mb-3">
        <div class="card w3-dark-gray ">
            <div class="card-body">
                <i class="fa fa-user"></i>
                <%=problem.getIdUser().getFirstName() + " " + problem.getIdUser().getName()%>
            </div>
        </div>
    </div>
    <div class="col-lg-2  mb-3">
        <div class="card w3-dark-gray">
            <div class="card-body">
                <i class="fa fa-briefcase"></i>
                <%=problem.getIdUser().getIdTypeUser().getName()%>
            </div>
        </div>
    </div>
    <div class="col-lg-2 mb-3">
        <div class="card w3-dark-gray">
            <div class="card-body">
                <i class="fa fa-folder"></i>
                <%=problem.getIdLevel1().getName()%>
            </div>
        </div>
    </div>
    <div class="col-lg-2 mb-3">
        <div class="card w3-dark-gray">
            <div class="card-body">
                <i class="fa fa-group"></i>
                <%=problem.getIdUser().getIdLevel0().getName()%>
            </div>
        </div>
    </div>

    <div class="col-lg-3 mb-3">
        <div class="card w3-pink">
            <div class="card-body">
                <i class="fa fa-warning"></i>
                <%=problem.getCode()%>
            </div>
        </div>

    </div>

</div> 

<form  action="<%=application.getContextPath()%>/CreateS1P1"  method="post"  enctype="multipart/form-data" >

    <div class="card mb-3" >
        <div class="card-header font-weight-bold">
            Caractérisation
        </div>
        <div class="card-body w3-medium">


            <div class="row">
                <div class="col-lg-4">
                    <div class="card mb-3 ">
                        <div class="card-header ">
                            <div class="form-group">
                                <input  name="reference" type="text" class=" form-control" placeholder="Reference" required>
                            </div>
                        </div>
                        <div class="card-body w3-white">
                            <!--#######################################-->
                            <!--================================-->

                            <!--================================-->
                            <div class="form-group row">
                                <label  class="col-lg-4">
                                    <h6>Que s'est t'il passé&nbsp;?</h6>
                                </label>
                                <div class="col-lg-8">
                                    <input name="what" type="text" class="form-control" placeholder="est-ce un probléme ?" required>
                                </div>
                            </div>
                            <!--================================-->
                            <div class="form-group row">
                                <label  class="col-lg-4">
                                    <h6>Quand ?</h6>
                                </label>
                                <div class="col-lg-8">
                                    <input name="when" type="date" class="form-control" placeholder="date et heure ?" required>
                                </div>
                            </div>
                            <!--================================-->
                            <div class="form-group row">
                                <label  class="col-lg-4">
                                    <h6>Ou ?</h6>
                                </label>
                                <div class="col-lg-8">
                                    <input name="where" type="text" class="form-control" placeholder="détecté / généré ?" required>
                                </div>
                            </div>
                            <!--================================-->
                            <div class="form-group row">
                                <label  class="col-lg-4">
                                    <h6>Qui ?</h6>
                                </label>
                                <div class="col-lg-8">
                                    <input name="who" type="text" class="form-control" placeholder="a détecté le probléme ?" required>
                                </div>
                            </div>
                            <!--================================-->
                            <div class="form-group row">
                                <label  class="col-lg-4">
                                    <h6>Comment  ?</h6>
                                </label>
                                <div class="col-lg-8">
                                    <input name="how" type="text" class="form-control" placeholder="a-t-il eté détecté ?" required> 
                                </div>
                            </div>
                            <!--================================-->
                            <div class="form-group row">
                                <label  class="col-lg-4">
                                    <h6>Combien  ?</h6>
                                </label>
                                <div class="col-lg-8">
                                    <input name="how_match" type="number" class="form-control" placeholder="de défauts? Pertes?" required>
                                </div>
                            </div>
                            <!--================================-->
                            <div class="form-group row">
                                <label  class="col-lg-4">
                                    <h6>Pourquoi  ?</h6>
                                </label>
                                <div class="col-lg-8">
                                    <input name="why" type="text" class="form-control" placeholder="est-ce un probléme ?" required>
                                </div>
                            </div>
                            <hr>
                            <div class="form-group row">

                                <div class="col-lg-12">
                                    <div class="form-group ">
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <label for="staticEmail" class="col-form-label">Respect du standard ?</label>
                                                <label class="switch">
                                                    <input name="respect_standard" type="checkbox" checked>
                                                    <span class="slider round"></span>
                                                </label>   
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-12">
                                    <div class="form-group ">
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <label for="staticEmail" class="col-form-label">Problème récurrent ?&nbsp;</label>
                                                <label class="switch">
                                                    <input name="probleme_recurrent" type="checkbox" checked>
                                                    <span class="slider round"></span>
                                                </label>   
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <br> 
                            </div>
                            <!--#######################################-->
                        </div>
                    </div>
                </div>

                <div class="col-lg-4 ">
                    <!--#######################################-->
                    <div class="row">
                        <div class="col-lg-12">

                            <div class="card  mb-3">
                                <div class="card-header w3-text-pink">
                                    Mauvaise piece
                                </div>
                                <div class="card-body  w3-white w3-padding w3-center ">
                                    <label class="newbtn w3-padding-64" style="cursor: pointer;" >
                                        <img class="card-img-top w3-text-gray fa fa-upload w3-xxlarge" id="img1" src="" >
                                        <input style="display: none;"  onchange="readURL(this, img1);" name="bad_piece" type="file" accept="image/*" required>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-12">

                            <div class="card mb-3">
                                <div class="card-header w3-text-green">
                                    Bonne piece
                                </div>
                                <div class="card-body  w3-white w3-padding w3-center">
                                    <label class="newbtn w3-padding-64" style="cursor: pointer;" >
                                        <img class="card-img-top w3-text-gray fa fa-upload w3-xxlarge " id="img2" src="" >
                                        <input style="display: none;"  onchange="readURL(this, img2);" name="good_piece" type="file" accept="image/*" required>
                                    </label>
                                </div>
                            </div>
                        </div>

                        <script>
                            function readURL(input, img) {
                                if (input.files && input.files[0]) {
                                    var reader = new FileReader();
                                    reader.onload = function (e) {
                                        $(img).attr('src', e.target.result);
                                    };
                                    reader.readAsDataURL(input.files[0]);
                                }
                            }
                        </script>
                    </div>
                </div>
                <div class="col-lg-4" >

                    <div class="card bg-light mb-3">
                        <div class="card-header">Type de probleme</div>
                        <div class="card-body  w3-white">
                            <%  List<TypeProblem> listTypeProblem = ServiceTypeProblem.findAll();
                                for (TypeProblem typeProblem : listTypeProblem) {
                                    String value = typeProblem.getName();
                            %>

                            <div class="col-auto my-1">
                                <div class="custom-control custom-radio mr-sm-2">
                                    <input name="type_problem"  type="radio" class="custom-control-input" id="radio<%=typeProblem.getId()%>" value="<%=typeProblem.getId()%>">
                                    <label class="custom-control-label" for="radio<%=typeProblem.getId()%>"><%=value%></label>
                                </div>
                            </div>
                            <%}%>
                        </div>
                    </div>


                    <div class="card bg-light mb-3">
                        <div class="card-header">
                            Qui doit être Alerté
                        </div>
                        <div class="card-body  w3-white">
                            <%  List<TypeUser> listTypeUser1 = ServiceTypeUser.findAll();
                                for (TypeUser typeUser : listTypeUser1) {
                                    String value = typeUser.getName();
                            %>
                            <div class="col-auto my-1">
                                <div class="custom-control custom-checkbox mr-sm-2">
                                    <input name="ShouldAlerted[]"  type="checkbox" class="custom-control-input" id="checkbox<%=typeUser.getId()%>" value="<%=typeUser.getId()%>">
                                    <label class="custom-control-label" for="checkbox<%=typeUser.getId()%>"><%=value%></label>
                                </div>
                            </div>
                            <%}%>
                        </div>
                    </div>

                    <div class="card bg-light mb-3">
                        <div class="card-header">
                            Qui peut être Alerté
                        </div>
                        <div class="card-body  w3-white">
                            <%  listTypeUser1 = ServiceTypeUser.findAll();
                                for (TypeUser typeUser : listTypeUser1) {
                                    String value = typeUser.getName();
                            %>
                            <div class="col-auto my-1">
                                <div class="custom-control custom-checkbox mr-sm-2">
                                    <input name="CanAlerted[]"  type="checkbox" class="custom-control-input" id="checkbox1<%=typeUser.getId()%>" value="<%=typeUser.getId()%>">
                                    <label class="custom-control-label" for="checkbox1<%=typeUser.getId()%>"><%=value%></label>
                                </div>
                            </div>
                            <%}%>
                        </div>
                    </div>
                </div>
            </div> 
        </div>
        <div class="card-footer w3-padding-small">
            <div class="btn-group w3-right" role="group" aria-label="Basic example">
                <button type="reset" class="btn w3-white">Annuler</button>
                <button type="submit" class="btn btn-primary" name="S1P1">Suivant</button>
            </div>
        </div>
    </div>
</form>













<%
    //listTypeProblem = null;
    // listTypeUser1 = null;
    //listTypeUser2 = null;

%>