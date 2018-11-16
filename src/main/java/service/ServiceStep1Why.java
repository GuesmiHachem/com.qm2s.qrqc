/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;



import entity.Step1Why;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.exceptions.NonexistentEntityException;


/**
 *
 * @author Hachem
 */
public class ServiceStep1Why {

     //#############################################
    public static Step1Why create(Step1Why t) {
        return service.FactoryJPA.getStep1WhyJpaController().create(t);
    }

    //#############################################
    public static void edit(Step1Why t) {
        try {
            service.FactoryJPA.getStep1WhyJpaController().edit(t);
        } catch (Exception ex) {
            Logger.getLogger(ServiceStep1Why.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getStep1WhyJpaController().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceStep1Why.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Step1Why> it = findAll().iterator();
        while (it.hasNext()) {
            Step1Why obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Step1Why find(int id) {
        return service.FactoryJPA.getStep1WhyJpaController().findStep1Why(id);
    }

    //#############################################
    public static List<Step1Why> findAll() {
        return service.FactoryJPA.getStep1WhyJpaController().findStep1WhyEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Step1Why> it = findAll().iterator();
        while (it.hasNext()) {
            Step1Why obj = it.next();
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        afficher();
    }
}
