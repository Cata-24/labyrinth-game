package boygirl.model.general;

import boygirl.model.elements.Boy;
import boygirl.model.elements.Girl;
import boygirl.model.elements.Monster;
import boygirl.model.elements.Wall;

import java.io.IOException;
import java.util.List;

public class Menu extends OutModel{

    public Menu(String filename) throws IOException {super(filename);}

    @Override
    public Boy getBoy() {
        if (boy == null) return new Boy(25, 8, "#0000FF");
        else return boy;
    }

    @Override
    public Girl getGirl() {
        if (girl == null) return new Girl(25, 11, "#FFC0CB");
        else return girl;
    }

    public boolean goGameplay() {
        return (getBoy().getX() == 41 && getGirl().getX() == 41 &&
                getBoy().getY() == 8 && getGirl().getY() == 11);
    }

    public boolean continueGameplay() {
        return (getBoy().getX() == 11 && getGirl().getX() == 11 &&
                getBoy().getY() == 8 && getGirl().getY() == 11);
    }
}
