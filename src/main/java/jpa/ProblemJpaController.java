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
import entity.TypeProblem;
import entity.User;
import entity.Level1;
import java.util.ArrayList;
import java.util.List;
import entity.Notification;
import entity.Problem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class ProblemJpaController implements Serializable {

    public ProblemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Problem create(Problem problem) {
        if (problem.getStep1List() == null) {
            problem.setStep1List(new ArrayList<Step1>());
        }
        if (problem.getNotificationList() == null) {
            problem.setNotificationList(new ArrayList<Notification>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1 idStep1 = problem.getIdStep1();
            if (idStep1 != null) {
                idStep1 = em.getReference(idStep1.getClass(), idStep1.getId());
                problem.setIdStep1(idStep1);
            }
            TypeProblem idTypeProblem = problem.getIdTypeProblem();
            if (idTypeProblem != null) {
                idTypeProblem = em.getReference(idTypeProblem.getClass(), idTypeProblem.getId());
                problem.setIdTypeProblem(idTypeProblem);
            }
            User idUser = problem.getIdUser();
            if (idUser != null) {
                idUser = em.getReference(idUser.getClass(), idUser.getId());
                problem.setIdUser(idUser);
            }
            Level1 idLevel1 = problem.getIdLevel1();
            if (idLevel1 != null) {
                idLevel1 = em.getReference(idLevel1.getClass(), idLevel1.getId());
                problem.setIdLevel1(idLevel1);
            }
            List<Step1> attachedStep1List = new ArrayList<Step1>();
            for (Step1 step1ListStep1ToAttach : problem.getStep1List()) {
                step1ListStep1ToAttach = em.getReference(step1ListStep1ToAttach.getClass(), step1ListStep1ToAttach.getId());
                attachedStep1List.add(step1ListStep1ToAttach);
            }
            problem.setStep1List(attachedStep1List);
            List<Notification> attachedNotificationList = new ArrayList<Notification>();
            for (Notification notificationListNotificationToAttach : problem.getNotificationList()) {
                notificationListNotificationToAttach = em.getReference(notificationListNotificationToAttach.getClass(), notificationListNotificationToAttach.getId());
                attachedNotificationList.add(notificationListNotificationToAttach);
            }
            problem.setNotificationList(attachedNotificationList);
            em.persist(problem);
            if (idStep1 != null) {
                Problem oldIdProblemOfIdStep1 = idStep1.getIdProblem();
                if (oldIdProblemOfIdStep1 != null) {
                    oldIdProblemOfIdStep1.setIdStep1(null);
                    oldIdProblemOfIdStep1 = em.merge(oldIdProblemOfIdStep1);
                }
                idStep1.setIdProblem(problem);
                idStep1 = em.merge(idStep1);
            }
            if (idTypeProblem != null) {
                idTypeProblem.getProblemList().add(problem);
                idTypeProblem = em.merge(idTypeProblem);
            }
            if (idUser != null) {
                idUser.getProblemList().add(problem);
                idUser = em.merge(idUser);
            }
            if (idLevel1 != null) {
                idLevel1.getProblemList().add(problem);
                idLevel1 = em.merge(idLevel1);
            }
            for (Step1 step1ListStep1 : problem.getStep1List()) {
                Problem oldIdProblemOfStep1ListStep1 = step1ListStep1.getIdProblem();
                step1ListStep1.setIdProblem(problem);
                step1ListStep1 = em.merge(step1ListStep1);
                if (oldIdProblemOfStep1ListStep1 != null) {
                    oldIdProblemOfStep1ListStep1.getStep1List().remove(step1ListStep1);
                    oldIdProblemOfStep1ListStep1 = em.merge(oldIdProblemOfStep1ListStep1);
                }
            }
            for (Notification notificationListNotification : problem.getNotificationList()) {
                Problem oldIdProblemOfNotificationListNotification = notificationListNotification.getIdProblem();
                notificationListNotification.setIdProblem(problem);
                notificationListNotification = em.merge(notificationListNotification);
                if (oldIdProblemOfNotificationListNotification != null) {
                    oldIdProblemOfNotificationListNotification.getNotificationList().remove(notificationListNotification);
                    oldIdProblemOfNotificationListNotification = em.merge(oldIdProblemOfNotificationListNotification);
                }
            }
            em.getTransaction().commit();
            return problem;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Problem problem) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Problem persistentProblem = em.find(Problem.class, problem.getId());
            Step1 idStep1Old = persistentProblem.getIdStep1();
            Step1 idStep1New = problem.getIdStep1();
            TypeProblem idTypeProblemOld = persistentProblem.getIdTypeProblem();
            TypeProblem idTypeProblemNew = problem.getIdTypeProblem();
            User idUserOld = persistentProblem.getIdUser();
            User idUserNew = problem.getIdUser();
            Level1 idLevel1Old = persistentProblem.getIdLevel1();
            Level1 idLevel1New = problem.getIdLevel1();
            List<Step1> step1ListOld = persistentProblem.getStep1List();
            List<Step1> step1ListNew = problem.getStep1List();
            List<Notification> notificationListOld = persistentProblem.getNotificationList();
            List<Notification> notificationListNew = problem.getNotificationList();
            List<String> illegalOrphanMessages = null;
            for (Notification notificationListOldNotification : notificationListOld) {
                if (!notificationListNew.contains(notificationListOldNotification)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Notification " + notificationListOldNotification + " since its idProblem field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idStep1New != null) {
                idStep1New = em.getReference(idStep1New.getClass(), idStep1New.getId());
                problem.setIdStep1(idStep1New);
            }
            if (idTypeProblemNew != null) {
                idTypeProblemNew = em.getReference(idTypeProblemNew.getClass(), idTypeProblemNew.getId());
                problem.setIdTypeProblem(idTypeProblemNew);
            }
            if (idUserNew != null) {
                idUserNew = em.getReference(idUserNew.getClass(), idUserNew.getId());
                problem.setIdUser(idUserNew);
            }
            if (idLevel1New != null) {
                idLevel1New = em.getReference(idLevel1New.getClass(), idLevel1New.getId());
                problem.setIdLevel1(idLevel1New);
            }
            List<Step1> attachedStep1ListNew = new ArrayList<Step1>();
            for (Step1 step1ListNewStep1ToAttach : step1ListNew) {
                step1ListNewStep1ToAttach = em.getReference(step1ListNewStep1ToAttach.getClass(), step1ListNewStep1ToAttach.getId());
                attachedStep1ListNew.add(step1ListNewStep1ToAttach);
            }
            step1ListNew = attachedStep1ListNew;
            problem.setStep1List(step1ListNew);
            List<Notification> attachedNotificationListNew = new ArrayList<Notification>();
            for (Notification notificationListNewNotificationToAttach : notificationListNew) {
                notificationListNewNotificationToAttach = em.getReference(notificationListNewNotificationToAttach.getClass(), notificationListNewNotificationToAttach.getId());
                attachedNotificationListNew.add(notificationListNewNotificationToAttach);
            }
            notificationListNew = attachedNotificationListNew;
            problem.setNotificationList(notificationListNew);
            problem = em.merge(problem);
            if (idStep1Old != null && !idStep1Old.equals(idStep1New)) {
                idStep1Old.setIdProblem(null);
                idStep1Old = em.merge(idStep1Old);
            }
            if (idStep1New != null && !idStep1New.equals(idStep1Old)) {
                Problem oldIdProblemOfIdStep1 = idStep1New.getIdProblem();
                if (oldIdProblemOfIdStep1 != null) {
                    oldIdProblemOfIdStep1.setIdStep1(null);
                    oldIdProblemOfIdStep1 = em.merge(oldIdProblemOfIdStep1);
                }
                idStep1New.setIdProblem(problem);
                idStep1New = em.merge(idStep1New);
            }
            if (idTypeProblemOld != null && !idTypeProblemOld.equals(idTypeProblemNew)) {
                idTypeProblemOld.getProblemList().remove(problem);
                idTypeProblemOld = em.merge(idTypeProblemOld);
            }
            if (idTypeProblemNew != null && !idTypeProblemNew.equals(idTypeProblemOld)) {
                idTypeProblemNew.getProblemList().add(problem);
                idTypeProblemNew = em.merge(idTypeProblemNew);
            }
            if (idUserOld != null && !idUserOld.equals(idUserNew)) {
                idUserOld.getProblemList().remove(problem);
                idUserOld = em.merge(idUserOld);
            }
            if (idUserNew != null && !idUserNew.equals(idUserOld)) {
                idUserNew.getProblemList().add(problem);
                idUserNew = em.merge(idUserNew);
            }
            if (idLevel1Old != null && !idLevel1Old.equals(idLevel1New)) {
                idLevel1Old.getProblemList().remove(problem);
                idLevel1Old = em.merge(idLevel1Old);
            }
            if (idLevel1New != null && !idLevel1New.equals(idLevel1Old)) {
                idLevel1New.getProblemList().add(problem);
                idLevel1New = em.merge(idLevel1New);
            }
            for (Step1 step1ListOldStep1 : step1ListOld) {
                if (!step1ListNew.contains(step1ListOldStep1)) {
                    step1ListOldStep1.setIdProblem(null);
                    step1ListOldStep1 = em.merge(step1ListOldStep1);
                }
            }
            for (Step1 step1ListNewStep1 : step1ListNew) {
                if (!step1ListOld.contains(step1ListNewStep1)) {
                    Problem oldIdProblemOfStep1ListNewStep1 = step1ListNewStep1.getIdProblem();
                    step1ListNewStep1.setIdProblem(problem);
                    step1ListNewStep1 = em.merge(step1ListNewStep1);
                    if (oldIdProblemOfStep1ListNewStep1 != null && !oldIdProblemOfStep1ListNewStep1.equals(problem)) {
                        oldIdProblemOfStep1ListNewStep1.getStep1List().remove(step1ListNewStep1);
                        oldIdProblemOfStep1ListNewStep1 = em.merge(oldIdProblemOfStep1ListNewStep1);
                    }
                }
            }
            for (Notification notificationListNewNotification : notificationListNew) {
                if (!notificationListOld.contains(notificationListNewNotification)) {
                    Problem oldIdProblemOfNotificationListNewNotification = notificationListNewNotification.getIdProblem();
                    notificationListNewNotification.setIdProblem(problem);
                    notificationListNewNotification = em.merge(notificationListNewNotification);
                    if (oldIdProblemOfNotificationListNewNotification != null && !oldIdProblemOfNotificationListNewNotification.equals(problem)) {
                        oldIdProblemOfNotificationListNewNotification.getNotificationList().remove(notificationListNewNotification);
                        oldIdProblemOfNotificationListNewNotification = em.merge(oldIdProblemOfNotificationListNewNotification);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = problem.getId();
                if (findProblem(id) == null) {
                    throw new NonexistentEntityException("The problem with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Problem problem;
            try {
                problem = em.getReference(Problem.class, id);
                problem.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The problem with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Notification> notificationListOrphanCheck = problem.getNotificationList();
            for (Notification notificationListOrphanCheckNotification : notificationListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Problem (" + problem + ") cannot be destroyed since the Notification " + notificationListOrphanCheckNotification + " in its notificationList field has a non-nullable idProblem field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Step1 idStep1 = problem.getIdStep1();
            if (idStep1 != null) {
                idStep1.setIdProblem(null);
                idStep1 = em.merge(idStep1);
            }
            TypeProblem idTypeProblem = problem.getIdTypeProblem();
            if (idTypeProblem != null) {
                idTypeProblem.getProblemList().remove(problem);
                idTypeProblem = em.merge(idTypeProblem);
            }
            User idUser = problem.getIdUser();
            if (idUser != null) {
                idUser.getProblemList().remove(problem);
                idUser = em.merge(idUser);
            }
            Level1 idLevel1 = problem.getIdLevel1();
            if (idLevel1 != null) {
                idLevel1.getProblemList().remove(problem);
                idLevel1 = em.merge(idLevel1);
            }
            List<Step1> step1List = problem.getStep1List();
            for (Step1 step1ListStep1 : step1List) {
                step1ListStep1.setIdProblem(null);
                step1ListStep1 = em.merge(step1ListStep1);
            }
            em.remove(problem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Problem> findProblemEntities() {
        return findProblemEntities(true, -1, -1);
    }

    public List<Problem> findProblemEntities(int maxResults, int firstResult) {
        return findProblemEntities(false, maxResults, firstResult);
    }

    private List<Problem> findProblemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Problem.class));
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

    public Problem findProblem(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Problem.class, id);
        } finally {
            em.close();
        }
    }

    public int getProblemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Problem> rt = cq.from(Problem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
