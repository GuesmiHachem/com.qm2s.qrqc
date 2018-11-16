/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Level0;
import entity.Level1;
import entity.Step1;
import entity.Step1ActionFollowed;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class ServiceStep1ActionFollowed {

    //#############################################
    public static Step1ActionFollowed create(Step1ActionFollowed t) {
        return service.FactoryJPA.getStep1ActionFollowedJpaController().create(t);
    }

    //#############################################
    public static void edit(Step1ActionFollowed t) {
        try {
            service.FactoryJPA.getStep1ActionFollowedJpaController().edit(t);
        } catch (Exception ex) {
            Logger.getLogger(Step1ActionFollowed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getStep1ActionFollowedJpaController().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Step1ActionFollowed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Step1ActionFollowed> it = findAll().iterator();
        while (it.hasNext()) {
            Step1ActionFollowed obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Step1ActionFollowed find(int id) {
        return service.FactoryJPA.getStep1ActionFollowedJpaController().findStep1ActionFollowed(id);
    }

    //#############################################
    public static List<Step1ActionFollowed> findAll() {
        return service.FactoryJPA.getStep1ActionFollowedJpaController().findStep1ActionFollowedEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Step1ActionFollowed> it = findAll().iterator();
        while (it.hasNext()) {
            Step1ActionFollowed obj = it.next();
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        afficher();
    }

    public static void doStep1ActionFollowed(Step1 step1, Level0 level0) {
        List<Level0> listLevel0 = ServiceLevel1.getList5Level0(level0);
        for (Level0 l0 : listLevel0) {
            Step1ActionFollowed step1ActionFollowed = new Step1ActionFollowed();
            step1ActionFollowed.setIdLevel0(l0);
            step1ActionFollowed.setIdStep1(step1);
            step1ActionFollowed.setEffective(false);
            step1ActionFollowed.setToBeFollowed(false);
            create(step1ActionFollowed);
        }

    }

    public static int getStep1ActionFollowedToBeFollowed(Step1 step1) {
        List<Step1ActionFollowed> list = step1.getStep1ActionFollowedList();
        int nb = 0;
        for (Step1ActionFollowed step1ActionFollowed : list) {
            if (step1ActionFollowed.getToBeFollowed()) {
                nb++;
            }
        }
        return nb;
    }

}
