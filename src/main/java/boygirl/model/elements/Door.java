package boygirl.model.elements;

public class Door extends Element {
    private boolean open;
    private String color;

    public Door(int x, int y, String color) {
        super(x,y,color);
        open = false;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass()) return false;

        return(this == o ||
                this.getPosition().equals(((Door) o).getPosition()));

    }

}
