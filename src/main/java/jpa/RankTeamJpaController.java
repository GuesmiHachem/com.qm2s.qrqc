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
import entity.Level0;
import entity.RankTeam;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class RankTeamJpaController implements Serializable {

    public RankTeamJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public RankTeam create(RankTeam rankTeam) {
        if (rankTeam.getLevel0List() == null) {
            rankTeam.setLevel0List(new ArrayList<Level0>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Level0> attachedLevel0List = new ArrayList<Level0>();
            for (Level0 level0ListLevel0ToAttach : rankTeam.getLevel0List()) {
                level0ListLevel0ToAttach = em.getReference(level0ListLevel0ToAttach.getClass(), level0ListLevel0ToAttach.getId());
                attachedLevel0List.add(level0ListLevel0ToAttach);
            }
            rankTeam.setLevel0List(attachedLevel0List);
            em.persist(rankTeam);
            for (Level0 level0ListLevel0 : rankTeam.getLevel0List()) {
                RankTeam oldIdRankTeamOfLevel0ListLevel0 = level0ListLevel0.getIdRankTeam();
                level0ListLevel0.setIdRankTeam(rankTeam);
                level0ListLevel0 = em.merge(level0ListLevel0);
                if (oldIdRankTeamOfLevel0ListLevel0 != null) {
                    oldIdRankTeamOfLevel0ListLevel0.getLevel0List().remove(level0ListLevel0);
                    oldIdRankTeamOfLevel0ListLevel0 = em.merge(oldIdRankTeamOfLevel0ListLevel0);
                }
            }
            em.getTransaction().commit();
            return rankTeam;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RankTeam rankTeam) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RankTeam persistentRankTeam = em.find(RankTeam.class, rankTeam.getId());
            List<Level0> level0ListOld = persistentRankTeam.getLevel0List();
            List<Level0> level0ListNew = rankTeam.getLevel0List();
            List<String> illegalOrphanMessages = null;
            for (Level0 level0ListOldLevel0 : level0ListOld) {
                if (!level0ListNew.contains(level0ListOldLevel0)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Level0 " + level0ListOldLevel0 + " since its idRankTeam field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Level0> attachedLevel0ListNew = new ArrayList<Level0>();
            for (Level0 level0ListNewLevel0ToAttach : level0ListNew) {
                level0ListNewLevel0ToAttach = em.getReference(level0ListNewLevel0ToAttach.getClass(), level0ListNewLevel0ToAttach.getId());
                attachedLevel0ListNew.add(level0ListNewLevel0ToAttach);
            }
            level0ListNew = attachedLevel0ListNew;
            rankTeam.setLevel0List(level0ListNew);
            rankTeam = em.merge(rankTeam);
            for (Level0 level0ListNewLevel0 : level0ListNew) {
                if (!level0ListOld.contains(level0ListNewLevel0)) {
                    RankTeam oldIdRankTeamOfLevel0ListNewLevel0 = level0ListNewLevel0.getIdRankTeam();
                    level0ListNewLevel0.setIdRankTeam(rankTeam);
                    level0ListNewLevel0 = em.merge(level0ListNewLevel0);
                    if (oldIdRankTeamOfLevel0ListNewLevel0 != null && !oldIdRankTeamOfLevel0ListNewLevel0.equals(rankTeam)) {
                        oldIdRankTeamOfLevel0ListNewLevel0.getLevel0List().remove(level0ListNewLevel0);
                        oldIdRankTeamOfLevel0ListNewLevel0 = em.merge(oldIdRankTeamOfLevel0ListNewLevel0);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = rankTeam.getId();
                if (findRankTeam(id) == null) {
                    throw new NonexistentEntityException("The rankTeam with id " + id + " no longer exists.");
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
            RankTeam rankTeam;
            try {
                rankTeam = em.getReference(RankTeam.class, id);
                rankTeam.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rankTeam with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Level0> level0ListOrphanCheck = rankTeam.getLevel0List();
            for (Level0 level0ListOrphanCheckLevel0 : level0ListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This RankTeam (" + rankTeam + ") cannot be destroyed since the Level0 " + level0ListOrphanCheckLevel0 + " in its level0List field has a non-nullable idRankTeam field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(rankTeam);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RankTeam> findRankTeamEntities() {
        return findRankTeamEntities(true, -1, -1);
    }

    public List<RankTeam> findRankTeamEntities(int maxResults, int firstResult) {
        return findRankTeamEntities(false, maxResults, firstResult);
    }

    private List<RankTeam> findRankTeamEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RankTeam.class));
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

    public RankTeam findRankTeam(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RankTeam.class, id);
        } finally {
            em.close();
        }
    }

    public int getRankTeamCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RankTeam> rt = cq.from(RankTeam.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
