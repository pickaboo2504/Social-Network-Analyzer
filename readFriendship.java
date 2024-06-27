package network;

import java.io.*;

public class readFriendship {
	private String []names;
	private int [][] weightedGraph;
	private String filename;
	public readFriendship(String string) {
		// TODO Auto-generated constructor stub
	}



	public void CheckFriendship(String filename)
	{
		this.filename=filename;
	}

	
	
	public void readGraphFromFile() {
		try(BufferedReader fileReader=new BufferedReader(new FileReader(filename))){
			String namesInput=fileReader.readLine();
			if(namesInput!=null)
			{
				names=namesInput.split(",");
				int numusers=names.length;
				weightedGraph=new int[numusers][numusers];
				for(int i=0;i<numusers;i++)
				{
					String rowInput=fileReader.readLine();
					String []values=rowInput.split("\\s+");
					for(int j=0;j<numusers;j++)
					{
						try {
							if(values[j].trim().equalsIgnoreCase("-1"))
							{
								weightedGraph[i][j]=-1;
							}
							else {
								weightedGraph[i][j]=Integer.parseInt(values[j].trim());
							}
						}
						catch(NumberFormatException ex)
						{
							weightedGraph[i][j]=Integer.MAX_VALUE;
						}
					}
					
				}
			
			
			System.out.println("data has been read from "+filename);
			}
			else {
				System.out.println("file empty");
			}
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void writeGraphToFile() {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filename))) {
            // Write names
            String namesOutput = String.join(",", names);
            fileWriter.write(namesOutput);
            fileWriter.newLine();

            // Write adjacency matrix
            for (int i = 0; i < names.length; i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < names.length; j++) {
                    if (weightedGraph[i][j] == -1) {
                        row.append("-1 ");
                    } else {
                        row.append(weightedGraph[i][j]).append(" ");
                    }
                }
                fileWriter.write(row.toString().trim());
                fileWriter.newLine();
            }

            System.out.println("Data has been written to " + filename);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Getter method to retrieve the weighted graph
    public int[][] getWeightedGraph() {
        return weightedGraph;
    }

    // Getter method to retrieve the user names
    public String[] getNames() {
        return names;
    }

    public static void main(String[] args) {
        readFriendship graphInput = new readFriendship("map.txt");
        graphInput.readGraphFromFile();
        // You can call writeGraphToFile() here to write data back to the file if needed.
    }



	public int[][] readFriendship() {
		// TODO Auto-generated method stub
		return null;
	}

}



