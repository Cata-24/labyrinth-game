package boygirl.controler.game;

import boygirl.Game;
import boygirl.controler.general.GameplayController;
import boygirl.guihelp.LanternaGui;
import boygirl.model.Position;
import boygirl.model.elements.*;
import boygirl.model.general.Gameplay;

import java.util.ArrayList;
import java.util.List;

public class GirlGameController extends GameplayController {
    public GirlGameController(Gameplay outModel) {
        super(outModel);
    }

    public void run(Game game, LanternaGui.input input, long time) {
        switch (input) {
            case wup -> move(getOutModel().getGirl().moveUp());
            case sdown -> move(getOutModel().getGirl().moveDown());
            case aleft -> move(getOutModel().getGirl().moveLeft());
            case dright -> move(getOutModel().getGirl().moveRight());
        }

        checkp();
        hearts();
        stars();

        if (die()) {
            getOutModel().getGirl().respawn();
        }
    }

    private void move(Position position) {
        if (check(position)) getOutModel().getGirl().setPosition(position);
    }

    private boolean check(Position position) {
        if (getOutModel().getWalls().contains(new Wall(position.getX(), position.getY(), "#FFFFFF"))) {
            return false;
        }

        for (Door door: getOutModel().getDoors()) {
            if (door.getPosition().equals(position) && !door.isOpen()) return false;
        }

        return true;
    }

    private boolean die() {
        Position position = getOutModel().getGirl().getPosition();
        if (getOutModel().getMonsters().contains(new Monster(position.getX(), position.getY(), "#FFFFFF")) |
                getOutModel().getArrows().contains(new Arrow(position.getX(), position.getY(), "", ""))) {
            return true;
        }

        for (Crack crack: getOutModel().getCracks()) {
            if (getOutModel().getGirl().getPosition().equals(crack.getPosition()) && !crack.isSafe()) return true;
        }

        return false;
    }

    private void hearts() {
        Heart heartTemp = null;

        for (Heart heart : getOutModel().getHearts()) {
            if (heart.getPosition().equals(getOutModel().getGirl().getPosition())) {
                getOutModel().getGirl().catchHeart();
                heartTemp = heart;
            }
        }
        getOutModel().getHearts().remove(heartTemp);
    }

    private void stars() {
        Star starTemp = null;

        for (Star star : getOutModel().getStars()) {
            if (star.getPosition().equals(getOutModel().getGirl().getPosition())) {
                starTemp = star;
            }
        }
        getOutModel().getStars().remove(starTemp);
    }

    private void checkp() {
        for (Checkpoint checkpoint : getOutModel().getCheckpoints()) {
            if (checkpoint.getAround(getOutModel().getGirl().getPosition())) {
                getOutModel().getGirl().setRespawn(checkpoint.getPosition());
            }
        }
    }


}
