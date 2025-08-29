package boygirl.controller;

import boygirl.Game;
import boygirl.controler.game.ArrowController;
import boygirl.guihelp.LanternaGui;
import boygirl.model.Position;
import boygirl.model.elements.Arrow;
import boygirl.model.elements.Wall;
import boygirl.model.general.Gameplay;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArrowControllerTest {
    Gameplay gameplay;
    Game game;
    ArrowController arrowController;

    @Test
    void colision() throws IOException {
        gameplay = new Gameplay("/GameBuildTest.txt", 0);
        game = Mockito.mock(Game.class);
        arrowController = new ArrowController(gameplay);

        gameplay.getArrows().add(new Arrow(10,10, "", "up"));
        gameplay.getWalls().add(new Wall(10,9, ""));

        long time = 1000;
        arrowController.run(game, LanternaGui.input.up, time);

        Assertions.assertEquals("down", gameplay.getArrows().get(2).getDirection());
        Assertions.assertEquals(new Position(10,10), gameplay.getArrows().get(2).getPosition());
    }

    @Property
    void run(@ForAll long time) throws IOException {
        gameplay = new Gameplay("/GameBuildTest.txt", 0);
        game = Mockito.mock(Game.class);
        arrowController = new ArrowController(gameplay);

        List<Arrow> expectedArrows = new ArrayList<>();
        expectedArrows.add(new Arrow(0, 10, "", "right"));
        expectedArrows.add(new Arrow(1, 10, "", "up"));

        long temp = arrowController.getLastTime();
        arrowController.run(game, LanternaGui.input.up, time);

        if (time - temp <= 500) {
            for (int i = 0; i < expectedArrows.size(); i++) {
                Assertions.assertEquals(expectedArrows.get(i).getPosition(), gameplay.getArrows().get(i).getPosition());
                Assertions.assertEquals(expectedArrows.get(i).getDirection(), gameplay.getArrows().get(i).getDirection());
            }
        }
    }
}
