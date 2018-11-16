<%@page import="entity.*"%>
<%@page import="service.*"%>
<%@page import="domaine.Design"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ResourceBundle"%>


<% try {%>

<div class="content " >
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">

                <div class="<%=Design.card%> ">
                    <div class="card-content">
                        <!--================================================-->
                        <div class="row">



                            <div class="col-lg-12 ">
                                <nav aria-label="breadcrumb" class="" > 
                                    <ol class="breadcrumb w3-green w3-text-white">
                                        <li class="breadcrumb-item"><a class="w3-text-white" href="<%=application.getContextPath()%>/Level">List des activités</a></li>
                                    </ol>
                                    
                                    <form action="<%=application.getContextPath()%>/Level" method="post">
                                        <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                    return true;
                                                } else {
                                                    return false;
                                                }" style="border-radius: 5px;margin:3px;" name="deleteAll" type="submit" class="<%=Design.btn%>  fa fa-trash"> 
                                        </button>
                                        <button disabled style="border-radius: 5px;margin:3px;" name="renameLevel" type="button" class=" <%=Design.btn%> fa fa-edit"> 
                                        </button>
                                        <button data-toggle="modal" data-target="#addLevel" style="border-radius: 5px;margin:3px;" name="addLevel" type="button" class="<%=Design.btn%>   fa fa-plus"> 
                                        </button>
                                    </form>
                                        
                                </nav>

                                <br>
                                <div class="<%=Design.containerTitle%>">
                                    <h3 class="<%=Design.textNormal%>">Niveau 3</h3>
                                </div>
                                <div class="<%=Design.container%>">
                                    <br>
                                    <div class="<%=Design.cadreTable%>">
                                        <table class="<%=Design.table%>" cellspacing="0" width="100%" style="width:100%">
                                            <thead>
                                                <tr class="w3-light-gray w3-text-dark-gray">
                                                    <th></th>
                                                    <th>Nom</th>
                                                    <th>Taille</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% List<Level3> listLevel31 = ServiceLevel3.findAll(); %>
                                                <% for (Level3 l : listLevel31) {%>
                                                <tr>
                                                    <td><%=l.getId()%></td>
                                                    <td><%=l.getName()%></td>
                                                    <td><%=l.getLevel2List().size()%></td>
                                                    <td>

                                                        <form action="<%=application.getContextPath()%>/Level" method="post" class="form-horizontal">
                                                            <input hidden style="margin:3px;" name="idLevel" type="text" class="w3-hide" placeholder="" value="<%=l.getId()%>">
                                                            <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                                        return true;
                                                                    } else {
                                                                        return false;
                                                                    }" name="deleteLevel" type="submit" class="<%=Design.btn%>  w3-hover-red fa fa-trash"> 
                                                            </button>
                                                            <a href="<%=application.getContextPath()%>/L3?id=<%=l.getId()%>" class="<%=Design.btn%> w3-hover-green fa fa-eye"> 
                                                            </a>
                                                        </form>

                                                    </td>

                                                </tr>
                                                <% }%>
                                            </tbody>
                                        </table>
                                    </div>
                                    <br>
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

<% } catch (Exception ex) {
        response.sendRedirect("level.jsp");
    }%>



<div class="modal fade" id="addLevel" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body bg-white">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br><br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">Ajouter un niveau <star> *</star></h3>
                </div>
                <div class="<%=Design.container%>">
                    <form action="<%=application.getContextPath()%>/Level" method="post">

                        <div class="card-content">
                            <div class="form-group">
                                <br>
                                <input class="w3-input w3-border w3-border-grey w3-round" name="nameLevel" type="text" required="true" email="true" autocomplete="off" aria-required="true" required>
                            </div>
                        </div>
                        <button name="addLevel" type="submit" class="<%=Design.btn%>">Ajouter</button>
                        <button  type="reset" class="<%=Design.btn%>">Annuler</button>

                    </form> 
                    <br>
                </div>



            </div> 
        </div>
    </div>
</div>  


