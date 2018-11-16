/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import entity.Hardware;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class ServiceHardware {

//#############################################
    public static Hardware create(Hardware t) {
        return service.FactoryJPA.getHardwareJpaController().create(t);
    }

    //#############################################
    public static void edit(Hardware t) {
        try {
            service.FactoryJPA.getHardwareJpaController().edit(t);
        } catch (Exception ex) {
            Logger.getLogger(ServiceHardware.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getHardwareJpaController().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceHardware.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Hardware> it = findAll().iterator();
        while (it.hasNext()) {
            Hardware obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Hardware find(int id) {
        return service.FactoryJPA.getHardwareJpaController().findHardware(id);
    }

    //#############################################
    public static List<Hardware> findAll() {
        return service.FactoryJPA.getHardwareJpaController().findHardwareEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Hardware> it = findAll().iterator();
        while (it.hasNext()) {
            Hardware obj = it.next();
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