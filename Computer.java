import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Computer implements Runnable {
	int x, y, yDirection, count;
	Rectangle paddle;

	public Computer(int x, int y, int count){
		this.x = x;
		this.y = y;
		this.count = count;
		paddle = new Rectangle(x, y, 10, 50);
	}
	
	public void setYDirection(int yDir) {
		yDirection = yDir;
	}

	public void move() {
		Ball ball = World.b;
		paddle.y = ball.getY()-15;
		
//		System.out.println(paddle.y);                          //DEBUG: print computer paddle location
		if (paddle.y <= 15) {
			paddle.y = 15;
		}	
		if (paddle.y >= 340) {
			paddle.y = 340;
		}
		
	}
	
	public void draw(Graphics g) {
		switch(count) {
		default:
			System.out.println("Please enter a Valid ID in paddle contructor");
			break;
		case 1:
			g.setColor(Color.white);
			g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
			break;
		case 2:
			g.setColor(Color.white);
			g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
			break;
		}
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				move();
				Thread.sleep(7);
			}
		} 
		catch(Exception e) { 
			System.err.println(e.getMessage()); 
		}
	}
}


