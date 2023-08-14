package inputs;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Main.GamePanel;

public class MouseInputs implements MouseListener, MouseMotionListener{

    private GamePanel gamePanel;
	public MouseInputs(GamePanel gamePanel) {
		this.gamePanel= gamePanel;
	}
    @Override
    public void mouseDragged(MouseEvent e) {
        
//throw new UnsupportedOperationException("Unimplemented method 'mouseDragged'");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
        gamePanel.setRectPos(e.getX(), e.getY());

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        System.out.println("mouse clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
       // throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {

       // throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
        //throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
      //  throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
    
}
