
<%@page import="java.util.ResourceBundle"%>
<%@page import="model.*"%>
<%
    Problem problem = (Problem) session.getAttribute("problem");
    ResourceBundle bundle = (ResourceBundle) session.getAttribute("bundle");
%>
<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">



                <button class="btn btn-danger btn-fill btn-wd">Step 3</button>
                <br><br>
                <div class="card ">
                    <div class="card-content ">  
                        <div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="col-lg-3">
                                        <p><b  class="">Date : </b></p>
                                        <p><b  class="">Leader : </b></p>
                                        <p><b  class="">Deputy : </b></p>
                                        <br>
                                        <p><b  class="">Guests : </b></p>
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




                            <!--===============================================
                            
                            NEW SAFETY ISSUE ?
                            
                            ================================================-->

                            <div class="row">
                                <div class="col-lg-12 text-center btn-google btn-fill" >
                                    <h5>NEW SAFETY ISSUE ?</h5>
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


                            <!--===============================================
                            
                            Nouvelle  Productivité WHAT DID YOU IMPROVE YESTERDAY ?
                            
                            ================================================-->

                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5>Nouvelle  Productivité WHAT DID YOU IMPROVE YESTERDAY ?</h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center" >
                                    <p><b>Detection - Communication - Analysis - Verification, Did we implement a new productivity?</b></p>
                                    <textarea class="form-control" placeholder="" rows="3">
                                            
                                    </textarea>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12" >
                                    <br>
                                    <table class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>NEW ISSUES (incident /SRM/RED ALERT) ?</th>
                                                <th>UAP  1</th>
                                                <th>UAP  2</th>
                                                <th>UAP  3</th>
                                                <th>UAP  4</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td> incident  0 Km</td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td> Incident garantie</td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td> Incident Logistic</td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td> Stop Scrap</td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td> Incident  fournisseur </td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>

                            <!--===============================================
                           
                           Dérogation DEVIATIONS
                           
                           ================================================-->


                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5> Dérogation DEVIATIONS</h5>
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


                            <!--===============================================
                           
                           Retouche / Rework      Tri /Firewall - Sorting
                           
                           ================================================-->

                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="col-lg-12 btn-github btn-fill" >
                                        <h5> Retouche / Rework</h5>
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
                                        <h5>Tri /Firewall - Sorting</h5>
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


                            <!--===============================================
                           
                           Top 3  escaldé à partir de QRQC step 2 
                           
                           ================================================-->



                            <div class="row">
                                <div class="col-lg-12 text-center btn-warning btn-fill" >
                                    <h5>Top 3  escaldé à partir de QRQC step 2 </h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12" >
                                    <br>
                                    <table class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>UAP  1</th>
                                                <th>UAP  2</th>
                                                <th>UAP  3</th>
                                                <th>UAP  4</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>


                            <!--===============================================
                            
                            ESCALATION FROM OTHER QRQC (APU ?)
                            
                            ================================================-->

                            <div class="row">
                                <div class="col-lg-6 text-center btn-github btn-fill" >
                                    <h5>ESCALATION FROM OTHER QRQC (APU ?)</h5>
                                </div>
                                <div class="col-lg-6" >
                                    <div class="form-group">
                                        <input class="form-control" type="text" placeholder="">
                                    </div>
                                </div>
                            </div>



                            <!--===============================================
                            
                            ASSIGMENT SHEET REVIEW (Assignments of yesterday)
                            
                            ================================================-->

                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5>ASSIGMENT SHEET REVIEW (Assignments of yesterday)</h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12" >
                                    <br>
                                    Fiche d'assignation 
                                </div>
                            </div>




                            <!--===============================================
                            
                            Review the 8D and challenge the content with facts and data
                            
                            ================================================-->

                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5>Review the 8D and challenge the content with facts and data</h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center" >
                                    <br>
                                    <div class="form-group">
                                        <input class="form-control" type="text" placeholder="Logical Thinking Grid:  (5W2H, Containment, Ishikawa , 5 Why ?  Etc?  ) -">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" type="text" placeholder="New Assigments / Comments:">
                                    </div>
                                </div>
                            </div>





                            <!--===============================================
                            
                            WHAT DID YOU LEARN YESTERDAY ?  LLC and Kaizen Card? Can we cross-fertilize ?
                            
                            ================================================-->

                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5>WHAT DID YOU LEARN YESTERDAY ?  LLC and Kaizen Card? Can we cross-fertilize ?</h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center" >
                                    <br>
                                    <div class="form-group">
                                        <input class="form-control" type="text" placeholder="Learn - Share -Keep - Use">
                                    </div>
                                </div>
                            </div>






                            <!--===============================================
                            
                            WHAT DID YOU TEACH YESTERDAY ? OJT 
                            
                            ================================================-->

                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5>WHAT DID YOU TEACH YESTERDAY ? OJT </h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center" >
                                    <br>
                                    <div class="form-group">
                                        <input class="form-control" type="text" placeholder="Explain - Demonstrate - Request - Confirm">
                                    </div>
                                </div>
                            </div>




                            <!--===============================================
                            
                            CONGRATULATIONS TO THE TEAM (Welcome the new problems, VIM closure ? )
                            
                            ================================================-->

                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5>CONGRATULATIONS TO THE TEAM (Welcome the new problems, VIM closure ? )</h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center" >
                                    <br>
                                    <div class="form-group">
                                        <input class="form-control" type="text" placeholder="">
                                    </div>
                                </div>
                            </div>



                            <!--===============================================
                            
                            GENBA: WHAT DID YOU OBSERVE ? 
                            
                            ================================================-->

                            <div class="row">
                                <div class="col-lg-12 text-center btn-github btn-fill" >
                                    <h5>GENBA: WHAT DID YOU OBSERVE ? </h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-center" >
                                    <br>
                                    <div class="form-group">
                                        <input class="form-control" type="text" placeholder="Check Evidence (when not clear in QRQC)  Or LLC Or Corrective action effectiveness Or??. On Genba">
                                    </div>
                                </div>
                            </div>


                            <!--===============================================
                            
                            QRQC OJT  (Check list Assessment & Actions)
                            
                            ================================================-->

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

