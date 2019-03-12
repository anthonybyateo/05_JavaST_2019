package by.training.taskthread.repository;

import by.training.taskthread.entity.Stop;
import by.training.taskthread.specification.StopSpecification;

import java.util.concurrent.CopyOnWriteArrayList;

public interface Repository {
    void addStop(Stop stop);
    void removeStop(Stop stop);
    void updateStop(Stop stop);

    CopyOnWriteArrayList query(StopSpecification specification);
}
