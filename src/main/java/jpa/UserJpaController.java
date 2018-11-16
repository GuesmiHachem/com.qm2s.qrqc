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
import entity.Level0;
import entity.Level1;
import entity.Level2;
import entity.Level3;
import entity.TypeUser;
import entity.Step1Comment;
import java.util.ArrayList;
import java.util.List;
import entity.Step1Action;
import entity.Step1Securisation;
import entity.Step1;
import entity.Notification;
import entity.Processus;
import entity.Problem;
import entity.Step1View;
import entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.exceptions.IllegalOrphanException;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Hachem
 */
public class UserJpaController implements Serializable {

    public UserJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public User create(User user) {
        if (user.getStep1CommentList() == null) {
            user.setStep1CommentList(new ArrayList<Step1Comment>());
        }
        if (user.getStep1ActionList() == null) {
            user.setStep1ActionList(new ArrayList<Step1Action>());
        }
        if (user.getStep1SecurisationList() == null) {
            user.setStep1SecurisationList(new ArrayList<Step1Securisation>());
        }
        if (user.getStep1List() == null) {
            user.setStep1List(new ArrayList<Step1>());
        }
        if (user.getNotificationList() == null) {
            user.setNotificationList(new ArrayList<Notification>());
        }
        if (user.getProcessusList() == null) {
            user.setProcessusList(new ArrayList<Processus>());
        }
        if (user.getProblemList() == null) {
            user.setProblemList(new ArrayList<Problem>());
        }
        if (user.getStep1ViewList() == null) {
            user.setStep1ViewList(new ArrayList<Step1View>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Level0 idLevel0 = user.getIdLevel0();
            if (idLevel0 != null) {
                idLevel0 = em.getReference(idLevel0.getClass(), idLevel0.getId());
                user.setIdLevel0(idLevel0);
            }
            Level1 idLevel1 = user.getIdLevel1();
            if (idLevel1 != null) {
                idLevel1 = em.getReference(idLevel1.getClass(), idLevel1.getId());
                user.setIdLevel1(idLevel1);
            }
            Level2 idLevel2 = user.getIdLevel2();
            if (idLevel2 != null) {
                idLevel2 = em.getReference(idLevel2.getClass(), idLevel2.getId());
                user.setIdLevel2(idLevel2);
            }
            Level3 idLevel3 = user.getIdLevel3();
            if (idLevel3 != null) {
                idLevel3 = em.getReference(idLevel3.getClass(), idLevel3.getId());
                user.setIdLevel3(idLevel3);
            }
            TypeUser idTypeUser = user.getIdTypeUser();
            if (idTypeUser != null) {
                idTypeUser = em.getReference(idTypeUser.getClass(), idTypeUser.getId());
                user.setIdTypeUser(idTypeUser);
            }
            List<Step1Comment> attachedStep1CommentList = new ArrayList<Step1Comment>();
            for (Step1Comment step1CommentListStep1CommentToAttach : user.getStep1CommentList()) {
                step1CommentListStep1CommentToAttach = em.getReference(step1CommentListStep1CommentToAttach.getClass(), step1CommentListStep1CommentToAttach.getId());
                attachedStep1CommentList.add(step1CommentListStep1CommentToAttach);
            }
            user.setStep1CommentList(attachedStep1CommentList);
            List<Step1Action> attachedStep1ActionList = new ArrayList<Step1Action>();
            for (Step1Action step1ActionListStep1ActionToAttach : user.getStep1ActionList()) {
                step1ActionListStep1ActionToAttach = em.getReference(step1ActionListStep1ActionToAttach.getClass(), step1ActionListStep1ActionToAttach.getId());
                attachedStep1ActionList.add(step1ActionListStep1ActionToAttach);
            }
            user.setStep1ActionList(attachedStep1ActionList);
            List<Step1Securisation> attachedStep1SecurisationList = new ArrayList<Step1Securisation>();
            for (Step1Securisation step1SecurisationListStep1SecurisationToAttach : user.getStep1SecurisationList()) {
                step1SecurisationListStep1SecurisationToAttach = em.getReference(step1SecurisationListStep1SecurisationToAttach.getClass(), step1SecurisationListStep1SecurisationToAttach.getId());
                attachedStep1SecurisationList.add(step1SecurisationListStep1SecurisationToAttach);
            }
            user.setStep1SecurisationList(attachedStep1SecurisationList);
            List<Step1> attachedStep1List = new ArrayList<Step1>();
            for (Step1 step1ListStep1ToAttach : user.getStep1List()) {
                step1ListStep1ToAttach = em.getReference(step1ListStep1ToAttach.getClass(), step1ListStep1ToAttach.getId());
                attachedStep1List.add(step1ListStep1ToAttach);
            }
            user.setStep1List(attachedStep1List);
            List<Notification> attachedNotificationList = new ArrayList<Notification>();
            for (Notification notificationListNotificationToAttach : user.getNotificationList()) {
                notificationListNotificationToAttach = em.getReference(notificationListNotificationToAttach.getClass(), notificationListNotificationToAttach.getId());
                attachedNotificationList.add(notificationListNotificationToAttach);
            }
            user.setNotificationList(attachedNotificationList);
            List<Processus> attachedProcessusList = new ArrayList<Processus>();
            for (Processus processusListProcessusToAttach : user.getProcessusList()) {
                processusListProcessusToAttach = em.getReference(processusListProcessusToAttach.getClass(), processusListProcessusToAttach.getId());
                attachedProcessusList.add(processusListProcessusToAttach);
            }
            user.setProcessusList(attachedProcessusList);
            List<Problem> attachedProblemList = new ArrayList<Problem>();
            for (Problem problemListProblemToAttach : user.getProblemList()) {
                problemListProblemToAttach = em.getReference(problemListProblemToAttach.getClass(), problemListProblemToAttach.getId());
                attachedProblemList.add(problemListProblemToAttach);
            }
            user.setProblemList(attachedProblemList);
            List<Step1View> attachedStep1ViewList = new ArrayList<Step1View>();
            for (Step1View step1ViewListStep1ViewToAttach : user.getStep1ViewList()) {
                step1ViewListStep1ViewToAttach = em.getReference(step1ViewListStep1ViewToAttach.getClass(), step1ViewListStep1ViewToAttach.getId());
                attachedStep1ViewList.add(step1ViewListStep1ViewToAttach);
            }
            user.setStep1ViewList(attachedStep1ViewList);
            em.persist(user);
            if (idLevel0 != null) {
                idLevel0.getUserList().add(user);
                idLevel0 = em.merge(idLevel0);
            }
            if (idLevel1 != null) {
                idLevel1.getUserList().add(user);
                idLevel1 = em.merge(idLevel1);
            }
            if (idLevel2 != null) {
                idLevel2.getUserList().add(user);
                idLevel2 = em.merge(idLevel2);
            }
            if (idLevel3 != null) {
                idLevel3.getUserList().add(user);
                idLevel3 = em.merge(idLevel3);
            }
            if (idTypeUser != null) {
                idTypeUser.getUserList().add(user);
                idTypeUser = em.merge(idTypeUser);
            }
            for (Step1Comment step1CommentListStep1Comment : user.getStep1CommentList()) {
                User oldIdUserOfStep1CommentListStep1Comment = step1CommentListStep1Comment.getIdUser();
                step1CommentListStep1Comment.setIdUser(user);
                step1CommentListStep1Comment = em.merge(step1CommentListStep1Comment);
                if (oldIdUserOfStep1CommentListStep1Comment != null) {
                    oldIdUserOfStep1CommentListStep1Comment.getStep1CommentList().remove(step1CommentListStep1Comment);
                    oldIdUserOfStep1CommentListStep1Comment = em.merge(oldIdUserOfStep1CommentListStep1Comment);
                }
            }
            for (Step1Action step1ActionListStep1Action : user.getStep1ActionList()) {
                User oldAffectedToOfStep1ActionListStep1Action = step1ActionListStep1Action.getAffectedTo();
                step1ActionListStep1Action.setAffectedTo(user);
                step1ActionListStep1Action = em.merge(step1ActionListStep1Action);
                if (oldAffectedToOfStep1ActionListStep1Action != null) {
                    oldAffectedToOfStep1ActionListStep1Action.getStep1ActionList().remove(step1ActionListStep1Action);
                    oldAffectedToOfStep1ActionListStep1Action = em.merge(oldAffectedToOfStep1ActionListStep1Action);
                }
            }
            for (Step1Securisation step1SecurisationListStep1Securisation : user.getStep1SecurisationList()) {
                User oldAffectedToOfStep1SecurisationListStep1Securisation = step1SecurisationListStep1Securisation.getAffectedTo();
                step1SecurisationListStep1Securisation.setAffectedTo(user);
                step1SecurisationListStep1Securisation = em.merge(step1SecurisationListStep1Securisation);
                if (oldAffectedToOfStep1SecurisationListStep1Securisation != null) {
                    oldAffectedToOfStep1SecurisationListStep1Securisation.getStep1SecurisationList().remove(step1SecurisationListStep1Securisation);
                    oldAffectedToOfStep1SecurisationListStep1Securisation = em.merge(oldAffectedToOfStep1SecurisationListStep1Securisation);
                }
            }
            for (Step1 step1ListStep1 : user.getStep1List()) {
                User oldUserValidationOfStep1ListStep1 = step1ListStep1.getUserValidation();
                step1ListStep1.setUserValidation(user);
                step1ListStep1 = em.merge(step1ListStep1);
                if (oldUserValidationOfStep1ListStep1 != null) {
                    oldUserValidationOfStep1ListStep1.getStep1List().remove(step1ListStep1);
                    oldUserValidationOfStep1ListStep1 = em.merge(oldUserValidationOfStep1ListStep1);
                }
            }
            for (Notification notificationListNotification : user.getNotificationList()) {
                User oldIdUserOfNotificationListNotification = notificationListNotification.getIdUser();
                notificationListNotification.setIdUser(user);
                notificationListNotification = em.merge(notificationListNotification);
                if (oldIdUserOfNotificationListNotification != null) {
                    oldIdUserOfNotificationListNotification.getNotificationList().remove(notificationListNotification);
                    oldIdUserOfNotificationListNotification = em.merge(oldIdUserOfNotificationListNotification);
                }
            }
            for (Processus processusListProcessus : user.getProcessusList()) {
                User oldIdUserOfProcessusListProcessus = processusListProcessus.getIdUser();
                processusListProcessus.setIdUser(user);
                processusListProcessus = em.merge(processusListProcessus);
                if (oldIdUserOfProcessusListProcessus != null) {
                    oldIdUserOfProcessusListProcessus.getProcessusList().remove(processusListProcessus);
                    oldIdUserOfProcessusListProcessus = em.merge(oldIdUserOfProcessusListProcessus);
                }
            }
            for (Problem problemListProblem : user.getProblemList()) {
                User oldIdUserOfProblemListProblem = problemListProblem.getIdUser();
                problemListProblem.setIdUser(user);
                problemListProblem = em.merge(problemListProblem);
                if (oldIdUserOfProblemListProblem != null) {
                    oldIdUserOfProblemListProblem.getProblemList().remove(problemListProblem);
                    oldIdUserOfProblemListProblem = em.merge(oldIdUserOfProblemListProblem);
                }
            }
            for (Step1View step1ViewListStep1View : user.getStep1ViewList()) {
                User oldIdUserOfStep1ViewListStep1View = step1ViewListStep1View.getIdUser();
                step1ViewListStep1View.setIdUser(user);
                step1ViewListStep1View = em.merge(step1ViewListStep1View);
                if (oldIdUserOfStep1ViewListStep1View != null) {
                    oldIdUserOfStep1ViewListStep1View.getStep1ViewList().remove(step1ViewListStep1View);
                    oldIdUserOfStep1ViewListStep1View = em.merge(oldIdUserOfStep1ViewListStep1View);
                }
            }
            em.getTransaction().commit();
            return user;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(User user) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            User persistentUser = em.find(User.class, user.getId());
            Level0 idLevel0Old = persistentUser.getIdLevel0();
            Level0 idLevel0New = user.getIdLevel0();
            Level1 idLevel1Old = persistentUser.getIdLevel1();
            Level1 idLevel1New = user.getIdLevel1();
            Level2 idLevel2Old = persistentUser.getIdLevel2();
            Level2 idLevel2New = user.getIdLevel2();
            Level3 idLevel3Old = persistentUser.getIdLevel3();
            Level3 idLevel3New = user.getIdLevel3();
            TypeUser idTypeUserOld = persistentUser.getIdTypeUser();
            TypeUser idTypeUserNew = user.getIdTypeUser();
            List<Step1Comment> step1CommentListOld = persistentUser.getStep1CommentList();
            List<Step1Comment> step1CommentListNew = user.getStep1CommentList();
            List<Step1Action> step1ActionListOld = persistentUser.getStep1ActionList();
            List<Step1Action> step1ActionListNew = user.getStep1ActionList();
            List<Step1Securisation> step1SecurisationListOld = persistentUser.getStep1SecurisationList();
            List<Step1Securisation> step1SecurisationListNew = user.getStep1SecurisationList();
            List<Step1> step1ListOld = persistentUser.getStep1List();
            List<Step1> step1ListNew = user.getStep1List();
            List<Notification> notificationListOld = persistentUser.getNotificationList();
            List<Notification> notificationListNew = user.getNotificationList();
            List<Processus> processusListOld = persistentUser.getProcessusList();
            List<Processus> processusListNew = user.getProcessusList();
            List<Problem> problemListOld = persistentUser.getProblemList();
            List<Problem> problemListNew = user.getProblemList();
            List<Step1View> step1ViewListOld = persistentUser.getStep1ViewList();
            List<Step1View> step1ViewListNew = user.getStep1ViewList();
            List<String> illegalOrphanMessages = null;
            for (Step1Comment step1CommentListOldStep1Comment : step1CommentListOld) {
                if (!step1CommentListNew.contains(step1CommentListOldStep1Comment)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Step1Comment " + step1CommentListOldStep1Comment + " since its idUser field is not nullable.");
                }
            }
            for (Step1Action step1ActionListOldStep1Action : step1ActionListOld) {
                if (!step1ActionListNew.contains(step1ActionListOldStep1Action)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Step1Action " + step1ActionListOldStep1Action + " since its affectedTo field is not nullable.");
                }
            }
            for (Step1Securisation step1SecurisationListOldStep1Securisation : step1SecurisationListOld) {
                if (!step1SecurisationListNew.contains(step1SecurisationListOldStep1Securisation)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Step1Securisation " + step1SecurisationListOldStep1Securisation + " since its affectedTo field is not nullable.");
                }
            }
            for (Notification notificationListOldNotification : notificationListOld) {
                if (!notificationListNew.contains(notificationListOldNotification)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Notification " + notificationListOldNotification + " since its idUser field is not nullable.");
                }
            }
            for (Step1View step1ViewListOldStep1View : step1ViewListOld) {
                if (!step1ViewListNew.contains(step1ViewListOldStep1View)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Step1View " + step1ViewListOldStep1View + " since its idUser field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idLevel0New != null) {
                idLevel0New = em.getReference(idLevel0New.getClass(), idLevel0New.getId());
                user.setIdLevel0(idLevel0New);
            }
            if (idLevel1New != null) {
                idLevel1New = em.getReference(idLevel1New.getClass(), idLevel1New.getId());
                user.setIdLevel1(idLevel1New);
            }
            if (idLevel2New != null) {
                idLevel2New = em.getReference(idLevel2New.getClass(), idLevel2New.getId());
                user.setIdLevel2(idLevel2New);
            }
            if (idLevel3New != null) {
                idLevel3New = em.getReference(idLevel3New.getClass(), idLevel3New.getId());
                user.setIdLevel3(idLevel3New);
            }
            if (idTypeUserNew != null) {
                idTypeUserNew = em.getReference(idTypeUserNew.getClass(), idTypeUserNew.getId());
                user.setIdTypeUser(idTypeUserNew);
            }
            List<Step1Comment> attachedStep1CommentListNew = new ArrayList<Step1Comment>();
            for (Step1Comment step1CommentListNewStep1CommentToAttach : step1CommentListNew) {
                step1CommentListNewStep1CommentToAttach = em.getReference(step1CommentListNewStep1CommentToAttach.getClass(), step1CommentListNewStep1CommentToAttach.getId());
                attachedStep1CommentListNew.add(step1CommentListNewStep1CommentToAttach);
            }
            step1CommentListNew = attachedStep1CommentListNew;
            user.setStep1CommentList(step1CommentListNew);
            List<Step1Action> attachedStep1ActionListNew = new ArrayList<Step1Action>();
            for (Step1Action step1ActionListNewStep1ActionToAttach : step1ActionListNew) {
                step1ActionListNewStep1ActionToAttach = em.getReference(step1ActionListNewStep1ActionToAttach.getClass(), step1ActionListNewStep1ActionToAttach.getId());
                attachedStep1ActionListNew.add(step1ActionListNewStep1ActionToAttach);
            }
            step1ActionListNew = attachedStep1ActionListNew;
            user.setStep1ActionList(step1ActionListNew);
            List<Step1Securisation> attachedStep1SecurisationListNew = new ArrayList<Step1Securisation>();
            for (Step1Securisation step1SecurisationListNewStep1SecurisationToAttach : step1SecurisationListNew) {
                step1SecurisationListNewStep1SecurisationToAttach = em.getReference(step1SecurisationListNewStep1SecurisationToAttach.getClass(), step1SecurisationListNewStep1SecurisationToAttach.getId());
                attachedStep1SecurisationListNew.add(step1SecurisationListNewStep1SecurisationToAttach);
            }
            step1SecurisationListNew = attachedStep1SecurisationListNew;
            user.setStep1SecurisationList(step1SecurisationListNew);
            List<Step1> attachedStep1ListNew = new ArrayList<Step1>();
            for (Step1 step1ListNewStep1ToAttach : step1ListNew) {
                step1ListNewStep1ToAttach = em.getReference(step1ListNewStep1ToAttach.getClass(), step1ListNewStep1ToAttach.getId());
                attachedStep1ListNew.add(step1ListNewStep1ToAttach);
            }
            step1ListNew = attachedStep1ListNew;
            user.setStep1List(step1ListNew);
            List<Notification> attachedNotificationListNew = new ArrayList<Notification>();
            for (Notification notificationListNewNotificationToAttach : notificationListNew) {
                notificationListNewNotificationToAttach = em.getReference(notificationListNewNotificationToAttach.getClass(), notificationListNewNotificationToAttach.getId());
                attachedNotificationListNew.add(notificationListNewNotificationToAttach);
            }
            notificationListNew = attachedNotificationListNew;
            user.setNotificationList(notificationListNew);
            List<Processus> attachedProcessusListNew = new ArrayList<Processus>();
            for (Processus processusListNewProcessusToAttach : processusListNew) {
                processusListNewProcessusToAttach = em.getReference(processusListNewProcessusToAttach.getClass(), processusListNewProcessusToAttach.getId());
                attachedProcessusListNew.add(processusListNewProcessusToAttach);
            }
            processusListNew = attachedProcessusListNew;
            user.setProcessusList(processusListNew);
            List<Problem> attachedProblemListNew = new ArrayList<Problem>();
            for (Problem problemListNewProblemToAttach : problemListNew) {
                problemListNewProblemToAttach = em.getReference(problemListNewProblemToAttach.getClass(), problemListNewProblemToAttach.getId());
                attachedProblemListNew.add(problemListNewProblemToAttach);
            }
            problemListNew = attachedProblemListNew;
            user.setProblemList(problemListNew);
            List<Step1View> attachedStep1ViewListNew = new ArrayList<Step1View>();
            for (Step1View step1ViewListNewStep1ViewToAttach : step1ViewListNew) {
                step1ViewListNewStep1ViewToAttach = em.getReference(step1ViewListNewStep1ViewToAttach.getClass(), step1ViewListNewStep1ViewToAttach.getId());
                attachedStep1ViewListNew.add(step1ViewListNewStep1ViewToAttach);
            }
            step1ViewListNew = attachedStep1ViewListNew;
            user.setStep1ViewList(step1ViewListNew);
            user = em.merge(user);
            if (idLevel0Old != null && !idLevel0Old.equals(idLevel0New)) {
                idLevel0Old.getUserList().remove(user);
                idLevel0Old = em.merge(idLevel0Old);
            }
            if (idLevel0New != null && !idLevel0New.equals(idLevel0Old)) {
                idLevel0New.getUserList().add(user);
                idLevel0New = em.merge(idLevel0New);
            }
            if (idLevel1Old != null && !idLevel1Old.equals(idLevel1New)) {
                idLevel1Old.getUserList().remove(user);
                idLevel1Old = em.merge(idLevel1Old);
            }
            if (idLevel1New != null && !idLevel1New.equals(idLevel1Old)) {
                idLevel1New.getUserList().add(user);
                idLevel1New = em.merge(idLevel1New);
            }
            if (idLevel2Old != null && !idLevel2Old.equals(idLevel2New)) {
                idLevel2Old.getUserList().remove(user);
                idLevel2Old = em.merge(idLevel2Old);
            }
            if (idLevel2New != null && !idLevel2New.equals(idLevel2Old)) {
                idLevel2New.getUserList().add(user);
                idLevel2New = em.merge(idLevel2New);
            }
            if (idLevel3Old != null && !idLevel3Old.equals(idLevel3New)) {
                idLevel3Old.getUserList().remove(user);
                idLevel3Old = em.merge(idLevel3Old);
            }
            if (idLevel3New != null && !idLevel3New.equals(idLevel3Old)) {
                idLevel3New.getUserList().add(user);
                idLevel3New = em.merge(idLevel3New);
            }
            if (idTypeUserOld != null && !idTypeUserOld.equals(idTypeUserNew)) {
                idTypeUserOld.getUserList().remove(user);
                idTypeUserOld = em.merge(idTypeUserOld);
            }
            if (idTypeUserNew != null && !idTypeUserNew.equals(idTypeUserOld)) {
                idTypeUserNew.getUserList().add(user);
                idTypeUserNew = em.merge(idTypeUserNew);
            }
            for (Step1Comment step1CommentListNewStep1Comment : step1CommentListNew) {
                if (!step1CommentListOld.contains(step1CommentListNewStep1Comment)) {
                    User oldIdUserOfStep1CommentListNewStep1Comment = step1CommentListNewStep1Comment.getIdUser();
                    step1CommentListNewStep1Comment.setIdUser(user);
                    step1CommentListNewStep1Comment = em.merge(step1CommentListNewStep1Comment);
                    if (oldIdUserOfStep1CommentListNewStep1Comment != null && !oldIdUserOfStep1CommentListNewStep1Comment.equals(user)) {
                        oldIdUserOfStep1CommentListNewStep1Comment.getStep1CommentList().remove(step1CommentListNewStep1Comment);
                        oldIdUserOfStep1CommentListNewStep1Comment = em.merge(oldIdUserOfStep1CommentListNewStep1Comment);
                    }
                }
            }
            for (Step1Action step1ActionListNewStep1Action : step1ActionListNew) {
                if (!step1ActionListOld.contains(step1ActionListNewStep1Action)) {
                    User oldAffectedToOfStep1ActionListNewStep1Action = step1ActionListNewStep1Action.getAffectedTo();
                    step1ActionListNewStep1Action.setAffectedTo(user);
                    step1ActionListNewStep1Action = em.merge(step1ActionListNewStep1Action);
                    if (oldAffectedToOfStep1ActionListNewStep1Action != null && !oldAffectedToOfStep1ActionListNewStep1Action.equals(user)) {
                        oldAffectedToOfStep1ActionListNewStep1Action.getStep1ActionList().remove(step1ActionListNewStep1Action);
                        oldAffectedToOfStep1ActionListNewStep1Action = em.merge(oldAffectedToOfStep1ActionListNewStep1Action);
                    }
                }
            }
            for (Step1Securisation step1SecurisationListNewStep1Securisation : step1SecurisationListNew) {
                if (!step1SecurisationListOld.contains(step1SecurisationListNewStep1Securisation)) {
                    User oldAffectedToOfStep1SecurisationListNewStep1Securisation = step1SecurisationListNewStep1Securisation.getAffectedTo();
                    step1SecurisationListNewStep1Securisation.setAffectedTo(user);
                    step1SecurisationListNewStep1Securisation = em.merge(step1SecurisationListNewStep1Securisation);
                    if (oldAffectedToOfStep1SecurisationListNewStep1Securisation != null && !oldAffectedToOfStep1SecurisationListNewStep1Securisation.equals(user)) {
                        oldAffectedToOfStep1SecurisationListNewStep1Securisation.getStep1SecurisationList().remove(step1SecurisationListNewStep1Securisation);
                        oldAffectedToOfStep1SecurisationListNewStep1Securisation = em.merge(oldAffectedToOfStep1SecurisationListNewStep1Securisation);
                    }
                }
            }
            for (Step1 step1ListOldStep1 : step1ListOld) {
                if (!step1ListNew.contains(step1ListOldStep1)) {
                    step1ListOldStep1.setUserValidation(null);
                    step1ListOldStep1 = em.merge(step1ListOldStep1);
                }
            }
            for (Step1 step1ListNewStep1 : step1ListNew) {
                if (!step1ListOld.contains(step1ListNewStep1)) {
                    User oldUserValidationOfStep1ListNewStep1 = step1ListNewStep1.getUserValidation();
                    step1ListNewStep1.setUserValidation(user);
                    step1ListNewStep1 = em.merge(step1ListNewStep1);
                    if (oldUserValidationOfStep1ListNewStep1 != null && !oldUserValidationOfStep1ListNewStep1.equals(user)) {
                        oldUserValidationOfStep1ListNewStep1.getStep1List().remove(step1ListNewStep1);
                        oldUserValidationOfStep1ListNewStep1 = em.merge(oldUserValidationOfStep1ListNewStep1);
                    }
                }
            }
            for (Notification notificationListNewNotification : notificationListNew) {
                if (!notificationListOld.contains(notificationListNewNotification)) {
                    User oldIdUserOfNotificationListNewNotification = notificationListNewNotification.getIdUser();
                    notificationListNewNotification.setIdUser(user);
                    notificationListNewNotification = em.merge(notificationListNewNotification);
                    if (oldIdUserOfNotificationListNewNotification != null && !oldIdUserOfNotificationListNewNotification.equals(user)) {
                        oldIdUserOfNotificationListNewNotification.getNotificationList().remove(notificationListNewNotification);
                        oldIdUserOfNotificationListNewNotification = em.merge(oldIdUserOfNotificationListNewNotification);
                    }
                }
            }
            for (Processus processusListOldProcessus : processusListOld) {
                if (!processusListNew.contains(processusListOldProcessus)) {
                    processusListOldProcessus.setIdUser(null);
                    processusListOldProcessus = em.merge(processusListOldProcessus);
                }
            }
            for (Processus processusListNewProcessus : processusListNew) {
                if (!processusListOld.contains(processusListNewProcessus)) {
                    User oldIdUserOfProcessusListNewProcessus = processusListNewProcessus.getIdUser();
                    processusListNewProcessus.setIdUser(user);
                    processusListNewProcessus = em.merge(processusListNewProcessus);
                    if (oldIdUserOfProcessusListNewProcessus != null && !oldIdUserOfProcessusListNewProcessus.equals(user)) {
                        oldIdUserOfProcessusListNewProcessus.getProcessusList().remove(processusListNewProcessus);
                        oldIdUserOfProcessusListNewProcessus = em.merge(oldIdUserOfProcessusListNewProcessus);
                    }
                }
            }
            for (Problem problemListOldProblem : problemListOld) {
                if (!problemListNew.contains(problemListOldProblem)) {
                    problemListOldProblem.setIdUser(null);
                    problemListOldProblem = em.merge(problemListOldProblem);
                }
            }
            for (Problem problemListNewProblem : problemListNew) {
                if (!problemListOld.contains(problemListNewProblem)) {
                    User oldIdUserOfProblemListNewProblem = problemListNewProblem.getIdUser();
                    problemListNewProblem.setIdUser(user);
                    problemListNewProblem = em.merge(problemListNewProblem);
                    if (oldIdUserOfProblemListNewProblem != null && !oldIdUserOfProblemListNewProblem.equals(user)) {
                        oldIdUserOfProblemListNewProblem.getProblemList().remove(problemListNewProblem);
                        oldIdUserOfProblemListNewProblem = em.merge(oldIdUserOfProblemListNewProblem);
                    }
                }
            }
            for (Step1View step1ViewListNewStep1View : step1ViewListNew) {
                if (!step1ViewListOld.contains(step1ViewListNewStep1View)) {
                    User oldIdUserOfStep1ViewListNewStep1View = step1ViewListNewStep1View.getIdUser();
                    step1ViewListNewStep1View.setIdUser(user);
                    step1ViewListNewStep1View = em.merge(step1ViewListNewStep1View);
                    if (oldIdUserOfStep1ViewListNewStep1View != null && !oldIdUserOfStep1ViewListNewStep1View.equals(user)) {
                        oldIdUserOfStep1ViewListNewStep1View.getStep1ViewList().remove(step1ViewListNewStep1View);
                        oldIdUserOfStep1ViewListNewStep1View = em.merge(oldIdUserOfStep1ViewListNewStep1View);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = user.getId();
                if (findUser(id) == null) {
                    throw new NonexistentEntityException("The user with id " + id + " no longer exists.");
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
            User user;
            try {
                user = em.getReference(User.class, id);
                user.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Step1Comment> step1CommentListOrphanCheck = user.getStep1CommentList();
            for (Step1Comment step1CommentListOrphanCheckStep1Comment : step1CommentListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This User (" + user + ") cannot be destroyed since the Step1Comment " + step1CommentListOrphanCheckStep1Comment + " in its step1CommentList field has a non-nullable idUser field.");
            }
            List<Step1Action> step1ActionListOrphanCheck = user.getStep1ActionList();
            for (Step1Action step1ActionListOrphanCheckStep1Action : step1ActionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This User (" + user + ") cannot be destroyed since the Step1Action " + step1ActionListOrphanCheckStep1Action + " in its step1ActionList field has a non-nullable affectedTo field.");
            }
            List<Step1Securisation> step1SecurisationListOrphanCheck = user.getStep1SecurisationList();
            for (Step1Securisation step1SecurisationListOrphanCheckStep1Securisation : step1SecurisationListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This User (" + user + ") cannot be destroyed since the Step1Securisation " + step1SecurisationListOrphanCheckStep1Securisation + " in its step1SecurisationList field has a non-nullable affectedTo field.");
            }
            List<Notification> notificationListOrphanCheck = user.getNotificationList();
            for (Notification notificationListOrphanCheckNotification : notificationListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This User (" + user + ") cannot be destroyed since the Notification " + notificationListOrphanCheckNotification + " in its notificationList field has a non-nullable idUser field.");
            }
            List<Step1View> step1ViewListOrphanCheck = user.getStep1ViewList();
            for (Step1View step1ViewListOrphanCheckStep1View : step1ViewListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This User (" + user + ") cannot be destroyed since the Step1View " + step1ViewListOrphanCheckStep1View + " in its step1ViewList field has a non-nullable idUser field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Level0 idLevel0 = user.getIdLevel0();
            if (idLevel0 != null) {
                idLevel0.getUserList().remove(user);
                idLevel0 = em.merge(idLevel0);
            }
            Level1 idLevel1 = user.getIdLevel1();
            if (idLevel1 != null) {
                idLevel1.getUserList().remove(user);
                idLevel1 = em.merge(idLevel1);
            }
            Level2 idLevel2 = user.getIdLevel2();
            if (idLevel2 != null) {
                idLevel2.getUserList().remove(user);
                idLevel2 = em.merge(idLevel2);
            }
            Level3 idLevel3 = user.getIdLevel3();
            if (idLevel3 != null) {
                idLevel3.getUserList().remove(user);
                idLevel3 = em.merge(idLevel3);
            }
            TypeUser idTypeUser = user.getIdTypeUser();
            if (idTypeUser != null) {
                idTypeUser.getUserList().remove(user);
                idTypeUser = em.merge(idTypeUser);
            }
            List<Step1> step1List = user.getStep1List();
            for (Step1 step1ListStep1 : step1List) {
                step1ListStep1.setUserValidation(null);
                step1ListStep1 = em.merge(step1ListStep1);
            }
            List<Processus> processusList = user.getProcessusList();
            for (Processus processusListProcessus : processusList) {
                processusListProcessus.setIdUser(null);
                processusListProcessus = em.merge(processusListProcessus);
            }
            List<Problem> problemList = user.getProblemList();
            for (Problem problemListProblem : problemList) {
                problemListProblem.setIdUser(null);
                problemListProblem = em.merge(problemListProblem);
            }
            em.remove(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<User> findUserEntities() {
        return findUserEntities(true, -1, -1);
    }

    public List<User> findUserEntities(int maxResults, int firstResult) {
        return findUserEntities(false, maxResults, firstResult);
    }

    private List<User> findUserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(User.class));
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

    public User findUser(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    public int getUserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<User> rt = cq.from(User.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
