package by.training.taskthread.entity;

import java.util.concurrent.CopyOnWriteArrayList;

public class Route {
    private CopyOnWriteArrayList<Stop> stopList;

    public Route() {
        this.stopList = new CopyOnWriteArrayList<>();
    }

    public void add(final Stop stop ) {
        stopList.add(stop);
    }

    public Stop get(final int index) {
        return stopList.get(index);
    }

    public void set(final int index, final Stop stop ) {
        stopList.set(index, stop);
    }

    public int size() {
        return stopList.size();
    }

}
