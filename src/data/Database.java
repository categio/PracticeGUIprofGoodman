package data;
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
}
