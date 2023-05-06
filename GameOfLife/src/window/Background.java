package window;

import java.awt.*;

public class Background {
    private final int numRows;
    private final int numCols;

    public Background(int numCols, int numRows) {
        this.numCols = numCols;
        this.numRows = numRows;
    }

    public void paintBackGround(Graphics g) {
        int tileSize = 20;
        g.setColor(Color.BLACK);

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                g.drawRect(col * tileSize, row * tileSize, tileSize, tileSize);
            }
        }
    }

    public void fillNode(int x, int y, Graphics g){
        g.fillRect(x - 8, y - 30, 20, 20);
    }
}
