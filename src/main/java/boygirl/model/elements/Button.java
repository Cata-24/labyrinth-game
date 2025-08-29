package boygirl.model.elements;

public class Button extends Element {
    private long lastcheck = 0;
    private boolean open;
    private long time;

    public Button(int x, int y, long time, String color) {
        super(x,y,color);
        this.time = time;
        open = false;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public long getTime() {return time;}

    public long getLastcheck () {return lastcheck;}
    public void setLastcheck(long lastcheck) {this.lastcheck = lastcheck;}

    @Override
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass()) return false;

        return(this == o ||
                this.getPosition().equals(((Button) o).getPosition()));

    }
}
