/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Step1;
import entity.Step1AlertCan;
import entity.Step1AlertShould;
import entity.Step1View;
import entity.TypeUser;
import entity.User;
import java.util.ArrayList;
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
public class ServiceStep1 {

    //#############################################
    public static Step1 create(Step1 t) {
        return service.FactoryJPA.getStep1JpaController().create(t);
    }

    //#############################################
    public static void edit(Step1 t) {
        try {
            service.FactoryJPA.getStep1JpaController().edit(t);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceStep1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceStep1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getStep1JpaController().destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ServiceStep1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceStep1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Step1> it = findAll().iterator();
        while (it.hasNext()) {
            Step1 obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Step1 find(int id) {
        return service.FactoryJPA.getStep1JpaController().findStep1(id);
    }

    //#############################################
    public static List<Step1> findAll() {
        return service.FactoryJPA.getStep1JpaController().findStep1Entities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Step1> it = findAll().iterator();
        while (it.hasNext()) {
            Step1 obj = it.next();
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
    public static List<TypeUser> getListTypeUserCan(Step1 step1) {
        List<Step1AlertCan> listStep1AlertCan = step1.getStep1AlertCanList();
        List<TypeUser> listTypeUser = new ArrayList<TypeUser>();
        for (Step1AlertCan step1AlertCan : listStep1AlertCan) {
            TypeUser typeUser = step1AlertCan.getIdTypeUser();
            listTypeUser.add(typeUser);
        }
        return listTypeUser;
    }

    public static List<TypeUser> getListTypeUserShould(Step1 step1) {
        List<Step1AlertShould> listStep1AlertShould = step1.getStep1AlertShouldList();
        List<TypeUser> listTypeUser = new ArrayList<TypeUser>();
        for (Step1AlertShould step1AlertShould : listStep1AlertShould) {
            TypeUser typeUser = step1AlertShould.getIdTypeUser();
            listTypeUser.add(typeUser);
        }
        return listTypeUser;
    }

    public static boolean isStep1ViewByUser(Step1 step1, User user) {

        List<Step1View> listStep1ViewList = user.getStep1ViewList();

        for (Step1View step1View : listStep1ViewList) {

            if (step1View.getIdStep1().equals(step1)) {
                return true;
            }
        }
        return false;
    }
}
