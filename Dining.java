import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;

class DiningPhilosophers {

    private final ReentrantLock[] forks = new ReentrantLock[5];
    private final Semaphore eatingLimit = new Semaphore(4, true); // fair=true

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock(true); // fair lock
        }
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher + 1) % 5;

        // Only let 4 of the 5 philosophers compete for forks at a time
        eatingLimit.acquire();
        try {
            forks[left].lock();
            forks[right].lock();
            try {
                pickLeftFork.run();
                pickRightFork.run();
                eat.run();
                putLeftFork.run();
                putRightFork.run();
            } finally {
                forks[left].unlock();
                forks[right].unlock();
            }
        } finally {
            eatingLimit.release();
        }
    }
}