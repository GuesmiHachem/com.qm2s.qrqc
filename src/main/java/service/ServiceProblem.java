/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Level1;
import entity.Problem;
import entity.User;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
public class ServiceProblem {

//#############################################
    public static Problem create(Problem t) {
        return service.FactoryJPA.getProblemJpaController().create(t);
    }

    //#############################################
    public static void edit(Problem t) {
        try {
            service.FactoryJPA.getProblemJpaController().edit(t);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceProblem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceProblem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getProblemJpaController().destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ServiceProblem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceProblem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Problem> it = findAll().iterator();
        while (it.hasNext()) {
            Problem obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Problem find(int id) {
        return service.FactoryJPA.getProblemJpaController().findProblem(id);
    }

    //#############################################
    public static List<Problem> findAll() {
        return service.FactoryJPA.getProblemJpaController().findProblemEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Problem> it = findAll().iterator();
        while (it.hasNext()) {
            Problem obj = it.next();
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        afficher();
    }

    /*

                            @@@@@                                        @@@@@
                            @@@@@@@                                      @@@@@@@
                            @@@@@@@           @@@@@@@@@@@@@@@            @@@@@@@
                             @@@@@@@@       @@@@@@@@@@@@@@@@@@@        @@@@@@@@
                                 @@@@@     @@@@@@@@@@@@@@@@@@@@@     @@@@@
                                   @@@@@  @@@@@@@@@@@@@@@@@@@@@@@  @@@@@
                                     @@  @@@@@@@@@@@@@@@@@@@@@@@@@  @@
                                        @@@@@@@    @@@@@@    @@@@@@
                                        @@@@@@      @@@@      @@@@@
                                        @@@@@@      @@@@      @@@@@
                                         @@@@@@    @@@@@@    @@@@@
                                          @@@@@@@@@@@  @@@@@@@@@@
                                           @@@@@@@@@@  @@@@@@@@@
                                       @@   @@@@@@@@@@@@@@@@@   @@
                                       @@@@  @@@@ @ @ @ @ @@@@  @@@@
                                      @@@@@   @@@ @ @ @ @ @@@   @@@@@
                                    @@@@@      @@@@@@@@@@@@@      @@@@@
                                  @@@@          @@@@@@@@@@@          @@@@
                               @@@@@              @@@@@@@              @@@@@
                              @@@@@@@                                 @@@@@@@
                               @@@@@                                   @@@@@


     */
    public static int countProblemByDate(String code) {
        Iterator<Problem> list = findAll().iterator();
        int nb = 0;
        while (list.hasNext()) {
            Problem problem = list.next();
            String codeDate = problem.getCode().substring(0, 8);
            if (codeDate.equals(code)) {
                nb++;
            }
        }
        return nb;

    }

    public static Problem generateProblem(User user) {

        Date d = new Date();
        String dd, mm, yy;

        if (d.getDate() <= 9) {
            dd = "0" + d.getDate();
        } else {
            dd = d.getDate() + "";
        }

        if ((d.getMonth() + 1) <= 9) {
            mm = "0" + (d.getMonth() + 1);
        } else {
            mm = (d.getMonth() + 1) + "";
        }

        yy = (1900 + d.getYear()) + "";

        String codeDate = yy + mm + dd;

        int num = countProblemByDate(codeDate);
        String code = "";
        if (num <= 9) {
            code = codeDate + "_0" + num;
        } else {
            code = codeDate + "_" + num;
        }

        Problem problem = new Problem();
        //problem.setNum(num);
        problem.setCode(code);
        //problem.setCode_date(codeDate);
        problem.setDateCreation(d);
        problem.setIdUser(user);
        problem.setIdLevel1(user.getIdLevel0().getIdLevel1());
        // problem.setIdStep1(idLevel1);
        // problem.setIdTypeProblem(idLevel1);

        problem.setLevel(1);
        // problem.setReference(idLevel1);
        problem.setStatus("ouvert");
        problem = create(problem);

        return problem;
    }
//**************************************************************************

    public static List<Problem> _filterProblem_date(List<Problem> listProblem, String date) {
        List<Problem> listProblemfiltre = new ArrayList<Problem>();
        Date d = new Date(date);
        for (Problem p : listProblem) {

            Date dateProblem = p.getDateCreation();
            if ((dateProblem.getDate() == d.getDate())
                    && (dateProblem.getMonth() == d.getMonth())
                    && (dateProblem.getYear() == d.getYear())) {
                listProblemfiltre.add(p);
            }
        }
        return listProblemfiltre;
    }

    //**************************************************************************
    public static List<Problem> _filterProblem_today(List<Problem> listProblem) {
        List<Problem> listProblemfiltre = new ArrayList<Problem>();
        Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateToDay = dateFormat.format(actuelle);
        actuelle = new Date(dateToDay);
        for (Problem p : listProblem) {
            Date dateProblem = p.getDateCreation();
            if ((dateProblem.getDate() == actuelle.getDate())
                    && (dateProblem.getMonth() == actuelle.getMonth())
                    && (dateProblem.getYear() == actuelle.getYear())) {
                listProblemfiltre.add(p);
            }
        }
        return listProblemfiltre;
    }

    //**************************************************************************
    public static List<Problem> _filterProblem_month(List<Problem> listProblem) {
        List<Problem> listProblemfiltre = new ArrayList<Problem>();
        Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateToDay = dateFormat.format(actuelle);
        actuelle = new Date(dateToDay);
        for (Problem p : listProblem) {
            Date dateProblem = p.getDateCreation();
            if ((dateProblem.getMonth() == actuelle.getMonth())) {
                listProblemfiltre.add(p);
            }
        }
        return listProblemfiltre;
    }

    //**************************************************************************
    public static List<Problem> _filterProblem_week(List<Problem> listProblem) {
        List<Problem> listProblemfiltre = new ArrayList<Problem>();
        Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(actuelle);
        int thisweek = cal.get(Calendar.WEEK_OF_YEAR);
        for (Problem p : listProblem) {

            Date dateProblem = p.getDateCreation();
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(dateProblem);
            int thisweek1 = cal1.get(Calendar.WEEK_OF_YEAR);
            if ((thisweek1 == thisweek)) {
                listProblemfiltre.add(p);

            }
        }
        return listProblemfiltre;
    }

    //**************************************************************************
    public static List<Problem> _filterProblem_level0(User user) {
        List<Problem> listProblemfiltre = new ArrayList<Problem>();
        if (user.getIdLevel0() != null) {
            return user.getProblemList();
        }
        return listProblemfiltre;
    }
    //**************************************************************************

    public static List<Problem> _filterProblem_level1(User user) {
        List<Problem> listProblemfiltre = new ArrayList<Problem>();
        if (user.getIdLevel0() != null) {
           Level1 l1=user.getIdLevel0().getIdLevel1();
            return l1.getProblemList();
        }
        if (user.getIdLevel1() != null) {
           return user.getIdLevel1().getProblemList();
        }
        return listProblemfiltre;
    }
    //**************************************************************************
}
