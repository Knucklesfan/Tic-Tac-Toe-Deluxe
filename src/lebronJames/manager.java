package lebronJames;


import java.util.Random;

import javax.swing.JOptionPane;

public class manager {
	private static int b = 0;
	private static int c = 0;
	public static void ComputerRound() {
		checkWin();
		getRandomEmpty();
		checkWin();

	}

	public static void checkWin() {
		//note to self; this code is written as the vertical checker. Probably could put this in it's own method but whatever.
		for(int i = 0; i < main.resolution; i++) {
			for(int x = 0; x < main.resolution; x++) {
			if(main.buttons[i][x].getText().equals(main.playerOneSymbol)) {
				b++;
			}
			if(main.buttons[i][x].getText().equals(main.playerTwoSymbol)) {
				c++;
			}

			}
			if(b == main.resolution) {
				System.out.println("itaz");

				Player1Win();
			}
			if(c == main.resolution) {
				System.out.println("itgg");

				Player2Win();
			}
			b = 0;
			c = 0;

		}
		b = 0;
		c = 0;

		for(int i = 0; i < main.resolution; i++) {
			for(int x = 0; x < main.resolution; x++) {
			if(main.buttons[x][i].getText().equals(main.playerOneSymbol)) {
				b++;
			}
			if(main.buttons[x][i].getText().equals(main.playerTwoSymbol)) {
				c++;
			}

			}
			if(b == main.resolution) {
				System.out.println("rit");

				Player1Win();
			}
			if(c == main.resolution) {
				System.out.println("iat");

				Player2Win();
			}
			else {
			b = 0;
			c = 0;
			}

		}
		b = 0;
		c = 0;

		for(int i = 0; i < main.resolution; i++) {
			if(main.buttons[i][i].getText().equals(main.playerOneSymbol)) {
				b++;
			}
			if(main.buttons[i][i].getText().equals(main.playerTwoSymbol)) {
				c++;
			}

			}
			if(b == main.resolution) {
				System.out.println("hit");

				Player1Win();
			}
			if(c == main.resolution) {
				System.out.println("sit");

				Player2Win();
			}
			b = 0;
			c = 0;

			int x = 0;
			for(int i = main.resolution - 1; i >= 0; i--) {
				
				System.out.println(main.buttons[x][i].getText() + " " + i);
				if(main.buttons[x][i].getText().equals(main.playerOneSymbol)) {
					b++;
				}
				if(main.buttons[x][i].getText().equals(main.playerTwoSymbol)) {
					c++;
				}
				x++;
				if(b == main.resolution) {
					System.out.println("it");
					Player1Win();
				}
				if(c == main.resolution) {
					System.out.println("bit");

					Player2Win();
				}
			}
			b = 0;
			c = 0;



		if(!checkRandomEmpty()) {
			Tie();
		}
		}

	private static void Tie() {
        Object[] options = {"Yes",
        "No"};
        int player = JOptionPane.showOptionDialog(null,
        		"Tie! Play again?",
        		"Tic Tac Toe Deluxe",
        		JOptionPane.YES_NO_OPTION,
        		JOptionPane.QUESTION_MESSAGE,
        		null,     //do not use a custom Icon
        		options,  //the titles of buttons
        		options[0]); //default button title
        if(player == 0) {
    		main.window.setVisible(false);
    		main.window.dispose();
    		if(!main.theme_maker) {
    		main.softRefresh();     
    		}
    		else {
    			main.theme_maker = false;
    			main.main(null);
    		}
}
        else {
        	System.exit(0);
        }

	}

	private static void Player2Win() {
		// TODO Auto-generated method stub
		c = 0;
		b = 0;
        Object[] options = {"Yes",
        "No"};
        int player = JOptionPane.showOptionDialog(null,
        		"Player Two wins! Play again?",
        		"Tic Tac Toe Deluxe",
        		JOptionPane.YES_NO_OPTION,
        		JOptionPane.QUESTION_MESSAGE,
        		null,     //do not use a custom Icon
        		options,  //the titles of buttons
        		options[0]); //default button title
        if(player == 0) {
    		main.window.setVisible(false);
    		main.window.dispose();
    		if(!main.theme_maker) {
    		main.softRefresh();     
    		}
    		else {
    			main.theme_maker = false;
    			main.main(null);
    		}
        }
        else {
        	System.exit(0);
        }
		
	}

	private static void Player1Win() {
		// TODO Auto-generated method stub
        Object[] options = {"Yes",
        "No"};
        int player = JOptionPane.showOptionDialog(null,
        		"Player One wins! Play again?",
        		"Tic Tac Toe Deluxe",
        		JOptionPane.YES_NO_OPTION,
        		JOptionPane.QUESTION_MESSAGE,
        		null,     //do not use a custom Icon
        		options,  //the titles of buttons
        		options[0]); //default button title
        if(player == 0) {
    		main.window.setVisible(false);
    		main.window.dispose();
    		if(!main.theme_maker) {
    		main.softRefresh();     
    		}
    		else {
    			main.theme_maker = false;
    			main.main(null);
    		}
        }
        else {
        	System.exit(0);
        }
	}

	private static void getRandomEmpty() {
		int c = 0;
		int d = 0;
		int sqar = main.resolution * main.resolution;
		Random ran = new Random();
		
		for(int i = 0; i < sqar; i++) {
			c = ran.nextInt(main.resolution);
			d = ran.nextInt(main.resolution);
			if(main.buttons[c][d].getText().equals("")){
				main.buttons[c][d].setForeground(main.playerTwo);
				main.buttons[c][d].setText(main.playerTwoSymbol);
				return;
			}
		}
		getRandomEmpty();
	}
	private static boolean checkRandomEmpty() {
		for(int i = 0; i < main.resolution; i++) {
			for(int x = 0; x < main.resolution; x++) {
			if(main.buttons[i][x].getText().equals("")){
				return true;
			}
			}
		}
		return false;
	}
	}
