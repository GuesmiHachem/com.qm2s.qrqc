/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Nature;
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
public class ServiceNature {

    //#############################################
    public static Nature create(Nature t) {
        return service.FactoryJPA.getNatureJpaController().create(t);
    }

    //#############################################
    public static void edit(Nature t) {
        try {
            service.FactoryJPA.getNatureJpaController().edit(t);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceNature.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceNature.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getNatureJpaController().destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ServiceNature.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceNature.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Nature> it = findAll().iterator();
        while (it.hasNext()) {
            Nature obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Nature find(int id) {
        return service.FactoryJPA.getNatureJpaController().findNature(id);
    }

    //#############################################
    public static List<Nature> findAll() {
        return service.FactoryJPA.getNatureJpaController().findNatureEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Nature> it = findAll().iterator();
        while (it.hasNext()) {
            Nature obj = it.next();
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        afficher();
    }
}
