<%@page import="entity.Hardware"%>
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



<!-- card  -->   
<div class="card w3-white w3-border-grey w3-border">
    <div class="card-content ">
        <!--================================================-->
        <div class="row ">
            <div class="col-lg-12 ">

                <!--====================================================================-->
                <div class="<%=Design.containerTitle%>">
                    <div class="col-xs-5">
                        <h3 class="<%=Design.textNormal%>">Liste des appareils</h3>
                    </div>
                    <div class=" w3-right">
                        <form action="<%=application.getContextPath()%>/SAdmin" method="post">
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
                                    <th>Niveau 1</th>
                                    <th>Date de creation</th>
                                    <th>Active</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <% List<Hardware> listHardware = ServiceHardware.findAll(); %>
                                <% for (Hardware hardware : listHardware) {%>
                                <tr>
                                    <td ><%=hardware.getId()%></td>
                                    <td><%=hardware.getName()%></td>
                                    <td><%=hardware.getIdLevel1().getName()%></td>
                                    <td><%=hardware.getDateCreation().toLocaleString()%></td>
                                    <td>
                                        <%
                                            if (hardware.getActive()) {
                                                out.println("Oui");
                                            } else {
                                                out.println("Non");
                                            }
                                        %>
                                    </td>
                                    <td>
                                        <form class="form-horizontal " action="<%=application.getContextPath()%>/SAdmin" method="post">
                                            <input hidden style="margin:3px;" name="idHardware" type="text" class="w3-hide" placeholder="" value="<%=hardware.getId()%>">
                                            <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                        return true;
                                                    } else {
                                                        return false;
                                                    }" name="deleteHardware" type="submit" class="ui button ">
                                                        <i class="fa fa-close w3-text-pink"></i>
                                            </button>

                                            <%if (hardware.getActive()) {%>
                                            <button type="submit" name="desactiver" class="negative ui button">Desactiver</button>
                                            <% } else {%>
                                            <button type="submit" name="activer" class="positive ui button">Activer</button>
                                            <%}%>


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


<%} catch (Exception ex) {
        // response.sendRedirect("level.jsp");
    }%>


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


