<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="entity.*"%>
<%@page import="service.*"%>
<%@page import="domaine.Design"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.List"%>
<%
    entity.Problem problem = (entity.Problem) session.getAttribute("problem");
    ResourceBundle bundle = (ResourceBundle) session.getAttribute("bundle");
    List<Step1Securisation> listStep1SecurityPlan = (List<Step1Securisation>) session.getAttribute("listSecurityPlan");
%>

<%
    if (listStep1SecurityPlan == null) {
        listStep1SecurityPlan = new ArrayList<Step1Securisation>();
        session.setAttribute("listSecurityPlan", listStep1SecurityPlan);
    }
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


<form  action="<%=application.getContextPath()%>/CreateS1P2"  method="post" >
    <div class="card bg-light mb-3" >
        <div class="card-header font-weight-bold">
            Actions immédiates 
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
                            <div id="plansecurisation">
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
                                            <label class="switch">
                                                <input name="sort" type="checkbox" checked>
                                                <span class="slider round"></span>
                                            </label>   
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="basic-addon1">Quel est le critéré de trie: ?</span>
                                    </div>
                                    <input name="sort_criterion" type="text" class="form-control" placeholder="" aria-label="Username" aria-describedby="basic-addon1">
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Autre Actions immédiates&nbsp;&nbsp;</span>
                                    </div>
                                    <textarea name="immediate_actions" cols="5" class="form-control" aria-label="Autre Actions immédiates"></textarea>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="form-group ">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <label for="staticEmail" class="col-form-label">Validation de redémarrage ?</label>
                                            <label class="switch">
                                                <input name="start_validation" type="checkbox" checked>
                                                <span class="slider round"></span>
                                            </label>   
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
        </div>
        <div class="card-footer">
            <div class="btn-group w3-right" role="group" aria-label="Basic example">
                <button type="reset" class="btn btn-light">Annuler</button>
                <button type="submit" class="btn btn-primary" name="S1P2">Suivant</button>

            </div>
        </div>
    </div>
</form>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br>
                <div class="card">
                    <div class="card-header">
                        <h3 class="">Plan de sécurisation Client</h3>
                    </div>
                    <div class="card-body">
                        <br>
                        <form name="f_plansecurisation" method="post" action="<%=application.getContextPath()%>/CreateS1P2">
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
                                    <input readonly value="0" name="n2" type="number" class="form-control" required>

                                </div>
                                <div class="form-group">
                                    <button name="AddPlan"  type="button" class="btn btn-primary" onclick="_addPlanSecurisation()">Ajouter</button>
                                    <button type="reset" class="<%=Design.btn%>">Annuler</button>
                                </div>
                            </div>
                        </form>
                        <br>
                    </div>
                </div>





            </div>
        </div>
    </div>
</div>
<%
    problem = null;
    listStep1SecurityPlan = null;

%>
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
        }

    }


    function _viewPlanSecurisation() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("plansecurisation").innerHTML = this.responseText;
            }
        };
        var url = "<%=application.getContextPath()%>/user/ajax/s1p2/viewPlanSecurisation.jsp";
        xhttp.open("POST", url, true);
        xhttp.send();
    }

    function _addPlanSecurisation() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                _viewPlanSecurisation();
            }
        };

        var where = f_plansecurisation.where.value;
        var who = f_plansecurisation.who.value;
        var n1 = f_plansecurisation.n1.value;
        var n2 = f_plansecurisation.n2.value;

        var url = "<%=application.getContextPath()%>/user/ajax/s1p2/addPlanSecurisation.jsp?";
        url = url + "where=" + where;
        url = url + "&who=" + who;
        url = url + "&n1=" + n1;
        url = url + "&n2=" + n2;

        f_plansecurisation.where.value = "";
        f_plansecurisation.who.value = "";
        f_plansecurisation.n1.value = "";

        xhttp.open("GET", url, true);
        xhttp.send();
    }

    function _deletePlanSecurisation(id) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                _viewPlanSecurisation();
            }
        };
        var url = "<%=application.getContextPath()%>/user/ajax/s1p2/deletePlanSecurisation.jsp?";
        url = url + "id=" + id;

        xhttp.open("POST", url, true);
        xhttp.send();
    }


    window.onload = function () {
        _viewPlanSecurisation();
        //setInterval(tout, 2000);
    }

</script>