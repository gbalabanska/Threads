package track;

import track.pit.Pit;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceTrack implements Track {

    private static final int DEFAULT_PITTEAMS_COUNT = 3;

    private final int nOfPitTeams;
    private final Pit pit;
    private final AtomicInteger carsCount; // total cars that have been sent to the queue
    private int numberOfFinishedCars = 0;
    private final List<Integer> finishedCarsIds;

    public RaceTrack() {
        this(DEFAULT_PITTEAMS_COUNT);
    }

    public RaceTrack(int nOfPitTeams) {
        this.nOfPitTeams = nOfPitTeams;
        pit = new Pit(nOfPitTeams);
        carsCount = new AtomicInteger();
        finishedCarsIds = new ArrayList<>();
    }

    @Override
    public void enterPit(Car car) {
        pit.submitCar(car);
        carsCount.incrementAndGet();
    }

    @Override
    public int getNumberOfFinishedCars() {
        return numberOfFinishedCars;
    }

    @Override
    public List<Integer> getFinishedCarsIds() {
        return this.finishedCarsIds;
    }

    @Override
    public Pit getPit() {
        return pit;
    }

    public int getnOfPitTeams() {
        return nOfPitTeams;
    }
}
