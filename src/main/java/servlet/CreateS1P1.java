/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import domaine.Config;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.ServiceProblem;
import service.ServiceStep1;
import service.ServiceStep1AlertCan;
import service.ServiceStep1AlertShould;
import service.ServiceTypeProblem;
import service.ServiceTypeUser;

/**
 *
 * @author Hachem
 */
public class CreateS1P1 extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String S1P1Form = "/user/page/S1P1Form.jsp";
    public String S1P2Form = "/user/page/S1P2Form.jsp";
    public String S1P3Form = "/user/page/S1P3Form.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();
        //--------------------------------------------------------

        entity.Problem problem = (entity.Problem) session.getAttribute("problem");
        entity.User user = (entity.User) session.getAttribute("user");
        if (problem == null) {
            problem = ServiceProblem.generateProblem(user);
            session.setAttribute("problem", problem);

        }

        application.getRequestDispatcher(S1P1Form).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        application = request.getServletContext();

        entity.Problem problem = (entity.Problem) session.getAttribute("problem");
        //--------------------------------------------------------

        List<Step1AlertCan> listStep1AlertCan = new ArrayList<Step1AlertCan>();
        List<Step1AlertShould> listStep1AlertShould = new ArrayList<Step1AlertShould>();

        String reference = request.getParameter("reference");
        String when = "";
        String where = "";
        String who = "";
        String how = "";
        String how_match = "0";
        String why = "";
        String what = "";
        String bad_piece = "";
        String good_piece = "";
        String respect_standard_string = "";
        String probleme_recurrent_string = "";
        String type_problem = "";
        boolean respect_standard = false;
        boolean probleme_recurrent = false;

        File file;
        int maxFileSize = 5000 * 1024 * 1024;
        int maxMemSize = 5000 * 1024 * 1024;
        String filePath = new Config().getPathPictureProblem();
        String contentType = request.getContentType();
        String fieldName = null;
        String valuefieldName = null;
        FileItem fi = null;
        String fileName = "";

        if ((contentType.indexOf("multipart/form-data") >= 0)) {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(maxMemSize);
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(maxFileSize);
            try {
                List fileItems = upload.parseRequest(request);
                Iterator i = fileItems.iterator();
                while (i.hasNext()) {
                    fi = (FileItem) i.next();

                    if (fi.isFormField()) {
                        fieldName = fi.getFieldName();
                        valuefieldName = fi.getString();

                        //response.getWriter().print(fieldName + "   :  " + valuefieldName + "\n");
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
                        } else if (fieldName.equals("probleme_recurrent")) {
                            probleme_recurrent_string = valuefieldName;
                            //response.getWriter().print(probleme_recurrent_string + "--");
                        } else if (fieldName.equals("type_problem")) {
                            type_problem = valuefieldName;
                            //response.getWriter().print(type_problem + "--");
                            //response.getWriter().print(fieldName + "--");

                        } else if (fieldName.equals("ShouldAlerted[]")) {
                            Step1AlertShould step1AlertShould = new Step1AlertShould();
                            entity.TypeUser typeUser = ServiceTypeUser.find(Integer.parseInt(valuefieldName));
                           // response.getWriter().print(fieldName + "--"+valuefieldName+"--\n");
                            step1AlertShould.setIdTypeUser(typeUser);
                            listStep1AlertShould.add(step1AlertShould);
                        } else if (fieldName.equals("CanAlerted[]")) {
                            Step1AlertCan step1AlertCan = new Step1AlertCan();
                            entity.TypeUser typeUser = ServiceTypeUser.find(Integer.parseInt(valuefieldName));
                           // response.getWriter().print(fieldName + "--"+valuefieldName+"\n");
                            step1AlertCan.setIdTypeUser(typeUser);
                            listStep1AlertCan.add(step1AlertCan);
                        }

                        if (respect_standard_string.equals("on")) {
                            respect_standard = true;
                        }

                        if (probleme_recurrent_string.equals("on")) {
                            probleme_recurrent = true;
                        }

                    } else {

                        fieldName = fi.getFieldName();
                        if (fieldName.equals("bad_piece")) {
                            fileName = problem.getCode() + "_bad.jpg";
                            bad_piece = fileName;
                            file = new File(filePath + fileName);
                            fi.write(file);
                        } else if (fieldName.equals("good_piece")) {
                            fileName = problem.getCode() + "_good.jpg";
                            good_piece = fileName;
                            file = new File(filePath + fileName);
                            fi.write(file);
                        }

                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }

            
            Step1 step1 = new Step1();
            step1.setWhen(when);
            step1.setWhere(where);
            step1.setWho(who);
            step1.setHow(how);
            step1.setHowMutch(Integer.parseInt(how_match));
            step1.setWhy(why);
            step1.setWhat(what);
            step1.setBadPiece(bad_piece);
            step1.setGoodPiece(good_piece);
            step1.setRespectStandard(respect_standard);
            step1.setRecognizedProblem(probleme_recurrent);

            // step1
            step1 = ServiceStep1.create(step1);
            step1.setIdProblem(problem);
            problem.setReference(reference);
            problem.setIdTypeProblem(ServiceTypeProblem.find(Integer.parseInt(type_problem)));
            problem.setIdStep1(step1);

            for (Step1AlertCan whoCanBeAlerted : listStep1AlertCan) {
                whoCanBeAlerted.setIdStep1(step1);
                ServiceStep1AlertCan.create(whoCanBeAlerted);
            }
            for (Step1AlertShould whoShouldBeAlerted : listStep1AlertShould) {
                whoShouldBeAlerted.setIdStep1(step1);
                ServiceStep1AlertShould.create(whoShouldBeAlerted);
            }

            ServiceProblem.edit(problem);
            problem = ServiceProblem.find(problem.getId());
            ServiceStep1.edit(step1);
            step1 = ServiceStep1.find(step1.getId());

            session.setAttribute("problem", problem);
            session.setAttribute("step1", step1);
            //  session.setAttribute("listWhoShouldBeAlerted", listStep1AlertShould);
            //  session.setAttribute("listWhoCanBeAlerted", listStep1AlertCan);

            //============================================================
            response.sendRedirect(application.getContextPath() + "/CreateS1P2");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
