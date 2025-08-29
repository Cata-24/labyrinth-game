package boygirl.controler.game;

import boygirl.Game;
import boygirl.controler.general.Controller;
import boygirl.controler.general.GameplayController;
import boygirl.guihelp.LanternaGui;
import boygirl.model.Position;
import boygirl.model.elements.*;
import boygirl.model.general.Gameplay;
import boygirl.model.general.OutModel;

import java.util.ArrayList;
import java.util.List;

public class BoyGameController extends GameplayController {
    public BoyGameController(Gameplay outModel) {
        super(outModel);
    }

    public void run(Game game, LanternaGui.input input, long time) {
        switch (input) {
            case up -> move(getOutModel().getBoy().moveUp());
            case down -> move(getOutModel().getBoy().moveDown());
            case left -> move(getOutModel().getBoy().moveLeft());
            case right -> move(getOutModel().getBoy().moveRight());
        }

        checkp();
        hearts();
        stars();

        if (die()) {
            getOutModel().getBoy().respawn();
        }
    }

    private void move(Position position) {
        if (check(position)) getOutModel().getBoy().setPosition(position);
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
        Position position = getOutModel().getBoy().getPosition();
        if (getOutModel().getMonsters().contains(new Monster(position.getX(), position.getY(), "#FFFFFF")) |
                getOutModel().getArrows().contains(new Arrow(position.getX(), position.getY(), "", ""))) {
            return true;
        }

        for (Crack crack: getOutModel().getCracks()) {
            if (getOutModel().getBoy().getPosition().equals(crack.getPosition()) && !crack.isSafe()) return true;
        }

        return false;
    }

    private void hearts() {
        Heart heartTemp = null;

        for (Heart heart : getOutModel().getHearts()) {
            if (heart.getPosition().equals(getOutModel().getBoy().getPosition())) {
                getOutModel().getBoy().catchHeart();
                heartTemp = heart;
            }
        }
        getOutModel().getHearts().remove(heartTemp);
    }

    private void stars() {
        Star starTemp = null;

        for (Star star : getOutModel().getStars()) {
            if (star.getPosition().equals(getOutModel().getBoy().getPosition())) {
                starTemp = star;
            }
        }
        getOutModel().getStars().remove(starTemp);
    }

    private void checkp() {
        for (Checkpoint checkpoint : getOutModel().getCheckpoints()) {
            if (checkpoint.getAround(getOutModel().getBoy().getPosition())) {
                getOutModel().getBoy().setRespawn(checkpoint.getPosition());
            }
        }
    }
}
