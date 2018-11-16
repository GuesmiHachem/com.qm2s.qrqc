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
import entity.Step1AlertCan;
import entity.TypeUser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class Step1AlertCanJpaController implements Serializable {

    public Step1AlertCanJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Step1AlertCan create(Step1AlertCan step1AlertCan) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1 idStep1 = step1AlertCan.getIdStep1();
            if (idStep1 != null) {
                idStep1 = em.getReference(idStep1.getClass(), idStep1.getId());
                step1AlertCan.setIdStep1(idStep1);
            }
            TypeUser idTypeUser = step1AlertCan.getIdTypeUser();
            if (idTypeUser != null) {
                idTypeUser = em.getReference(idTypeUser.getClass(), idTypeUser.getId());
                step1AlertCan.setIdTypeUser(idTypeUser);
            }
            em.persist(step1AlertCan);
            if (idStep1 != null) {
                idStep1.getStep1AlertCanList().add(step1AlertCan);
                idStep1 = em.merge(idStep1);
            }
            if (idTypeUser != null) {
                idTypeUser.getStep1AlertCanList().add(step1AlertCan);
                idTypeUser = em.merge(idTypeUser);
            }
            em.getTransaction().commit();
            return step1AlertCan;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Step1AlertCan step1AlertCan) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1AlertCan persistentStep1AlertCan = em.find(Step1AlertCan.class, step1AlertCan.getId());
            Step1 idStep1Old = persistentStep1AlertCan.getIdStep1();
            Step1 idStep1New = step1AlertCan.getIdStep1();
            TypeUser idTypeUserOld = persistentStep1AlertCan.getIdTypeUser();
            TypeUser idTypeUserNew = step1AlertCan.getIdTypeUser();
            if (idStep1New != null) {
                idStep1New = em.getReference(idStep1New.getClass(), idStep1New.getId());
                step1AlertCan.setIdStep1(idStep1New);
            }
            if (idTypeUserNew != null) {
                idTypeUserNew = em.getReference(idTypeUserNew.getClass(), idTypeUserNew.getId());
                step1AlertCan.setIdTypeUser(idTypeUserNew);
            }
            step1AlertCan = em.merge(step1AlertCan);
            if (idStep1Old != null && !idStep1Old.equals(idStep1New)) {
                idStep1Old.getStep1AlertCanList().remove(step1AlertCan);
                idStep1Old = em.merge(idStep1Old);
            }
            if (idStep1New != null && !idStep1New.equals(idStep1Old)) {
                idStep1New.getStep1AlertCanList().add(step1AlertCan);
                idStep1New = em.merge(idStep1New);
            }
            if (idTypeUserOld != null && !idTypeUserOld.equals(idTypeUserNew)) {
                idTypeUserOld.getStep1AlertCanList().remove(step1AlertCan);
                idTypeUserOld = em.merge(idTypeUserOld);
            }
            if (idTypeUserNew != null && !idTypeUserNew.equals(idTypeUserOld)) {
                idTypeUserNew.getStep1AlertCanList().add(step1AlertCan);
                idTypeUserNew = em.merge(idTypeUserNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = step1AlertCan.getId();
                if (findStep1AlertCan(id) == null) {
                    throw new NonexistentEntityException("The step1AlertCan with id " + id + " no longer exists.");
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
            Step1AlertCan step1AlertCan;
            try {
                step1AlertCan = em.getReference(Step1AlertCan.class, id);
                step1AlertCan.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The step1AlertCan with id " + id + " no longer exists.", enfe);
            }
            Step1 idStep1 = step1AlertCan.getIdStep1();
            if (idStep1 != null) {
                idStep1.getStep1AlertCanList().remove(step1AlertCan);
                idStep1 = em.merge(idStep1);
            }
            TypeUser idTypeUser = step1AlertCan.getIdTypeUser();
            if (idTypeUser != null) {
                idTypeUser.getStep1AlertCanList().remove(step1AlertCan);
                idTypeUser = em.merge(idTypeUser);
            }
            em.remove(step1AlertCan);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Step1AlertCan> findStep1AlertCanEntities() {
        return findStep1AlertCanEntities(true, -1, -1);
    }

    public List<Step1AlertCan> findStep1AlertCanEntities(int maxResults, int firstResult) {
        return findStep1AlertCanEntities(false, maxResults, firstResult);
    }

    private List<Step1AlertCan> findStep1AlertCanEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Step1AlertCan.class));
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

    public Step1AlertCan findStep1AlertCan(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Step1AlertCan.class, id);
        } finally {
            em.close();
        }
    }

    public int getStep1AlertCanCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Step1AlertCan> rt = cq.from(Step1AlertCan.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
