package data;
import
import java.sql.*;
import java.util.ArrayList;

import static java.lang.System.exit;

/**
 * Database set up
 *
 * @author Catherine Giovetti
 * @version 2021.12.04
 */
public class Database {
    public static Connection connection = null;
    private static String CONN_STRING = "jdbc:jtds:sqlserver://cisdbss.pcc.edu/IMDB";
    private static String USERNAME = "275student";
    private static String PASSWORD = "275student";
    private static String GET_ALL_GENRES_SQL = "SELECT DISTINCT genre FROM title_genre"
    private static String GET_ALL_TYPES_SQL = "SELECT DISTINCT titleType FROM title_basics";

    private static String FIND_SHOWS_SQL = "SELECT TOP 50 primaryTitle, startYear, averageRating, numVotes\n" +
            "FROM title_basics\n" +
            "JOIN title_ratings ON title_basics.tconst = title_ratings.tconst\n" +
            "JOIN title_genre ON title_basics.tconst = title_genre.tconst\n" +
            "WHERE numVotes > ?\n" +
            "AND titleType = ?\n" +
            "AND genre = ?\n" +
            "ORDER BY averageRating DESC;";

    public static void connect() {
        if(connection != null) {
            return;
        } else {
            try {
                connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                exit(-1);
            }
        }
    }
    public static ArrayList<Genre> getAllGenres() {
        connect();
        ArrayList<Genre>  genres = new ArrayList<Genre>();
        try {
            PreparedStatement stmt = connection.prepareStatement(GET_ALL_GENRES_SQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                genres.add(newGenre(rs.getString( "genre")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }
    public static ArrayList<ShowType> getAllShowTypes() {
        connect();
        ArrayList<ShowType> types = new ArrayList<ShowType>();
        try {
            PreparedStatement stmt = connection.prepareStatement(GET_ALL_TYPES_SQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                types.add(new ShowType(rs.getString("titleType")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }
    public static ArrayList<Shows> findShows(Integer minShows, String titleType, String genre) {
        connect();
        ArrayList<Show> shows = new ArrayList<Show>();
        try {
            PreparedStatement stmt = connection.prepareStatement(FIND_SHOWS_SQL);
            stmt.setInt(0, minShows);
            stmt.setString(1, titleType);
            stmt.setString(2,genre);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                shows.add(new Show(
                        //primaryTitle, startYear, averageRating, numVotes
                        rs.getString("primaryTitle"),
                        rs.getInt("startYear"),
                        rs.getFloat("averageRating"),
                        rs.getInt("numVotes")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shows;
    }

}
