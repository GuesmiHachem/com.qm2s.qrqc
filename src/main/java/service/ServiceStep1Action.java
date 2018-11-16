/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Step1;
import entity.Step1Action;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class ServiceStep1Action {

    //#############################################
    public static Step1Action create(Step1Action t) {
        return service.FactoryJPA.getStep1ActionJpaController().create(t);
    }

    //#############################################
    public static void edit(Step1Action t) {
        try {
            service.FactoryJPA.getStep1ActionJpaController().edit(t);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceProcessus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceProcessus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getStep1ActionJpaController().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceStep1Action.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Step1Action> it = findAll().iterator();
        while (it.hasNext()) {
            Step1Action obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Step1Action find(int id) {
        return service.FactoryJPA.getStep1ActionJpaController().findStep1Action(id);
    }

    //#############################################
    public static List<Step1Action> findAll() {
        return service.FactoryJPA.getStep1ActionJpaController().findStep1ActionEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Step1Action> it = findAll().iterator();
        while (it.hasNext()) {
            Step1Action obj = it.next();
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        afficher();
    }

    public static boolean isAllActionDoing(Step1 step1) {
        List<Step1Action> list = step1.getStep1ActionList();
        for (Step1Action step1Action : list) {
            if (step1Action.getPercentageCompleted()!= 100) {
                return false;
            }

        }
        return true;

    }

}
