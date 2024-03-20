package org.example;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StationJSON {
    private String station_name;
    private String depth;

    public String toString(){
        return ("Глубина станции "+ station_name + ": "+ depth);
    }
}