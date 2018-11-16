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
import entity.Step1;
import entity.User;
import entity.Step1Comment;
import java.util.ArrayList;
import java.util.List;
import entity.Step1Action;
import entity.Step1Securisation;
import entity.Step1ActionFollowed;
import entity.Step1AlertCan;
import entity.Step1AlertShould;
import entity.Step1Why;
import entity.Step1View;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class Step1JpaController implements Serializable {

    public Step1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Step1 create(Step1 step1) {
        if (step1.getStep1CommentList() == null) {
            step1.setStep1CommentList(new ArrayList<Step1Comment>());
        }
        if (step1.getStep1ActionList() == null) {
            step1.setStep1ActionList(new ArrayList<Step1Action>());
        }
        if (step1.getStep1SecurisationList() == null) {
            step1.setStep1SecurisationList(new ArrayList<Step1Securisation>());
        }
        if (step1.getStep1ActionFollowedList() == null) {
            step1.setStep1ActionFollowedList(new ArrayList<Step1ActionFollowed>());
        }
        if (step1.getStep1AlertCanList() == null) {
            step1.setStep1AlertCanList(new ArrayList<Step1AlertCan>());
        }
        if (step1.getStep1AlertShouldList() == null) {
            step1.setStep1AlertShouldList(new ArrayList<Step1AlertShould>());
        }
        if (step1.getProblemList() == null) {
            step1.setProblemList(new ArrayList<Problem>());
        }
        if (step1.getStep1WhyList() == null) {
            step1.setStep1WhyList(new ArrayList<Step1Why>());
        }
        if (step1.getStep1ViewList() == null) {
            step1.setStep1ViewList(new ArrayList<Step1View>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Problem idProblem = step1.getIdProblem();
            if (idProblem != null) {
                idProblem = em.getReference(idProblem.getClass(), idProblem.getId());
                step1.setIdProblem(idProblem);
            }
            User userValidation = step1.getUserValidation();
            if (userValidation != null) {
                userValidation = em.getReference(userValidation.getClass(), userValidation.getId());
                step1.setUserValidation(userValidation);
            }
            List<Step1Comment> attachedStep1CommentList = new ArrayList<Step1Comment>();
            for (Step1Comment step1CommentListStep1CommentToAttach : step1.getStep1CommentList()) {
                step1CommentListStep1CommentToAttach = em.getReference(step1CommentListStep1CommentToAttach.getClass(), step1CommentListStep1CommentToAttach.getId());
                attachedStep1CommentList.add(step1CommentListStep1CommentToAttach);
            }
            step1.setStep1CommentList(attachedStep1CommentList);
            List<Step1Action> attachedStep1ActionList = new ArrayList<Step1Action>();
            for (Step1Action step1ActionListStep1ActionToAttach : step1.getStep1ActionList()) {
                step1ActionListStep1ActionToAttach = em.getReference(step1ActionListStep1ActionToAttach.getClass(), step1ActionListStep1ActionToAttach.getId());
                attachedStep1ActionList.add(step1ActionListStep1ActionToAttach);
            }
            step1.setStep1ActionList(attachedStep1ActionList);
            List<Step1Securisation> attachedStep1SecurisationList = new ArrayList<Step1Securisation>();
            for (Step1Securisation step1SecurisationListStep1SecurisationToAttach : step1.getStep1SecurisationList()) {
                step1SecurisationListStep1SecurisationToAttach = em.getReference(step1SecurisationListStep1SecurisationToAttach.getClass(), step1SecurisationListStep1SecurisationToAttach.getId());
                attachedStep1SecurisationList.add(step1SecurisationListStep1SecurisationToAttach);
            }
            step1.setStep1SecurisationList(attachedStep1SecurisationList);
            List<Step1ActionFollowed> attachedStep1ActionFollowedList = new ArrayList<Step1ActionFollowed>();
            for (Step1ActionFollowed step1ActionFollowedListStep1ActionFollowedToAttach : step1.getStep1ActionFollowedList()) {
                step1ActionFollowedListStep1ActionFollowedToAttach = em.getReference(step1ActionFollowedListStep1ActionFollowedToAttach.getClass(), step1ActionFollowedListStep1ActionFollowedToAttach.getId());
                attachedStep1ActionFollowedList.add(step1ActionFollowedListStep1ActionFollowedToAttach);
            }
            step1.setStep1ActionFollowedList(attachedStep1ActionFollowedList);
            List<Step1AlertCan> attachedStep1AlertCanList = new ArrayList<Step1AlertCan>();
            for (Step1AlertCan step1AlertCanListStep1AlertCanToAttach : step1.getStep1AlertCanList()) {
                step1AlertCanListStep1AlertCanToAttach = em.getReference(step1AlertCanListStep1AlertCanToAttach.getClass(), step1AlertCanListStep1AlertCanToAttach.getId());
                attachedStep1AlertCanList.add(step1AlertCanListStep1AlertCanToAttach);
            }
            step1.setStep1AlertCanList(attachedStep1AlertCanList);
            List<Step1AlertShould> attachedStep1AlertShouldList = new ArrayList<Step1AlertShould>();
            for (Step1AlertShould step1AlertShouldListStep1AlertShouldToAttach : step1.getStep1AlertShouldList()) {
                step1AlertShouldListStep1AlertShouldToAttach = em.getReference(step1AlertShouldListStep1AlertShouldToAttach.getClass(), step1AlertShouldListStep1AlertShouldToAttach.getId());
                attachedStep1AlertShouldList.add(step1AlertShouldListStep1AlertShouldToAttach);
            }
            step1.setStep1AlertShouldList(attachedStep1AlertShouldList);
            List<Problem> attachedProblemList = new ArrayList<Problem>();
            for (Problem problemListProblemToAttach : step1.getProblemList()) {
                problemListProblemToAttach = em.getReference(problemListProblemToAttach.getClass(), problemListProblemToAttach.getId());
                attachedProblemList.add(problemListProblemToAttach);
            }
            step1.setProblemList(attachedProblemList);
            List<Step1Why> attachedStep1WhyList = new ArrayList<Step1Why>();
            for (Step1Why step1WhyListStep1WhyToAttach : step1.getStep1WhyList()) {
                step1WhyListStep1WhyToAttach = em.getReference(step1WhyListStep1WhyToAttach.getClass(), step1WhyListStep1WhyToAttach.getId());
                attachedStep1WhyList.add(step1WhyListStep1WhyToAttach);
            }
            step1.setStep1WhyList(attachedStep1WhyList);
            List<Step1View> attachedStep1ViewList = new ArrayList<Step1View>();
            for (Step1View step1ViewListStep1ViewToAttach : step1.getStep1ViewList()) {
                step1ViewListStep1ViewToAttach = em.getReference(step1ViewListStep1ViewToAttach.getClass(), step1ViewListStep1ViewToAttach.getId());
                attachedStep1ViewList.add(step1ViewListStep1ViewToAttach);
            }
            step1.setStep1ViewList(attachedStep1ViewList);
            em.persist(step1);
            if (idProblem != null) {
                idProblem.getStep1List().add(step1);
                idProblem = em.merge(idProblem);
            }
            if (userValidation != null) {
                userValidation.getStep1List().add(step1);
                userValidation = em.merge(userValidation);
            }
            for (Step1Comment step1CommentListStep1Comment : step1.getStep1CommentList()) {
                Step1 oldIdStep1OfStep1CommentListStep1Comment = step1CommentListStep1Comment.getIdStep1();
                step1CommentListStep1Comment.setIdStep1(step1);
                step1CommentListStep1Comment = em.merge(step1CommentListStep1Comment);
                if (oldIdStep1OfStep1CommentListStep1Comment != null) {
                    oldIdStep1OfStep1CommentListStep1Comment.getStep1CommentList().remove(step1CommentListStep1Comment);
                    oldIdStep1OfStep1CommentListStep1Comment = em.merge(oldIdStep1OfStep1CommentListStep1Comment);
                }
            }
            for (Step1Action step1ActionListStep1Action : step1.getStep1ActionList()) {
                Step1 oldIdStep1OfStep1ActionListStep1Action = step1ActionListStep1Action.getIdStep1();
                step1ActionListStep1Action.setIdStep1(step1);
                step1ActionListStep1Action = em.merge(step1ActionListStep1Action);
                if (oldIdStep1OfStep1ActionListStep1Action != null) {
                    oldIdStep1OfStep1ActionListStep1Action.getStep1ActionList().remove(step1ActionListStep1Action);
                    oldIdStep1OfStep1ActionListStep1Action = em.merge(oldIdStep1OfStep1ActionListStep1Action);
                }
            }
            for (Step1Securisation step1SecurisationListStep1Securisation : step1.getStep1SecurisationList()) {
                Step1 oldIdStep1OfStep1SecurisationListStep1Securisation = step1SecurisationListStep1Securisation.getIdStep1();
                step1SecurisationListStep1Securisation.setIdStep1(step1);
                step1SecurisationListStep1Securisation = em.merge(step1SecurisationListStep1Securisation);
                if (oldIdStep1OfStep1SecurisationListStep1Securisation != null) {
                    oldIdStep1OfStep1SecurisationListStep1Securisation.getStep1SecurisationList().remove(step1SecurisationListStep1Securisation);
                    oldIdStep1OfStep1SecurisationListStep1Securisation = em.merge(oldIdStep1OfStep1SecurisationListStep1Securisation);
                }
            }
            for (Step1ActionFollowed step1ActionFollowedListStep1ActionFollowed : step1.getStep1ActionFollowedList()) {
                Step1 oldIdStep1OfStep1ActionFollowedListStep1ActionFollowed = step1ActionFollowedListStep1ActionFollowed.getIdStep1();
                step1ActionFollowedListStep1ActionFollowed.setIdStep1(step1);
                step1ActionFollowedListStep1ActionFollowed = em.merge(step1ActionFollowedListStep1ActionFollowed);
                if (oldIdStep1OfStep1ActionFollowedListStep1ActionFollowed != null) {
                    oldIdStep1OfStep1ActionFollowedListStep1ActionFollowed.getStep1ActionFollowedList().remove(step1ActionFollowedListStep1ActionFollowed);
                    oldIdStep1OfStep1ActionFollowedListStep1ActionFollowed = em.merge(oldIdStep1OfStep1ActionFollowedListStep1ActionFollowed);
                }
            }
            for (Step1AlertCan step1AlertCanListStep1AlertCan : step1.getStep1AlertCanList()) {
                Step1 oldIdStep1OfStep1AlertCanListStep1AlertCan = step1AlertCanListStep1AlertCan.getIdStep1();
                step1AlertCanListStep1AlertCan.setIdStep1(step1);
                step1AlertCanListStep1AlertCan = em.merge(step1AlertCanListStep1AlertCan);
                if (oldIdStep1OfStep1AlertCanListStep1AlertCan != null) {
                    oldIdStep1OfStep1AlertCanListStep1AlertCan.getStep1AlertCanList().remove(step1AlertCanListStep1AlertCan);
                    oldIdStep1OfStep1AlertCanListStep1AlertCan = em.merge(oldIdStep1OfStep1AlertCanListStep1AlertCan);
                }
            }
            for (Step1AlertShould step1AlertShouldListStep1AlertShould : step1.getStep1AlertShouldList()) {
                Step1 oldIdStep1OfStep1AlertShouldListStep1AlertShould = step1AlertShouldListStep1AlertShould.getIdStep1();
                step1AlertShouldListStep1AlertShould.setIdStep1(step1);
                step1AlertShouldListStep1AlertShould = em.merge(step1AlertShouldListStep1AlertShould);
                if (oldIdStep1OfStep1AlertShouldListStep1AlertShould != null) {
                    oldIdStep1OfStep1AlertShouldListStep1AlertShould.getStep1AlertShouldList().remove(step1AlertShouldListStep1AlertShould);
                    oldIdStep1OfStep1AlertShouldListStep1AlertShould = em.merge(oldIdStep1OfStep1AlertShouldListStep1AlertShould);
                }
            }
            for (Problem problemListProblem : step1.getProblemList()) {
                Step1 oldIdStep1OfProblemListProblem = problemListProblem.getIdStep1();
                problemListProblem.setIdStep1(step1);
                problemListProblem = em.merge(problemListProblem);
                if (oldIdStep1OfProblemListProblem != null) {
                    oldIdStep1OfProblemListProblem.getProblemList().remove(problemListProblem);
                    oldIdStep1OfProblemListProblem = em.merge(oldIdStep1OfProblemListProblem);
                }
            }
            for (Step1Why step1WhyListStep1Why : step1.getStep1WhyList()) {
                Step1 oldIdStep1OfStep1WhyListStep1Why = step1WhyListStep1Why.getIdStep1();
                step1WhyListStep1Why.setIdStep1(step1);
                step1WhyListStep1Why = em.merge(step1WhyListStep1Why);
                if (oldIdStep1OfStep1WhyListStep1Why != null) {
                    oldIdStep1OfStep1WhyListStep1Why.getStep1WhyList().remove(step1WhyListStep1Why);
                    oldIdStep1OfStep1WhyListStep1Why = em.merge(oldIdStep1OfStep1WhyListStep1Why);
                }
            }
            for (Step1View step1ViewListStep1View : step1.getStep1ViewList()) {
                Step1 oldIdStep1OfStep1ViewListStep1View = step1ViewListStep1View.getIdStep1();
                step1ViewListStep1View.setIdStep1(step1);
                step1ViewListStep1View = em.merge(step1ViewListStep1View);
                if (oldIdStep1OfStep1ViewListStep1View != null) {
                    oldIdStep1OfStep1ViewListStep1View.getStep1ViewList().remove(step1ViewListStep1View);
                    oldIdStep1OfStep1ViewListStep1View = em.merge(oldIdStep1OfStep1ViewListStep1View);
                }
            }
            em.getTransaction().commit();
            return step1;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Step1 step1) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Step1 persistentStep1 = em.find(Step1.class, step1.getId());
            Problem idProblemOld = persistentStep1.getIdProblem();
            Problem idProblemNew = step1.getIdProblem();
            User userValidationOld = persistentStep1.getUserValidation();
            User userValidationNew = step1.getUserValidation();
            List<Step1Comment> step1CommentListOld = persistentStep1.getStep1CommentList();
            List<Step1Comment> step1CommentListNew = step1.getStep1CommentList();
            List<Step1Action> step1ActionListOld = persistentStep1.getStep1ActionList();
            List<Step1Action> step1ActionListNew = step1.getStep1ActionList();
            List<Step1Securisation> step1SecurisationListOld = persistentStep1.getStep1SecurisationList();
            List<Step1Securisation> step1SecurisationListNew = step1.getStep1SecurisationList();
            List<Step1ActionFollowed> step1ActionFollowedListOld = persistentStep1.getStep1ActionFollowedList();
            List<Step1ActionFollowed> step1ActionFollowedListNew = step1.getStep1ActionFollowedList();
            List<Step1AlertCan> step1AlertCanListOld = persistentStep1.getStep1AlertCanList();
            List<Step1AlertCan> step1AlertCanListNew = step1.getStep1AlertCanList();
            List<Step1AlertShould> step1AlertShouldListOld = persistentStep1.getStep1AlertShouldList();
            List<Step1AlertShould> step1AlertShouldListNew = step1.getStep1AlertShouldList();
            List<Problem> problemListOld = persistentStep1.getProblemList();
            List<Problem> problemListNew = step1.getProblemList();
            List<Step1Why> step1WhyListOld = persistentStep1.getStep1WhyList();
            List<Step1Why> step1WhyListNew = step1.getStep1WhyList();
            List<Step1View> step1ViewListOld = persistentStep1.getStep1ViewList();
            List<Step1View> step1ViewListNew = step1.getStep1ViewList();
            List<String> illegalOrphanMessages = null;
            for (Step1Comment step1CommentListOldStep1Comment : step1CommentListOld) {
                if (!step1CommentListNew.contains(step1CommentListOldStep1Comment)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Step1Comment " + step1CommentListOldStep1Comment + " since its idStep1 field is not nullable.");
                }
            }
            for (Step1Action step1ActionListOldStep1Action : step1ActionListOld) {
                if (!step1ActionListNew.contains(step1ActionListOldStep1Action)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Step1Action " + step1ActionListOldStep1Action + " since its idStep1 field is not nullable.");
                }
            }
            for (Step1Securisation step1SecurisationListOldStep1Securisation : step1SecurisationListOld) {
                if (!step1SecurisationListNew.contains(step1SecurisationListOldStep1Securisation)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Step1Securisation " + step1SecurisationListOldStep1Securisation + " since its idStep1 field is not nullable.");
                }
            }
            for (Step1ActionFollowed step1ActionFollowedListOldStep1ActionFollowed : step1ActionFollowedListOld) {
                if (!step1ActionFollowedListNew.contains(step1ActionFollowedListOldStep1ActionFollowed)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Step1ActionFollowed " + step1ActionFollowedListOldStep1ActionFollowed + " since its idStep1 field is not nullable.");
                }
            }
            for (Step1AlertCan step1AlertCanListOldStep1AlertCan : step1AlertCanListOld) {
                if (!step1AlertCanListNew.contains(step1AlertCanListOldStep1AlertCan)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Step1AlertCan " + step1AlertCanListOldStep1AlertCan + " since its idStep1 field is not nullable.");
                }
            }
            for (Step1AlertShould step1AlertShouldListOldStep1AlertShould : step1AlertShouldListOld) {
                if (!step1AlertShouldListNew.contains(step1AlertShouldListOldStep1AlertShould)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Step1AlertShould " + step1AlertShouldListOldStep1AlertShould + " since its idStep1 field is not nullable.");
                }
            }
            for (Step1Why step1WhyListOldStep1Why : step1WhyListOld) {
                if (!step1WhyListNew.contains(step1WhyListOldStep1Why)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Step1Why " + step1WhyListOldStep1Why + " since its idStep1 field is not nullable.");
                }
            }
            for (Step1View step1ViewListOldStep1View : step1ViewListOld) {
                if (!step1ViewListNew.contains(step1ViewListOldStep1View)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Step1View " + step1ViewListOldStep1View + " since its idStep1 field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idProblemNew != null) {
                idProblemNew = em.getReference(idProblemNew.getClass(), idProblemNew.getId());
                step1.setIdProblem(idProblemNew);
            }
            if (userValidationNew != null) {
                userValidationNew = em.getReference(userValidationNew.getClass(), userValidationNew.getId());
                step1.setUserValidation(userValidationNew);
            }
            List<Step1Comment> attachedStep1CommentListNew = new ArrayList<Step1Comment>();
            for (Step1Comment step1CommentListNewStep1CommentToAttach : step1CommentListNew) {
                step1CommentListNewStep1CommentToAttach = em.getReference(step1CommentListNewStep1CommentToAttach.getClass(), step1CommentListNewStep1CommentToAttach.getId());
                attachedStep1CommentListNew.add(step1CommentListNewStep1CommentToAttach);
            }
            step1CommentListNew = attachedStep1CommentListNew;
            step1.setStep1CommentList(step1CommentListNew);
            List<Step1Action> attachedStep1ActionListNew = new ArrayList<Step1Action>();
            for (Step1Action step1ActionListNewStep1ActionToAttach : step1ActionListNew) {
                step1ActionListNewStep1ActionToAttach = em.getReference(step1ActionListNewStep1ActionToAttach.getClass(), step1ActionListNewStep1ActionToAttach.getId());
                attachedStep1ActionListNew.add(step1ActionListNewStep1ActionToAttach);
            }
            step1ActionListNew = attachedStep1ActionListNew;
            step1.setStep1ActionList(step1ActionListNew);
            List<Step1Securisation> attachedStep1SecurisationListNew = new ArrayList<Step1Securisation>();
            for (Step1Securisation step1SecurisationListNewStep1SecurisationToAttach : step1SecurisationListNew) {
                step1SecurisationListNewStep1SecurisationToAttach = em.getReference(step1SecurisationListNewStep1SecurisationToAttach.getClass(), step1SecurisationListNewStep1SecurisationToAttach.getId());
                attachedStep1SecurisationListNew.add(step1SecurisationListNewStep1SecurisationToAttach);
            }
            step1SecurisationListNew = attachedStep1SecurisationListNew;
            step1.setStep1SecurisationList(step1SecurisationListNew);
            List<Step1ActionFollowed> attachedStep1ActionFollowedListNew = new ArrayList<Step1ActionFollowed>();
            for (Step1ActionFollowed step1ActionFollowedListNewStep1ActionFollowedToAttach : step1ActionFollowedListNew) {
                step1ActionFollowedListNewStep1ActionFollowedToAttach = em.getReference(step1ActionFollowedListNewStep1ActionFollowedToAttach.getClass(), step1ActionFollowedListNewStep1ActionFollowedToAttach.getId());
                attachedStep1ActionFollowedListNew.add(step1ActionFollowedListNewStep1ActionFollowedToAttach);
            }
            step1ActionFollowedListNew = attachedStep1ActionFollowedListNew;
            step1.setStep1ActionFollowedList(step1ActionFollowedListNew);
            List<Step1AlertCan> attachedStep1AlertCanListNew = new ArrayList<Step1AlertCan>();
            for (Step1AlertCan step1AlertCanListNewStep1AlertCanToAttach : step1AlertCanListNew) {
                step1AlertCanListNewStep1AlertCanToAttach = em.getReference(step1AlertCanListNewStep1AlertCanToAttach.getClass(), step1AlertCanListNewStep1AlertCanToAttach.getId());
                attachedStep1AlertCanListNew.add(step1AlertCanListNewStep1AlertCanToAttach);
            }
            step1AlertCanListNew = attachedStep1AlertCanListNew;
            step1.setStep1AlertCanList(step1AlertCanListNew);
            List<Step1AlertShould> attachedStep1AlertShouldListNew = new ArrayList<Step1AlertShould>();
            for (Step1AlertShould step1AlertShouldListNewStep1AlertShouldToAttach : step1AlertShouldListNew) {
                step1AlertShouldListNewStep1AlertShouldToAttach = em.getReference(step1AlertShouldListNewStep1AlertShouldToAttach.getClass(), step1AlertShouldListNewStep1AlertShouldToAttach.getId());
                attachedStep1AlertShouldListNew.add(step1AlertShouldListNewStep1AlertShouldToAttach);
            }
            step1AlertShouldListNew = attachedStep1AlertShouldListNew;
            step1.setStep1AlertShouldList(step1AlertShouldListNew);
            List<Problem> attachedProblemListNew = new ArrayList<Problem>();
            for (Problem problemListNewProblemToAttach : problemListNew) {
                problemListNewProblemToAttach = em.getReference(problemListNewProblemToAttach.getClass(), problemListNewProblemToAttach.getId());
                attachedProblemListNew.add(problemListNewProblemToAttach);
            }
            problemListNew = attachedProblemListNew;
            step1.setProblemList(problemListNew);
            List<Step1Why> attachedStep1WhyListNew = new ArrayList<Step1Why>();
            for (Step1Why step1WhyListNewStep1WhyToAttach : step1WhyListNew) {
                step1WhyListNewStep1WhyToAttach = em.getReference(step1WhyListNewStep1WhyToAttach.getClass(), step1WhyListNewStep1WhyToAttach.getId());
                attachedStep1WhyListNew.add(step1WhyListNewStep1WhyToAttach);
            }
            step1WhyListNew = attachedStep1WhyListNew;
            step1.setStep1WhyList(step1WhyListNew);
            List<Step1View> attachedStep1ViewListNew = new ArrayList<Step1View>();
            for (Step1View step1ViewListNewStep1ViewToAttach : step1ViewListNew) {
                step1ViewListNewStep1ViewToAttach = em.getReference(step1ViewListNewStep1ViewToAttach.getClass(), step1ViewListNewStep1ViewToAttach.getId());
                attachedStep1ViewListNew.add(step1ViewListNewStep1ViewToAttach);
            }
            step1ViewListNew = attachedStep1ViewListNew;
            step1.setStep1ViewList(step1ViewListNew);
            step1 = em.merge(step1);
            if (idProblemOld != null && !idProblemOld.equals(idProblemNew)) {
                idProblemOld.getStep1List().remove(step1);
                idProblemOld = em.merge(idProblemOld);
            }
            if (idProblemNew != null && !idProblemNew.equals(idProblemOld)) {
                idProblemNew.getStep1List().add(step1);
                idProblemNew = em.merge(idProblemNew);
            }
            if (userValidationOld != null && !userValidationOld.equals(userValidationNew)) {
                userValidationOld.getStep1List().remove(step1);
                userValidationOld = em.merge(userValidationOld);
            }
            if (userValidationNew != null && !userValidationNew.equals(userValidationOld)) {
                userValidationNew.getStep1List().add(step1);
                userValidationNew = em.merge(userValidationNew);
            }
            for (Step1Comment step1CommentListNewStep1Comment : step1CommentListNew) {
                if (!step1CommentListOld.contains(step1CommentListNewStep1Comment)) {
                    Step1 oldIdStep1OfStep1CommentListNewStep1Comment = step1CommentListNewStep1Comment.getIdStep1();
                    step1CommentListNewStep1Comment.setIdStep1(step1);
                    step1CommentListNewStep1Comment = em.merge(step1CommentListNewStep1Comment);
                    if (oldIdStep1OfStep1CommentListNewStep1Comment != null && !oldIdStep1OfStep1CommentListNewStep1Comment.equals(step1)) {
                        oldIdStep1OfStep1CommentListNewStep1Comment.getStep1CommentList().remove(step1CommentListNewStep1Comment);
                        oldIdStep1OfStep1CommentListNewStep1Comment = em.merge(oldIdStep1OfStep1CommentListNewStep1Comment);
                    }
                }
            }
            for (Step1Action step1ActionListNewStep1Action : step1ActionListNew) {
                if (!step1ActionListOld.contains(step1ActionListNewStep1Action)) {
                    Step1 oldIdStep1OfStep1ActionListNewStep1Action = step1ActionListNewStep1Action.getIdStep1();
                    step1ActionListNewStep1Action.setIdStep1(step1);
                    step1ActionListNewStep1Action = em.merge(step1ActionListNewStep1Action);
                    if (oldIdStep1OfStep1ActionListNewStep1Action != null && !oldIdStep1OfStep1ActionListNewStep1Action.equals(step1)) {
                        oldIdStep1OfStep1ActionListNewStep1Action.getStep1ActionList().remove(step1ActionListNewStep1Action);
                        oldIdStep1OfStep1ActionListNewStep1Action = em.merge(oldIdStep1OfStep1ActionListNewStep1Action);
                    }
                }
            }
            for (Step1Securisation step1SecurisationListNewStep1Securisation : step1SecurisationListNew) {
                if (!step1SecurisationListOld.contains(step1SecurisationListNewStep1Securisation)) {
                    Step1 oldIdStep1OfStep1SecurisationListNewStep1Securisation = step1SecurisationListNewStep1Securisation.getIdStep1();
                    step1SecurisationListNewStep1Securisation.setIdStep1(step1);
                    step1SecurisationListNewStep1Securisation = em.merge(step1SecurisationListNewStep1Securisation);
                    if (oldIdStep1OfStep1SecurisationListNewStep1Securisation != null && !oldIdStep1OfStep1SecurisationListNewStep1Securisation.equals(step1)) {
                        oldIdStep1OfStep1SecurisationListNewStep1Securisation.getStep1SecurisationList().remove(step1SecurisationListNewStep1Securisation);
                        oldIdStep1OfStep1SecurisationListNewStep1Securisation = em.merge(oldIdStep1OfStep1SecurisationListNewStep1Securisation);
                    }
                }
            }
            for (Step1ActionFollowed step1ActionFollowedListNewStep1ActionFollowed : step1ActionFollowedListNew) {
                if (!step1ActionFollowedListOld.contains(step1ActionFollowedListNewStep1ActionFollowed)) {
                    Step1 oldIdStep1OfStep1ActionFollowedListNewStep1ActionFollowed = step1ActionFollowedListNewStep1ActionFollowed.getIdStep1();
                    step1ActionFollowedListNewStep1ActionFollowed.setIdStep1(step1);
                    step1ActionFollowedListNewStep1ActionFollowed = em.merge(step1ActionFollowedListNewStep1ActionFollowed);
                    if (oldIdStep1OfStep1ActionFollowedListNewStep1ActionFollowed != null && !oldIdStep1OfStep1ActionFollowedListNewStep1ActionFollowed.equals(step1)) {
                        oldIdStep1OfStep1ActionFollowedListNewStep1ActionFollowed.getStep1ActionFollowedList().remove(step1ActionFollowedListNewStep1ActionFollowed);
                        oldIdStep1OfStep1ActionFollowedListNewStep1ActionFollowed = em.merge(oldIdStep1OfStep1ActionFollowedListNewStep1ActionFollowed);
                    }
                }
            }
            for (Step1AlertCan step1AlertCanListNewStep1AlertCan : step1AlertCanListNew) {
                if (!step1AlertCanListOld.contains(step1AlertCanListNewStep1AlertCan)) {
                    Step1 oldIdStep1OfStep1AlertCanListNewStep1AlertCan = step1AlertCanListNewStep1AlertCan.getIdStep1();
                    step1AlertCanListNewStep1AlertCan.setIdStep1(step1);
                    step1AlertCanListNewStep1AlertCan = em.merge(step1AlertCanListNewStep1AlertCan);
                    if (oldIdStep1OfStep1AlertCanListNewStep1AlertCan != null && !oldIdStep1OfStep1AlertCanListNewStep1AlertCan.equals(step1)) {
                        oldIdStep1OfStep1AlertCanListNewStep1AlertCan.getStep1AlertCanList().remove(step1AlertCanListNewStep1AlertCan);
                        oldIdStep1OfStep1AlertCanListNewStep1AlertCan = em.merge(oldIdStep1OfStep1AlertCanListNewStep1AlertCan);
                    }
                }
            }
            for (Step1AlertShould step1AlertShouldListNewStep1AlertShould : step1AlertShouldListNew) {
                if (!step1AlertShouldListOld.contains(step1AlertShouldListNewStep1AlertShould)) {
                    Step1 oldIdStep1OfStep1AlertShouldListNewStep1AlertShould = step1AlertShouldListNewStep1AlertShould.getIdStep1();
                    step1AlertShouldListNewStep1AlertShould.setIdStep1(step1);
                    step1AlertShouldListNewStep1AlertShould = em.merge(step1AlertShouldListNewStep1AlertShould);
                    if (oldIdStep1OfStep1AlertShouldListNewStep1AlertShould != null && !oldIdStep1OfStep1AlertShouldListNewStep1AlertShould.equals(step1)) {
                        oldIdStep1OfStep1AlertShouldListNewStep1AlertShould.getStep1AlertShouldList().remove(step1AlertShouldListNewStep1AlertShould);
                        oldIdStep1OfStep1AlertShouldListNewStep1AlertShould = em.merge(oldIdStep1OfStep1AlertShouldListNewStep1AlertShould);
                    }
                }
            }
            for (Problem problemListOldProblem : problemListOld) {
                if (!problemListNew.contains(problemListOldProblem)) {
                    problemListOldProblem.setIdStep1(null);
                    problemListOldProblem = em.merge(problemListOldProblem);
                }
            }
            for (Problem problemListNewProblem : problemListNew) {
                if (!problemListOld.contains(problemListNewProblem)) {
                    Step1 oldIdStep1OfProblemListNewProblem = problemListNewProblem.getIdStep1();
                    problemListNewProblem.setIdStep1(step1);
                    problemListNewProblem = em.merge(problemListNewProblem);
                    if (oldIdStep1OfProblemListNewProblem != null && !oldIdStep1OfProblemListNewProblem.equals(step1)) {
                        oldIdStep1OfProblemListNewProblem.getProblemList().remove(problemListNewProblem);
                        oldIdStep1OfProblemListNewProblem = em.merge(oldIdStep1OfProblemListNewProblem);
                    }
                }
            }
            for (Step1Why step1WhyListNewStep1Why : step1WhyListNew) {
                if (!step1WhyListOld.contains(step1WhyListNewStep1Why)) {
                    Step1 oldIdStep1OfStep1WhyListNewStep1Why = step1WhyListNewStep1Why.getIdStep1();
                    step1WhyListNewStep1Why.setIdStep1(step1);
                    step1WhyListNewStep1Why = em.merge(step1WhyListNewStep1Why);
                    if (oldIdStep1OfStep1WhyListNewStep1Why != null && !oldIdStep1OfStep1WhyListNewStep1Why.equals(step1)) {
                        oldIdStep1OfStep1WhyListNewStep1Why.getStep1WhyList().remove(step1WhyListNewStep1Why);
                        oldIdStep1OfStep1WhyListNewStep1Why = em.merge(oldIdStep1OfStep1WhyListNewStep1Why);
                    }
                }
            }
            for (Step1View step1ViewListNewStep1View : step1ViewListNew) {
                if (!step1ViewListOld.contains(step1ViewListNewStep1View)) {
                    Step1 oldIdStep1OfStep1ViewListNewStep1View = step1ViewListNewStep1View.getIdStep1();
                    step1ViewListNewStep1View.setIdStep1(step1);
                    step1ViewListNewStep1View = em.merge(step1ViewListNewStep1View);
                    if (oldIdStep1OfStep1ViewListNewStep1View != null && !oldIdStep1OfStep1ViewListNewStep1View.equals(step1)) {
                        oldIdStep1OfStep1ViewListNewStep1View.getStep1ViewList().remove(step1ViewListNewStep1View);
                        oldIdStep1OfStep1ViewListNewStep1View = em.merge(oldIdStep1OfStep1ViewListNewStep1View);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = step1.getId();
                if (findStep1(id) == null) {
                    throw new NonexistentEntityException("The step1 with id " + id + " no longer exists.");
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
            Step1 step1;
            try {
                step1 = em.getReference(Step1.class, id);
                step1.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The step1 with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Step1Comment> step1CommentListOrphanCheck = step1.getStep1CommentList();
            for (Step1Comment step1CommentListOrphanCheckStep1Comment : step1CommentListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Step1 (" + step1 + ") cannot be destroyed since the Step1Comment " + step1CommentListOrphanCheckStep1Comment + " in its step1CommentList field has a non-nullable idStep1 field.");
            }
            List<Step1Action> step1ActionListOrphanCheck = step1.getStep1ActionList();
            for (Step1Action step1ActionListOrphanCheckStep1Action : step1ActionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Step1 (" + step1 + ") cannot be destroyed since the Step1Action " + step1ActionListOrphanCheckStep1Action + " in its step1ActionList field has a non-nullable idStep1 field.");
            }
            List<Step1Securisation> step1SecurisationListOrphanCheck = step1.getStep1SecurisationList();
            for (Step1Securisation step1SecurisationListOrphanCheckStep1Securisation : step1SecurisationListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Step1 (" + step1 + ") cannot be destroyed since the Step1Securisation " + step1SecurisationListOrphanCheckStep1Securisation + " in its step1SecurisationList field has a non-nullable idStep1 field.");
            }
            List<Step1ActionFollowed> step1ActionFollowedListOrphanCheck = step1.getStep1ActionFollowedList();
            for (Step1ActionFollowed step1ActionFollowedListOrphanCheckStep1ActionFollowed : step1ActionFollowedListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Step1 (" + step1 + ") cannot be destroyed since the Step1ActionFollowed " + step1ActionFollowedListOrphanCheckStep1ActionFollowed + " in its step1ActionFollowedList field has a non-nullable idStep1 field.");
            }
            List<Step1AlertCan> step1AlertCanListOrphanCheck = step1.getStep1AlertCanList();
            for (Step1AlertCan step1AlertCanListOrphanCheckStep1AlertCan : step1AlertCanListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Step1 (" + step1 + ") cannot be destroyed since the Step1AlertCan " + step1AlertCanListOrphanCheckStep1AlertCan + " in its step1AlertCanList field has a non-nullable idStep1 field.");
            }
            List<Step1AlertShould> step1AlertShouldListOrphanCheck = step1.getStep1AlertShouldList();
            for (Step1AlertShould step1AlertShouldListOrphanCheckStep1AlertShould : step1AlertShouldListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Step1 (" + step1 + ") cannot be destroyed since the Step1AlertShould " + step1AlertShouldListOrphanCheckStep1AlertShould + " in its step1AlertShouldList field has a non-nullable idStep1 field.");
            }
            List<Step1Why> step1WhyListOrphanCheck = step1.getStep1WhyList();
            for (Step1Why step1WhyListOrphanCheckStep1Why : step1WhyListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Step1 (" + step1 + ") cannot be destroyed since the Step1Why " + step1WhyListOrphanCheckStep1Why + " in its step1WhyList field has a non-nullable idStep1 field.");
            }
            List<Step1View> step1ViewListOrphanCheck = step1.getStep1ViewList();
            for (Step1View step1ViewListOrphanCheckStep1View : step1ViewListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Step1 (" + step1 + ") cannot be destroyed since the Step1View " + step1ViewListOrphanCheckStep1View + " in its step1ViewList field has a non-nullable idStep1 field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Problem idProblem = step1.getIdProblem();
            if (idProblem != null) {
                idProblem.getStep1List().remove(step1);
                idProblem = em.merge(idProblem);
            }
            User userValidation = step1.getUserValidation();
            if (userValidation != null) {
                userValidation.getStep1List().remove(step1);
                userValidation = em.merge(userValidation);
            }
            List<Problem> problemList = step1.getProblemList();
            for (Problem problemListProblem : problemList) {
                problemListProblem.setIdStep1(null);
                problemListProblem = em.merge(problemListProblem);
            }
            em.remove(step1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Step1> findStep1Entities() {
        return findStep1Entities(true, -1, -1);
    }

    public List<Step1> findStep1Entities(int maxResults, int firstResult) {
        return findStep1Entities(false, maxResults, firstResult);
    }

    private List<Step1> findStep1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Step1.class));
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

    public Step1 findStep1(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Step1.class, id);
        } finally {
            em.close();
        }
    }

    public int getStep1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Step1> rt = cq.from(Step1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
