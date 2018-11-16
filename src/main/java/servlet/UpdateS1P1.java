/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import domaine.Config;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.ServiceProblem;
import service.ServiceStep1;
import service.ServiceTypeProblem;

/**
 *
 * @author Hachem
 */
public class UpdateS1P1 extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();
        //--------------------------------------------------------

        String idProblem = request.getParameter("id");
        entity.Problem problem = ServiceProblem.find(Integer.parseInt(idProblem));
        response.sendRedirect(application.getContextPath() + "/UpdateProblem?id=" + problem.getId());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        application = request.getServletContext();
        String idProblem = request.getParameter("id");
        entity.Problem problem = ServiceProblem.find(Integer.parseInt(idProblem));
        entity.Step1 step1 = problem.getIdStep1();

//--------------------------------------------------------
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
       

        //  File file;
        int maxFileSize = 10000 * 1024 * 1024;
        int maxMemSize = 10000 * 1024 * 1024;
        String filePath =  new Config().pathPictureProblem;
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

                        //response.getWriter().print(fieldName + "--" + valuefieldName + "<br>");
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
                        } else if (fieldName.equals("type_problem")) {
                            type_problem = valuefieldName;
                        }
                        if (respect_standard_string.equals("on")) {
                            respect_standard = true;
                        }
                        if (probleme_recurrent_string.equals("on")) {
                            probleme_recurrent = true;
                        }

                        

                    } else {

                        fileName = "";
                        fieldName = fi.getFieldName();
                        //valuefieldName = fi.getString();

                        if (fieldName.equals("bad_piece")) {
                            if (fi.getSize() != 0) {

                                File f1 = new File(filePath + step1.getBadPiece());
                                f1.delete();
                                double d=new Random().nextDouble()*1000;
                                bad_piece = d + "_bad.jpg";
                                File f2 = new File(filePath + bad_piece);
                                fi.write(f2);
                                //response.getWriter().println("bad_piece   :   " + fi.getSize());
                                step1.setBadPiece(bad_piece);

                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }

                            }

                        } else if (fieldName.equals("good_piece")) {

                            if (fi.getSize() != 0) {
                                File f1 = new File(filePath + step1.getGoodPiece());
                                f1.delete();
                                double d=new Random().nextDouble()*1000;
                                good_piece = d + "_good.jpg";
                                File f2 = new File(filePath + good_piece);
                                fi.write(f2);
                                //response.getWriter().println("good_piece   :   " + fi.getSize());
                                step1.setGoodPiece(good_piece);

                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }

                            }
                        }

                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }

            //response.getWriter().println("respect_standard_string   :   " + respect_standard_string);
            //response.getWriter().println("probleme_recurrent_string  :  " + probleme_recurrent_string);
            // response.getWriter().println("respect_standard   :  " + respect_standard);
            // response.getWriter().println("probleme_recurrent  :  " + probleme_recurrent);
            problem.setReference(reference);
            problem.setIdTypeProblem(ServiceTypeProblem.find(Integer.parseInt(type_problem)));

            ServiceProblem.edit(problem);
            problem = ServiceProblem.find(problem.getId());

            step1.setWhen(when);
            step1.setWhere(where);
            step1.setWho(who);
            step1.setHow(how);
            step1.setHowMutch(Integer.parseInt(how_match));
            step1.setWhy(why);
            step1.setWhat(what);
            //step1.setBadPiece(bad_piece);
            //step1.setGoodPiece(good_piece);
            step1.setRespectStandard(respect_standard);
            step1.setRecognizedProblem(probleme_recurrent);
            

            // step1
            //step1 = ServiceStep1.create(step1);
            // step1.setIdProblem(problem);
            ServiceStep1.edit(step1);
            step1 = ServiceStep1.find(step1.getId());

            /*problem.setIdStep1(step1);
            step1.setIdProblem(problem);
           

            ServiceProblem.edit(problem);
            problem = ServiceProblem.find(problem.getId());
            ServiceStep1.edit(step1);
            step1 = ServiceStep1.find(step1.getId());
             */
            // session.setAttribute("problem", problem);
            //session.setAttribute("step1", step1);
            //  session.setAttribute("listWhoShouldBeAlerted", listStep1AlertShould);
            //  session.setAttribute("listWhoCanBeAlerted", listStep1AlertCan);
            //============================================================
            response.sendRedirect(application.getContextPath() + "/S1P1?id=" + problem.getId());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
