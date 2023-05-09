package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private final int gameWidth;
    private final int gameHeight;
    private int count = 0;

    public Window(int gameWidth, int gameHeight, String gameRules) {
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;

        this.setSize(gameWidth + 16, gameHeight + 40);
        this.setVisible(true);
        this.setTitle("Game of Life");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(Window.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel(gameWidth, gameHeight, gameRules);
        this.add(gamePanel);
        this.addMouseListener(gamePanel);

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(count % 2 == 0) {
                    gamePanel.stopTimer();
                }else{
                    gamePanel.startTimer();
                }
                count++;
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(stopButton);
        this.add(buttonPanel, BorderLayout.NORTH);
    }
}
