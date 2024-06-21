package utilities;



import java.io.IOException;

public interface IPDF {
    public String ConvertHtmlToPdf(String Html , String path ) throws IOException;

    public String htmlToXhtml(String html);
}
