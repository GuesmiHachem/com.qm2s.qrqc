/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import entity.Level2;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class ServiceLevel2 {

    //#############################################
    public static Level2 create(Level2 t) {
        return service.FactoryJPA.getLevel2JpaController().create(t);
    }

    //#############################################
    public static void edit(Level2 t) {
        try {
            service.FactoryJPA.getLevel2JpaController().edit(t);
        } catch (Exception ex) {
            Logger.getLogger(ServiceLevel2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getLevel2JpaController().destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ServiceLevel2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceLevel2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Level2> it = findAll().iterator();
        while (it.hasNext()) {
            Level2 obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Level2 find(int _id) {
        return service.FactoryJPA.getLevel2JpaController().findLevel2(_id);
    }

    //#############################################
    public static List<Level2> findAll() {
        return service.FactoryJPA.getLevel2JpaController().findLevel2Entities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Level2> it = findAll().iterator();
        while (it.hasNext()) {
            Level2 obj = it.next();
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        afficher();
    }
}
