<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="domaine.Design"%>
<%@page import="domaine.Design"%>
<%@page import="entity.*"%>
<%@page import="service.*"%>

<%@page import="java.util.List"%>






<div class="content w3-light-gray">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">

                <div class="card w3-white w3-border-grey w3-border">
                    <div class="card-content">
                        <!--================================================-->
                        <div class="row">
                            <div class="col-lg-12">

                                <div class="<%=Design.containerTitle%>">
                                    <div class="col-xs-5">
                                        <h3 class="<%=Design.textNormal%>">Liste rang des equipes</h3>
                                    </div>
                                    <div class="w3-right">
                                        <button data-toggle="modal" data-target="#addRankTeam" style="border-radius: 5px;margin:3px;" name="addRankTeam" type="button" class="<%=Design.btn%> w3-hover-white ti-plus"> 
                                        </button>
                                    </div>
                                    <div class=" w3-right">
                                        <form action="<%=application.getContextPath()%>/ListRankTeam" method="post">
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
                                    <table  class="<%=Design.table%>" cellspacing="0" width="100%" style="width:100%">
                                        <thead>
                                            <tr class="w3-light-gray">
                                                <th>#</th>
                                                <th>Nom</th>
                                                <th>StartTime</th>
                                                <th>EndTime</th>
                                                <td class="disabled-sorting" ></td>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                List<RankTeam> listRankTeam = ServiceRankTeam.findAll();
                                                for (RankTeam rankTeam : listRankTeam) {
                                                    DateFormat sdf = new SimpleDateFormat("HH:mm");
                                            %>
                                            <tr>
                                                <td><%=rankTeam.getId()%></td>
                                                <td><%=rankTeam.getName()%></td>
                                                <td><%=sdf.format(rankTeam.getStartTime())%></td>
                                                <td><%=sdf.format(rankTeam.getEndTime())%></td>
                                                <td>
                                                    <form class="form-horizontal " action="" method="post">
                                                        <input hidden style="margin:3px;" name="idRankTeam" type="text" class="w3-hide" placeholder="" value="<%=rankTeam.getId()%>">
                                                        <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                                                    return true;
                                                                } else {
                                                                    return false;
                                                                }" name="deleteRankTeam" type="submit" class="<%=Design.btn%> w3-hover-pink ti-minus"> 
                                                        </button>
                                                        <a href="RankTeam?id=<%=rankTeam.getId()%>" class="<%=Design.btn%> w3-hover-light-green ti-eye"> 
                                                        </a>
                                                    </form>

                                                </td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                    </table>
                                </div>


                            </div>
                        </div>
                        <br>

                    </div>
                </div><!--  end card  -->
            </div> <!-- end col-md-12 -->
        </div> <!-- end row -->
    </div>
</div>

<div class="modal fade" id="addRankTeam" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog  modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body bg-white">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span class="w3-text-black" aria-hiddenx="true">&times;</span>
                </button>
                <br><br>
                <div class="<%=Design.containerTitle%>">
                    <h3 class="<%=Design.textTitle%>">Ajouter un rang d'equipe</h3>
                </div>
                <div class="<%=Design.container%>">
                    <br>
                    <form  name="f1" action="<%=application.getContextPath()%>/ListRankTeam" method="post" >

                        <div class="card-content">
                            <div class="form-group">
                                <p class="<%=Design.textNormal%>">Nom </p>

                                <input class="w3-input w3-border w3-border-grey w3-round" name="nameRankTeam" type="text" required="true" email="true" autocomplete="off" aria-required="true">
                            </div>

                            <div class="form-group">
                                <p class="<%=Design.textNormal%>">StartTime</p>
                                <input class="w3-input w3-border w3-border-grey w3-round " name="startTimeRankTeam" type="time" required="true" value="">
                            </div>
                            <div class="form-group">
                                <p class="<%=Design.textNormal%>">EndTime</p>
                                <input class="w3-input w3-border w3-border-grey w3-round " name="endTimeRankTeam" type="time" required="true" value="">
                            </div>

                            <button style="border-radius: 5px;" name="addRankTeam" type="submit" class="<%=Design.btn%>">Ajouter</button>
                            <button style="border-radius: 5px;" type="reset" class="<%=Design.btn%>">Annuler</button>
                        </div>

                    </form>
                    <br>
                </div>


            </div> 
        </div>
    </div>
</div>  

