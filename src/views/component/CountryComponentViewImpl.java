package views.component;

import java.util.List;
import java.util.Scanner;

import models.Country;

public class CountryComponentViewImpl implements IComponentView<Country> {

    private Scanner scanner;

    public CountryComponentViewImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    @Override
    public Integer readInteger(String prompt) {
        System.out.print(prompt + ": ");
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input!");
                System.out.println("Please enter an Interger!");
            }

        }
    }

    @Override
    public Double readDouble(String prompt) {
        System.out.print(prompt + ": ");
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input!");
                System.out.println("Please enter a Number!");
            }

        }
    }

    @Override
    public void displayList(List<Country> items) {
        System.out.println("\n============== LIST OF COUNTRY ==============");
        System.out.println("\n+-------------------------------------------+");
        System.out.println("|  id  |       \tname\t           | region |");
        System.out.println("+-------------------------------------------+");
        for (Country region : items) {
            System.out.printf("| %-4s | %-25s | %-6d |\n", region.getId(), region.getName(), region.getRegion_id());
        }
        System.out.println("+-------------------------------------------+");
    }

    @Override
    public void displayItem(Country item) {
        if (item != null) {
            System.out.println("\n+---------------------------------------+");
            System.out.println("|  id  |      \tname\t       | region |");
            System.out.println("+---------------------------------------+");

            System.out.printf("| %-4s | %-25s | %-6d |\n", item.getId(), item.getName(), item.getRegion_id());

            System.out.println("+---------------------------------------+");
            System.out.println("data is not found!");
        }
    }

}
