/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.TypeProblem;
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
public class ServiceTypeProblem {

     //#############################################
    public static TypeProblem create(TypeProblem t) {
        return service.FactoryJPA.getTypeProblemJpaController().create(t);
    }

    //#############################################
    public static void edit(TypeProblem t) {
        try {
            service.FactoryJPA.getTypeProblemJpaController().edit(t);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceTypeProblem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceTypeProblem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getTypeProblemJpaController().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceTypeProblem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<TypeProblem> it = findAll().iterator();
        while (it.hasNext()) {
            TypeProblem obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static TypeProblem find(int id) {
        return service.FactoryJPA.getTypeProblemJpaController().findTypeProblem(id);
    }

    //#############################################
    public static List<TypeProblem> findAll() {
        return service.FactoryJPA.getTypeProblemJpaController().findTypeProblemEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<TypeProblem> it = findAll().iterator();
        while (it.hasNext()) {
            TypeProblem obj = it.next();
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        afficher();
    }
}
