package lebronJames;

import java.awt.*;
import java.util.*;
import java.util.Timer;
import java.util.*;

import javax.swing.*;


public class CreditMving {
	public static int x = 0;
	private static Timer timer = new Timer();
	   private static class HelloWorldDisplay extends JPanel {
		   	private double angle;
			public HelloWorldDisplay() {
	              timer.schedule(task, 0, 5);
		   	}
		      public void paintComponent(Graphics g) {
		    	  
		         super.paintComponent(g);
		         GradientPaint gp = new GradientPaint(0, 0, Color.pink, 0, 550, Color.orange);
		         Graphics2D gb = (Graphics2D) g;
		         gb.setPaint(gp);
		         gb.fillRect(0, 0, 550, 550);
		         gb.setColor(Color.BLACK);
		         gb.rotate(angle, 0 ,0);
		         gb.setFont(new Font("Arial", Font.PLAIN, 40));
		         gb.drawString("Tic Tac Toe DELUXE",x,70);
		         gb.setFont(new Font("Arial", Font.PLAIN, 20));
		         gb.drawString("Created by Knucklesfan",250,100);
		         gb.setFont(new Font("Arial", Font.PLAIN, 10));

		         gb.drawString("Vers " + main.version,0,170);

		         gb.rotate(-Math.toRadians(angle));
		         g.finalize();

		      }
		      TimerTask task = new TimerTask() {
		          @Override
		          public void run() {
			        	  x++;
		        	  if(x == 555) {
		        		  x = -400;
		        		  }
		        	  repaint();
		          }
		   };
	   }
	   public static void showCreds() { 
		      HelloWorldDisplay displayPanel = new HelloWorldDisplay();
		      JFrame window = new JFrame("Tic Tac Toe Deluxe: CREDITS");
		      window.add(displayPanel);
		      window.setSize(550,200);
		      window.setResizable(false);
		      window.setLocationRelativeTo(null);
		      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      window.setVisible(true);

	   }
}
