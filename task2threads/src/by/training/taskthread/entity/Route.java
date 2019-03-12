package by.training.taskthread.entity;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Route {
    private List<Integer> idList;

    public Route() {
        this.idList = new CopyOnWriteArrayList<>();
    }

    public void add(final int id) {
        idList.add(id);
    }

    public void addAll(final List<Integer> id) {
        idList.addAll(id);
    }

    public Integer get(final int index) {
        return idList.get(index);
    }

    public void set(final int index, final int id ) {
        idList.set(index, id);
    }

    public int size() {
        return idList.size();
    }

}
