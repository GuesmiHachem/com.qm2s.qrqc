<%@page import="service.ServiceHardware"%>
<%@page import="entity.Hardware"%>
<%

    String idHardware = request.getParameter("idHardware");
    Hardware hardware = ServiceHardware.find(Integer.parseInt(idHardware));
    if (hardware != null) {
        if (hardware.getActive()) {
            out.print("true");
        } else {
            out.print("false");
        }
    }else{
      out.print("false");
    }

%>