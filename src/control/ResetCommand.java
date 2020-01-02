package control;

import model.Square;
import view.Point;

public class ResetCommand implements Command {
    private final Square square;

    public ResetCommand(Square square) {
        this.square = square;
    }
    
    @Override
    public void execute() {
        square.setPos(new Point(square.getBoundX()/2,square.getBoundY()/2));
    }
    
}
