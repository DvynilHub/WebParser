import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

public class Parser {
    public static void main(String[] args) {


        List<Article> articleList = new ArrayList<Article>();

        {
            try {
                Document doc = Jsoup.connect("https://www.irgups.ru/eis/rasp/index.php?action=student&pid=2446&t=1611592703").get();
                Elements h1Element = doc.getElementsByAttributeValue("class", "r_grp");
                h1Element.forEach(new Consumer<Element>() {
                    @Override
                    public void accept(Element h1Element) {
                        Element aElement = h1Element.child(0);
                        String url = aElement.attr("href");
                        String title = aElement.child(0).text();
                        articleList.add(new Article(url, title));
                    }
                });
                articleList.forEach(System.out::println);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Article{
    private String url;
    private String name;

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Article(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Article{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}