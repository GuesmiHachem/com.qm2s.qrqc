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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class UpdateProfile extends HttpServlet {

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
        String firstName = request.getParameter("firstName");
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String cin = request.getParameter("cin");
        String matricule = request.getParameter("matricule");
        String tel = request.getParameter("tel");
        //--------------------------------------------------------
        String updateUser = request.getParameter("updateUser");
        //--------------------------------------------------------
/*
        Date birthdayDate = null;
        String birthdayString = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            birthdayDate = sdf.parse(birthday);
            birthdayString = new SimpleDateFormat("yyyy-MM-dd").format(new Date(birthday));
        } catch (ParseException ex) {
            Logger.getLogger(UpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
//--------------------------------------------------------
        //if (updateUser != null) {
        user.setId(user.getId());
        user.setFirstName(firstName);
        user.setName(name);
        user.setMatricule(matricule);
        user.setCin(cin);
        user.setName(name);

        user.setBirthday(birthday);
        user.setLogin(login);
        user.setPassword(password);
        user.setTel(tel);

        ServiceUser.edit(user);
        // }

        //******************************************
        response.sendRedirect(application.getContextPath() + "/MyProfile");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
