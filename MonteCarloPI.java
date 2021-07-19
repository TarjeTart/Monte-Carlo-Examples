import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/*
Monte Carlo of PI:
circle area/square area = pi*r^2/4r^2 = pi/4
pi = 4*circle area/square area = 4*simulation
*/

public class Main extends JFrame implements ActionListener{

	boolean paint = false;
	
	ArrayList<vec> points = new ArrayList<vec>();
	
	JPanel p = new JPanel();
	JPanel p2 = new JPanel();
	
	JTextField input = new JTextField("Enter number of dots",60);
	
	JButton b = new JButton("Start");
	
	int circleHits = 0;
	int dots = 1;
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {

		super("Monte Carlo Pi Simulation");
		
		setResizable(false);
		
		setSize(700,500);
		input.setSize(new Dimension(400,50));
		input.setMinimumSize(new Dimension(400,50));
		b.setSize(new Dimension(100,150));
		b.setFont(new Font("Arial",Font.PLAIN, 30));
		
		b.addActionListener(this);
		p.add(input);
		p.add(b);
		add(p);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		p.setVisible(false);
		p2.setVisible(true);
		paint = true;
		
		setSize(400,424);
		
		dots = Integer.valueOf(input.getText());
		
		for(int i = 1; i <= dots; i++) {
			vec point = vec.random(.5,.5,0);
			points.add(point);
			if(point.mag() < .5) {
				circleHits++;
			}
			Graphics g = getGraphics();
			g.setColor(Color.RED);
			g.drawOval(7, 32, 385, 385);
			g.setColor(Color.BLACK);
			g.fillOval(7+(int)((385)*(.5+point.x)), 32+(int)((385)*(.5+point.y)), 3, 3);
			if(i%25==0) {
				g.clearRect(352, 360, 50, 40);
				g.drawRect(352, 360, 50, 40);
				g.drawString(Double.toString((4)*((double)circleHits/i)), 357, 375);
				g.drawString(Integer.toString(i), 357, 390);
			}
			synchronized(this) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		if(!paint)
			return;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
		g2d.drawOval(7, 32, 385, 385);
		g2d.setColor(Color.BLACK);
        for(vec i : points) {
        	g2d.fillOval(7+(int)((385)*(.5+i.x)), 32+(int)((385)*(.5+i.y)), 3, 3);
        }
        g2d.clearRect(352, 360, 50, 40);
		g2d.drawRect(352, 360, 50, 40);
		g2d.drawString(Double.toString((4)*((double)circleHits/dots)), 357, 375);
		g2d.drawString(Integer.toString(dots), 357, 390);
    }

}
