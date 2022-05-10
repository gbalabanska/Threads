package track;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Car extends Thread {

    private static final Random RANDOM = new Random();
    private static final int BOUND = 1000;

    public final Semaphore semaphore;
    private final int id;
    private final int nPitStops;
    private final RaceTrack track;

    public Car(int id, int nPitStops, RaceTrack track) {
        this.id = id;
        this.nPitStops = nPitStops;
        this.track = track;
        semaphore = new Semaphore(0);
    }

    @Override
    public void run() {
        int currentStop = 0;
        while (nPitStops > currentStop) {
            try {
                System.out.println("Started driving car ID=" + id);
                Thread.sleep(RANDOM.nextInt(BOUND));
                System.out.println("Ended driving car ID=" + id);
            } catch (InterruptedException e) {
                System.err.print("Unexpected exception was thrown: " + e.getMessage());
                e.printStackTrace();
            }
            track.enterPit(this);
            System.out.println("Entered pit car ID=" + id);
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Exited pit car ID=" + id);
            currentStop++;
        }
        System.out.println("Car with ID=" + id + " finished.");
        track.getFinishedCarsIds().add(this.id);
    }

    public int getCarId() {
        return this.id;
    }

    public int getNPitStops() {
        return this.nPitStops;
    }

    public Track getTrack() {
        return this.track;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }
}
