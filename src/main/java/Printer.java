import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Printer {

    public void printInConsole(ResultSet res) throws SQLException {
        String title, producer, sort, type;
        int price, rating;
        while (res.next()) {
            // res.next();
            title = res.getString(2);
            producer = res.getString(3);
            sort = res.getString(4);
            type = res.getString(5);
            price = res.getInt(6);
            rating = res.getInt(7);

            System.out.println(title + " | " + producer + " | " + sort + " | " + type + " | " + price + " | " + rating);
        }
    }


    public void saveToFile(ResultSet res, String fileName) throws IOException, SQLException {

        String title, producer, sort, type;
        int price, rating;
        FileWriter fw = new FileWriter((fileName + ".csv"));
        BufferedWriter bw = new BufferedWriter(fw);
        while (res.next()) {
            title = res.getString(2);
            producer = res.getString(3);
            sort = res.getString(4);
            type = res.getString(5);
            price = res.getInt(6);
            rating = res.getInt(7);
            bw.write(title + ";" + producer + ";" + sort + ";" + type + ";" + price + ";" + rating);
            bw.newLine();
        }

        bw.close();


    }

}
