package lesson_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    CyclicBarrier cyclicBarrier;
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private static AtomicInteger ai;

    static {
        ai = new AtomicInteger(0);
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier barrier) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        cyclicBarrier = barrier;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        if (ai.incrementAndGet() == 1) {
            System.out.println(name + " WIN !!!!!");
        }

        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
