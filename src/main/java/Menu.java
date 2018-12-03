import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Scanner scan = new Scanner(System.in);
        dataDownload dd = new dataDownload("root", "admin");
        Printer print = new Printer();

        System.out.println("PROSZĘ WYBRAĆ JEDNĄ Z OPCJI:");
        System.out.println("OP1  <-  WSZYSTKIE REKORDY");
        System.out.println("OP2  <-  WIĘKSZE OD...");
        System.out.println("OP3  <-  TYLKO GRY KOMPUTEROWE");
        System.out.println("OP4  <-  WYJSCIE");




        Opcje op = null;

        while(!(op = Opcje.valueOf(scan.nextLine())).equals(Opcje.OP4)){

            switch (op){
                case OP1:
                    print.printInConsole(dd.showAll());
                    print.saveToFile(dd.showAll(), "Query1");
                    break;
                case OP2:
                    System.out.println("PROSZĘ PODAĆ RATING MIN:");
                    int rating = scan.nextInt();
                    scan.nextLine();
                    print.printInConsole(dd.showGamesAboveLevel(rating));
                    print.saveToFile(dd.showGamesAboveLevel(rating), "Query2");
                    break;
                case OP3:
                    print.printInConsole(dd.showComputerGames());
                    print.saveToFile(dd.showComputerGames(), "Query3");
                    break;
                default:
                    System.out.println("-------------");
                    System.out.println("ZŁY WYBÓR");
                    System.out.println("-------------");
            }

            System.out.println("\nPROSZĘ WYBRAĆ JEDNĄ Z OPCJI:");
            System.out.println("OP1  <-  WSZYSTKIE REKORDY");
            System.out.println("OP2  <-  WIĘKSZE OD...");
            System.out.println("OP3  <-  TYLKO GRY KOMPUTEROWE");
            System.out.println("OP4  <-  WYJSCIE");        }


    }
}
