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
import entity.Level3;
import entity.Processus;
import entity.Level2Relation;
import java.util.ArrayList;
import java.util.List;
import entity.Level1;
import entity.Level2;
import entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class Level2JpaController implements Serializable {

    public Level2JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Level2 create(Level2 level2) {
        if (level2.getLevel2RelationList() == null) {
            level2.setLevel2RelationList(new ArrayList<Level2Relation>());
        }
        if (level2.getLevel2RelationList1() == null) {
            level2.setLevel2RelationList1(new ArrayList<Level2Relation>());
        }
        if (level2.getLevel1List() == null) {
            level2.setLevel1List(new ArrayList<Level1>());
        }
        if (level2.getUserList() == null) {
            level2.setUserList(new ArrayList<User>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Level3 idLevel3 = level2.getIdLevel3();
            if (idLevel3 != null) {
                idLevel3 = em.getReference(idLevel3.getClass(), idLevel3.getId());
                level2.setIdLevel3(idLevel3);
            }
            Processus idProcessus = level2.getIdProcessus();
            if (idProcessus != null) {
                idProcessus = em.getReference(idProcessus.getClass(), idProcessus.getId());
                level2.setIdProcessus(idProcessus);
            }
            List<Level2Relation> attachedLevel2RelationList = new ArrayList<Level2Relation>();
            for (Level2Relation level2RelationListLevel2RelationToAttach : level2.getLevel2RelationList()) {
                level2RelationListLevel2RelationToAttach = em.getReference(level2RelationListLevel2RelationToAttach.getClass(), level2RelationListLevel2RelationToAttach.getId());
                attachedLevel2RelationList.add(level2RelationListLevel2RelationToAttach);
            }
            level2.setLevel2RelationList(attachedLevel2RelationList);
            List<Level2Relation> attachedLevel2RelationList1 = new ArrayList<Level2Relation>();
            for (Level2Relation level2RelationList1Level2RelationToAttach : level2.getLevel2RelationList1()) {
                level2RelationList1Level2RelationToAttach = em.getReference(level2RelationList1Level2RelationToAttach.getClass(), level2RelationList1Level2RelationToAttach.getId());
                attachedLevel2RelationList1.add(level2RelationList1Level2RelationToAttach);
            }
            level2.setLevel2RelationList1(attachedLevel2RelationList1);
            List<Level1> attachedLevel1List = new ArrayList<Level1>();
            for (Level1 level1ListLevel1ToAttach : level2.getLevel1List()) {
                level1ListLevel1ToAttach = em.getReference(level1ListLevel1ToAttach.getClass(), level1ListLevel1ToAttach.getId());
                attachedLevel1List.add(level1ListLevel1ToAttach);
            }
            level2.setLevel1List(attachedLevel1List);
            List<User> attachedUserList = new ArrayList<User>();
            for (User userListUserToAttach : level2.getUserList()) {
                userListUserToAttach = em.getReference(userListUserToAttach.getClass(), userListUserToAttach.getId());
                attachedUserList.add(userListUserToAttach);
            }
            level2.setUserList(attachedUserList);
            em.persist(level2);
            if (idLevel3 != null) {
                idLevel3.getLevel2List().add(level2);
                idLevel3 = em.merge(idLevel3);
            }
            if (idProcessus != null) {
                idProcessus.getLevel2List().add(level2);
                idProcessus = em.merge(idProcessus);
            }
            for (Level2Relation level2RelationListLevel2Relation : level2.getLevel2RelationList()) {
                Level2 oldIdLevel2P1OfLevel2RelationListLevel2Relation = level2RelationListLevel2Relation.getIdLevel2P1();
                level2RelationListLevel2Relation.setIdLevel2P1(level2);
                level2RelationListLevel2Relation = em.merge(level2RelationListLevel2Relation);
                if (oldIdLevel2P1OfLevel2RelationListLevel2Relation != null) {
                    oldIdLevel2P1OfLevel2RelationListLevel2Relation.getLevel2RelationList().remove(level2RelationListLevel2Relation);
                    oldIdLevel2P1OfLevel2RelationListLevel2Relation = em.merge(oldIdLevel2P1OfLevel2RelationListLevel2Relation);
                }
            }
            for (Level2Relation level2RelationList1Level2Relation : level2.getLevel2RelationList1()) {
                Level2 oldIdLevel2P2OfLevel2RelationList1Level2Relation = level2RelationList1Level2Relation.getIdLevel2P2();
                level2RelationList1Level2Relation.setIdLevel2P2(level2);
                level2RelationList1Level2Relation = em.merge(level2RelationList1Level2Relation);
                if (oldIdLevel2P2OfLevel2RelationList1Level2Relation != null) {
                    oldIdLevel2P2OfLevel2RelationList1Level2Relation.getLevel2RelationList1().remove(level2RelationList1Level2Relation);
                    oldIdLevel2P2OfLevel2RelationList1Level2Relation = em.merge(oldIdLevel2P2OfLevel2RelationList1Level2Relation);
                }
            }
            for (Level1 level1ListLevel1 : level2.getLevel1List()) {
                Level2 oldIdLevel2OfLevel1ListLevel1 = level1ListLevel1.getIdLevel2();
                level1ListLevel1.setIdLevel2(level2);
                level1ListLevel1 = em.merge(level1ListLevel1);
                if (oldIdLevel2OfLevel1ListLevel1 != null) {
                    oldIdLevel2OfLevel1ListLevel1.getLevel1List().remove(level1ListLevel1);
                    oldIdLevel2OfLevel1ListLevel1 = em.merge(oldIdLevel2OfLevel1ListLevel1);
                }
            }
            for (User userListUser : level2.getUserList()) {
                Level2 oldIdLevel2OfUserListUser = userListUser.getIdLevel2();
                userListUser.setIdLevel2(level2);
                userListUser = em.merge(userListUser);
                if (oldIdLevel2OfUserListUser != null) {
                    oldIdLevel2OfUserListUser.getUserList().remove(userListUser);
                    oldIdLevel2OfUserListUser = em.merge(oldIdLevel2OfUserListUser);
                }
            }
            em.getTransaction().commit();
            return level2;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Level2 level2) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Level2 persistentLevel2 = em.find(Level2.class, level2.getId());
            Level3 idLevel3Old = persistentLevel2.getIdLevel3();
            Level3 idLevel3New = level2.getIdLevel3();
            Processus idProcessusOld = persistentLevel2.getIdProcessus();
            Processus idProcessusNew = level2.getIdProcessus();
            List<Level2Relation> level2RelationListOld = persistentLevel2.getLevel2RelationList();
            List<Level2Relation> level2RelationListNew = level2.getLevel2RelationList();
            List<Level2Relation> level2RelationList1Old = persistentLevel2.getLevel2RelationList1();
            List<Level2Relation> level2RelationList1New = level2.getLevel2RelationList1();
            List<Level1> level1ListOld = persistentLevel2.getLevel1List();
            List<Level1> level1ListNew = level2.getLevel1List();
            List<User> userListOld = persistentLevel2.getUserList();
            List<User> userListNew = level2.getUserList();
            List<String> illegalOrphanMessages = null;
            for (Level2Relation level2RelationListOldLevel2Relation : level2RelationListOld) {
                if (!level2RelationListNew.contains(level2RelationListOldLevel2Relation)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Level2Relation " + level2RelationListOldLevel2Relation + " since its idLevel2P1 field is not nullable.");
                }
            }
            for (Level2Relation level2RelationList1OldLevel2Relation : level2RelationList1Old) {
                if (!level2RelationList1New.contains(level2RelationList1OldLevel2Relation)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Level2Relation " + level2RelationList1OldLevel2Relation + " since its idLevel2P2 field is not nullable.");
                }
            }
            for (Level1 level1ListOldLevel1 : level1ListOld) {
                if (!level1ListNew.contains(level1ListOldLevel1)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Level1 " + level1ListOldLevel1 + " since its idLevel2 field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idLevel3New != null) {
                idLevel3New = em.getReference(idLevel3New.getClass(), idLevel3New.getId());
                level2.setIdLevel3(idLevel3New);
            }
            if (idProcessusNew != null) {
                idProcessusNew = em.getReference(idProcessusNew.getClass(), idProcessusNew.getId());
                level2.setIdProcessus(idProcessusNew);
            }
            List<Level2Relation> attachedLevel2RelationListNew = new ArrayList<Level2Relation>();
            for (Level2Relation level2RelationListNewLevel2RelationToAttach : level2RelationListNew) {
                level2RelationListNewLevel2RelationToAttach = em.getReference(level2RelationListNewLevel2RelationToAttach.getClass(), level2RelationListNewLevel2RelationToAttach.getId());
                attachedLevel2RelationListNew.add(level2RelationListNewLevel2RelationToAttach);
            }
            level2RelationListNew = attachedLevel2RelationListNew;
            level2.setLevel2RelationList(level2RelationListNew);
            List<Level2Relation> attachedLevel2RelationList1New = new ArrayList<Level2Relation>();
            for (Level2Relation level2RelationList1NewLevel2RelationToAttach : level2RelationList1New) {
                level2RelationList1NewLevel2RelationToAttach = em.getReference(level2RelationList1NewLevel2RelationToAttach.getClass(), level2RelationList1NewLevel2RelationToAttach.getId());
                attachedLevel2RelationList1New.add(level2RelationList1NewLevel2RelationToAttach);
            }
            level2RelationList1New = attachedLevel2RelationList1New;
            level2.setLevel2RelationList1(level2RelationList1New);
            List<Level1> attachedLevel1ListNew = new ArrayList<Level1>();
            for (Level1 level1ListNewLevel1ToAttach : level1ListNew) {
                level1ListNewLevel1ToAttach = em.getReference(level1ListNewLevel1ToAttach.getClass(), level1ListNewLevel1ToAttach.getId());
                attachedLevel1ListNew.add(level1ListNewLevel1ToAttach);
            }
            level1ListNew = attachedLevel1ListNew;
            level2.setLevel1List(level1ListNew);
            List<User> attachedUserListNew = new ArrayList<User>();
            for (User userListNewUserToAttach : userListNew) {
                userListNewUserToAttach = em.getReference(userListNewUserToAttach.getClass(), userListNewUserToAttach.getId());
                attachedUserListNew.add(userListNewUserToAttach);
            }
            userListNew = attachedUserListNew;
            level2.setUserList(userListNew);
            level2 = em.merge(level2);
            if (idLevel3Old != null && !idLevel3Old.equals(idLevel3New)) {
                idLevel3Old.getLevel2List().remove(level2);
                idLevel3Old = em.merge(idLevel3Old);
            }
            if (idLevel3New != null && !idLevel3New.equals(idLevel3Old)) {
                idLevel3New.getLevel2List().add(level2);
                idLevel3New = em.merge(idLevel3New);
            }
            if (idProcessusOld != null && !idProcessusOld.equals(idProcessusNew)) {
                idProcessusOld.getLevel2List().remove(level2);
                idProcessusOld = em.merge(idProcessusOld);
            }
            if (idProcessusNew != null && !idProcessusNew.equals(idProcessusOld)) {
                idProcessusNew.getLevel2List().add(level2);
                idProcessusNew = em.merge(idProcessusNew);
            }
            for (Level2Relation level2RelationListNewLevel2Relation : level2RelationListNew) {
                if (!level2RelationListOld.contains(level2RelationListNewLevel2Relation)) {
                    Level2 oldIdLevel2P1OfLevel2RelationListNewLevel2Relation = level2RelationListNewLevel2Relation.getIdLevel2P1();
                    level2RelationListNewLevel2Relation.setIdLevel2P1(level2);
                    level2RelationListNewLevel2Relation = em.merge(level2RelationListNewLevel2Relation);
                    if (oldIdLevel2P1OfLevel2RelationListNewLevel2Relation != null && !oldIdLevel2P1OfLevel2RelationListNewLevel2Relation.equals(level2)) {
                        oldIdLevel2P1OfLevel2RelationListNewLevel2Relation.getLevel2RelationList().remove(level2RelationListNewLevel2Relation);
                        oldIdLevel2P1OfLevel2RelationListNewLevel2Relation = em.merge(oldIdLevel2P1OfLevel2RelationListNewLevel2Relation);
                    }
                }
            }
            for (Level2Relation level2RelationList1NewLevel2Relation : level2RelationList1New) {
                if (!level2RelationList1Old.contains(level2RelationList1NewLevel2Relation)) {
                    Level2 oldIdLevel2P2OfLevel2RelationList1NewLevel2Relation = level2RelationList1NewLevel2Relation.getIdLevel2P2();
                    level2RelationList1NewLevel2Relation.setIdLevel2P2(level2);
                    level2RelationList1NewLevel2Relation = em.merge(level2RelationList1NewLevel2Relation);
                    if (oldIdLevel2P2OfLevel2RelationList1NewLevel2Relation != null && !oldIdLevel2P2OfLevel2RelationList1NewLevel2Relation.equals(level2)) {
                        oldIdLevel2P2OfLevel2RelationList1NewLevel2Relation.getLevel2RelationList1().remove(level2RelationList1NewLevel2Relation);
                        oldIdLevel2P2OfLevel2RelationList1NewLevel2Relation = em.merge(oldIdLevel2P2OfLevel2RelationList1NewLevel2Relation);
                    }
                }
            }
            for (Level1 level1ListNewLevel1 : level1ListNew) {
                if (!level1ListOld.contains(level1ListNewLevel1)) {
                    Level2 oldIdLevel2OfLevel1ListNewLevel1 = level1ListNewLevel1.getIdLevel2();
                    level1ListNewLevel1.setIdLevel2(level2);
                    level1ListNewLevel1 = em.merge(level1ListNewLevel1);
                    if (oldIdLevel2OfLevel1ListNewLevel1 != null && !oldIdLevel2OfLevel1ListNewLevel1.equals(level2)) {
                        oldIdLevel2OfLevel1ListNewLevel1.getLevel1List().remove(level1ListNewLevel1);
                        oldIdLevel2OfLevel1ListNewLevel1 = em.merge(oldIdLevel2OfLevel1ListNewLevel1);
                    }
                }
            }
            for (User userListOldUser : userListOld) {
                if (!userListNew.contains(userListOldUser)) {
                    userListOldUser.setIdLevel2(null);
                    userListOldUser = em.merge(userListOldUser);
                }
            }
            for (User userListNewUser : userListNew) {
                if (!userListOld.contains(userListNewUser)) {
                    Level2 oldIdLevel2OfUserListNewUser = userListNewUser.getIdLevel2();
                    userListNewUser.setIdLevel2(level2);
                    userListNewUser = em.merge(userListNewUser);
                    if (oldIdLevel2OfUserListNewUser != null && !oldIdLevel2OfUserListNewUser.equals(level2)) {
                        oldIdLevel2OfUserListNewUser.getUserList().remove(userListNewUser);
                        oldIdLevel2OfUserListNewUser = em.merge(oldIdLevel2OfUserListNewUser);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = level2.getId();
                if (findLevel2(id) == null) {
                    throw new NonexistentEntityException("The level2 with id " + id + " no longer exists.");
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
            Level2 level2;
            try {
                level2 = em.getReference(Level2.class, id);
                level2.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The level2 with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Level2Relation> level2RelationListOrphanCheck = level2.getLevel2RelationList();
            for (Level2Relation level2RelationListOrphanCheckLevel2Relation : level2RelationListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Level2 (" + level2 + ") cannot be destroyed since the Level2Relation " + level2RelationListOrphanCheckLevel2Relation + " in its level2RelationList field has a non-nullable idLevel2P1 field.");
            }
            List<Level2Relation> level2RelationList1OrphanCheck = level2.getLevel2RelationList1();
            for (Level2Relation level2RelationList1OrphanCheckLevel2Relation : level2RelationList1OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Level2 (" + level2 + ") cannot be destroyed since the Level2Relation " + level2RelationList1OrphanCheckLevel2Relation + " in its level2RelationList1 field has a non-nullable idLevel2P2 field.");
            }
            List<Level1> level1ListOrphanCheck = level2.getLevel1List();
            for (Level1 level1ListOrphanCheckLevel1 : level1ListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Level2 (" + level2 + ") cannot be destroyed since the Level1 " + level1ListOrphanCheckLevel1 + " in its level1List field has a non-nullable idLevel2 field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Level3 idLevel3 = level2.getIdLevel3();
            if (idLevel3 != null) {
                idLevel3.getLevel2List().remove(level2);
                idLevel3 = em.merge(idLevel3);
            }
            Processus idProcessus = level2.getIdProcessus();
            if (idProcessus != null) {
                idProcessus.getLevel2List().remove(level2);
                idProcessus = em.merge(idProcessus);
            }
            List<User> userList = level2.getUserList();
            for (User userListUser : userList) {
                userListUser.setIdLevel2(null);
                userListUser = em.merge(userListUser);
            }
            em.remove(level2);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Level2> findLevel2Entities() {
        return findLevel2Entities(true, -1, -1);
    }

    public List<Level2> findLevel2Entities(int maxResults, int firstResult) {
        return findLevel2Entities(false, maxResults, firstResult);
    }

    private List<Level2> findLevel2Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Level2.class));
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

    public Level2 findLevel2(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Level2.class, id);
        } finally {
            em.close();
        }
    }

    public int getLevel2Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Level2> rt = cq.from(Level2.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
