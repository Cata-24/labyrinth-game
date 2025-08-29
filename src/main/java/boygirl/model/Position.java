package boygirl.model;

public class Position {
    private int x;
    private int y;

    public Position(int a, int b) {x = a; y = b;}
    public int getX() {return x;}
    public int getY() {return y;}
    public void setX(int a) {x = a;}
    public void setY(int b) {y = b;}

    @Override
    public boolean equals(Object o) {
        if(o == null || o.getClass() != this.getClass()) return false;

        return (this == o) ||
                (this.x == ((Position) o).x && this.y == ((Position) o).y);
    }
}
