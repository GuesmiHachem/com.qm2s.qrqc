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
import entity.Level2;
import entity.Level2Relation;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class Level2RelationJpaController implements Serializable {

    public Level2RelationJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Level2Relation create(Level2Relation level2Relation) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Level2 idLevel2P1 = level2Relation.getIdLevel2P1();
            if (idLevel2P1 != null) {
                idLevel2P1 = em.getReference(idLevel2P1.getClass(), idLevel2P1.getId());
                level2Relation.setIdLevel2P1(idLevel2P1);
            }
            Level2 idLevel2P2 = level2Relation.getIdLevel2P2();
            if (idLevel2P2 != null) {
                idLevel2P2 = em.getReference(idLevel2P2.getClass(), idLevel2P2.getId());
                level2Relation.setIdLevel2P2(idLevel2P2);
            }
            em.persist(level2Relation);
            if (idLevel2P1 != null) {
                idLevel2P1.getLevel2RelationList().add(level2Relation);
                idLevel2P1 = em.merge(idLevel2P1);
            }
            if (idLevel2P2 != null) {
                idLevel2P2.getLevel2RelationList().add(level2Relation);
                idLevel2P2 = em.merge(idLevel2P2);
            }
            em.getTransaction().commit();
            return level2Relation;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Level2Relation level2Relation) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Level2Relation persistentLevel2Relation = em.find(Level2Relation.class, level2Relation.getId());
            Level2 idLevel2P1Old = persistentLevel2Relation.getIdLevel2P1();
            Level2 idLevel2P1New = level2Relation.getIdLevel2P1();
            Level2 idLevel2P2Old = persistentLevel2Relation.getIdLevel2P2();
            Level2 idLevel2P2New = level2Relation.getIdLevel2P2();
            if (idLevel2P1New != null) {
                idLevel2P1New = em.getReference(idLevel2P1New.getClass(), idLevel2P1New.getId());
                level2Relation.setIdLevel2P1(idLevel2P1New);
            }
            if (idLevel2P2New != null) {
                idLevel2P2New = em.getReference(idLevel2P2New.getClass(), idLevel2P2New.getId());
                level2Relation.setIdLevel2P2(idLevel2P2New);
            }
            level2Relation = em.merge(level2Relation);
            if (idLevel2P1Old != null && !idLevel2P1Old.equals(idLevel2P1New)) {
                idLevel2P1Old.getLevel2RelationList().remove(level2Relation);
                idLevel2P1Old = em.merge(idLevel2P1Old);
            }
            if (idLevel2P1New != null && !idLevel2P1New.equals(idLevel2P1Old)) {
                idLevel2P1New.getLevel2RelationList().add(level2Relation);
                idLevel2P1New = em.merge(idLevel2P1New);
            }
            if (idLevel2P2Old != null && !idLevel2P2Old.equals(idLevel2P2New)) {
                idLevel2P2Old.getLevel2RelationList().remove(level2Relation);
                idLevel2P2Old = em.merge(idLevel2P2Old);
            }
            if (idLevel2P2New != null && !idLevel2P2New.equals(idLevel2P2Old)) {
                idLevel2P2New.getLevel2RelationList().add(level2Relation);
                idLevel2P2New = em.merge(idLevel2P2New);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = level2Relation.getId();
                if (findLevel2Relation(id) == null) {
                    throw new NonexistentEntityException("The level2Relation with id " + id + " no longer exists.");
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
            Level2Relation level2Relation;
            try {
                level2Relation = em.getReference(Level2Relation.class, id);
                level2Relation.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The level2Relation with id " + id + " no longer exists.", enfe);
            }
            Level2 idLevel2P1 = level2Relation.getIdLevel2P1();
            if (idLevel2P1 != null) {
                idLevel2P1.getLevel2RelationList().remove(level2Relation);
                idLevel2P1 = em.merge(idLevel2P1);
            }
            Level2 idLevel2P2 = level2Relation.getIdLevel2P2();
            if (idLevel2P2 != null) {
                idLevel2P2.getLevel2RelationList().remove(level2Relation);
                idLevel2P2 = em.merge(idLevel2P2);
            }
            em.remove(level2Relation);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Level2Relation> findLevel2RelationEntities() {
        return findLevel2RelationEntities(true, -1, -1);
    }

    public List<Level2Relation> findLevel2RelationEntities(int maxResults, int firstResult) {
        return findLevel2RelationEntities(false, maxResults, firstResult);
    }

    private List<Level2Relation> findLevel2RelationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Level2Relation.class));
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

    public Level2Relation findLevel2Relation(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Level2Relation.class, id);
        } finally {
            em.close();
        }
    }

    public int getLevel2RelationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Level2Relation> rt = cq.from(Level2Relation.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
