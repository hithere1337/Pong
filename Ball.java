import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Ball implements Runnable {
	int x, y, xDirection, yDirection;
	int p1score, p2score;
	Player p1 = new Player(10, 25, 1);
//	Player p2 = new Player(485, 25, 2);                                     //Uncomment for 2-player
	Computer comp = new Computer(485, 25, 2);                               //Uncomment for 1-player
	Rectangle ball;

	public Ball(int x, int y) {
		p1score = p2score = 0;
		this.x = x;
		this.y = y;

		//Set ball moving randomly
		Random r = new Random();
		int rXDir = r.nextInt(1);
		if (rXDir == 0)
			rXDir-=2;
		setXDirection(rXDir);

		int rYDir = r.nextInt(1);
		if (rYDir == 0)
			rYDir-=2;
		setYDirection(rYDir);

		//create "ball"
		ball = new Rectangle(this.x, this.y, 10, 10);
	}

	public void setXDirection(int xDir) {
		xDirection = xDir;
	}
	public void setYDirection(int yDir) {
		yDirection = yDir;
	}

	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(ball.x, ball.y, ball.width, ball.height);
	}

	public void collision() {
		if(ball.intersects(p1.paddle)) {
			setXDirection(+2);
		}
//		if(ball.intersects(p2.paddle)) {                                    //Uncomment for 2-player
//			setXDirection(-2);
//		}
		if(ball.intersects(comp.paddle)) {                                  //Uncomment for 1-player
			setXDirection(-2);
		}
	}	
	
	public void move() {
		collision();
		ball.x += xDirection;
		ball.y += yDirection;
		
		//bounce
		if (ball.x <= 0) {			   //p2 scores
			setXDirection(+2);
			p2score++;
		}
		if (ball.x >= 485) {           //p1 scores
			setXDirection(-2);
			p1score++;
		}
		if (ball.y <= 15) {
			setYDirection(+2);
		}
		if (ball.y >= 385) {
			setYDirection(-2);
		}
	}

	@Override
	public void run() {
		try {
			while(true) {
				move();
//				System.out.println("Ball Location: ("+ball.x+", "+ball.y+")"); 		//DEBUG: Output ball location
				Thread.sleep(8);
			}
		}
		catch(Exception e) { 
			System.err.println(e.getMessage()); 
		}
	}
	
	public int getX() {
		return ball.x;
	}
	
	public int getY() {
		return ball.y;
	}
}