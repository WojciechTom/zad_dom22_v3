import java.io.IOException;
import java.sql.*;

public class DataDownload {

    private String user;
    private String password;
    Connection con;
    Statement stat;


     public DataDownload(String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/gry?&serverTimezone=UTC";
        con = DriverManager.getConnection(url, user, password);
        stat = con.createStatement();
    }

    public ResultSet ShowAll() throws SQLException, ClassNotFoundException, IOException {
        String query = "select * from games";
        ResultSet res = stat.executeQuery(query);
        return res;
    }


    public ResultSet ShowGamesAboveLevel(int MinRating) throws SQLException, IOException {
        String query = "select * from games where rating > " + MinRating + " ";
        ResultSet res = stat.executeQuery(query);
        return res;
    }


    public ResultSet ShowComputerGames() throws SQLException, IOException {
        String query = "select * from games where sort  = \"computer game\" ";
        ResultSet res = stat.executeQuery(query);
        return res;
    }



}
