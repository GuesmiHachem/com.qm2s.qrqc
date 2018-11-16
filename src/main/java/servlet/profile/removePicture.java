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
public class removePicture extends HttpServlet {

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
        
        String removePhoto = request.getParameter("removePhoto");
        //--------------------------------------------------------
        if (removePhoto != null) {
            String filePath = new Config().pathPictureUser;
            File f1 = new File(filePath + user.getPicture());
            f1.delete();
            user.setPicture("");
            ServiceUser.edit(user);
            session.setAttribute("user", user);
        }

        //******************************************
        response.sendRedirect(application.getContextPath() + "/MyProfile");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
