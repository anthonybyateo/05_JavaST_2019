package by.training.taskthread.specification;

import by.training.taskthread.entity.Stop;

public class FindStopSpecificationById implements FindStopSpecification {

    private int id;

    public FindStopSpecificationById(final int idStop) {
        id = idStop;
    }

    @Override
    public boolean specified(final Stop stop) {
        return id == stop.getId();
    }
}
