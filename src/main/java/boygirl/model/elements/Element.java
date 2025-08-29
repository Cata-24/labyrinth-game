package boygirl.model.elements;

import boygirl.model.Position;

public abstract class Element {
    private Position position;
    private String color;

    Element(int x, int y, String color) {
        this.position = new Position(x, y);
        this.color = color;
    }

    public Position getPosition() {return position;}

    public void setPosition(Position position) {this.position = position;}

    public int getX() {return getPosition().getX();}

    public int getY() {return getPosition().getY();}

    public void setX(int x) {getPosition().setX(x);}

    public void setY(int y) {getPosition().setY(y);}

    public Position moveUp() {
        return new Position(getX(), getY() - 1);
    }

    public Position moveDown() {
        return new Position(getX(), getY() + 1);
    }

    public Position moveLeft() {
        return new Position(getX() - 1, getY());
    }

    public Position moveRight() {
        return new Position(getX() + 1, getY());
    }

    public String getColor() {return color;}
}
