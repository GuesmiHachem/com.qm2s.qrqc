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
                D5 : Plan d'actions
            </div>
            <div class="card-body w3-white">
                <div class="row">                 
                    <div class="row">
                        <div class="col-12">
                            <div class="row">
                                <div class="col-lg-12 ">


                                    <div class="card text-white bg-dark border border-dark mb-3">
                                        <div class="card-header text-dark bg-warning font-weight-bold">
                                            PLAN D'ACTION CONTRE L'OCCURRENCE / ACTION PLAN AGAINST OCCURRENCE
                                        </div>
                                        <small class="form-text text-danger alert-dark font-weight-bold ">
                                            Pour chaque cause racine d'apparition du défaut, définir les actions correctives qui permettront de la corriger / For each occurrence root cause, define the corrective actions which will correct it
                                        </small>
                                        <table class="table table-hover table-sm table-responsive-lg table-responsive-md table-responsive bg-white">
                                            <tr class="bg-dark text-white font-weight-bold ">
                                                <td>
                                                    <small>CAUSE RACINE / ROOT CAUSE [1]</small>	
                                                </td>
                                                <td  >
                                                    <small>ACTION CORRECTIVE / CORRECTIVE ACTION [2]</small>							
                                                </td>
                                                <td > 
                                                    <small>QUI / WHO ? [3]</small>							
                                                </td>
                                                <td >
                                                    <small>Date prévue / Scheduled date [4]</small>						
                                                </td >
                                                <td >
                                                    <small>Date réalisé / Closing date [5]</small>	
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                            </tr>
                                        </table>
                                    </div>






                                    <div class="card text-white bg-dark border border-dark mb-3">
                                        <div class="card-header text-dark bg-warning font-weight-bold">
                                            PLAN D'ACTION CONTRE LA NON DETECTION / ACTION PLAN AGAINST NON DETECTION
                                        </div>
                                        <small class="form-text text-danger alert-dark font-weight-bold ">
                                            Pour chaque cause racine de non détection du défaut, définir les actions correctives qui permettront de la corriger / For each non detection root cause, define the corrective actions which will correct it							
                                        </small>
                                        <table class="table table-hover table-sm table-responsive-lg table-responsive-md table-responsive bg-white">
                                            <tr class="bg-dark text-white font-weight-bold ">
                                                <td>
                                                    <small>CAUSE RACINE / ROOT CAUSE [1]</small>	
                                                </td>
                                                <td  >
                                                    <small>ACTION CORRECTIVE / CORRECTIVE ACTION [2]</small>							
                                                </td>
                                                <td > 
                                                    <small>QUI / WHO ? [3]</small>							
                                                </td>
                                                <td >
                                                    <small>Date prévue / Scheduled date [4]</small>						
                                                </td >
                                                <td >
                                                    <small>Date réalisé / Closing date [5]</small>	
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <textarea class="" rows="2"></textarea>
                                                    </div>	
                                                </td>
                                            </tr>
                                        </table>
                                    </div>


                                    <!--==============================-->
















                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

