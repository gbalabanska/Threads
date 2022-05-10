package track.pit;

import track.Car;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Pit {

    private boolean isFinishingTime = false;

    private final int nPitTeams;
    private final PitTeam[] teams;
    private final Queue<Car> cars;
    private int nPitStopsCount = 0;

    public Pit(int nPitTeams) {
        this.nPitTeams = nPitTeams;
        this.cars = new ArrayDeque<>();
        this.teams = new PitTeam[nPitTeams];
        initTeams();
    }

    private void initTeams() {
        for (int i = 0; i < nPitTeams; i++) {
            teams[i] = new PitTeam(i, this);
            teams[i].start();
        }
    }

    public synchronized void submitCar(Car car) {
        cars.add(car);
        this.notifyAll();
    }

    public synchronized Car getCar() {
        while (cars.isEmpty() && !isFinishingTime) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return cars.isEmpty() ? null : cars.poll();
    }

    public int getPitStopsCount() {
        return this.nPitStopsCount;
    }

    public List<PitTeam> getPitTeams() {
        return Arrays.asList(this.teams.clone());
    }

    public synchronized void finishRace() {
        isFinishingTime = true;
        this.notifyAll();
    }

    public Queue<Car> getCars() {
        return cars;
    }
}
