package window;

import game.GameAlgorithm;
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
    private Background background;
    private int xMousePosition;
    private int yMousePosition;
    private Node[][] nodes;
    private final int tileSize = 20;
    private String gameRules;
    private Timer timer = new Timer(100, this);

    public GamePanel(int gameWidth, int gameHeight, String gameRules) {
        this.gameHeight = gameHeight;
        this.gameWidth = gameWidth;
        this.gameRules = gameRules;

        this.setPreferredSize(new Dimension(gameWidth, gameHeight));
        this.setVisible(true);
        timer.start();
        nodes = new Node[gameHeight/10][gameWidth/10];

        fillNodes();

        nodes[5][10] = new Node(20*tileSize,15*tileSize,true);
        nodes[5][11] = new Node(20*tileSize,15*tileSize,true);
        nodes[5][12] = new Node(20*tileSize,15*tileSize,true);
        nodes[4][12] = new Node(20*tileSize,15*tileSize,true);
        nodes[3][11] = new Node(20*tileSize,15*tileSize,true);
    }

    public void paint(Graphics g){
        background = new Background(gameWidth / tileSize, gameHeight / tileSize, tileSize);
        background.paintBackGround(g);
        background.fillNode(nodes, g);
    }

    private void fillNodes(){
        for(int i = 0; i < nodes.length; i++){
            for(int j = 0; j < nodes[i].length; j++){
                nodes[i][j] = new Node(i*20,j*20,false);
            }
        }
    }

    public void stopTimer() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }
    public void startTimer() {
        if (timer != null) {
            timer.start();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        xMousePosition = e.getX() - 8;
        xMousePosition -= xMousePosition % tileSize;
        xMousePosition /= tileSize;
        yMousePosition = e.getY() - 30;
        yMousePosition -= yMousePosition % tileSize;
        yMousePosition /= tileSize;
        nodes[xMousePosition][yMousePosition] = new Node(xMousePosition * tileSize,yMousePosition * tileSize, true);
        repaint();
        System.out.println(xMousePosition + " " + yMousePosition);
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
        nodes = new GameAlgorithm(gameRules).gameRules(nodes,tileSize);
        repaint();
    }
}
