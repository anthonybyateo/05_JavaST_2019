package by.training.taskthread.creator;

import by.training.taskthread.entity.AbstractStop;
import by.training.taskthread.entity.Stop;

import java.util.List;

public class
StopBusFactory implements StopFactory {
    @Override
    public AbstractStop createStop(final int id, final String name) {
        return new Stop(id, 0, name);
    }

    @Override
    public List<AbstractStop> createStopList(final List<Integer> id,
                                             final List<String> name) {
        return null;
    }
}
