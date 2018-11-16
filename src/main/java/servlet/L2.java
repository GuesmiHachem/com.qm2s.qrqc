/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.*;
import service.*;

/**
 *
 * @author Hachem
 */
public class L2 extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/level2.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();

        //------------------------------------------------------------
        //------------------------------------------------------------
        String id = request.getParameter("id");
        Level2 level2 = ServiceLevel2.find(Integer.parseInt(id));
        //--------------------------------------------------------
        Level3 level3 = level2.getIdLevel3();
        List<Level2> listLevel2 = level3.getLevel2List();
        int index = listLevel2.indexOf((Level2) level2);
        Level2 level2Next = level2;
        Level2 level2Prev = level2;
        if (listLevel2.size() > 1) {
            if (index == 0) {
                level2Next = listLevel2.get(index + 1);
                level2Prev = listLevel2.get(listLevel2.size() - 1);
            } else if (index == (listLevel2.size() - 1)) {
                level2Next = listLevel2.get(0);
                level2Prev = listLevel2.get(index - 1);
            } else {
                level2Next = listLevel2.get(index + 1);
                level2Prev = listLevel2.get(index - 1);
            }
        }

        request.setAttribute("level2", level2);
        request.setAttribute("level3", level3);
        request.setAttribute("level2Next", level2Next);
        request.setAttribute("level2Prev", level2Prev);
        //------------------------------------------------------------

        application.getRequestDispatcher(pageweb).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        application = request.getServletContext();

        //------------------------------------------------------------
        String id = request.getParameter("id");
        Level2 level2 = ServiceLevel2.find(Integer.parseInt(id));
        //--------------------------------------------------------
        Level3 level3 = level2.getIdLevel3();
        List<Level2> listLevel2 = level3.getLevel2List();
        int index = listLevel2.indexOf((Level2) level2);
        Level2 level2Next = level2;
        Level2 level2Prev = level2;
        if (listLevel2.size() > 1) {
            if (index == 0) {
                level2Next = listLevel2.get(index + 1);
                level2Prev = listLevel2.get(listLevel2.size() - 1);
            } else if (index == (listLevel2.size() - 1)) {
                level2Next = listLevel2.get(0);
                level2Prev = listLevel2.get(index - 1);
            } else {
                level2Next = listLevel2.get(index + 1);
                level2Prev = listLevel2.get(index - 1);
            }
        }

        //--------------------------------------------------------
        String idLevel = request.getParameter("idLevel");
        String nameLevel = request.getParameter("nameLevel");
        String idUser = request.getParameter("idUser");
        //--------------------------------------------------------
        String addLevel = request.getParameter("addLevel");
        String addUser = request.getParameter("addUser");
        String renameLevel = request.getParameter("renameLevel");
        String deleteAll = request.getParameter("deleteAll");
        String deleteLevel = request.getParameter("deleteLevel");
        String deleteUser = request.getParameter("deleteUser");
        //--------------------------------------------------------

        //--------------------------------------------------------
        //--------------------------------------------------------
        if (addLevel != null) {
            Level1 level1 = new Level1();
            level1.setName(nameLevel);
            level1.setIdLevel2(level2);
            ServiceLevel1.create(level1);
        }
        //--------------------------------------------------------
        if (deleteAll != null) {
            List<Level1> list = level2.getLevel1List();
            for (Level1 l : list) {
                ServiceLevel1.destroy(l.getId());
            }
        }
        //--------------------------------------------------------
        if (renameLevel != null) {
            level2.setName(nameLevel);
            ServiceLevel2.edit(level2);
        }
        //--------------------------------------------------------
        if (deleteLevel != null) {
            ServiceLevel1.destroy(Integer.parseInt(idLevel));
        }
        //--------------------------------------------------------
        if (deleteUser != null) {
            entity.User user = ServiceUser.find(Integer.parseInt(idUser));
            user.setIdLevel2(null);
            ServiceUser.edit(user);
        }
        //--------------------------------------------------------
        if (addUser != null) {
            entity.User user = ServiceUser.find(Integer.parseInt(idUser));
            user.setIdLevel2(level2);
            ServiceUser.edit(user);
        }

        //--------------------------------------------------------
        response.sendRedirect(application.getContextPath() + "/L2?id=" + level2.getId());

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
