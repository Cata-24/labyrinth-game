package boygirl.controller;

import boygirl.Game;
import boygirl.controler.game.ButtonController;
import boygirl.guihelp.LanternaGui;
import boygirl.model.Position;
import boygirl.model.elements.Button;
import boygirl.model.elements.Door;
import boygirl.model.general.Gameplay;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Objects;

public class ButtonControllerTest {
    Game game;
    Gameplay gameplay;
    ButtonController buttonController;

    @BeforeEach
    void setUp() throws IOException {
        game = Mockito.mock(Game.class);
        gameplay = new Gameplay("/GameBuildTest.txt", 0);
        buttonController = new ButtonController(gameplay);
    }

    @Test
    void openClose() {
        Button button = new Button(10,10,0, "aa");
        gameplay.getButtons().add(button);
        gameplay.getDoors().add(new Door(20, 20, "aa"));

        gameplay.getBoy().setPosition(new Position(10, 10));

        buttonController.run(game, LanternaGui.input.up, 1000);

        for (Door door: gameplay.getDoors()) {
            if (door.getColor().equals(button.getColor())) {
                Assertions.assertTrue(door.isOpen());
            }
        }

        gameplay.getBoy().setPosition(new Position(11, 10));

        buttonController.run(game, LanternaGui.input.up, 2000);

        for (Door door: gameplay.getDoors()) {
            if (door.getColor().equals(button.getColor())) {
                Assertions.assertFalse(door.isOpen());
            }
        }
    }

    @Test
    void twoButtons() {
        Button button1 = new Button(10,10,0, "aa");
        Button button2 = new Button(10,20,0, "aa");

        gameplay.getButtons().add(button1);
        gameplay.getButtons().add(button2);

        gameplay.getDoors().add(new Door(20, 20, "aa"));

        gameplay.getBoy().setPosition(new Position(10, 10));
        gameplay.getGirl().setPosition(new Position(10, 20));

        buttonController.run(game, LanternaGui.input.up, 1000);

        for (Door door: gameplay.getDoors()) {
            if (door.getColor().equals("aa")) {
                Assertions.assertTrue(door.isOpen());
            }
        }

        gameplay.getBoy().setPosition(new Position(11, 10));

        buttonController.run(game, LanternaGui.input.up, 2000);

        Assertions.assertFalse(button1.isOpen());
        for (Door door: gameplay.getDoors()) {
            if (door.getColor().equals("aa")) {
                Assertions.assertTrue(door.isOpen());
            }
        }
    }

}
