package views;

import java.util.List;
import java.util.Scanner;

import models.Region;

public class RegionView implements IViews<Region> {
    private Scanner scanner;

    public RegionView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayList(List<Region> items) {

        System.out.println("\n========== list of regions ==========");
        System.out.println("\n---------------------------------------");
        System.out.println("| id |    \tname\t      | count |");
        System.out.println("---------------------------------------");
        for (Region region : items) {
            System.out.printf("| %2d | %-22s | %-5d |\n", region.getId(), region.getName(), region.getCount());
        }
        System.out.println("---------------------------------------");
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
    public void displayItem(Region item) {
        if (item != null) {
            System.out.println("\n---------------------------------------");
            System.out.println("| id |    \tname\t      | count |");
            System.out.println("---------------------------------------");

            System.out.printf("| %2d | %-22s | %-5d |\n", item.getId(), item.getName(), item.getCount());

            System.out.println("---------------------------------------");
        } else {
            System.out.println("data is not found!");
        }
    }

    @Override
    public void displaySearchItems(List<Region> items) {
        System.out.println("\n---------------------------------------");
        System.out.println("| id |    \tname\t      | count |");
        System.out.println("---------------------------------------");
        for (Region region : items) {
            System.out.printf("| %2d | %-22s | %-5d |\n", region.getId(), region.getName(), region.getCount());
        }
        System.out.println("---------------------------------------");
    }

}
