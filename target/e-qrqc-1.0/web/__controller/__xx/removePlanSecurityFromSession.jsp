



<%@page import="model.SecurityPlan"%>
<%@page import="java.util.List"%>
<%

    String hashcode = request.getParameter("hashcode");
    List<SecurityPlan> list = (List<SecurityPlan>) session.getAttribute("listSecurityPlan");
    out.print(list.size());

    for (int i = 0; i < list.size(); i++) {
        SecurityPlan securityPlan = list.get(i);
        if ((securityPlan.hashCode() + "").equals(hashcode)) {
            list.remove(securityPlan);
        }
    }
      session.setAttribute("listSecurityPlan", list);
    /*
   
     */
    response.sendRedirect(application.getContextPath() + "/user/page/S1P2Form.jsp");
%>