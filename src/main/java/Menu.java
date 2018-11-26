import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Scanner scan = new Scanner(System.in);
        DataDownload dd = new DataDownload("root", "admin");
        Printer print = new Printer();

        System.out.println("PROSZĘ WYBRAĆ JEDNĄ Z OPCJI:");
        System.out.println("1. WSZYSTKIE REKORDY");
        System.out.println("2. WIĘKSZE OD...");
        System.out.println("3. TYLKO GRY KOMPUTEROWE");
        System.out.println("4. WYJSCIE");



        String komenda= null;
        while(!(komenda = scan.nextLine()).equals("4")){
            if (komenda.equals("1")){
                print.printInConsole(dd.ShowAll());
                print.saveToFile(dd.ShowAll(), "Query1");

            } else if(komenda.equals("2")){
                System.out.println("PROSZĘ PODAĆ RATING MIN:");
                int rating = scan.nextInt();
                scan.nextLine();
                print.printInConsole(dd.ShowGamesAboveLevel(rating));
                print.saveToFile(dd.ShowGamesAboveLevel(rating), "Query2");

            } else if( komenda.equals("3")){
                print.printInConsole(dd.ShowComputerGames());
                print.saveToFile(dd.ShowComputerGames(), "Query3");

            } else {
                System.out.println("-------------");
                System.out.println("ZŁY WYBÓR");
                System.out.println("-------------");

            }

            System.out.println("\nPROSZE WYBRAĆ JEDNĄ Z OPCJI");
            System.out.println("1. WSZYSTKIE REKORDY");
            System.out.println("2. WIĘKSZE OD...");
            System.out.println("3. TYLKO GRY KOMPUTEROWE");
            System.out.println("4. WYJSCIE");
        }
    }
}
