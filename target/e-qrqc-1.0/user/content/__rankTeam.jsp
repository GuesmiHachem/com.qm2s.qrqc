<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="entity.*"%>
<%@page import="service.*"%>

<%@page import="domaine.Design"%>
<%@page import="java.util.List"%>

<%
    String idRankTeam=request.getParameter("id");
    entity.RankTeam rankTeam = ServiceRankTeam.find(Integer.parseInt(idRankTeam));
%>

<% try {%>


<div class="content w3-light-gray">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">

                <div class="card w3-white w3-border-grey w3-border">
                    <div class="card-content">

                        <div class="<%=Design.containerTitle%>">
                            <div class="col-xs-5">
                                <h3 class="<%=Design.textNormal%>">Modifier rang d'equipe</h3>
                            </div>
                            <div class="w3-right">
                                <button  onclick="document.location.href = 'ListRankTeam'" style="border-radius: 5px;margin:3px;"  type="button" class="<%=Design.btn%> ti-view-list"> 
                                </button>
                            </div>

                        </div>
                        <div class="<%=Design.container%>">
                            <br>
                            <%
                            DateFormat sdf = new SimpleDateFormat("HH:mm");
                            %>
                            <form  name="f1" action="" method="post" >

                                <div class="card-content">
                                    <div class="form-group">
                                        <p class="<%=Design.textNormal%>">Nom de type</p>
                                        <input class="w3-input w3-border w3-border-grey w3-round " name="nameRankTeam" type="text" required="true" value="<%=rankTeam.getName()%>">
                                    </div>
                                    <div class="form-group">
                                        <p class="<%=Design.textNormal%>">StartTime</p>
                                        <input class="w3-input w3-border w3-border-grey w3-round " name="startTimeRankTeam" type="time" required="true" value="<%=sdf.format(rankTeam.getStartTime())%>">
                                    </div>
                                    <div class="form-group">
                                        <p class="<%=Design.textNormal%>">EndTime</p>
                                        <input class="w3-input w3-border w3-border-grey w3-round " name="endTimeRankTeam" type="time" required="true" value="<%=sdf.format(rankTeam.getEndTime())%>">
                                    </div>
                                </div>

                                <button style="border-radius: 5px;" name="updateRankTeam" type="submit" class="<%=Design.btn%>">Modifier</button>
                                <button style="border-radius: 5px;" type="reset" class="<%=Design.btn%>">Annuler</button>


                            </form>
                            <br>
                        </div>       

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%} catch (Exception ex) {
        response.sendRedirect("listUser.jsp");
    }%>
