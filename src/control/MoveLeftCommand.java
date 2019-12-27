package control;

import model.Square;

public class MoveLeftCommand implements Command{
    private final Square square;

    public MoveLeftCommand(Square square) {
        this.square = square;
    }
    
    @Override
    public void execute() {
        square.setPosX(square.getPosX() - 5);
    }
    
}
