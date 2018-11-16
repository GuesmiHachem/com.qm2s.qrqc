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
import entity.Step1Comment;
import entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class Step1CommentJpaController implements Serializable {

    public Step1CommentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Step1Comment create(Step1Comment step1Comment) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1 idStep1 = step1Comment.getIdStep1();
            if (idStep1 != null) {
                idStep1 = em.getReference(idStep1.getClass(), idStep1.getId());
                step1Comment.setIdStep1(idStep1);
            }
            User idUser = step1Comment.getIdUser();
            if (idUser != null) {
                idUser = em.getReference(idUser.getClass(), idUser.getId());
                step1Comment.setIdUser(idUser);
            }
            em.persist(step1Comment);
            if (idStep1 != null) {
                idStep1.getStep1CommentList().add(step1Comment);
                idStep1 = em.merge(idStep1);
            }
            if (idUser != null) {
                idUser.getStep1CommentList().add(step1Comment);
                idUser = em.merge(idUser);
            }
            em.getTransaction().commit();
            return step1Comment;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Step1Comment step1Comment) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1Comment persistentStep1Comment = em.find(Step1Comment.class, step1Comment.getId());
            Step1 idStep1Old = persistentStep1Comment.getIdStep1();
            Step1 idStep1New = step1Comment.getIdStep1();
            User idUserOld = persistentStep1Comment.getIdUser();
            User idUserNew = step1Comment.getIdUser();
            if (idStep1New != null) {
                idStep1New = em.getReference(idStep1New.getClass(), idStep1New.getId());
                step1Comment.setIdStep1(idStep1New);
            }
            if (idUserNew != null) {
                idUserNew = em.getReference(idUserNew.getClass(), idUserNew.getId());
                step1Comment.setIdUser(idUserNew);
            }
            step1Comment = em.merge(step1Comment);
            if (idStep1Old != null && !idStep1Old.equals(idStep1New)) {
                idStep1Old.getStep1CommentList().remove(step1Comment);
                idStep1Old = em.merge(idStep1Old);
            }
            if (idStep1New != null && !idStep1New.equals(idStep1Old)) {
                idStep1New.getStep1CommentList().add(step1Comment);
                idStep1New = em.merge(idStep1New);
            }
            if (idUserOld != null && !idUserOld.equals(idUserNew)) {
                idUserOld.getStep1CommentList().remove(step1Comment);
                idUserOld = em.merge(idUserOld);
            }
            if (idUserNew != null && !idUserNew.equals(idUserOld)) {
                idUserNew.getStep1CommentList().add(step1Comment);
                idUserNew = em.merge(idUserNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = step1Comment.getId();
                if (findStep1Comment(id) == null) {
                    throw new NonexistentEntityException("The step1Comment with id " + id + " no longer exists.");
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
            Step1Comment step1Comment;
            try {
                step1Comment = em.getReference(Step1Comment.class, id);
                step1Comment.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The step1Comment with id " + id + " no longer exists.", enfe);
            }
            Step1 idStep1 = step1Comment.getIdStep1();
            if (idStep1 != null) {
                idStep1.getStep1CommentList().remove(step1Comment);
                idStep1 = em.merge(idStep1);
            }
            User idUser = step1Comment.getIdUser();
            if (idUser != null) {
                idUser.getStep1CommentList().remove(step1Comment);
                idUser = em.merge(idUser);
            }
            em.remove(step1Comment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Step1Comment> findStep1CommentEntities() {
        return findStep1CommentEntities(true, -1, -1);
    }

    public List<Step1Comment> findStep1CommentEntities(int maxResults, int firstResult) {
        return findStep1CommentEntities(false, maxResults, firstResult);
    }

    private List<Step1Comment> findStep1CommentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Step1Comment.class));
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

    public Step1Comment findStep1Comment(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Step1Comment.class, id);
        } finally {
            em.close();
        }
    }

    public int getStep1CommentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Step1Comment> rt = cq.from(Step1Comment.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
