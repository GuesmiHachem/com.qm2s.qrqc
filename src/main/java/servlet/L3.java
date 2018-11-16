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
public class L3 extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/level3.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();

        //------------------------------------------------------------
        String id = request.getParameter("id");
        Level3 level3 =  ServiceLevel3.find(Integer.parseInt(id));
        List<Level3> listLevel3 = ServiceLevel3.findAll();
        int index = listLevel3.indexOf((Level3) level3);
        Level3 level3Next = level3;
        Level3 level3Prev = level3;
        if (listLevel3.size() > 1) {
            if (index == 0) {
                level3Next = listLevel3.get(index + 1);
                level3Prev = listLevel3.get(listLevel3.size() - 1);
            } else if (index == (listLevel3.size() - 1)) {
                level3Next = listLevel3.get(0);
                level3Prev = listLevel3.get(index - 1);

            } else {
                level3Next = listLevel3.get(index + 1);
                level3Prev = listLevel3.get(index - 1);
            }
        }
        request.setAttribute("level3", level3);
        request.setAttribute("level3Next", level3Next);
        request.setAttribute("level3Prev", level3Prev);
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
        Level3 level3 =  ServiceLevel3.find(Integer.parseInt(id));
        List<Level3> listLevel3 =  ServiceLevel3.findAll();
        int index = listLevel3.indexOf((Level3) level3);
        Level3 level3Next = level3;
        Level3 level3Prev = level3;
        if (listLevel3.size() > 1) {
            if (index == 0) {
                level3Next = listLevel3.get(index + 1);
                level3Prev = listLevel3.get(listLevel3.size() - 1);
            } else if (index == (listLevel3.size() - 1)) {
                level3Next = listLevel3.get(0);
                level3Prev = listLevel3.get(index - 1);

            } else {
                level3Next = listLevel3.get(index + 1);
                level3Prev = listLevel3.get(index - 1);
            }
        }
        request.setAttribute("level3", level3);
        request.setAttribute("level3Next", level3Next);
        request.setAttribute("level3Prev", level3Prev);
        //------------------------------------------------------------

        String nameLevel = request.getParameter("nameLevel");
        String idLevel = request.getParameter("idLevel");
        String idUser = request.getParameter("idUser");
        //String idTypeUser = request.getParameter("idTypeUser");
        String idNature = request.getParameter("idNature");
        String idProcessus = request.getParameter("idProcessus");
        String nameNature = request.getParameter("nameNature");
        String nameProcessus = request.getParameter("nameProcessus");
        String color = request.getParameter("color");
        //String idNature = request.getParameter("idNature");
        //String idProcessus = request.getParameter("idProcessus");
        //--------------------------------------------------------
        String addLevel = request.getParameter("addLevel");
        String renameLevel = request.getParameter("renameLevel");
        String deleteAll = request.getParameter("deleteAll");
        String deleteLevel = request.getParameter("deleteLevel");
        String addUser = request.getParameter("addUser");
        String deleteUser = request.getParameter("deleteUser");
        String addNature = request.getParameter("addNature");
        String addProcessus = request.getParameter("addProcessus");
        String deleteNature = request.getParameter("deleteNature");
        String deleteProcessus = request.getParameter("deleteProcessus");
        //--------------------------------------------------------

        //--------------------------------------------------------
        if (addLevel != null) {
            Level2 level2 = new Level2();
            level2.setName(nameLevel);
            level2.setIdLevel3(level3);
            level2.setIdProcessus(ServiceProcessus.find(Integer.parseInt(idProcessus)));
            //level2.setId_type2_level2(Integer.parseInt(idProcessus));
            ServiceLevel2.create(level2);
        }
        //--------------------------------------------------------
        if (deleteAll != null) {
            List<Level2> list = level3.getLevel2List();
            for (Level2 l : list) {
               ServiceLevel2.destroy(l.getId());
            }
        }
        //--------------------------------------------------------
        if (renameLevel != null) {
            level3.setName(nameLevel);
             ServiceLevel3.edit(level3);
        }
        //--------------------------------------------------------
        if (deleteLevel != null) {
            ServiceLevel2.destroy(Integer.parseInt(idLevel));
        }
        //--------------------------------------------------------
        if (addUser != null) {
            entity.User user = ServiceUser.find(Integer.parseInt(idUser));
            user.setIdLevel3(level3);
            ServiceUser.edit(user);
        }
        //--------------------------------------------------------
        if (deleteUser != null) {
            entity.User user =  ServiceUser.find(Integer.parseInt(idUser));
            user.setIdLevel3(null);
            ServiceUser.edit(user);
        }
        //--------------------------------------------------------
        if (addNature != null) {
            entity.Nature nat = new entity.Nature();
            nat.setName(nameNature);
            
            ServiceNature.create(nat);
        }
        //--------------------------------------------------------
        if (addProcessus != null) {
            entity.Processus pro = new entity.Processus();
            pro.setName(nameProcessus);
            pro.setIdNature(ServiceNature.find(Integer.parseInt(idNature)));
            pro.setIdUser(ServiceUser.find(Integer.parseInt(idUser)));
            ServiceProcessus.create(pro);
        }
        //--------------------------------------------------------
        if (deleteNature != null) {
            ServiceNature.destroy(Integer.parseInt(idNature));
        }
        //--------------------------------------------------------
        if (deleteProcessus != null) {
           ServiceProcessus.destroy(Integer.parseInt(idProcessus));
        }
        //--------------------------------------------------------

        response.sendRedirect(application.getContextPath() + "/L3?id=" + level3.getId());
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
