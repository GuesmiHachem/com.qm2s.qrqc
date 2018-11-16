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
import entity.Step1Securisation;
import entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class Step1SecurisationJpaController implements Serializable {

    public Step1SecurisationJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Step1Securisation create(Step1Securisation step1Securisation) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1 idStep1 = step1Securisation.getIdStep1();
            if (idStep1 != null) {
                idStep1 = em.getReference(idStep1.getClass(), idStep1.getId());
                step1Securisation.setIdStep1(idStep1);
            }
            User affectedTo = step1Securisation.getAffectedTo();
            if (affectedTo != null) {
                affectedTo = em.getReference(affectedTo.getClass(), affectedTo.getId());
                step1Securisation.setAffectedTo(affectedTo);
            }
            em.persist(step1Securisation);
            if (idStep1 != null) {
                idStep1.getStep1SecurisationList().add(step1Securisation);
                idStep1 = em.merge(idStep1);
            }
            if (affectedTo != null) {
                affectedTo.getStep1SecurisationList().add(step1Securisation);
                affectedTo = em.merge(affectedTo);
            }
            em.getTransaction().commit();
            return step1Securisation;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Step1Securisation step1Securisation) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1Securisation persistentStep1Securisation = em.find(Step1Securisation.class, step1Securisation.getId());
            Step1 idStep1Old = persistentStep1Securisation.getIdStep1();
            Step1 idStep1New = step1Securisation.getIdStep1();
            User affectedToOld = persistentStep1Securisation.getAffectedTo();
            User affectedToNew = step1Securisation.getAffectedTo();
            if (idStep1New != null) {
                idStep1New = em.getReference(idStep1New.getClass(), idStep1New.getId());
                step1Securisation.setIdStep1(idStep1New);
            }
            if (affectedToNew != null) {
                affectedToNew = em.getReference(affectedToNew.getClass(), affectedToNew.getId());
                step1Securisation.setAffectedTo(affectedToNew);
            }
            step1Securisation = em.merge(step1Securisation);
            if (idStep1Old != null && !idStep1Old.equals(idStep1New)) {
                idStep1Old.getStep1SecurisationList().remove(step1Securisation);
                idStep1Old = em.merge(idStep1Old);
            }
            if (idStep1New != null && !idStep1New.equals(idStep1Old)) {
                idStep1New.getStep1SecurisationList().add(step1Securisation);
                idStep1New = em.merge(idStep1New);
            }
            if (affectedToOld != null && !affectedToOld.equals(affectedToNew)) {
                affectedToOld.getStep1SecurisationList().remove(step1Securisation);
                affectedToOld = em.merge(affectedToOld);
            }
            if (affectedToNew != null && !affectedToNew.equals(affectedToOld)) {
                affectedToNew.getStep1SecurisationList().add(step1Securisation);
                affectedToNew = em.merge(affectedToNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = step1Securisation.getId();
                if (findStep1Securisation(id) == null) {
                    throw new NonexistentEntityException("The step1Securisation with id " + id + " no longer exists.");
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
            Step1Securisation step1Securisation;
            try {
                step1Securisation = em.getReference(Step1Securisation.class, id);
                step1Securisation.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The step1Securisation with id " + id + " no longer exists.", enfe);
            }
            Step1 idStep1 = step1Securisation.getIdStep1();
            if (idStep1 != null) {
                idStep1.getStep1SecurisationList().remove(step1Securisation);
                idStep1 = em.merge(idStep1);
            }
            User affectedTo = step1Securisation.getAffectedTo();
            if (affectedTo != null) {
                affectedTo.getStep1SecurisationList().remove(step1Securisation);
                affectedTo = em.merge(affectedTo);
            }
            em.remove(step1Securisation);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Step1Securisation> findStep1SecurisationEntities() {
        return findStep1SecurisationEntities(true, -1, -1);
    }

    public List<Step1Securisation> findStep1SecurisationEntities(int maxResults, int firstResult) {
        return findStep1SecurisationEntities(false, maxResults, firstResult);
    }

    private List<Step1Securisation> findStep1SecurisationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Step1Securisation.class));
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

    public Step1Securisation findStep1Securisation(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Step1Securisation.class, id);
        } finally {
            em.close();
        }
    }

    public int getStep1SecurisationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Step1Securisation> rt = cq.from(Step1Securisation.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
