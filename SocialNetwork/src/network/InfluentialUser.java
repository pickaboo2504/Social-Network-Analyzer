package network;


public class InfluentialUser {
	private readFriendship graphInput;

    public void InfluentialUser() {
        
        int[][] adjacencyMatrix = graphInput.readFriendship();
        String[] names = graphInput.getNames();

        int mostConnections = -1; // Initialize to a negative value
        String influentialUser = "";

        for (int i = 0; i < names.length; i++) {
            int totalConnections = 0;
            for (int j = 0; j < names.length; j++) {
                if (adjacencyMatrix[i][j] != -1) { // Check if there is a connection
                    totalConnections += adjacencyMatrix[i][j];
                }
            }

            if (totalConnections > mostConnections) {
                mostConnections = totalConnections;
                influentialUser = names[i];
            }
        }

        
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
