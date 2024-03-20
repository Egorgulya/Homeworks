package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class StationsByLines {
    public static Map<String,List<String>> lineNames = new TreeMap<>();
    public static void getStationsByLines() throws IOException {

        for (Station a : Main.total){
            if(!lineNames.containsKey(a.getLine())) {
                lineNames.put(a.getLine(), new ArrayList<>());
                lineNames.get(a.getLine()).add(a.getName());
            } else {
                lineNames.get(a.getLine()).add(a.getName());
            }
        }
        File file1 = new File("data/stationsByLines.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(file1,lineNames);
    }
}