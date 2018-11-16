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
import entity.Step1;
import entity.Step1ActionFollowed;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class Step1ActionFollowedJpaController implements Serializable {

    public Step1ActionFollowedJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Step1ActionFollowed create(Step1ActionFollowed step1ActionFollowed) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Level0 idLevel0 = step1ActionFollowed.getIdLevel0();
            if (idLevel0 != null) {
                idLevel0 = em.getReference(idLevel0.getClass(), idLevel0.getId());
                step1ActionFollowed.setIdLevel0(idLevel0);
            }
            Step1 idStep1 = step1ActionFollowed.getIdStep1();
            if (idStep1 != null) {
                idStep1 = em.getReference(idStep1.getClass(), idStep1.getId());
                step1ActionFollowed.setIdStep1(idStep1);
            }
            em.persist(step1ActionFollowed);
            if (idLevel0 != null) {
                idLevel0.getStep1ActionFollowedList().add(step1ActionFollowed);
                idLevel0 = em.merge(idLevel0);
            }
            if (idStep1 != null) {
                idStep1.getStep1ActionFollowedList().add(step1ActionFollowed);
                idStep1 = em.merge(idStep1);
            }
            em.getTransaction().commit();
            return step1ActionFollowed;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Step1ActionFollowed step1ActionFollowed) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1ActionFollowed persistentStep1ActionFollowed = em.find(Step1ActionFollowed.class, step1ActionFollowed.getId());
            Level0 idLevel0Old = persistentStep1ActionFollowed.getIdLevel0();
            Level0 idLevel0New = step1ActionFollowed.getIdLevel0();
            Step1 idStep1Old = persistentStep1ActionFollowed.getIdStep1();
            Step1 idStep1New = step1ActionFollowed.getIdStep1();
            if (idLevel0New != null) {
                idLevel0New = em.getReference(idLevel0New.getClass(), idLevel0New.getId());
                step1ActionFollowed.setIdLevel0(idLevel0New);
            }
            if (idStep1New != null) {
                idStep1New = em.getReference(idStep1New.getClass(), idStep1New.getId());
                step1ActionFollowed.setIdStep1(idStep1New);
            }
            step1ActionFollowed = em.merge(step1ActionFollowed);
            if (idLevel0Old != null && !idLevel0Old.equals(idLevel0New)) {
                idLevel0Old.getStep1ActionFollowedList().remove(step1ActionFollowed);
                idLevel0Old = em.merge(idLevel0Old);
            }
            if (idLevel0New != null && !idLevel0New.equals(idLevel0Old)) {
                idLevel0New.getStep1ActionFollowedList().add(step1ActionFollowed);
                idLevel0New = em.merge(idLevel0New);
            }
            if (idStep1Old != null && !idStep1Old.equals(idStep1New)) {
                idStep1Old.getStep1ActionFollowedList().remove(step1ActionFollowed);
                idStep1Old = em.merge(idStep1Old);
            }
            if (idStep1New != null && !idStep1New.equals(idStep1Old)) {
                idStep1New.getStep1ActionFollowedList().add(step1ActionFollowed);
                idStep1New = em.merge(idStep1New);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = step1ActionFollowed.getId();
                if (findStep1ActionFollowed(id) == null) {
                    throw new NonexistentEntityException("The step1ActionFollowed with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1ActionFollowed step1ActionFollowed;
            try {
                step1ActionFollowed = em.getReference(Step1ActionFollowed.class, id);
                step1ActionFollowed.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The step1ActionFollowed with id " + id + " no longer exists.", enfe);
            }
            Level0 idLevel0 = step1ActionFollowed.getIdLevel0();
            if (idLevel0 != null) {
                idLevel0.getStep1ActionFollowedList().remove(step1ActionFollowed);
                idLevel0 = em.merge(idLevel0);
            }
            Step1 idStep1 = step1ActionFollowed.getIdStep1();
            if (idStep1 != null) {
                idStep1.getStep1ActionFollowedList().remove(step1ActionFollowed);
                idStep1 = em.merge(idStep1);
            }
            em.remove(step1ActionFollowed);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Step1ActionFollowed> findStep1ActionFollowedEntities() {
        return findStep1ActionFollowedEntities(true, -1, -1);
    }

    public List<Step1ActionFollowed> findStep1ActionFollowedEntities(int maxResults, int firstResult) {
        return findStep1ActionFollowedEntities(false, maxResults, firstResult);
    }

    private List<Step1ActionFollowed> findStep1ActionFollowedEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Step1ActionFollowed.class));
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

    public Step1ActionFollowed findStep1ActionFollowed(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Step1ActionFollowed.class, id);
        } finally {
            em.close();
        }
    }

    public int getStep1ActionFollowedCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Step1ActionFollowed> rt = cq.from(Step1ActionFollowed.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
