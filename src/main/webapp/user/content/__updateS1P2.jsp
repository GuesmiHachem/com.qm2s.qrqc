

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
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






<form  action="<%=application.getContextPath()%>/UpdateS1P2?id=<%=problem.getId()%>" method="post"  >
    <div class="card mb-3" >
        <div class="card-header font-weight-bold ">
            Actions immédiates
            <div class="w3-right">
                <button  onclick="document.location.href = 'Problem?id=<%=problem.getId()%>'" type="button" class="btn btn-light btn-sm fa fa-external-link w3-text-dark-gray"> 
                </button>
            </div>
        </div>
        <div class="card-body w3-white">
            <form>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="form-group mb-3">
                            <label>Lancer un tri</label>
                            <br>
                            <% if (step1.getSort()) {%>
                            <label class="switch">
                                <input name="sort" type="checkbox" checked>
                                <span class="slider round"></span>
                            </label>   
                            <% } else {%>
                            <label class="switch">
                                <input name="sort" type="checkbox">
                                <span class="slider round"></span>
                            </label>  
                            <% }%>
                        </div>
                    </div> 

                    <div class="col-lg-4">
                        <div class="form-group mb-3">
                            <label>Quel est le critéré de tri</label>
                            <input  type="text" class="form-control w3-white" value="<%=step1.getSortCriterion()%>">  
                        </div>
                    </div> 

                    <div class="col-lg-4">
                        <div class="form-group mb-3">
                            <label>Autre Actions immédiates</label>
                            <textarea  class="form-control w3-white" rows="5" ><%=step1.getImmediateActions()%></textarea>
                        </div>
                    </div> 
                    <div class="col-lg-12 mb-3">
                        <label>Plan de sécurisation client</label>
                        <br>
                        <button data-toggle="modal" data-target="#exampleModal"  type="button" class="btn btn-primary mb-3">Ajouter</button>
                        <br>
                        <table  class="tableq  w3-responsive table-sm w3-table " cellspacing="0" width="100%" style="width:100%">
                            <thead class="w3-blue-gray"> 
                                <tr>
                                    <th style=" white-space: nowrap;" class="" >#</th>
                                    <th style=" white-space: nowrap;" class="" >Non de l'action</th>
                                    <th style=" white-space: nowrap;" class="" >Priorité</th>
                                    <th style=" white-space: nowrap;" class="" >État</th>
                                    <th style=" white-space: nowrap;" class="" >Description</th>
                                    <th style=" white-space: nowrap;" class="" >Date de début</th>
                                    <th style=" white-space: nowrap;" class="" >Échéance</th>
                                    <th style=" white-space: nowrap;" class="" >Pourcentage achevé %</th>
                                    <th style=" white-space: nowrap;" class="" >Affecté à</th>
                                    <th style=" white-space: nowrap;" class="" >Où</th>
                                    <th style=" white-space: nowrap;" class="" >Combien ?</th>
                                    <th style=" white-space: nowrap;" class="" >Resultat ?</th>
                                    <th style=" white-space: nowrap;" class="" >Supprimer</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (int i = 0; i < listStep1SecurityPlan.size(); i++) {
                                        Step1Securisation step1Securisation = listStep1SecurityPlan.get(i);
                                %>

                                <tr>
                                    <td style=" white-space: nowrap;" class="w3-border" ><%=(i + 1)%></td>
                                    <td style=" white-space: nowrap;" class="w3-border" >Plan de sécurisation</td>
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
                                    <td style=" white-space: nowrap;" class="w3-border" >

                                        <form action="<%=application.getContextPath()%>/UpdateS1P2?id=<%=problem.getId()%>" method="post">
                                            <input hidden name="hashcode" type="text" value="<%=step1Securisation.hashCode()%>">
                                            <button  name="removePlan" type="submit" class="btn btn-sm btn-danger w3-tiny">
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
                                    <td style=" white-space: nowrap;" class="w3-border" ><%=(i + 1)%></td>
                                    <td style=" white-space: nowrap;" class="w3-border"></td>
                                    <td style=" white-space: nowrap;" class="w3-border"></td>
                                    <td style=" white-space: nowrap;" class="w3-border"></td>
                                    <td style=" white-space: nowrap;" class="w3-border"></td>
                                    <td style=" white-space: nowrap;" class="w3-border"></td>
                                    <td style=" white-space: nowrap;" class="w3-border"></td>
                                    <td style=" white-space: nowrap;" class="w3-border"></td>
                                    <td style=" white-space: nowrap;" class="w3-border"></td>
                                    <td style=" white-space: nowrap;" class="w3-border"></td>
                                    <td style=" white-space: nowrap;" class="w3-border"></td>
                                    <td style=" white-space: nowrap;" class="w3-border"></td>
                                    <td style=" white-space: nowrap;" class="w3-border"></td>

                                </tr>

                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-lg-4">
                        <div class="form-group mb-3">
                            <label>Validation de redémarrage ?</label>
                            <br>
                            <% if (step1.getStartValidation()) {%>
                            <label class="switch">
                                <input name="start_validation" type="checkbox" checked>
                                <span class="slider round"></span>
                            </label>   
                            <% } else {%>
                            <label class="switch">
                                <input name="start_validation" type="checkbox">
                                <span class="slider round"></span>
                            </label>  
                            <% }%>
                        </div>
                    </div> 
                </div>   

            </form>





            <div class="row">
                <div class="col-lg-7">
                    <div class="card mb-3">
                        <div class="card-body">
                            <p class="">Respecter votre Plan de sécurisation Client.</p>

                            <!-- Button trigger modal -->
                            <button data-toggle="modal" data-target="#exampleModal"  type="button" class="btn btn-primary">Ajouter</button>
                            <br>
                            <br>
                            <% if (listStep1SecurityPlan != null) {%>
                            <div class="<%=Design.cadreTable%>">
                                <table  class="table" cellspacing="0" width="100%" style="width:100%">
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
                                            Step1Securisation step1Securisation = null;
                                            for (int i = 0; i < listStep1SecurityPlan.size(); i++) {
                                                step1Securisation = listStep1SecurityPlan.get(i);

                                        %>

                                        <tr>
                                            <td><%=(i + 1)%></td>
                                            <td><%=step1Securisation.getWhere()%></td>
                                            <td><%=step1Securisation.getAffectedTo().getFirstName() + " " + step1Securisation.getAffectedTo().getName()%></td>
                                            <td><%=step1Securisation.getHowMutch()%></td>
                                            <td><%=step1Securisation.getResult()%></td>

                                            <td>

                                                <form action="<%=application.getContextPath()%>/UpdateS1P2?id=<%=problem.getId()%>" method="post">
                                                    <input hidden name="hashcode" type="text" value="<%=step1Securisation.hashCode()%>">
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
                </div> 
                <div class="col-lg-5">
                    <div class="card mb-3">
                        <div class="card-body">
                            <div class="col-lg-12">
                                <div class="form-group ">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <label for="staticEmail" class="col-form-label">Faut-il lancer un Trie ?</label>
                                            <% if (step1.getSort()) {%>
                                            <label class="switch">
                                                <input name="sort" type="checkbox" checked>
                                                <span class="slider round"></span>
                                            </label>   
                                            <% } else {%>
                                            <label class="switch">
                                                <input name="sort" type="checkbox">
                                                <span class="slider round"></span>
                                            </label>  

                                            <% }%>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="basic-addon1">Quel est le critéré de trie: ?</span>
                                    </div>
                                    <input name="sort_criterion" type="text" class="form-control" value="<%=step1.getSortCriterion()%>" >
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Autre Actions immédiates&nbsp;&nbsp;</span>
                                    </div>
                                    <textarea name="immediate_actions" rows="3" class="form-control" aria-label="Autre Actions immédiates">
                                        <%=step1.getImmediateActions()%>
                                    </textarea>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="form-group ">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <label for="staticEmail" class="col-form-label">Validation de redémarrage ?</label>
                                            <% if (step1.getStartValidation()) {%>
                                            <label class="switch">
                                                <input name="start_validation" type="checkbox" checked>
                                                <span class="slider round"></span>
                                            </label> 
                                            <% } else {%>
                                            <label class="switch">
                                                <input name="start_validation" type="checkbox" >
                                                <span class="slider round"></span>
                                            </label> 
                                            <% }%>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
        </div>
        <div class="card-footer w3-padding-small">
            <div class="btn-group w3-right" role="group" aria-label="Basic example">
                <button type="reset" class="btn btn-light">Annuler</button>
                <button type="submit" class="btn btn-primary" name="S1P2">Sauvegarder</button>

            </div>
        </div>
    </div>
</form>





<!-- Modal -->
<div class="modal fade" id="exampleModalc" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <form method="post" action="<%=application.getContextPath()%>/UpdateS1P2?id=<%=problem.getId()%>">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Plan de sécurisation Client</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">


                    <div class="card-content">
                        <div class="form-group">
                            <label>Où ?</label><star> *</star>
                            <input name="where" type="text" placeholder="" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Qui ?</label><star> *</star>
                            <select name="who" class="form-control">
                                <option value="" disabled >Choisir ..</option>

                                <%
                                    List<User> listUser12 = ServiceUser.findAll();

                                    Collections.sort(listUser12, new Comparator<User>() {
                                        public int compare(User u1, User u2) {
                                            return u1.getName().compareToIgnoreCase(u2.getName());
                                        }
                                    });

                                    for (User u1 : listUser12) {
                                        String name = u1.getName() + " " + u1.getFirstName();
                                %>
                                <option  value="<%=u1.getId()%>" class="w3-input w3-padding w3-text-dark-gray w3-hover-light-gray"><%=name%></option>
                                <%}%>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Combien ?</label><star> *</star>
                            <input  name="n1" type="number" class="form-control" required>

                        </div>
                        <div class="form-group">
                            <label>Resultat (par défaut)</label>
                            <input readonly value="0" name="n2" type="number" class="form-control w3-light-gray w3-text-gray" required>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button  type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button name="AddPlan" type="submit" class="btn btn-primary">Ajouter</button>
                </div>
            </div>
        </form>           
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModals" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br><br>
                <div class="">
                    <h3 class="">Plan de sécurisation Client</h3>
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form method="post" action="<%=application.getContextPath()%>/UpdateS1P2?id=<%=problem.getId()%>">
                        <div class="card-content">
                            <div class="form-group">
                                <label>Priorité</label>
                                <input name="where" type="text" placeholder="" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Etat</label>
                                <input name="where" type="text" placeholder="" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <input name="where" type="text" placeholder="" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Date de Debut</label>
                                <input name="where" type="text" placeholder="" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Echeance</label>
                                <input name="where" type="text" placeholder="" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Pourcentage achevé %</label>
                                <input name="where" type="text" placeholder="" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Où </label>
                                <input name="where" type="text" placeholder="" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Qui</label><star> *</star>
                                <select name="who" class="form-control">
                                    <option value="" disabled >Choisir ..</option>
                                    <% for (User u1 : ServiceUser.findAll()) {%>
                                    <% String name = u1.getName() + " " + u1.getFirstName();%>
                                    <option  value="<%=u1.getId()%>" class="w3-input w3-padding w3-text-dark-gray w3-hover-light-gray"><%=name%></option>
                                    <%}%>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Combien </label><star> *</star>
                                <input  name="n1" type="number" class="<%=Design.inputText%>" required>

                            </div>
                            <div class="form-group">
                                <label>Resultat</label>
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


<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Plan de sécurisation Client</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="<%=application.getContextPath()%>/UpdateS1P2?id=<%=problem.getId()%>">
                    <div class="card-content">
                        <div class="form-group">
                            <label>Priorité</label><star class="w3-text-red"> *</star>
                            <select name="priority" class="form-control custom-select ">
                                <option  value="(1) Haute" class="form-control">(1) Haute</option>
                                <option  value="(2) Normale" class="form-control">(2) Normale</option>
                                <option  value="(3) Faible" class="form-control">(3) Faible</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Etat</label>
                            <select name="state" class="form-control custom-select ">
                                <option  value="Non démarré" class="form-control">Non démarré</option>
                                <option  value="En cours" class="form-control">En cours</option>
                                <option  value="Terminé" class="form-control">Terminé</option>
                                <option  value="Différé" class="form-control">Différé</option>
                                <option  value="En attente" class="form-control">En attente</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Description</label><star class="w3-text-red"> *</star>
                            <input name="description" type="text" placeholder="" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Date de Debut</label><star class="w3-text-red"> *</star>
                            <input name="start_date" type="date" placeholder="" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Echeance</label><star class="w3-text-red"> *</star>
                            <input name="deadline" type="date" placeholder="" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Pourcentage achevé %</label><star class="w3-text-red"> *</star>
                            <div class="w3-right w3-blue-gray w3-padding-small w3-round" >
                                <output id="percentage_completed_output"></output>%
                            </div>
                            <input oninput="percentage_completed_output.value=parseInt(percentage_completed.value)" type="range" class="range custom-range" min="0" max="100" step="1" name="percentage_completed" value="">

                        </div>
                        <div class="form-group">
                            <label>Où </label><star class="w3-text-red"> *</star>
                            <input name="where_" type="text" placeholder="" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Qui</label><star class="w3-text-red"> *</star>
                            <select name="affected_to" class="form-control">
                                <% for (User u1 : ServiceUser.findAll()) {%>
                                <% String name = u1.getName() + " " + u1.getFirstName();%>
                                <option  value="<%=u1.getId()%>" class="w3-input w3-padding w3-text-dark-gray w3-hover-light-gray"><%=name%></option>
                                <%}%>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Combien </label> <star class="w3-text-red"> *</star>
                            <input  name="how_mutch" type="number" class="form-control" required>

                        </div>
                        <div class="form-group">
                            <label>Resultat</label> <star class="w3-text-red"> *</star>
                            <input readonly value="0" name="result" type="number" class="form-control w3-light-gray w3-text-gray" required>

                        </div>
                        <div class="form-group">
                            <button name="AddPlan" type="submit" class="btn btn-primary">Ajouter</button>
                            <button  type="reset" class="btn btn-light">Annuler</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>                            

<script>
    function changeSortCrits()
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


    $(document).ready(function () {
        $(function () {
            /* $('#valrange').on('input', function () {
             $(this).text($('#range').val());
             });
             */
        });
    });
</script>