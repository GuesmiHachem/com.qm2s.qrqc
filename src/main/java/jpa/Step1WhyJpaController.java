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
import entity.Step1;
import entity.Step1Why;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class Step1WhyJpaController implements Serializable {

    public Step1WhyJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Step1Why create(Step1Why step1Why) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1 idStep1 = step1Why.getIdStep1();
            if (idStep1 != null) {
                idStep1 = em.getReference(idStep1.getClass(), idStep1.getId());
                step1Why.setIdStep1(idStep1);
            }
            em.persist(step1Why);
            if (idStep1 != null) {
                idStep1.getStep1WhyList().add(step1Why);
                idStep1 = em.merge(idStep1);
            }
            em.getTransaction().commit();
            return step1Why;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Step1Why step1Why) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1Why persistentStep1Why = em.find(Step1Why.class, step1Why.getId());
            Step1 idStep1Old = persistentStep1Why.getIdStep1();
            Step1 idStep1New = step1Why.getIdStep1();
            if (idStep1New != null) {
                idStep1New = em.getReference(idStep1New.getClass(), idStep1New.getId());
                step1Why.setIdStep1(idStep1New);
            }
            step1Why = em.merge(step1Why);
            if (idStep1Old != null && !idStep1Old.equals(idStep1New)) {
                idStep1Old.getStep1WhyList().remove(step1Why);
                idStep1Old = em.merge(idStep1Old);
            }
            if (idStep1New != null && !idStep1New.equals(idStep1Old)) {
                idStep1New.getStep1WhyList().add(step1Why);
                idStep1New = em.merge(idStep1New);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = step1Why.getId();
                if (findStep1Why(id) == null) {
                    throw new NonexistentEntityException("The step1Why with id " + id + " no longer exists.");
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
            Step1Why step1Why;
            try {
                step1Why = em.getReference(Step1Why.class, id);
                step1Why.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The step1Why with id " + id + " no longer exists.", enfe);
            }
            Step1 idStep1 = step1Why.getIdStep1();
            if (idStep1 != null) {
                idStep1.getStep1WhyList().remove(step1Why);
                idStep1 = em.merge(idStep1);
            }
            em.remove(step1Why);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Step1Why> findStep1WhyEntities() {
        return findStep1WhyEntities(true, -1, -1);
    }

    public List<Step1Why> findStep1WhyEntities(int maxResults, int firstResult) {
        return findStep1WhyEntities(false, maxResults, firstResult);
    }

    private List<Step1Why> findStep1WhyEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Step1Why.class));
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

    public Step1Why findStep1Why(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Step1Why.class, id);
        } finally {
            em.close();
        }
    }

    public int getStep1WhyCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Step1Why> rt = cq.from(Step1Why.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
