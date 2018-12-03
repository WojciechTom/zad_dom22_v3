import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class dataDownload {

    private String user;
    private String password;
    private Connection con;
    private Statement stat;


     public dataDownload(String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/gry?&serverTimezone=UTC";
        con = DriverManager.getConnection(url, user, password);
        stat = con.createStatement();
    }

    public ArrayList<Game> showAll() throws SQLException, ClassNotFoundException, IOException {
        String query = "select * from games";
        ResultSet res = stat.executeQuery(query);
        return resultSetToList(res);
    }


    public ArrayList<Game> showGamesAboveLevel(int MinRating) throws SQLException, IOException {
        String query = "select * from games where rating > " + MinRating + " ";
        ResultSet res = stat.executeQuery(query);
        return resultSetToList(res);
    }


    public ArrayList<Game> showComputerGames() throws SQLException, IOException {
        String query = "select * from games where sort  = \"computer game\" ";
        ResultSet res = stat.executeQuery(query);
        return resultSetToList(res);
    }

    private ArrayList<Game> resultSetToList(ResultSet res) throws SQLException {
        ArrayList<Game> listaGier = new ArrayList<Game>();
        while (res.next()) {
            Game gra = new Game(res.getString("title"), res.getString("producer"), res.getString("sort"), res.getString("type"), res.getInt("price"), res.getInt("rating"));
            listaGier.add(gra);
        }
        return listaGier;
     }

}
