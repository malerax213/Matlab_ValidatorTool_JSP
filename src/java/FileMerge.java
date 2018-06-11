
import java.io.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class FileMerge {

    public static void merge(File f1, File f2, File f3) throws FileNotFoundException, IOException {
        PrintWriter pw = new PrintWriter(f3.getAbsolutePath());
        BufferedReader br1 = new BufferedReader(new FileReader(f1.getAbsolutePath()));
        BufferedReader br2 = new BufferedReader(new FileReader(f2.getAbsolutePath()));

        String line1 = br1.readLine();
        String line2 = br2.readLine();

        // loop to copy lines
        while (line1 != null) {
            if (line1 != null) {
                pw.println(line1);
                line1 = br1.readLine();
            }
        }
        pw.println("\n");
        while (line2 != null) {
            if (line2 != null) {
                pw.println(line2);
                line2 = br2.readLine();
            }
        }
        pw.println("\n");
        pw.println("________________________________________________________________");
        pw.flush();

        // closing resources
        br1.close();
        br2.close();
        pw.close();
    }

    public static void convertTextfileToPDF(File file) {
        FileInputStream iStream = null;
        DataInputStream in = null;
        InputStreamReader is = null;
        BufferedReader br = null;
        try {
            Document pdfDoc = new Document();

            String text_file_name = file.getParent() + "/" + file.getName();
            text_file_name = text_file_name.substring(0, text_file_name.length() - 4);
            text_file_name = text_file_name + ".pdf";
            PdfWriter writer = PdfWriter.getInstance(pdfDoc, new FileOutputStream(text_file_name));
            pdfDoc.open();
            pdfDoc.setMarginMirroring(true);
            pdfDoc.setMargins(36, 72, 108, 180);
            pdfDoc.topMargin();
            Font normal_font = new Font();
            Font bold_font = new Font();
            bold_font.setStyle(Font.BOLD);
            bold_font.setSize(10);
            normal_font.setStyle(Font.NORMAL);
            normal_font.setSize(10);
            pdfDoc.add(new Paragraph("\n"));
            if (file.exists()) {
                iStream = new FileInputStream(file);
                in = new DataInputStream(iStream);
                is = new InputStreamReader(in);
                br = new BufferedReader(is);
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    Paragraph para = new Paragraph(strLine + "\n", normal_font);
                    para.setAlignment(Element.ALIGN_JUSTIFIED);
                    pdfDoc.add(para);
                }
            } else {
                System.out.println("file does not exist");
            }
            pdfDoc.close();
        } catch (Exception e) {
            System.out.println("FileUtility.covertEmailToPDF(): exception = " + e.getMessage());
        } finally {

            try {
                if (br != null) {
                    br.close();
                }
                if (is != null) {
                    is.close();
                }
                if (in != null) {
                    in.close();
                }
                if (iStream != null) {
                    iStream.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
