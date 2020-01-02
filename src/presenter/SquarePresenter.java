package presenter;

import model.Square;
import view.Point;
import view.SquareDisplay;

public class SquarePresenter implements Observer{
    public final static Point ScreenSize = new Point(400,400);
    private Square square;
    private SquareDisplay squareDisplay;

    public SquarePresenter(Square square, SquareDisplay squareDisplay) {
        this.square = square;
        this.squareDisplay = squareDisplay;
        this.square.add(this);
        this.squareDisplay.add(new SquareDisplay.Listener() {
            @Override
            public void newPosition(Point point) {
                square.setPos(ScreenToModel(point));
                update();
            }
        });
    }
    
    
    
    @Override
    public void update() {
        squareDisplay.show(modelToScreen(square.getPos()));
    }
    
    public Point modelToScreen(Point p){
        return new Point(
            p.getX() * ScreenSize.getX() / square.getBoundX(),
            (square.getBoundY() - p.getY()) * ScreenSize.getY() / square.getBoundY()
        );
    }
    
    public Point ScreenToModel(Point p){
        return new Point(
                p.getX() * square.getBoundX() / ScreenSize.getX(),
                (square.getBoundY() - p.getY()) * square.getBoundY() / ScreenSize.getY()
        );
    }
}
