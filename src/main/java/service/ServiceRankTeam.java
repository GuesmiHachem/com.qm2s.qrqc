/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.RankTeam;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class ServiceRankTeam {
    //#############################################

    public static RankTeam create(RankTeam t) {
        return service.FactoryJPA.getRankTeamJpaController().create(t);
    }

    //#############################################
    public static void edit(RankTeam t) {
        try {
            service.FactoryJPA.getRankTeamJpaController().edit(t);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceRankTeam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceRankTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getRankTeamJpaController().destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ServiceRankTeam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceRankTeam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<RankTeam> it = findAll().iterator();
        while (it.hasNext()) {
            RankTeam obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static RankTeam find(int id) {
        return service.FactoryJPA.getRankTeamJpaController().findRankTeam(id);
    }

    //#############################################
    public static List<RankTeam> findAll() {
        return service.FactoryJPA.getRankTeamJpaController().findRankTeamEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<RankTeam> it = findAll().iterator();
        while (it.hasNext()) {
            RankTeam obj = it.next();
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        //afficher();
        Date date = new Date();
        getRankTeam(date);
    }

    public static RankTeam getRankTeam(Date date) {
        List<RankTeam> list = findAll();
          RankTeam rankTeam=null;
        for (int i=0;i<list.size();i++) {
            rankTeam=list.get(i);
            Time time = new Time(date.getHours(), date.getMinutes(), date.getSeconds());
            Time s = new Time(rankTeam.getStartTime().getTime());
            Time e = new Time(rankTeam.getEndTime().getTime());
            if (time.after(s) && time.before(e)) {

                return rankTeam;
            }
        }
        return rankTeam;

    }

}
