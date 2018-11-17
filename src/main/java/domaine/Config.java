/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaine;

/**
 *
 * @author Hachem
 */
public class Config {

    public String pathApp;
    public String pathPictureUser;
    public String pathPictureProblem;
    public String pathPdf;

    public Config() {
        config1();
    }

    public void config1() {
        this.pathApp = "C:\\Users\\Hachem\\Documents\\NetBeansProjects\\com.qm2s.qrqc\\";
        this.pathPictureUser = this.pathApp + "src\\main\\webapp\\img\\profile\\";
        this.pathPictureProblem = this.pathApp + "src\\main\\webapp\\upload\\";
        this.pathPdf = this.pathApp + "src\\main\\webapp\\pdf\\";

    }

    public void config2() {

        this.pathApp = "/usr/local/tomcat7/webapps/eq/";
        this.pathPictureUser = this.pathApp + "img/profile/";
        this.pathPictureProblem = this.pathApp + "upload/";
        this.pathPdf = this.pathApp + "pdf/";
    }

    public String getPathApp() {
        return pathApp;
    }

    public String getPathPictureUser() {
        return pathPictureUser;
    }

    public String getPathPictureProblem() {
        return pathPictureProblem;
    }

    public String getPathPdf() {
        return pathPdf;
    }

}
