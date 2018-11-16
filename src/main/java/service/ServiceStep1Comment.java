/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Step1Comment;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class ServiceStep1Comment {

    //#############################################
    public static Step1Comment create(Step1Comment t) {
        return service.FactoryJPA.getStep1CommentJpaController().create(t);
    }

    //#############################################
    public static void edit(Step1Comment t) {
        try {
            service.FactoryJPA.getStep1CommentJpaController().edit(t);
        } catch (Exception ex) {
            Logger.getLogger(ServiceStep1Comment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getStep1CommentJpaController().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceStep1Comment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Step1Comment> it = findAll().iterator();
        while (it.hasNext()) {
            Step1Comment obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Step1Comment find(int id) {
        return service.FactoryJPA.getStep1CommentJpaController().findStep1Comment(id);
    }

    //#############################################
    public static List<Step1Comment> findAll() {
        return service.FactoryJPA.getStep1CommentJpaController().findStep1CommentEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Step1Comment> it = findAll().iterator();
        while (it.hasNext()) {
            Step1Comment obj = it.next();
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
