package by.training.taskthread.main;

import by.training.taskthread.entity.Bus;
import by.training.taskthread.entity.Route;
import by.training.taskthread.entity.Stop;
import by.training.taskthread.parser.ParserData;
import by.training.taskthread.reader.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread());

        FileReader reader = new FileReader();
        List<String> stopList = new ArrayList<>();
        List<String> durationList = new ArrayList<>();
        String path1 = "data/stops.txt";
        String path2 = "data/route79duration.txt";
        try {
            stopList = reader.readData(path1);
            durationList = reader.readData(path2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ParserData parser = new ParserData();
        System.out.println(stopList);
        System.out.println(parser.parseArguments(durationList));

        AtomicLong i = 0;
        i.decrementAndGet();
/*

         CommonResourse res = new CommonResourse();
        ReentrantLock lock = new ReentrantLock();
        //ExecutorService pool = Executors.newCachedThreadPool ();
        Semaphore sem = new Semaphore(3 );
        Route route1 = new Route();
        Stop stop1 = new Stop(0, 10, "Stop 1");
        Stop stop2 = new Stop(1, 10, "Stop 2");
        Stop stop3 = new Stop(3, 10, "Stop 3");
        route1.add(stop1);
        route1.add(stop2);
        route1.add(stop3);

        Bus bus1 = new Bus(0, 20, route1, lock, res, sem);
        Bus bus2 = new Bus(1, 20, route1, lock, res, sem);
        Bus bus3 = new Bus(2, 20, route1, lock, res, sem);
        FutureTask<Integer> task1 = new FutureTask(bus1);
        FutureTask<Integer> task2 = new FutureTask(bus2);
        FutureTask<Integer> task3 = new FutureTask(bus3);
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);
        t1.start();
        //t2.start();
        t3.start();

        try {
            t2.sleep(6000);
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/



        System.out.println(Thread.currentThread());

    }
}
