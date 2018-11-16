<%@page import="dao.DaoTypeUser"%>
<%@page import="model.TypeUser"%>
<%@page import="model.TypeUser"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="dao.DaoProblem"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="model.Problem"%>
<%
    Problem problem = (Problem) session.getAttribute("problem");
    ResourceBundle bundle = (ResourceBundle) session.getAttribute("bundle");
%>

<%
    if (problem == null) {
        problem = new DaoProblem().generateProblem();
        session.setAttribute("problem", problem);
        response.sendRedirect("S1P1Form.jsp");
    } else {
%>
<div class="content w3-light-gray" >
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">


                <div class="card w3-white w3-border-grey w3-border">
                    <div class="card-content " >

                        <div class=" w3-container w3-padding-small w3-border w3-border-grey w3-round-large w3-light-gray">
                            <div class="row w3-padding-small">
                                <div class="col-lg-3 ">
                                    <p class="w3-border w3-white w3-round-xxlarge w3-padding-small"><% out.println(bundle.getString("probleme"));%>  </b></p>
                                </div>
                                <div class="col-lg-3 ">
                                    <p class="w3-border w3-white w3-round-xxlarge w3-padding-small">N° :<%=problem.getNum()%></p>
                                </div>
                                <div class="col-lg-3">
                                    <p class="w3-border w3-white w3-round-xxlarge w3-padding-small">Code : <%=problem.getCode()%></p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="progress">
                                        <div class="progress-bar w3-dark-gray" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 33%;">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="w3-container w3-light-gray w3-border w3-border-grey w3-round">
                            <h2 class="">Caractérisation</h2>
                        </div>
                        <br>
                        <div class="w3-container w3-white w3-border w3-border-grey w3-round">
                            <br>
                            <form  action="../controller/createPart1Step1.jsp"  method="post"  enctype="multipart/form-data" >

                                <div class="row">
                                    <div class="col-lg-5">
                                        <!--#######################################-->
                                        <!--================================-->
                                        <div class="form-group">
                                            <input  name="reference" type="text" class="w3-input w3-border w3-border-grey w3-white form-control" placeholder="Reference" required>
                                        </div>
                                        <div class="form-group row">
                                            <label  class="col-lg-4">
                                                <h6><% out.println(bundle.getString("quand"));%> ?</h6>
                                            </label>
                                            <div class="col-lg-8">
                                                <input name="when" type="text" class="w3-input w3-border w3-round datetimepicker" placeholder="date et heure ?" required>
                                            </div>
                                        </div>
                                        <!--================================-->
                                        <div class="form-group row">
                                            <label  class="col-lg-4">
                                                <h6><% out.println(bundle.getString("ou"));%> ?</h6>
                                            </label>
                                            <div class="col-lg-8">
                                                <input name="where" type="text" class="w3-input w3-border w3-round  " placeholder="détecté / généré ?" required>
                                            </div>
                                        </div>
                                        <!--================================-->
                                        <div class="form-group row">
                                            <label  class="col-lg-4">
                                                <h6><% out.println(bundle.getString("qui"));%> ?</h6>
                                            </label>
                                            <div class="col-lg-8">
                                                <input name="who" type="text" class="w3-input w3-border w3-round " placeholder="a détecté le probléme ?" required>
                                            </div>
                                        </div>
                                        <!--================================-->
                                        <div class="form-group row">
                                            <label  class="col-lg-4">
                                                <h6><% out.println(bundle.getString("comment"));%> ?</h6>
                                            </label>
                                            <div class="col-lg-8">
                                                <input name="how" type="text" class="w3-input w3-border w3-round " placeholder="a-t-il eté détecté ?" required> 
                                            </div>
                                        </div>
                                        <!--================================-->
                                        <div class="form-group row">
                                            <label  class="col-lg-4">
                                                <h6><% out.println(bundle.getString("combien"));%> ?</h6>
                                            </label>
                                            <div class="col-lg-8">
                                                <input name="how_match" type="number" class="w3-input w3-border w3-round " placeholder="de défauts? Pertes?" required>
                                            </div>
                                        </div>
                                        <!--================================-->
                                        <div class="form-group row">
                                            <label  class="col-lg-4">
                                                <h6><% out.println(bundle.getString("pourquoi"));%> ?</h6>
                                            </label>
                                            <div class="col-lg-8">
                                                <input name="why" type="text" class="w3-input w3-border w3-round " placeholder="est-ce un probléme ?" required>
                                            </div>
                                        </div>
                                        <!--================================-->
                                        <div class="form-group row">
                                            <label  class="col-lg-4">
                                                <h6><% out.println(bundle.getString("quoi"));%> ?</h6>
                                            </label>
                                            <div class="col-lg-8">
                                                <input name="what" type="text" class="w3-input w3-border w3-round " placeholder="est-ce un probléme ?" required>
                                            </div>
                                        </div>
                                        <!--#######################################-->
                                    </div>

                                    <div class="col-lg-3 ">
                                        <!--#######################################-->
                                        <div class="col-md-12">
                                            <p class="text-danger"><b><% out.println(bundle.getString("mauvaise.piece"));%></b></p>
                                            <div class="fileinput fileinput-new text-center" data-provides="fileinput">
                                                <div class="fileinput-new thumbnail">
                                                    <img src="<%=application.getContextPath()%>/assets/img/choose_file.jpg" alt="...">
                                                </div>
                                                <div class="fileinput-preview fileinput-exists thumbnail"></div>
                                                <div>
                                                    <span class="w3-btn w3-light-gray w3-round w3-border btn-file" style="border-radius: 5px">
                                                        <span class="fileinput-new">Select image</span>
                                                        <span class="fileinput-exists">Change</span>
                                                        <input name="bad_piece" type="file" accept="image/*" required/>
                                                    </span>
                                                    <a style="border-radius: 5px" href="#pablo" class="w3-btn w3-light-gray w3-round w3-border fileinput-exists" data-dismiss="fileinput"><i class="fa fa-filltimes"></i> Remove</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <p class="text-success"><b><% out.println(bundle.getString("bonne.piece"));%></b></p>
                                            <div class="fileinput fileinput-new text-center" data-provides="fileinput">
                                                <div class="fileinput-new thumbnail">
                                                    <img src="<%=application.getContextPath()%>/assets/img/choose_file.jpg" alt="...">
                                                </div>
                                                <div class="fileinput-preview fileinput-exists thumbnail"></div>
                                                <div>
                                                    <span style="border-radius: 5px"  class="w3-btn w3-light-gray w3-round w3-border btn-file ">
                                                        <span class="fileinput-new">Select image</span>
                                                        <span class="fileinput-exists">Change</span>
                                                        <input name="good_piece" type="file" required accept="image/*"/>
                                                    </span>
                                                    <a style="border-radius: 5px" href="#pablo" class="w3-btn w3-light-gray w3-round w3-border fileinput-exists" data-dismiss="fileinput"><i class="fa fa-btn-filltimes"></i> Remove</a>
                                                </div>
                                            </div>
                                        </div>

                                        <!--#######################################-->
                                    </div>

                                    <div class="col-lg-2" >
                                        <div class="col">
                                            <div class="form-group">
                                                <div class="form-check">
                                                    <p class="card-title"><b><% out.println(bundle.getString("type.de.probleme"));%></b></p>
                                                </div>
                                            </div>
                                        </div>
                                        <!--#######################################-->
                                        <div class="col ">
                                            <div class="radio">
                                                <input type="radio" name="type_problem" id="radio1" value="securite" checked>
                                                <label for="radio1">
                                                    <% out.println(bundle.getString("securite"));%>
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <input  type="radio" name="type_problem" id="radio2" value="qualite">
                                                <label for="radio2">
                                                    <% out.println(bundle.getString("qualite"));%>
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <input type="radio" name="type_problem" id="radio3" value="kosu">
                                                <label for="radio3">
                                                    <% out.println(bundle.getString("kosu"));%>
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <input type="radio" name="type_problem" id="radio4" value="maintenance">
                                                <label for="radio4">
                                                    <% out.println(bundle.getString("maintenance"));%>
                                                </label>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="col">
                                            <div class="form-group">

                                                <div class="col-md-12">
                                                    <div class="form-check">
                                                        <p class="card-title"><b><% out.println(bundle.getString("respect.du.standard"));%></b></p>
                                                        <input name="respect_standard" type="checkbox" class="switch-icon " checked>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                        <!--#######################################-->
                                    </div>
                                    <div class="col-lg-2">
                                        <!--#######################################-->
                                        <div class="col ">
                                            <div class="form-group">
                                                <div class="form-check">
                                                    <p class="card-title"><b> <% out.println(bundle.getString("qui.doit.etre.alerte"));%></b></p>
                                                </div>
                                            </div>
                                        </div>
                                        <!--#######################################-->
                                        <div class="col">

                                            <div class="checkbox">
                                                <input name="shouldAlert1" id="checkbox2" type="checkbox">
                                                <label for="checkbox2">
                                                    <% out.println(bundle.getString("superviseur"));%>
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <input name="shouldAlert2" id="checkbox3" type="checkbox">
                                                <label for="checkbox3">
                                                    <% out.println(bundle.getString("securite"));%>
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <input name="shouldAlert3" id="checkbox4" type="checkbox">
                                                <label for="checkbox4">
                                                    <% out.println(bundle.getString("maintenance"));%>
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <input name="shouldAlert4" id="checkbox5" type="checkbox">
                                                <label for="checkbox5">
                                                    Qualité UAP
                                                </label>
                                            </div>

                                            <div class="checkbox">
                                                <input name="shouldAlert5" id="checkbox7" type="checkbox">
                                                <label for="checkbox7">
                                                    Train d'Appro
                                                </label>
                                            </div>
                                            <select class="selectpicker" data-style=" w3-border w3-border-gray w3-round w3-input" multiple title="Choose City" data-size="7">
                                                <%  List<TypeUser> listTypeUser = new DaoTypeUser().findAll();
                                                    for (TypeUser typeUser : listTypeUser) {
                                                        String value = typeUser.getName();
                                                %>
                                                <option class="" draggable value="<%=typeUser.getId()%>"><%=value%></option>   
                                                <%}%>
                                            </select>

                                        </div>
                                        <!--#######################################-->
                                        <div class="col ">
                                            <div class="form-group">
                                                <div class="form-check">
                                                    <p class="card-title"><b> <% out.println(bundle.getString("qui.peut.etre.alerte"));%></b></p>
                                                </div>
                                            </div>
                                        </div>
                                        <!--#######################################-->
                                        <div class="col">

                                            <div class="checkbox">
                                                <input name="canAlert1" id="checkbox6" type="checkbox">
                                                <label for="checkbox6">
                                                    Qualité Fournisseur
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <input name="canAlert2" id="checkbox8" type="checkbox">
                                                <label for="checkbox8">
                                                    <% out.println(bundle.getString("logistique"));%>
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <input name="canAlert3" id="checkbox9" type="checkbox">
                                                <label for="checkbox9">
                                                    Resp UAP
                                                </label>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-lg-12   ">
                                        <div class="form-group">
                                            <button style="border-radius: 5px" type="submit" class="w3-btn w3-light-gray w3-round w3-border">Suivant</button>
                                            <button style="border-radius: 5px" type="reset" class="w3-btn w3-light-gray w3-round w3-border"><% out.println(bundle.getString("annuler"));%></button>

                                        </div>


                                    </div>
                                </div> 
                            </form>
                        </div>




                    </div>
                </div>


            </div>
        </div>
    </div> 
</div> 
<%
    }
%>

