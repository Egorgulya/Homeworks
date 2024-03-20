package org.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Station {

    public  String name;
    public  String line;
    public String date;
    public  Double depth ;
    public  boolean hasConnect = false;



    public Station(String name) {
        this.name = name;
    }
    public String toString(){
        return "Станция: " + name+ "\n"+
                "Линия: "+ line + "\n"+
                "Переходы: " + hasConnect+ " \n"+
                "Глубина: "+ depth + "\n"+
                "Основана в: "+date;

    }
}