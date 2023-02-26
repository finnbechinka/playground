# Flights-in-Europe

### Zusammenfassung

You are a freelancer with the task to implement a flight booking system for the reliable airline „Oceanic Airline“. The system is very simple. Its only function is to search for the shortest (shortest time) route from one origin airport to a destination airport in Europe.

### Zielstellung

In this stage you will implement a simple flight search. Your task is to filter flights and to find the best connection for the customer.

### Szenario 1: Preparations I: Filter booked up flights.

In this step you implement the first method of the FlightService class. It should return all flights that are booked up.

You need to implement the getFullFlights method which returns all flights in the system that are fully booked and have no available seats. For reference you can look into the Flight.java and the Airport.java class.

When a flight from Dresden to Munich gets booked up.

Then the getFullFlights method should return a Stream with the flight from Dresden to Munich.

This should work for other flights as well. Please take care that the service should work with big data sets.

### Szenario 2: Preparations II: Filter flights by their destinations.

In this step you are supposed to implememt a method which filters all flights by a given destination.

You need to implement the getFlightsForDestination method. It should return all flights that are flying to the given destination.

When two flights - one from Frankfurt one from Zurich are flying to Dresden.

Your method should return those two flights.

This should work for other flights as well. Please take care that the service works with big data sets.

### Szenario 3: Prepatations III: Filter flights by their origins.

In this step you should implement a method which returns flights by their origins.

You are supposed to implement the getFlightsForOrigin method which returns all flights that are flying from a given origin.

When four flights are flying from Dresden to Frankfurt, Amsterdam, Munich and Zürich .

Then your method should return all these flights.

This should work for other flights as well. Please take care that the service works with big data sets.

### Szenario 4: Find the shortest connection

Customers of Oceanic Airlines are booking their flights over the Website. The final method to implement should find the connections between two airports that takes the smallest amount of time for the passenger

You need to implement the getShortestFlightByRoute method which returns the connection between two airports that takes the least amount of time.

Given is again a network of Airports that are connected by Flights.

A user searches for a Oceanic flight from Dresden to Barcelona. Since there is no direct connection between the airports, your method should find a route with multiple flights.

Your method should return the fastest connection: from Dresden via Frankfurt to Barcelona.

Since other customers are booking as well, the flight from Frankfurt to Barcelona gets booked up.

Your method should find the slightly longer connection via Munich.

When a customer searches for a connection that is not available, then your method should return an empty List.

Your method should work for other connections as well. Take care that Oceanic Airlines has a large route network - even in Europe. Try to implement the algorithm in a way that it takes the least amount of time.
