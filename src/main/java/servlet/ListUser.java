/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.*;

/**
 *
 * @author Hachem
 */
public class ListUser extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/listUser.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();

        application.getRequestDispatcher(pageweb).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        application = request.getServletContext();

        //--------------------------------------------------------
        String idUser = request.getParameter("idUser");
        String nameTypeUser = request.getParameter("nameTypeUser");
        String idTypeUser = request.getParameter("idTypeUser");

        String firstName = request.getParameter("firstName");
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        //--------------------------------------------------------
        String addTypeUser = request.getParameter("addTypeUser");
        String addUser = request.getParameter("addUser");
        String deleteUser = request.getParameter("deleteUser");
        String deleteTypeUser = request.getParameter("deleteTypeUser");
        //--------------------------------------------------------

        //--------------------------------------------------------
        if (addTypeUser != null) {
            entity.TypeUser typeUser = new entity.TypeUser();
            typeUser.setName(nameTypeUser);

            ServiceTypeUser.create(typeUser);
        }
        //--------------------------------------------------------
        if (addUser != null) {
            entity.User user = new entity.User();

            user.setFirstName(firstName);
            user.setName(name);
            user.setBirthday(birthday);
            user.setLogin(login);
            user.setPassword(password);
            user.setPicture("");
            user.setIdLevel0(null);
            user.setIdLevel1(null);
            user.setIdLevel2(null);
            user.setIdLevel3(null);
            user.setMatricule("");
            user.setCin("");
            user.setEmail("");
            user.setTel("");
            user.setIdTypeUser( ServiceTypeUser.find(Integer.parseInt(idTypeUser)));

            ServiceUser.create(user);
        }
        //--------------------------------------------------------
        if (deleteUser != null) {
            ServiceUser.destroy(Integer.parseInt(idUser));
        }
        //--------------------------------------------------------
        if (deleteTypeUser != null) {
            ServiceTypeUser.destroy(Integer.parseInt(idTypeUser));
        }

         response.sendRedirect(application.getContextPath() + "/ListUser");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
