package org.example;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({ "name", "date"})
public class StationCSV {
    public String name;
    public String date;


    public String toString(){
        return "Станция "+ name + " основана в "+ date;
    }
}
