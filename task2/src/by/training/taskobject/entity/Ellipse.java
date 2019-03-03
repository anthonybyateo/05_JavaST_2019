package by.training.taskobject.entity;

import by.training.taskobject.observer.Observable;
import by.training.taskobject.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Ellipse extends Shape implements Observable {

    private int id;
    private String name;
    private Point2D point1;
    private Point2D point2;

    private List<Observer> observerList;

    public Ellipse(final int idEllipse, final String nameEllipse,
                   final Point2D point1Ellipse, final Point2D point2Ellipse) {
        this.id = idEllipse;
        this.name = nameEllipse;
        this.point1 = point1Ellipse;
        this.point2 = point2Ellipse;
        observerList = new ArrayList<>();
    }

    public Ellipse(final Point2D point1Ellipse, final Point2D point2Ellipse) {
        this.id = 0;
        this.name = new String("Ellipse");
        this.point1 = point1Ellipse;
        this.point2 = point2Ellipse;
        observerList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(final int idEllipse) {
        id = idEllipse;
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public void setName(final String nameEllipse) {
        this.name = nameEllipse;
        notifyObservers();
    }

    public Point2D getPoint1() {
        return point1;
    }

    public void setPoint1(final Point2D point1Ellipse) {
        this.point1 = point1Ellipse;
        notifyObservers();
    }

    public Point2D getPoint2() {
        return point2;
    }

    public void setPoint2(final Point2D point2Ellipse) {
        this.point2 = point2Ellipse;
        notifyObservers();
    }

    public Observer getObserverList(final int index) {
        return observerList.get(index);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return (int) (prime * id
                + ((name == null) ? 0 : name.hashCode())
                + ((point1 == null) ? 0 : point1.hashCode())
                + ((point2 == null) ? 0 : point2.hashCode()));
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Ellipse ellipse = (Ellipse) obj;

        if (this.hashCode() != ellipse.hashCode()) {
            return false;
        }

        return (id == ellipse.id
                && name == ellipse.name
                || (name != null && name.equals(ellipse.name)
                && point1 == ellipse.point1
                || (point1 != null && point1.equals(ellipse.point1)))
                && point2 == ellipse.point2
                || (point2 != null && point2.equals(ellipse.point2)));
    }


    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        result.append("id: " + id);
        result.append(" name: " + name);
        result.append(" point1: " + point1);
        result.append(" point2: " + point2);

        return result.toString();
    }

    @Override
    public void addObserver(final Observer ob) {

        observerList.add(ob);

    }

    @Override
    public void removeObserver(final Observer ob) {

        observerList.remove(ob);
    }

    @Override
    public void notifyObservers() {
        for (Observer ob : observerList) {
            ob.update(this);
        }
    }
}