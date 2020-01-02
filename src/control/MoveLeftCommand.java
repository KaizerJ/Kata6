package control;

import model.Square;
import view.Point;

public class MoveLeftCommand implements Command{
    private final Square square;

    public MoveLeftCommand(Square square) {
        this.square = square;
    }
    
    @Override
    public void execute() {
        square.setPos(new Point(square.getPosX() - square.getBoundX()/10,
                                square.getPosY()));
    }
    
}
