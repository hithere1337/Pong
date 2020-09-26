import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player implements Runnable {
	int x, y, yDirection, count;
	Rectangle paddle;

	public Player(int x, int y, int count){
		this.x = x;
		this.y = y;
		this.count = count;
		paddle = new Rectangle(x, y, 10, 50);
	}

	public void keyPressed(KeyEvent e) {
		switch(count) {
		default:
			System.out.println("Please enter a Valid ID in paddle contructor");
			break;
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W) {
				setYDirection(-2);
			}
			if(e.getKeyCode() == KeyEvent.VK_S) {
					setYDirection(2);
			}
			break;
		case 2:
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(-2);
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(2);
			}
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch(count) {
		default:
			System.out.println("Please enter a Valid ID in paddle contructor");
			break;
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W) {
				setYDirection(0);
			}
			if(e.getKeyCode() == KeyEvent.VK_S) {
				setYDirection(0);
			}
			break;
		case 2:
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(0);
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(0);
			}
			break;
		}
	}
	
	public void setYDirection(int yDir) {
		yDirection = yDir;
	}

	public void move() {
		paddle.y += yDirection;
//		if(StdDraw.isKeyPressed(up1)) {
//			
//		}
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


