package org.example;


import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;




public class Main {
    public static void main(String[] args) {

    }

    public static long findCountAircraftWithModelAirbus(Airport airport, String model) {
        //TODO Метод должен вернуть количество самолетов указанной модели.
        // подходят те самолеты, у которых name начинается со строки model
        return airport.getAllAircrafts()
                .stream()
                .map(Aircraft::getModel)
                .filter(aircraftModel -> aircraftModel.contains(model))
                .count();
    }

    public static Map<String, Integer> findMapCountParkedAircraftByTerminalName(Airport airport) {
        Map<String, Integer> aircraftByTerminal = airport.getTerminals()
                .stream()
                .collect(Collectors.toMap(Terminal::getName,terminal -> terminal.getParkedAircrafts().size()));

        //TODO Метод должен вернуть словарь с количеством припаркованных самолетов в каждом терминале.
        return aircraftByTerminal;
    }

    public static List<Flight> findFlightsLeavingInTheNextHours(Airport airport, int hours) {
        Instant now  = Instant.now();
        Instant inTwoHour = now.plus(hours, ChronoUnit.HOURS);

        return airport.getTerminals()
                .stream()
                .map(Terminal::getFlights)
                .flatMap(Collection::stream)
                .filter(flights -> flights.getType().equals(Flight.Type.DEPARTURE))
                .filter(flight -> flight.getDate().isAfter(now) && flight.getDate().isBefore(inTwoHour))
                .collect(Collectors.toList());

        //TODO Метод должен вернуть список отправляющихся рейсов в ближайшее количество часов.

    }

    public static Optional<Flight> findFirstFlightArriveToTerminal(Airport airport, String terminalName) {

        //TODO Найти ближайший прилет в указанный терминал.
        return airport.getTerminals().stream()
                .filter(terminal -> terminal.getName().equals(terminalName))
                .map(Terminal::getFlights)
                .flatMap(Collection::stream)
                .filter(flight -> flight.getType().equals(Flight.Type.ARRIVAL))
                .sorted(Comparator.comparing(Flight::getDate))
                .findFirst();
    }
}