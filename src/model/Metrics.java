package model;


import java.util.Objects;

public class Metrics implements Skiable{

    private Integer time;
    private Integer avgSpeed;


    public Metrics(Integer time) {
        this.time = time;

    }

    @Override
    public Metrics calculateSkierAvgSpeed(Tracks track) {
        this.avgSpeed = (int) ((track.getLenghtTrack() / this.time) / 16.667);
        return this;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(Integer avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Metrics metrics = (Metrics) o;
        return Objects.equals(time, metrics.time) &&
                Objects.equals(avgSpeed, metrics.avgSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, avgSpeed);
    }

    @Override
    public String toString() {
        return "Metrics{" +
                "time=" + time +
                ", avgSpeed=" + avgSpeed +
                '}';
    }
}
