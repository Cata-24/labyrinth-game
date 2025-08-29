package boygirl.model.elements;

import boygirl.model.Position;

public class Checkpoint extends Element {

    public Checkpoint(int x, int y, String color) {super(x ,y, color);}

    public boolean getAround(Position pos) {
        return Math.abs(getX() - pos.getX()) <= 1 && Math.abs(getY() - pos.getY()) <= 1;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass()) return false;

        return(this == o ||
                this.getPosition().equals(((Checkpoint) o).getPosition()));

    }
}
