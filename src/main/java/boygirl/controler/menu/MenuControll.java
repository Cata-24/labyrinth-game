package boygirl.controler.menu;

import boygirl.Game;
import boygirl.controler.game.BoyGameController;
import boygirl.controler.game.GirlGameController;
import boygirl.controler.general.Controller;
import boygirl.controler.general.MenuController;
import boygirl.guihelp.LanternaGui;
import boygirl.model.general.Gameplay;
import boygirl.model.general.Menu;
import boygirl.states.StateGameplay;

import java.io.IOException;

public class MenuControll extends MenuController {
    BoyMenuController boyCont;
    GirlMenuController girlCont;

    public MenuControll(Menu outModel) {
        super(outModel);
        this.boyCont = new BoyMenuController(outModel);
        this.girlCont = new GirlMenuController(outModel);
    }

    @Override
    public void run(Game game, LanternaGui.input input, long time) throws IOException {
        getBoyController().run(game, input, time);
        getGirlController().run(game, input, time);

        if (game.getBefore() != null && getOutModel().continueGameplay()) {
            game.setState(game.getBefore());
            game.setBefore(null);
        }

        if (getOutModel().goGameplay()) {
            game.setBefore(null);
            game.setState(new StateGameplay(new Gameplay("/background/Game1.txt", 1)));
        }
        if (input == LanternaGui.input.back) game.setState(null);
    }

    private BoyMenuController getBoyController() {
        return boyCont;
    }

    private GirlMenuController getGirlController() {
        return girlCont;
    }
}
