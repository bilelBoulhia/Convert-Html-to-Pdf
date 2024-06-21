package Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

// Import statement for IronPDF for Java


import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;
import utilities.IPDF;


import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Random;


public class PdfConverter implements IPDF {
    @Override
    public String ConvertHtmlToPdf(String html , String SelectedPath ) throws IOException {

        if(html == null || SelectedPath == null)
        {
            return "error";
        }




        File directory = new File(SelectedPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }




        String FilePath = SelectedPath+ File.separator + "output"+ new Random().nextInt()  +".pdf";


        try {

            ITextRenderer renderer = new ITextRenderer();


            String content = FileUtils.readFileToString(Paths.get(html).toFile(), StandardCharsets.UTF_8);




            String htmlToXhtml = htmlToXhtml(content);
            renderer.setDocumentFromString(htmlToXhtml);


            renderer.layout();
            FileOutputStream fos = new FileOutputStream(FilePath);
            renderer.createPDF(fos);
            fos.close();

            System.out.println("PDF generated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "added succefully" +  FilePath;
    }

    @Override
    public String htmlToXhtml(String html) {
        Document document = Jsoup.parse(html);


        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);



        String cleanedHtml = document.html();

          cleanedHtml = cleanedHtml.replaceAll("<script.*?</script>", "");

        // Replace problematic characters with entities
        cleanedHtml = cleanedHtml.replaceAll("&(?!amp;|lt;|gt;|quot;|apos;)", "&amp;");

        return cleanedHtml;
    }
}
/*
            // Perform replacements
            Map<String, String> valueMap = new HashMap<>();
            valueMap.put("employeeId", "20240200001");
            valueMap.put("employeeName", "Harish Jay Raj");
            valueMap.put("startDate", "25-03-2024");

            Set<Entry<String, String>> entrySet = valueMap.entrySet();
            for (Entry<String, String> es : entrySet) {
                content = content.replace("@{" + es.getKey() + "}", es.getValue());
            }
             content = escapeAmpersands(content);
*/