package control;

import model.Square;

public class ResetCommand implements Command {
    private final Square square;

    public ResetCommand(Square square) {
        this.square = square;
    }
    
    @Override
    public void execute() {
        square.setPosX(0);
        square.setPosY(0);
    }
    
}
