/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Level0;
import entity.Level1;
import entity.Level2;
import entity.Level2Relation;
import entity.Level3;
import entity.Notification;
import entity.Problem;
import entity.TypeUser;
import entity.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.exceptions.NonexistentEntityException;
import mail.Mailer;

/**
 *
 * @author Hachem
 */
public class ServiceNotification {

    //#############################################
    public static Notification create(Notification t) {
        return service.FactoryJPA.getNotificationJpaController().create(t);
    }

    //#############################################
    public static void edit(Notification t) {
        try {
            service.FactoryJPA.getNotificationJpaController().edit(t);
        } catch (Exception ex) {
            Logger.getLogger(ServiceNotification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getNotificationJpaController().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceNotification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Notification> it = findAll().iterator();
        while (it.hasNext()) {
            Notification obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Notification find(int id) {
        return service.FactoryJPA.getNotificationJpaController().findNotification(id);
    }

    //#############################################
    public static List<Notification> findAll() {
        return service.FactoryJPA.getNotificationJpaController().findNotificationEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Notification> it = findAll().iterator();
        while (it.hasNext()) {
            Notification obj = it.next();
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        afficher();
    }

    public static List<User> getListUserOfLevel2RelationList(Level2 level2) {
        List<Level2Relation> list = level2.getLevel2RelationList();
        List<User> listUserReturn = new ArrayList<User>();
        for (Level2Relation level2Relation : list) {
            if (level2Relation.getIdLevel2P1().equals(level2)) {
                listUserReturn.addAll(level2Relation.getIdLevel2P2().getUserList());
            } else {
                listUserReturn.addAll(level2Relation.getIdLevel2P1().getUserList());
            }
        }
        return listUserReturn;
    }

    public static List<User> getAllUserRelatedToThisLevel(Level0 level0) {

        List<User> listUserReturn = new ArrayList<User>();
        Level1 level1 = level0.getIdLevel1();
        listUserReturn = getAllUserRelatedToThisLevel(level1);
        return listUserReturn;
    }

    public static List<User> getAllUserRelatedToThisLevel(Level2 level2) {

        List<User> listUserReturn = new ArrayList<User>();
        List<Level1> listLevel1 = level2.getLevel1List();
        for (Level1 level1 : listLevel1) {
            listUserReturn.addAll(getAllUserRelatedToThisLevel(level1));
        }
        return listUserReturn;
    }

    public static List<User> getAllUserRelatedToThisLevel(Level3 level3) {

        List<User> listUserReturn = new ArrayList<User>();
        List<Level2> listLevel2 = level3.getLevel2List();
        for (Level2 level2 : listLevel2) {
            listUserReturn.addAll(getAllUserRelatedToThisLevel(level2));
        }
        return listUserReturn;
    }

    public static List<User> getAllUserRelatedToThisLevel(Level1 level1) {

        List<User> listUserReturn = new ArrayList<User>();
        for (Level0 level0 : level1.getLevel0List()) {
            listUserReturn.addAll(level0.getUserList());
        }

        listUserReturn.addAll(level1.getUserList());
        Level2 level2 = level1.getIdLevel2();
        if (level2 != null) {
            listUserReturn.addAll(level2.getUserList());
            listUserReturn.addAll(getListUserOfLevel2RelationList(level2));
            Level3 level3 = level2.getIdLevel3();
            if (level3 != null) {
                listUserReturn.addAll(level3.getUserList());
            }
        }
        return listUserReturn;
    }

    public static void doNotification(Problem problem) {

        User user = problem.getIdUser();
        List<User> listAllUserReturn = new ArrayList<User>();
        List<User> listAllUserRelated = new ArrayList<User>();
        if (user.getIdLevel0() != null) {
            listAllUserRelated = getAllUserRelatedToThisLevel(user.getIdLevel0());
        } else if (user.getIdLevel1() != null) {
            listAllUserRelated = getAllUserRelatedToThisLevel(user.getIdLevel1());
        } else if (user.getIdLevel2() != null) {
            listAllUserRelated = getAllUserRelatedToThisLevel(user.getIdLevel2());
        } else if (user.getIdLevel3() != null) {
            listAllUserRelated = getAllUserRelatedToThisLevel(user.getIdLevel3());
        }

        List<TypeUser> listTypeUserReturn = ServiceStep1AlertShould.getListTypeUser(problem.getIdStep1().getStep1AlertShouldList());

        for (User u : listAllUserRelated) {
            TypeUser tu = u.getIdTypeUser();
            if (listTypeUserReturn.contains(tu)) {
                listAllUserReturn.add(u);
            }
        }

        for (User u : listAllUserReturn) {
            Notification not = new Notification();
            not.setTitle(problem.getIdUser().getFirstName() + " " + problem.getIdUser().getName() + " a partagé avec vous le probléme " + problem.getCode());
            not.setIdProblem(problem);
            not.setIdUser(u);
            not.setDateCreation(new Date(new Date().getTime()));
            ServiceNotification.create(not);
            if (!u.getEmail().equals("")) {
                //Mailer.send(" e-QRQC V1.0 ", "idev.hachem@gmail.com", "98687465.aA", u.getEmail(), "Problem:"+problem.getCode(), "vvvvvv vvvvv gg");
                Mailer.sendProblem(" e-QRQC V1.0 ", "idev.hachem@gmail.com", "98687465.aA", u, problem);

            }

        }

    }

}
