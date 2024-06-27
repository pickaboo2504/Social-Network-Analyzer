package network;

import javax.swing.*;

public class CheckFriendship {
    private readFriendship graphInput; // Added reference to WeightedGraphInput

    public CheckFriendship(readFriendship graphInput) {
        this.graphInput = graphInput;
    }

    public void checkFriendship(String user1, String user2) {
        graphInput.readGraphFromFile();

        int[][] adjacencyMatrix = graphInput.readFriendship();
        String[] names = graphInput.getNames();
        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(user1)) {
                index1 = i;
            }
            if (names[i].equalsIgnoreCase(user2)) {
                index2 = i;
            }
        }

        if (index1 != -1 && index2 != -1) {
            if (adjacencyMatrix[index1][index2] != -1) {
                textField_2.setText("Yes");
            } else {
                textField_2.setText("No");
            }
        } else {
            textField_2.setText("Invalid users");
        }
    }

    public static void main(String[] args) {
        // You can add code here for testing if needed.
    }
}
