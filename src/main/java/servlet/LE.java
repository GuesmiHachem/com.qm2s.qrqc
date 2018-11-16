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
public class LE extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/levelE.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();

        //----------------------------------------------------------
        String id = request.getParameter("id");
        Level0 level0 = ServiceLevel0.find(Integer.parseInt(id));
        Level1 level1 = level0.getIdLevel1();
        Level2 level2 = level1.getIdLevel2();
        Level3 level3 = level2.getIdLevel3();
        //----------------------------------------------------------
        List<Level0> listLevel0 = level1.getLevel0List();
        int index = listLevel0.indexOf((Level0) level0);
        Level0 level0Next = level0;
        Level0 level0Prev = level0;
        if (listLevel0.size() > 1) {
            if (index == 0) {
                level0Next = listLevel0.get(index + 1);
                level0Prev = listLevel0.get(listLevel0.size() - 1);
            } else if (index == (listLevel0.size() - 1)) {
                level0Next = listLevel0.get(0);
                level0Prev = listLevel0.get(index - 1);

            } else {
                level0Next = listLevel0.get(index + 1);
                level0Prev = listLevel0.get(index - 1);
            }
        }

        request.setAttribute("level0", level0);
        request.setAttribute("level1", level1);
        request.setAttribute("level2", level2);
        request.setAttribute("level3", level3);
        request.setAttribute("level0Next", level0Next);
        request.setAttribute("level0Prev", level0Prev);
        //------------------------------------------------------------

        application.getRequestDispatcher(pageweb).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        application = request.getServletContext();

        //----------------------------------------------------------
        String id = request.getParameter("id");
        Level0 level0 = ServiceLevel0.find(Integer.parseInt(id));
        Level1 level1 = level0.getIdLevel1();
        Level2 level2 = level1.getIdLevel2();
        Level3 level3 = level2.getIdLevel3();
        //----------------------------------------------------------
        List<Level0> listLevel0 = level1.getLevel0List();
        int index = listLevel0.indexOf((Level0) level0);
        Level0 level0Next = level0;
        Level0 level0Prev = level0;
        if (listLevel0.size() > 1) {
            if (index == 0) {
                level0Next = listLevel0.get(index + 1);
                level0Prev = listLevel0.get(listLevel0.size() - 1);
            } else if (index == (listLevel0.size() - 1)) {
                level0Next = listLevel0.get(0);
                level0Prev = listLevel0.get(index - 1);

            } else {
                level0Next = listLevel0.get(index + 1);
                level0Prev = listLevel0.get(index - 1);
            }
        }
        //----------------------------------------------------------
        String idLevel = request.getParameter("idLevel");
        String nameLevel = request.getParameter("nameLevel");
        String idUser = request.getParameter("idUser");
        //----------------------------------------------------------
        String addLevel = request.getParameter("addLevel");
        String renameLevel = request.getParameter("renameLevel");
        String deleteAll = request.getParameter("deleteAll");
        String deleteLevel = request.getParameter("deleteLevel");
        String addUser = request.getParameter("addUser");
        String deleteUser = request.getParameter("deleteUser");
        //----------------------------------------------------------

        //----------------------------------------------------------
        //----------------------------------------------------------
        if (deleteAll != null) {
            List<Level0> list = level1.getLevel0List();
            for (Level0 l : list) {
                 ServiceLevel0.destroy(l.getId());
            }
        }
        //--------------------------------------------------------
        if (renameLevel != null) {

            level0.setName(nameLevel);
            ServiceLevel0.edit(level0);
        }
        //--------------------------------------------------------
        if (deleteLevel != null) {
            ServiceLevel0.destroy(Integer.parseInt(idLevel));
        }
        //----------------------------------------------------------
        if (deleteUser != null) {
            entity.User user = ServiceUser.find(Integer.parseInt(idUser));
            user.setIdLevel0(null);
            ServiceUser.edit(user);
        }
        //--------------------------------------------------------
        if (addUser != null) {
            entity.User user = ServiceUser.find(Integer.parseInt(idUser));
            user.setIdLevel0(level0);
            ServiceUser.edit(user);
        }

        //--------------------------------------------------------
        response.sendRedirect(application.getContextPath() + "/LE?id=" + level0.getId());

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
