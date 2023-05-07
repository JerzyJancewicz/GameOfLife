package game;

public class Node{

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

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }
}
