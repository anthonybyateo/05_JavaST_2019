package by.training.taskthread.entity;

import by.training.taskthread.main.CommonResourse;

import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Bus implements Callable <Integer> {

    private int id;
    private int passenger;
    private Route route;
    Semaphore sem;
    ReentrantLock locker;
    CommonResourse res;

    public Bus(final int idBus, final int passengerBus, final Route routeBus,
               ReentrantLock lock, CommonResourse ress, Semaphore semm) {
        this.id = idBus;
        this.passenger = passengerBus;
        this.route = routeBus;
        locker = lock;
        res = ress;
        sem = semm;
    }

    @Override
    public Integer call() throws Exception {
       // Stop stop = new Stop(0, 0, "0");



        try {

           for (int i = 0; i < route.size(); i++) {

               sem.acquire();

               //locker.lock();
               System.out.println(route.get(i).getName() + " Bus " + id);
               route.get(i).setPassenger(0);
                for (int j = 1; j < 5; j++) {
                    System.out.println(route.get(i).getPassenger());
                    route.get(i).setPassenger(j);
                    TimeUnit.MILLISECONDS.sleep(1000);
                }
               sem.release();
               TimeUnit.MILLISECONDS.sleep(10000);
               //locker.unlock();


            }
        } finally {


        }








        return 0;
    }
}

