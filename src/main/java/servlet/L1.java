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
public class L1 extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/level1.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();

        //----------------------------------------------------------
        String id = request.getParameter("id");
        Level1 level1 = ServiceLevel1.find(Integer.parseInt(id));
        Level2 level2 = level1.getIdLevel2();
        Level3 level3 = level2.getIdLevel3();
        //----------------------------------------------------------
        //--------------------------------------------------------

        List<Level1> listLevel1 = level2.getLevel1List();
        int index = listLevel1.indexOf((Level1) level1);
        Level1 level1Next = level1;
        Level1 level1Prev = level1;
        if (listLevel1.size() > 1) {
            if (index == 0) {
                level1Next = listLevel1.get(index + 1);
                level1Prev = listLevel1.get(listLevel1.size() - 1);
            } else if (index == (listLevel1.size() - 1)) {
                level1Next = listLevel1.get(0);
                level1Prev = listLevel1.get(index - 1);

            } else {
                level1Next = listLevel1.get(index + 1);
                level1Prev = listLevel1.get(index - 1);
            }
        }

        request.setAttribute("level1", level1);
        request.setAttribute("level2", level2);
        request.setAttribute("level3", level3);
        request.setAttribute("level1Next", level1Next);
        request.setAttribute("level1Prev", level1Prev);
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
        Level1 level1 = ServiceLevel1.find(Integer.parseInt(id));
        Level2 level2 = level1.getIdLevel2();
        Level3 level3 = level2.getIdLevel3();
        //----------------------------------------------------------
        String nameLevel = request.getParameter("nameLevel");
        String idLevel = request.getParameter("idLevel");
        String idUser = request.getParameter("idUser");
        String idRankTeam = request.getParameter("idRankTeam");
        //----------------------------------------------------------
        String addLevel = request.getParameter("addLevel");
        String renameLevel = request.getParameter("renameLevel");
        String deleteAll = request.getParameter("deleteAll");
        String deleteLevel = request.getParameter("deleteLevel");
        String deleteUser = request.getParameter("deleteUser");
        String addUser = request.getParameter("addUser");
        //----------------------------------------------------------

        List<Level1> listLevel1 = level2.getLevel1List();
        int index = listLevel1.indexOf((Level1) level1);
        Level1 level1Next = level1;
        Level1 level1Prev = level1;
        if (listLevel1.size() > 1) {
            if (index == 0) {
                level1Next = listLevel1.get(index + 1);
                level1Prev = listLevel1.get(listLevel1.size() - 1);
            } else if (index == (listLevel1.size() - 1)) {
                level1Next = listLevel1.get(0);
                level1Prev = listLevel1.get(index - 1);

            } else {
                level1Next = listLevel1.get(index + 1);
                level1Prev = listLevel1.get(index - 1);
            }
        }
        //----------------------------------------------------------
        if (addLevel != null) {
            Level0 level0 = new Level0();
            level0.setName(nameLevel);
            level0.setIdRankTeam(ServiceRankTeam.find(Integer.parseInt(idRankTeam)));
            level0.setIdLevel1(level1);
            ServiceLevel0.create(level0);
        }
        //----------------------------------------------------------
        if (deleteAll != null) {
            List<Level0> list = level1.getLevel0List();
            for (Level0 l : list) {
                ServiceLevel0.destroy(l.getId());
            }
        }
        //----------------------------------------------------------
        if (renameLevel != null) {

            level1.setName(nameLevel);
            ServiceLevel1.edit(level1);
        }
        //----------------------------------------------------------
        if (deleteLevel != null) {

            ServiceLevel0.destroy(Integer.parseInt(idLevel));
        }
        //--------------------------------------------------------
        if (deleteUser != null) {
            entity.User user = ServiceUser.find(Integer.parseInt(idUser));
            user.setIdLevel1(null);
            ServiceUser.edit(user);
        }
        //--------------------------------------------------------
        if (addUser != null) {
            entity.User user = ServiceUser.find(Integer.parseInt(idUser));
            user.setIdLevel1(level1);
            ServiceUser.edit(user);
        }
        //--------------------------------------------------------
        response.sendRedirect(application.getContextPath() + "/L1?id=" + level1.getId());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
