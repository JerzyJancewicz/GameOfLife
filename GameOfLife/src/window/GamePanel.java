package window;

import game.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements MouseListener, ActionListener {

    private final int gameWidth;
    private final int gameHeight;
    private Node node;
    private Background background;
    private int xMousePosition;
    private int yMousePosition;
    private Timer timer = new Timer(1000, this);

    public GamePanel(int gameWidth, int gameHeight) {
        this.gameHeight = gameHeight;
        this.gameWidth = gameWidth;
        this.setPreferredSize(new Dimension(gameWidth, gameHeight));
        this.setVisible(true);
        timer.start();
    }

    public void paint(Graphics g){
        background = new Background(gameWidth / 10, gameHeight / 10);
        background.paintBackGround(g);
        background.fillNode(xMousePosition, yMousePosition, g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        node = new Node(e.getX(), e.getY());
        xMousePosition = e.getX();
        yMousePosition = e.getY();
        System.out.println(node.getxPosition() +" "+ node.getyPosition());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
