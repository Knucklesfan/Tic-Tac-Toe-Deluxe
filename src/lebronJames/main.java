package lebronJames;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class main {
	public static int resolution = 3;
    public static JButton[][] buttons;
    public static JFrame window;
	private static int player = 0;
	public static boolean firstRun = true;
	private static File file;
	private static int modi;
	public static boolean theme_maker;
	public static String playerOneSymbol;
	public static String playerTwoSymbol;
	private static HelloWorldDisplay content;
	private static boolean angel;
	private static Image icon;
	public static Color playerOne;
	public static Color playerTwo;
	private static int fontSize;
	public static String version = "5.0.3";



	   private static class HelloWorldDisplay extends JPanel {
		   @Override
		      public void paintComponent(Graphics g) {
		         super.paintComponent(g);
		             g.drawImage(icon, 0, 0, this);
		         g.finalize();

		      }
		   }
	   private static class ButtonHandler implements ActionListener {

			private boolean mode;

			public void actionPerformed(ActionEvent e) {
					AbstractButton jb = (AbstractButton) e.getSource();
					if(player == 0) {
						if(jb.getText().equals("")) {
							jb.setForeground(playerOne);
							jb.setText(playerOneSymbol);
							nextPlayer();
						}

					}
					if(player == 1) {
					if(jb.getText().equals("")) {
						if(firstRun) {
							firstRun = false;
						}
						if(mode) {
							jb.setForeground(playerTwo);
							jb.setText(playerTwoSymbol);
						}
						if(!mode) {
							jb.setForeground(playerOne);
						jb.setText(playerOneSymbol);
						}
						mode = !mode;
						if(mode == true) {
							window.setTitle("Tic Tac Toe Deluxe: Current Player: " + playerTwoSymbol);
						}
						if(mode == false) {
							window.setTitle("Tic Tac Toe Deluxe: Current Player: " + playerOneSymbol);
						}

						manager.checkWin();
					}
					}
			}

			private void nextPlayer() {
				if(player == 0) {
					manager.ComputerRound();
				}
				if(player == 1) {
					mode = true;
					firstRun = false;
				}
				mode = !mode;
			}
	   }
	public static void softRefresh() {
		      buttons = new JButton[resolution][resolution];
		      ButtonHandler listener = new ButtonHandler();
		      //buttons[0].addActionListener(listener);
		      content = new HelloWorldDisplay();
		      content.setLayout(new GridLayout(resolution,resolution));
		        if(modi == 0) {
			        for(int i = 0; i < main.resolution; i++) {
			        	for(int x = 0; x < main.resolution; x++) {
					      buttons[i][x] = new JButton("");
				    	  buttons[i][x].setFont(new Font("Arial", Font.PLAIN, 40));
			        	}
					      playerOneSymbol = "X";
					      playerTwoSymbol = "O";

			        }
		        }
		        if(modi == 1) {
			        for(int i = 0; i < main.resolution; i++) {
			        	for(int x = 0; x < main.resolution; x++) {
					      buttons[i][x] = new JButton("");
				        	buttons[i][x].setBackground(Color.DARK_GRAY);
					    	  buttons[i][x].setFont(new Font("Arial", Font.PLAIN, 40));


			        	}
			        	playerOne = Color.WHITE;
			        	playerTwo = Color.WHITE;
						      playerOneSymbol = "X";
						      playerTwoSymbol = "O";


			        }
			        
		        }
		        if(modi == 2) {
			        for(int i = 0; i < main.resolution; i++) {
			        	for(int x = 0; x < main.resolution; x++) {
					      buttons[i][x] = new JButton("");
				        	Color z = new Color((int)(Math.random() * 0x1000000));
				        	buttons[i][x].setBackground(z);
					    	  buttons[i][x].setFont(new Font("Arial", Font.PLAIN, 40));
						      playerOneSymbol = "X";
						      playerTwoSymbol = "O";
			        	}

			        }
		        }
	        if(modi == 3) {
	        	try {
					reloadTheme();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
		      for(int i = 0; i < main.resolution; i++) {
		    	  for(int x = 0; x < main.resolution; x++) {
			      content.add(buttons[i][x]);
			      buttons[i][x].addActionListener(listener);
		    	  }
		      }
		      window = new JFrame("Tic Tac Toe Deluxe");
		      if(player == 1) {
		    	  window.setTitle("Tic Tac Toe Deluxe: Current Player X");
		      }
		      window.setContentPane(content);
		      window.setSize(550,550);
		      window.setLocationRelativeTo(null);
		      window.setVisible(true);

	    }

	   public static void main(String[] args) {
		        Object[] options = {"One Player Arcade",
                "Two players Arcade", "Credits"};
		        int bear = JOptionPane.showOptionDialog(null,
		        		"How many players are playing?",
		        		"Tic Tac Toe Deluxe",
		        		JOptionPane.YES_NO_OPTION,
		        		JOptionPane.QUESTION_MESSAGE,
		        		null,     //do not use a custom Icon
		        		options,  //the titles of buttons
		        		options[0]); //default button title
		        if(bear == 0) {
		        	player = 0;
		        }
		        if(bear == 1) {
		        	player = 1;
		        }
		        if(bear == 2) {
		        	CreditMving.showCreds();
		        }
		        if(bear < 2) {
		        Object[] simp = {"Classic Game",
                "Theme Maker"};
		        int simple = JOptionPane.showOptionDialog(null,
		        		"Classic game or Theme Maker?",
		        		"Tic Tac Toe Deluxe",
		        		JOptionPane.YES_NO_OPTION,
		        		JOptionPane.QUESTION_MESSAGE,
		        		null,     //do not use a custom Icon
		        		simp,  //the titles of buttons
		        		simp[0]); //default button title
		        if(simple == 0) {
			        Object[] mode = {"Light mode",
	                "Dark mode", "Colorful mode", "Load Theme"};
			        modi = JOptionPane.showOptionDialog(null,
			        		"Select a theme",
			        		"Tic Tac Toe Deluxe",
			        		JOptionPane.YES_NO_OPTION,
			        		JOptionPane.QUESTION_MESSAGE,
			        		null,     //do not use a custom Icon
			        		mode,  //the titles of buttons
			        		mode[0]); //default button title
			        Object[] meh = {"Classic (3x3)",
			                "Tolerable (5x5)" , "Hard (7x7)" , "Insane! (9x9)", "Custom (?x?)","Random (Might not be playable!)"};
					        int meem = JOptionPane.showOptionDialog(null,
					        		"Difficulty?",
					        		"Tic Tac Toe Deluxe",
					        		JOptionPane.YES_NO_OPTION,
					        		JOptionPane.QUESTION_MESSAGE,
					        		null,     //do not use a custom Icon
					        		meh,  //the titles of buttons
					        		meh[0]); //default button title
					        if(meem == 0) {
					        	resolution = 3;
					        }
					        if(meem == 1) {
					        	resolution = 5;
					        }
					        if(meem == 2) {
					        	resolution = 7;
					        }
					        if(meem == 3) {
					        	resolution = 9;
					        }
					        if(meem == 4) {
					    		resolution = Integer.parseInt(JOptionPane.showInputDialog(null, "Resolution?"));
					        }
					        if(meem == 5) {
					        	resolution = (int) (Math.random()*50);
					        }
					        if(modi == 3) {
					    		JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
					            int r = j.showOpenDialog(null); 
					            file = j.getSelectedFile();
					        }
					        softRefresh();
			        }
		        	if(simple == 1) {
						try {
							createTheme();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
		        }
		        }
	private static void loadTheme() throws FileNotFoundException {
        reloadTheme();
	}
	private static void createTheme() throws FileNotFoundException {
		modi = 3;
		theme_maker = true;
		JOptionPane.showMessageDialog(null, "First, select an image");
		JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
        int r = j.showOpenDialog(null); 
        File sabin = j.getSelectedFile();
        ImageIcon icon = new ImageIcon(sabin.getPath());
		JOptionPane.showMessageDialog(null, "Next, select a text color for each player");
        JColorChooser c = new JColorChooser();
        Color b = c.showDialog(null, "Text color for Player One", Color.blue);
        JColorChooser d = new JColorChooser();
        Color e = c.showDialog(null, "Text color for Player Two", Color.blue);

		playerOneSymbol = JOptionPane.showInputDialog(null, "Text for Player one?");
		playerTwoSymbol = JOptionPane.showInputDialog(null, "Text for Player two?");
		fontSize = Integer.parseInt(JOptionPane.showInputDialog(null, "Font size?"));

        Object[] options = {"Standard",
        "Full"};
        angel = false;
        int pal = JOptionPane.showOptionDialog(null,
        		"Use full or standard image mode?",
        		"Tic Tac Toe Deluxe",
        		JOptionPane.YES_NO_OPTION,
        		JOptionPane.QUESTION_MESSAGE,
        		null,     //do not use a custom Icon
        		options,  //the titles of buttons
        		options[0]); //default button title
        if(pal == 0) {
        	angel = false;
        }
        if(pal == 1) {
        	angel = true;
        }

		JOptionPane.showMessageDialog(null, "Finally, save your custom theme.");
        JFileChooser saver = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
        
        // invoke the showsSaveDialog function to show the save dialog 
        int save = saver.showSaveDialog(null); 
        
        File sav = saver.getSelectedFile();
        
        PrintWriter print = new PrintWriter(sav.getPath());
        print.println(sabin.getPath());
        print.println(b.getRed() + " " + b.getGreen() + " " + b.getBlue());
        print.println(e.getRed() + " " + e.getGreen() + " " + e.getBlue());
        print.println(playerOneSymbol);
        print.println(playerTwoSymbol);
        print.println(angel);
        print.println(fontSize);
        print.close();
        
		JOptionPane.showMessageDialog(null, "Saved successfully!");
		file = sav;
		softRefresh();
	}
	private static void reloadTheme() throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        icon = Toolkit.getDefaultToolkit().createImage(scan.nextLine());
        playerOne = new Color(scan.nextInt(),scan.nextInt(),scan.nextInt());
        playerTwo = new Color(scan.nextInt(),scan.nextInt(),scan.nextInt());

        playerOneSymbol = scan.next();
        playerTwoSymbol = scan.next();
        angel = scan.nextBoolean();
        fontSize = scan.nextInt();
        System.out.println(resolution);
        for(int i = 0; i < resolution; i++) {
        	for(int x = 0; x < resolution; x++) {
		      buttons[i][x] = new JButton("");
		        buttons[i][x].setHorizontalTextPosition(JButton.CENTER);
		        buttons[i][x].setVerticalTextPosition(JButton.CENTER);
		        if(angel) {
		        	buttons[i][x].setOpaque(false);
		        	buttons[i][x].setContentAreaFilled(false);
		        	buttons[i][x].setBorderPainted(true);		        	
		        }
		        else {
		        	ImageIcon ic = new ImageIcon(icon);
			        buttons[i][x].setIcon(ic);
		        }
		    	  buttons[i][x].setFont(new Font("Arial", Font.PLAIN, fontSize));
        }
        }
	}

	}
