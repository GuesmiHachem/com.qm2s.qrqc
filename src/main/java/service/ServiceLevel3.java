/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import entity.Level3;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;
/**
 *
 * @author Hachem
 */
public class ServiceLevel3 {

      //#############################################
    public static Level3 create(Level3 t) {
        return service.FactoryJPA.getLevel3JpaController().create(t);
    }

    //#############################################
    public static void edit(Level3 t) {
        try {
            service.FactoryJPA.getLevel3JpaController().edit(t);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceLevel3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceLevel3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getLevel3JpaController().destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ServiceLevel3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceLevel3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Level3> it = findAll().iterator();
        while (it.hasNext()) {
            Level3 obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Level3 find(int id) {
        return service.FactoryJPA.getLevel3JpaController().findLevel3(id);
    }

    //#############################################
    public static List<Level3> findAll() {
        return service.FactoryJPA.getLevel3JpaController().findLevel3Entities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Level3> it = findAll().iterator();
        while (it.hasNext()) {
            Level3 obj = it.next();
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        afficher();
    }
}
