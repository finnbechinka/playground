package de.entwicklerheld.flightsearch;

import java.awt.Point;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sound.midi.SysexMessage;


public class FlightService implements IFlightService {
    private Collection<Flight> availableFlights;

    public static FlightService of(Collection<Flight> availableFlights) {
        return new FlightService(availableFlights);
    }

    private FlightService(Collection<Flight> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public Stream<Flight> getFullFlights() {
        return availableFlights
                            .stream()
                            .filter(x -> x.getAvailableSeats() == 0);
    }

    public Stream<Flight> getFlightsForDestination(Airport destination) {
        return availableFlights
                            .stream()
                            .filter(x -> x.getDestination() == destination);
    }

    public Stream<Flight> getFlightsForOrigin(Airport origin) {
        return availableFlights
                            .stream()
                            .filter(x -> x.getOrigin() == origin);
    }

    public List<Flight> getShortestFlightByRoute(Airport origin, Airport destination) {
        List<Flight> shortestRoute = new ArrayList<Flight>();
        List<Flight> possibleFlights = availableFlights
                                                .stream()
                                                .filter(x -> x.getAvailableSeats() != 0)
                                                .collect(Collectors.toList());

        // Create a list of all airports that are available with the given flights
        List<Airport> airports = new ArrayList<>();
        airports.add(origin);
        for(Flight flight : possibleFlights){
            if(!airports.contains(flight.getOrigin()))
                airports.add(flight.getOrigin());
                
            if(!airports.contains(flight.getDestination()))
                airports.add(flight.getDestination());
        }

        // Create a weighted adjacency matrix with the distance between the airports
        int[][] airportDistance = new int[airports.size()][airports.size()];
        for(Airport a : airports){
            for(Airport b : airports){
                Flight tmp = null;
                for(Flight flight : possibleFlights){
                    if(flight.getOrigin().equals(a) && flight.getDestination().equals(b)){
                        tmp = flight;
                        break;
                    }
                }
                if(tmp != null)
                airportDistance[airports.indexOf(a)][airports.indexOf(b)] = Integer.parseInt(Long.toString(tmp.getDuration().getSeconds()));
            }
        }
        
        Integer[][] dijkstrasResults = dijkstrasSPA(airportDistance);

        int indexOfDest = 0;
        for(Airport curr : airports){
            if(curr.equals(destination)){
                indexOfDest = airports.indexOf(curr);
            }
        }

        // Backtrace the results of dijkstras and convert them into flights
        List<Integer> hopsID = new ArrayList<>();
        hopsID.add(0, indexOfDest);
        int prev = indexOfDest;
        boolean done = false;
        while(!done){
            int smallest = Integer.MAX_VALUE;
            int smallestIndex = 0;
            for(int i = 0; i < dijkstrasResults.length; i++){
                if(dijkstrasResults[i][0] == dijkstrasResults[prev][2] && dijkstrasResults[i][1] < smallest){
                    smallestIndex = i;
                    smallest = dijkstrasResults[i][1];
                }
            }
            hopsID.add(0, smallestIndex);
            prev = smallestIndex;
            if(prev == 0)
                done = true;
        }

        List<Airport> hops = new ArrayList<>();
        for(Integer x : hopsID){
            hops.add(airports.get(x));
        }

        for(int i = 0; i < hops.size() - 1; i ++){
            for(Flight flight : possibleFlights){
                if(flight.getOrigin().equals(hops.get(i)) && flight.getDestination().equals(hops.get(i+1))){
                    shortestRoute.add(flight);
                }   
            }
            if(shortestRoute.size() == hops.size()){
                break;
            }
        }

        return shortestRoute;
    }

    public Integer[][] dijkstrasSPA(int[][] weightedGraph){
        List<Integer> visited = new ArrayList<Integer>();
        List<Integer> queue = new ArrayList<Integer>();
        Integer[][] results = new Integer[weightedGraph.length][3];

        for(int i = 0; i < weightedGraph.length; i++){
            results[i][0] = i;

            if(i == 0){
            results[i][1] = 0;
            }
            else
            results[i][1] = Integer.MAX_VALUE;

            results[i][2] = null;
            queue.add(i);
        }

        while(visited.size() < queue.size()){
            // Look for node with shortest distance to source (the firsttime this is source)
            int smallest = Integer.MAX_VALUE;
            int smallestIndex = -1;
            for(int i = 0; i < results.length; i++){
                if(results[i][1] < smallest && !visited.contains(i)){
                    smallest = results[i][1];
                    smallestIndex = i;
                }else if(queue.size() - 1 == visited.size() && !visited.contains(i)){
                    smallest = results[i][1];
                    smallestIndex = i;
                }
            }

            // Check neighbors and calculate their distance to source,
            // Add the current node as their previous node
            for(int i = 0; i < weightedGraph.length; i++){
                if(!visited.contains(i) && weightedGraph[smallestIndex][i] != 0){
                    int dist = smallest + weightedGraph[smallestIndex][i];
                    if(dist < results[i][1]){
                        results[i][1] = dist;
                        results[i][2] = smallestIndex;
                    }
                }
            }
            visited.add(smallestIndex);
        }
        return results;
    }
}
