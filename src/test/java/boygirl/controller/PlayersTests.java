package boygirl.controller;

import boygirl.Game;
import boygirl.controler.game.BoyGameController;
import boygirl.guihelp.LanternaGui;
import boygirl.model.Position;
import boygirl.model.elements.Monster;
import boygirl.model.elements.Wall;
import boygirl.model.general.Gameplay;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PlayersTests {
    Game game;
    Gameplay gameplay;
    BoyGameController gameController;

    @BeforeEach
    void setUp() throws IOException {
        game = Mockito.mock(Game.class);
        gameplay = new Gameplay("/GameBuildTest.txt", 0);
        gameController = new BoyGameController(gameplay);
    }

    @Test
    void inputMoveUp() {
        Position position = gameplay.getBoy().getPosition();
        gameController.run(game, LanternaGui.input.up, 0);
        Assertions.assertEquals(gameplay.getBoy().getPosition().getY(), position.getY() - 1);
        Assertions.assertEquals(gameplay.getBoy().getPosition().getX(), position.getX());
    }

    @Test
    void inputMoveDown() {
        Position position = gameplay.getBoy().getPosition();
        gameController.run(game, LanternaGui.input.down, 0);
        Assertions.assertEquals(gameplay.getBoy().getPosition().getY(), position.getY() + 1);
        Assertions.assertEquals(gameplay.getBoy().getPosition().getX(), position.getX());
    }

    @Test
    void inputMoveLeft() {
        Position position = gameplay.getBoy().getPosition();
        gameController.run(game, LanternaGui.input.left, 0);
        Assertions.assertEquals(gameplay.getBoy().getPosition().getY(), position.getY());
        Assertions.assertEquals(gameplay.getBoy().getPosition().getX(), position.getX() - 1);
    }

    @Test
    void inputMoveRight() {
        Position position = gameplay.getBoy().getPosition();
        gameController.run(game, LanternaGui.input.right, 0);
        Assertions.assertEquals(gameplay.getBoy().getPosition().getY(), position.getY());
        Assertions.assertEquals(gameplay.getBoy().getPosition().getX(), position.getX() + 1);
    }

    @Test
    void moveColision() {
        gameplay.getBoy().setPosition(new Position(10, 10));
        gameplay.getWalls().add(new Wall(10, 9, ""));
        gameController.run(game, LanternaGui.input.up, 0);

        Assertions.assertEquals(10, gameplay.getBoy().getPosition().getY());
        Assertions.assertEquals(10, gameplay.getBoy().getPosition().getX());
    }

    @Test
    void death() {
        gameplay.getBoy().setPosition(new Position(10, 10));
        gameplay.getMonsters().add(new Monster(10, 9, ""));
        gameController.run(game, LanternaGui.input.up, 0);

        Assertions.assertEquals(2, gameplay.getBoy().getLives());
        Assertions.assertEquals(new Position(7, 1), gameplay.getBoy().getPosition());
    }
}
