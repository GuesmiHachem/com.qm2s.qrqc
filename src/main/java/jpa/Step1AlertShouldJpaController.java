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
import entity.Step1AlertShould;
import entity.TypeUser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class Step1AlertShouldJpaController implements Serializable {

    public Step1AlertShouldJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Step1AlertShould create(Step1AlertShould step1AlertShould) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1 idStep1 = step1AlertShould.getIdStep1();
            if (idStep1 != null) {
                idStep1 = em.getReference(idStep1.getClass(), idStep1.getId());
                step1AlertShould.setIdStep1(idStep1);
            }
            TypeUser idTypeUser = step1AlertShould.getIdTypeUser();
            if (idTypeUser != null) {
                idTypeUser = em.getReference(idTypeUser.getClass(), idTypeUser.getId());
                step1AlertShould.setIdTypeUser(idTypeUser);
            }
            em.persist(step1AlertShould);
            if (idStep1 != null) {
                idStep1.getStep1AlertShouldList().add(step1AlertShould);
                idStep1 = em.merge(idStep1);
            }
            if (idTypeUser != null) {
                idTypeUser.getStep1AlertShouldList().add(step1AlertShould);
                idTypeUser = em.merge(idTypeUser);
            }
            em.getTransaction().commit();
            return step1AlertShould;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Step1AlertShould step1AlertShould) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1AlertShould persistentStep1AlertShould = em.find(Step1AlertShould.class, step1AlertShould.getId());
            Step1 idStep1Old = persistentStep1AlertShould.getIdStep1();
            Step1 idStep1New = step1AlertShould.getIdStep1();
            TypeUser idTypeUserOld = persistentStep1AlertShould.getIdTypeUser();
            TypeUser idTypeUserNew = step1AlertShould.getIdTypeUser();
            if (idStep1New != null) {
                idStep1New = em.getReference(idStep1New.getClass(), idStep1New.getId());
                step1AlertShould.setIdStep1(idStep1New);
            }
            if (idTypeUserNew != null) {
                idTypeUserNew = em.getReference(idTypeUserNew.getClass(), idTypeUserNew.getId());
                step1AlertShould.setIdTypeUser(idTypeUserNew);
            }
            step1AlertShould = em.merge(step1AlertShould);
            if (idStep1Old != null && !idStep1Old.equals(idStep1New)) {
                idStep1Old.getStep1AlertShouldList().remove(step1AlertShould);
                idStep1Old = em.merge(idStep1Old);
            }
            if (idStep1New != null && !idStep1New.equals(idStep1Old)) {
                idStep1New.getStep1AlertShouldList().add(step1AlertShould);
                idStep1New = em.merge(idStep1New);
            }
            if (idTypeUserOld != null && !idTypeUserOld.equals(idTypeUserNew)) {
                idTypeUserOld.getStep1AlertShouldList().remove(step1AlertShould);
                idTypeUserOld = em.merge(idTypeUserOld);
            }
            if (idTypeUserNew != null && !idTypeUserNew.equals(idTypeUserOld)) {
                idTypeUserNew.getStep1AlertShouldList().add(step1AlertShould);
                idTypeUserNew = em.merge(idTypeUserNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = step1AlertShould.getId();
                if (findStep1AlertShould(id) == null) {
                    throw new NonexistentEntityException("The step1AlertShould with id " + id + " no longer exists.");
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
            Step1AlertShould step1AlertShould;
            try {
                step1AlertShould = em.getReference(Step1AlertShould.class, id);
                step1AlertShould.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The step1AlertShould with id " + id + " no longer exists.", enfe);
            }
            Step1 idStep1 = step1AlertShould.getIdStep1();
            if (idStep1 != null) {
                idStep1.getStep1AlertShouldList().remove(step1AlertShould);
                idStep1 = em.merge(idStep1);
            }
            TypeUser idTypeUser = step1AlertShould.getIdTypeUser();
            if (idTypeUser != null) {
                idTypeUser.getStep1AlertShouldList().remove(step1AlertShould);
                idTypeUser = em.merge(idTypeUser);
            }
            em.remove(step1AlertShould);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Step1AlertShould> findStep1AlertShouldEntities() {
        return findStep1AlertShouldEntities(true, -1, -1);
    }

    public List<Step1AlertShould> findStep1AlertShouldEntities(int maxResults, int firstResult) {
        return findStep1AlertShouldEntities(false, maxResults, firstResult);
    }

    private List<Step1AlertShould> findStep1AlertShouldEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Step1AlertShould.class));
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

    public Step1AlertShould findStep1AlertShould(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Step1AlertShould.class, id);
        } finally {
            em.close();
        }
    }

    public int getStep1AlertShouldCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Step1AlertShould> rt = cq.from(Step1AlertShould.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
