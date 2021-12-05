package logic;
import data.Database;
import java.util.ArrayList;

/**
 * Class Show that creates an array list that holds the data for shows.
 * @author Catherine Giovetti
 * @version 2021.12.04
 */
public class Show {
    private String primaryTitle;
    private Integer startYear;
    private Float averageRating;
    private Integer numVotes;

    public Show(String pt, Integer sy, Float ar, Integer nv) {
        primaryTitle = pt;
        startYear = sy;
        averageRating = ar;
        numVotes = nv;
    }

    public static ArrayList<Show> findShows(Integer minShows, String titleType, String genre) {
        return Database.findShows(minShows, titleType, genre);
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public Float getAverageRating() {
        return averageRating;
    }

    public Integer getNumVotes() {
        return numVotes;
    }
}
