package by.training.taskthread.main;

import by.training.taskthread.creator.Creator;
import by.training.taskthread.creator.StopBusFactory;
import by.training.taskthread.entity.AbstractStop;
import by.training.taskthread.entity.Bus;
import by.training.taskthread.entity.Route;
import by.training.taskthread.entity.Stop;
import by.training.taskthread.parser.ParserData;
import by.training.taskthread.reader.FileReader;
import by.training.taskthread.repository.Repository;
import by.training.taskthread.repository.StopBusRepository;
import by.training.taskthread.specification.FindStopSpecificationById;
import by.training.taskthread.specification.FindStopSpecificationByIdList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread());

        FileReader reader = new FileReader();
        List<String> stopNameList = new ArrayList<>();
        List<String> durationList = new ArrayList<>();
        String path1 = "data/stops.txt";
        String path2 = "data/route79duration.txt";
        try {
            stopNameList = reader.readData(path1);
            durationList = reader.readData(path2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ParserData parser = new ParserData();

        Route route = new Route();
        List<Integer> idStop = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            route.add(i);
            idStop.add(i);
        }

        Creator creator = new Creator();
        StopBusFactory factory = new StopBusFactory();
        List<AbstractStop> stopList = new ArrayList<>();
        stopList.addAll(creator.createStopList(factory, idStop, stopNameList));

        StopBusRepository repository = StopBusRepository.getInstance();

        for (AbstractStop abstractStop : stopList) {

            repository.addStop((Stop) abstractStop);
        }

        Semaphore semaphore = new Semaphore(2 );
        ExecutorService pool = Executors.newScheduledThreadPool(3);


        for (int i = 0; i < 3; i++) {
            Bus bus = new Bus(i, 0, route, semaphore, repository);

            Future<Integer> result = ((ScheduledExecutorService) pool)
                    .schedule(bus, 5*i, TimeUnit.SECONDS);
        }

        pool.shutdown();
        System.out.println(Thread.currentThread());

    }
}
