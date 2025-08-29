package boygirl.controler.game;

import boygirl.Game;
import boygirl.controler.general.GameplayController;
import boygirl.guihelp.LanternaGui;
import boygirl.model.Position;
import boygirl.model.elements.Door;
import boygirl.model.elements.Wall;
import boygirl.model.elements.Winner;
import boygirl.model.general.Gameplay;
import boygirl.model.general.Menu;
import boygirl.states.StateGameplay;
import boygirl.states.StateMenu;

import java.io.IOException;

public class GameController extends GameplayController {

    private final int max_level = 5;

    BoyGameController boyCont;
    GirlGameController girlCont;
    MonsterController monCont;
    ButtonController buttonCont;
    ArrowController arrowCont;

    public GameController(Gameplay outModel) {
        super(outModel);
        this.boyCont = new BoyGameController(outModel);
        this.girlCont = new GirlGameController(outModel);
        this.monCont = new MonsterController(outModel);
        this.buttonCont = new ButtonController(outModel);
        this.arrowCont = new ArrowController(outModel);
    }

    public void run(Game game, LanternaGui.input input, long time) throws IOException {
        getBoyController().run(game, input, time);
        getGirlController().run(game, input, time);
        getMonController().run(game, input, time);
        getButtonController().run(game, input, time);
        getArrowController().run(game, input, time);

        checkStars();
        if (getOutModel().getBoy().getLives() == 0 |
                getOutModel().getGirl().getLives() == 0) {
            game.setState(new StateGameplay(new Gameplay("/background/Lose.txt", max_level)));
        }
        if (input == LanternaGui.input.back) {
            game.setBefore(game.getState());
            game.setState(new StateMenu(new Menu("/background/Menu2.txt")));
        }

        getWinner(game);
    }

    public void checkStars() {
        if (getOutModel().getStars().isEmpty()) {
            for (Door door : getOutModel().getDoors()) {
                if (door.getColor().equals("#FFFF00")) {
                    door.setOpen(true);
                }
            }
        }
    }

    private void getWinner(Game game) throws IOException {
        Position boytemp = getOutModel().getBoy().getPosition();
        Position girltemp = getOutModel().getGirl().getPosition();

        if (getOutModel().getWinners().contains(new Winner(boytemp.getX(), boytemp.getY(), "")) &&
                getOutModel().getWinners().contains(new Winner(girltemp.getX(), girltemp.getY(), ""))) {
            win(game);
        }
    }

    private void win(Game game) throws IOException {
        getOutModel().increaseLevel();

        if (getOutModel().getLevel() <= max_level) {
            System.out.println("Level: " + getOutModel().getLevel());
            game.setState(new StateGameplay(new Gameplay("/background/Game" + getOutModel().getLevel() + ".txt", getOutModel().getLevel())));
        } else {
            game.setState(new StateMenu(new Menu("/background/Menu1.txt")));
        }
    }

    private BoyGameController getBoyController() {
        return boyCont;
    }

    private GirlGameController getGirlController() {
        return girlCont;
    }

    private MonsterController getMonController() {return monCont;}

    private ButtonController getButtonController() {return buttonCont;}

    private ArrowController getArrowController() {return arrowCont;}
}
