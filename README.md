# Multithreaded Programming

## Race Track 🏎️ 🚦 ⛽

The objective is to simulate a race track with cars. The track consists of a `Pit`, where there are a certain number of `PitTeam`s - teams of mechanics. Each team can service any of the cars. The cars on the track drive for a certain time until they finish the race or need servicing and enter the pit. If there is a free team, it services the car; otherwise, the car waits for one to become available.

## Task

**1. Create the `RaceTrack` class**

The class should have a public constructor that takes an integer (the number of teams in the pit) and implements the `Track` interface.

**2. Create the `Car` class, which is a thread, and implements the following structure:**

```java
package bg.sofia.uni.fmi.mjt.race.track;

public class Car implements Runnable {

    public Car(int id, int nPitStops, Track track) {
        throw new UnsupportedOperationException("Method not yet implemented");
    }
    
    @Override
    public void run() {
         throw new UnsupportedOperationException("Method not yet implemented");
    }

    public int getCarId() {
         throw new UnsupportedOperationException("Method not yet implemented");
    }

    public int getNPitStops() {
         throw new UnsupportedOperationException("Method not yet implemented");
    }

    public Track getTrack() {
         throw new UnsupportedOperationException("Method not yet implemented");
    }

}
```
When started, the car begins to make laps around the track. This takes some time, which we can model with a pause in the thread - the car pauses for a random interval from 0 to 1 second, after which it enters the pit. Upon creation, the car receives as a parameter the required number of pit stops needed for it to successfully complete the race.

**3. Create the `Pit` class and implement the following structure:**

```java
package bg.sofia.uni.fmi.mjt.race.track.pit;

import bg.sofia.uni.fmi.mjt.race.track.Car;

public class Pit {
    
    public Pit(int nPitTeams) {
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    public void submitCar(Car car) {
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    public Car getCar() {
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    public int getPitStopsCount() {
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    public List<PitTeam> getPitTeams() {
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    public void finishRace() {
        throw new UnsupportedOperationException("Method not yet implemented");
    }

}
```

**4. Create a class PitTeam that is a thread and services the cars in the pit.**
