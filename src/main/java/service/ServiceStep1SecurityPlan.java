/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Step1Securisation;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.exceptions.NonexistentEntityException;


/**
 *
 * @author Hachem
 */
public class ServiceStep1SecurityPlan {

    //#############################################
    public static Step1Securisation create(Step1Securisation t) {
        return service.FactoryJPA.getStep1SecurisationJpaController().create(t);
    }

    //#############################################
    public static void edit(Step1Securisation t) {
        try {
            service.FactoryJPA.getStep1SecurisationJpaController().edit(t);
        } catch (Exception ex) {
            Logger.getLogger(ServiceStep1SecurityPlan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getStep1SecurisationJpaController().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceStep1SecurityPlan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Step1Securisation> it = findAll().iterator();
        while (it.hasNext()) {
            Step1Securisation obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Step1Securisation find(int id) {
        return service.FactoryJPA.getStep1SecurisationJpaController().findStep1Securisation(id);
    }

    //#############################################
    public static List<Step1Securisation> findAll() {
        return service.FactoryJPA.getStep1SecurisationJpaController().findStep1SecurisationEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Step1Securisation> it = findAll().iterator();
        while (it.hasNext()) {
            Step1Securisation obj = it.next();
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        afficher();
    }
}
