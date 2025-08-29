package boygirl.controler.game;

import boygirl.Game;
import boygirl.controler.general.GameplayController;
import boygirl.guihelp.LanternaGui;
import boygirl.model.Position;
import boygirl.model.elements.*;
import boygirl.model.general.Gameplay;

import java.util.List;
import java.util.Random;

public class MonsterController extends GameplayController {

    long moveTrack;

    public MonsterController(Gameplay outModel) {super(outModel); moveTrack = 0;}

    public void run(Game game, LanternaGui.input input, long time) {
        if (time - getMoveTrack() > 1000) {
            moveMonster(getOutModel().getMonsters());
            this.moveTrack = time;
        }
    }

    public void moveMonster(List<Monster> monsters) {
        for (Monster monster : monsters) {
            Random random = new Random();

            Position ret = new Position(monster.getPosition().getX() + random.nextInt(3) - 1,
                    monster.getPosition().getY() + random.nextInt(3) - 1);

            move(ret, monster);

        }
    }

    public void move(Position position, Monster monster) {
        if (noElem(position)) monster.setPosition(position);
    }

    private boolean noElem(Position position) {
        return !(getOutModel().getWalls().contains(new Wall(position.getX(), position.getY(), "" )) |
        getOutModel().getDoors().contains(new Door(position.getX(), position.getY(), "")) |
        getOutModel().getCracks().contains(new Crack(position.getX(), position.getY(), "", false)) |
        getOutModel().getStars().contains(new Star(position.getX(), position.getY(), "")) |
        getOutModel().getArrows().contains(new Arrow(position.getX(), position.getY(), "", "")) |
        getOutModel().getButtons().contains(new Button(position.getX(), position.getY(), 0, "")) |
        getOutModel().getMonsters().contains(new Monster(position.getX(), position.getY(),"")));
    }

    public long getMoveTrack() {
        return moveTrack;
    }
}
