package control;

import model.Square;

public class MoveDownCommand implements Command{
    private final Square square;

    public MoveDownCommand(Square square) {
        this.square = square;
    }
    
    @Override
    public void execute() {
        square.setPosY(square.getPosY() - 5);
    }
    
}
