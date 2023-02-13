import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;


public class Main {

    private static final String PATH_FOR_IMG = "C:\\Users\\Roman\\IdeaProjects\\html\\src\\image";

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://lenta.ru").get();

        for (Element element : doc.select("img")){

            String imagine = element.absUrl("src");
            String[] fragments = imagine.split("\\/");
            String fileName = fragments[fragments.length - 1].replace(":" , "").replace("?", "");

            try {
                URL url = new URL(imagine);
                InputStream in = url.openStream();
                OutputStream out = new BufferedOutputStream(new FileOutputStream(PATH_FOR_IMG + fileName));
                for (int b; (b = in.read()) != -1; ) {
                    out.write(b);
                }
                out.close();
                in.close();
            }
            catch (Exception exception) {
                exception.printStackTrace();

            }

        }





    }



}
