package control;

import model.Square;
import view.Point;

public class MoveUpCommand implements Command {
    private final Square square;

    public MoveUpCommand(Square square) {
        this.square = square;
    }
    
    @Override
    public void execute() {
        square.setPos(new Point(square.getPosX(),
                                square.getPosY() + square.getBoundY()/10));
    }
    
}
