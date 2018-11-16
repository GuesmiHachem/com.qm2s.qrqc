/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaine;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hachem
 */
public class Colonne {

    public String text;
    public int size;
    public BaseColor color;
    public BaseColor background;

    public float padding;
    public int horizontalAlignment;
    public int colspan;
    //public static com.itextpdf.text.Paragraph par;
// public static PdfPCell pdfCell=new PdfPCell();

    /*
    
   

    
   
    public Chunk chunk;
    public Font font;
    
    
    public Colonne() {
        text = "";
        size = 10;
        color = BaseColor.BLACK;
        background = BaseColor.WHITE;
        padding = 5f;
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

        font = new Font(FontFamily.TIMES_ROMAN, size, Font.NORMAL, color);
        chunk = new Chunk(text);
        chunk.setFont(font);
        paragraph = new Paragraph(chunk);
        pdfCell = new PdfPCell(paragraph);
        pdfCell.setBackgroundColor(background);
        pdfCell.setHorizontalAlignment(horizontalAlignment);
        pdfCell.setPadding(padding);
        pdfCell.setColspan(colspan);
    }
     */
    private void getPdfCellcc(Document doc) {
        PdfPCell c = new PdfPCell(new Phrase("dddd"));
        PdfPTable table = new PdfPTable(1);
        //return table;
        //  return new PdfPCell();
    }

    public static void main(String[] args) {
       
    }

}
