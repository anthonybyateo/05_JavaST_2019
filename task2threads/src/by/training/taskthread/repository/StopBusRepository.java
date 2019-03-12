package by.training.taskthread.repository;

import by.training.taskthread.entity.Stop;
import by.training.taskthread.specification.FindStopSpecification;
import by.training.taskthread.specification.StopSpecification;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class StopBusRepository implements Repository{

    private CopyOnWriteArrayList<Stop> stopList = new CopyOnWriteArrayList<>();

    private static StopBusRepository instance = null;
    private static ReentrantLock lock = new ReentrantLock();

    private StopBusRepository() { }

    public static StopBusRepository getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new StopBusRepository();
            }
        } finally {
            lock.unlock();
        }
        return instance;
    }

    @Override
    public void addStop(Stop stop) {
        stopList.add(stop);
    }

    @Override
    public void removeStop(Stop stop) {
        stopList.remove(stop);
    }

    @Override
    public void updateStop(Stop stop) {
        stopList.set(stop.getId(), stop);
    }

    @Override
    public CopyOnWriteArrayList<Stop> query(StopSpecification specification) {

        CopyOnWriteArrayList<Stop> queryStopList = new CopyOnWriteArrayList<>();

        if (specification instanceof FindStopSpecification) {

            for (Stop stop : stopList) {
                if (((FindStopSpecification) specification)
                        .specified(stop)) {
                    queryStopList.add(stop);
                }
            }
        }

        return queryStopList;
    }
}
