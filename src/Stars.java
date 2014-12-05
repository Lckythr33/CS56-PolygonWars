import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

	public class Stars extends JPanel
	{
			static int n = 0;
			
			private static int[] threeSidesX = {35, 50, 65};
			private static int[] threeSidesY = {70, 30, 70};
			
			private static int[] fourSidesX = {40, 20, 40, 60};
			private static int[] fourSidesY = {20, 80, 50, 80};
			
			private static int[] fiveSidesX = {25, 50, 75, 75, 25};
			private static int[] fiveSidesY = {20, 40, 20, 60, 60};
			
			private static int[] sixSidesX = {50, 50, 80, 50, 20, 20};
			private static int[] sixSidesY = {20, 50, 50, 80, 80, 50};
			
			private static int[] sevenSidesX = {20, 50, 50, 70, 100, 70, 50};
			private static int[] sevenSidesY = {50, 50, 20, 50, 50, 80, 80};
			
			private static int[] eightSidesX = {20, 50, 50, 75, 95, 75, 50, 20};
			private static int[] eightSidesY = {70, 45, 25, 45, 45, 70, 70, 100};
			
			private static int[] nineSidesX = {20, 45, 70, 55, 90, 80, 65, 75, 55};
			private static int[] nineSidesY = {100, 30, 10, 35, 45, 75, 85, 60, 55};
			
			private static int[] tenSidesX = {20, 20, 40, 70, 70, 90, 60, 50, 40, 40};
			private static int[] tenSidesY = {60, 40, 40, 10, 40, 40, 55, 75, 60, 90};
		
			private static int[] elevenSidesX = {20, 20, 40, 30, 70, 70, 90, 60, 50, 40, 40};
			private static int[] elevenSidesY = {60, 40, 40, 25, 10, 40, 40, 55, 75, 60, 90};
			
			private static int[] twelveSidesX = {20, 20, 40, 30, 55, 70, 70, 90, 60, 50, 40, 40};
			private static int[] twelveSidesY = {60, 40, 40, 25, 35, 10, 40, 40, 55, 75, 60, 90};
			
			private static int[] thirteenSidesX = {20, 20, 40, 30, 55, 70, 70, 90, 75, 60, 50, 40, 40};
			private static int[] thirteenSidesY = {60, 40, 40, 25, 35, 10, 40, 40, 80, 55, 75, 60, 90};
		
			
			public static void main (String[] args)
			{
		        String nString = JOptionPane.showInputDialog("Enter the number of sides for the polygon (3-10)");
		        n = Integer.parseInt(nString);
		     
				JFrame jf = new JFrame();
				jf.setVisible(true);
				jf.setSize(120,180);
				jf.setLocation(600, 400);
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				Stars rpp = new Stars();
				
				jf.add(rpp);
				rpp.setVisible(true);
		        
			}
			
			
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				
				if(n == 3)
				{
					g.setColor(Color.RED);	
					g.fillPolygon(threeSidesX, threeSidesY , 3);
				}
				
				else if(n == 4)
				{
					g.setColor(Color.GREEN);	
					g.fillPolygon(fourSidesX, fourSidesY , 4);
				}
				
				else if(n == 5)
				{
					g.setColor(Color.YELLOW);	
					g.fillPolygon(fiveSidesX, fiveSidesY , 5);
				}
				
				else if(n == 6)
				{
					g.setColor(Color.BLUE);	
					g.fillPolygon(sixSidesX, sixSidesY , 6);
				}
				
				else if(n == 7)
				{
					g.setColor(Color.BLACK);	
					g.fillPolygon(sevenSidesX, sevenSidesY , 7);
				}
				
				else if(n == 8)
				{
					g.setColor(Color.ORANGE);	
					g.fillPolygon(eightSidesX, eightSidesY , 8);
				}
				
				else if(n == 9)
				{
					g.setColor(Color.CYAN);	
					g.fillPolygon(nineSidesX, nineSidesY , 9);
				}
				
				else if(n == 10)
				{
					g.setColor(Color.GRAY);	
					g.fillPolygon(tenSidesX, tenSidesY , 10);
				}
				
				else if(n == 11)
				{
					g.setColor(Color.PINK);	
					g.fillPolygon(elevenSidesX, elevenSidesY , 11);
				}
				
				else if(n == 12)
				{
					g.setColor(Color.DARK_GRAY);	
					g.fillPolygon(twelveSidesX, twelveSidesY , 12);
				}
				
				else if(n == 13)
				{
					g.setColor(Color.LIGHT_GRAY);	
					g.fillPolygon(thirteenSidesX, thirteenSidesY , 13);
				}
				
			}
		}

