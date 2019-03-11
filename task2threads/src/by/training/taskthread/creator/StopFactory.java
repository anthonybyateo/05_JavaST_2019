package by.training.taskthread.creator;

import by.training.taskthread.entity.AbstractStop;

import java.util.List;

public interface StopFactory {

    AbstractStop createStop(int id, String name);

    List<AbstractStop> createStopList(List<Integer> id, List<String> name);
}
