package model;

public class Square {
    private final int size;
    private int posX, posY;
    private final int boundX, boundY;

    public Square(int size, int boundX, int boundY) {
        this.size = size;
        this.boundX = boundX;
        this.boundY = boundY;
        this.posX = 0;
        this.posY = 0;
    }
    
    
    public void setPosX(int posX) {
        this.posX = posX > boundX - (size/2) || posX < (size/2) ? 
                this.posX :  posX;
    }

    public void setPosY(int posY) {
        this.posY = posY > boundY - (size/2) || posY < (size/2) ? 
                this.posY :  posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getSize() {
        return size;
    }
}
