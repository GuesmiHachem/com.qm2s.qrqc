<%-- 
    Document   : problem_comment
    Created on : 28 sept. 2018, 13:48:23
    Author     : Hachem
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="entity.*"%>
<%@page import="service.*"%>


<%@page import="domaine.Design"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
    //List<Step1> listStep1 = new ArrayList<Step1>();
    User userContent_ajax = (User) session.getAttribute("user");
    String id_problem_ajax = request.getParameter("id");
    Problem problem_ajax = ServiceProblem.find(Integer.parseInt(id_problem_ajax));

    Step1 step1_ajax = problem_ajax.getIdStep1();

    List<Step1Comment> listStep1Comment_ajax = step1_ajax.getStep1CommentList();


%>
<div class="col-lg-12">
    <div class="card">
        <div class="card-header">
            <p class=" ti-comment"> <%=step1_ajax.getStep1CommentList().size()%> Commentaires</p>
        </div>  
    </div>
    <br>
</div>


<br>

<%        for (int i = listStep1Comment_ajax.size() - 1; i >= 0; i--) {
        Step1Comment step1Comment_ajax = listStep1Comment_ajax.get(i);
        User userComment_ajax = step1Comment_ajax.getIdUser();
        String comment_ajax = step1Comment_ajax.getComment();
%>

<% if (userComment_ajax.getIdTypeUser() != null) {%>
<% if (userComment_ajax.getIdLevel0() != null) {%>
<div class="col-lg-12">

    <% if (userComment_ajax.equals(userContent_ajax)) {%>
    <div class="row">
        <div class="col-lg-6 col-12">
            <div class="card mb-3 " >
                <div class="card-body">
                    <div class="row">
                        <div class="col-lg-2 col-3">
                            <img width="80px" height="80px" class="photo w3-image w3-circle" src="<%=application.getContextPath()%>/img/profile/<%=userComment_ajax.getPicture()%>">
                        </div>
                        <div class="col-lg-10 col-9">
                            <a class="w3-large"><%=userComment_ajax.getFirstName() + " " + userComment_ajax.getName()%></a>
                            <p class="w3-text-blue"> <%=userComment_ajax.getIdTypeUser().getName()%>
                                <small class="w3-text-grey"><%=step1Comment_ajax.getDateCreation().toLocaleString().substring(0, 13)%></small>
                                <small class="w3-text-grey"> <%=step1Comment_ajax.getDateCreation().toLocaleString().substring(13)%></small>
                            </p>
                            <div class="description">
                                <p><%=comment_ajax%></p>
                            </div>
                            <div class="extra">
                                <button type="button" class="btn btn-sm w3-white" data-toggle="modal" data-target="#comment<%=step1Comment_ajax.getId()%>"  >
                                    <i class="w3-text-blue fa fa-edit"></i>
                                </button>
                                <button  type="button" class="btn btn-sm  w3-white" name="deleteComment" onclick="_deleteStep1Comment(<%=step1Comment_ajax.getId()%>)">
                                    <i class="w3-text-pink fa fa-close"></i>
                                </button>
                            </div> 
                        </div>
                    </div>
                </div>            
            </div>
        </div>
    </div>                     
    <%} else {%>
    <div class="row">
        <div class="col-lg-6 col-12">
            <div class="card bg-light mb-3">
                <div class="card-body">
                    <div class="row">
                        <div class="col-lg-2 col-3">
                            <img width="80px" height="80px" class="photo w3-image w3-circle" src="<%=application.getContextPath()%>/img/profile/<%=userComment_ajax.getPicture()%>">
                        </div>
                        <div class="col-lg-10 col-9">
                            <a class="w3-large"><%=userComment_ajax.getFirstName() + " " + userComment_ajax.getName()%></a>
                            <p class="w3-text-blue"> <%=userComment_ajax.getIdTypeUser().getName()%>
                                <small class="w3-text-grey"><%=step1Comment_ajax.getDateCreation().toLocaleString().substring(0, 13)%></small>
                                <small class="w3-text-grey"> <%=step1Comment_ajax.getDateCreation().toLocaleString().substring(13)%></small>
                            </p>
                            <div class="description">
                                <p><%=comment_ajax%></p>
                            </div> 
                        </div>
                    </div>
                </div>            
            </div>
        </div>
    </div>                                    

    <%}%>
</div>



<%}%>
<%}%>

<br>
<%
    }
%>

