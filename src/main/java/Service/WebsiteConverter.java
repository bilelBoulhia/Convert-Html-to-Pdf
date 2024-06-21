package Service;
import java.io.*;
import java.net.HttpURLConnection;
import utilities.IWEBSITE;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;

public class WebsiteConverter implements IWEBSITE {
    @Override
    public String fetchHtmlCode(String site) throws IOException {

        String codeSource = "";

        URL weburl = new URL(site);

        HttpURLConnection cnx = (HttpURLConnection) weburl.openConnection();

        cnx.setRequestMethod("GET");

        int reponse = cnx.getResponseCode();

        if (reponse == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(cnx.getInputStream()));
            String lines;
            while ((lines = in.readLine()) != null) {

                codeSource += lines;

            }

            in.close();
        } else {
            return "error";
        }

        return codeSource;
    }

    public String convertToHtml(String htmldata, String path) throws IOException {

        if (htmldata == null || path == null) {
            return null;
        }

        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String FilePath = path + File.separator + "html" + LocalDate.now() + ".html";


        BufferedWriter bfr = new BufferedWriter(new FileWriter(FilePath));

        bfr.write(htmldata);

        return FilePath;

    }
}
/*
*  public boolean convertToHtml(String htmldata ,String path) throws IOException {

        if(htmldata == null || path == null)
        {
            return false;
        }

        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String FilePath = path + File.separator + "data "+ LocalDate.now() +".html";


        BufferedWriter bfr = new BufferedWriter(new FileWriter( FilePath));

        bfr.write(htmldata);

        return true;
    }*/