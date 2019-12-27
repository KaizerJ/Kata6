package control;

import model.Square;

public class MoveRightCommand implements Command{
    private final Square square;

    public MoveRightCommand(Square square) {
        this.square = square;
    }
    
    @Override
    public void execute() {
        square.setPosX(square.getPosX() + 5);
    }
    
}
