

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
    List<Step1SecurityPlan> listStep1SecurityPlan = step1.getStep1SecurityPlanList();
    List<Step1ActionFollowed> listStep1ActionFollowed = step1.getStep1ActionFollowedList();
    //List<Step1Why> listStep1Why = step1.getSte
    List<Step1AlertCan> listStep1AlertCan = step1.getStep1AlertCanList();
    List<Step1AlertShould> listStep1AlertShould = step1.getStep1AlertShouldList();
    ResourceBundle bundle = (ResourceBundle) session.getAttribute("bundle");


%>



<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">

                <div class="card w3-border w3-border-gray">
                    <div class="card-content ">  


                        <div class="<%=Design.containerTitle%>">
                            <div class="w3-left">
                                <h4  style="color: <%=typeProblem.getColor()%>"  class="w3-xlarge"> <%=typeProblem.getName()%></h4>
                            </div>
                            <div class="w3-right">
                                <button  onclick="document.location.href = 'Problem?id=<%=problem.getId()%>'" type="button" class="<%=Design.btn%> ti-back-right w3-margin"> 
                                </button>
                            </div>

                        </div>
                        <br>
                        <div class="w3-round w3-light-gray w3-padding">
                            <div class="row w3-padding-small">

                                <div class="col-lg-1 w3-padding-small">
                                    <%if (user.getPicture().equals("")) {%>
                                    <img src="<%=application.getContextPath()%>/img/profile/user.png" alt="...">
                                    <%} else {%> 
                                    <img width="50px" height="50px" class="photo w3-image w3-circle" src="<%=application.getContextPath()%>/img/profile/<%=user.getPicture()%>" alt="...">
                                    <%}%> 
                                </div>
                                <div class="col-lg-2 ">
                                    <p class="w3-large w3-borderd w3-white w3-round-large w3-padding-small">Probléme </b></p>
                                </div>
                                <div class="col-lg-3 ">
                                    <p class="w3-large w3-borderd w3-white w3-round-large w3-padding-small">Niveau E: <%=problem.getIdUser().getIdLevel0().getName()%></p>
                                </div>
                                <div class="col-lg-3 ">
                                    <p class="w3-large w3-borderd w3-white w3-round-large w3-padding-small">Niveau 1: <%=problem.getIdLevel1().getName()%></p>
                                </div>
                                <div class="col-lg-3">
                                    <p class="w3-large w3-borderd w3-white w3-round-large w3-padding-small">Code : <%=problem.getCode()%></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>



                <div class="card w3-border w3-border-gray">
                    <div class="card-content "> 




                        <div class="<%=Design.containerTitle%>">
                            <h2 class="<%=Design.textTitle%>">Caractérisation</h2>
                        </div>
                        <div class="<%=Design.container%>">
                            <br>
                            <form  action="<%=application.getContextPath()%>/UpdateS1P1?id=<%=problem.getId()%>"  method="post"  enctype="multipart/form-data" >

                                <div class="row">
                                    <div class="col-lg-5">
                                        <!--#######################################-->
                                        <!--================================-->
                                        <div class="form-group">
                                            <input  name="reference" type="text" class="w3-input w3-border w3-border-grey w3-white form-control" value="<%=problem.getReference()%>" required1>
                                        </div 


                                        <!--================================-->
                                        <div class="form-group row">
                                            <label  class="col-lg-4">
                                                <h6>Que s'est t'il passé&nbsp;?</h6>
                                            </label>
                                            <div class="col-lg-8">
                                                <input name="what" type="text" class="w3-input w3-border w3-round " value="<%=step1.getWhat()%>" required1>
                                            </div>
                                        </div>
                                        <!--================================-->
                                        <div class="form-group row">
                                            <label  class="col-lg-4">
                                                <h6><%=bundle.getString("quand")%> ?</h6>
                                            </label>
                                            <div class="col-lg-8">
                                                <input name="when" type="text" class="w3-input w3-border w3-round datetimepicker" value="<%=step1.getWhen()%>" required1>
                                            </div>
                                        </div>
                                        <!--================================-->
                                        <div class="form-group row">
                                            <label  class="col-lg-4">
                                                <h6><%=bundle.getString("ou")%> ?</h6>
                                            </label>
                                            <div class="col-lg-8">
                                                <input name="where" type="text" class="w3-input w3-border w3-round  " value="<%=step1.getWhere()%>" required1>
                                            </div>
                                        </div>
                                        <!--================================-->
                                        <div class="form-group row">
                                            <label  class="col-lg-4">
                                                <h6><%=bundle.getString("qui")%> ?</h6>
                                            </label>
                                            <div class="col-lg-8">
                                                <input name="who" type="text" class="w3-input w3-border w3-round " value="<%=step1.getWho()%>" required1>
                                            </div>
                                        </div>
                                        <!--================================-->
                                        <div class="form-group row">
                                            <label  class="col-lg-4">
                                                <h6><%=bundle.getString("comment")%> ?</h6>
                                            </label>
                                            <div class="col-lg-8">
                                                <input name="how" type="text" class="w3-input w3-border w3-round " value="<%=step1.getHow()%>" required1> 
                                            </div>
                                        </div>
                                        <!--================================-->
                                        <div class="form-group row">
                                            <label  class="col-lg-4">
                                                <h6><%=bundle.getString("combien")%> ?</h6>
                                            </label>
                                            <div class="col-lg-8">
                                                <input name="how_match" type="number" class="w3-input w3-border w3-round " value="<%=step1.getHowMutch()%>" required1>
                                            </div>
                                        </div>
                                        <!--================================-->
                                        <div class="form-group row">
                                            <label  class="col-lg-4">
                                                <h6><%=bundle.getString("pourquoi")%> ?</h6>
                                            </label>
                                            <div class="col-lg-8">
                                                <input name="why" type="text" class="w3-input w3-border w3-round " value="<%=step1.getWhy()%>" required1>
                                            </div>
                                        </div>
                                        <hr>
                                        <!--#######################################-->
                                        <div class="form-group row">
                                            <div class="col">
                                                <div class="<%=Design.container%> w3-padding1">
                                                    <div class="form-check">
                                                        <div class="w3-left">
                                                            <span class="<%=Design.textNormal%>">Respect du standard</span>
                                                        </div>
                                                        <div class="w3-right">
                                                            <%if (step1.getRespectStandard()) {%>
                                                            <input name="respect_standard" type="checkbox" class="switch-icon" checked>
                                                            <%} else {%>
                                                            <input name="respect_standard" type="checkbox" class="switch-icon" >
                                                            <%}%>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <br>
                                            <div class="col">
                                                <div class="<%=Design.container%> w3-padding1">
                                                    <div class="form-check">
                                                        <div class="w3-left">
                                                            <span class="<%=Design.textNormal%>">Problème récurrent</span>
                                                        </div>
                                                        <div class="w3-right">
                                                            <%if (step1.getRecognizedProblem()) {%>
                                                            <input name="probleme_recurrent" type="checkbox" class="switch-icon" checked>
                                                            <%} else {%>
                                                            <input name="probleme_recurrent" type="checkbox" class="switch-icon" >
                                                            <%}%>

                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <br> 


                                        </div>

                                        <!--#######################################-->
                                    </div>

                                    <div class="col-lg-4 ">
                                        <!--#######################################-->
                                        <div class="col-lg-12">

                                            <div class="<%=Design.containerTitle%>">
                                                <h3 class="<%=Design.textNormal%> w3-text-pink">PIECE MAUVAISE</h3>
                                            </div>
                                            <div class="w3-container w3-white w3-margin-bottom">
                                                <br>
                                                <div class="fileinput fileinput-new text-center" data-provides="fileinput">
                                                    <div class="fileinput-new thumbnail">
                                                        <img src="<%=application.getContextPath()%>/upload/<%=step1.getBadPiece()%>" alt="...">
                                                    </div>
                                                    <div class="fileinput-preview fileinput-exists thumbnail"></div>
                                                    <div>
                                                        <span class="w3-btn w3-light-gray w3-round w3-border btn-file" style="border-radius: 5px">
                                                            <span class="fileinput-new">Select image</span>
                                                            <span class="fileinput-exists">Change</span>
                                                            <input name="bad_piece" type="file" accept="image/*" />
                                                        </span>
                                                        <a style="border-radius: 5px" href="#pablo" class="w3-btn w3-light-gray w3-round w3-border fileinput-exists" data-dismiss="fileinput"><i class="fa fa-filltimes"></i> Remove</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>


                                        <div class="col-lg-12">

                                            <div class="<%=Design.containerTitle%>">
                                                <h3 class="<%=Design.textNormal%> w3-text-green">PIECE BONNE </h3>
                                            </div>
                                            <div class="w3-container w3-white w3-margin-bottom">
                                                <br>
                                                <div class="fileinput fileinput-new text-center" data-provides="fileinput">
                                                    <div class="fileinput-new thumbnail">
                                                        <img src="<%=application.getContextPath()%>/upload/<%=step1.getGoodPiece()%>" alt="...">
                                                    </div>
                                                    <div class="fileinput-preview fileinput-exists thumbnail"></div>
                                                    <div>
                                                        <span style="border-radius: 5px"  class="w3-btn w3-light-gray w3-round w3-border btn-file ">
                                                            <span class="fileinput-new">Select image</span>
                                                            <span class="fileinput-exists">Change</span>
                                                            <input name="good_piece" type="file" accept="image/*"/>
                                                        </span>
                                                        <a style="border-radius: 5px" href="#pablo" class="w3-btn w3-light-gray w3-round w3-border fileinput-exists" data-dismiss="fileinput"><i class="fa fa-btn-filltimes"></i> Remove</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <!--#######################################-->
                                    </div>

                                    <div class="col-lg-3" >
                                        <div class="col">
                                            <div class="<%=Design.containerTitle%>">
                                                <h3 class="<%=Design.textTitle%>">Type de probleme</h3>
                                            </div>
                                        </div>
                                        <!--#######################################-->
                                        <div class="col ">

                                            <%  List<TypeProblem> listTypeProblem = ServiceTypeProblem.findAll();
                                                for (TypeProblem tp : listTypeProblem) {
                                                    String value = tp.getName();
                                                    if (tp.equals(typeProblem)) {
                                            %>
                                            <div class="radio">
                                                <input type="radio" name="type_problem" id="radio<%=tp.getId()%>" value="<%=tp.getId()%>"  checked>
                                                <label for="radio<%=tp.getId()%>">
                                                    <%=value%>
                                                </label>
                                            </div>
                                            <%} else {%>
                                            <div class="radio">
                                                <input type="radio" name="type_problem" id="radio<%=tp.getId()%>" value="<%=tp.getId()%>"  >
                                                <label for="radio<%=tp.getId()%>">
                                                    <%=value%>
                                                </label>
                                            </div>
                                            <%}
                                                }%>
                                        </div>


                                        <!--#######################################-->
                                    </div>

                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-lg-12   ">
                                        <div class="form-group">
                                            <button style="border-radius: 5px" type="submit" class="<%=Design.btn%> ti-save" name="S1P1"></button>
                                            <button style="border-radius: 5px" type="reset" class="<%=Design.btn%> ti-back-left"></button>
                                        </div>
                                    </div>
                                </div> 
                            </form>
                        </div>
                    </div>
                </div>



                <div class="card w3-border w3-border-gray">
                    <div class="card-content ">  
                        <div class="<%=Design.containerTitle%>">
                            <h2 class="<%=Design.textTitle%>" >Actions immédiates </h2>
                            <small>Que doit-on faire tout de suite pour sécuriser et redémarrer?</small>
                        </div>
                        <div class="<%=Design.container%>">
                            <div class="row">

                                <div class="col-lg-12">
                                    <br> <br>
                                    <!-- Button trigger modal -->
                                    <% if (listStep1SecurityPlan != null) {%>
                                    <div class="<%=Design.cadreTable%>">
                                        <div class="<%=Design.containerTitle%>">
                                            <div class="col-xs-5">
                                                <h3 class="<%=Design.textNormal%>">Respecter votre Plan de sécurisation Client</h3>
                                            </div>
                                            <div class="w3-right">
                                                <button data-toggle="modal" data-target="#exampleModal" style="border-radius: 5px;margin:3px;" type="button" class="<%=Design.btn%> ti-plus"></button>
                                            </div>
                                        </div>
                                        <br>
                                        <table  class="<%=Design.table%>" cellspacing="0" width="100%" style="width:100%">
                                            <thead>
                                                <tr class="">
                                                    <th class="" scope="col">#</th>
                                                    <th class="" scope="col">Où ?</th>
                                                    <th class="" scope="col">Qui ?</th>
                                                    <th class="" scope="col">Combien ?</th>
                                                    <th class="" scope="col">Resultat ?</th>
                                                    <th class="" scope="col">Supprimer</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    Step1SecurityPlan securityPlan = null;
                                                    for (int i = 0; i < listStep1SecurityPlan.size(); i++) {
                                                        securityPlan = listStep1SecurityPlan.get(i);

                                                %>

                                                <tr>
                                                    <td><%=(i + 1)%></td>
                                                    <td><%=securityPlan.getWhere()%></td>
                                                    <td><%=securityPlan.getWho()%></td>
                                                    <td><%=securityPlan.getHowMuch()%></td>
                                                    <td><%=securityPlan.getResult()%></td>

                                                    <td>

                                                        <form action="<%=application.getContextPath()%>/UpdateS1P2?id=<%=problem.getId()%>" method="post">
                                                            <input hidden name="hashcode" type="text" value="<%= securityPlan.hashCode()%>">
                                                            <button style="border-radius: 5px" name="removePlan" type="submit"   rel="tooltip" title="" class="<%=Design.btn%> w3-tiny w3-text-red" data-original-title1="Remove">
                                                                <i class="ti-close"></i>
                                                            </button>
                                                        </form>

                                                    </td>
                                                </tr>
                                                <%

                                                    }
                                                %>
                                                <%
                                                    for (int i = listStep1SecurityPlan.size(); i < 3; i++) {
                                                %>
                                                <tr>
                                                    <td><%=(i + 1)%></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>

                                                </tr>

                                                <%
                                                        }
                                                    }

                                                %>
                                            </tbody>
                                        </table>
                                    </div>


                                </div> 
                            </div>

                            <!--======================================================-->
                            <form name="f" action="<%=application.getContextPath()%>/UpdateS1P2?id=<%=problem.getId()%>" method="post">


                                <div class="row">
                                    <br>
                                    <div class="col">
                                        <div class="<%=Design.container%> w3-padding1">
                                            <div class="form-check">
                                                <div class="w3-left">
                                                    <span class="<%=Design.textNormal%>">Validation de redémarrage</span>
                                                </div>
                                                <div class="w3-right">
                                                    <%if (step1.getStartValidation()) {%>
                                                    <input name="start_validation" type="checkbox" class="switch-icon" checked>
                                                    <%} else {%>
                                                    <input name="start_validation" type="checkbox" class="switch-icon" >
                                                    <%}%>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="col">
                                        <div class="<%=Design.container%> w3-padding1">
                                            <div class="form-check">
                                                <div class="w3-left">
                                                    <span class="<%=Design.textNormal%>">Faut-il lancer un Trie ?</span>
                                                </div>
                                                <div class="w3-right">
                                                    <%if (step1.getSort()) {%>
                                                    <input name="sort" type="checkbox" class="switch-icon" checked onchange="changeSortCrit()">
                                                    <%} else {%>
                                                    <input name="sort" type="checkbox" class="switch-icon" onchange="changeSortCrit()">
                                                    <%}%>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <br>

                                <br>
                                <div id="criteria" class="row">
                                    <div class="col-lg-6 col-md-6">
                                        <b class="card-title"> Quel est le critéré de trie: ?</b>
                                    </div>
                                    <div class="col-lg-3 col-md-6">
                                        <input id="sort_criterion" name="sort_criterion" class="w3-input w3-small w3-border w3-round " type="text" value="<%=step1.getSortCriterion()%>"  readonly>
                                    </div>
                                </div>

                                <!--======================================================-->
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <h5 class="">Autre Actions immédiates :</h5>
                                            <textarea name="immediate_actions" class="w3-input w3-border" rows="5" dir="rtl" style="text-align: left;">
                                                <%=step1.getImmediateActions().trim()%>
                                            </textarea>
                                        </div>
                                    </div>
                                    <div class="col-lg-12">
                                        <div class="form-group">
                                            <button style="border-radius: 5px" type="submit" class="<%=Design.btn%> ti-save" name="S1P2"></button>
                                            <button style="border-radius: 5px" type="reset" class="<%=Design.btn%> ti-back-left"></button>

                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <br>
                    </div>
                </div>  

                <div class="card w3-border w3-border-gray">
                    <div class="card-content ">         
                        <div class="<%=Design.containerTitle%>">
                            <h2 class="<%=Design.textTitle%>" >Analyse et actions définitives</h2>
                        </div>
                        <div class="w3-container">
                            <br>
                            <div class="">
                                <div class="row">
                                    <br>
                                    <div class="col-lg-12">
                                        <div class="<%=Design.cadreTable%>">
                                            <table  class="<%=Design.table%>" cellspacing="0" width="100%" style="width:100%">
                                                <thead>
                                                    <tr class="">
                                                        <th  scope="col">Action</th>
                                                        <th  scope="col">Qui</th>
                                                        <th  scope="col">Quand</th>
                                                        <th  scope="col">Commentaire</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <%                                                    for (Step1Action step1Action : listStep1Action) {
                                                    %>
                                                    <tr>

                                                        <td><%=step1Action.getAction()%></td>
                                                        <td><%=step1Action.getWho()%></td>
                                                        <td><%=step1Action.getWhen()%></td>
                                                        <td><%=step1Action.getComment()%></td>

                                                    </tr>

                                                    <%
                                                        }

                                                    %>
                                                </tbody>

                                            </table>
                                        </div>
                                        <br>
                                    </div>
                                </div>
                            </div>
                            <br>
                        </div>




                    </div>
                </div>

            </div>
        </div>

    </div><!--  end card  -->
</div> <!-- end col-md-12 -->
<!-- </div>  end row -->



<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br><br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">Plan de sécurisation Client</h3>
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form method="post" action="<%=application.getContextPath()%>/UpdateS1P2?id=<%=problem.getId()%>">
                        <div class="card-content">
                            <div class="form-group">
                                <label>Où ?</label><star> *</star>
                                <input name="where" type="text" placeholder="" class="<%=Design.inputText%>" required>
                            </div>
                            <div class="form-group">
                                <label>Qui ?</label><star> *</star>
                                <input name="who" type="text" placeholder="" class="<%=Design.inputText%>" required>
                            </div>
                            <div class="form-group">
                                <label>Combien ?</label><star> *</star>
                                <input  name="n1" type="number" class="<%=Design.inputText%>" required>

                            </div>
                            <div class="form-group">
                                <label>Resultat (par défaut)</label>
                                <input readonly value="0" name="n2" type="number" class="<%=Design.inputText%> w3-light-gray w3-text-gray" required>

                            </div>
                            <div class="form-group">
                                <button name="AddPlan" style="border-radius: 5px" type="submit" class="<%=Design.btn%>">Ajouter</button>
                                <button style="border-radius: 5px" type="reset" class="<%=Design.btn%>">Annuler</button>
                            </div>
                        </div>
                    </form>
                    <br>
                </div>




            </div>
        </div>
    </div>
</div>


<script>
    function changeSortCrit()
    {
        var sc = document.f.sort_criterion;
        if (document.f.sort.checked)
        {
            sc.readOnly = false;
            document.getElementById("criteria").classList.remove('hide');

        } else {
            sc.readOnly = true;
            document.getElementById("criteria").classList.add('hide');
            document.getElementById("sort_criterion").value = "";
        }

    }
</script>