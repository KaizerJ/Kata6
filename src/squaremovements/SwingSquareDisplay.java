package squaremovements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import view.Point;
import view.SquareDisplay;

public class SwingSquareDisplay extends JPanel implements SquareDisplay {
    private Point point;
    private final int squareSize;
    private final List<Listener> listeners = new ArrayList<>();
    private boolean grabbed = false;

    public SwingSquareDisplay(int squareSize, int width, int height) {
        this.squareSize = squareSize;
        this.point = new Point(squareSize/2,squareSize/2);
        this.addMouseListener(mouseListener());
        this.addMouseMotionListener(motionListener());
        setPreferredSize(new Dimension(width, height));
    }
    
    
    @Override
    public void show(Point point) {
        this.point = point;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.fillRect(point.getX() - (squareSize/2), point.getY() - (squareSize/2), 
                squareSize, squareSize);
    }

    
    
    @Override
    public void add(Listener listener) {
        listeners.add(listener);
    }

    private MouseListener mouseListener() {
        return new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                if(isTouching(me.getX(), me.getY())) grabbed = true;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                grabbed = false;
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
            
        };
    }
    
    private boolean isTouching(int x, int y){
        boolean v = isInside(point, new Point(x,y), squareSize);
        System.out.println(v);
        return v;
    }

    private boolean isInside(Point pos, Point location, int range) {
        return Math.abs(pos.getX() - location.getX()) <= range/2 &&
                Math.abs(pos.getY() - location.getY()) <= range/2 ;
    }

    private MouseMotionListener motionListener() {
        return new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent me) {
                if (!grabbed) return;
                for (Listener listener : listeners) {
                    listener.newPosition(new Point(me.getX(), me.getY()));
                }
            }

            @Override
            public void mouseMoved(MouseEvent me) {
            }
            
        };
    }
    
}
