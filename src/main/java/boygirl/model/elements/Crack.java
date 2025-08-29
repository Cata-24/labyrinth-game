package boygirl.model.elements;

public class Crack extends Element {
    private boolean safe;

    public Crack(int x, int y, String color, boolean safe) {
        super(x,y,color);
        this.safe = safe;
    }

    public boolean isSafe() {
        return safe;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass()) return false;

        return(this == o ||
                this.getPosition().equals(((Crack) o).getPosition()));

    }
}
