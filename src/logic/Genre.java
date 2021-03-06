package logic;
import data.Database;
import java.util.ArrayList;

/**
 * class Genre that creates an array list to hold the genre names.
 * @author Catherine Giovetti
 * @version 2021.12.04
 */
public class Genre {
    private String name;

    public Genre(String n) {
        name = n;
    }

    public static ArrayList<Genre> getAllGenres(){
        return Database.getAllGenres();
    }

    public String getName() {
        return name;
    }
}
