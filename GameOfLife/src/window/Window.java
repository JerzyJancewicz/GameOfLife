package window;

import javax.swing.*;

public class Window extends JFrame {

    private final int gameWidth;
    private final int gameHeight;

    public Window(int gameWidth, int gameHeight) {
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;

        this.setSize(gameWidth + 16, gameHeight + 40);
        this.setVisible(true);
        this.setTitle("Game of Life");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(Window.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel(gameWidth, gameHeight);
        this.add(gamePanel);
        this.addMouseListener(gamePanel);

    }


}
