package by.training.taskthread.entity;

public class Stop extends AbstractStop{
    private int id;
    private int passenger;
    private String name;

    public Stop(final int idStop, final int passengerStop,
                final String nameStop) {
        this.id = idStop;
        this.passenger = passengerStop;
        this.name = nameStop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
