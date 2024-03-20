package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class WebParser {
    public Map<String, String> Lines = new HashMap<>();
    public List<String> linesNames;
    public List<String> linesCodes;
    public static Document doc;



    public void webParisng(String s) throws IOException {

        doc = Jsoup.connect(s).get();                                               //создаем мапу из ключ-код станции, занчение - имя станции
        Elements lines = doc.select("span.t-metrostation-list-header");
        linesNames = lines.eachText();
        linesCodes = lines.eachAttr("data-line");
        for (int i = 0; i < linesNames.size(); i++) {
            Lines.put(linesCodes.get(i), linesNames.get(i));
        }
        //        Lines.forEach((a, h) -> System.out.println("Key " + a + " value " + h)); // проверочная строка.

        Elements stations = doc.select("span.name");
        for (int i = 0; i < stations.size(); i++) {
            if (Lines.containsKey(stations
                    .get(i)
                    .parents().parents().parents()
                    .attr("data-depend-set")
                    .replace("lines-", ""))) {

                Main.total.add(new Station(stations.get(i).text()));
                Main.total.get(i).setLine(Lines.get(stations
                        .get(i)
                        .parents().parents().parents()
                        .attr("data-depend-set")
                        .replace("lines-", "")));
            }
            if (stations.get(i).parent().children().hasAttr("title")){
                Main.total.get(i).setHasConnect(true);
            }
        }
    }
}