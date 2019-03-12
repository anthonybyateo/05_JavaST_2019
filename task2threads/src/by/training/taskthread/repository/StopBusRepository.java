package by.training.taskthread.repository;

import by.training.taskthread.entity.Stop;
import by.training.taskthread.specification.StopSpecification;

import java.util.concurrent.CopyOnWriteArrayList;

public class StopBusRepository implements Repository{
    private CopyOnWriteArrayList<Stop> stopList;

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
        stopList.add(stop);
    }

    @Override
    public CopyOnWriteArrayList<Stop> query(StopSpecification specification) {
        return null;
    }
}
