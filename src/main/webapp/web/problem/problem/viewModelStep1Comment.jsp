

<%@page import="service.ServiceProblem"%>
<%@page import="entity.Step1"%>
<%@page import="entity.Problem"%>
<%@page import="entity.Problem"%>
<%@page import="entity.Step1Comment"%>
<%
    String id_problem_ajax = request.getParameter("id");
    Problem problem= ServiceProblem.find(Integer.parseInt(id_problem_ajax));
    Step1 step1 = problem.getIdStep1();


%>


<%
    for (Step1Comment step1C : step1.getStep1CommentList()) {
%>


<!-- Modal -->
<div class="modal fade" id="comment<%=step1C.getId()%>" tabindex="-1" role="dialog" aria-labelledby="comment<%=step1C.getId()%>" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modifier Commentaire</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label>Commentaire</label>
                                <textarea name="comment" class="form-control"  rows="3">
                                    <%=step1C.getComment().trim()%>
                                </textarea>
                            </div>
                            <div class="w3-right">
                                <button  type="reset" class="btn btn-light">Annuler</button>
                                <button  type="button" class="btn btn-primary" name="updateComment" onclick="_updateStep1Comment(<%=step1C.getId()%>, comment.value);_viewModelStep1Comment();" class="close" data-dismiss="modal" aria-label="Close">Modifier</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%
    }
%>
