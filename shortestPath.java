package network;

import javax.swing.*;

public class shortestPath {
    private readFriendship graphInput;
    private JTextField textField_4;

    public shortestPath(readFriendship graphInput, JTextField textField_4) {
        this.graphInput = graphInput;
        this.textField_4 = textField_4;
    }


    public void shortestPath(String user1, String user2) {
        int[][] adjacencyMatrix = graphInput.getWeightedGraph();
        String[] names = graphInput.getNames();

        int[][] distance = new int[names.length][names.length];
        int[][] predecessor = new int[names.length][names.length];

     
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names.length; j++) {
                distance[i][j] = adjacencyMatrix[i][j];
                if (i != j && adjacencyMatrix[i][j] != -1) {
                    predecessor[i][j] = i;
                } else {
                    predecessor[i][j] = -1;
                }
            }
        }

        
        for (int k = 0; k < names.length; k++) {
            for (int i = 0; i < names.length; i++) {
                for (int j = 0; j < names.length; j++) {
                    if (distance[i][k] != -1 && distance[k][j] != -1) {
                        int newDistance = distance[i][k] + distance[k][j];
                        if (distance[i][j] == -1 || newDistance < distance[i][j]) {
                            distance[i][j] = newDistance;
                            predecessor[i][j] = predecessor[k][j];
                        }
                    }
                }
            }
        }

       
        int user1Index = -1;
        int user2Index = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(user1)) {
                user1Index = i;
            }
            if (names[i].equals(user2)) {
                user2Index = i; 
            }
        }

        if (user1Index == -1 || user2Index == -1 || distance[user1Index][user2Index] == -1) {
            textField_4.setText("No path found");
            return;
        }

        

        StringBuilder shortestPath = new StringBuilder();
        int current = user2Index;
        while (current != user1Index) {
            shortestPath.insert(0, "->" + names[current]);
            current = predecessor[user1Index][current];
        }
        shortestPath.insert(0, names[user1Index]);

        textField_4.setText(shortestPath.toString());
    }
}
