package track;

public class Main {

    public static int CARS_COUNT = 3;
    public static int PITSTOPS_PER_CAR = 2;
    public static RaceTrack track = new RaceTrack();

    public static void main(String[] args) throws InterruptedException {

        Car[] carsArr = new Car[CARS_COUNT];
        for (int i = 0; i < CARS_COUNT; i++) {
            carsArr[i] = new Car(i, PITSTOPS_PER_CAR, track);
            carsArr[i].start();
        }

        for (int i = 0; i < CARS_COUNT; i++) {
            carsArr[i].join();
        }

        track.getPit().finishRace();
    }

}
