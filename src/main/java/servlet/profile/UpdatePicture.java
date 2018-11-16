/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.profile;

import domaine.Config;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.ServiceUser;

/**
 *
 * @author Hachem
 */
public class UpdatePicture extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/myProfile.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();
        //--------------------------------------------------------
        application.getRequestDispatcher(pageweb).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        application = request.getServletContext();
        //--------------------------------------------------------
        entity.User user = (entity.User) session.getAttribute("user");
        //--------------------------------------------------------
        File file;
        int maxFileSize = 5000 * 1024 * 1024;
        int maxMemSize = 5000 * 1024 * 1024;
        ServletContext context = request.getServletContext();
        String filePath = new Config().pathPictureUser;
        String contentType = request.getContentType();

        if ((contentType.indexOf("multipart/form-data") >= 0)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(maxMemSize);
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(maxFileSize);
            try {
                List fileItems = upload.parseRequest(request);
                Iterator i = fileItems.iterator();
                while (i.hasNext()) {
                    FileItem fi = (FileItem) i.next();

                    if (!fi.isFormField()) {
                        String fileName = "";
                        String fieldName = fi.getFieldName();

                        if (fieldName.equals("photo")) {

                            fileName = new Date(new Date().getTime()).getTime() + "_" + user.getId() + ".jpg";
                        }

                        File f1 = new File(filePath + user.getPicture());
                        f1.delete();

                        File f2 = new File(filePath + fileName);
                        fi.write(f2);
                        user.setPicture(fileName);
                        ServiceUser.edit(user);
                        session.setAttribute("user", user);
                        try {
                            Thread.sleep(2500);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        f1 = null;
                        f2 = null;

                    }
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        //******************************************
        response.sendRedirect(application.getContextPath() + "/MyProfile");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
