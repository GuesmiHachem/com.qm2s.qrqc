/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Step1Comment;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.*;

/**
 *
 * @author Hachem
 */
public class FactoryJPA {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    private static EntityManagerFactory emf = null;

    private static Level0JpaController level0JpaController = null;
    private static Level1JpaController level1JpaController = null;
    private static Level2JpaController level2JpaController = null;
    private static Level2RelationJpaController level2RelationJpaController = null;//************
    private static Level3JpaController level3JpaController = null;

    private static NatureJpaController natureJpaController = null;
    private static ProcessusJpaController processusJpaController = null;

    private static ProblemJpaController problemJpaController = null;
    private static Step1JpaController step1JpaController = null;
    private static Step1ActionFollowedJpaController step1ActionFollowedJpaController = null;//************
    private static Step1ActionJpaController step1ActionJpaController = null;
    private static Step1AlertCanJpaController step1AlertCanJpaController = null;
    private static Step1AlertShouldJpaController step1AlertShouldJpaController = null;
    private static Step1SecurisationJpaController step1SecurisationJpaController = null;
    private static Step1WhyJpaController step1WhyJpaController = null;//*************
    private static Step1CommentJpaController step1CommentJpaController = null;//*************
    private static Step1ViewJpaController step1ViewJpaController = null;//*************

    private static TypeProblemJpaController typeProblemJpaController = null;
    private static TypeUserJpaController typeUserJpaController = null;

    private static NotificationJpaController notificationJpaController = null;
    private static UserJpaController userJpaController = null;

    private static RankTeamJpaController rankTeamJpaController = null;//*************

    private static HardwareJpaController hardwareJpaController = null;//*************

    public static EntityManagerFactory getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("com.mycompany_xxx_war_1.0-SNAPSHOTPU");
        }
        return emf;
    }

    //======================== 01 ========================
    public static Level0JpaController getLevel0JpaController() {
        if (level0JpaController == null) {
            level0JpaController = new Level0JpaController(getEntityManager());
        }
        return level0JpaController;
    }

    //======================== 02 ========================
    public static Level1JpaController getLevel1JpaController() {
        if (level1JpaController == null) {
            level1JpaController = new Level1JpaController(getEntityManager());
        }
        return level1JpaController;
    }

    //======================== 03 ========================
    public static Level2JpaController getLevel2JpaController() {
        if (level2JpaController == null) {
            level2JpaController = new Level2JpaController(getEntityManager());
        }
        return level2JpaController;
    }

    //======================== 04 ========================
    public static Level2RelationJpaController getLevel2RelationJpaController() {
        if (level2RelationJpaController == null) {
            level2RelationJpaController = new Level2RelationJpaController(getEntityManager());
        }
        return level2RelationJpaController;
    }

    //======================== 05 ========================
    public static Level3JpaController getLevel3JpaController() {
        if (level3JpaController == null) {
            level3JpaController = new Level3JpaController(getEntityManager());
        }
        return level3JpaController;
    }

    //======================== 06 ========================
    public static NatureJpaController getNatureJpaController() {
        if (natureJpaController == null) {
            natureJpaController = new NatureJpaController(getEntityManager());
        }
        return natureJpaController;
    }

    //======================== 07 ========================
    public static ProcessusJpaController getProcessusJpaController() {
        if (processusJpaController == null) {
            processusJpaController = new ProcessusJpaController(getEntityManager());
        }
        return processusJpaController;
    }

    //======================== 08 ========================
    public static NotificationJpaController getNotificationJpaController() {
        if (notificationJpaController == null) {
            notificationJpaController = new NotificationJpaController(getEntityManager());
        }
        return notificationJpaController;
    }

    //======================== 09 ========================
    public static ProblemJpaController getProblemJpaController() {
        if (problemJpaController == null) {
            problemJpaController = new ProblemJpaController(getEntityManager());
        }
        return problemJpaController;
    }

    //======================== 10 ========================
    public static Step1JpaController getStep1JpaController() {
        if (step1JpaController == null) {
            step1JpaController = new Step1JpaController(getEntityManager());
        }
        return step1JpaController;
    }

    //======================== 11 ========================
    public static Step1WhyJpaController getStep1WhyJpaController() {
        if (step1WhyJpaController == null) {
            step1WhyJpaController = new Step1WhyJpaController(getEntityManager());
        }
        return step1WhyJpaController;
    }

    //======================== 12 ========================
    public static TypeProblemJpaController getTypeProblemJpaController() {
        if (typeProblemJpaController == null) {
            typeProblemJpaController = new TypeProblemJpaController(getEntityManager());
        }
        return typeProblemJpaController;
    }

    //======================== 13 ========================
    public static TypeUserJpaController getTypeUserJpaController() {
        if (typeUserJpaController == null) {
            typeUserJpaController = new TypeUserJpaController(getEntityManager());
        }
        return typeUserJpaController;
    }

    //======================== 14 ========================
    public static UserJpaController getUserJpaController() {
        if (userJpaController == null) {
            userJpaController = new UserJpaController(getEntityManager());
        }
        return userJpaController;
    }

    //======================== 15 ========================
    public static Step1ActionFollowedJpaController getStep1ActionFollowedJpaController() {
        if (step1ActionFollowedJpaController == null) {
            step1ActionFollowedJpaController = new Step1ActionFollowedJpaController(getEntityManager());
        }
        return step1ActionFollowedJpaController;
    }

    //======================== 16 ========================
    public static Step1ActionJpaController getStep1ActionJpaController() {
        if (step1ActionJpaController == null) {
            step1ActionJpaController = new Step1ActionJpaController(getEntityManager());
        }
        return step1ActionJpaController;
    }

    //======================== 17 ========================
    public static Step1AlertCanJpaController getStep1AlertCanJpaController() {
        if (step1AlertCanJpaController == null) {
            step1AlertCanJpaController = new Step1AlertCanJpaController(getEntityManager());
        }
        return step1AlertCanJpaController;
    }

    //======================== 18 ========================
    public static Step1AlertShouldJpaController getStep1AlertShouldJpaController() {
        if (step1AlertShouldJpaController == null) {
            step1AlertShouldJpaController = new Step1AlertShouldJpaController(getEntityManager());
        }
        return step1AlertShouldJpaController;
    }

    //======================== 19 ========================
    public static Step1SecurisationJpaController getStep1SecurisationJpaController() {
        if (step1SecurisationJpaController == null) {
            step1SecurisationJpaController = new Step1SecurisationJpaController(getEntityManager());
        }
        return step1SecurisationJpaController;
    }

    //======================== 20 ========================
    public static RankTeamJpaController getRankTeamJpaController() {
        if (rankTeamJpaController == null) {
            rankTeamJpaController = new RankTeamJpaController(getEntityManager());
        }
        return rankTeamJpaController;
    }

    //======================== 21 ========================
    public static Step1CommentJpaController getStep1CommentJpaController() {
        if (step1CommentJpaController == null) {
            step1CommentJpaController = new Step1CommentJpaController(getEntityManager());
        }
        return step1CommentJpaController;
    }

    //======================== 22 ========================
    public static Step1ViewJpaController getStep1ViewJpaController() {
        if (step1ViewJpaController == null) {
            step1ViewJpaController = new Step1ViewJpaController(getEntityManager());
        }
        return step1ViewJpaController;
    }
    
    //======================== 23 ========================
    public static HardwareJpaController getHardwareJpaController() {
        if (hardwareJpaController == null) {
            hardwareJpaController = new HardwareJpaController(getEntityManager());
        }
        return hardwareJpaController;
    }

}
