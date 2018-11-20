


<%@ page import = "java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@page import="dao.DaoUser"%>
<%@page import="model.WhoCanBeAlerted"%>
<%@page import="model.WhoShouldBeAlerted"%>
<%@page import="model.Step1"%>
<%@page import="model.Problem"%>
<%@page import="dao.DaoWhoCanBeAlerted"%>
<%@page import="dao.DaoWhoShouldBeAlerted"%>
<%@page import="dao.DaoStep1"%>
<%@page import="dao.DaoProblem"%>


<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*" %>
<%@ page import = "org.apache.commons.fileupload.*" %>
<%@ page import = "org.apache.commons.fileupload.disk.*" %>
<%@ page import = "org.apache.commons.fileupload.servlet.*" %>
<%@ page import = "org.apache.commons.io.output.*" %>



<%
    out.print("---------------<br>");
    Problem problem = (Problem) session.getAttribute("problem");

    List<WhoCanBeAlerted> listWhoCanBeAlerted = new ArrayList<WhoCanBeAlerted>();
    List<WhoShouldBeAlerted> listWhoShouldBeAlerted = new ArrayList<WhoShouldBeAlerted>();

    /*String reference = request.getParameter("reference");

    String when = request.getParameter("when");
    String where = request.getParameter("where");
    String who = request.getParameter("who");
    String how = request.getParameter("how");
    String how_match = request.getParameter("how_match");
    String why = request.getParameter("why");
    String what = request.getParameter("what");
    String bad_piece = request.getParameter("bad_piece");
    String good_piece = request.getParameter("good_piece");
    String respect_standard_string = request.getParameter("respect_standard");
    String type_problem = request.getParameter("type_problem");

    String shouldAlert1 = request.getParameter("shouldAlert1");
    String shouldAlert2 = request.getParameter("shouldAlert2");
    String shouldAlert3 = request.getParameter("shouldAlert3");
    String shouldAlert4 = request.getParameter("shouldAlert4");
    String shouldAlert5 = request.getParameter("shouldAlert5");

    String canAlert1 = request.getParameter("canAlert1");
    String canAlert2 = request.getParameter("canAlert2");
    String canAlert3 = request.getParameter("canAlert3");
    out.print("---------------<br>");
    
     */
    String reference = request.getParameter("reference");

    String when = "";
    String where = "";
    String who = "";
    String how = "";
    String how_match = "";
    String why = "";
    String what = "";
    String bad_piece = "";
    String good_piece = "";
    String respect_standard_string = "";
    String type_problem = "";

    String shouldAlert1 = "";
    String shouldAlert2 = "";
    String shouldAlert3 = "";
    String shouldAlert4 = "";
    String shouldAlert5 = "";

    String canAlert1 = "";
    String canAlert2 = "";
    String canAlert3 = "";

    boolean respect_standard;


    /*
     ====================================================
     ====================================================
     */
    //problem.setReference(reference);
    // session.setAttribute("problem", problem);

    /*
     ====================================================
     ====================================================
     */
 /* Step1 step1 = new Step1();

    step1.setId_user(3);
    step1.setWhen_("hhhhhh");
    step1.setWhere_(where);
    step1.setWho_(who);
    step1.setHow_(how);
    step1.setHow_match_(Integer.parseInt(how_match));
    step1.setHow_match_(33);
    step1.setWhy_(why);
    step1.setWhat_(what);
    step1.setBad_piece("bad_piece");
    step1.setGood_piece("good_piece");
    step1.setRespect_standard(respect_standard);
    step1.setType_problem(type_problem);
    session.setAttribute("step1", step1);
    /*
     ====================================================
     ====================================================
     */
 /* if (shouldAlert1 != null) {
        WhoShouldBeAlerted whoShouldBeAlerted = new WhoShouldBeAlerted();
        whoShouldBeAlerted.setType_user("supervisor");
        listWhoShouldBeAlerted.add(whoShouldBeAlerted);
    }
    if (shouldAlert2 != null) {
        WhoShouldBeAlerted whoShouldBeAlerted = new WhoShouldBeAlerted();
        whoShouldBeAlerted.setType_user("security");
        listWhoShouldBeAlerted.add(whoShouldBeAlerted);
    }
    if (shouldAlert3 != null) {
        WhoShouldBeAlerted whoShouldBeAlerted = new WhoShouldBeAlerted();
        whoShouldBeAlerted.setType_user("maintenance");
        listWhoShouldBeAlerted.add(whoShouldBeAlerted);
    }
    if (shouldAlert4 != null) {
        WhoShouldBeAlerted whoShouldBeAlerted = new WhoShouldBeAlerted();
        whoShouldBeAlerted.setType_user("quality uap");
        listWhoShouldBeAlerted.add(whoShouldBeAlerted);
    }
    if (shouldAlert5 != null) {
        WhoShouldBeAlerted whoShouldBeAlerted = new WhoShouldBeAlerted();
        whoShouldBeAlerted.setType_user("train d'appro");
        listWhoShouldBeAlerted.add(whoShouldBeAlerted);
    }

    session.setAttribute("listWhoShouldBeAlerted", listWhoShouldBeAlerted);*/
 /*
     ====================================================
     ====================================================
     */
 /*  if (canAlert1 != null) {
        WhoCanBeAlerted whoCanBeAlerted = new WhoCanBeAlerted();
        whoCanBeAlerted.setType_user("Supplier quality");
        listWhoCanBeAlerted.add(whoCanBeAlerted);
    }
    if (canAlert2 != null) {
        WhoCanBeAlerted whoCanBeAlerted = new WhoCanBeAlerted();
        whoCanBeAlerted.setType_user("Logistics");
        listWhoCanBeAlerted.add(whoCanBeAlerted);
    }
    if (canAlert3 != null) {
        WhoCanBeAlerted whoCanBeAlerted = new WhoCanBeAlerted();
        whoCanBeAlerted.setType_user("Resp UAP");
        listWhoCanBeAlerted.add(whoCanBeAlerted);
    }
    session.setAttribute("listWhoCanBeAlerted", listWhoCanBeAlerted);
     */

%>















<%   File file;
    int maxFileSize = 5000 * 1024;
    int maxMemSize = 5000 * 1024;
    ServletContext context = pageContext.getServletContext();
    // String filePath = "/usr/local/tomcat7/webapps/str/upload/";
    String filePath = "C:\\Users\\Hachem\\Documents\\NetBeansProjects\\str\\web\\upload\\";
    String contentType = request.getContentType();

    //  if ((contentType.indexOf("multipart/form-data") >= 0)) {
    DiskFileItemFactory factory = new DiskFileItemFactory();
    factory.setSizeThreshold(maxMemSize);

    ServletFileUpload upload = new ServletFileUpload(factory);

    upload.setSizeMax(maxFileSize);

    try {
        List fileItems = upload.parseRequest(request);
        Iterator i = fileItems.iterator();
        while (i.hasNext()) {
            FileItem fi = (FileItem) i.next();

            if (fi.isFormField()) {
                //out.print(fi.getString("reference") + "---****-<br>");
                /* out.print("<br>-----------------</br>");
                out.print(fi.getFieldName() + "<br>");
                out.print(fi.getName() + "<br>");
                out.print(fi.getString() + "<br>");
                out.print("<br>-----------------</br>");
                 */
                String fieldName = fi.getFieldName();
                String valuefieldName = fi.getString();

                if (fieldName.equals("reference")) {
                    reference = valuefieldName;
                } else if (fieldName.equals("when")) {
                    when = valuefieldName;
                } else if (fieldName.equals("where")) {
                    where = valuefieldName;
                } else if (fieldName.equals("who")) {
                    who = valuefieldName;
                } else if (fieldName.equals("how")) {
                    how = valuefieldName;
                } else if (fieldName.equals("how_match")) {
                    how_match = valuefieldName;
                } else if (fieldName.equals("why")) {
                    why = valuefieldName;
                } else if (fieldName.equals("what")) {
                    what = valuefieldName;
                } else if (fieldName.equals("respect_standard")) {
                    respect_standard_string = valuefieldName;
                } else if (fieldName.equals("type_problem")) {
                    type_problem = valuefieldName;
                } else if (fieldName.equals("shouldAlert1")) {
                    shouldAlert1 = valuefieldName;
                } else if (fieldName.equals("shouldAlert2")) {
                    shouldAlert2 = valuefieldName;
                } else if (fieldName.equals("shouldAlert3")) {
                    shouldAlert3 = valuefieldName;
                } else if (fieldName.equals("shouldAlert4")) {
                    shouldAlert4 = valuefieldName;
                } else if (fieldName.equals("canAlert1")) {
                    canAlert1 = valuefieldName;
                } else if (fieldName.equals("canAlert2")) {
                    canAlert2 = valuefieldName;
                } else if (fieldName.equals("canAlert3")) {
                    canAlert3 = valuefieldName;
                }

            } else {
                // Get the uploaded file parameters
                String fileName = "";
                String fieldName = fi.getFieldName();
                //String valuefieldName = fi.getString();
                if (fieldName.equals("bad_piece")) {
                    // fi.setFieldName(problem.getCode()+"_1");
                    fileName = problem.getCode()+"_"+problem.getNum() + "_bad_piece.jpg";
                    good_piece = fileName;
                } else if (fieldName.equals("good_piece")) {
                    // fi.setFieldName(problem.getCode()+"_2");
                    fileName = problem.getCode()+"_"+problem.getNum() + "_good_piece.jpg";
                    bad_piece = fileName;
                }

                //String fieldName = fi.getFieldName();
                //String fileName = fi.getName();
                // boolean isInMemory = fi.isInMemory();
                // long sizeInBytes = fi.getSize();
                // Write the file
                if (fileName.lastIndexOf("\\") >= 0) {
                    file = new File(filePath
                            + fileName.substring(fileName.lastIndexOf("\\")));
                } else {
                    file = new File(filePath
                            + fileName.substring(fileName.lastIndexOf("\\") + 1));
                }
                fi.write(file);
            }
        }
        //response.sendRedirect("index.jsp");
    } catch (Exception ex) {
        System.out.println(ex);
    }
    // } else {
    //response.sendRedirect("index.jsp");
    // }

    problem.setReference(reference);
    session.setAttribute("problem", problem);

    if (respect_standard_string != null) {
        respect_standard = true;
    } else {
        respect_standard = false;
    }

    Step1 step1 = new Step1();
    User user = (User) session.getAttribute("user");
    step1.setId_user(user.getId());
    step1.setWhen_(when);
    step1.setWhere_(where);
    step1.setWho_(who);
    step1.setHow_(how);
    step1.setHow_match_(Integer.parseInt(how_match));
    step1.setWhy_(why);
    step1.setWhat_(what);
    step1.setBad_piece(bad_piece);
    step1.setGood_piece(good_piece);
    step1.setRespect_standard(respect_standard);
    step1.setType_problem(type_problem);
    session.setAttribute("step1", step1);

    //out.print("--" + shouldAlert1 + "--");
    if (!shouldAlert1.equals("")) {
        WhoShouldBeAlerted whoShouldBeAlerted = new WhoShouldBeAlerted();
        whoShouldBeAlerted.setType_user("supervisor");
        listWhoShouldBeAlerted.add(whoShouldBeAlerted);
    }
    if (!shouldAlert2.equals("")) {
        WhoShouldBeAlerted whoShouldBeAlerted = new WhoShouldBeAlerted();
        whoShouldBeAlerted.setType_user("security");
        listWhoShouldBeAlerted.add(whoShouldBeAlerted);
    }
    if (!shouldAlert3.equals("")) {
        WhoShouldBeAlerted whoShouldBeAlerted = new WhoShouldBeAlerted();
        whoShouldBeAlerted.setType_user("maintenance");
        listWhoShouldBeAlerted.add(whoShouldBeAlerted);
    }
    if (!shouldAlert4.equals("")) {
        WhoShouldBeAlerted whoShouldBeAlerted = new WhoShouldBeAlerted();
        whoShouldBeAlerted.setType_user("quality uap");
        listWhoShouldBeAlerted.add(whoShouldBeAlerted);
    }
    if (!shouldAlert5.equals("")) {
        WhoShouldBeAlerted whoShouldBeAlerted = new WhoShouldBeAlerted();
        whoShouldBeAlerted.setType_user("train d'appro");
        listWhoShouldBeAlerted.add(whoShouldBeAlerted);
    }

    session.setAttribute("listWhoShouldBeAlerted", listWhoShouldBeAlerted);

    if (!canAlert1.equals("")) {
        WhoCanBeAlerted whoCanBeAlerted = new WhoCanBeAlerted();
        whoCanBeAlerted.setType_user("Supplier quality");
        listWhoCanBeAlerted.add(whoCanBeAlerted);
    }
    if (!canAlert2.equals("")) {
        WhoCanBeAlerted whoCanBeAlerted = new WhoCanBeAlerted();
        whoCanBeAlerted.setType_user("Logistics");
        listWhoCanBeAlerted.add(whoCanBeAlerted);
    }
    if (!canAlert3.equals("")) {
        WhoCanBeAlerted whoCanBeAlerted = new WhoCanBeAlerted();
        whoCanBeAlerted.setType_user("Resp UAP");
        listWhoCanBeAlerted.add(whoCanBeAlerted);
    }
    session.setAttribute("listWhoCanBeAlerted", listWhoCanBeAlerted);
%>




<%
    /*  Enumeration<String> list = request.getParameterNames();
    out.print("--------*-------<br>");
    while (list.hasMoreElements()) {
        String ch = list.nextElement();
        out.print(ch + "  :  " + request.getParameter(ch));
    }*/
    //out.print(request.getAttribute("reference"));
    //out.print(request.getParameter("reference"));
    //out.print(contentType);
    //out.print(context);
    //out.print("--------*-------<br>");
    response.sendRedirect(application.getContextPath() + "/user/page/S1P2Form.jsp");
%>