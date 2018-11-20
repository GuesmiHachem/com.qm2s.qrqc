<%@page import="model.*"%>
<%@page import="service.*"%>

<%@page import="domaine.Design"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ResourceBundle"%>
<%
    Problem problem = (Problem) session.getAttribute("problem");
    Step1 step1 = (Step1) session.getAttribute("step1");
    ResourceBundle bundle = (ResourceBundle) session.getAttribute("bundle");
    List<Step1Part3> listStep1part3 = (List<Step1Part3>) session.getAttribute("listStep1part3");
    
%>
<%
    if (listStep1part3 == null) {
        listStep1part3 = new ArrayList<Step1Part3>();
        session.setAttribute("listStep1part3", listStep1part3);
    }
%>

<div class="content w3-light-gray">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">


                <div class="card w3-white w3-border w3-border-grey">
                    <div class="card-content ">

                        <div class="w3-round w3-light-blue w3-padding">
                            <div class="row">
                                <div class="col-lg-3 ">
                                    <p class="w3-large w3-borderd w3-white w3-round-large w3-padding-small"><% out.println(bundle.getString("probleme"));%>  </b></p>
                                </div>
                                <div class="col-lg-3 ">
                                    <p class="w3-large w3-borderd w3-white w3-round-large w3-padding-small">N° :<%=problem.getNum()%></p>
                                </div>
                                <div class="col-lg-3">
                                    <p class="w3-large w3-borderd w3-white w3-round-large w3-padding-small">Code : <%=problem.getCode()%></p>
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="<%=Design.containerTitle%>">
                            <h2 class="<%=Design.textTitle%>">Analyse et actions définitives</h2>
                        </div>
                        <div class="<%=Design.container%>">
                            <div class="row">
                                <div class="col-lg-12">
                                    <br>
                                    <!-- Button trigger modal -->
                                    <button   type="button" class="<%=Design.btn%>" data-toggle="modal" data-target="#exampleModal">
                                        Ajouter
                                    </button>
                                    <br><br>                                 
                                    <% if (listStep1part3 != null) {%> 
                                    <div class="<%=Design.cadreTable%>">
                                        <table  class="<%=Design.table%>" cellspacing="0" width="100%" style="width:100%">
                                            <thead>
                                                <tr class="">
                                                    <th class="" scope="col">#</th>
                                                    <th class="" scope="col">Pourquoi ?</th>
                                                    <th class="" scope="col">Action ?</th>
                                                    <th class="" scope="col">Qui ?</th>
                                                    <th class="" scope="col">Quand ?</th>
                                                    <th class="" scope="col">Commentaire</th>
                                                    <th class="" scope="col">Supprimer</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    for (int i = 0; i < listStep1part3.size(); i++) {

                                                        Step1Part3 step1part3 = listStep1part3.get(i);
                                                %>
                                                <tr>
                                                    <td><%=(i + 1)%></td>
                                                    <td><%=step1part3.getWhy_()%></td>
                                                    <td><%=step1part3.getAction()%></td>
                                                    <td><%=step1part3.getWho_()%></td>
                                                    <td><%=step1part3.getWhen_()%></td>
                                                    <td><%=step1part3.getComment()%></td>
                                                    <td>

                                                        <form action="<%=application.getContextPath()%>/CreateS1P3" method="post">
                                                            <input hidden name="hashcode" type="text" value="<%= step1part3.hashCode()%>">
                                                            <button style="border-radius: 5px" name="removePlan" type="submit"   rel="tooltip" title="" class="w3-white w3-round w3-text-red" data-original-title="Remove">
                                                                <i class="ti-close"></i>
                                                            </button>
                                                        </form>

                                                    </td>
                                                </tr>
                                                <%
                                                    }

                                                %>
                                                <%                                                    for (int i = listStep1part3.size(); i < 5; i++) {
                                                %>
                                                <tr>
                                                    <td><%=(i + 1)%></td>
                                                    <td></td>
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
                                    <br>
                                </div> 
                            </div>
                            <!--======================================================-->
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="form-group">

                                        <form action="<%=application.getContextPath()%>/CreateS1P3" method="post">
                                            <button style="border-radius: 5px" name="S1P3" type="submit"  class="<%=Design.btn%>">
                                                finir
                                            </button>
                                        </form>
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
                    <h3 class="<%=Design.textTitle%>">Analyse et actions définitives</h3>
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form method="post" action="<%=application.getContextPath()%>/CreateS1P3">
                        <div class="card-content">
                            <div class="form-group">
                                <label>Pourquoi ?</label><star> *</star>
                                <input name="pourquoi" type="text" placeholder="" class="w3-input w3-border w3-border-grey w3-round" required>
                            </div>
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

                            <button style="border-radius: 5px" type="submit" class="<%=Design.btn%>" name="AddAction" >Ajouter</button>
                            <button style="border-radius: 5px" type="reset" class="<%=Design.btn%>">Annuler</button>
                        </div>
                    </form>
                    <br>
                </div>




            </div>
            <div class="modal-footer">
                <!--<button style="border-radius: 5px" class="btn btn-dribbble" type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>-->
            </div>
        </div>
    </div>
</div>
