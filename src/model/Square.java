package model;

import presenter.Observer;
import java.util.ArrayList;
import java.util.List;
import view.Point;

public class Square {
    private final int size;
    private int posX, posY;
    private final int boundX, boundY;
    private final List<Observer> observers = new ArrayList<>();
    
    public Square(int size, int boundX, int boundY) {
        this.size = size;
        this.boundX = boundX;
        this.boundY = boundY;
        this.posX = boundX/2;
        this.posY = boundX/2;
    }
    
    public void setPos(Point point){
        setPosX(point.getX());
        setPosY(point.getY());
        updateObservers();
    }
    
    private void setPosX(int posX) {
        this.posX = posX > boundX - (size/2) || posX < (size/2) ? 
                this.posX :  posX;
    }

    private void setPosY(int posY) {
        this.posY = posY > boundY - (size/2) || posY < (size/2) ? 
                this.posY :  posY;
    }

    public Point getPos(){
        return new Point(getPosX(),getPosY());
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

    public int getBoundX() {
        return boundX;
    }

    public int getBoundY() {
        return boundY;
    }

    public void add(Observer observer) {
        this.observers.add(observer);
    }

    private void updateObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
