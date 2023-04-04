package views;

import java.util.Scanner;

import exeption.databaseConnectionExeption;
import tools.DBConnection;
import tools.Utility;
import views.menus.CountryTableMenu;
import views.menus.RegionTableMenu;

public class MainMenu {
    
    static private Scanner terminalInput = new Scanner(System.in);
    
    public static void DisplayMenu() {

        boolean isContinue = true;

        while (isContinue) {
            try {

                DBConnection dbConnection = new DBConnection();
                dbConnection.getConnection();

                Utility.clearScreen();

                System.out.println("+================================+");
                System.out.println("|             HR DB              |");
                System.out.println("+================================+");
                System.out.println("| 1. Region Table                |");
                System.out.println("| 2. Country Table               |");
                System.out.println("+================================+");
                System.out.println("| x. EXIT                         |");
                System.out.println("+================================+");

                System.out.print("Input Select: ");
                String inputUser = terminalInput.nextLine();

                switch (inputUser) {
                    case "1":
                        RegionTableMenu.DisplayMenu();
                        break;
                    case "2":
                        CountryTableMenu.DisplayMenu();
                        break;
                    case "x":
                        Utility.displayMessage("Thanks You >///<");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nInput Invalid!");
                        System.out.println("please select [1-2]");
                        break;
                }

            } catch (databaseConnectionExeption e) {
                Utility.clearScreen();
                System.out.println(e.getMessage());
            }

            isContinue = Utility.yesOrNo("Do you want to continue ");

        }

    }
}
