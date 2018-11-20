



<%@page import="model.Step1Part3"%>
<%@page import="model.SecurityPlan"%>
<%@page import="java.util.List"%>
<%

    String hashcode = request.getParameter("hashcode");
    List<Step1Part3> listStep1part3 = (List<Step1Part3>) session.getAttribute("listStep1part3");
    out.print(listStep1part3.size());

    for (int i = 0; i < listStep1part3.size(); i++) {
        Step1Part3 sp = listStep1part3.get(i);
        if ((sp.hashCode() + "").equals(hashcode)) {
            listStep1part3.remove(sp);
        }
    }
      session.setAttribute("listStep1part3", listStep1part3);
    /*
   
     */
    response.sendRedirect(application.getContextPath() + "/user/page/S1P3Form.jsp");
%>