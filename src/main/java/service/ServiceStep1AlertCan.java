/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Step1AlertCan;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.exceptions.NonexistentEntityException;


/**
 *
 * @author Hachem
 */
public class ServiceStep1AlertCan {

     //#############################################
    public static Step1AlertCan create(Step1AlertCan t) {
        return service.FactoryJPA.getStep1AlertCanJpaController().create(t);
    }

    //#############################################
    public static void edit(Step1AlertCan t) {
        try {
            service.FactoryJPA.getStep1AlertCanJpaController().edit(t);
        } catch (Exception ex) {
            Logger.getLogger(ServiceStep1AlertCan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getStep1AlertCanJpaController().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceStep1AlertCan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Step1AlertCan> it = findAll().iterator();
        while (it.hasNext()) {
            Step1AlertCan obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Step1AlertCan find(int id) {
        return service.FactoryJPA.getStep1AlertCanJpaController().findStep1AlertCan(id);
    }

    //#############################################
    public static List<Step1AlertCan> findAll() {
        return service.FactoryJPA.getStep1AlertCanJpaController().findStep1AlertCanEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Step1AlertCan> it = findAll().iterator();
        while (it.hasNext()) {
            Step1AlertCan obj = it.next();
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        afficher();
    }
}
