/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Level2Relation;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class ServiceLevel2Relation {

    //#############################################
    public static Level2Relation create(Level2Relation t) {
        return service.FactoryJPA.getLevel2RelationJpaController().create(t);
    }

    //#############################################
    public static void edit(Level2Relation t) {
        try {
            service.FactoryJPA.getLevel2RelationJpaController().edit(t);
        } catch (Exception ex) {
            Logger.getLogger(ServiceLevel2Relation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getLevel2RelationJpaController().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceLevel2Relation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Level2Relation> it = findAll().iterator();
        while (it.hasNext()) {
            Level2Relation obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Level2Relation find(int id) {
        return service.FactoryJPA.getLevel2RelationJpaController().findLevel2Relation(id);
    }

    //#############################################
    public static List<Level2Relation> findAll() {
        return service.FactoryJPA.getLevel2RelationJpaController().findLevel2RelationEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Level2Relation> it = findAll().iterator();
        while (it.hasNext()) {
            Level2Relation obj = it.next();
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
}
