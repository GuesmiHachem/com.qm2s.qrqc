/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entity.Hardware;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.Level1;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class HardwareJpaController implements Serializable {

    public HardwareJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Hardware create(Hardware hardware) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Level1 idLevel1 = hardware.getIdLevel1();
            if (idLevel1 != null) {
                idLevel1 = em.getReference(idLevel1.getClass(), idLevel1.getId());
                hardware.setIdLevel1(idLevel1);
            }
            em.persist(hardware);
            if (idLevel1 != null) {
                idLevel1.getHardwareList().add(hardware);
                idLevel1 = em.merge(idLevel1);
            }
            em.getTransaction().commit();
            return hardware;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Hardware hardware) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Hardware persistentHardware = em.find(Hardware.class, hardware.getId());
            Level1 idLevel1Old = persistentHardware.getIdLevel1();
            Level1 idLevel1New = hardware.getIdLevel1();
            if (idLevel1New != null) {
                idLevel1New = em.getReference(idLevel1New.getClass(), idLevel1New.getId());
                hardware.setIdLevel1(idLevel1New);
            }
            hardware = em.merge(hardware);
            if (idLevel1Old != null && !idLevel1Old.equals(idLevel1New)) {
                idLevel1Old.getHardwareList().remove(hardware);
                idLevel1Old = em.merge(idLevel1Old);
            }
            if (idLevel1New != null && !idLevel1New.equals(idLevel1Old)) {
                idLevel1New.getHardwareList().add(hardware);
                idLevel1New = em.merge(idLevel1New);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = hardware.getId();
                if (findHardware(id) == null) {
                    throw new NonexistentEntityException("The hardware with id " + id + " no longer exists.");
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
            Hardware hardware;
            try {
                hardware = em.getReference(Hardware.class, id);
                hardware.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The hardware with id " + id + " no longer exists.", enfe);
            }
            Level1 idLevel1 = hardware.getIdLevel1();
            if (idLevel1 != null) {
                idLevel1.getHardwareList().remove(hardware);
                idLevel1 = em.merge(idLevel1);
            }
            em.remove(hardware);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Hardware> findHardwareEntities() {
        return findHardwareEntities(true, -1, -1);
    }

    public List<Hardware> findHardwareEntities(int maxResults, int firstResult) {
        return findHardwareEntities(false, maxResults, firstResult);
    }

    private List<Hardware> findHardwareEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Hardware.class));
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

    public Hardware findHardware(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Hardware.class, id);
        } finally {
            em.close();
        }
    }

    public int getHardwareCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Hardware> rt = cq.from(Hardware.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
