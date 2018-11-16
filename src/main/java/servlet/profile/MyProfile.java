/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.profile;

import domaine.Config;
import java.io.File;
import java.io.IOException;
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
public class MyProfile extends HttpServlet {

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

        //--------------------------------------------------------
        String idTypeUser = request.getParameter("idTypeUser");
        String firstName = request.getParameter("firstName");
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        //--------------------------------------------------------
        String updateUser = request.getParameter("updateUser");
        String removePhoto = request.getParameter("removePhoto");
        String updatePhoto = request.getParameter("updatePhoto");
        //--------------------------------------------------------
        if (updateUser != null) {
            user.setId(user.getId());
            user.setFirstName(firstName);
            user.setName(name);
            user.setBirthday(birthday);
            user.setLogin(login);
            user.setPassword(password);

            ServiceUser.edit(user);
        }

        if (removePhoto != null) {
            String filePath = new Config().pathPictureUser;
            File f1 = new File(filePath + user.getPicture());
            f1.delete();
            user.setPicture("");
            ServiceUser.edit(user);
            session.setAttribute("user", user);
        } else {
            //******************************************
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
        }

        //******************************************
        response.sendRedirect(application.getContextPath() + "/MyProfile");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
