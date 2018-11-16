/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

/**
 *
 * @author Hachem
 */
import entity.Problem;
import entity.User;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import service.ServiceProblem;
import service.ServiceUser;

public class SendEmail {

    

    public static void main(String[] args) {
        //from,password,to,subject,message  
       // Mailer.send(" e-QRQC V1.0 ","idev.hachem@gmail.com", "98687465.aA", "guesmi.hachem@gmail.com", "Problem:20180310_03", "vvvvvv vvvvv gg");
        //change from, password and to  
        Mailer.sendProblem(" e-QRQC V1.0 ","idev.hachem@gmail.com", "98687465.aA", ServiceUser.find(28), ServiceProblem.find(80));
    }
}
