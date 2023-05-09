import window.Window;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int gameWidth = 800;
        int gameHeight = 800;

        System.out.println("Game of life");
        System.out.println("Wprowadz zasady : ");

        Scanner scanner = new Scanner(System.in);
        String gameRules = scanner.nextLine();
        new Window(gameWidth, gameHeight, gameRules);
    }
}