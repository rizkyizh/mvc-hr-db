package views.menus;

import java.util.Scanner;
import controllers.RegionController;
import daos.RegionDAO;
import exeption.databaseConnectionExeption;
import tools.DBConnection;
import tools.Utility;
import views.RegionView;

public class MainMenuView {

    Scanner terminalInput;

    public MainMenuView() {
        this.terminalInput = new Scanner(System.in);

    }

    public void DisplayMenu() {

        boolean isContinue = true;

        while (isContinue) {
            try {

                DBConnection dbConnection = new DBConnection();
                RegionDAO regionDao = new RegionDAO(dbConnection.getConnection());
                RegionView regionView = new RegionView();
                RegionController regionController = new RegionController(regionDao, regionView);

                Utility.clearScreen();

                System.out.println("========= Region Table =========");
                System.out.println("1. Show Regions List ");
                System.out.println("2. Search Region ");
                System.out.println("3. Add region ");
                System.out.println("4. Edit region ");
                System.out.println("5. Delete region ");
                System.out.println("================================");
                System.out.println("x. EXIT");
                System.out.println("================================");

                System.out.print("Input Select: ");
                String inputUser = terminalInput.nextLine();

                switch (inputUser) {
                    case "1":
                        regionController.listRegion();
                        break;
                    case "2":
                        regionController.readRegion();
                        break;
                    case "3":
                        regionController.createRegion();
                        break;
                    case "4":
                        regionController.updateRegion();
                        break;
                    case "5":
                        regionController.deleteRegion();
                        break;
                    case "x":
                        Utility.displayMessage("Thanks You >///<");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Input Invalid!");
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
