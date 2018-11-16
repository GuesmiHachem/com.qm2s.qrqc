/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Step1Comment;
import entity.Step1View;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class ServiceStep1View {

    //#############################################
    public static Step1View create(Step1View t) {
        return service.FactoryJPA.getStep1ViewJpaController().create(t);
    }

    //#############################################
    public static void edit(Step1View t) {
        try {
            service.FactoryJPA.getStep1ViewJpaController().edit(t);
        } catch (Exception ex) {
            Logger.getLogger(ServiceStep1View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getStep1ViewJpaController().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceStep1View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Step1View> it = findAll().iterator();
        while (it.hasNext()) {
            Step1View obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Step1View find(int id) {
        return service.FactoryJPA.getStep1ViewJpaController().findStep1View(id);
    }

    //#############################################
    public static List<Step1View> findAll() {
        return service.FactoryJPA.getStep1ViewJpaController().findStep1ViewEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Step1View> it = findAll().iterator();
        while (it.hasNext()) {
            Step1View obj = it.next();
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
    //#############################################
   
    
    
}
