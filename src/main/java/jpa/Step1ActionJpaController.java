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
import entity.Step1Action;
import entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class Step1ActionJpaController implements Serializable {

    public Step1ActionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Step1Action create(Step1Action step1Action) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1 idStep1 = step1Action.getIdStep1();
            if (idStep1 != null) {
                idStep1 = em.getReference(idStep1.getClass(), idStep1.getId());
                step1Action.setIdStep1(idStep1);
            }
            User affectedTo = step1Action.getAffectedTo();
            if (affectedTo != null) {
                affectedTo = em.getReference(affectedTo.getClass(), affectedTo.getId());
                step1Action.setAffectedTo(affectedTo);
            }
            em.persist(step1Action);
            if (idStep1 != null) {
                idStep1.getStep1ActionList().add(step1Action);
                idStep1 = em.merge(idStep1);
            }
            if (affectedTo != null) {
                affectedTo.getStep1ActionList().add(step1Action);
                affectedTo = em.merge(affectedTo);
            }
            em.getTransaction().commit();
            return step1Action;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Step1Action step1Action) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1Action persistentStep1Action = em.find(Step1Action.class, step1Action.getId());
            Step1 idStep1Old = persistentStep1Action.getIdStep1();
            Step1 idStep1New = step1Action.getIdStep1();
            User affectedToOld = persistentStep1Action.getAffectedTo();
            User affectedToNew = step1Action.getAffectedTo();
            if (idStep1New != null) {
                idStep1New = em.getReference(idStep1New.getClass(), idStep1New.getId());
                step1Action.setIdStep1(idStep1New);
            }
            if (affectedToNew != null) {
                affectedToNew = em.getReference(affectedToNew.getClass(), affectedToNew.getId());
                step1Action.setAffectedTo(affectedToNew);
            }
            step1Action = em.merge(step1Action);
            if (idStep1Old != null && !idStep1Old.equals(idStep1New)) {
                idStep1Old.getStep1ActionList().remove(step1Action);
                idStep1Old = em.merge(idStep1Old);
            }
            if (idStep1New != null && !idStep1New.equals(idStep1Old)) {
                idStep1New.getStep1ActionList().add(step1Action);
                idStep1New = em.merge(idStep1New);
            }
            if (affectedToOld != null && !affectedToOld.equals(affectedToNew)) {
                affectedToOld.getStep1ActionList().remove(step1Action);
                affectedToOld = em.merge(affectedToOld);
            }
            if (affectedToNew != null && !affectedToNew.equals(affectedToOld)) {
                affectedToNew.getStep1ActionList().add(step1Action);
                affectedToNew = em.merge(affectedToNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = step1Action.getId();
                if (findStep1Action(id) == null) {
                    throw new NonexistentEntityException("The step1Action with id " + id + " no longer exists.");
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
            Step1Action step1Action;
            try {
                step1Action = em.getReference(Step1Action.class, id);
                step1Action.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The step1Action with id " + id + " no longer exists.", enfe);
            }
            Step1 idStep1 = step1Action.getIdStep1();
            if (idStep1 != null) {
                idStep1.getStep1ActionList().remove(step1Action);
                idStep1 = em.merge(idStep1);
            }
            User affectedTo = step1Action.getAffectedTo();
            if (affectedTo != null) {
                affectedTo.getStep1ActionList().remove(step1Action);
                affectedTo = em.merge(affectedTo);
            }
            em.remove(step1Action);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Step1Action> findStep1ActionEntities() {
        return findStep1ActionEntities(true, -1, -1);
    }

    public List<Step1Action> findStep1ActionEntities(int maxResults, int firstResult) {
        return findStep1ActionEntities(false, maxResults, firstResult);
    }

    private List<Step1Action> findStep1ActionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Step1Action.class));
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

    public Step1Action findStep1Action(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Step1Action.class, id);
        } finally {
            em.close();
        }
    }

    public int getStep1ActionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Step1Action> rt = cq.from(Step1Action.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
