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
import entity.Problem;
import entity.TypeProblem;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class TypeProblemJpaController implements Serializable {

    public TypeProblemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public TypeProblem create(TypeProblem typeProblem) {
        if (typeProblem.getProblemList() == null) {
            typeProblem.setProblemList(new ArrayList<Problem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Problem> attachedProblemList = new ArrayList<Problem>();
            for (Problem problemListProblemToAttach : typeProblem.getProblemList()) {
                problemListProblemToAttach = em.getReference(problemListProblemToAttach.getClass(), problemListProblemToAttach.getId());
                attachedProblemList.add(problemListProblemToAttach);
            }
            typeProblem.setProblemList(attachedProblemList);
            em.persist(typeProblem);
            for (Problem problemListProblem : typeProblem.getProblemList()) {
                TypeProblem oldIdTypeProblemOfProblemListProblem = problemListProblem.getIdTypeProblem();
                problemListProblem.setIdTypeProblem(typeProblem);
                problemListProblem = em.merge(problemListProblem);
                if (oldIdTypeProblemOfProblemListProblem != null) {
                    oldIdTypeProblemOfProblemListProblem.getProblemList().remove(problemListProblem);
                    oldIdTypeProblemOfProblemListProblem = em.merge(oldIdTypeProblemOfProblemListProblem);
                }
            }
            em.getTransaction().commit();
            return typeProblem;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TypeProblem typeProblem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TypeProblem persistentTypeProblem = em.find(TypeProblem.class, typeProblem.getId());
            List<Problem> problemListOld = persistentTypeProblem.getProblemList();
            List<Problem> problemListNew = typeProblem.getProblemList();
            List<Problem> attachedProblemListNew = new ArrayList<Problem>();
            for (Problem problemListNewProblemToAttach : problemListNew) {
                problemListNewProblemToAttach = em.getReference(problemListNewProblemToAttach.getClass(), problemListNewProblemToAttach.getId());
                attachedProblemListNew.add(problemListNewProblemToAttach);
            }
            problemListNew = attachedProblemListNew;
            typeProblem.setProblemList(problemListNew);
            typeProblem = em.merge(typeProblem);
            for (Problem problemListOldProblem : problemListOld) {
                if (!problemListNew.contains(problemListOldProblem)) {
                    problemListOldProblem.setIdTypeProblem(null);
                    problemListOldProblem = em.merge(problemListOldProblem);
                }
            }
            for (Problem problemListNewProblem : problemListNew) {
                if (!problemListOld.contains(problemListNewProblem)) {
                    TypeProblem oldIdTypeProblemOfProblemListNewProblem = problemListNewProblem.getIdTypeProblem();
                    problemListNewProblem.setIdTypeProblem(typeProblem);
                    problemListNewProblem = em.merge(problemListNewProblem);
                    if (oldIdTypeProblemOfProblemListNewProblem != null && !oldIdTypeProblemOfProblemListNewProblem.equals(typeProblem)) {
                        oldIdTypeProblemOfProblemListNewProblem.getProblemList().remove(problemListNewProblem);
                        oldIdTypeProblemOfProblemListNewProblem = em.merge(oldIdTypeProblemOfProblemListNewProblem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = typeProblem.getId();
                if (findTypeProblem(id) == null) {
                    throw new NonexistentEntityException("The typeProblem with id " + id + " no longer exists.");
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
            TypeProblem typeProblem;
            try {
                typeProblem = em.getReference(TypeProblem.class, id);
                typeProblem.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The typeProblem with id " + id + " no longer exists.", enfe);
            }
            List<Problem> problemList = typeProblem.getProblemList();
            for (Problem problemListProblem : problemList) {
                problemListProblem.setIdTypeProblem(null);
                problemListProblem = em.merge(problemListProblem);
            }
            em.remove(typeProblem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TypeProblem> findTypeProblemEntities() {
        return findTypeProblemEntities(true, -1, -1);
    }

    public List<TypeProblem> findTypeProblemEntities(int maxResults, int firstResult) {
        return findTypeProblemEntities(false, maxResults, firstResult);
    }

    private List<TypeProblem> findTypeProblemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TypeProblem.class));
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

    public TypeProblem findTypeProblem(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TypeProblem.class, id);
        } finally {
            em.close();
        }
    }

    public int getTypeProblemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TypeProblem> rt = cq.from(TypeProblem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
