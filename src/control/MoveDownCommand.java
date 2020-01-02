package control;

import model.Square;
import view.Point;

public class MoveDownCommand implements Command{
    private final Square square;

    public MoveDownCommand(Square square) {
        this.square = square;
    }
    
    @Override
    public void execute() {
        square.setPos(new Point(square.getPosX(),
                                square.getPosY() - square.getBoundY()/10));
    }
    
}
