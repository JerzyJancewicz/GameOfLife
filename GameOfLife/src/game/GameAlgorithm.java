package game;

import java.util.ArrayList;

public class GameAlgorithm {

    private String gameRules;

    public GameAlgorithm(String gameRules) {
        this.gameRules = gameRules;
    }

    private ArrayList<Integer> gameRulesList(int i){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int first = Integer.parseInt(gameRules.split("/")[i]);
        while (first > 10){
            arrayList.add(first%10);
            first /= 10;
        }
        arrayList.add(first);
        return arrayList;
    }

    public Node[][] gameRules(Node[][] nodes, int tileSize){
        Node[][] tmp = new Node[nodes.length][nodes[0].length];

        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                Node current = nodes[i][j];
                int aliveNeighbors = countAliveNeighbors(i, j, nodes);

                if (current.isCondition() && gameRulesList(0).contains(aliveNeighbors)) {
                    tmp[i][j] = new Node(i*tileSize, j*tileSize, true);
                } else if (!current.isCondition() && gameRulesList(1).contains(aliveNeighbors)) {
                    tmp[i][j] = new Node(i*tileSize, j*tileSize, true);
                } else {
                    tmp[i][j] = new Node(i*tileSize, j*tileSize, false);
                }
            }
        }
        return tmp;
    }

    private int countAliveNeighbors(int i, int j, Node[][] nodes) {
        int count = 0;

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
