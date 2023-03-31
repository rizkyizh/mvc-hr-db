package test;

import views.menus.MainMenuView;

public class ViewTest {
    public static void main(String[] args) {
        test_main_menu();
    }

    public static void test_main_menu() {

        MainMenuView main = new MainMenuView();
        main.DisplayMenu();

    }
}
