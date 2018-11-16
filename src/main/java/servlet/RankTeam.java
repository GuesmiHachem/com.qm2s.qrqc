/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.ServiceRankTeam;

/**
 *
 * @author Hachem
 */
public class RankTeam extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/rankTeam.jsp";

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
        String idRankTeam = request.getParameter("id");
        entity.RankTeam rankTeam = ServiceRankTeam.find(Integer.parseInt(idRankTeam));
        //--------------------------------------------------------

        //--------------------------------------------------------
        String startTimeRankTeam = request.getParameter("startTimeRankTeam");
        String endTimeRankTeam = request.getParameter("endTimeRankTeam");
        String nameRankTeam = request.getParameter("nameRankTeam");
        //--------------------------------------------------------
        String updateRankTeam = request.getParameter("updateRankTeam");
        //--------------------------------------------------------
        if (updateRankTeam != null) {

            try {
                rankTeam.setName(nameRankTeam);
                DateFormat sdf = new SimpleDateFormat("HH:MM");
                Date dateStartTimeRankTeam = (Date) sdf.parse(startTimeRankTeam);
                Date dateEndTimeRankTeam = (Date) sdf.parse(endTimeRankTeam);
                rankTeam.setStartTime(dateStartTimeRankTeam);
                rankTeam.setEndTime(dateEndTimeRankTeam);

                ServiceRankTeam.edit(rankTeam);
            } catch (ParseException ex) {
                Logger.getLogger(RankTeam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        response.sendRedirect(application.getContextPath() + "/RankTeam?id=" + rankTeam.getId());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
