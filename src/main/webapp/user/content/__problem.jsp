

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="entity.*"%>
<%@page import="service.*"%>


<%@page import="domaine.Design"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
    //List<Step1> listStep1 = new ArrayList<Step1>();
    User userContent = (User) session.getAttribute("user");
    String id_problem = request.getParameter("id");
    Problem problem = ServiceProblem.find(Integer.parseInt(id_problem));
    TypeProblem typeProblem = problem.getIdTypeProblem();
    Step1 step1 = problem.getIdStep1();
    User user = problem.getIdUser();
    List<Step1Action> listStep1Action = step1.getStep1ActionList();
    List<Step1Why> listStep1Why = step1.getStep1WhyList();
    List<Step1SecurityPlan> listStep1SecurityPlan = step1.getStep1SecurityPlanList();
    List<Step1ActionFollowed> listStep1ActionFollowed = step1.getStep1ActionFollowedList();
    List<Step1AlertCan> listStep1AlertCan = step1.getStep1AlertCanList();
    List<Step1AlertShould> listStep1AlertShould = step1.getStep1AlertShouldList();
    List<Step1Comment> listStep1Comment = step1.getStep1CommentList();


%>



<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">

            <br> 
            <div class="w3-bar w3-dark-gray w3-border-bottom w3-padding w3-round">
                <div class="w3-row">
                    <!--=============================================================-->  
                    <div class="w3-col l12">
                        <div class="ui labeled button w3-margin-bottom1" tabindex="0" style="margin: 5px;">
                            <div class="ui green button">
                                <i data-toggle="modal" data-target="#Step1ViewListUser"  class="fa fa-eye"></i> vue
                            </div>
                            <a class="ui basic grey left pointing label">
                                <span class="w3-small"><%=problem.getIdStep1().getStep1ViewList().size()%></span>
                            </a>
                        </div>
                        <div class=" ui labeled button" tabindex="0" style="margin: 5px;">
                            <div class="ui green button">
                                Status
                            </div>
                            <a class="ui basic grey left pointing label">
                                <span class="w3-small"><%=problem.getStatus()%></span>
                            </a>
                        </div>
                        <div class="ui labeled button" tabindex="0" style="margin: 5px;">
                            <div class="ui green button">
                                Code
                            </div>
                            <a class="ui basic grey left pointing label">
                                <span class="w3-small"><%=problem.getCode()%></span>
                            </a>
                        </div>
                        <div class="ui labeled button" tabindex="0" style="margin: 5px;">
                            <div class="ui green button">
                                <i class="fa fa-user"></i>  
                            </div>
                            <a class="ui basic grey left pointing label">
                                <span class="w3-small"><%=problem.getIdUser().getName() + " " + problem.getIdUser().getFirstName()%></span>
                            </a>
                        </div>
                        <div class="ui labeled button" tabindex="0" style="margin: 5px;">
                            <div class="ui green button">
                                <i class="ti-alert"></i>  
                            </div>
                            <a class="ui basic grey left pointing label">
                                <span  class="w3-small" style="color: <%=typeProblem.getColor()%>"><%=problem.getIdTypeProblem().getName()%></span>
                            </a>
                        </div>
                    </div>       
                </div>
            </div>




            <br>
            <div class="w3-bar w3-dark-gray w3-round">
                <a href="#caracterisation" class="w3-bar-item w3-button">Caractérisation</a>
                <a href="#actionsimmediate" class="w3-bar-item w3-button">Actions immédiates</a>
                <a href="#5pourquoi" class="w3-bar-item w3-button">5 Pourquoi</a>
                <a href="#actions" class="w3-bar-item w3-button">Actions</a>
                <a href="#suivi" class="w3-bar-item w3-button">Suivi</a>
                <a href="#commentaires" class="w3-bar-item w3-button">Commentaires</a>
                <a href="ProblemPdf?id=<%=problem.getId()%>" class="w3-bar-item w3-button w3-right w3-hover-pink w3-hover-text-white    w3-red w3-text-white">
                    <i class=" w3-hover-text-white fa fa-file-pdf-o "></i>
                </a>
            </div>
            <br>

            <a name="caracterisation"></a>
            <div  class="w3-container w3-light-blue w3-padding-small w3-round w3-border-0  w3-margin-bottom">
                <div class="w3-left">
                    <p class="w3-large">Caractérisation</p>
                </div>
                <div class="w3-right">
                    <button  onclick="document.location.href = 'S1P1?id=<%=problem.getId()%>'" type="button" class="<%=Design.btn%>  ti-pencil-alt w3-text-dark-gray btn btn-lg btn-icon"> 
                    </button>
                </div>
            </div>
            <div  class="w3-container w3-padding-small w3-white">

                <div class="w3-row">
                    <div class="w3-col l12">
                        <br>
                        <h1 class="ui red ribbon label">Caractérisation</h1>
                        <br> <br> 
                    </div>

                </div>
                <div class="w3-row">

                    <div class="w3-col l5">
                        <!--#######################################-->
                        <table class="<%=Design.table%>">
                            <tr>
                                <th>Réference</th>
                                <td> <%=problem.getReference()%></td>
                            </tr>
                            <tr>
                                <th>Que s'est t'il passé&nbsp;?</th>
                                <td> <%=step1.getWhat()%></td>
                            </tr>
                            <tr>
                                <th>Quand&nbsp;?</th>
                                <td><%=step1.getWhen()%></td>
                            </tr>
                            <tr>
                                <th>Où&nbsp;?</th>
                                <td><%=step1.getWho()%></td>
                            </tr>
                            <tr>
                                <th>Qui&nbsp;?</th>
                                <td><%=step1.getWho()%></td>
                            </tr>
                            <tr>
                                <th>Comment&nbsp;?</th>
                                <td><%=step1.getHow()%></td>
                            </tr>
                            <tr>
                                <th>Combien&nbsp;?</th>
                                <td> <%=step1.getHowMutch()%></td>
                            </tr>
                            <tr>
                                <th>Pourquoi&nbsp;?</th>
                                <td> <%=step1.getWhy()%></td>
                            </tr>

                        </table>
                        <br>




                        <div class="w3-container w3-margin-bottom w3-light-gray w3-padding w3-round">
                            <span class=" w3-left">Respect du standard</span>
                            <%if (step1.getRespectStandard()) {%>
                            <span class="w3-text-green ti-check w3-right"></span>
                            <%} else {%>
                            <span class="w3-text-red ti-close w3-right"></span>
                            <%}%>
                        </div>
                        <div class="w3-container w3-margin-bottom w3-light-gray w3-padding w3-round">
                            <span class=" w3-left">Probléme recurrent</span>
                            <%if (step1.getRecognizedProblem()) {%>
                            <span class="w3-text-green ti-check w3-right"></span>
                            <%} else {%>
                            <span class="w3-text-red ti-close w3-right"></span>
                            <%}%>
                        </div>

                        <!--#######################################-->
                    </div>

                    <div class="w3-col l3">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="<%=Design.containerTitle%> w3-padding-small w3-margin-bottom">
                                    <p class="<%=Design.textTitle%> w3-text-pink">PIECE MAUVAISE</p>
                                </div>
                                <div class="<%=Design.container%> w3-margin-bottom">
                                    <br>
                                    <div class="fileinput fileinput-new text-center" data-provides="fileinput">
                                        <div class="fileinput-new">
                                            <img class="w3-round" src="<%=application.getContextPath()%>/upload/<%=step1.getBadPiece()%>" alt="...">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="<%=Design.containerTitle%> w3-padding-small w3-margin-bottom">
                                    <p class="<%=Design.textTitle%> w3-text-green">PIECE BONNE </p>
                                </div>
                                <div class="<%=Design.container%> w3-margin-bottom">
                                    <br>
                                    <div class="fileinput fileinput-new text-center" data-provides="fileinput">
                                        <div class="fileinput-new">
                                            <img class="w3-round" src="<%=application.getContextPath()%>/upload/<%=step1.getGoodPiece()%>" alt="...">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="w3-col l4">
                        <!--#######################################-->
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="<%=Design.containerTitle%>">
                                    <h3 class="<%=Design.textNormal%>">Qui doit être Alerté <span class="w3-badge w3-round w3-pink"> <%=listStep1AlertShould.size()%></span></h3>
                                </div>
                                <ul class="w3-ul w3-bordedr w3-white">
                                    <%
                                        for (Step1AlertShould step1AlertShould : listStep1AlertShould) {
                                    %>
                                    <li>
                                        <%=step1AlertShould.getIdTypeUser().getName()%>
                                    </li>
                                    <%
                                        }
                                    %>
                                </ul> 
                            </div>

                            <div class="col-lg-12">
                                <br>
                                <div class="<%=Design.containerTitle%>">
                                    <h3 class="<%=Design.textNormal%>">Qui peut être Alerté <span class="w3-badge w3-round w3-pink"> <%=listStep1AlertCan.size()%></span></h3>
                                </div>
                                <ul class="w3-ul w3-borderd w3-white">
                                    <%
                                        for (Step1AlertCan step1AlertCan : listStep1AlertCan) {
                                    %>
                                    <li>
                                        <%=step1AlertCan.getIdTypeUser().getName()%>
                                    </li>
                                    <%
                                        }
                                    %>
                                </ul> 
                            </div>


                        </div>
                        <!--#######################################-->

                    </div>

                </div>

            </div>

            <a name="actionsimmediate"></a>
            <div class="card w3-border w3-border-gray">
                <div class="card-content ">  
                    <div class="<%=Design.containerTitle%>  w3-padding-small">

                        <div class="w3-left">
                            <h2 class="<%=Design.textTitle%>" >Actions immédiates </h2>
                        </div>
                        <div class="w3-right">
                            <button  onclick="document.location.href = 'S1P2?id=<%=problem.getId()%>'" type="button" class="<%=Design.btn%> ti-pencil-alt w3-text-dark-gray btn btn-lg btn-icon"> 
                            </button>
                        </div>
                    </div>
                    <div class="w3-container ">
                        <div class="row">
                            <br>
                            <br>
                            <div class="w3-container w3-margin w3-light-gray w3-padding w3-round">
                                <span class=" w3-left">Lancer un tri</span>
                                <%if (step1.getSort()) {%>
                                <span class="w3-text-green ti-check w3-right"></span>
                                <%} else {%>
                                <span class="w3-text-red ti-close w3-right"></span>
                                <%}%>
                            </div>
                            <div class="w3-container w3-margin w3-light-gray w3-padding w3-round">
                                <span class=" w3-left">Validation de redémarrage</span>
                                <%if (step1.getStartValidation()) {%>
                                <span class="w3-text-green ti-check w3-right"></span>
                                <%} else {%>
                                <span class="w3-text-red ti-close w3-right"></span>
                                <%}%>
                            </div>
                            <div class="w3-container w3-margin  w3-padding w3-round">
                                <a href="#"><i><u>Voir le rapport de tri</u></i></a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="<%=Design.containerTitle%> w3-margin-bottom1">
                                    <h3 class="<%=Design.textNormal%>">Quel est le critéré de tri</h3>
                                </div>
                                <div class="w3-container w3-margin-bottom w3-padding w3-border1 w3-round1">
                                    <p class="<%=Design.textNormal%>"><%=step1.getSortCriterion()%></p>
                                </div>
                                <div class="<%=Design.containerTitle%> w3-margin-bottom1">
                                    <h3 class="<%=Design.textNormal%>">Autre Actions immédiates </h3>
                                </div>
                                <div class="w3-container w3-margin-bottom w3-padding w3-border1 w3-round1">
                                    <p class="<%=Design.textNormal%>"><%=step1.getImmediateActions()%></p>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="<%=Design.containerTitle%> w3-margin-bottom">
                                    <h3 class="<%=Design.textNormal%>">Plan de securité</h3>
                                </div>
                                <table  class="<%=Design.table%>" cellspacing="0" width="100%" style="width:100%">
                                    <thead>
                                        <tr class="">
                                            <th  scope="col">Où</th>
                                            <th  scope="col">Qui</th>
                                            <th  scope="col">Combien</th>
                                            <th  scope="col">Resultat</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for (Step1SecurityPlan step1SecurityPlan : listStep1SecurityPlan) {
                                        %>

                                        <tr>
                                            <td ><%=step1SecurityPlan.getWhere()%></td>
                                            <td><%=step1SecurityPlan.getWho()%></td>
                                            <td><%=step1SecurityPlan.getHowMuch()%></td>
                                            <td><%=step1SecurityPlan.getResult()%></td>

                                        </tr>
                                        <%
                                            }

                                        %>
                                    </tbody>

                                </table>

                            </div>
                        </div>
                        <br>
                    </div>
                    <br>
                </div>
            </div>  

            <a name="5pourquoi"></a>                        
            <div class="card w3-border w3-border-gray">
                <div class="card-content ">   
                    <div class="<%=Design.containerTitle%>">
                        <h2 class="<%=Design.textTitle%>" >Analyse et actions définitives</h2>
                    </div>
                    <br>
                    <br>
                    <div class="<%=Design.containerTitle%>">
                        <div class="w3-left">
                            <h2 class="<%=Design.textNormal%>">5 pourquoi : <%=step1.getWhat()%></h2>
                        </div>
                        <div class="w3-right">
                            <button data-toggle="modal" data-target="#addWhy" style="border-radius: 5px;margin:3px;" name="addWhy" type="button" class="<%=Design.btn%> w3-hover-white ti-plus"> 
                            </button>
                        </div>
                        <div class=" w3-right">
                            <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                        _deleteAllStep1Why();
                                        return true;
                                    } else {
                                        return false;
                                    }" style="border-radius: 5px;margin:3px;" name="destroyAll" type="submit" class="<%=Design.btn%> w3-hover-white ti-trash"> 
                            </button>
                        </div>

                    </div>
                    <div class="<%=Design.container%>">
                        <br>
                        <div id="why">
                        </div>
                        <br>
                    </div>





                    <a name="actions"></a>  
                    <div class="<%=Design.containerTitle%>">
                        <div class="w3-left">
                            <h2 class="<%=Design.textNormal%>">Actions</h2>
                        </div>
                        <div class="w3-right">
                            <button data-toggle="modal" data-target="#addAction" type="button" class="<%=Design.btn%> w3-hover-white ti-plus"> 
                            </button>
                        </div>
                        <div class=" w3-right">
                            <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                        _deleteAllStep1Action();
                                        return true;
                                    } else {
                                        return false;
                                    }" style="border-radius: 5px;margin:3px;" name="destroyAll" type="button" class="<%=Design.btn%> w3-hover-white ti-trash"> 
                            </button>
                        </div>

                    </div>
                    <div class="<%=Design.container%>">
                        <br>
                        <div id="actions">
                        </div>
                        <br>
                    </div>






                    <a name="suivi"></a>    
                    <div class="<%=Design.containerTitle%>">
                        <h2 class="<%=Design.textNormal%>" >Suivi des equipes </h2>
                    </div>
                    <br>
                    <div class="<%=Design.container%>">
                        <br>
                        <div class="<%=Design.cadreTable%>">
                            <table class="<%=Design.table%>" cellspacing="0" width="100%" style="width:100%">
                                <thead>
                                    <tr class="w3-light-gray w3-text-dark-gray">
                                        <th>ID</th>
                                        <th>Equipe</th>
                                        <th>Rang d'equipe</th>
                                        <th>Start Time</th>
                                        <th>End Time</th>
                                        <th>Efficace</th>
                                        <th>Date</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% List<Step1ActionFollowed> ListStep1ActionFollowed = step1.getStep1ActionFollowedList(); %>
                                    <%  boolean first = true;
                                        for (int i = 0; i < ListStep1ActionFollowed.size(); i++) {
                                            Step1ActionFollowed step1ActionFollowed = ListStep1ActionFollowed.get(i);
                                            Level0 l0 = step1ActionFollowed.getIdLevel0();
                                            boolean efficace = step1ActionFollowed.getEffective();
                                            boolean toBeFollowed = step1ActionFollowed.getToBeFollowed();

                                            DateFormat sdf = new SimpleDateFormat("HH:mm");
                                            Date date = new Date();
                                            RankTeam rk = l0.getIdRankTeam();

                                            if (ServiceRankTeam.getRankTeam(date) != null) {

                                    %>


                                    <%                                            if (toBeFollowed == true) {
                                    %>
                                    <tr>
                                        <td><%=(i + 1)%></td>
                                        <td>
                                            <span class="w3-tag w3-padding w3-round w3-light-green"><%=l0.getName()%></span>
                                        </td>
                                        <td><%=l0.getIdRankTeam().getName()%></td>
                                        <td><%=sdf.format(l0.getIdRankTeam().getStartTime())%></td>
                                        <td><%=sdf.format(l0.getIdRankTeam().getEndTime())%></td>
                                        <td>
                                            <%
                                                if (efficace == true) {
                                            %>
                                            Oui
                                            <%
                                            } else {
                                            %>
                                            Non
                                            <%
                                                }
                                            %>
                                        </td>
                                        <td><%=step1ActionFollowed.getDateCreation()%></td>
                                    </tr>
                                    <%} else {%>

                                    <% if ((!userContent.getIdLevel0().equals(l0)) && ServiceRankTeam.getRankTeam(date).equals(rk) && first == true && ServiceStep1ActionFollowed.getStep1ActionFollowedToBeFollowed(step1) <= (i + 1)) {%>
                                    <tr class="w3-light-gray">
                                        <td>
                                            <i class="fa fa-chevron-circle-right" style="font-size:24px"></i>
                                        </td>
                                        <td>
                                            <span class="w3-tag w3-padding w3-round w3-light-blue"><%=l0.getName()%></span>
                                        </td>
                                        <td><%=l0.getIdRankTeam().getName()%></td>
                                        <td><%=sdf.format(l0.getIdRankTeam().getStartTime())%></td>
                                        <td><%=sdf.format(l0.getIdRankTeam().getEndTime())%></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <% first = false;%>
                                    <% } else if (userContent.getIdLevel0().equals(l0) && ServiceRankTeam.getRankTeam(date).equals(rk) && first == true) {%>
                                    <tr>
                                        <td><i class="fa fa-chevron-circle-right" style="font-size:24px"></i>
                                        </td>
                                        <td>
                                            <span class="w3-tag w3-padding w3-round w3-pink"><%=l0.getName()%></span>
                                        </td>
                                        <td><%=l0.getIdRankTeam().getName()%></td>
                                        <td><%=sdf.format(l0.getIdRankTeam().getStartTime())%></td>
                                        <td><%=sdf.format(l0.getIdRankTeam().getEndTime())%></td>
                                        <td>

                                            <div class="<%=Design.container%> w3-padding1">
                                                <form method="post" action="<%=application.getContextPath()%>/CreateS1P5?id=<%=problem.getId()%>">
                                                    <div class="form-check">
                                                        <div class="w3-left">
                                                            <input hidden style="margin:3px;" name="idStep1ActionFollowed" type="text" class="w3-hide" placeholder="" value="<%=step1ActionFollowed.getId()%>">

                                                            <input name="efficace" type="checkbox" class="switch-icon" checked1>
                                                        </div>
                                                        <div class="w3-right">
                                                            <button style="border-radius: 5px" type="submit" class="<%=Design.btn%> ti-check" name="S1P5"></button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </td>
                                        <td></td>
                                    </tr>
                                    <% first = false;%>
                                    <% } else {%>
                                    <tr>
                                        <td><%=(i + 1)%></td>
                                        <td>
                                            <span class="w3-tag w3-padding w3-round w3-light-blue"><%=l0.getName()%></span>
                                        </td>
                                        <td><%=l0.getIdRankTeam().getName()%></td>
                                        <td><%=sdf.format(l0.getIdRankTeam().getStartTime())%></td>
                                        <td><%=sdf.format(l0.getIdRankTeam().getEndTime())%></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <% } %>



                                    <%}
                                            } else {
                                                out.print("<tr><td>" + date + "  " + ServiceRankTeam.getRankTeam(date).getName() + "</td></tr>");
                                            }
                                        }%>
                                </tbody>
                            </table>
                        </div>
                        <br>
                    </div>

                </div>
            </div>
            <a name="commentaires"></a>                   
            <div class="card w3-border w3-border-gray">
                <div class="card-content ">  
                    <div class="<%=Design.containerTitle%>">
                        <h2 class="<%=Design.textNormal%>">Commentaires</h2>
                    </div>
                    <br>
                    <div class="<%=Design.container%>">
                        <form name="f_comment" action="#" method="post">
                            <div class="row w3-padding-small">

                                <div class="col-lg-1 w3-padding-small w3-left">
                                    <%if (user.getPicture().equals("")) {%>
                                    <img src="<%=application.getContextPath()%>/img/profile/user.png" alt="...">
                                    <%} else {%> 
                                    <img width="50px" height="50px" class="photo w3-image w3-circle" src="<%=application.getContextPath()%>/img/profile/<%=userContent.getPicture()%>" alt="...">
                                    <%}%> 
                                </div>
                                <div class="col-lg-11">
                                    <textarea name="comment" class="w3-input w3-border " rows="3"></textarea>
                                </div>
                            </div>
                            <div class="row">

                                <div class="w3-right">
                                    <div class="form-group">
                                        <button style="border-radius: 5px" type="reset" class="<%=Design.btn%>">ANNULER</button>
                                        <button style="border-radius: 5px" type="button" class="w3-btn w3-round w3-blue" name="addComment" onclick="_addStep1Comment()();">AJOUTER UN COMMENTAIRE</button>
                                    </div>

                                </div>
                            </div>
                        </form>

                        <br>
                        <div class="row" id="comment123">

                        </div>

                    </div>
                </div>

            </div><!--  end card  -->
        </div> <!-- end col-md-12 -->
        <!-- </div>  end row -->
    </div>
</div>




<!-- Modal -->
<div class="modal fade" id="addAction" tabindex="-1" role="dialog" aria-labelledby="addAction" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br><br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">Analyse et actions définitives</h3>
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form name="f_action">
                        <div class="card-content">
                            <div class="form-group">
                                <label>Action ?</label><star> *</star>
                                <input name="action" type="text" placeholder="" class="w3-input w3-border w3-border-grey w3-round" required>
                            </div>
                            <div class="form-group">
                                <label>Qui ?</label><star> *</star>
                                <input name="qui" type="text" placeholder="" class="w3-input w3-border w3-border-grey w3-round" required>
                            </div>
                            <div class="form-group">
                                <label>Quand ?</label><star> *</star>
                                <input name="quand" type="text" placeholder="" class="w3-input w3-border w3-border-grey w3-round datetimepicker" required>
                            </div>
                            <div class="form-group">
                                <label>Commentaire ?</label>
                                <textarea name="commentaire" class="w3-input w3-border w3-border-grey w3-round" placeholder="" rows="2" >
                                            
                                </textarea>
                            </div>

                            <button style="border-radius: 5px" type="button" class="<%=Design.btn%>" onclick="_addStep1Action(action.value, qui.value, quand.value, commentaire.value)" class="close" data-dismiss="modal" aria-label="Close" >Ajouter</button>
                            <button style="border-radius: 5px" type="reset" class="<%=Design.btn%>">Annuler</button>
                        </div>
                    </form>
                    <br>
                </div>
            </div>

        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="addWhy" tabindex="-1" role="dialog" aria-labelledby="addWhy" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br><br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">5 Pourquoi</h3>
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form name="f_why"> 
                        <div class="card-content">
                            <div class="form-group">
                                <label>Pourquoi ?</label><star> *</star>
                                <input name="pourquoi" type="text" placeholder="" class="w3-input w3-border w3-border-grey w3-round" required>
                            </div>
                            <div class="form-group">
                                <label>Commentaire ?</label>
                                <textarea name="commentaire" class="w3-input w3-border w3-border-grey w3-round" placeholder="" rows="2" >         
                                </textarea>
                            </div>

                            <button style="border-radius: 5px" type="button" class="<%=Design.btn%>" onclick="_addStep1Why(pourquoi.value, commentaire.value)" class="close" data-dismiss="modal" aria-label="Close" >Ajouter</button>
                            <button style="border-radius: 5px" type="reset" class="<%=Design.btn%>">Annuler</button>
                        </div>
                    </form>
                    <br>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="Step1ViewListUser" tabindex="-1" role="dialog" aria-labelledby="Step1ViewListUser" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div class="<%=Design.container%>">
                    <br>
                    <% for (Step1View step1View : step1.getStep1ViewList()) { %>
                    <div class="row">
                        <div class="col-lg-3 ">
                            <%if (step1View.getIdUser().getPicture().equals("")) {%>
                            <img width="70px" height="70px"  class="photo w3-image w3-circle w3-margin" src="<%=application.getContextPath()%>/img/profile/user.png" alt="...">
                            <%} else {%> 
                            <img width="70px" height="70px" class="photo w3-image w3-circle w3-margin" src="<%=application.getContextPath()%>/img/profile/<%=step1View.getIdUser().getPicture()%>" alt="...">
                            <%}%> 
                        </div>
                        <div class="col-lg-9" >
                            <div class="w3-left w3-margin">
                                <span class="w3-medium  w3-text-dark-gray">
                                    <%=step1View.getIdUser().getFirstName() + " " + step1View.getIdUser().getName()%>
                                </span>
                                <p class="w3-small  w3-text-green">
                                    <%=step1View.getIdUser().getIdTypeUser().getName()%>
                                </p> 
                            </div>
                            <div class="w3-right w3-margin">
                                <small class="w3-small w3-text-dark-gray">
                                    <%=step1View.getDateCreation().toLocaleString().substring(0, 13)%>
                                </small>
                                <small class="w3-small w3-text-gray">
                                    <%=step1View.getDateCreation().toLocaleString().substring(13)%>
                                </small>

                            </div>
                        </div>
                    </div>
                    <% }%>
                    <br>
                </div>
            </div>
        </div>
    </div>
</div>



<script>

    function _addStep1Comment() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                _viewAllStep1Comment();
            }
        };
        var comment = document.f_comment.comment.value;
        var addComment = document.f_comment.addComment.value;
        var url = "<%=application.getContextPath()%>/Problem?";
        url = url + "id=" + <%=problem.getId()%>;
        url = url + "&comment=" + comment;
        url = url + "&addComment=" + addComment;
        document.f_comment.comment.value = "";
        xhttp.open("POST", url, true);
        xhttp.send();

    }
    function _deleteStep1Comment(step1CommentId) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                _viewAllStep1Comment();
            }
        };
        var url = "<%=application.getContextPath()%>/Problem?";
        url = url + "id=" + <%=problem.getId()%>;
        url = url + "&idComment=" + step1CommentId;
        url = url + "&deleteComment=" + "deleteComment";
        document.f_comment.comment.value = "";
        xhttp.open("POST", url, true);
        xhttp.send();

    }

    function _updateStep1Comment(step1CommentId, comment) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                _viewAllStep1Comment();
            }
        };
        var url = "<%=application.getContextPath()%>/Problem?";
        url = url + "id=" + <%=problem.getId()%>;
        url = url + "&idComment=" + step1CommentId;
        url = url + "&updateComment=" + "updateComment";
        url = url + "&comment=" + comment;
        xhttp.open("POST", url, true);
        xhttp.send();

    }

    function _viewAllStep1Comment() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("comment123").innerHTML = this.responseText;
            }
        };

        var url = "<%=application.getContextPath()%>/user/ajax/viewAllStep1Comment.jsp?";
        url = url + "id=" + <%=problem.getId()%>;
        xhttp.open("GET", url, true);
        xhttp.send();
    }
//***********************************************************
//***********************************************************
    function _addStep1Action(action, qui, quand, commentaire) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                _viewAllStep1Action();
            }
        };
        var url = "<%=application.getContextPath()%>/CreateS1P3?";
        url = url + "id=" + <%=problem.getId()%>;
        url = url + "&action=" + action;
        url = url + "&qui=" + qui;
        url = url + "&quand=" + quand;
        url = url + "&commentaire=" + commentaire;
        url = url + "&addAction=" + "addAction";
        document.f_action.action.value = "";
        document.f_action.qui.value = "";
        document.f_action.quand.value = "";
        document.f_action.commentaire.value = "";

        xhttp.open("POST", url, true);

        xhttp.send();
    }

    function _addStep1ActionStatus(idStep1Action) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                _viewAllStep1Action();
            }
        };
        var url = "<%=application.getContextPath()%>/CreateS1P3?";
        url = url + "id=" + <%=problem.getId()%>;
        url = url + "&idStep1Action=" + idStep1Action;

        url = url + "&addStep1ActionStatus=" + "addStep1ActionStatus";
        xhttp.open("POST", url, true);

        xhttp.send();
    }
    function _minusStep1ActionStatus(idStep1Action) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                _viewAllStep1Action();
            }
        };
        var url = "<%=application.getContextPath()%>/CreateS1P3?";
        url = url + "id=" + <%=problem.getId()%>;
        url = url + "&idStep1Action=" + idStep1Action;

        url = url + "&minusStep1ActionStatus=" + "minusStep1ActionStatus";
        xhttp.open("POST", url, true);

        xhttp.send();
    }

    function _updateStep1Action(idStep1Action, action, qui, quand, commentaire) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                _viewAllStep1Action();
            }
        };
        var url = "<%=application.getContextPath()%>/CreateS1P3?";
        url = url + "id=" + <%=problem.getId()%>;
        url = url + "&idStep1Action=" + idStep1Action;
        url = url + "&action=" + action;
        url = url + "&qui=" + qui;
        url = url + "&quand=" + quand;
        url = url + "&commentaire=" + commentaire;
        url = url + "&updateAction=" + "updateAction";
        xhttp.open("POST", url, true);

        xhttp.send();
    }
    function _deleteStep1Action(step1ActionId) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                _viewAllStep1Action();
            }
        };
        var url = "<%=application.getContextPath()%>/CreateS1P3?";
        url = url + "id=" + <%=problem.getId()%>;
        url = url + "&idStep1Action=" + step1ActionId;
        url = url + "&destroyAction=" + "destroyAction";
        xhttp.open("POST", url, true);
        xhttp.send();

    }

    function _deleteAllStep1Action() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                _viewAllStep1Action();
            }
        };
        var url = "<%=application.getContextPath()%>/CreateS1P3?";
        url = url + "id=" + <%=problem.getId()%>;
        url = url + "&destroyAll=" + "destroyAll";
        xhttp.open("POST", url, true);
        xhttp.send();

    }

    function _viewAllStep1Action() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("actions").innerHTML = this.responseText;
            }
        };
        var url = "<%=application.getContextPath()%>/user/ajax/viewAllStep1Action.jsp?";
        url = url + "id=" + <%=problem.getId()%>;
        xhttp.open("GET", url, true);
        xhttp.send();
    }
//***********************************************************
//***********************************************************
    function _addStep1Why(why, commentaire) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                _viewAllStep1Why();
            }
        };
        var url = "<%=application.getContextPath()%>/CreateS1P4?";
        url = url + "id=" + <%=problem.getId()%>;
        url = url + "&pourquoi=" + why;
        url = url + "&commentaire=" + commentaire;
        url = url + "&addWhy=" + "addWhy";
        document.f_why.pourquoi.value = "";
        document.f_why.commentaire.value = "";

        xhttp.open("POST", url, true);

        xhttp.send();
    }



    function _updateStep1Why(idStep1Why, why, commentaire) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                _viewAllStep1Why();
            }
        };
        var url = "<%=application.getContextPath()%>/CreateS1P4?";
        url = url + "id=" + <%=problem.getId()%>;
        url = url + "&idStep1Why=" + idStep1Why;
        url = url + "&pourquoi=" + why;
        url = url + "&commentaire=" + commentaire;
        url = url + "&updateWhy=" + "updateWhy";
        xhttp.open("POST", url, true);

        xhttp.send();
    }
    function _deleteStep1Why(step1WhyId) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                _viewAllStep1Why();
            }
        };
        var url = "<%=application.getContextPath()%>/CreateS1P4?";
        url = url + "id=" + <%=problem.getId()%>;
        url = url + "&idStep1Why=" + step1WhyId;
        url = url + "&destroyWhy=" + "destroyWhy";
        xhttp.open("POST", url, true);
        xhttp.send();

    }

    function _deleteAllStep1Why() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                _viewAllStep1Why();
            }
        };
        var url = "<%=application.getContextPath()%>/CreateS1P4?";
        url = url + "id=" + <%=problem.getId()%>;
        url = url + "&destroyAll=" + "destroyAll";
        xhttp.open("POST", url, true);
        xhttp.send();

    }

    function _viewAllStep1Why() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("why").innerHTML = this.responseText;
            }
        };
        var url = "<%=application.getContextPath()%>/user/ajax/viewAllStep1Why.jsp?";
        url = url + "id=" + <%=problem.getId()%>;
        xhttp.open("GET", url, true);
        xhttp.send();
    }





    function tout()
    {
        _viewAllStep1Comment();
        _viewAllStep1Action();
        _viewAllStep1Why();
    }
    window.onload = function () {
        tout();
        setInterval(tout, 2000);
    }

</script>


<%
    for (Step1Comment step1C : step1.getStep1CommentList()) {
%>


<!-- Modal -->
<div class="modal fade" id="comment<%=step1C.getId()%>" tabindex="-1" role="dialog" aria-labelledby="comment<%=step1C.getId()%>" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br><br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">Modifier Commentaire</h3>
                </div>
                <div class="<%=Design.container%>">
                    <br><br>
                    <form>
                        <div class="row">

                            <div class="col-lg-12">
                                <textarea name="comment" class="w3-input w3-border" dir="rtl" style="text-align: left; " rows="3">
                                    <%=step1C.getComment().trim()%>
                                </textarea>
                            </div>

                            <div class="col-lg-12 ">
                                <br><br>
                                <div class="form-group w3-right">
                                    <button style="border-radius: 5px" type="reset" class="<%=Design.btn%>">Annuler</button>
                                    <button style="border-radius: 5px" type="button" class="w3-btn w3-round w3-blue" name="updateComment" onclick="_updateStep1Comment(<%=step1C.getId()%>, comment.value);" class="close" data-dismiss="modal" aria-label="Close">Modofier</button>
                                </div>

                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
<%
    }
%>


<%
    for (Step1Action step1Action : step1.getStep1ActionList()) {
%>


<!-- Modal -->
<div class="modal fade" id="action<%=step1Action.getId()%>" tabindex="-1" role="dialog" aria-labelledby="action<%=step1Action.getId()%>" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br><br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">Analyse et actions définitives</h3>
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form>
                        <div class="card-content">
                            <div class="form-group">
                                <label>Action ?</label><star> *</star>
                                <input name="action" type="text" value="<%=step1Action.getAction()%>" class="w3-input w3-border w3-border-grey w3-round" required>
                            </div>
                            <div class="form-group">
                                <label>Qui ?</label><star> *</star>
                                <input name="qui" type="text" value="<%=step1Action.getWho()%>" class="w3-input w3-border w3-border-grey w3-round" required>
                            </div>
                            <div class="form-group">
                                <label>Quand ?</label><star> *</star>
                                <input name="quand" type="text" value="<%=step1Action.getWhen()%>" class="w3-input w3-border w3-border-grey w3-round datetimepicker" required>
                            </div>
                            <div class="form-group">
                                <label>Commentaire ?</label>
                                <textarea name="commentaire" class="w3-input w3-border w3-border-grey w3-round" rows="4" dir="rtl" style="text-align: left;">
                                    <%=step1Action.getComment().trim()%>         
                                </textarea>
                            </div>

                            <button style="border-radius: 5px" type="button" class="<%=Design.btn%>" onclick="_updateStep1Action(<%=step1Action.getId()%>, action.value, qui.value, quand.value, commentaire.value)" class="close" data-dismiss="modal" aria-label="Close" >Modifier</button>
                            <button style="border-radius: 5px" type="reset" class="<%=Design.btn%>">Annuler</button>
                        </div>
                    </form>
                    <br>
                </div>
            </div>
        </div>  
    </div>
</div>
<%
    }
%>




<!-- Modal -->
<%
    for (Step1Why step1Why : step1.getStep1WhyList()) {
%>


<div class="modal fade" id="why<%=step1Why.getId()%>" tabindex="-1" role="dialog" aria-labelledby="action<%=step1Why.getId()%>" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br><br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">Analyse et actions définitives</h3>
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form>
                        <div class="card-content">
                            <div class="form-group">
                                <label>Pourquoi ?</label><star> *</star>
                                <input name="pourquoi" type="text" value="<%=step1Why.getWhy()%>" class="w3-input w3-border w3-border-grey w3-round" required>
                            </div>
                            <div class="form-group">
                                <label>Commentaire ?</label>
                                <textarea name="commentaire" class="w3-input w3-border w3-border-grey w3-round" rows="4" dir="rtl" style="text-align: left;">
                                    <%=step1Why.getComment().trim()%>         
                                </textarea>
                            </div>

                            <button style="border-radius: 5px" type="button" class="<%=Design.btn%>" onclick="_updateStep1Why(<%=step1Why.getId()%>, pourquoi.value, commentaire.value)" class="close" data-dismiss="modal" aria-label="Close" >Modifier</button>
                            <button style="border-radius: 5px" type="reset" class="<%=Design.btn%>">Annuler</button>
                        </div>
                    </form>
                    <br>
                </div>
            </div>
        </div>  
    </div>
</div>
<%
    }
%>
