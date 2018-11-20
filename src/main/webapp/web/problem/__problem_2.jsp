

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
    String permission = (String) session.getAttribute("permission");
    String id_problem = request.getParameter("id");
    Problem problem = ServiceProblem.find(Integer.parseInt(id_problem));
    TypeProblem typeProblem = problem.getIdTypeProblem();
    Step1 step1 = problem.getIdStep1();
    User user = problem.getIdUser();
    List<Step1Action> listStep1Action = step1.getStep1ActionList();
    List<Step1Why> listStep1Why = step1.getStep1WhyList();
    List<Step1Securisation> listStep1Securisation = step1.getStep1SecurisationList();
    List<Step1ActionFollowed> listStep1ActionFollowed = step1.getStep1ActionFollowedList();
    List<Step1AlertCan> listStep1AlertCan = step1.getStep1AlertCanList();
    List<Step1AlertShould> listStep1AlertShould = step1.getStep1AlertShouldList();
    List<Step1Comment> listStep1Comment = step1.getStep1CommentList();


%>




<div class="row">
    <div class="col-md-12">

        <div class="row">

            <div class="col-lg-1 mb-3">
                <button type="button" class="btn btn-success btn-lg btn-block " data-toggle="modal" data-target="#Step1ViewListUser">
                    <span class=" w3-small"> <%=problem.getIdStep1().getStep1ViewList().size()%> vues </span>                    
                </button>
            </div>
            <div class="col-lg-2 mb-3">
                <div  class="card bg-light">
                    <div  class="card-header ">
                        <span class="w3-left w3-text-dark-gray">Status</span> 
                        <span class="w3-right w3-text-dark-gray"><%=problem.getStatus()%></span>                 
                    </div>
                </div>
            </div>
            <div class="col-lg-2 mb-3">
                <div  class="card bg-light">
                    <div  class="card-header ">
                        <span class="w3-left w3-text-dark-gray">Code</span> 
                        <span class="w3-right w3-text-dark-gray"><%=problem.getCode()%></span>                 
                    </div>
                </div>
            </div>
            <div class="col-lg-2 mb-3">
                <div  class="card bg-light">
                    <div  class="card-header ">
                        <i class="w3-left fa fa-user w3-text-dark-gray"></i> 
                        <span class="w3-right w3-text-dark-gray"><%=problem.getIdUser().getName() + " " + problem.getIdUser().getFirstName()%></span>                 
                    </div>
                </div>
            </div>
            <div class="col-lg-2 mb-3">
                <div  class="card bg-light">
                    <div  class="card-header ">
                        <i class="w3-left fa fa-warning w3-text-dark-gray"></i> 
                        <span class="w3-right w3-text-dark-gray"><%=problem.getIdTypeProblem().getName()%></span>                 
                    </div>
                </div>
            </div>

        </div>
        <br>     

        <div class="w3-bar bg-light w3-round">
            <a href="#caracterisation" class="w3-bar-item w3-button">Caract�risation</a>
            <a href="#actionsimmediate" class="w3-bar-item w3-button">Actions imm�diates</a>
            <a href="#5pourquoi" class="w3-bar-item w3-button">5 Pourquoi</a>
            <a href="#actions" class="w3-bar-item w3-button">Actions</a>
            <a href="#suivi" class="w3-bar-item w3-button">Suivi</a>
            <a href="#commentaires" class="w3-bar-item w3-button">Commentaires</a>


            <%if (permission.equals("yes")) {%>   
            <button  onclick="document.location.href = 'ProblemPdf?id=<%=problem.getId()%>'"  type="button" class="w3-bar-item w3-button w3-right w3-hover-pink w3-hover-text-white    w3-red w3-text-white"> 
                <i class=" w3-hover-text-white fa fa-file-pdf-o w3-large"></i>
            </button>
            <%} else {%>   
            <button  disabled onclick="document.location.href = 'ProblemPdf?id=<%=problem.getId()%>'"  type="button" class="w3-bar-item w3-button w3-right w3-hover-pink w3-hover-text-white    w3-red w3-text-white"> 
                <i class=" w3-hover-text-white fa fa-archive w3-large"></i>
            </button>
            <%}%>


            <%if (permission.equals("yes")) {%>   
            <button  onclick="document.location.href = 'Rapport8D?id=<%=problem.getId()%>'"  type="button"          class="w3-bar-item w3-button w3-right w3-hover-dark-grey w3-hover-text-white w3-grey w3-text-white"> 
                <i class="fa fa-archive w3-large"></i> Rapport 8D
            </button>
            <%} else {%>   
            <button  disabled onclick="document.location.href = 'Rapport8D?id=<%=problem.getId()%>'"  type="button" class="w3-bar-item w3-button w3-right w3-hover-dark-grey w3-hover-text-white w3-grey w3-text-white"> 
                <i class="fa fa-archive w3-large"></i> Rapport 8D
            </button>
            <%}%>


        </div>
        <br>
        <!--===================================================================
        =======================================================================
        =======================================================================
        ===================================================================-->
        <a name="caracterisation"></a>

        <div class="card  mb-3" >
            <div class="card-header bg-light w3-padding-small">
                <div class="w3-left">
                    Caract�risation
                </div>
                <div class="w3-right">

                    <%if (permission.equals("yes")) {%>   
                    <button  onclick="document.location.href = 'S1P1?id=<%=problem.getId()%>'" type="button" class="btn btn-sm btn-light"> 
                        <i class=" ti-pencil-alt"> </i>
                    </button>
                    <%} else {%>   
                    <button  disabled onclick="document.location.href = 'S1P1?id=<%=problem.getId()%>'" type="button" class="btn btn-sm btn-light"> 
                        <i class=" ti-pencil-alt"> </i>
                    </button>
                    <%}%>
                </div>
            </div>
            <div class="card-body w3-white">
                <div class="row">
                    <div class="col-lg-5">
                        <!--#######################################-->
                        <table class="table table-bordered">
                            <tr>
                                <th>R�ference</th>
                                <td> <%=problem.getReference()%></td>
                            </tr>
                            <tr>
                                <th>Que s'est t'il pass�&nbsp;?</th>
                                <td> <%=step1.getWhat()%></td>
                            </tr>
                            <tr>
                                <th>Quand&nbsp;?</th>
                                <td><%=step1.getWhen()%></td>
                            </tr>
                            <tr>
                                <th>O�&nbsp;?</th>
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
                        <div class="w3-container w3-margin-bottom w3-light-gray w3-padding w3-round">
                            <span class=" w3-left">Respect du standard</span>
                            <%if (step1.getRespectStandard()) {%>
                            <span class="w3-text-green ti-check w3-right"></span>
                            <%} else {%>
                            <span class="w3-text-red ti-close w3-right"></span>
                            <%}%>
                        </div>
                        <div class="w3-container w3-margin-bottom w3-light-gray w3-padding w3-round">
                            <span class=" w3-left">Probl�me recurrent</span>
                            <%if (step1.getRecognizedProblem()) {%>
                            <span class="w3-text-green ti-check w3-right"></span>
                            <%} else {%>
                            <span class="w3-text-red ti-close w3-right"></span>
                            <%}%>
                        </div>
                        <!--#######################################-->
                    </div>

                    <div class="col-lg-3">
                        <div class="w3-row">


                            <div class="col-lg-12">
                                <div class="card  mb-3 bg-danger">
                                    <div class="card-header w3-text-white">
                                        PIECE MAUVAISE
                                    </div>
                                    <div class="card-body  w3-white w3-padding w3-center ">
                                        <img class="card-img-top " id="img1" src="<%=application.getContextPath()%>/upload/<%=step1.getBadPiece()%>" alt="...">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="card  mb-3 bg-success">
                                    <div class="card-header w3-text-white">
                                        PIECE BONNE
                                    </div>
                                    <div class="card-body  w3-white w3-padding w3-center ">
                                        <img class="card-img-top " id="img1" src="<%=application.getContextPath()%>/upload/<%=step1.getGoodPiece()%>" alt="...">
                                    </div>
                                </div>
                            </div>        

                        </div>
                    </div>

                    <div class="col-lg-4">
                        <!--#######################################-->
                        <div class="w3-row">
                            <div class="col-lg-12">
                                <div class="card  mb-3">
                                    <div class="card-header">
                                        Qui doit �tre Alert� <span class="w3-badge w3-round w3-pink"> <%=listStep1AlertShould.size()%></span>
                                    </div>
                                    <ul class="list-group list-group-flush">
                                        <%
                                            for (Step1AlertShould step1AlertShould : listStep1AlertShould) {
                                        %>
                                        <li class="list-group-item">
                                            <%=step1AlertShould.getIdTypeUser().getName()%>
                                        </li>
                                        <%
                                            }
                                        %>
                                    </ul>
                                </div>
                            </div> 
                            <div class="col-lg-12">
                                <div class="card  mb-3">
                                    <div class="card-header">
                                        Qui peut �tre Alert� <span class="w3-badge w3-round w3-pink"> <%=listStep1AlertCan.size()%></span>
                                    </div>
                                    <ul class="list-group list-group-flush">
                                        <%
                                            for (Step1AlertCan step1AlertCan : listStep1AlertCan) {
                                        %>
                                        <li class="list-group-item">
                                            <%=step1AlertCan.getIdTypeUser().getName()%>
                                        </li>
                                        <%
                                            }
                                        %>
                                    </ul>
                                </div>
                            </div> 
                        </div>
                        <!--#######################################-->

                    </div>
                </div>
            </div>
            <div class="card-footer">

            </div>
        </div>


        <!--===================================================================
        =======================================================================
        =======================================================================
        ===================================================================-->

        <a name="actionsimmediate"></a>
        <div class="card  mb-3" >
            <div class="card-header bg-light1 w3-padding-small">
                <div class="w3-left">
                    Actions imm�diates
                </div>
                <div class="w3-right">
                    <%if (permission.equals("yes")) {%>   
                    <button  onclick="document.location.href = 'S1P2?id=<%=problem.getId()%>'" type="button" class="btn btn-sm btn-light"> 
                        <i class=" ti-pencil-alt"> </i>
                    </button>
                    <%} else {%>   
                    <button  disabled onclick="document.location.href = 'S1P2?id=<%=problem.getId()%>'" type="button" class="btn btn-sm btn-light"> 
                        <i class=" ti-pencil-alt"> </i>
                    </button>
                    <%}%>
                </div>
            </div>
            <div class="card-body w3-white">
                <div class="row">
                    <div class="col-lg-12">
                        <br>
                        <form>
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="form-group">
                                        <label>Lancer un tri</label>
                                        <%if (step1.getSort()) {%>    
                                        <input disabled type="text" class="form-control w3-text-green w3-white " value="oui" >                          
                                        <%} else {%>
                                        <input disabled type="text" class="form-control w3-text-red w3-white" value="non" >  
                                        <%}%>
                                    </div>
                                </div> 

                                <div class="col-lg-4">
                                    <div class="form-group">
                                        <label>Voir le rapport de tri</label>
                                        <a href="#"  class="form-control w3-text-white w3-light-blue"  > cliquer ici ..</a>
                                    </div>
                                </div> 

                                <div class="col-lg-4">
                                    <div class="form-group">
                                        <label>Quel est le crit�r� de tri</label>
                                        <input disabled type="text" class="form-control w3-white" value="<%=step1.getSortCriterion()%>">  
                                    </div>
                                </div> 

                                <div class="col-lg-4">
                                    <div class="form-group">
                                        <label>Autre Actions imm�diates</label>
                                        <textarea  disabled class="form-control w3-white" rows="3" ><%=step1.getImmediateActions()%></textarea>
                                    </div>
                                </div> 
                                <div class="col-lg-12">
                                    <label>Plan de s�curisation client</label>
                                    <table  class="tableq  w3-responsive table-sm w3-table " cellspacing="0" width="100%" style="width:100%">
                                        <thead class="w3-blue-gray"> 
                                            <tr>
                                                <th style=" white-space: nowrap;" class="" >Non de l'action</th>
                                                <th style=" white-space: nowrap;" class="" >Priorit�</th>
                                                <th style=" white-space: nowrap;" class="" >�tat</th>
                                                <th style=" white-space: nowrap;" class="" >Description</th>
                                                <th style=" white-space: nowrap;" class="" >Date de d�but</th>
                                                <th style=" white-space: nowrap;" class="" >�ch�ance</th>
                                                <th style=" white-space: nowrap;" class="" >Pourcentage achev� %</th>
                                                <th style=" white-space: nowrap;" class="" >Affect� �</th>
                                                <th style=" white-space: nowrap;" class="" >O�</th>
                                                <th style=" white-space: nowrap;" class="" >Combien ?</th>
                                                <th style=" white-space: nowrap;" class="" >Resultat ?</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                out.println(listStep1Securisation.size());
                                                for (Step1Securisation step1Securisation : listStep1Securisation) {
                                            %>

                                            <tr>
                                                <td style=" white-space: nowrap;" class="w3-border" >Plan de s�curisation</td>
                                                <td style=" white-space: nowrap;" class="w3-border" ><%=step1Securisation.getPriority()%></td>
                                                <td style=" white-space: nowrap;" class="w3-border" ><%=step1Securisation.getState()%></td>
                                                <td style=" white-space: nowrap;" class="w3-border" ><%=step1Securisation.getDescription()%></td>
                                                <td style=" white-space: nowrap;" class="w3-border" ><%=new SimpleDateFormat("MM/dd/yyyy").format(step1Securisation.getStartDate())%></td>
                                                <td style=" white-space: nowrap;" class="w3-border" ><%=new SimpleDateFormat("MM/dd/yyyy").format(step1Securisation.getDeadline())%></td>
                                                <td style=" white-space: nowrap;" class="w3-border" ><%=step1Securisation.getPercentageCompleted()%>%</td>
                                                <td style=" white-space: nowrap;" class="w3-border" ><%=step1Securisation.getAffectedTo().getFirstName() + " " + step1Securisation.getAffectedTo().getName()%></td>
                                                <td style=" white-space: nowrap;" class="w3-border" ><%=step1Securisation.getWhere()%></td>
                                                <td style=" white-space: nowrap;" class="w3-border" ><%=step1Securisation.getHowMutch()%></td>
                                                <td style=" white-space: nowrap;" class="w3-border" ><%=step1Securisation.getResult()%></td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>   

                        </form>


                    </div>

                </div>
            </div>
            <div class="card-footer w3-padding-small">
                <%    if (step1.getStartValidation()) {
                %>
                <div class="row">
                    <div class="col-lg-6">
                        <p class="w3-text-green w3-padding w3-round">
                            Validation de red�marrage
                            <small class="w3-text-dark-gray w3-small">
                                Oui par &nbsp;
                                <span  class="w3-text-blue"><%=step1.getUserValidation().getName() + " " + step1.getUserValidation().getFirstName()%></span>
                                &nbsp;
                                <span  class="w3-text-grey"><%=step1.getDateValidation().toLocaleString()%></span>
                            </small>
                        </p>
                    </div>
                </div>

                <%
                } else {
                %>
                <div class="row">
                    <div class="col-lg-6">
                        <p class="w3-text-red w3-padding w3-round">
                            Validation de red�marrage
                        </p>
                    </div>
                </div>

                <%
                    }
                %>
            </div>
        </div>


        <!--===================================================================
        =======================================================================
        =======================================================================
         ===================================================================-->
        <a name="5pourquoi"></a>                        
        <div class="card mb-3">
            <div  class="card-header">
                Analyse et actions d�finitives
            </div>
            <div class="card-body">   
                <div class="w3-col-12"> 
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card mb-3">
                                <div  class="card-header w3-padding-small">
                                    <div class="w3-left">
                                        5 Pourquoi  : <%=step1.getWhat()%>
                                    </div>
                                    <div class="w3-right">
                                        <%if (permission.equals("yes")) {%>   
                                        <button data-toggle="modal" data-target="#addWhy"  name="addWhy" type="button" class="btn btn-light btn-sm ti-plus"> 
                                        </button>
                                        <%} else {%>   
                                        <button disabled data-toggle="modal" data-target="#addWhy"  name="addWhy" type="button" class="btn btn-light btn-sm ti-plus"> 
                                        </button>
                                        <%}%>
                                    </div>
                                    <div class=" w3-right">

                                        <%if (permission.equals("yes")) {%>   
                                        <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                    _deleteAllStep1Why();
                                                    return true;
                                                } else {
                                                    return false;
                                                }" name="destroyAll" type="submit" class="btn btn-light btn-sm ti-trash"> 
                                        </button>
                                        <%} else {%>   
                                        <button disabled onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                    _deleteAllStep1Why();
                                                    return true;
                                                } else {
                                                    return false;
                                                }"name="destroyAll" type="submit" class="btn btn-light btn-sm ti-trash"> 
                                        </button>
                                        <%}%>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div id="why">
                                    </div>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>

                    <a name="actions"></a>  

                    <div  class="row">
                        <div class="col-lg-12">
                            <div class="card mb-3">
                                <div class="card-header w3-padding-small">
                                    Actions
                                    <div class="w3-right">
                                        <%if (permission.equals("yes")) {%>   
                                        <button data-toggle="modal" data-target="#addAction"  name="addAction" type="button" class="btn btn-light btn-sm ti-plus"> 
                                        </button>
                                        <%} else {%>   
                                        <button disabled data-toggle="modal" data-target="#addAction"  name="addAction" type="button" class="btn btn-light btn-sm ti-plus"> 
                                        </button>
                                        <%}%>
                                    </div>
                                    <div class=" w3-right">
                                        <%if (permission.equals("yes")) {%>   
                                        <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                    _deleteAllStep1Action();
                                                    return true;
                                                } else {
                                                    return false;
                                                }" name="destroyAll" type="button" class="btn btn-light btn-sm ti-trash"> 
                                        </button>
                                        <%} else {%>   
                                        <button disabled onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                    _deleteAllStep1Action();
                                                    return true;
                                                } else {
                                                    return false;
                                                }"  name="destroyAll" type="button" class="btn btn-light btn-sm ti-trash"> 
                                        </button>
                                        <%}%>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div id="actions">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>



                    <a name="suivi"></a>   
                    <div  class="row ">
                        <div  class="col-lg-12">
                            <div class="card mb-3">
                                <div class="card-header">
                                    Suivi des equipes
                                </div>
                                <div class="card-body">
                                    <table class="table table-bordered table-responsive-md" cellspacing="0" width="100%" style="width:100%">
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
                                                                    <label class="switch">
                                                                        <input name="efficace" type="checkbox" >
                                                                        <span class="slider round"></span>
                                                                    </label>
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

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!--===================================================================
        =======================================================================
        =======================================================================
         ===================================================================-->                    
        <a name="commentaires"></a>  
        <div  class="row ">
            <div  class="col-lg-12">
                <div class="card mb-3">
                    <div class="card-header">
                        Commentaires
                    </div>
                    <div class="card-body">
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
                                <div class="col-lg-4 w3-right">
                                    <div class="form-group">
                                        <button type="reset" class="btn btn-light">ANNULER</button>
                                        <button type="button" class="btn btn-primary" name="addComment" onclick="_addStep1Comment();">AJOUTER UN COMMENTAIRE</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <br>
                        <div class="row" id="comment123">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- end col-md-12 -->
    <!-- </div>  end row -->
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
                    <h3 class="<%=Design.textTitle%>">Analyse et actions d�finitives</h3>
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
                                <select name="qui" class="form-control">
                                    <option value="" disabled >Choisir ..</option>
                                    <% for (User u1 : ServiceUser.findAll()) {%>
                                    <% String name = u1.getName() + " " + u1.getFirstName();%>
                                    <option  value="<%=u1.getId()%>" class=""><%=name%></option>
                                    <%}%>
                                </select>
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

    function  _openModelUpdateComment(id) {
        document.f_updatecomment.idcomment.value = id;
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

    function _viewModelStep1Comment() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("modelComment").innerHTML = this.responseText;
            }
        };
        var url = "<%=application.getContextPath()%>/user/ajax/problem/viewModelStep1Comment.jsp?";
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
        //  _viewModelStep1Comment();
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
            <div class="modal-header">
                <h5 class="modal-title">Modifier Commentaire</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label>Commentaire</label>
                                <textarea name="comment" class="form-control"  rows="3">
                                    <%=step1C.getComment().trim()%>
                                </textarea>
                            </div>
                            <div class="w3-right">
                                <button  type="reset" class="btn btn-light">Annuler</button>
                                <button  type="button" class="btn btn-primary" name="updateComment" onclick="_updateStep1Comment(<%=step1C.getId()%>, comment.value);" class="close" data-dismiss="modal" aria-label="Close">Modifier</button>
                            </div>
                        </div>
                    </div>
                </form>
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
                    <h3 class="<%=Design.textTitle%>">Analyse et actions d�finitives</h3>
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
                                <select name="qui" class="form-control">
                                    <option value="" disabled >Choisir ..</option>
                                    <% for (User u1 : ServiceUser.findAll()) {%>
                                    <% String name = u1.getName() + " " + u1.getFirstName();%>
                                    <option  value="<%=u1.getId()%>" class=""><%=name%></option>
                                    <%}%>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Quand ?</label><star> *</star>
                                <input name="quand" type="text" value="<%=step1Action.getStartDate()%>" class="w3-input w3-border w3-border-grey w3-round datetimepicker" required>
                            </div>
                            <div class="form-group">
                                <label>Commentaire ?</label>
                                <textarea name="commentaire" class="w3-input w3-border w3-border-grey w3-round" rows="4" dir="rtl" style="text-align: left;">
                                    <%=step1Action.getDescription().trim()%>         
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
                    <h3 class="<%=Design.textTitle%>">Analyse et actions d�finitives</h3>
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
