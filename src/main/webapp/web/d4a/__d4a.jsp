<%-- 
    Document   : __overview
    Created on : 16 juin 2018, 19:41:16
    Author     : Hachem
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domaine.Design"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="entity.*"%>
<%@page import="service.*"%>

<%
    session = ServiceUser.refreshSessionUser(session);

    User userContent = (User) session.getAttribute("user");
    String permission = (String) session.getAttribute("permission");
    String id_problem = request.getParameter("id");
    Problem problem = ServiceProblem.find(Integer.parseInt(id_problem));
    TypeProblem typeProblem = problem.getIdTypeProblem();
    Step1 step1 = problem.getIdStep1();
    User user = problem.getIdUser();

%>


<div class="row">
    <div class="col-lg-12">

        <div class="card bg-light mb-3" >
            <div class="card-header font-weight-bold">
                <i class="fa fa-archive"></i>
                D4a : Analyse occurence
            </div>
            <div class="card-body w3-white">
                <div class="row">
                    <!--========================================================-->
                    <div class="col-lg-12 ">
                        <div class="card text-white bg-dark mb-3">
                            <div class="card-header">ISHIKAWA POUR L'OCCURRENCE / ISHIKAWA FOR OCCURRENCE</div>
                            <div class="card-body text-white bg-white">

                                <div class="row" >
                                    <div class="col-lg-9" >
                                        <div class="row">
                                            <div class="col-lg-4 ">
                                                <p class="alert alert-dark bg-info text-white">Matiére/Material[1]</p>
                                                <div class="form-group">
                                                    <textarea class="form-control shadow" rows="3"></textarea>
                                                </div>
                                                <center>
                                                    <i class="fa fa-chevron-down text-info" style="font-size:20px;"></i>
                                                </center>
                                            </div>
                                            <div class="col-lg-4  ">
                                                <p class="alert alert-dark bg-warning text-white">Main d'oeuvre/Man[1]</p>
                                                <div class="form-group">
                                                    <textarea class="form-control shadow" rows="3"></textarea>
                                                </div>
                                                <center>
                                                    <i class="fa fa-chevron-down text-warning" style="font-size:20px;"></i>
                                                </center>
                                            </div>
                                            <div class="col-lg-4 ">
                                                <p class="alert alert-dark bg-success text-white">Moyen/Machine[1]</p>
                                                <div class="form-group">
                                                    <textarea class="form-control shadow" rows="3"></textarea>
                                                </div>
                                                <center>
                                                    <i class="fa fa-chevron-down text-success" style="font-size:20px;"></i>
                                                </center>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-11 bg-white">
                                                <hr class="style13">
                                            </div>
                                            <div class="col-1 bg-white">
                                                <center>
                                                    <i class="fa fa-play text-danger" style="font-size:30px;"></i>
                                                </center>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-4 ">
                                                <center>
                                                    <i class="fa fa-chevron-up text-info" style="font-size:20px;"></i>
                                                </center>
                                                <div class="form-group">
                                                    <textarea class="form-control shadow" rows="3"></textarea>
                                                </div>
                                                <p class="alert alert-dark bg-info text-white">Méthode/Method[1]</p>
                                            </div>
                                            <div class="col-lg-4 ">
                                                <center>
                                                    <i class="fa fa-chevron-up text-warning" style="font-size:20px;"></i>
                                                </center>
                                                <div class="form-group">
                                                    <textarea class="form-control shadow" rows="3"></textarea>
                                                </div>
                                                <p class="alert alert-dark bg-warning text-white">Milieu/Environnement[1]</p>
                                            </div>
                                            <div class="col-lg-4 ">
                                                <center>
                                                    <i class="fa fa-chevron-up text-dark" style="font-size:20px;"></i>
                                                </center>
                                                <div class="form-group">
                                                    <textarea class="form-control shadow" rows="3"></textarea>
                                                </div>
                                                <p class="alert alert-dark bg-dark text-white">.........</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-12 align-middle">
                                        <br><br><br><br><br><br>
                                        <p class="alert alert-danger bg-danger text-white">Problème/Problem [2]</p>
                                        <div class="form-group">
                                            <textarea class="form-control shadow" rows="3"></textarea>
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>
                        <div class="card text-white bg-dark mb-3">
                            <div class="card-header">
                                ISHIKAWA POUR L'OCCURRENCE / ISHIKAWA FOR OCCURRENCE
                            </div>
                            <div class="card-body text-white bg-white ">
                                <div class="row">
                                    <!--==================================-->
                                    <!--==================================-->
                                    <div class="col-lg-6 ">
                                        <div class="card mb-3 ">
                                            <div class="card-header text-dark bg-warning shadow">
                                                <small class="form-text font-weight-bold"> 
                                                    5 POURQUOI POUR L'OCCURRENCE : 1er facteur
                                                </small>
                                                <small class="form-text font-weight-bold text-white"> 
                                                    5 WHYS FOR OCCURRENCE : 1rst factor
                                                </small>
                                            </div>
                                            <div class="card-body text-dark bg-white shadow">
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">Cause potentielle 1 / Potential cause 1 [3]</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted"> 1er POURQUOI / 1rst WHY [4]</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">2nd POURQUOI / 2nd WHY [5]</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">3ème POURQUOI / 3rd WHY</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">4ème POURQUOI / 4th WHY</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">5ème POURQUOI / 5th WHY</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                            </div>
                                        </div>
                                    </div>
                                    <!--==================================-->
                                    <!--==================================-->
                                    <div class="col-lg-6 ">
                                        <div class="card mb-3 ">
                                            <div class="card-header text-dark bg-warning shadow">
                                                <small class="form-text font-weight-bold"> 
                                                    5 POURQUOI POUR L'OCCURRENCE : 2er facteur
                                                </small>
                                                <small class="form-text font-weight-bold text-white"> 
                                                    5 WHYS FOR OCCURRENCE : 2nd factor
                                                </small>
                                            </div>
                                            <div class="card-body text-dark bg-white shadow">
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">Cause potentielle 2 / Potential cause 2 [3]</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted"> 1er POURQUOI / 1rst WHY [4]</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">2nd POURQUOI / 2nd WHY [5]</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">3ème POURQUOI / 3rd WHY</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">4ème POURQUOI / 4th WHY</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">5ème POURQUOI / 5th WHY</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                            </div>
                                        </div>
                                    </div>
                                    <!--==================================-->
                                    <!--==================================-->
                                    <div class="col-lg-6 ">
                                        <div class="card mb-3 ">
                                            <div class="card-header text-dark bg-warning shadow">
                                                <small class="form-text font-weight-bold"> 
                                                    5 POURQUOI POUR L'OCCURRENCE : 3ème facteur
                                                </small>
                                                <small class="form-text font-weight-bold text-white"> 
                                                    5 WHYS FOR OCCURRENCE : 3rd factor
                                                </small>
                                            </div>
                                            <div class="card-body text-dark bg-white shadow">
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">Cause potentielle 3 / Potential cause 3 [3]</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted"> 1er POURQUOI / 1rst WHY [4]</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">2nd POURQUOI / 2nd WHY [5]</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">3ème POURQUOI / 3rd WHY</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">4ème POURQUOI / 4th WHY</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">5ème POURQUOI / 5th WHY</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                            </div>
                                        </div>
                                    </div>
                                    <!--==================================-->
                                    <!--==================================-->
                                    <div class="col-lg-6 ">
                                        <div class="card mb-3 ">
                                            <div class="card-header text-dark bg-warning shadow">
                                                <small class="form-text font-weight-bold"> 
                                                    5 POURQUOI POUR L'OCCURRENCE : 4ème facteur
                                                </small>
                                                <small class="form-text font-weight-bold text-white"> 
                                                    5 WHYS FOR OCCURRENCE : 2rd factor
                                                </small>
                                            </div>
                                            <div class="card-body text-dark bg-white shadow">
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">Cause potentielle 4 / Potential cause 4 [3]</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted"> 1er POURQUOI / 1rst WHY [4]</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">2nd POURQUOI / 2nd WHY [5]</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">3ème POURQUOI / 3rd WHY</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">4ème POURQUOI / 4th WHY</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                                <!--================================================-->
                                                <div class="row">
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <small class="form-text text-muted">5ème POURQUOI / 5th WHY</small>
                                                    </div>
                                                    <div class="col-lg-12 col-md-6 col-xs-12 mb-2">
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-sm " >
                                                        </div> 
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--================================================-->
                </div>
            </div>
        </div>
    </div>
</div>
