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
import entity.Step1View;
import entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class Step1ViewJpaController implements Serializable {

    public Step1ViewJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Step1View create(Step1View step1View) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1 idStep1 = step1View.getIdStep1();
            if (idStep1 != null) {
                idStep1 = em.getReference(idStep1.getClass(), idStep1.getId());
                step1View.setIdStep1(idStep1);
            }
            User idUser = step1View.getIdUser();
            if (idUser != null) {
                idUser = em.getReference(idUser.getClass(), idUser.getId());
                step1View.setIdUser(idUser);
            }
            em.persist(step1View);
            if (idStep1 != null) {
                idStep1.getStep1ViewList().add(step1View);
                idStep1 = em.merge(idStep1);
            }
            if (idUser != null) {
                idUser.getStep1ViewList().add(step1View);
                idUser = em.merge(idUser);
            }
            em.getTransaction().commit();
            return step1View;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Step1View step1View) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1View persistentStep1View = em.find(Step1View.class, step1View.getId());
            Step1 idStep1Old = persistentStep1View.getIdStep1();
            Step1 idStep1New = step1View.getIdStep1();
            User idUserOld = persistentStep1View.getIdUser();
            User idUserNew = step1View.getIdUser();
            if (idStep1New != null) {
                idStep1New = em.getReference(idStep1New.getClass(), idStep1New.getId());
                step1View.setIdStep1(idStep1New);
            }
            if (idUserNew != null) {
                idUserNew = em.getReference(idUserNew.getClass(), idUserNew.getId());
                step1View.setIdUser(idUserNew);
            }
            step1View = em.merge(step1View);
            if (idStep1Old != null && !idStep1Old.equals(idStep1New)) {
                idStep1Old.getStep1ViewList().remove(step1View);
                idStep1Old = em.merge(idStep1Old);
            }
            if (idStep1New != null && !idStep1New.equals(idStep1Old)) {
                idStep1New.getStep1ViewList().add(step1View);
                idStep1New = em.merge(idStep1New);
            }
            if (idUserOld != null && !idUserOld.equals(idUserNew)) {
                idUserOld.getStep1ViewList().remove(step1View);
                idUserOld = em.merge(idUserOld);
            }
            if (idUserNew != null && !idUserNew.equals(idUserOld)) {
                idUserNew.getStep1ViewList().add(step1View);
                idUserNew = em.merge(idUserNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = step1View.getId();
                if (findStep1View(id) == null) {
                    throw new NonexistentEntityException("The step1View with id " + id + " no longer exists.");
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
            Step1View step1View;
            try {
                step1View = em.getReference(Step1View.class, id);
                step1View.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The step1View with id " + id + " no longer exists.", enfe);
            }
            Step1 idStep1 = step1View.getIdStep1();
            if (idStep1 != null) {
                idStep1.getStep1ViewList().remove(step1View);
                idStep1 = em.merge(idStep1);
            }
            User idUser = step1View.getIdUser();
            if (idUser != null) {
                idUser.getStep1ViewList().remove(step1View);
                idUser = em.merge(idUser);
            }
            em.remove(step1View);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Step1View> findStep1ViewEntities() {
        return findStep1ViewEntities(true, -1, -1);
    }

    public List<Step1View> findStep1ViewEntities(int maxResults, int firstResult) {
        return findStep1ViewEntities(false, maxResults, firstResult);
    }

    private List<Step1View> findStep1ViewEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Step1View.class));
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

    public Step1View findStep1View(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Step1View.class, id);
        } finally {
            em.close();
        }
    }

    public int getStep1ViewCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Step1View> rt = cq.from(Step1View.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
