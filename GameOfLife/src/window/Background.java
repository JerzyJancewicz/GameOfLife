package window;
import game.Node;
import java.awt.*;

public class Background {
    private final int numRows;
    private final int numCols;
    private final int tileSize;

    public Background(int numCols, int numRows, int tileSize) {
        this.numCols = numCols;
        this.numRows = numRows;
        this.tileSize = tileSize;
    }

    public void paintBackGround(Graphics g) {
        g.setColor(Color.BLACK);

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                g.drawRect(col * tileSize, row * tileSize, tileSize, tileSize);
            }
        }
    }

    public void fillNode(Node[][] nodes, Graphics g){
        for(int i = 0; i < nodes.length;i++){
            for(int j = 0; j < nodes[i].length; j++){
                if(nodes[i][j].isCondition()) {
                    g.fillRect(nodes[i][j].getxPosition(), nodes[i][j].getyPosition(), 20, 20);
                }else {
                    g.clearRect(nodes[i][j].getxPosition(), nodes[i][j].getyPosition(), 20, 20);
                    g.drawRect(nodes[i][j].getxPosition(), nodes[i][j].getyPosition(), 20, 20);
                }
            }
        }
    }
    public void fillNode(int x, int y, Graphics g){
        g.fillRect(x, y, 20, 20);
    }
}
