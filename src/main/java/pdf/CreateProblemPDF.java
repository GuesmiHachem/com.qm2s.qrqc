/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import domaine.Config;
import entity.Problem;
import entity.Step1;
import entity.Step1Action;
import entity.Step1AlertCan;
import entity.Step1AlertShould;
import entity.Step1SecurityPlan;
import entity.Step1Why;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ServiceProblem;
import servlet.ProblemPdf;

/**
 *
 * @author Hachem
 */
public class CreateProblemPDF {

    public CreateProblemPDF(Problem problem) {
        createProblemPDF(problem);
    }

    public void createProblemPDF(Problem problem) {
        Document document = new Document();
        //float widthPage = document.getPageSize().getWidth();
        //float heightPage = document.getPageSize().getHeight();
        try {

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new Config().pathPdf + problem.getCode() + ".pdf"));
            createFooter(document, writer);
            document.addTitle(problem.getCode());
            document.open();

            createHeader(document, problem);
            retourLine(document);
            createTitle1(document);
            retourLine(document);
            createProfileUser(document, problem);
            retourLine(document);
            createDescriptionProblem(document, problem);
            retourLine(document);
            createTitle2(document, "Step1");
            retourLine(document);
            createTitle3(document, "Caractérisation");
            retourLine(document);
            createStep1Part1(document, problem);
            retourLine(document);
            createAlertUser(document, problem);
            retourLine(document);
            createStep1Other(document, problem);
            retourLine(document);
            document.newPage();
            create2Piece(document, problem);
            retourLine(document);

            retourLine(document);
            createTitle3(document, "Actions immédiates");
            retourLine(document);
            createStep1Part2(document, problem);
            retourLine(document);
            createPlanSecurisation(document, problem);
            retourLine(document);
            createTitle3(document, "Analyse et actions définitives");
            retourLine(document);
            createListWhy(document, problem);
            retourLine(document);
            createListAction(document, problem);
            retourLine(document);

            //createFooter(document, writer);
        } catch (Exception e) {
            System.out.println(e);
        }
        document.close();
    }

    public class FooterTable extends PdfPageEventHelper {

        protected PdfPTable footer;
        // protected Phrase watermark = new Phrase("e-QRQC -- V 1.0", new Font(FontFamily.TIMES_ROMAN, 60, Font.NORMAL, BaseColor.LIGHT_GRAY));

        public FooterTable(PdfPTable footer) {
            this.footer = footer;
        }

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            footer.writeSelectedRows(0, -1, 36, 36, writer.getDirectContent());

            //PdfContentByte canvas = writer.getDirectContentUnder();
            //ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 298, 421, 45);
        }
    }

    public void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        String idProblem = request.getParameter("id");
        entity.Problem problem = ServiceProblem.find(Integer.parseInt(idProblem));
        entity.User userProblem = problem.getIdUser();

        File pdfFile = new File(new Config().pathPdf + problem.getCode() + ".pdf");

        response.setContentType("application/pdf");
        response.setContentLength((int) pdfFile.length());

        FileInputStream fileInputStream = new FileInputStream(pdfFile);
        OutputStream responseOutputStream = response.getOutputStream();
        int bytes;
        while ((bytes = fileInputStream.read()) != -1) {
            responseOutputStream.write(bytes);
        }

    }

    public void retourLine(Document document) {
        try {
            Paragraph par = new Paragraph();
            par.add("\n");
            document.add(par);
        } catch (DocumentException ex) {
            Logger.getLogger(ProblemPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createTitle1(Document document) throws DocumentException, IOException {

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1});
        PdfPCell cell = new Colonne("Rapport de QRQC", 18, BaseColor.WHITE, BaseColor.GRAY, 8, PdfPCell.ALIGN_CENTER, 1).getPdfCell();
        cell.setBorder(Rectangle.BOX);
        cell.setBorderWidth(0.1f);
        cell.setBorderColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        // table.addCell(new Colonne("Rapport de QRQC", 15, BaseColor.WHITE, BaseColor.BLUE, 5, PdfPCell.ALIGN_CENTER, 1).getPdfCell());

        document.add(table);
    }

    public void createTitle2(Document document, String chaine) throws DocumentException, IOException {

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1});

        PdfPCell cell = new Colonne(chaine, 12, BaseColor.WHITE, BaseColor.DARK_GRAY, 5, PdfPCell.ALIGN_CENTER, 1).getPdfCell();
        cell.setBorder(Rectangle.BOX);
        cell.setBorderWidth(0.1f);
        // cell.setBorderColor(BaseColor.BLUE);
        table.addCell(cell);
        document.add(table);
    }

    public void createTitle3(Document document, String chaine) throws DocumentException, IOException {

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1});

        PdfPCell cell = new Colonne(chaine, 12, BaseColor.BLACK, BaseColor.ORANGE, 5, PdfPCell.ALIGN_CENTER, 1).getPdfCell();
        //cell.setBorder(Rectangle.BOX);
        //cell.setBorderWidth(0);
        // cell.setBorderColor(BaseColor.BLUE);
        table.addCell(cell);
        document.add(table);
    }

    public void createHeader(Document document, entity.Problem problem) throws DocumentException, IOException {

        Font fontBlue = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK);
        Chunk fontBlueText1 = new Chunk("Société de Tri & de Retouche STR TQM\n", fontBlue);
        Chunk fontBlueText2 = new Chunk("Tunisie\n", fontBlue);
        Chunk fontBlueText3 = new Chunk("Adresse : Rue abderrahmen elbahri Boumhal\n", fontBlue);
        Chunk fontBlueText4 = new Chunk("Tél : 58533201 / 58533200\n", fontBlue);

        Image img = Image.getInstance(new Config().pathPictureUser + "logo.png");
        img.setAlt("ffff");
        img.scaleToFit(100, 100);

        Paragraph par = new Paragraph();
        par.add(fontBlueText1);
        par.add(fontBlueText2);
        par.add(fontBlueText3);
        par.add(fontBlueText4);

        PdfPCell cell1 = new PdfPCell(img);
        cell1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell1.setBorderWidth(0);

        PdfPCell cell3 = new PdfPCell(par);
        cell3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell3.setBorderWidth(0);

        PdfPCell cell2 = new PdfPCell();
        cell2.setBorderWidth(0);

        PdfPTable tableHeader2 = new PdfPTable(3);
        tableHeader2.setWidthPercentage(100);
        tableHeader2.setWidths(new int[]{1, 2, 2});

        tableHeader2.addCell(cell1);
        tableHeader2.addCell(cell2);
        tableHeader2.addCell(cell3);
        tableHeader2.completeRow();

        PdfPCell cell11 = new PdfPCell(tableHeader2);
        cell11.setBorderColor(BaseColor.LIGHT_GRAY);

        cell11.setPadding(5);
        PdfPTable tableHeader1 = new PdfPTable(1);
        tableHeader1.setWidthPercentage(100);
        tableHeader1.addCell(cell11);

        document.add(tableHeader1);
    }

    public void createFooter(Document document, PdfWriter writer) throws DocumentException, IOException {

        //=========================================
        Font f1 = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.DARK_GRAY);
        Chunk ch1 = new Chunk("Document généré le \n" + new Date().toLocaleString().substring(0, 12) + "\n" + new Date().toLocaleString().substring(12), f1);

        Paragraph p1 = new Paragraph(ch1);

        PdfPCell cell1 = new PdfPCell(p1);
        cell1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell1.setBorderWidth(0);

        //=========================================
        Font f2 = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.DARK_GRAY);
        Chunk ch11 = new Chunk("Rapport génerer automatiquement par la base e-QRQC V1.0 de STR\n", f2);
        //Chunk ch22 = new Chunk("Tunisie\n", f2);
        Chunk ch33 = new Chunk("Adresse : Rue abderrahmen elbahri Boumhal Tél : 58533201 / 58533200   site web : www.tunisiestr.com\n", f2);
        //Chunk ch44 = new Chunk("Tél : 58533201 / 58533200\n", f2);

        Paragraph par1 = new Paragraph();
        par1.add(ch11);
        //par1.add(ch22);
        par1.add(ch33);
        //par1.add(ch44);

        PdfPCell cell2 = new PdfPCell(par1);
        cell2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell2.setBorderWidth(0);

        //=========================================
        Font f3 = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL, BaseColor.DARK_GRAY);
        // Chunk ch3 = new Chunk("Page " + document.getPageNumber() + 1 + "/" + document.getPageNumber() + " ", f3);
        Chunk ch3 = new Chunk("Page ", f3);

        Paragraph p3 = new Paragraph(ch3);

        PdfPCell cell3 = new PdfPCell(p3);
        cell3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell3.setBorderWidth(0);

        //=========================================
        PdfPTable tableHeader2 = new PdfPTable(3);
        tableHeader2.setWidthPercentage(100);
        tableHeader2.setWidths(new int[]{1, 3, 1});

        tableHeader2.addCell(cell1);
        tableHeader2.addCell(cell2);
        tableHeader2.addCell(cell3);
        tableHeader2.completeRow();

        PdfPCell cell11 = new PdfPCell(tableHeader2);
        cell11.setBorderColor(BaseColor.LIGHT_GRAY);
        cell11.setPadding(0);

        PdfPTable tableHeader1 = new PdfPTable(1);
        tableHeader1.setTotalWidth(523);
        tableHeader1.setWidthPercentage(100);
        tableHeader1.addCell(cell11);
        //=========================================

        FooterTable event = new FooterTable(tableHeader1);
        writer.setPageEvent(event);

    }

    public void createProfileUser(Document document, entity.Problem problem) throws DocumentException, IOException {

        Step1 step1 = problem.getIdStep1();

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{2, 1, 1});
        table.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        Image img = Image.getInstance(new Config().pathPictureUser + problem.getIdUser().getPicture());
        img.scaleToFit(100, 100);

        PdfPCell cel = new PdfPCell(img);
        cel.setColspan(1);
        cel.setRowspan(6);
        cel.setPadding(10);
        cel.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        cel.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        table.addCell(cel);

        table.addCell(new Colonne("Prénom", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(problem.getIdUser().getFirstName(), 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.addCell(new Colonne("Nom", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(problem.getIdUser().getName(), 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.addCell(new Colonne("Niveau Equipe", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(problem.getIdUser().getIdLevel0().getName(), 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.addCell(new Colonne("Niveau 1", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(problem.getIdUser().getIdLevel0().getIdLevel1().getName(), 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.addCell(new Colonne("Niveau 2", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(problem.getIdUser().getIdLevel0().getIdLevel1().getIdLevel2().getName(), 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.addCell(new Colonne("Niveau 3", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(problem.getIdUser().getIdLevel0().getIdLevel1().getIdLevel2().getIdLevel3().getName(), 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        document.add(table);
    }

    public void createDescriptionProblem(Document document, entity.Problem problem) throws DocumentException, IOException {

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1, 1, 1, 1});

        table.addCell(new Colonne("Probléme", 12, BaseColor.WHITE, BaseColor.DARK_GRAY, 5, PdfPCell.ALIGN_CENTER, 4).getPdfCell());

        table.addCell(new Colonne("Code Probléme", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(problem.getCode(), 10, BaseColor.BLACK, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.addCell(new Colonne("Type Probléme", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(problem.getIdTypeProblem().getName(), 10, BaseColor.BLACK, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.addCell(new Colonne("Réference", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(problem.getReference(), 10, BaseColor.BLACK, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.addCell(new Colonne("Status", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(problem.getStatus(), 10, BaseColor.BLACK, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.addCell(new Colonne("Date création", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(problem.getDateCreation().toLocaleString(), 10, BaseColor.BLACK, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.addCell(new Colonne("Créér par", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(problem.getIdUser().getFirstName() + " " + problem.getIdUser().getName(), 10, BaseColor.BLACK, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        document.add(table);
    }

    public void createStep1Part1(Document document, entity.Problem problem) throws DocumentException, IOException {

        Step1 step1 = problem.getIdStep1();

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1, 1, 1, 1});

        //table.addCell(new Colonne("Caractérisation", 12, BaseColor.BLACK, BaseColor.ORANGE, 5, PdfPCell.ALIGN_CENTER, 4).getPdfCell());
        table.addCell(new Colonne("Que s'est t'il passé ?", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(step1.getWhat(), 10, BaseColor.BLACK, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.addCell(new Colonne("Quand ?", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(step1.getWhen(), 10, BaseColor.BLACK, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.addCell(new Colonne("Où ?", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(step1.getWhere(), 10, BaseColor.BLACK, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.addCell(new Colonne("Comment ?", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(step1.getHow(), 10, BaseColor.BLACK, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.addCell(new Colonne("Combien ?", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(step1.getHowMutch() + "", 10, BaseColor.BLACK, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.addCell(new Colonne("Pourquoi ?", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(step1.getWhy(), 10, BaseColor.BLACK, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.completeRow();
        document.add(table);
    }

    public void createAlertUser(Document document, entity.Problem problem) throws DocumentException, IOException {

        Step1 step1 = problem.getIdStep1();

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1, 1});

        com.itextpdf.text.List list1 = new com.itextpdf.text.List();
        for (Step1AlertCan step1AlertCan : step1.getStep1AlertCanList()) {
            list1.add(step1AlertCan.getIdTypeUser().getName());
        }

        com.itextpdf.text.List list2 = new com.itextpdf.text.List();
        for (Step1AlertShould step1AlertShould : step1.getStep1AlertShouldList()) {
            list2.add(step1AlertShould.getIdTypeUser().getName());
        }

        PdfPCell cell1 = new PdfPCell();
        cell1.addElement(list1);

        PdfPCell cell2 = new PdfPCell();
        cell2.addElement(list2);

        table.addCell(new Colonne("Utilisateur Qui doit être Alerté", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne("Utilisateur Qui peut être Alerté", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(cell1);
        table.addCell(cell2);

        document.add(table);
    }

    public void create2Piece(Document document, entity.Problem problem) throws DocumentException, IOException {

        Step1 step1 = problem.getIdStep1();

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1, 1});

        Image imgBad = null;
        Image imgGood = null;
        try {
            imgBad = Image.getInstance(new Config().pathPictureProblem + step1.getBadPiece());
        } catch (BadElementException ex) {
            Logger.getLogger(ProblemPdf.class.getName()).log(Level.SEVERE, null, ex);
            imgBad = null;
        } catch (IOException ex) {
            Logger.getLogger(ProblemPdf.class.getName()).log(Level.SEVERE, null, ex);
            imgBad = null;
        }

        try {
            imgGood = Image.getInstance(new Config().pathPictureProblem + step1.getGoodPiece());
        } catch (BadElementException ex) {
            Logger.getLogger(ProblemPdf.class.getName()).log(Level.SEVERE, null, ex);
            imgGood = null;
        } catch (IOException ex) {
            Logger.getLogger(ProblemPdf.class.getName()).log(Level.SEVERE, null, ex);
            imgGood = null;
        }

        PdfPCell cell1 = new PdfPCell(new Phrase("Pas d'image"));
        cell1.setFixedHeight(100);
        cell1.setPadding(10);
        if (imgBad != null) {
            cell1 = new PdfPCell(imgBad);
            cell1.setFixedHeight(100);
            cell1.setPadding(10);
        }

        PdfPCell cell2 = new PdfPCell(new Phrase("Pas d'image"));
        cell2.setFixedHeight(100);
        cell2.setPadding(10);
        if (imgGood != null) {
            cell2 = new PdfPCell(imgGood);
            cell2.setFixedHeight(100);
            cell2.setPadding(10);
        }

        table.addCell(new Colonne("PIECE MAUVAISE", 10, BaseColor.BLACK, BaseColor.RED, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne("PIECE BONNE", 10, BaseColor.BLACK, BaseColor.GREEN, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(cell1);
        table.addCell(cell2);

        document.add(table);
    }

    public void createStep1Other(Document document, entity.Problem problem) throws DocumentException, IOException {

        Step1 step1 = problem.getIdStep1();

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(50);
        table.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        table.setWidths(new int[]{1, 1});

        table.addCell(new Colonne("Respect du standard", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        if (step1.getRespectStandard()) {
            table.addCell(new Colonne("Oui", 10, BaseColor.GREEN, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        } else {
            table.addCell(new Colonne("Non", 10, BaseColor.RED, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        }

        table.addCell(new Colonne("Probléme recurrent", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        if (step1.getRecognizedProblem()) {
            table.addCell(new Colonne("Oui", 10, BaseColor.GREEN, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        } else {
            table.addCell(new Colonne("Non", 10, BaseColor.RED, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        }

        table.completeRow();
        document.add(table);
    }

    public void createStep1Part2(Document document, entity.Problem problem) throws DocumentException, IOException {

        Step1 step1 = problem.getIdStep1();
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1, 1, 1, 1});
        table.addCell(new Colonne("Lancer un tri ?", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        if (step1.getSort()) {
            table.addCell(new Colonne("Oui", 10, BaseColor.GREEN, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        } else {
            table.addCell(new Colonne("Non", 10, BaseColor.RED, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        }

        table.addCell(new Colonne("Quel est le critéré de tri ?", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(step1.getSortCriterion(), 10, BaseColor.BLACK, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.addCell(new Colonne("Autre Actions immédiates", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne(step1.getImmediateActions().trim(), 10, BaseColor.BLACK, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        table.addCell(new Colonne("Validation de redémarrage", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        if (step1.getStartValidation()) {
            table.addCell(new Colonne("Oui", 10, BaseColor.GREEN, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        } else {
            table.addCell(new Colonne("Non", 10, BaseColor.RED, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        }

        table.completeRow();
        document.add(table);

    }

    public void createPlanSecurisation(Document document, entity.Problem problem) throws DocumentException, IOException {

        Step1 step1 = problem.getIdStep1();

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1, 1, 1, 1});

        table.addCell(new Colonne("Plan de securité", 12, BaseColor.BLACK, BaseColor.GRAY, 5, PdfPCell.ALIGN_CENTER, 4).getPdfCell());

        table.addCell(new Colonne("Où", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne("Qui", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne("Combien", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne("Resultat", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        for (Step1SecurityPlan step1SecurityPlan : step1.getStep1SecurityPlanList()) {
            table.addCell(new Colonne(step1SecurityPlan.getWhere(), 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            table.addCell(new Colonne(step1SecurityPlan.getWho().getFirstName()+" "+step1SecurityPlan.getWho().getName(), 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            table.addCell(new Colonne(step1SecurityPlan.getHowMuch() + "", 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            table.addCell(new Colonne(step1SecurityPlan.getResult() + "", 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        }

        document.add(table);
    }

    public void createListWhy(Document document, entity.Problem problem) throws DocumentException, IOException {

        Step1 step1 = problem.getIdStep1();

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1, 2, 2});

        table.addCell(new Colonne("5 Pourquois", 12, BaseColor.BLACK, BaseColor.GRAY, 5, PdfPCell.ALIGN_CENTER, 4).getPdfCell());

        table.addCell(new Colonne("ID", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne("Pourquoi", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne("Commentaire", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        for (int i = 0; i < step1.getStep1WhyList().size(); i++) {
            Step1Why Step1Why = step1.getStep1WhyList().get(i);
            table.addCell(new Colonne((i + 1) + "", 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            table.addCell(new Colonne(Step1Why.getWhy(), 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            table.addCell(new Colonne(Step1Why.getComment() + "", 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        }

        for (int i = step1.getStep1ActionList().size(); i < 5; i++) {
            table.addCell(new Colonne((i + 1) + " ", 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            table.addCell(new Colonne(" ", 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            table.addCell(new Colonne(" ", 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        }
        document.add(table);
    }

    public void createListAction(Document document, entity.Problem problem) throws DocumentException, IOException {

        Step1 step1 = problem.getIdStep1();

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1, 2, 1, 2, 3, 1});

        table.addCell(new Colonne("Action", 12, BaseColor.BLACK, BaseColor.GRAY, 5, PdfPCell.ALIGN_CENTER, 6).getPdfCell());

        table.addCell(new Colonne("ID", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne("Action", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne("Qui", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne("Quand", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne("Commentaire", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
        table.addCell(new Colonne("Status", 10, BaseColor.BLACK, BaseColor.LIGHT_GRAY, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        for (int i = 0; i < step1.getStep1ActionList().size(); i++) {
            Step1Action step1Action = step1.getStep1ActionList().get(i);

            table.addCell(new Colonne((i + 1) + "", 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            table.addCell(new Colonne(step1Action.getAction(), 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            table.addCell(new Colonne(step1Action.getWho() + "", 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            table.addCell(new Colonne(step1Action.getWhen() + "", 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            table.addCell(new Colonne(step1Action.getComment().trim() + "", 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            if (step1Action.getStatus() == 100) {
                table.addCell(new Colonne(step1Action.getStatus() + "", 10, BaseColor.GREEN, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            } else {
                table.addCell(new Colonne(step1Action.getStatus() + "", 10, BaseColor.PINK, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            }
        }

        for (int i = step1.getStep1ActionList().size(); i < 5; i++) {
            table.addCell(new Colonne((i + 1) + " ", 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            table.addCell(new Colonne(" ", 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            table.addCell(new Colonne(" ", 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            table.addCell(new Colonne(" ", 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            table.addCell(new Colonne(" ", 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());
            table.addCell(new Colonne(" ", 10, BaseColor.DARK_GRAY, BaseColor.WHITE, 5, PdfPCell.ALIGN_LEFT, 1).getPdfCell());

        }

        document.add(table);
    }

    public class Colonne {

        public String text;
        public int size;
        public BaseColor color;
        public BaseColor background;
        public float padding;
        public int horizontalAlignment;
        public int colspan;

        public PdfPCell pdfCell;
        public Paragraph paragraph;
        public Chunk chunk;
        public Font font;

        public Colonne() {
            text = "";
            size = 10;
            color = BaseColor.BLACK;
            background = BaseColor.WHITE;
            padding = 5;
            horizontalAlignment = PdfPCell.ALIGN_LEFT;
            colspan = 1;
        }

        public Colonne(String text, int size, BaseColor color, BaseColor background, float padding, int horizontalAlignment, int colspan) {

            super();
            this.text = text;
            this.size = size;
            this.color = color;
            this.background = background;
            this.padding = padding;
            this.horizontalAlignment = horizontalAlignment;
            this.colspan = colspan;

            font = new Font(Font.FontFamily.TIMES_ROMAN, size, Font.NORMAL, color);
            chunk = new Chunk(text);
            chunk.setFont(font);
            paragraph = new Paragraph(chunk);
            pdfCell = new PdfPCell(paragraph);
            pdfCell.setBackgroundColor(background);
            pdfCell.setHorizontalAlignment(horizontalAlignment);
            pdfCell.setPadding(padding);
            pdfCell.setColspan(colspan);
        }

        public PdfPCell getPdfCell() {
            return pdfCell;
        }

    }

}
