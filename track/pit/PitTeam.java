package track.pit;

import track.Car;

import java.util.Random;

public class PitTeam extends Thread {

    private static final Random RANDOM = new Random();
    private static final int BOUND = 200;
    private final int id;
    private final Pit pit;
    private int repairedCars = 0;
    private int stoppedCars = 0;

    public PitTeam(int id, Pit pitStop) {
        this.id = id;
        this.pit = pitStop;
    }

    @Override
    public void run() {
        repairCar();
    }

    private void repairCar() {
        Car car = null;
        while ((car = pit.getCar()) != null) {
            stoppedCars++;
            try {
                Thread.sleep(RANDOM.nextInt(BOUND));
                repairedCars++;
                car.getSemaphore().release();
            } catch (InterruptedException e) {
                System.err.print("Unexpected exception was thrown: " + e.getMessage());
                e.printStackTrace();
            }
        }

        System.out.println(String.format("Team %d repaired %s cars.", id, repairedCars));
    }

    public int getPitStoppedCars() { //number of cars stopped at this pit team
        return this.stoppedCars;
    }

}
