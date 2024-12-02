package game;

import java.sql.*;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;


public class DbConnect {

    private static Connection connection = null;
    private static Statement statement = null;

    // Method to establish the database connection
    public static void dbConnect() throws SQLException {
        String dbUrl = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD"; // Oracle DB URL
        String username = "COMP228_F24_soh_57"; // Provided username
        String password = "password"; // Provided password
        connection = DriverManager.getConnection(dbUrl, username, password);
        System.out.println("Database connected");
        statement = connection.createStatement();
    }

    // Method to disconnect from the database
    public static void dbDisconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Database closed");
        }
    }

    // Drop table method
    public static void dropTable(String tableName) throws SQLException {
        dbConnect();

        String sql = "DROP TABLE " + tableName;
        statement.executeUpdate(sql);
        System.out.println("Table " + tableName + " is dropped!");

        if (statement != null) {
            statement.close();
        }
        dbDisconnect();
    }

    // Create AKASH_SUKUMARAN_GAME table
    public static void createGameTable() throws SQLException {
        dbConnect();

        String sql = "CREATE TABLE AKASH_SUKUMARAN_GAME (game_id INT PRIMARY KEY, game_title VARCHAR(100))";
        statement.executeUpdate(sql);
        System.out.println("AKASH_SUKUMARAN_GAME Table created");

        if (statement != null) {
            statement.close();
        }
        dbDisconnect();
    }

    // Insert Game data into AKASH_SUKUMARAN_GAME table
    public static void insertGameData(game.Game game) throws SQLException {
        dbConnect();

        String sql = "INSERT INTO AKASH_SUKUMARAN_GAME VALUES(" + game.getGame_id() + ",'" + game.getGame_title() + "')";
        System.out.println("Inserting into AKASH_SUKUMARAN_GAME table: " + sql);

        statement.executeUpdate(sql);
        System.out.println("One row inserted");

        if (statement != null) {
            statement.close();
        }
        dbDisconnect();
    }

    // Create AKASH_SUKUMARAN_PLAYER table
    public static void createPlayerTable() throws SQLException {
        dbConnect();

        String sql = "CREATE TABLE AKASH_SUKUMARAN_PLAYER (player_id INT PRIMARY KEY, first_name VARCHAR(100), last_name VARCHAR(100), address VARCHAR(100), postal_code VARCHAR(100), province VARCHAR(100), phone_number VARCHAR(100))";
        statement.executeUpdate(sql);
        System.out.println("AKASH_SUKUMARAN_PLAYER Table created");

        if (statement != null) {
            statement.close();
        }
        dbDisconnect();
    }

    // Insert Player data into AKASH_SUKUMARAN_PLAYER table
    public static void insertPlayerData(game.Player player) throws SQLException {
        dbConnect();

        String sql = "INSERT INTO AKASH_SUKUMARAN_PLAYER VALUES(" + player.getPlayer_id() + ",'" + player.getFirst_name() + "','" + player.getLast_name() + "','" + player.getAddress() + "','" + player.getPostal_code() + "','" + player.getProvince() + "','" + player.getPhone_number() + "')";
        System.out.println("Inserting into AKASH_SUKUMARAN_PLAYER table: " + sql);

        statement.executeUpdate(sql);
        System.out.println("One row inserted!");

        if (statement != null) {
            statement.close();
        }
        dbDisconnect();
    }

    // Update Player data in AKASH_SUKUMARAN_PLAYER table
    public static void updatePlayerData(game.Player player) throws SQLException {
        dbConnect();

        String sql = "UPDATE AKASH_SUKUMARAN_PLAYER SET first_name = ?, last_name = ?, address = ?, postal_code = ?, province = ?, phone_number = ? WHERE player_id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, player.getFirst_name());
        stmt.setString(2, player.getLast_name());
        stmt.setString(3, player.getAddress());
        stmt.setString(4, player.getPostal_code());
        stmt.setString(5, player.getProvince());
        stmt.setString(6, player.getPhone_number());
        stmt.setInt(7, player.getPlayer_id());

        stmt.executeUpdate();
        System.out.println("Row updated");

        stmt.close();
        dbDisconnect();
    }

    // Create AKASH_SUKUMARAN_PG table
    public static void createPlayerAndGameTable() throws SQLException {
        dbConnect();

        String sql = "CREATE TABLE AKASH_SUKUMARAN_PG (player_game_id INT PRIMARY KEY, game_id INT, player_id INT, player_date VARCHAR(100), score INT)";
        statement.executeUpdate(sql);
        System.out.println("AKASH_SUKUMARAN_PG Table created");

        if (statement != null) {
            statement.close();
        }
        dbDisconnect();
    }

    // Insert Player and Game data into AKASH_SUKUMARAN_PG table
    public static void insertPlayerAndGameData(game.PlayerAndGame pag) throws SQLException {
        dbConnect();

        String sql = "INSERT INTO AKASH_SUKUMARAN_PG VALUES(" + pag.getPlayer_game_id() + "," + pag.getGame_id() + "," + pag.getPlayer_id() + ",'" + pag.getPlayer_date() + "'," + pag.getScore() + ")";
        System.out.println("Inserting into AKASH_SUKUMARAN_PG table: " + sql);

        statement.executeUpdate(sql);
        System.out.println("One row inserted");

        if (statement != null) {
            statement.close();
        }
        dbDisconnect();
    }

    // Query method
    public static ResultSet query(String tableName, String sql) throws SQLException {
        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
        dbConnect();

        ResultSet resultSet = statement.executeQuery(sql + " " + tableName);
        crs.populate(resultSet);

        if (statement != null) {
            statement.close();
        }
        dbDisconnect();

        return crs;
    }

    // Delete data from table
    public static void delete(String tableName, Integer player_game_id) throws SQLException {
        dbConnect();

        String sql = "DELETE FROM " + tableName + " WHERE player_game_id = " + player_game_id;
        statement.executeUpdate(sql);
        System.out.println("Data deleted");

        if (statement != null) {
            statement.close();
        }
        dbDisconnect();
    }

    public static void main(String[] args) throws SQLException {
        try {
            DbConnect.dbConnect();
            DbConnect.dbDisconnect();

            // Dropping existing tables before recreating
            try {
                DbConnect.dropTable("AKASH_SUKUMARAN_GAME");
            } catch (SQLException e) { }
            try {
                DbConnect.dropTable("AKASH_SUKUMARAN_PLAYER");
            } catch (SQLException e) { }
            try {
                DbConnect.dropTable("AKASH_SUKUMARAN_PG");
            } catch (SQLException e) { }

            // Creating tables
            DbConnect.createGameTable();
            DbConnect.createPlayerTable();
            DbConnect.createPlayerAndGameTable();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
