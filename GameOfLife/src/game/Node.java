package game;

public class Node {

    private int xPosition;
    private int yPosition;
    private boolean condition;

    public Node(int xPosition, int yPosition, boolean condition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.condition = condition;
    }

    public int getxPosition() {
        return xPosition;
    }


    public int getyPosition() {
        return yPosition;
    }


    public boolean isCondition() {
        return condition;
    }
}
