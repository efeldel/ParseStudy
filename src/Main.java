import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static String pageUrl = "https://www.krylatskoye.ru/content/ratings/2021/09/0928.html";

    public static void main(String[] args) throws IOException {
        List<String> cities = new ArrayList<String>();
        Document doc = Jsoup.connect(pageUrl).get();
        Element table = doc.select("table").first();
        assert table != null;
        Elements rows = table.select("tr");
        for (int i = 2, m = rows.size(); i < m; i++) {
            Element row = rows.get(i);
            Elements cols = row.select("td");
            cities.add(cols.get(1).text());
        }
        cities.stream().sorted().forEach(System.out::println);
    }
}
