/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Step1AlertShould;
import entity.TypeUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class ServiceStep1AlertShould {

     //#############################################
    public static Step1AlertShould create(Step1AlertShould t) {
        return service.FactoryJPA.getStep1AlertShouldJpaController().create(t);
    }

    //#############################################
    public static void edit(Step1AlertShould t) {
        try {
            service.FactoryJPA.getStep1AlertShouldJpaController().edit(t);
        } catch (Exception ex) {
            Logger.getLogger(ServiceStep1AlertShould.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getStep1AlertShouldJpaController().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceStep1AlertShould.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Step1AlertShould> it = findAll().iterator();
        while (it.hasNext()) {
            Step1AlertShould obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Step1AlertShould find(int id) {
        return service.FactoryJPA.getStep1AlertShouldJpaController().findStep1AlertShould(id);
    }

    //#############################################
    public static List<Step1AlertShould> findAll() {
        return service.FactoryJPA.getStep1AlertShouldJpaController().findStep1AlertShouldEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Step1AlertShould> it = findAll().iterator();
        while (it.hasNext()) {
            Step1AlertShould obj = it.next();
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        afficher();
    }
    
    public static List<TypeUser> getListTypeUser(List<Step1AlertShould> listStep1AlertShould ) {
      List<TypeUser> listTypeUserReturn =new ArrayList<TypeUser>();
      for(Step1AlertShould step1AlertShould:listStep1AlertShould)
      {
          listTypeUserReturn.add(step1AlertShould.getIdTypeUser());
      }
      return listTypeUserReturn;
    }
    
}
