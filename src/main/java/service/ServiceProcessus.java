/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Processus;
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
public class ServiceProcessus {

    //#############################################
    public static Processus create(Processus t) {
        return service.FactoryJPA.getProcessusJpaController().create(t);
    }

    //#############################################
    public static void edit(Processus t) {
        try {
            service.FactoryJPA.getProcessusJpaController().edit(t);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceProcessus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceProcessus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getProcessusJpaController().destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ServiceProcessus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceProcessus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Processus> it = findAll().iterator();
        while (it.hasNext()) {
            Processus obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Processus find(int id) {
        return service.FactoryJPA.getProcessusJpaController().findProcessus(id);
    }

    //#############################################
    public static List<Processus> findAll() {
        return service.FactoryJPA.getProcessusJpaController().findProcessusEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Processus> it = findAll().iterator();
        while (it.hasNext()) {
            Processus obj = it.next();
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        afficher();
        
    }
}
