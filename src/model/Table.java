package model;

    //Sería lo correcto con Square como clase interna pero los bounds ya los tiene el square
public class Table {
    private final int height, width;
    private final Square square;

    public Table(int height, int width, Square square) {
        this.height = height;
        this.width = width;
        this.square = square;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Square getSquare() {
        return square;
    }
}
