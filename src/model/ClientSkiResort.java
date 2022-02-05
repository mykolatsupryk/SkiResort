package model;

import exceptions.NameNullException;

import java.io.*;
import java.util.*;

public abstract class ClientSkiResort {

    private String name;
    private List<TracksAndMetrics> tracksAndMetrics = new ArrayList<>();
    private File resume;  //incapsulation


    public ClientSkiResort(String name) {
        this.name = name;
        this.tracksAndMetrics = createTrackAndMetrics();
        resume = new File("/home/mykolatsupryk/Java education/KindGeek/SkiResort/src/resume/" + name + "'s Resume.txt");
    }

    public List<TracksAndMetrics> createTrackAndMetrics() {

//        tracksAndMetrics.add(new TracksAndMetrics(Tracks.EAST_TRACK, new ArrayList<>()));
//        tracksAndMetrics.add(new TracksAndMetrics(Tracks.NORTH_TRACK, new ArrayList<>()));
//        tracksAndMetrics.add(new TracksAndMetrics(Tracks.SOUTH_TRACK, new ArrayList<>()));
//        tracksAndMetrics.add(new TracksAndMetrics(Tracks.WEST_TRACK, new ArrayList<>()));
        Arrays.stream(Tracks.values()).forEach(track -> {
            tracksAndMetrics.add(new TracksAndMetrics(track, new ArrayList<>()));
        });

        return tracksAndMetrics;
    }

    public  void setTimeToFinishRace(Tracks track, int timeToFinishRace){
//        for (TracksAndMetrics tracksAndMetric : tracksAndMetrics) {
//            if (tracksAndMetric.getTrack().equals(track)) {
//                tracksAndMetric.getMetrics().add(new Metrics(timeToFinishRace).calculateSkierAvgSpeed(track));
//            }
//        }
        tracksAndMetrics.stream().filter(tracksAndMetric -> tracksAndMetric.getTrack().equals(track)).forEach(tam -> {
            tam.getMetrics().add(new Metrics(timeToFinishRace).calculateSkierAvgSpeed(track));
        });
    }

    public void addToResumeFile (String s) throws IOException {
        FileWriter fileWriter = new FileWriter(resume, true);
        fileWriter.append(s + "\n");

        fileWriter.close();
    }

    public void clearResumeFile () throws IOException {
        FileWriter fileWriter = new FileWriter(resume, false);
        fileWriter.append("");
        fileWriter.close();
    }

    public void deleteResumeFile () {
        this.resume.delete();
    }

    public void readResumeFile () throws IOException {
        FileReader fileReader = new FileReader(resume);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String readLine;
        while (true) {
            readLine = bufferedReader.readLine();
            if (readLine != null) {
                System.out.println(readLine);
            } else {
                break;
            }
        }
    }


    public abstract void say();

    public String getName() throws NameNullException {
        if (this.name == null) {
            throw new NameNullException("This person's name is NULL!");
        } else {
            return this.name;
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TracksAndMetrics> getTracksAndMetrics() {
        return tracksAndMetrics;
    }

    public void setTracksAndMetrics(List<TracksAndMetrics> tracksAndMetrics) {
        this.tracksAndMetrics = tracksAndMetrics;
    }

    public File getResume() {
        return resume;
    }

    public void setResume(File resume) {
        this.resume = resume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientSkiResort that = (ClientSkiResort) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(tracksAndMetrics, that.tracksAndMetrics) &&
                Objects.equals(resume, that.resume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tracksAndMetrics, resume);
    }

    private StringBuilder printTracks () {
        StringBuilder stringBuilder = new StringBuilder();
//        for (TracksAndMetrics tracksAndM : tracksAndMetrics) {
//            stringBuilder.append("\n").append(tracksAndM.getTrack()).append(" = ");
//
//            List<Metrics> values = tracksAndM.getMetrics();
//            for (int i = 0; i < values.size(); i++) {
//                if (i != values.size() - 1) {
//                    stringBuilder.append(" ").append(values.get(i).getTime()).append(" min, ");
//                } else {
//                    stringBuilder.append(" ").append(values.get(i).getTime()).append(" min ;");
//                }
//            }
//        }
        tracksAndMetrics.stream().forEach(tracksAndMetric -> {
            stringBuilder.append("\n").append(tracksAndMetric.getTrack()).append(" = ");

            List<Metrics> values = tracksAndMetric.getMetrics();
            values.stream().filter(v -> values.indexOf(v) != (values.size() - 1)).forEach(v -> {
                stringBuilder.append(" ").append(v.getTime()).append(" min, ");
            });
            values.stream().filter(v -> values.indexOf(v) == (values.size() - 1)).forEach(v -> {
                stringBuilder.append(" ").append(v.getTime()).append(" min ;");
            });
        });

        return stringBuilder;
    }

    @Override
    public String toString() {
        return "\nClient: " + name +
                ", Tracks(min)" + printTracks();
    }
}
