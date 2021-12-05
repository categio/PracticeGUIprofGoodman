package logic;
import data.Database;
import java.util.ArrayList;

/**
 * Collects Data for Show Types into an array list.
 * @author Catherine Giovetti
 * @version 2021.12.04
 */
public class ShowType {
    private String name;

    public ShowType(String n) {
        name = n;
    }

    public static ArrayList<ShowType> getAllShowTypes(){
        return Database.getAllShowTypes();
    }

    public String getName() {
        return name;
    }
}
