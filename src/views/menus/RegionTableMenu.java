package views.menus;

import java.util.Scanner;
import tools.Utility;
import views.MainMenu;
import views.RegionView;

public class RegionTableMenu {

    static Scanner terminalInput = new Scanner(System.in);

    public static void DisplayMenu() {

        boolean isContinue = true;

        while (isContinue) {

            Utility.clearScreen();

            RegionView regionView = new RegionView();

            System.out.println("+================================+");
            System.out.println("|          REGION TABLE          |");
            System.out.println("+================================+");
            System.out.println("| 1. Show Regions List           |");
            System.out.println("| 2. Search Region               |");
            System.out.println("| 3. Add region                  |");
            System.out.println("| 4. Edit region                 |");
            System.out.println("| 5. Delete region               |");
            System.out.println("+================================+");
            System.out.println("| b. BACK                        |");
            System.out.println("| x. EXIT                        |");
            System.out.println("+================================+");

            System.out.print("Input Select: ");
            String inputUser = terminalInput.nextLine();

            switch (inputUser) {
                case "1":
                    Utility.clearScreen();
                    regionView.ShowDataList();
                    break;
                case "2":
                    Utility.clearScreen();
                    regionView.searchData();
                    break;
                case "3":
                    Utility.clearScreen();
                    regionView.addData();
                    break;
                case "4":
                    Utility.clearScreen();
                    regionView.EditData();
                    break;
                case "5":
                    Utility.clearScreen();
                    regionView.DeleteData();
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
