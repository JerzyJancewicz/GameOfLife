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
    private Background background;
    private int xMousePosition;
    private int yMousePosition;
    private Node[][] nodes;
    private final int tileSize = 20;
    private final Timer timer = new Timer(333, this);

    public GamePanel(int gameWidth, int gameHeight) {
        this.gameHeight = gameHeight;
        this.gameWidth = gameWidth;
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
        //background.fillNode(xMousePosition * tileSize,yMousePosition * tileSize,g);
    }

    private void fillNodes(){
        for(int i = 0; i < nodes.length; i++){
            for(int j = 0; j < nodes[i].length; j++){
                nodes[i][j] = new Node(i*20,j*20,false);
            }
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
        nodes[yMousePosition][xMousePosition] = new Node(xMousePosition * tileSize,yMousePosition * tileSize, true);
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
        // Create a copy of the grid to store the new state of the cells
        Node[][] newNodes = new Node[nodes.length][nodes[0].length];

        // Loop over all the cells in the grid
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                Node current = nodes[i][j];
                int aliveNeighbors = countAliveNeighbors(i, j);

                if (current.isCondition() && (aliveNeighbors == 2 || aliveNeighbors == 3)) {
                    newNodes[i][j] = new Node(i*tileSize, j*tileSize, true);
                } else if (!current.isCondition() && aliveNeighbors == 3) {
                    newNodes[i][j] = new Node(i*tileSize, j*tileSize, true);
                } else{
                    newNodes[i][j] = new Node(i*tileSize, j*tileSize, false);
                }
            }
        }

        nodes = newNodes;
        repaint();
    }

    // Count the number of alive neighbors of the cell at (i, j)
    private int countAliveNeighbors(int i, int j) {
        int count = 0;

        // Check the eight neighboring cells
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                if (di == 0 && dj == 0) {
                    continue;
                }
                int ni = i + di;
                int nj = j + dj;
                if (ni >= 0 && ni < nodes.length && nj >= 0 && nj < nodes[0].length && nodes[ni][nj].isCondition()) {
                    count++;
                }
            }
        }
        return count;
    }
}
