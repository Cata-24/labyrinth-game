package boygirl.controler.menu;

import boygirl.Game;
import boygirl.controler.general.MenuController;
import boygirl.guihelp.LanternaGui;
import boygirl.model.Position;
import boygirl.model.elements.Wall;
import boygirl.model.general.Menu;

public class GirlMenuController extends MenuController {

    public GirlMenuController(Menu outModel) {super(outModel);}

    public void run(Game game, LanternaGui.input input, long time) {
        switch (input) {
            case wup -> move(getOutModel().getGirl().moveUp(), game);
            case sdown -> move(getOutModel().getGirl().moveDown(), game);
            case aleft -> move(getOutModel().getGirl().moveLeft(), game);
            case dright -> move(getOutModel().getGirl().moveRight(), game);
        }
    }

    private void move(Position position, Game game) {
        if (position.getY() <= 12 && position.getY() >= 10 && position.getX() >= 11 && !game.getGui().hasChar(position)) {
            getOutModel().getGirl().setPosition(position);
        }
    }
}
