/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.TypeUser;
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
public class ServiceTypeUser {

    //#############################################
    public static TypeUser create(TypeUser t) {
        return service.FactoryJPA.getTypeUserJpaController().create(t);
    }

    //#############################################
    public static void edit(TypeUser t) {
        try {
            service.FactoryJPA.getTypeUserJpaController().edit(t);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceTypeUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceTypeUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getTypeUserJpaController().destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ServiceTypeUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceTypeUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<TypeUser> it = findAll().iterator();
        while (it.hasNext()) {
            TypeUser obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static TypeUser find(int id) {
        return service.FactoryJPA.getTypeUserJpaController().findTypeUser(id);
    }

    //#############################################
    public static List<TypeUser> findAll() {
        return service.FactoryJPA.getTypeUserJpaController().findTypeUserEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<TypeUser> it = findAll().iterator();
        while (it.hasNext()) {
            TypeUser obj = it.next();
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        afficher();
    }
}
