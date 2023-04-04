package views.menus;

import java.util.Scanner;

import tools.Utility;
import views.CountryView;
import views.MainMenu;

public class CountryTableMenu {
    static Scanner terminalInput = new Scanner(System.in);

    public static void DisplayMenu() {

        boolean isContinue = true;

        while (isContinue) {

            Utility.clearScreen();

            CountryView countryView = new CountryView();

            System.out.println("+================================+");
            System.out.println("|         COUNTRY TABLE          |");
            System.out.println("+================================+");
            System.out.println("| 1. Show Country List           |");
            System.out.println("| 2. Search Country              |");
            System.out.println("| 3. Add Country                 |");
            System.out.println("| 4. Edit Country                |");
            System.out.println("| 5. Delete Country              |");
            System.out.println("+================================+");
            System.out.println("| b. BACK                        |");
            System.out.println("| x. EXIT                        |");
            System.out.println("+================================+");

            System.out.print("Input Select: ");
            String inputUser = terminalInput.nextLine();

            switch (inputUser) {
                case "1":
                    Utility.clearScreen();
                    countryView.ShowDataList();
                    break;
                case "2":
                    Utility.clearScreen();
                    countryView.searchData();
                    break;
                case "3":
                    Utility.clearScreen();
                    countryView.addData();
                    break;
                case "4":
                    Utility.clearScreen();
                    countryView.EditData();
                    break;
                case "5":
                    Utility.clearScreen();
                    countryView.DeleteData();
                    break;
                case "b":
                    MainMenu.DisplayMenu();
                    return;
                case "x":
                    Utility.displayMessage("Thanks You >///<");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInput Invalid!");
                    System.out.println("please select [1-5]");
                    break;
            }

            isContinue = Utility.yesOrNo("Do you want to continue ");

        }

        if (!isContinue) {
            System.exit(0);
        }

    }
}
