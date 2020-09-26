import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;


public class World extends JFrame {
	int width = 500;
	int height = 400;
	Dimension screenSize = new Dimension(width, height);
	Image image;
	Graphics graphics;
	static Ball b = new Ball(250, 200);
	
	public World() {
		this.setTitle("Pong");
		this.setSize(screenSize);
		this.setResizable(false);
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(new AL());
	}
	
	public static void main(String[] args) {
		World world = new World();
		
		Thread ball = new Thread(b);
		ball.start();
		Thread p1 = new Thread(b.p1);
//		Thread p2 = new Thread(b.p2);                             //uncomment for 2-player
//		p2.start();                                               //uncomment for 2-player
		Thread computer = new Thread(b.comp);                     //uncomment for 1-player
		p1.start();
		computer.start();                                         //uncomment for 1-player
		
	}
	
	@Override
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}
	
	public void draw(Graphics g) {
		b.draw(g);
		b.p1.draw(g);
//		b.p2.draw(g);                                             //uncomment for 2-player
		b.comp.draw(g);                                           //uncomment for 1-player
		
		g.setColor(Color.WHITE);
		g.drawString((new Integer(b.p1score)).toString(), 50, 50);
		g.drawString(""+b.p2score, 430, 50);
		
		repaint();
	}
	
	public class AL extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			b.p1.keyPressed(e); 
//			b.p2.keyPressed(e);                                   //uncomment for 2-player   
		}
		@Override
		public void keyReleased(KeyEvent e) {
			b.p1.keyReleased(e);
//			b.p2.keyReleased(e);                                  //uncomment for 2-player
		}
	}
}
