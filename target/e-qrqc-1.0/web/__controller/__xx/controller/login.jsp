
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@page import="dao.DaoUser"%>
<%

    String login = request.getParameter("login");
    String password = request.getParameter("password");
    DaoUser daoUser = new DaoUser();
    User user = daoUser.exist(login, password);
    if (user != null) {
        session.setAttribute("user", user);
        
        
        
        /*List<HttpSession> list=(List<HttpSession> )application.getAttribute("sessions");
        if(list==null)
        {
          list=new ArrayList<HttpSession>();
        }
        list.add(session);
        application.setAttribute("sessions", list);
        
        out.print("user != null");
        */
        response.sendRedirect(application.getContextPath() + "/user/page/home.jsp");
    } else {
        response.sendRedirect(application.getContextPath());
        out.print("user == null");
    }


%>