/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import entity.Level2;
import entity.Level3;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class Level3JpaController implements Serializable {

    public Level3JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Level3 create(Level3 level3) {
        if (level3.getUserList() == null) {
            level3.setUserList(new ArrayList<User>());
        }
        if (level3.getLevel2List() == null) {
            level3.setLevel2List(new ArrayList<Level2>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<User> attachedUserList = new ArrayList<User>();
            for (User userListUserToAttach : level3.getUserList()) {
                userListUserToAttach = em.getReference(userListUserToAttach.getClass(), userListUserToAttach.getId());
                attachedUserList.add(userListUserToAttach);
            }
            level3.setUserList(attachedUserList);
            List<Level2> attachedLevel2List = new ArrayList<Level2>();
            for (Level2 level2ListLevel2ToAttach : level3.getLevel2List()) {
                level2ListLevel2ToAttach = em.getReference(level2ListLevel2ToAttach.getClass(), level2ListLevel2ToAttach.getId());
                attachedLevel2List.add(level2ListLevel2ToAttach);
            }
            level3.setLevel2List(attachedLevel2List);
            em.persist(level3);
            for (User userListUser : level3.getUserList()) {
                Level3 oldIdLevel3OfUserListUser = userListUser.getIdLevel3();
                userListUser.setIdLevel3(level3);
                userListUser = em.merge(userListUser);
                if (oldIdLevel3OfUserListUser != null) {
                    oldIdLevel3OfUserListUser.getUserList().remove(userListUser);
                    oldIdLevel3OfUserListUser = em.merge(oldIdLevel3OfUserListUser);
                }
            }
            for (Level2 level2ListLevel2 : level3.getLevel2List()) {
                Level3 oldIdLevel3OfLevel2ListLevel2 = level2ListLevel2.getIdLevel3();
                level2ListLevel2.setIdLevel3(level3);
                level2ListLevel2 = em.merge(level2ListLevel2);
                if (oldIdLevel3OfLevel2ListLevel2 != null) {
                    oldIdLevel3OfLevel2ListLevel2.getLevel2List().remove(level2ListLevel2);
                    oldIdLevel3OfLevel2ListLevel2 = em.merge(oldIdLevel3OfLevel2ListLevel2);
                }
            }
            em.getTransaction().commit();
            return level3;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Level3 level3) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Level3 persistentLevel3 = em.find(Level3.class, level3.getId());
            List<User> userListOld = persistentLevel3.getUserList();
            List<User> userListNew = level3.getUserList();
            List<Level2> level2ListOld = persistentLevel3.getLevel2List();
            List<Level2> level2ListNew = level3.getLevel2List();
            List<String> illegalOrphanMessages = null;
            for (Level2 level2ListOldLevel2 : level2ListOld) {
                if (!level2ListNew.contains(level2ListOldLevel2)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Level2 " + level2ListOldLevel2 + " since its idLevel3 field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<User> attachedUserListNew = new ArrayList<User>();
            for (User userListNewUserToAttach : userListNew) {
                userListNewUserToAttach = em.getReference(userListNewUserToAttach.getClass(), userListNewUserToAttach.getId());
                attachedUserListNew.add(userListNewUserToAttach);
            }
            userListNew = attachedUserListNew;
            level3.setUserList(userListNew);
            List<Level2> attachedLevel2ListNew = new ArrayList<Level2>();
            for (Level2 level2ListNewLevel2ToAttach : level2ListNew) {
                level2ListNewLevel2ToAttach = em.getReference(level2ListNewLevel2ToAttach.getClass(), level2ListNewLevel2ToAttach.getId());
                attachedLevel2ListNew.add(level2ListNewLevel2ToAttach);
            }
            level2ListNew = attachedLevel2ListNew;
            level3.setLevel2List(level2ListNew);
            level3 = em.merge(level3);
            for (User userListOldUser : userListOld) {
                if (!userListNew.contains(userListOldUser)) {
                    userListOldUser.setIdLevel3(null);
                    userListOldUser = em.merge(userListOldUser);
                }
            }
            for (User userListNewUser : userListNew) {
                if (!userListOld.contains(userListNewUser)) {
                    Level3 oldIdLevel3OfUserListNewUser = userListNewUser.getIdLevel3();
                    userListNewUser.setIdLevel3(level3);
                    userListNewUser = em.merge(userListNewUser);
                    if (oldIdLevel3OfUserListNewUser != null && !oldIdLevel3OfUserListNewUser.equals(level3)) {
                        oldIdLevel3OfUserListNewUser.getUserList().remove(userListNewUser);
                        oldIdLevel3OfUserListNewUser = em.merge(oldIdLevel3OfUserListNewUser);
                    }
                }
            }
            for (Level2 level2ListNewLevel2 : level2ListNew) {
                if (!level2ListOld.contains(level2ListNewLevel2)) {
                    Level3 oldIdLevel3OfLevel2ListNewLevel2 = level2ListNewLevel2.getIdLevel3();
                    level2ListNewLevel2.setIdLevel3(level3);
                    level2ListNewLevel2 = em.merge(level2ListNewLevel2);
                    if (oldIdLevel3OfLevel2ListNewLevel2 != null && !oldIdLevel3OfLevel2ListNewLevel2.equals(level3)) {
                        oldIdLevel3OfLevel2ListNewLevel2.getLevel2List().remove(level2ListNewLevel2);
                        oldIdLevel3OfLevel2ListNewLevel2 = em.merge(oldIdLevel3OfLevel2ListNewLevel2);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = level3.getId();
                if (findLevel3(id) == null) {
                    throw new NonexistentEntityException("The level3 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Level3 level3;
            try {
                level3 = em.getReference(Level3.class, id);
                level3.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The level3 with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Level2> level2ListOrphanCheck = level3.getLevel2List();
            for (Level2 level2ListOrphanCheckLevel2 : level2ListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Level3 (" + level3 + ") cannot be destroyed since the Level2 " + level2ListOrphanCheckLevel2 + " in its level2List field has a non-nullable idLevel3 field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<User> userList = level3.getUserList();
            for (User userListUser : userList) {
                userListUser.setIdLevel3(null);
                userListUser = em.merge(userListUser);
            }
            em.remove(level3);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Level3> findLevel3Entities() {
        return findLevel3Entities(true, -1, -1);
    }

    public List<Level3> findLevel3Entities(int maxResults, int firstResult) {
        return findLevel3Entities(false, maxResults, firstResult);
    }

    private List<Level3> findLevel3Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Level3.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Level3 findLevel3(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Level3.class, id);
        } finally {
            em.close();
        }
    }

    public int getLevel3Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Level3> rt = cq.from(Level3.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
