package ir.maktab.view;

import java.util.Scanner;

public class Menu {
    private String[] menuItems;
    Scanner scanner = new Scanner(System.in);

    public Menu(String[] menuItems) {
        this.menuItems = menuItems;
    }

    public void showMenu() {
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ". " + menuItems[i]);
        }
    }
}
