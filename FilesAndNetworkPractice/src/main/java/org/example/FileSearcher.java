package org.example;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileSearcher extends SimpleFileVisitor<Path>  {
    public  static List<String> searchedJsosn = new ArrayList<>();
    public static List<String> searchedCSV = new ArrayList<>();
    public static String json= ".json";
    public static String csv = ".csv";

    public static void printSearchedFilesNames(){
        System.out.println("JSONs: ");
        searchedJsosn.forEach(x -> System.out.println(x));
        System.out.println("CSVs: ");
        searchedCSV.forEach(x -> System.out.println(x));
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr){
        if (file.getFileName().toString().endsWith(json) ){
            searchedJsosn.add(file.toString());
        } else if (  file.getFileName().toString().endsWith(csv)){
            searchedCSV.add(file.toString());
        }
        return FileVisitResult.CONTINUE;
    }
}
