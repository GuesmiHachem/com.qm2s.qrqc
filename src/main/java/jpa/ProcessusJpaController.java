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
import entity.Nature;
import entity.User;
import entity.Level2;
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
public class ProcessusJpaController implements Serializable {

    public ProcessusJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Processus create(Processus processus) {
        if (processus.getLevel2List() == null) {
            processus.setLevel2List(new ArrayList<Level2>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nature idNature = processus.getIdNature();
            if (idNature != null) {
                idNature = em.getReference(idNature.getClass(), idNature.getId());
                processus.setIdNature(idNature);
            }
            User idUser = processus.getIdUser();
            if (idUser != null) {
                idUser = em.getReference(idUser.getClass(), idUser.getId());
                processus.setIdUser(idUser);
            }
            List<Level2> attachedLevel2List = new ArrayList<Level2>();
            for (Level2 level2ListLevel2ToAttach : processus.getLevel2List()) {
                level2ListLevel2ToAttach = em.getReference(level2ListLevel2ToAttach.getClass(), level2ListLevel2ToAttach.getId());
                attachedLevel2List.add(level2ListLevel2ToAttach);
            }
            processus.setLevel2List(attachedLevel2List);
            em.persist(processus);
            if (idNature != null) {
                idNature.getProcessusList().add(processus);
                idNature = em.merge(idNature);
            }
            if (idUser != null) {
                idUser.getProcessusList().add(processus);
                idUser = em.merge(idUser);
            }
            for (Level2 level2ListLevel2 : processus.getLevel2List()) {
                Processus oldIdProcessusOfLevel2ListLevel2 = level2ListLevel2.getIdProcessus();
                level2ListLevel2.setIdProcessus(processus);
                level2ListLevel2 = em.merge(level2ListLevel2);
                if (oldIdProcessusOfLevel2ListLevel2 != null) {
                    oldIdProcessusOfLevel2ListLevel2.getLevel2List().remove(level2ListLevel2);
                    oldIdProcessusOfLevel2ListLevel2 = em.merge(oldIdProcessusOfLevel2ListLevel2);
                }
            }
            em.getTransaction().commit();
            return processus;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Processus processus) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Processus persistentProcessus = em.find(Processus.class, processus.getId());
            Nature idNatureOld = persistentProcessus.getIdNature();
            Nature idNatureNew = processus.getIdNature();
            User idUserOld = persistentProcessus.getIdUser();
            User idUserNew = processus.getIdUser();
            List<Level2> level2ListOld = persistentProcessus.getLevel2List();
            List<Level2> level2ListNew = processus.getLevel2List();
            List<String> illegalOrphanMessages = null;
            for (Level2 level2ListOldLevel2 : level2ListOld) {
                if (!level2ListNew.contains(level2ListOldLevel2)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Level2 " + level2ListOldLevel2 + " since its idProcessus field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idNatureNew != null) {
                idNatureNew = em.getReference(idNatureNew.getClass(), idNatureNew.getId());
                processus.setIdNature(idNatureNew);
            }
            if (idUserNew != null) {
                idUserNew = em.getReference(idUserNew.getClass(), idUserNew.getId());
                processus.setIdUser(idUserNew);
            }
            List<Level2> attachedLevel2ListNew = new ArrayList<Level2>();
            for (Level2 level2ListNewLevel2ToAttach : level2ListNew) {
                level2ListNewLevel2ToAttach = em.getReference(level2ListNewLevel2ToAttach.getClass(), level2ListNewLevel2ToAttach.getId());
                attachedLevel2ListNew.add(level2ListNewLevel2ToAttach);
            }
            level2ListNew = attachedLevel2ListNew;
            processus.setLevel2List(level2ListNew);
            processus = em.merge(processus);
            if (idNatureOld != null && !idNatureOld.equals(idNatureNew)) {
                idNatureOld.getProcessusList().remove(processus);
                idNatureOld = em.merge(idNatureOld);
            }
            if (idNatureNew != null && !idNatureNew.equals(idNatureOld)) {
                idNatureNew.getProcessusList().add(processus);
                idNatureNew = em.merge(idNatureNew);
            }
            if (idUserOld != null && !idUserOld.equals(idUserNew)) {
                idUserOld.getProcessusList().remove(processus);
                idUserOld = em.merge(idUserOld);
            }
            if (idUserNew != null && !idUserNew.equals(idUserOld)) {
                idUserNew.getProcessusList().add(processus);
                idUserNew = em.merge(idUserNew);
            }
            for (Level2 level2ListNewLevel2 : level2ListNew) {
                if (!level2ListOld.contains(level2ListNewLevel2)) {
                    Processus oldIdProcessusOfLevel2ListNewLevel2 = level2ListNewLevel2.getIdProcessus();
                    level2ListNewLevel2.setIdProcessus(processus);
                    level2ListNewLevel2 = em.merge(level2ListNewLevel2);
                    if (oldIdProcessusOfLevel2ListNewLevel2 != null && !oldIdProcessusOfLevel2ListNewLevel2.equals(processus)) {
                        oldIdProcessusOfLevel2ListNewLevel2.getLevel2List().remove(level2ListNewLevel2);
                        oldIdProcessusOfLevel2ListNewLevel2 = em.merge(oldIdProcessusOfLevel2ListNewLevel2);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = processus.getId();
                if (findProcessus(id) == null) {
                    throw new NonexistentEntityException("The processus with id " + id + " no longer exists.");
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
            Processus processus;
            try {
                processus = em.getReference(Processus.class, id);
                processus.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The processus with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Level2> level2ListOrphanCheck = processus.getLevel2List();
            for (Level2 level2ListOrphanCheckLevel2 : level2ListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Processus (" + processus + ") cannot be destroyed since the Level2 " + level2ListOrphanCheckLevel2 + " in its level2List field has a non-nullable idProcessus field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Nature idNature = processus.getIdNature();
            if (idNature != null) {
                idNature.getProcessusList().remove(processus);
                idNature = em.merge(idNature);
            }
            User idUser = processus.getIdUser();
            if (idUser != null) {
                idUser.getProcessusList().remove(processus);
                idUser = em.merge(idUser);
            }
            em.remove(processus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Processus> findProcessusEntities() {
        return findProcessusEntities(true, -1, -1);
    }

    public List<Processus> findProcessusEntities(int maxResults, int firstResult) {
        return findProcessusEntities(false, maxResults, firstResult);
    }

    private List<Processus> findProcessusEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Processus.class));
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

    public Processus findProcessus(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Processus.class, id);
        } finally {
            em.close();
        }
    }

    public int getProcessusCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Processus> rt = cq.from(Processus.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
