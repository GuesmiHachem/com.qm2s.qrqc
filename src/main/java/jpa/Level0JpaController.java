/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entity.Level0;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.Level1;
import entity.RankTeam;
import entity.Step1ActionFollowed;
import java.util.ArrayList;
import java.util.List;
import entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class Level0JpaController implements Serializable {

    public Level0JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Level0 create(Level0 level0) {
        if (level0.getStep1ActionFollowedList() == null) {
            level0.setStep1ActionFollowedList(new ArrayList<Step1ActionFollowed>());
        }
        if (level0.getUserList() == null) {
            level0.setUserList(new ArrayList<User>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Level1 idLevel1 = level0.getIdLevel1();
            if (idLevel1 != null) {
                idLevel1 = em.getReference(idLevel1.getClass(), idLevel1.getId());
                level0.setIdLevel1(idLevel1);
            }
            RankTeam idRankTeam = level0.getIdRankTeam();
            if (idRankTeam != null) {
                idRankTeam = em.getReference(idRankTeam.getClass(), idRankTeam.getId());
                level0.setIdRankTeam(idRankTeam);
            }
            List<Step1ActionFollowed> attachedStep1ActionFollowedList = new ArrayList<Step1ActionFollowed>();
            for (Step1ActionFollowed step1ActionFollowedListStep1ActionFollowedToAttach : level0.getStep1ActionFollowedList()) {
                step1ActionFollowedListStep1ActionFollowedToAttach = em.getReference(step1ActionFollowedListStep1ActionFollowedToAttach.getClass(), step1ActionFollowedListStep1ActionFollowedToAttach.getId());
                attachedStep1ActionFollowedList.add(step1ActionFollowedListStep1ActionFollowedToAttach);
            }
            level0.setStep1ActionFollowedList(attachedStep1ActionFollowedList);
            List<User> attachedUserList = new ArrayList<User>();
            for (User userListUserToAttach : level0.getUserList()) {
                userListUserToAttach = em.getReference(userListUserToAttach.getClass(), userListUserToAttach.getId());
                attachedUserList.add(userListUserToAttach);
            }
            level0.setUserList(attachedUserList);
            em.persist(level0);
            if (idLevel1 != null) {
                idLevel1.getLevel0List().add(level0);
                idLevel1 = em.merge(idLevel1);
            }
            if (idRankTeam != null) {
                idRankTeam.getLevel0List().add(level0);
                idRankTeam = em.merge(idRankTeam);
            }
            for (Step1ActionFollowed step1ActionFollowedListStep1ActionFollowed : level0.getStep1ActionFollowedList()) {
                Level0 oldIdLevel0OfStep1ActionFollowedListStep1ActionFollowed = step1ActionFollowedListStep1ActionFollowed.getIdLevel0();
                step1ActionFollowedListStep1ActionFollowed.setIdLevel0(level0);
                step1ActionFollowedListStep1ActionFollowed = em.merge(step1ActionFollowedListStep1ActionFollowed);
                if (oldIdLevel0OfStep1ActionFollowedListStep1ActionFollowed != null) {
                    oldIdLevel0OfStep1ActionFollowedListStep1ActionFollowed.getStep1ActionFollowedList().remove(step1ActionFollowedListStep1ActionFollowed);
                    oldIdLevel0OfStep1ActionFollowedListStep1ActionFollowed = em.merge(oldIdLevel0OfStep1ActionFollowedListStep1ActionFollowed);
                }
            }
            for (User userListUser : level0.getUserList()) {
                Level0 oldIdLevel0OfUserListUser = userListUser.getIdLevel0();
                userListUser.setIdLevel0(level0);
                userListUser = em.merge(userListUser);
                if (oldIdLevel0OfUserListUser != null) {
                    oldIdLevel0OfUserListUser.getUserList().remove(userListUser);
                    oldIdLevel0OfUserListUser = em.merge(oldIdLevel0OfUserListUser);
                }
            }
            em.getTransaction().commit();
            return level0;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Level0 level0) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Level0 persistentLevel0 = em.find(Level0.class, level0.getId());
            Level1 idLevel1Old = persistentLevel0.getIdLevel1();
            Level1 idLevel1New = level0.getIdLevel1();
            RankTeam idRankTeamOld = persistentLevel0.getIdRankTeam();
            RankTeam idRankTeamNew = level0.getIdRankTeam();
            List<Step1ActionFollowed> step1ActionFollowedListOld = persistentLevel0.getStep1ActionFollowedList();
            List<Step1ActionFollowed> step1ActionFollowedListNew = level0.getStep1ActionFollowedList();
            List<User> userListOld = persistentLevel0.getUserList();
            List<User> userListNew = level0.getUserList();
            List<String> illegalOrphanMessages = null;
            for (Step1ActionFollowed step1ActionFollowedListOldStep1ActionFollowed : step1ActionFollowedListOld) {
                if (!step1ActionFollowedListNew.contains(step1ActionFollowedListOldStep1ActionFollowed)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Step1ActionFollowed " + step1ActionFollowedListOldStep1ActionFollowed + " since its idLevel0 field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idLevel1New != null) {
                idLevel1New = em.getReference(idLevel1New.getClass(), idLevel1New.getId());
                level0.setIdLevel1(idLevel1New);
            }
            if (idRankTeamNew != null) {
                idRankTeamNew = em.getReference(idRankTeamNew.getClass(), idRankTeamNew.getId());
                level0.setIdRankTeam(idRankTeamNew);
            }
            List<Step1ActionFollowed> attachedStep1ActionFollowedListNew = new ArrayList<Step1ActionFollowed>();
            for (Step1ActionFollowed step1ActionFollowedListNewStep1ActionFollowedToAttach : step1ActionFollowedListNew) {
                step1ActionFollowedListNewStep1ActionFollowedToAttach = em.getReference(step1ActionFollowedListNewStep1ActionFollowedToAttach.getClass(), step1ActionFollowedListNewStep1ActionFollowedToAttach.getId());
                attachedStep1ActionFollowedListNew.add(step1ActionFollowedListNewStep1ActionFollowedToAttach);
            }
            step1ActionFollowedListNew = attachedStep1ActionFollowedListNew;
            level0.setStep1ActionFollowedList(step1ActionFollowedListNew);
            List<User> attachedUserListNew = new ArrayList<User>();
            for (User userListNewUserToAttach : userListNew) {
                userListNewUserToAttach = em.getReference(userListNewUserToAttach.getClass(), userListNewUserToAttach.getId());
                attachedUserListNew.add(userListNewUserToAttach);
            }
            userListNew = attachedUserListNew;
            level0.setUserList(userListNew);
            level0 = em.merge(level0);
            if (idLevel1Old != null && !idLevel1Old.equals(idLevel1New)) {
                idLevel1Old.getLevel0List().remove(level0);
                idLevel1Old = em.merge(idLevel1Old);
            }
            if (idLevel1New != null && !idLevel1New.equals(idLevel1Old)) {
                idLevel1New.getLevel0List().add(level0);
                idLevel1New = em.merge(idLevel1New);
            }
            if (idRankTeamOld != null && !idRankTeamOld.equals(idRankTeamNew)) {
                idRankTeamOld.getLevel0List().remove(level0);
                idRankTeamOld = em.merge(idRankTeamOld);
            }
            if (idRankTeamNew != null && !idRankTeamNew.equals(idRankTeamOld)) {
                idRankTeamNew.getLevel0List().add(level0);
                idRankTeamNew = em.merge(idRankTeamNew);
            }
            for (Step1ActionFollowed step1ActionFollowedListNewStep1ActionFollowed : step1ActionFollowedListNew) {
                if (!step1ActionFollowedListOld.contains(step1ActionFollowedListNewStep1ActionFollowed)) {
                    Level0 oldIdLevel0OfStep1ActionFollowedListNewStep1ActionFollowed = step1ActionFollowedListNewStep1ActionFollowed.getIdLevel0();
                    step1ActionFollowedListNewStep1ActionFollowed.setIdLevel0(level0);
                    step1ActionFollowedListNewStep1ActionFollowed = em.merge(step1ActionFollowedListNewStep1ActionFollowed);
                    if (oldIdLevel0OfStep1ActionFollowedListNewStep1ActionFollowed != null && !oldIdLevel0OfStep1ActionFollowedListNewStep1ActionFollowed.equals(level0)) {
                        oldIdLevel0OfStep1ActionFollowedListNewStep1ActionFollowed.getStep1ActionFollowedList().remove(step1ActionFollowedListNewStep1ActionFollowed);
                        oldIdLevel0OfStep1ActionFollowedListNewStep1ActionFollowed = em.merge(oldIdLevel0OfStep1ActionFollowedListNewStep1ActionFollowed);
                    }
                }
            }
            for (User userListOldUser : userListOld) {
                if (!userListNew.contains(userListOldUser)) {
                    userListOldUser.setIdLevel0(null);
                    userListOldUser = em.merge(userListOldUser);
                }
            }
            for (User userListNewUser : userListNew) {
                if (!userListOld.contains(userListNewUser)) {
                    Level0 oldIdLevel0OfUserListNewUser = userListNewUser.getIdLevel0();
                    userListNewUser.setIdLevel0(level0);
                    userListNewUser = em.merge(userListNewUser);
                    if (oldIdLevel0OfUserListNewUser != null && !oldIdLevel0OfUserListNewUser.equals(level0)) {
                        oldIdLevel0OfUserListNewUser.getUserList().remove(userListNewUser);
                        oldIdLevel0OfUserListNewUser = em.merge(oldIdLevel0OfUserListNewUser);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = level0.getId();
                if (findLevel0(id) == null) {
                    throw new NonexistentEntityException("The level0 with id " + id + " no longer exists.");
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
            Level0 level0;
            try {
                level0 = em.getReference(Level0.class, id);
                level0.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The level0 with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Step1ActionFollowed> step1ActionFollowedListOrphanCheck = level0.getStep1ActionFollowedList();
            for (Step1ActionFollowed step1ActionFollowedListOrphanCheckStep1ActionFollowed : step1ActionFollowedListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Level0 (" + level0 + ") cannot be destroyed since the Step1ActionFollowed " + step1ActionFollowedListOrphanCheckStep1ActionFollowed + " in its step1ActionFollowedList field has a non-nullable idLevel0 field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Level1 idLevel1 = level0.getIdLevel1();
            if (idLevel1 != null) {
                idLevel1.getLevel0List().remove(level0);
                idLevel1 = em.merge(idLevel1);
            }
            RankTeam idRankTeam = level0.getIdRankTeam();
            if (idRankTeam != null) {
                idRankTeam.getLevel0List().remove(level0);
                idRankTeam = em.merge(idRankTeam);
            }
            List<User> userList = level0.getUserList();
            for (User userListUser : userList) {
                userListUser.setIdLevel0(null);
                userListUser = em.merge(userListUser);
            }
            em.remove(level0);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Level0> findLevel0Entities() {
        return findLevel0Entities(true, -1, -1);
    }

    public List<Level0> findLevel0Entities(int maxResults, int firstResult) {
        return findLevel0Entities(false, maxResults, firstResult);
    }

    private List<Level0> findLevel0Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Level0.class));
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

    public Level0 findLevel0(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Level0.class, id);
        } finally {
            em.close();
        }
    }

    public int getLevel0Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Level0> rt = cq.from(Level0.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
