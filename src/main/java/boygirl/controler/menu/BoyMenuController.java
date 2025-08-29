package boygirl.controler.menu;

import boygirl.Game;
import boygirl.controler.general.MenuController;
import boygirl.guihelp.LanternaGui;
import boygirl.model.Position;
import boygirl.model.elements.Wall;
import boygirl.model.general.Menu;

public class BoyMenuController extends MenuController {

    public BoyMenuController(Menu outModel) {super(outModel);}

    public void run(Game game, LanternaGui.input input, long time) {
        switch (input) {
            case up -> move(getOutModel().getBoy().moveUp(), game);
            case down -> move(getOutModel().getBoy().moveDown(), game);
            case left -> move(getOutModel().getBoy().moveLeft(), game);
            case right -> move(getOutModel().getBoy().moveRight(), game);
        }
    }

    private void move(Position position, Game game) {
        if (position.getY() <= 9 && position.getY() >= 7 && position.getX() >= 11 && !game.getGui().hasChar(position)) {
            getOutModel().getBoy().setPosition(position);
        }
    }
}
