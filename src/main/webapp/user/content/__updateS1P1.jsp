

<%@page import="java.util.ResourceBundle"%>
<%@page import="entity.*"%>
<%@page import="service.*"%>


<%@page import="domaine.Design"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
    //List<Step1> listStep1 = new ArrayList<Step1>();

    String id_problem = request.getParameter("id");
    Problem problem = ServiceProblem.find(Integer.parseInt(id_problem));
    TypeProblem typeProblem = problem.getIdTypeProblem();
    Step1 step1 = problem.getIdStep1();
    step1 = ServiceStep1.find(step1.getId());
    User user = problem.getIdUser();

    List<Step1Action> listStep1Action = step1.getStep1ActionList();
    List<Step1Securisation> listStep1SecurityPlan = step1.getStep1SecurisationList();
    List<Step1ActionFollowed> listStep1ActionFollowed = step1.getStep1ActionFollowedList();
    //List<Step1Why> listStep1Why = step1.getSte
    List<Step1AlertCan> listStep1AlertCan = step1.getStep1AlertCanList();
    List<Step1AlertShould> listStep1AlertShould = step1.getStep1AlertShouldList();
    ResourceBundle bundle = (ResourceBundle) session.getAttribute("bundle");


%>
<form  action="<%=application.getContextPath()%>/UpdateS1P1?id=<%=problem.getId()%>" method="post"  enctype="multipart/form-data" >
    <div class="card mb-3" >
        <div class="card-header font-weight-bold">
            Caractérisation
            <div class="w3-right">
                <button  onclick="document.location.href = 'Problem?id=<%=problem.getId()%>'" type="button" class="btn btn-light btn-sm fa fa-external-link w3-text-dark-gray"> 
                </button>
            </div>
        </div>
        <div class="card-body w3-medium">
            <div class="row">
                <div class="col-lg-5">
                    <div class="card mb-3 ">
                        <div class="card-header ">
                            <div class="form-group">
                                <input  name="reference" type="text" class=" form-control" value="<%=problem.getReference()%>" required>
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
                                    <input name="what" type="text" class="form-control" value="<%=step1.getWhat()%>" required>
                                </div>
                            </div>
                            <!--================================-->
                            <div class="form-group row">
                                <label  class="col-lg-4">
                                    <h6>Quand ?</h6>
                                </label>
                                <div class="col-lg-8">
                                    <input name="when" type="date" class="form-control" value="<%=step1.getWhen()%>" required>
                                </div>
                            </div>
                            <!--================================-->
                            <div class="form-group row">
                                <label  class="col-lg-4">
                                    <h6>Ou ?</h6>
                                </label>
                                <div class="col-lg-8">
                                    <input name="where" type="text" class="form-control" value="<%=step1.getWhere()%>" required>
                                </div>
                            </div>
                            <!--================================-->
                            <div class="form-group row">
                                <label  class="col-lg-4">
                                    <h6>Qui ?</h6>
                                </label>
                                <div class="col-lg-8">
                                    <input name="who" type="text" class="form-control" value="<%=step1.getWho()%>" required>
                                </div>
                            </div>
                            <!--================================-->
                            <div class="form-group row">
                                <label  class="col-lg-4">
                                    <h6>Comment  ?</h6>
                                </label>
                                <div class="col-lg-8">
                                    <input name="how" type="text" class="form-control" value="<%=step1.getHow()%>" required> 
                                </div>
                            </div>
                            <!--================================-->
                            <div class="form-group row">
                                <label  class="col-lg-4">
                                    <h6>Combien  ?</h6>
                                </label>
                                <div class="col-lg-8">
                                    <input name="how_match" type="number" class="form-control" value="<%=step1.getHowMutch()%>" required>
                                </div>
                            </div>
                            <!--================================-->
                            <div class="form-group row">
                                <label  class="col-lg-4">
                                    <h6>Pourquoi  ?</h6>
                                </label>
                                <div class="col-lg-8">
                                    <input name="why" type="text" class="form-control" value="<%=step1.getWhat()%>" required>
                                </div>
                            </div>
                            <hr>
                            <div class="form-group row">

                                <div class="col-lg-12">
                                    <div class="form-group ">
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <label for="staticEmail" class="col-form-label">Respect du standard ?</label>
                                                <%if (step1.getRespectStandard()) {%>
                                                <label class="switch">
                                                    <input name="respect_standard" type="checkbox" checked>
                                                    <span class="slider round"></span>
                                                </label>   
                                                <%} else {%>
                                                <label class="switch">
                                                    <input name="respect_standard" type="checkbox">
                                                    <span class="slider round"></span>
                                                </label> 
                                                <%}%>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-12">
                                    <div class="form-group ">
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <label for="staticEmail" class="col-form-label">Problème récurrent ?&nbsp;</label>
                                                <%if (step1.getRecognizedProblem()) {%>
                                                <label class="switch">
                                                    <input name="probleme_recurrent" type="checkbox" checked>
                                                    <span class="slider round"></span>
                                                </label>   
                                                <%} else {%>
                                                <label class="switch">
                                                    <input name="probleme_recurrent" type="checkbox" >
                                                    <span class="slider round"></span>
                                                </label>  
                                                <%}%>
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

                <div class="col-lg-3 ">
                    <!--#######################################-->
                    <div class="row">
                        <div class="col-lg-12">

                            <div class="card  mb-3">
                                <div class="card-header w3-text-pink">
                                    Mauvaise piece
                                </div>
                                <div class="card-body  w3-white w3-padding w3-center ">
                                    <label class="newbtn w3-padding-small" style="cursor: pointer;" >
                                        <img class="card-img-top w3-text-gray fa fa-upload w3-xxlarge" id="img1" src="<%=application.getContextPath()%>/upload/<%=step1.getBadPiece()%>" >
                                        <input style="display: none;"  onchange="readURL(this, img1);" name="bad_piece" type="file" accept="image/*" required1>
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
                                    <label class="newbtn w3-padding-small" style="cursor: pointer;" >
                                        <img class="card-img-top w3-text-gray fa fa-upload w3-xxlarge " id="img2" src="<%=application.getContextPath()%>/upload/<%=step1.getGoodPiece()%>" >
                                        <input style="display: none;"  onchange="readURL(this, img2);" name="good_piece" type="file" accept="image/*" required1>
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
                                for (TypeProblem tp : listTypeProblem) {
                                    String value = tp.getName();
                                    if (tp.equals(typeProblem)) {
                            %>

                            <div class="col-auto my-1">
                                <div class="custom-control custom-radio mr-sm-2">
                                    <input checked name="type_problem"  type="radio" class="custom-control-input" id="radio<%=tp.getId()%>" value="<%=tp.getId()%>">
                                    <label class="custom-control-label" for="radio<%=tp.getId()%>"><%=value%></label>
                                </div>
                            </div>
                            <%} else {%>
                            <div class="col-auto my-1">
                                <div class="custom-control custom-radio mr-sm-2">
                                    <input name="type_problem"  type="radio" class="custom-control-input" id="radio<%=tp.getId()%>" value="<%=tp.getId()%>">
                                    <label class="custom-control-label" for="radio<%=tp.getId()%>"><%=value%></label>
                                </div>
                            </div>
                            <%}
                                }%>
                        </div>
                    </div>
                </div>
            </div> 
        </div>
        <div class="card-footer w3-padding-small bg-light">
            <div class="btn-group w3-right" role="group" aria-label="Basic example">                
                <button type="submit" class="btn btn-primary" name="S1P1">Sauvegarder</button>
                <button type="reset" class="btn w3-white">Annuler</button>
            </div>
        </div>
    </div>
</form>








