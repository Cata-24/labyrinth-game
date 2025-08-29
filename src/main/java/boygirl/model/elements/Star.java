package boygirl.model.elements;

public class Star extends Element {
    public Star(int x, int y, String color) {super(x,y,color);}

    @Override
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass()) return false;

        return(this == o ||
                this.getPosition().equals(((Star) o).getPosition()));

    }
}
