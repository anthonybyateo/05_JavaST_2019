package by.training.taskthread.creator;

import by.training.taskthread.entity.AbstractStop;

import java.util.List;

public class Creator {

    public AbstractStop createStop(final StopFactory factory, final int id,
                                   final String name) {

        return factory.createStop(id, name);
    }

    public List<AbstractStop> createStopList(final StopFactory factory,
                                             final List<Integer> id,
                                             final List<String> name) {

        return factory.createStopList(id, name);
    }
}
