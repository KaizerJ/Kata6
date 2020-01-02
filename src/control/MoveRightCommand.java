package control;

import model.Square;
import view.Point;

public class MoveRightCommand implements Command{
    private final Square square;

    public MoveRightCommand(Square square) {
        this.square = square;
    }
    
    @Override
    public void execute() {
        square.setPos(new Point(square.getPosX() + square.getBoundX()/10,
                                square.getPosY()));
    }
    
}
