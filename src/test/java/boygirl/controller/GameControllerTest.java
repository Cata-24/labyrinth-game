package boygirl.controller;

import boygirl.Game;
import boygirl.controler.game.GameController;
import boygirl.guihelp.LanternaGui;
import boygirl.model.Position;
import boygirl.model.elements.Winner;
import boygirl.model.general.Gameplay;
import boygirl.states.StateGameplay;
import boygirl.states.StateMenu;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameControllerTest {
    Gameplay gameplay = new Gameplay("/GameBuildTest.txt", 5);
    GameController gameController = new GameController(gameplay);
    Game game = Mockito.mock(Game.class);

    public GameControllerTest() throws IOException {
    }

    @Test
    void lose() throws IOException {
        while (gameplay.getBoy().getLives() != 0) {
            gameplay.getBoy().respawn();
            gameplay.getGirl().respawn();
        }

        gameController.run(game, LanternaGui.input.none, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(StateGameplay.class));
    }

    @Test
    void win() throws IOException {
        gameplay.getWinners().add(new Winner(10, 10, "a"));
        gameplay.getGirl().setPosition(new Position(10,10));
        gameplay.getBoy().setPosition(new Position(10,10));

        gameController.run(game, LanternaGui.input.none, 1000);

        // Because the level is at 5 which is the max level

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(StateMenu.class));
    }
}
