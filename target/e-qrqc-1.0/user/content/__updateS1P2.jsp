

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
    List<Step1SecurityPlan> listStep1SecurityPlan = step1.getStep1SecurityPlanList();
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
                                            Step1SecurityPlan securityPlan = null;
                                            for (int i = 0; i < listStep1SecurityPlan.size(); i++) {
                                                securityPlan = listStep1SecurityPlan.get(i);

                                        %>

                                        <tr>
                                            <td><%=(i + 1)%></td>
                                            <td><%=securityPlan.getWhere()%></td>
                                            <td><%=securityPlan.getWho().getFirstName()+" "+securityPlan.getWho().getName()%></td>
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
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
                                <select name="who" class="form-control">
                                    <option value="" disabled >Choisir ..</option>
                                    <% for (User u1 : ServiceUser.findAll()) {%>
                                    <% String name = u1.getName() + " " + u1.getFirstName();%>
                                    <option  value="<%=u1.getId()%>" class="w3-input w3-padding w3-text-dark-gray w3-hover-light-gray"><%=name%></option>
                                    <%}%>
                                </select>
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
</script>