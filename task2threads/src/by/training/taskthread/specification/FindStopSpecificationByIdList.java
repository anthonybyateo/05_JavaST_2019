package by.training.taskthread.specification;

import by.training.taskthread.entity.Stop;

import java.util.List;

public class FindStopSpecificationByIdList implements FindStopSpecification {

    private List<Integer> idList;

    public FindStopSpecificationByIdList(List<Integer> id) {
        this.idList = id;
    }

    @Override
    public boolean specified(final Stop stop) {

        for (Integer id : idList) {
            if (id == stop.getId()) {
                return true;
            }
        }
        return false;
    }
}
