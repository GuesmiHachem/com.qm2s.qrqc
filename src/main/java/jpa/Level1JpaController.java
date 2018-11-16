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
import entity.Level2;
import entity.Problem;
import java.util.ArrayList;
import java.util.List;
import entity.Level0;
import entity.User;
import entity.Hardware;
import entity.Level1;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class Level1JpaController implements Serializable {

    public Level1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Level1 create(Level1 level1) {
        if (level1.getProblemList() == null) {
            level1.setProblemList(new ArrayList<Problem>());
        }
        if (level1.getLevel0List() == null) {
            level1.setLevel0List(new ArrayList<Level0>());
        }
        if (level1.getUserList() == null) {
            level1.setUserList(new ArrayList<User>());
        }
        if (level1.getHardwareList() == null) {
            level1.setHardwareList(new ArrayList<Hardware>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Level2 idLevel2 = level1.getIdLevel2();
            if (idLevel2 != null) {
                idLevel2 = em.getReference(idLevel2.getClass(), idLevel2.getId());
                level1.setIdLevel2(idLevel2);
            }
            List<Problem> attachedProblemList = new ArrayList<Problem>();
            for (Problem problemListProblemToAttach : level1.getProblemList()) {
                problemListProblemToAttach = em.getReference(problemListProblemToAttach.getClass(), problemListProblemToAttach.getId());
                attachedProblemList.add(problemListProblemToAttach);
            }
            level1.setProblemList(attachedProblemList);
            List<Level0> attachedLevel0List = new ArrayList<Level0>();
            for (Level0 level0ListLevel0ToAttach : level1.getLevel0List()) {
                level0ListLevel0ToAttach = em.getReference(level0ListLevel0ToAttach.getClass(), level0ListLevel0ToAttach.getId());
                attachedLevel0List.add(level0ListLevel0ToAttach);
            }
            level1.setLevel0List(attachedLevel0List);
            List<User> attachedUserList = new ArrayList<User>();
            for (User userListUserToAttach : level1.getUserList()) {
                userListUserToAttach = em.getReference(userListUserToAttach.getClass(), userListUserToAttach.getId());
                attachedUserList.add(userListUserToAttach);
            }
            level1.setUserList(attachedUserList);
            List<Hardware> attachedHardwareList = new ArrayList<Hardware>();
            for (Hardware hardwareListHardwareToAttach : level1.getHardwareList()) {
                hardwareListHardwareToAttach = em.getReference(hardwareListHardwareToAttach.getClass(), hardwareListHardwareToAttach.getId());
                attachedHardwareList.add(hardwareListHardwareToAttach);
            }
            level1.setHardwareList(attachedHardwareList);
            em.persist(level1);
            if (idLevel2 != null) {
                idLevel2.getLevel1List().add(level1);
                idLevel2 = em.merge(idLevel2);
            }
            for (Problem problemListProblem : level1.getProblemList()) {
                Level1 oldIdLevel1OfProblemListProblem = problemListProblem.getIdLevel1();
                problemListProblem.setIdLevel1(level1);
                problemListProblem = em.merge(problemListProblem);
                if (oldIdLevel1OfProblemListProblem != null) {
                    oldIdLevel1OfProblemListProblem.getProblemList().remove(problemListProblem);
                    oldIdLevel1OfProblemListProblem = em.merge(oldIdLevel1OfProblemListProblem);
                }
            }
            for (Level0 level0ListLevel0 : level1.getLevel0List()) {
                Level1 oldIdLevel1OfLevel0ListLevel0 = level0ListLevel0.getIdLevel1();
                level0ListLevel0.setIdLevel1(level1);
                level0ListLevel0 = em.merge(level0ListLevel0);
                if (oldIdLevel1OfLevel0ListLevel0 != null) {
                    oldIdLevel1OfLevel0ListLevel0.getLevel0List().remove(level0ListLevel0);
                    oldIdLevel1OfLevel0ListLevel0 = em.merge(oldIdLevel1OfLevel0ListLevel0);
                }
            }
            for (User userListUser : level1.getUserList()) {
                Level1 oldIdLevel1OfUserListUser = userListUser.getIdLevel1();
                userListUser.setIdLevel1(level1);
                userListUser = em.merge(userListUser);
                if (oldIdLevel1OfUserListUser != null) {
                    oldIdLevel1OfUserListUser.getUserList().remove(userListUser);
                    oldIdLevel1OfUserListUser = em.merge(oldIdLevel1OfUserListUser);
                }
            }
            for (Hardware hardwareListHardware : level1.getHardwareList()) {
                Level1 oldIdLevel1OfHardwareListHardware = hardwareListHardware.getIdLevel1();
                hardwareListHardware.setIdLevel1(level1);
                hardwareListHardware = em.merge(hardwareListHardware);
                if (oldIdLevel1OfHardwareListHardware != null) {
                    oldIdLevel1OfHardwareListHardware.getHardwareList().remove(hardwareListHardware);
                    oldIdLevel1OfHardwareListHardware = em.merge(oldIdLevel1OfHardwareListHardware);
                }
            }
            em.getTransaction().commit();
            return level1;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Level1 level1) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Level1 persistentLevel1 = em.find(Level1.class, level1.getId());
            Level2 idLevel2Old = persistentLevel1.getIdLevel2();
            Level2 idLevel2New = level1.getIdLevel2();
            List<Problem> problemListOld = persistentLevel1.getProblemList();
            List<Problem> problemListNew = level1.getProblemList();
            List<Level0> level0ListOld = persistentLevel1.getLevel0List();
            List<Level0> level0ListNew = level1.getLevel0List();
            List<User> userListOld = persistentLevel1.getUserList();
            List<User> userListNew = level1.getUserList();
            List<Hardware> hardwareListOld = persistentLevel1.getHardwareList();
            List<Hardware> hardwareListNew = level1.getHardwareList();
            List<String> illegalOrphanMessages = null;
            for (Level0 level0ListOldLevel0 : level0ListOld) {
                if (!level0ListNew.contains(level0ListOldLevel0)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Level0 " + level0ListOldLevel0 + " since its idLevel1 field is not nullable.");
                }
            }
            for (Hardware hardwareListOldHardware : hardwareListOld) {
                if (!hardwareListNew.contains(hardwareListOldHardware)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Hardware " + hardwareListOldHardware + " since its idLevel1 field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idLevel2New != null) {
                idLevel2New = em.getReference(idLevel2New.getClass(), idLevel2New.getId());
                level1.setIdLevel2(idLevel2New);
            }
            List<Problem> attachedProblemListNew = new ArrayList<Problem>();
            for (Problem problemListNewProblemToAttach : problemListNew) {
                problemListNewProblemToAttach = em.getReference(problemListNewProblemToAttach.getClass(), problemListNewProblemToAttach.getId());
                attachedProblemListNew.add(problemListNewProblemToAttach);
            }
            problemListNew = attachedProblemListNew;
            level1.setProblemList(problemListNew);
            List<Level0> attachedLevel0ListNew = new ArrayList<Level0>();
            for (Level0 level0ListNewLevel0ToAttach : level0ListNew) {
                level0ListNewLevel0ToAttach = em.getReference(level0ListNewLevel0ToAttach.getClass(), level0ListNewLevel0ToAttach.getId());
                attachedLevel0ListNew.add(level0ListNewLevel0ToAttach);
            }
            level0ListNew = attachedLevel0ListNew;
            level1.setLevel0List(level0ListNew);
            List<User> attachedUserListNew = new ArrayList<User>();
            for (User userListNewUserToAttach : userListNew) {
                userListNewUserToAttach = em.getReference(userListNewUserToAttach.getClass(), userListNewUserToAttach.getId());
                attachedUserListNew.add(userListNewUserToAttach);
            }
            userListNew = attachedUserListNew;
            level1.setUserList(userListNew);
            List<Hardware> attachedHardwareListNew = new ArrayList<Hardware>();
            for (Hardware hardwareListNewHardwareToAttach : hardwareListNew) {
                hardwareListNewHardwareToAttach = em.getReference(hardwareListNewHardwareToAttach.getClass(), hardwareListNewHardwareToAttach.getId());
                attachedHardwareListNew.add(hardwareListNewHardwareToAttach);
            }
            hardwareListNew = attachedHardwareListNew;
            level1.setHardwareList(hardwareListNew);
            level1 = em.merge(level1);
            if (idLevel2Old != null && !idLevel2Old.equals(idLevel2New)) {
                idLevel2Old.getLevel1List().remove(level1);
                idLevel2Old = em.merge(idLevel2Old);
            }
            if (idLevel2New != null && !idLevel2New.equals(idLevel2Old)) {
                idLevel2New.getLevel1List().add(level1);
                idLevel2New = em.merge(idLevel2New);
            }
            for (Problem problemListOldProblem : problemListOld) {
                if (!problemListNew.contains(problemListOldProblem)) {
                    problemListOldProblem.setIdLevel1(null);
                    problemListOldProblem = em.merge(problemListOldProblem);
                }
            }
            for (Problem problemListNewProblem : problemListNew) {
                if (!problemListOld.contains(problemListNewProblem)) {
                    Level1 oldIdLevel1OfProblemListNewProblem = problemListNewProblem.getIdLevel1();
                    problemListNewProblem.setIdLevel1(level1);
                    problemListNewProblem = em.merge(problemListNewProblem);
                    if (oldIdLevel1OfProblemListNewProblem != null && !oldIdLevel1OfProblemListNewProblem.equals(level1)) {
                        oldIdLevel1OfProblemListNewProblem.getProblemList().remove(problemListNewProblem);
                        oldIdLevel1OfProblemListNewProblem = em.merge(oldIdLevel1OfProblemListNewProblem);
                    }
                }
            }
            for (Level0 level0ListNewLevel0 : level0ListNew) {
                if (!level0ListOld.contains(level0ListNewLevel0)) {
                    Level1 oldIdLevel1OfLevel0ListNewLevel0 = level0ListNewLevel0.getIdLevel1();
                    level0ListNewLevel0.setIdLevel1(level1);
                    level0ListNewLevel0 = em.merge(level0ListNewLevel0);
                    if (oldIdLevel1OfLevel0ListNewLevel0 != null && !oldIdLevel1OfLevel0ListNewLevel0.equals(level1)) {
                        oldIdLevel1OfLevel0ListNewLevel0.getLevel0List().remove(level0ListNewLevel0);
                        oldIdLevel1OfLevel0ListNewLevel0 = em.merge(oldIdLevel1OfLevel0ListNewLevel0);
                    }
                }
            }
            for (User userListOldUser : userListOld) {
                if (!userListNew.contains(userListOldUser)) {
                    userListOldUser.setIdLevel1(null);
                    userListOldUser = em.merge(userListOldUser);
                }
            }
            for (User userListNewUser : userListNew) {
                if (!userListOld.contains(userListNewUser)) {
                    Level1 oldIdLevel1OfUserListNewUser = userListNewUser.getIdLevel1();
                    userListNewUser.setIdLevel1(level1);
                    userListNewUser = em.merge(userListNewUser);
                    if (oldIdLevel1OfUserListNewUser != null && !oldIdLevel1OfUserListNewUser.equals(level1)) {
                        oldIdLevel1OfUserListNewUser.getUserList().remove(userListNewUser);
                        oldIdLevel1OfUserListNewUser = em.merge(oldIdLevel1OfUserListNewUser);
                    }
                }
            }
            for (Hardware hardwareListNewHardware : hardwareListNew) {
                if (!hardwareListOld.contains(hardwareListNewHardware)) {
                    Level1 oldIdLevel1OfHardwareListNewHardware = hardwareListNewHardware.getIdLevel1();
                    hardwareListNewHardware.setIdLevel1(level1);
                    hardwareListNewHardware = em.merge(hardwareListNewHardware);
                    if (oldIdLevel1OfHardwareListNewHardware != null && !oldIdLevel1OfHardwareListNewHardware.equals(level1)) {
                        oldIdLevel1OfHardwareListNewHardware.getHardwareList().remove(hardwareListNewHardware);
                        oldIdLevel1OfHardwareListNewHardware = em.merge(oldIdLevel1OfHardwareListNewHardware);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = level1.getId();
                if (findLevel1(id) == null) {
                    throw new NonexistentEntityException("The level1 with id " + id + " no longer exists.");
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
            Level1 level1;
            try {
                level1 = em.getReference(Level1.class, id);
                level1.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The level1 with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Level0> level0ListOrphanCheck = level1.getLevel0List();
            for (Level0 level0ListOrphanCheckLevel0 : level0ListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Level1 (" + level1 + ") cannot be destroyed since the Level0 " + level0ListOrphanCheckLevel0 + " in its level0List field has a non-nullable idLevel1 field.");
            }
            List<Hardware> hardwareListOrphanCheck = level1.getHardwareList();
            for (Hardware hardwareListOrphanCheckHardware : hardwareListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Level1 (" + level1 + ") cannot be destroyed since the Hardware " + hardwareListOrphanCheckHardware + " in its hardwareList field has a non-nullable idLevel1 field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Level2 idLevel2 = level1.getIdLevel2();
            if (idLevel2 != null) {
                idLevel2.getLevel1List().remove(level1);
                idLevel2 = em.merge(idLevel2);
            }
            List<Problem> problemList = level1.getProblemList();
            for (Problem problemListProblem : problemList) {
                problemListProblem.setIdLevel1(null);
                problemListProblem = em.merge(problemListProblem);
            }
            List<User> userList = level1.getUserList();
            for (User userListUser : userList) {
                userListUser.setIdLevel1(null);
                userListUser = em.merge(userListUser);
            }
            em.remove(level1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Level1> findLevel1Entities() {
        return findLevel1Entities(true, -1, -1);
    }

    public List<Level1> findLevel1Entities(int maxResults, int firstResult) {
        return findLevel1Entities(false, maxResults, firstResult);
    }

    private List<Level1> findLevel1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Level1.class));
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

    public Level1 findLevel1(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Level1.class, id);
        } finally {
            em.close();
        }
    }

    public int getLevel1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Level1> rt = cq.from(Level1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
