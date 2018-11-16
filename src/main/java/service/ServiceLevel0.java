/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import entity.*;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class ServiceLevel0 {

    //#############################################
    public static Level0 create(Level0 t) {
        return service.FactoryJPA.getLevel0JpaController().create(t);
    }

    //#############################################
    public static void edit(Level0 t) {
        try {
            service.FactoryJPA.getLevel0JpaController().edit(t);
        } catch (Exception ex) {
            Logger.getLogger(ServiceLevel0.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getLevel0JpaController().destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ServiceLevel0.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceLevel0.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Level0> it = findAll().iterator();
        while (it.hasNext()) {
            Level0 obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Level0 find(int _id) {
        return service.FactoryJPA.getLevel0JpaController().findLevel0(_id);
    }

    //#############################################
    public static List<Level0> findAll() {
        return service.FactoryJPA.getLevel0JpaController().findLevel0Entities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Level0> it = findAll().iterator();
        while (it.hasNext()) {
            Level0 obj = it.next();
            System.out.println(obj);
        }
    }
    
    

    public static void main(String[] args) {
        afficher();
    }
}
