package boygirl.model.elements;

public class Heart extends Element {

    public Heart(int x, int y, String color) {super(x,y,color);}

    @Override
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass()) return false;

        return(this == o ||
                this.getPosition().equals(((Heart) o).getPosition()));

    }

}
