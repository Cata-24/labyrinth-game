package boygirl.model.elements;

public class Arrow extends Element {
    private String direction;

    public Arrow(int x, int y, String color, String direction) {
        super(x,y,color);
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public void invert() {
        switch (getDirection()) {
            case "up" -> this.direction = "down";
            case "down" -> this.direction = "up";
            case "left" -> this.direction = "right";
            case "right" -> this.direction = "left";
        }
    }

    @Override
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass()) return false;

        return(this == o ||
                this.getPosition().equals(((Arrow) o).getPosition()));

    }

}
