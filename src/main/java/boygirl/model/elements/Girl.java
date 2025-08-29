package boygirl.model.elements;

import boygirl.model.Position;

public class Girl extends Element {
    private Position respawn;
    private int lives;

    public Girl(int x, int y, String color) {
        super(x, y, color);
        this.respawn = getPosition();
        this.lives = 3;
    }

    private Position getRespawn() {
        return respawn;
    }

    public int getLives() {return lives;}

    public void catchHeart() {
        this.lives++;
    }

    public void setRespawn(Position respawn) {
        this.respawn = respawn;
    }

    public void respawn() {
        setPosition(getRespawn());
        this.lives--;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass()) return false;

        return(this == o ||
                this.getPosition().equals(((Girl) o).getPosition()));

    }

}
