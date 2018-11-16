/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entity.Nature;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entity.Processus;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class NatureJpaController implements Serializable {

    public NatureJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Nature create(Nature nature) {
        if (nature.getProcessusList() == null) {
            nature.setProcessusList(new ArrayList<Processus>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Processus> attachedProcessusList = new ArrayList<Processus>();
            for (Processus processusListProcessusToAttach : nature.getProcessusList()) {
                processusListProcessusToAttach = em.getReference(processusListProcessusToAttach.getClass(), processusListProcessusToAttach.getId());
                attachedProcessusList.add(processusListProcessusToAttach);
            }
            nature.setProcessusList(attachedProcessusList);
            em.persist(nature);
            for (Processus processusListProcessus : nature.getProcessusList()) {
                Nature oldIdNatureOfProcessusListProcessus = processusListProcessus.getIdNature();
                processusListProcessus.setIdNature(nature);
                processusListProcessus = em.merge(processusListProcessus);
                if (oldIdNatureOfProcessusListProcessus != null) {
                    oldIdNatureOfProcessusListProcessus.getProcessusList().remove(processusListProcessus);
                    oldIdNatureOfProcessusListProcessus = em.merge(oldIdNatureOfProcessusListProcessus);
                }
            }
            em.getTransaction().commit();
            return nature;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nature nature) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nature persistentNature = em.find(Nature.class, nature.getId());
            List<Processus> processusListOld = persistentNature.getProcessusList();
            List<Processus> processusListNew = nature.getProcessusList();
            List<String> illegalOrphanMessages = null;
            for (Processus processusListOldProcessus : processusListOld) {
                if (!processusListNew.contains(processusListOldProcessus)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Processus " + processusListOldProcessus + " since its idNature field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Processus> attachedProcessusListNew = new ArrayList<Processus>();
            for (Processus processusListNewProcessusToAttach : processusListNew) {
                processusListNewProcessusToAttach = em.getReference(processusListNewProcessusToAttach.getClass(), processusListNewProcessusToAttach.getId());
                attachedProcessusListNew.add(processusListNewProcessusToAttach);
            }
            processusListNew = attachedProcessusListNew;
            nature.setProcessusList(processusListNew);
            nature = em.merge(nature);
            for (Processus processusListNewProcessus : processusListNew) {
                if (!processusListOld.contains(processusListNewProcessus)) {
                    Nature oldIdNatureOfProcessusListNewProcessus = processusListNewProcessus.getIdNature();
                    processusListNewProcessus.setIdNature(nature);
                    processusListNewProcessus = em.merge(processusListNewProcessus);
                    if (oldIdNatureOfProcessusListNewProcessus != null && !oldIdNatureOfProcessusListNewProcessus.equals(nature)) {
                        oldIdNatureOfProcessusListNewProcessus.getProcessusList().remove(processusListNewProcessus);
                        oldIdNatureOfProcessusListNewProcessus = em.merge(oldIdNatureOfProcessusListNewProcessus);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = nature.getId();
                if (findNature(id) == null) {
                    throw new NonexistentEntityException("The nature with id " + id + " no longer exists.");
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
            Nature nature;
            try {
                nature = em.getReference(Nature.class, id);
                nature.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nature with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Processus> processusListOrphanCheck = nature.getProcessusList();
            for (Processus processusListOrphanCheckProcessus : processusListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Nature (" + nature + ") cannot be destroyed since the Processus " + processusListOrphanCheckProcessus + " in its processusList field has a non-nullable idNature field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(nature);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nature> findNatureEntities() {
        return findNatureEntities(true, -1, -1);
    }

    public List<Nature> findNatureEntities(int maxResults, int firstResult) {
        return findNatureEntities(false, maxResults, firstResult);
    }

    private List<Nature> findNatureEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nature.class));
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

    public Nature findNature(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nature.class, id);
        } finally {
            em.close();
        }
    }

    public int getNatureCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nature> rt = cq.from(Nature.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
