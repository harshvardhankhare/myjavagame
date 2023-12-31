package Main;

import java.awt.*;
//import java.awt.event.*; 
//import java.awt.event.KeyListener;
//import java.awt.EventListener ;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;
import inputs.MouseInputs;
import inputs.keyboardInputs;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private float xDir = 1f, yDir = 1f;
    private Color color = new Color(150, 20, 90);
    private Random random;

    //temp
    private ArrayList<MyRect> rects = new ArrayList<>();
    
    public GamePanel() {
        random = new Random();
        setFocusable(true);
        mouseInputs = new MouseInputs(this);
        addKeyListener(new keyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }
    public void changeXDelta(int value) {
		this.xDelta += value;
		
	}

	public void changeYDelta(int value) {
		this.yDelta += value;
		
	}
    public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
		
	}
	public void spawnRect(int x, int y) {
		rects.add(new MyRect(x, y));
	}


    public void paintComponent(Graphics g) {


        super.paintComponent(g);


  	for (MyRect rect : rects) {
			rect.updateRect();
			rect.draw(g);
		}

		updateRectangle();

		g.setColor(color);
		g.fillRect((int) xDelta, (int) yDelta, 200, 50);
    }
    private void updateRectangle() {
		xDelta += xDir;
		if (xDelta > 400 || xDelta < 0) {
			xDir *= -1;
			color = getRndColor();
		}

		yDelta += yDir;
		if (yDelta > 400 || yDelta < 0) {
			yDir *= -1;
			color = getRndColor();
		}
	}
    private Color getRndColor() {
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);

		return new Color(r, g, b);
	}
    public class MyRect {
		int x, y, w, h;
		int xDir = 1, yDir = 1;
		Color color;

		public MyRect(int x, int y) {
			this.x = x;
			this.y = y;
			w = random.nextInt(50);
			h = w;
			color = newColor();
		}

		public void updateRect() {
			this.x += xDir;
			this.y += yDir;

			if ((x + w) > 400 || x < 0) {
				xDir *= -1;
				color = newColor();
			}
			if ((y + h) > 400 || y < 0) {
				yDir *= -1;
				color = newColor();
			}

		}

		private Color newColor() {
			return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		}

		public void draw(Graphics g) {
			g.setColor(color);
			g.fillRect(x, y, w, h);
		}

	}
}
