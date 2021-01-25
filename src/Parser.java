import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Parser {
    Document doc;

    {
        try {
            doc = Jsoup.connect("https://hh.ru/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
