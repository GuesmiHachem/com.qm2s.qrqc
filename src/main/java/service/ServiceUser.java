/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.User;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class ServiceUser {

    //#############################################
    public static User create(User t) {
        return service.FactoryJPA.getUserJpaController().create(t);
    }

    //#############################################
    public static void edit(User t) {
        try {
            service.FactoryJPA.getUserJpaController().edit(t);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroy(int id) {
        try {
            service.FactoryJPA.getUserJpaController().destroy(id);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //#############################################
    public static void destroyAll() {
        Iterator<User> it = findAll().iterator();
        while (it.hasNext()) {
            User obj = it.next();
            destroy(obj.getId());
        }
    }

    //#############################################
    public static User find(int id) {
        return service.FactoryJPA.getUserJpaController().findUser(id);
    }

    //#############################################
    public static List<User> findAll() {
        return service.FactoryJPA.getUserJpaController().findUserEntities();
    }

    //#############################################
    public static void afficher() {
        Iterator<User> it = findAll().iterator();
        while (it.hasNext()) {
            User obj = it.next();
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        afficher();
    }

    /*

                            @@@@@                                        @@@@@
                            @@@@@@@                                      @@@@@@@
                            @@@@@@@           @@@@@@@@@@@@@@@            @@@@@@@
                             @@@@@@@@       @@@@@@@@@@@@@@@@@@@        @@@@@@@@
                                 @@@@@     @@@@@@@@@@@@@@@@@@@@@     @@@@@
                                   @@@@@  @@@@@@@@@@@@@@@@@@@@@@@  @@@@@
                                     @@  @@@@@@@@@@@@@@@@@@@@@@@@@  @@
                                        @@@@@@@    @@@@@@    @@@@@@
                                        @@@@@@      @@@@      @@@@@
                                        @@@@@@      @@@@      @@@@@
                                         @@@@@@    @@@@@@    @@@@@
                                          @@@@@@@@@@@  @@@@@@@@@@
                                           @@@@@@@@@@  @@@@@@@@@
                                       @@   @@@@@@@@@@@@@@@@@   @@
                                       @@@@  @@@@ @ @ @ @ @@@@  @@@@
                                      @@@@@   @@@ @ @ @ @ @@@   @@@@@
                                    @@@@@      @@@@@@@@@@@@@      @@@@@
                                  @@@@          @@@@@@@@@@@          @@@@
                               @@@@@              @@@@@@@              @@@@@
                              @@@@@@@                                 @@@@@@@
                               @@@@@                                   @@@@@


     */
    //#############################################
    public static User exist(String login, String password) {
        User user = null;
        Iterator<User> it = findAll().iterator();
        while (it.hasNext()) {
            user = it.next();
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }

        }
        return null;
    }

    public static HttpSession refreshSessionUser(HttpSession session) {
        User userContent = (User) session.getAttribute("user");
        if (userContent != null) {
            User u = exist(userContent.getLogin(), userContent.getPassword());
            session.setAttribute("user", u);
        }
        return session;
    }

}
