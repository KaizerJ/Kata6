package view;

public interface SquareDisplay {
    
    public void show(Point point);
    public void add(SquareDisplay.Listener listener);
    
    public interface Listener{
        
        public void newPosition(Point point);
    }
}
