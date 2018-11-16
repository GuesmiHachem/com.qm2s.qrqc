<%@page import="service.ServiceProblem"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="entity.*"%>
<%
    String id_problem = request.getParameter("id");
    Problem problem = ServiceProblem.find(Integer.parseInt(id_problem));
    ResourceBundle bundle = (ResourceBundle) session.getAttribute("bundle");
%>

<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">



                <button class="btn btn-danger btn-fill btn-wd">Step 2</button>
                <br><br>
                <div class="card ">
                    <div class="card-content ">  
                        <div>

                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="col-lg-3">
                                        <p><b  class="">Date : </b></p>
                                        <p><b  class=""><% out.println(bundle.getString("leader"));%> : </b></p>
                                        <p><b  class=""><% out.println(bundle.getString("deputy"));%> : </b></p>
                                        <br>
                                        <p><b  class=""><% out.println(bundle.getString("guests"));%> : </b></p>
                                    </div>
                                    <div class="col-lg-9 ">
                                        <p>01/21/2008</p>
                                        <p>foulen be foulen</p>
                                        <p><input type="text" class="form-control" placeholder=""></p>
                                        <div class="card btn-default btn-fill">
                                            <div class="bootstrap-tagsinput ">

                                            </div>
                                            <input name="guests" type="text" value="" class="tagsinput" data-role="tagsinput" data-color="success" style="display: none;">

                                        </div>


                                    </div>
                                </div>

                                <div class="col-lg-6 ">
                                    <div class="col-lg-6">

                                        <ul class="w3-ul w3-border">
                                            <li class="btn-github btn-fill"><b><% out.println(bundle.getString("qualite"));%></b></li>
                                            <li>Jill</li>
                                            <li>Eve</li>
                                            <li>Adam</li>
                                        </ul>
                                    </div>
                                    <div class="col-lg-6">
                                        <ul class="w3-ul w3-border">
                                            <li class="btn-github btn-fill"><b><% out.println(bundle.getString("superviseur"));%></b></li>
                                            <li>Jill</li>
                                            <li>Eve</li>
                                            <li>Adam</li>
                                        </ul>
                                    </div>

                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center btn-google btn-fill" >
                                    <h5><% out.println(bundle.getString("nouveau.probleme.de.securite"));%> ?</h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center" >
                                    <p><b>Partie  indicateur </b></p>
                                    <div class="col-lg-6">
                                        <div id="chartHours" class="ct-chart"></div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div id="chartActivity" class="ct-chart"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-4" >
                                    <p><b>Description :</b></p>
                                    <input class="form-control" type="text" placeholder="">
                                </div>
                                <div class="col-lg-4" >
                                    <p><b>Actions :</b></p>
                                    <input class="form-control" type="text" placeholder="">
                                </div>
                                <div class="col-lg-4" >
                                    <p><b>Assignations :</b></p>
                                    <input class="form-control" type="text" placeholder="">
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5><% out.println(bundle.getString("qui.est.ce.que.tu.a.ameliore.hier"));%> ?</h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center" >
                                    <p><b>Detection - Communication - Analysis - Verification, Did we implement a new productivity?</b></p>
                                    <input class="form-control" type="text" placeholder="">
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5><% out.println(bundle.getString("nouveau.probleme"));%></h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12" style="padding:30px">




                                    <!--================================-->
                                    <div class="row card  w3-light-grey">
                                        <div  class="col-lg-3  w3-blue-grey">
                                            <p>0 Km</p>
                                        </div>
                                        <div class="col-lg-9 ">
                                            <input name="n1" type="text" value="" class="tagsinput w3-input" data-role="tagsinput" data-color="success" style="display: none;">
                                        </div>
                                    </div>
                                    <!--================================-->
                                    <div class="row card  w3-light-grey">
                                        <div  class="col-lg-3  w3-blue-grey">
                                            <p>Warranty (Claim-FEW) / 3MIS</p>
                                        </div>
                                        <div class="col-lg-6">
                                            <input name="n2" type="text" value="" class="tagsinput" data-role="tagsinput" data-color="success" style="display: none;">
                                        </div>
                                    </div>
                                    <!--================================-->
                                    <div class="row card  w3-light-grey">
                                        <div  class="col-lg-3  w3-blue-grey">
                                            <p>Customer KPI drift</p>
                                        </div>
                                        <div class="col-lg-6">
                                            <input name="n3" type="text" value="" class="tagsinput" data-role="tagsinput" data-color="success" style="display: none;">
                                        </div>
                                    </div>
                                    <!--================================-->
                                    <div class="row card  w3-light-grey">
                                        <div  class="col-lg-3  w3-blue-grey">
                                            <p>QR/Customer response timing</p>
                                        </div>
                                        <div class="col-lg-6">
                                            <input name="n4" type="text" value="" class="tagsinput" data-role="tagsinput" data-color="success" style="display: none;">

                                        </div>
                                    </div>
                                    <!--================================-->
                                    <div class="row card  w3-light-grey">
                                        <div  class="col-lg-3  w3-blue-grey">
                                            <p>Logistic</p>
                                        </div>
                                        <div class="col-lg-6">
                                            <input name="n5" type="text" value="" class="tagsinput" data-role="tagsinput" data-color="success" style="display: none;">

                                        </div>
                                    </div>
                                    <!--================================-->
                                    <div class="row card  w3-light-grey">
                                        <div  class="col-lg-3  w3-blue-grey">
                                            <p>RPA - Control plan or Process audit - Non respect of S.C.P.</p>
                                        </div>
                                        <div class="col-lg-6">
                                            <input name="n6" type="text" value="" class="tagsinput" data-role="tagsinput" data-color="success" style="display: none;">

                                        </div>
                                    </div>
                                    <!--================================-->
                                    <div class="row card  w3-light-grey">
                                        <div  class="col-lg-3  w3-blue-grey">
                                            <p>Stop Scrap</p>
                                        </div>
                                        <div class="col-lg-6">
                                            <input name="n7" type="text" value="" class="tagsinput" data-role="tagsinput" data-color="success" style="display: none;">

                                        </div>
                                    </div>
                                    <!--================================-->
                                    <div class="row card  w3-light-grey">
                                        <div  class="col-lg-3  w3-blue-grey">
                                            <p>SRM</p>
                                        </div>
                                        <div class="col-lg-6 ">
                                            <input name="n8" type="text" value="" class="tagsinput" data-role="tagsinput" data-color="success" style="display: none;">

                                        </div>
                                    </div>



                                </div>

                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5><% out.println(bundle.getString("deviations"));%>/<% out.println(bundle.getString("derogation"));%></h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center" >
                                    <br>
                                    <div class="form-group">
                                        <input class="form-control" type="text" placeholder="New deviations ? ">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" type="text" placeholder="To be closed this Week ?">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="col-lg-12 btn-github btn-fill" >
                                        <h5><% out.println(bundle.getString("retouche"));%></h5>
                                    </div>
                                    <div class="col-lg-12" >
                                        <br>
                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder=" New Rework ?">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="How many pieces reworked yesterday?">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="Did we remove any rework?">
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-6">
                                    <div class="col-lg-12 btn-github btn-fill" >
                                        <h5><% out.println(bundle.getString("firewall"));%>-<% out.println(bundle.getString("sorting"));%></h5>
                                    </div>
                                    <div class="col-lg-12" >
                                        <br>
                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="New firewall or sorting ?">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder="How many pieces detected yesterday  ?">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="text" placeholder=" Did we remove any firewall or sorting ?">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5><% out.println(bundle.getString("top.3.suite.au.problemes.escaldes"));%></h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12" >
                                    <br>
                                    <table class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>TOPIC DESCRIPTION</th>
                                                <th>Assigment/QR Confirmed in 24 hrs ?</th>
                                                <th>To be Escalated ?</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5>ASSIGMENT SHEET REVIEW (Assignments of yesterday)</h5>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-12 text-center" >
                                    <br>

                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5>Review the PDCA and FTA and challenge the content with facts and data</h5>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-12" >
                                    <br>
                                    <p> Logical Thinking Grid:  (5W2H, Containment, FTA, 5 Why ?  Etc?  ) - Record  VIM N°</p>
                                    <textarea class="form-control" placeholder="" rows="3">
                                           
                                    </textarea>
                                    <br>
                                    <div class="form-group">
                                        <input class="form-control" type="text" placeholder="New Assigments / Comments:       v. Fiche d'assignation">
                                    </div>
                                    <br>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5>WHAT DID YOU LEARN YESTERDAY ?  LLC and Kaizen Card? Can we cross-fertilize ?</h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12" >
                                    <br>
                                    <p> Learn - Share -Keep - Use</p>
                                    <textarea class="form-control" placeholder="" rows="3">
                                           
                                    </textarea>
                                    <br>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5>WHAT DID YOU TEACH YESTERDAY ? OJT / SteDe results ?</h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12" >
                                    <br>
                                    <p> Explain - Demonstrate - Request - Confirm</p>
                                    <textarea class="form-control" placeholder="" rows="3">
                                           
                                    </textarea>
                                    <br>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5>CONGRATULATIONS TO THE TEAM ( Welcome the new problems, VIM closure ? )</h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12" >
                                    <br>
                                    <textarea class="form-control" placeholder="" rows="3">
                                           
                                    </textarea>
                                    <br>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5>GENBA: WHAT DID YOU OBSERVE ? </h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12" >
                                    <br>
                                    <p> Check Evidence (when not clear in QRQC)  Or LLC Or Corrective action effectiveness Or??. On Genba</p>
                                    <textarea class="form-control" placeholder="" rows="3">
                                           
                                    </textarea>
                                    <br>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5>QRQC OJT  (Check list Assessment & action)</h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12" >
                                    <br>
                                    <table class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Who</th>
                                                <th>New Results</th>
                                                <th>Comments</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-lg-12   ">
                                    <div class="form-group">
                                        <button style="border-radius: 5px" type="submit" class="btn btn-fill btn-github"><% out.println(bundle.getString("envoyer"));%></button>
                                        <button style="border-radius: 5px" type="reset" class="btn btn-fill btn-google"><% out.println(bundle.getString("annuler"));%></button>

                                    </div>


                                </div>
                            </div> 

                        </div>
                    </div>
                </div>

            </div>
        </div><!--  end card  -->
    </div> <!-- end col-md-12 -->
</div> <!-- end row -->

