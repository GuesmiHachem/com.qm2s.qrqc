/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import entity.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class ServiceLevel1 {

    //#############################################
    public static Level1 create(Level1 t) {
        return service.FactoryJPA.getLevel1JpaController().create(t);
    }

    //#############################################
    public static void edit(Level1 t) {
        try {
            service.FactoryJPA.getLevel1JpaController().edit(t);
        } catch (Exception ex) {
            Logger.getLogger(ServiceLevel1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getLevel1JpaController().destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ServiceLevel1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceLevel1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<Level1> it = findAll().iterator();
        while (it.hasNext()) {
            Level1 obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static Level1 find(int _id) {
        return service.FactoryJPA.getLevel1JpaController().findLevel1(_id);
    }

    //#############################################
    public static List<Level1> findAll() {
        return service.FactoryJPA.getLevel1JpaController().findLevel1Entities();
    }

    //#############################################
    public static void afficher() {
        Iterator<Level1> it = findAll().iterator();
        while (it.hasNext()) {
            Level1 obj = it.next();
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        afficher();
    }

    public static List<Level0> getList5Level0(Level0 level0) {
        Level1 level1 = level0.getIdLevel1();
        List<Level0> listReturn = new ArrayList<Level0>(5);
        List<Level0> listAll = new ArrayList<Level0>();
        if (level1 != null) {
            List<Level0> listLevel0 = level1.getLevel0List();
            listAll.addAll(listLevel0);
            listAll.addAll(listLevel0);
            listAll.addAll(listLevel0);
            listAll.addAll(listLevel0);
            listAll.addAll(listLevel0);
            int indexLevel0 = listAll.indexOf(level0);

            for (int i = indexLevel0; i < indexLevel0 + 5; i++) {
                Level0 l0 = listAll.get(i);
                listReturn.add(l0);
            }
        }
        return listReturn;
    }

}
