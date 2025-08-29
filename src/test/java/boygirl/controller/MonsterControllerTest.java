package boygirl.controller;

import boygirl.Game;
import boygirl.controler.game.MonsterController;
import boygirl.guihelp.LanternaGui;
import boygirl.model.Position;
import boygirl.model.elements.Monster;
import boygirl.model.general.Gameplay;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MonsterControllerTest {

    // Ensure that the run method in monsters only runs

    @Property
    public void run(@ForAll long time) throws IOException {
        Gameplay gameplay = new Gameplay("/GameBuildTest.txt", 1);
        MonsterController monsterController = new MonsterController(gameplay);
        Game game = Mockito.mock(Game.class);
        List<Monster> monsters = new ArrayList<>();
        List<Monster> monsters1 = gameplay.getMonsters();
        monsters.add(new Monster(0,2, "#FF0000"));
        monsters.add(new Monster(1,2, "#FF0000"));
        monsters.add(new Monster(2,2, "#FF0000"));

        long temp = monsterController.getMoveTrack();

        for (int i = 0; i < monsters.size(); i++) {
            monsters1.get(i).setPosition(monsters.get(i).getPosition());
        }

        monsterController.run(game, LanternaGui.input.up, time);
        if (time - temp > 1000) {
            for (int i = 0; i < monsters.size(); i++) {
                Position position = monsters.get(i).getPosition();
                Position position1 = monsters1.get(i).getPosition();
                if (!position.equals(position1)) {
                    Assertions.assertTrue(Math.abs(position.getX() - position1.getX()) <= 1);
                    Assertions.assertTrue(Math.abs(position.getY() - position1.getY()) <= 1);
                }
            }
        } else {
            for (int i = 0; i < monsters.size(); i++) {
                Position position = monsters.get(i).getPosition();
                Position position1 = monsters1.get(i).getPosition();
                Assertions.assertEquals(position.getX(), position1.getX());
                Assertions.assertEquals(position.getY(), position1.getY());
            }
        }
    }
}
