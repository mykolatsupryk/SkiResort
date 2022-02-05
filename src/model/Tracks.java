package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Tracks {


    EAST_TRACK(8000), NORTH_TRACK(10000), SOUTH_TRACK(12500),  WEST_TRACK(15000);

    private int lenghtTrack;

    Tracks(int lenghtTrack) {
        this.lenghtTrack = lenghtTrack;
    }

    public int getLenghtTrack() {
        return lenghtTrack;
    }

}
