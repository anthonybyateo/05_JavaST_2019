package by.training.taskthread.specification;

import by.training.taskthread.entity.Stop;

public interface FindStopSpecification extends StopSpecification {
    boolean specified(Stop stop);
}
