<%@page import="domaine.Design"%>
<%@page import="entity.Nature"%>
<%@page import="service.*"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ResourceBundle"%>


<% try {%>


<%


%>



<div class="content " >
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <!-- card  -->   
                <div class="card w3-white w3-border-grey w3-border">
                    <div class="card-content ">
                        <!--================================================-->
                        <div class="row ">
                            <div class="col-lg-12 ">

                                <!--====================================================================-->
                                <div class="<%=Design.containerTitle%>">
                                    <div class="col-xs-5">
                                        <h3 class="<%=Design.textNormal%>">Liste des natures</h3>
                                    </div>
                                    <div class="w3-right">
                                        <button data-toggle="modal" data-target="#addNature" style="border-radius: 5px;margin:3px;" name="addNature" type="button" class="<%=Design.btn%> w3-hover-white ti-plus"> 
                                        </button>
                                    </div>
                                    <div class=" w3-right">
                                        <form action="<%=application.getContextPath()%>/ListNature" method="post">
                                            <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                        return true;
                                                    } else {
                                                        return false;
                                                    }" style="border-radius: 5px;margin:3px;" name="destroyAll" type="submit" class="<%=Design.btn%> w3-hover-white ti-trash"> 
                                            </button>
                                        </form>
                                    </div>

                                </div>
                                <div class="<%=Design.container%>">
                                    <br>
                                    <div class="<%=Design.cadreTable%>">
                                        <table class="<%=Design.table%>" cellspacing="0" width="100%" style="width:100%">
                                            <thead>
                                                <tr class="w3-light-gray w3-text-dark-gray">
                                                    <th>ID</th>
                                                    <th>Nom</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% List<Nature> listNature = ServiceNature.findAll(); %>
                                                <% for (Nature nature : listNature) {%>
                                                <tr>
                                                    <td ><%=nature.getId()%></td>
                                                    <td><%=nature.getName()%></td>
                                                    <td>
                                                        <form class="form-horizontal " action="<%=application.getContextPath()%>/ListNature" method="post">
                                                            <input hidden style="margin:3px;" name="idNature" type="text" class="w3-hide" placeholder="" value="<%=nature.getId()%>">
                                                            <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                                        return true;
                                                                    } else {
                                                                        return false;
                                                                    }" name="deleteNature" type="submit" class="<%=Design.btn%> w3-hover-pink ti-minus"> 
                                                            </button>
                                                            <a href="<%=application.getContextPath()%>/Nature?id=<%=nature.getId()%>" class="<%=Design.btn%> w3-hover-light-green ti-eye"> 
                                                            </a>
                                                        </form>
                                                    </td>
                                                </tr>
                                                <% }
                                                %>
                                            </tbody>
                                        </table>
                                    </div>
                                    <br>
                                </div>

                            </div>
                        </div>


                    </div>
                </div>
                <!-- fin card  -->               
            </div>
        </div>
    </div> 
</div> 


<%} catch (Exception ex) {
        // response.sendRedirect("level.jsp");
    }%>

<!--####################################################################
    #                                                                  #
    #                        Ajouter Nature                            #
    ####################################################################-->

<div class="modal fade" id="addNature" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog  modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body bg-white">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br><br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">Ajouter Nature</h3>    
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form  name="f1" action="<%=application.getContextPath()%>/ListNature" method="post" >

                        <div class="card-content">
                            <div class="form-group">
                                <br>
                                <p class="<%=Design.textNormal%>">Nom </p>    
                                <input class="<%=Design.inputText%>" name="nameNature" type="text" required="true" >
                            </div>
                        </div>

                        <button style="border-radius: 5px;" name="addNature" type="submit" class="<%=Design.btn%>">Ajouter</button>
                        <button style="border-radius: 5px;" type="reset" class="<%=Design.btn%>">Annuler</button>


                    </form>
                    <br>
                </div>

            </div> 
        </div>
    </div>
</div> 

<script>
    function loadDoc() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("demo").innerHTML =
                        this.responseText;
            }
        };
        var idTypeUser = document.getElementById("idTypeUser");
        var idTypeUser = idTypeUser.options[idTypeUser.selectedIndex].value;
        xhttp.open("GET", "../ajax/demo.jsp?idTypeUser=" + idTypeUser, true);
        xhttp.send();
    }
</script>


