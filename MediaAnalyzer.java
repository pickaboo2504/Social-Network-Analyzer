package network;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaAnalyzer extends JFrame {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private readFriendship graphInput;
	public MediaAnalyzer() {
		
	    setAlwaysOnTop(true);
	    
	    getContentPane().setLayout(null); 
	    setLocationRelativeTo(null); 
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setPreferredSize(new Dimension(1100, 600));
		
		JLabel lblNewLabel = new JLabel("Enter a Name :");
		lblNewLabel.setBounds(275, 76, 171, 38);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel);
		
		JLabel lblEnterAName = new JLabel("Enter a Name :");
		lblEnterAName.setBounds(275, 125, 171, 38);
		lblEnterAName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterAName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(lblEnterAName);
		
		JButton btnNewButton = new JButton("Check Friendship");
		btnNewButton.setBounds(274, 188, 161, 38);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Influential User");
		btnNewButton_1.setBounds(274, 262, 161, 38);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Shortest Path");
		btnNewButton_2.setBounds(274, 333, 161, 38);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(489, 76, 295, 32);
		textField.setColumns(10);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(489, 131, 295, 32);
		textField_1.setColumns(10);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(489, 193, 295, 32);
		textField_2.setColumns(10);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(489, 267, 295, 32);
		textField_3.setColumns(10);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(489, 338, 295, 32);
		textField_4.setColumns(10);
		getContentPane().add(textField_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 0, 1043, 511);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\WhatsApp Image 2023-09-20 at 5.28.19 PM.jpeg"));
		getContentPane().add(lblNewLabel_1);
		 graphInput = new readFriendship("map.txt");

		 btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String user1 = textField.getText();
	                String user2 = textField_1.getText();
	                graphInput.readGraphFromFile(); 
	                CheckFriendship checker = new CheckFriendship(graphInput);
	                checker.checkFriendship(user1, user2);
	            }
	        });
	        btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                graphInput.readGraphFromFile();  // Read the graph data
	                InfluentialUser influentialuser=new InfluentialUser();
	            	influentialuser.InfluentialUser();
	            }
	        });

	        btnNewButton_2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String user1 = textField.getText();
	                String user2 = textField_1.getText();
	                graphInput.readGraphFromFile(); // Read the graph data
	                shortestPath spath=new shortestPath(graphInput, textField_4);
	            	spath.shortestPath(user1,user2);
	            	
	            }
	        });
	    }
	 

		
	
		public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    MediaAnalyzer frame = new MediaAnalyzer();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }
}