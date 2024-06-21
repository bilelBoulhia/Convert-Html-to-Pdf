package org.example;

import Service.PdfConverter;
import Service.WebsiteConverter;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;



import java.io.IOException;





@Command(name = "Convert", mixinStandardHelpOptions = true,
        description = "Convert html to the selected output format ")
public class ConvertCommand implements  Runnable {

    private final PdfConverter _ipf;
    private final WebsiteConverter _iwebsite;

    @Parameters(index = "0",paramLabel = "OutPutpath", defaultValue = "C:\\",
            description = "the output format of a selected file")

    String OutPutPath;
    @Parameters(index = "1", paramLabel = "Website",
            description = "intented website to convert")

    String Website;


    public ConvertCommand(PdfConverter IPF, WebsiteConverter Website){
        _ipf = IPF;
        _iwebsite = Website;
    }
    @Override
    public void run() {


        try {

            String Result = _ipf.ConvertHtmlToPdf(_iwebsite.fetchHtmlCode(Website),OutPutPath);

            System.out.printf(Result);

        } catch (IOException e) {
            System.out.printf("error : " + e);
        }


    }
    public static void main(String[] args) throws IOException {

        PdfConverter pdfConverter = new PdfConverter();
        WebsiteConverter websiteConverter = new WebsiteConverter();


        ConvertCommand convertCommand = new ConvertCommand(pdfConverter, websiteConverter);
        int exitCode = new CommandLine(convertCommand).execute(args);
        System.exit(exitCode);
}



}