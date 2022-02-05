package model;

import java.util.List;
import java.util.Objects;

public class TracksAndMetrics {

    private Tracks track;
    private List<Metrics> metrics;


    public TracksAndMetrics(Tracks track, List<Metrics> metrics) {
        this.track = track;
        this.metrics = metrics;
    }

    public Tracks getTrack() {
        return track;
    }

    public void setTrack(Tracks track) {
        this.track = track;
    }

    public List<Metrics> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Metrics> metrics) {
        this.metrics = metrics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TracksAndMetrics that = (TracksAndMetrics) o;
        return track == that.track &&
                Objects.equals(metrics, that.metrics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(track, metrics);
    }

    @Override
    public String toString() {
        return "TracksAndMetrics{" +
                "track=" + track +
                ", metrics=" + metrics +
                '}';
    }
}
