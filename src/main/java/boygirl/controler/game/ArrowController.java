package boygirl.controler.game;

import boygirl.Game;
import boygirl.controler.general.GameplayController;
import boygirl.guihelp.LanternaGui;
import boygirl.model.Position;
import boygirl.model.elements.Arrow;
import boygirl.model.elements.Wall;
import boygirl.model.general.Gameplay;

public class ArrowController extends GameplayController {
    private long lastTime = 0;

    public ArrowController(Gameplay outModel) {
        super(outModel);
    }

    public void run(Game game, LanternaGui.input input, long time) {
        if (time - lastTime > 500) {
            direction();
            this.lastTime = time;
        }
    }

    private void direction() {
        for (Arrow arrow: getOutModel().getArrows()) {
            switch (arrow.getDirection()) {
                case "up" -> move(arrow, arrow.moveUp());
                case "down" -> move(arrow, arrow.moveDown());
                case "left" -> move(arrow, arrow.moveLeft());
                case "right" -> move(arrow, arrow.moveRight());
            }
        }
    }

    private void move(Arrow arrow, Position position) {
        if (!getOutModel().getWalls().contains(new Wall(position.getX(), position.getY(), "#FFFFFF"))) {
            arrow.setPosition(position);
        } else {
            arrow.invert();
        }
    }

    public long getLastTime() {
        return lastTime;
    }
}
