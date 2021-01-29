# avios-rest-service

A REST API web service that calculates AVIOS points and their associated price discounts for different flights. Built with Java 11 and Gradle.

A CSV database of value-per-avios for different flight routes can be found under `src/main/resources`. Build the project with `gradlew build` and run it with `gradlew bootRun`. The local server is on localhost:8080, so try:

```
http://localhost:8080/priceOptions
```

And also try (for example):

```
http://localhost:8080/priceOptions?DepartureAirportCode=LHR&ArrivalAirportCode=JFK&Price=100.0
```

