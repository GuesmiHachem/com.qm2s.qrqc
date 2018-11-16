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
import domaine.Config;
import entity.Problem;
import entity.User;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import pdf.CreateProblemPDF;
import service.ServiceProblem;

public class Mailer {

    public static void sendProblem(String name, String from, String password, User user, Problem problem) {
        //Get properties object    
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        InternetAddress fromAddress;
        Address[] adrs = new Address[1];
        try {
            fromAddress = new InternetAddress(from, name);
            adrs[0] = fromAddress;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Mailer.class.getName()).log(Level.SEVERE, null, ex);
        }

        //get Session   
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        //compose message    
        try {

            Multipart multipart = new MimeMultipart();

            MimeMessage message = new MimeMessage(session);
            message.addFrom(adrs);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            message.setSubject(problem.getCode());
            
            message.setHeader("Disposition-Notification-To", user.getEmail());
           // message.setHeader("Return-Receipt-To", user.getEmail());
            //message.setText(msg);

            /*   BodyPart messageBodyPart0 = new MimeBodyPart();
            String contenu = "<img src='/img/profile/logo.png'  />";
            messageBodyPart0.setContent(contenu, "text/html");
            multipart.addBodyPart(messageBodyPart0);
            
             */
            

            //3) create MimeBodyPart object and set your message text   
            BodyPart messageBodyPart1 = new MimeBodyPart();
            String msg = "\nBonjour " + user.getFirstName() + " , \n\n";
            msg = msg + "Voici ce probléme publiée sur e-QRQC.com qui pourrait vous intéresser:\n\n";
            msg = msg + "================  PROBLEME ================\n\n";
            msg = msg + "Code Probléme : " + problem.getCode() + "\n";
            msg = msg + "Type Probléme : " + problem.getIdTypeProblem().getName() + "\n";
            msg = msg + "Réference     : " + problem.getReference() + "\n";
            msg = msg + "Status        : " + problem.getStatus() + "\n";
            msg = msg + "Créér par     : " + problem.getIdUser().getFirstName() + " " + problem.getIdUser().getName() + "\n";
            msg = msg + "===========================================\n\n";
            messageBodyPart1.setText(msg);
            multipart.addBodyPart(messageBodyPart1);

            BodyPart messageBodyPart2 = new MimeBodyPart();
            String pdf = "<B>veuillez cliquer ici : <a href='http://51.68.47.58:8080/e-qrqc-1.0/Problem?id=" + problem.getId() + "'>" + problem.getCode() + "</a>";
            messageBodyPart2.setContent(pdf, "text/html");
            multipart.addBodyPart(messageBodyPart2);

            //4) create new MimeBodyPart object and set DataHandler object to this object      
            MimeBodyPart messageBodyPart3 = new MimeBodyPart();
            pdf.CreateProblemPDF problemPdf = new CreateProblemPDF(problem);
            String filePdf = new Config().pathPdf + problem.getCode() + ".pdf";//change accordingly  
            DataSource source = new FileDataSource(filePdf);
            messageBodyPart3.setDataHandler(new DataHandler(source));
            messageBodyPart3.setFileName(problem.getCode() + ".pdf");
            multipart.addBodyPart(messageBodyPart3);

            /*     MimeBodyPart messageBodyPart4 = new MimeBodyPart();
            //pdf.CreateProblemPDF problemPdf = new CreateProblemPDF(problem);
            String file = new Config().pathPictureUser +"logo.png";//change accordingly  
            DataSource s = new FileDataSource(file);
            messageBodyPart4.setDataHandler(new DataHandler(s));
            //messageBodyPart4.setFileName(problem.getCode() + ".pdf");
            multipart.addBodyPart(messageBodyPart4);
             */
            //6) set the multiplart object to the message object  
            message.setContent(multipart);

            //7) send message  
            Transport.send(message);

            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
