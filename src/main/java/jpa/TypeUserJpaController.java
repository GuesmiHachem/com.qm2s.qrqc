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
import entity.Step1AlertCan;
import java.util.ArrayList;
import java.util.List;
import entity.Step1AlertShould;
import entity.TypeUser;
import entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class TypeUserJpaController implements Serializable {

    public TypeUserJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public TypeUser create(TypeUser typeUser) {
        if (typeUser.getStep1AlertCanList() == null) {
            typeUser.setStep1AlertCanList(new ArrayList<Step1AlertCan>());
        }
        if (typeUser.getStep1AlertShouldList() == null) {
            typeUser.setStep1AlertShouldList(new ArrayList<Step1AlertShould>());
        }
        if (typeUser.getUserList() == null) {
            typeUser.setUserList(new ArrayList<User>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Step1AlertCan> attachedStep1AlertCanList = new ArrayList<Step1AlertCan>();
            for (Step1AlertCan step1AlertCanListStep1AlertCanToAttach : typeUser.getStep1AlertCanList()) {
                step1AlertCanListStep1AlertCanToAttach = em.getReference(step1AlertCanListStep1AlertCanToAttach.getClass(), step1AlertCanListStep1AlertCanToAttach.getId());
                attachedStep1AlertCanList.add(step1AlertCanListStep1AlertCanToAttach);
            }
            typeUser.setStep1AlertCanList(attachedStep1AlertCanList);
            List<Step1AlertShould> attachedStep1AlertShouldList = new ArrayList<Step1AlertShould>();
            for (Step1AlertShould step1AlertShouldListStep1AlertShouldToAttach : typeUser.getStep1AlertShouldList()) {
                step1AlertShouldListStep1AlertShouldToAttach = em.getReference(step1AlertShouldListStep1AlertShouldToAttach.getClass(), step1AlertShouldListStep1AlertShouldToAttach.getId());
                attachedStep1AlertShouldList.add(step1AlertShouldListStep1AlertShouldToAttach);
            }
            typeUser.setStep1AlertShouldList(attachedStep1AlertShouldList);
            List<User> attachedUserList = new ArrayList<User>();
            for (User userListUserToAttach : typeUser.getUserList()) {
                userListUserToAttach = em.getReference(userListUserToAttach.getClass(), userListUserToAttach.getId());
                attachedUserList.add(userListUserToAttach);
            }
            typeUser.setUserList(attachedUserList);
            em.persist(typeUser);
            for (Step1AlertCan step1AlertCanListStep1AlertCan : typeUser.getStep1AlertCanList()) {
                TypeUser oldIdTypeUserOfStep1AlertCanListStep1AlertCan = step1AlertCanListStep1AlertCan.getIdTypeUser();
                step1AlertCanListStep1AlertCan.setIdTypeUser(typeUser);
                step1AlertCanListStep1AlertCan = em.merge(step1AlertCanListStep1AlertCan);
                if (oldIdTypeUserOfStep1AlertCanListStep1AlertCan != null) {
                    oldIdTypeUserOfStep1AlertCanListStep1AlertCan.getStep1AlertCanList().remove(step1AlertCanListStep1AlertCan);
                    oldIdTypeUserOfStep1AlertCanListStep1AlertCan = em.merge(oldIdTypeUserOfStep1AlertCanListStep1AlertCan);
                }
            }
            for (Step1AlertShould step1AlertShouldListStep1AlertShould : typeUser.getStep1AlertShouldList()) {
                TypeUser oldIdTypeUserOfStep1AlertShouldListStep1AlertShould = step1AlertShouldListStep1AlertShould.getIdTypeUser();
                step1AlertShouldListStep1AlertShould.setIdTypeUser(typeUser);
                step1AlertShouldListStep1AlertShould = em.merge(step1AlertShouldListStep1AlertShould);
                if (oldIdTypeUserOfStep1AlertShouldListStep1AlertShould != null) {
                    oldIdTypeUserOfStep1AlertShouldListStep1AlertShould.getStep1AlertShouldList().remove(step1AlertShouldListStep1AlertShould);
                    oldIdTypeUserOfStep1AlertShouldListStep1AlertShould = em.merge(oldIdTypeUserOfStep1AlertShouldListStep1AlertShould);
                }
            }
            for (User userListUser : typeUser.getUserList()) {
                TypeUser oldIdTypeUserOfUserListUser = userListUser.getIdTypeUser();
                userListUser.setIdTypeUser(typeUser);
                userListUser = em.merge(userListUser);
                if (oldIdTypeUserOfUserListUser != null) {
                    oldIdTypeUserOfUserListUser.getUserList().remove(userListUser);
                    oldIdTypeUserOfUserListUser = em.merge(oldIdTypeUserOfUserListUser);
                }
            }
            em.getTransaction().commit();
            return typeUser;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TypeUser typeUser) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TypeUser persistentTypeUser = em.find(TypeUser.class, typeUser.getId());
            List<Step1AlertCan> step1AlertCanListOld = persistentTypeUser.getStep1AlertCanList();
            List<Step1AlertCan> step1AlertCanListNew = typeUser.getStep1AlertCanList();
            List<Step1AlertShould> step1AlertShouldListOld = persistentTypeUser.getStep1AlertShouldList();
            List<Step1AlertShould> step1AlertShouldListNew = typeUser.getStep1AlertShouldList();
            List<User> userListOld = persistentTypeUser.getUserList();
            List<User> userListNew = typeUser.getUserList();
            List<String> illegalOrphanMessages = null;
            for (Step1AlertCan step1AlertCanListOldStep1AlertCan : step1AlertCanListOld) {
                if (!step1AlertCanListNew.contains(step1AlertCanListOldStep1AlertCan)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Step1AlertCan " + step1AlertCanListOldStep1AlertCan + " since its idTypeUser field is not nullable.");
                }
            }
            for (Step1AlertShould step1AlertShouldListOldStep1AlertShould : step1AlertShouldListOld) {
                if (!step1AlertShouldListNew.contains(step1AlertShouldListOldStep1AlertShould)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Step1AlertShould " + step1AlertShouldListOldStep1AlertShould + " since its idTypeUser field is not nullable.");
                }
            }
            for (User userListOldUser : userListOld) {
                if (!userListNew.contains(userListOldUser)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain User " + userListOldUser + " since its idTypeUser field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Step1AlertCan> attachedStep1AlertCanListNew = new ArrayList<Step1AlertCan>();
            for (Step1AlertCan step1AlertCanListNewStep1AlertCanToAttach : step1AlertCanListNew) {
                step1AlertCanListNewStep1AlertCanToAttach = em.getReference(step1AlertCanListNewStep1AlertCanToAttach.getClass(), step1AlertCanListNewStep1AlertCanToAttach.getId());
                attachedStep1AlertCanListNew.add(step1AlertCanListNewStep1AlertCanToAttach);
            }
            step1AlertCanListNew = attachedStep1AlertCanListNew;
            typeUser.setStep1AlertCanList(step1AlertCanListNew);
            List<Step1AlertShould> attachedStep1AlertShouldListNew = new ArrayList<Step1AlertShould>();
            for (Step1AlertShould step1AlertShouldListNewStep1AlertShouldToAttach : step1AlertShouldListNew) {
                step1AlertShouldListNewStep1AlertShouldToAttach = em.getReference(step1AlertShouldListNewStep1AlertShouldToAttach.getClass(), step1AlertShouldListNewStep1AlertShouldToAttach.getId());
                attachedStep1AlertShouldListNew.add(step1AlertShouldListNewStep1AlertShouldToAttach);
            }
            step1AlertShouldListNew = attachedStep1AlertShouldListNew;
            typeUser.setStep1AlertShouldList(step1AlertShouldListNew);
            List<User> attachedUserListNew = new ArrayList<User>();
            for (User userListNewUserToAttach : userListNew) {
                userListNewUserToAttach = em.getReference(userListNewUserToAttach.getClass(), userListNewUserToAttach.getId());
                attachedUserListNew.add(userListNewUserToAttach);
            }
            userListNew = attachedUserListNew;
            typeUser.setUserList(userListNew);
            typeUser = em.merge(typeUser);
            for (Step1AlertCan step1AlertCanListNewStep1AlertCan : step1AlertCanListNew) {
                if (!step1AlertCanListOld.contains(step1AlertCanListNewStep1AlertCan)) {
                    TypeUser oldIdTypeUserOfStep1AlertCanListNewStep1AlertCan = step1AlertCanListNewStep1AlertCan.getIdTypeUser();
                    step1AlertCanListNewStep1AlertCan.setIdTypeUser(typeUser);
                    step1AlertCanListNewStep1AlertCan = em.merge(step1AlertCanListNewStep1AlertCan);
                    if (oldIdTypeUserOfStep1AlertCanListNewStep1AlertCan != null && !oldIdTypeUserOfStep1AlertCanListNewStep1AlertCan.equals(typeUser)) {
                        oldIdTypeUserOfStep1AlertCanListNewStep1AlertCan.getStep1AlertCanList().remove(step1AlertCanListNewStep1AlertCan);
                        oldIdTypeUserOfStep1AlertCanListNewStep1AlertCan = em.merge(oldIdTypeUserOfStep1AlertCanListNewStep1AlertCan);
                    }
                }
            }
            for (Step1AlertShould step1AlertShouldListNewStep1AlertShould : step1AlertShouldListNew) {
                if (!step1AlertShouldListOld.contains(step1AlertShouldListNewStep1AlertShould)) {
                    TypeUser oldIdTypeUserOfStep1AlertShouldListNewStep1AlertShould = step1AlertShouldListNewStep1AlertShould.getIdTypeUser();
                    step1AlertShouldListNewStep1AlertShould.setIdTypeUser(typeUser);
                    step1AlertShouldListNewStep1AlertShould = em.merge(step1AlertShouldListNewStep1AlertShould);
                    if (oldIdTypeUserOfStep1AlertShouldListNewStep1AlertShould != null && !oldIdTypeUserOfStep1AlertShouldListNewStep1AlertShould.equals(typeUser)) {
                        oldIdTypeUserOfStep1AlertShouldListNewStep1AlertShould.getStep1AlertShouldList().remove(step1AlertShouldListNewStep1AlertShould);
                        oldIdTypeUserOfStep1AlertShouldListNewStep1AlertShould = em.merge(oldIdTypeUserOfStep1AlertShouldListNewStep1AlertShould);
                    }
                }
            }
            for (User userListNewUser : userListNew) {
                if (!userListOld.contains(userListNewUser)) {
                    TypeUser oldIdTypeUserOfUserListNewUser = userListNewUser.getIdTypeUser();
                    userListNewUser.setIdTypeUser(typeUser);
                    userListNewUser = em.merge(userListNewUser);
                    if (oldIdTypeUserOfUserListNewUser != null && !oldIdTypeUserOfUserListNewUser.equals(typeUser)) {
                        oldIdTypeUserOfUserListNewUser.getUserList().remove(userListNewUser);
                        oldIdTypeUserOfUserListNewUser = em.merge(oldIdTypeUserOfUserListNewUser);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = typeUser.getId();
                if (findTypeUser(id) == null) {
                    throw new NonexistentEntityException("The typeUser with id " + id + " no longer exists.");
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
            TypeUser typeUser;
            try {
                typeUser = em.getReference(TypeUser.class, id);
                typeUser.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The typeUser with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Step1AlertCan> step1AlertCanListOrphanCheck = typeUser.getStep1AlertCanList();
            for (Step1AlertCan step1AlertCanListOrphanCheckStep1AlertCan : step1AlertCanListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TypeUser (" + typeUser + ") cannot be destroyed since the Step1AlertCan " + step1AlertCanListOrphanCheckStep1AlertCan + " in its step1AlertCanList field has a non-nullable idTypeUser field.");
            }
            List<Step1AlertShould> step1AlertShouldListOrphanCheck = typeUser.getStep1AlertShouldList();
            for (Step1AlertShould step1AlertShouldListOrphanCheckStep1AlertShould : step1AlertShouldListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TypeUser (" + typeUser + ") cannot be destroyed since the Step1AlertShould " + step1AlertShouldListOrphanCheckStep1AlertShould + " in its step1AlertShouldList field has a non-nullable idTypeUser field.");
            }
            List<User> userListOrphanCheck = typeUser.getUserList();
            for (User userListOrphanCheckUser : userListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TypeUser (" + typeUser + ") cannot be destroyed since the User " + userListOrphanCheckUser + " in its userList field has a non-nullable idTypeUser field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(typeUser);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TypeUser> findTypeUserEntities() {
        return findTypeUserEntities(true, -1, -1);
    }

    public List<TypeUser> findTypeUserEntities(int maxResults, int firstResult) {
        return findTypeUserEntities(false, maxResults, firstResult);
    }

    private List<TypeUser> findTypeUserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TypeUser.class));
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

    public TypeUser findTypeUser(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TypeUser.class, id);
        } finally {
            em.close();
        }
    }

    public int getTypeUserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TypeUser> rt = cq.from(TypeUser.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
