/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entity.Notification;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.Problem;
import entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class NotificationJpaController implements Serializable {

    public NotificationJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Notification create(Notification notification) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Problem idProblem = notification.getIdProblem();
            if (idProblem != null) {
                idProblem = em.getReference(idProblem.getClass(), idProblem.getId());
                notification.setIdProblem(idProblem);
            }
            User idUser = notification.getIdUser();
            if (idUser != null) {
                idUser = em.getReference(idUser.getClass(), idUser.getId());
                notification.setIdUser(idUser);
            }
            em.persist(notification);
            if (idProblem != null) {
                idProblem.getNotificationList().add(notification);
                idProblem = em.merge(idProblem);
            }
            if (idUser != null) {
                idUser.getNotificationList().add(notification);
                idUser = em.merge(idUser);
            }
            em.getTransaction().commit();
            return notification;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Notification notification) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Notification persistentNotification = em.find(Notification.class, notification.getId());
            Problem idProblemOld = persistentNotification.getIdProblem();
            Problem idProblemNew = notification.getIdProblem();
            User idUserOld = persistentNotification.getIdUser();
            User idUserNew = notification.getIdUser();
            if (idProblemNew != null) {
                idProblemNew = em.getReference(idProblemNew.getClass(), idProblemNew.getId());
                notification.setIdProblem(idProblemNew);
            }
            if (idUserNew != null) {
                idUserNew = em.getReference(idUserNew.getClass(), idUserNew.getId());
                notification.setIdUser(idUserNew);
            }
            notification = em.merge(notification);
            if (idProblemOld != null && !idProblemOld.equals(idProblemNew)) {
                idProblemOld.getNotificationList().remove(notification);
                idProblemOld = em.merge(idProblemOld);
            }
            if (idProblemNew != null && !idProblemNew.equals(idProblemOld)) {
                idProblemNew.getNotificationList().add(notification);
                idProblemNew = em.merge(idProblemNew);
            }
            if (idUserOld != null && !idUserOld.equals(idUserNew)) {
                idUserOld.getNotificationList().remove(notification);
                idUserOld = em.merge(idUserOld);
            }
            if (idUserNew != null && !idUserNew.equals(idUserOld)) {
                idUserNew.getNotificationList().add(notification);
                idUserNew = em.merge(idUserNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = notification.getId();
                if (findNotification(id) == null) {
                    throw new NonexistentEntityException("The notification with id " + id + " no longer exists.");
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
            Notification notification;
            try {
                notification = em.getReference(Notification.class, id);
                notification.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The notification with id " + id + " no longer exists.", enfe);
            }
            Problem idProblem = notification.getIdProblem();
            if (idProblem != null) {
                idProblem.getNotificationList().remove(notification);
                idProblem = em.merge(idProblem);
            }
            User idUser = notification.getIdUser();
            if (idUser != null) {
                idUser.getNotificationList().remove(notification);
                idUser = em.merge(idUser);
            }
            em.remove(notification);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Notification> findNotificationEntities() {
        return findNotificationEntities(true, -1, -1);
    }

    public List<Notification> findNotificationEntities(int maxResults, int firstResult) {
        return findNotificationEntities(false, maxResults, firstResult);
    }

    private List<Notification> findNotificationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Notification.class));
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

    public Notification findNotification(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Notification.class, id);
        } finally {
            em.close();
        }
    }

    public int getNotificationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Notification> rt = cq.from(Notification.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
