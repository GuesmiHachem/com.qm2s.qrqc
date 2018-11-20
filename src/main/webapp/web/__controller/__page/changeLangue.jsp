

<%
    String lang1 = (String) request.getParameter("lang");
    if (lang1 != null) {
        if (lang1.equals("fr")) {
            session.setAttribute("lang", "fr");
        } else {
            session.setAttribute("lang", "en");
        }
    }
%>
