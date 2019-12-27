package control;

import model.Square;

public class MoveUpCommand implements Command {
    private final Square square;

    public MoveUpCommand(Square square) {
        this.square = square;
    }
    
    @Override
    public void execute() {
        square.setPosY(square.getPosY() + 5);
    }
    
}
