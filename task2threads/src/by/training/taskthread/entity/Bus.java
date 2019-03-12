package by.training.taskthread.entity;

import by.training.taskthread.repository.StopBusRepository;
import by.training.taskthread.specification.FindStopSpecificationById;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Bus implements Callable <Integer> {

    private int id;
    private int passenger;
    private Route route;
    private StopBusRepository repository;
    private Semaphore sem;

    public Bus(final int idBus, final int passengerBus,
               final Route routeBus, final Semaphore semaphore,
               final StopBusRepository stopBusRepository) {

        this.id = idBus;
        this.passenger = passengerBus;
        this.route = routeBus;
        this.sem = semaphore;
        this.repository = stopBusRepository;

    }

    @Override
    public Integer call() throws Exception {

        int k = 1;
        while (k < 5) {

            System.out.println("КРУГ №" + k);

            for (int i = 0; i < route.size(); i++) {

               sem.acquire();

               FindStopSpecificationById specification =
                       new FindStopSpecificationById(route.get(i));

               String name = repository.query(specification).get(0).getName();
               Stop stop = repository.query(specification).get(0);

               Random rnd = new Random();

               stop.setPassenger(rnd.nextInt(20));
               int outPassenger = rnd.nextInt(passenger + 1);
               this.passenger -= outPassenger;
               int inPassenger = rnd.nextInt(10);
               this.passenger += inPassenger;

               System.out.println("На остановку " + name
                       + " прибыл автобус №" + id + ".\nИз него вышло "
                       + outPassenger + " пассажиров и зашло " + inPassenger
                       + ".\nТеперь пассажиров в автобусе " + passenger
                       + ".\n");

               TimeUnit.MILLISECONDS.sleep(1000);
               sem.release();

               TimeUnit.MILLISECONDS.sleep(3000);
           }

           k++;
        }

        return this.passenger;
    }
}

