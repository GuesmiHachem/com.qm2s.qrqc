<%@page import="domaine.Design"%>
<%@page import="entity.*"%>
<%@page import="service.*"%>

<%@page import="java.util.List"%>

<%
    Nature nature = (Nature) request.getAttribute("nature");
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
                                <h3 class="<%=Design.textNormal%>">Modifier nature</h3>
                            </div>
                            <div class="w3-right">
                                <button  onclick="document.location.href = 'ListNature'" style="border-radius: 5px;margin:3px;"  type="button" class="<%=Design.btn%> ti-view-list"> 
                                </button>
                            </div>

                        </div>
                        <div class="<%=Design.container%>">
                            <br>
                            <form  name="f1" action="" method="post" >

                                <div class="card-content">
                                    <div class="form-group">
                                        <h5 class="">
                                            Nom du Nature
                                        </h5>
                                        <input class="w3-input w3-border w3-border-grey w3-round " name="nameNature" type="text" required="true" value="<%=nature.getName()%>">
                                    </div>
                                </div>

                                <button style="border-radius: 5px;" name="updateNature" type="submit" class="<%=Design.btn%>">Modifier</button>
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
        response.sendRedirect("listNatureProcessus.jsp");
    }%>
