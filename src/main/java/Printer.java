import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Printer {

    public void printInConsole(ArrayList<Game> lista) throws SQLException {
        for (Game gra : lista) {
            System.out.println(gra.getTitle() + " | " + gra.getProducer() + " | " + gra.getSort() + " | " + gra.getType() + " | " + gra.getPrice() + " | " + gra.getRating());
        }
    }


    public void saveToFile(ArrayList<Game> lista, String fileName) throws IOException {
        FileWriter fw = new FileWriter((fileName + ".csv"));
        BufferedWriter bw = new BufferedWriter(fw);
        for (Game gra : lista) {
            bw.write(gra.getTitle() + ";" + gra.getProducer() + ";" + gra.getSort() + ";" + gra.getType() + ";" + gra.getPrice() + ";" + gra.getRating());
            bw.newLine();
        }
        bw.close();
    }

}
