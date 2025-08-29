package boygirl.model;

import boygirl.model.elements.*;
import boygirl.model.general.Gameplay;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Checking the detection and creation of elements from a txt file in resources

public class GameplayTest {
    Gameplay gameplay;

    @BeforeEach
    void setUp() throws IOException {
        gameplay = new Gameplay("/GameBuildTest.txt", 1);
    }

    @Test
    void getWalls() {
        List<Wall> walls = gameplay.getWalls();
        List<Wall> expectedWalls = new ArrayList<>();
        expectedWalls.add(new Wall(0,0, "#FFFFFF"));
        expectedWalls.add(new Wall(1,0, "#FFFFFF"));
        expectedWalls.add(new Wall(2,0, "#FFFFFF"));
        Assertions.assertEquals(expectedWalls, walls);
    }

    @Test
    void getPlayers() {
        Boy boy = gameplay.getBoy();
        Boy expectedBoy = new Boy(7,1, "#0000FF");

        Girl girl = gameplay.getGirl();
        Girl expectedGirl = new Girl(8,1, "#FFC0CB");

        Assertions.assertEquals(expectedBoy, boy);
        Assertions.assertEquals(expectedGirl, girl);
    }

    @Test
    void getMonsters() {
        List<Monster> monsters = gameplay.getMonsters();
        List<Monster> expectedMonsters = new ArrayList<>();
        expectedMonsters.add(new Monster(0,2, "#FF0000"));
        expectedMonsters.add(new Monster(1,2, "#FF0000"));
        expectedMonsters.add(new Monster(2,2, "#FF0000"));

        Assertions.assertEquals(expectedMonsters, monsters);
    }

    @Test
    void getButtons() {
        List<Button> buttons = gameplay.getButtons();
        List<Button> expectedButtons = new ArrayList<>();
        expectedButtons.add(new Button(0,3,0, "#ADD8E6"));
        expectedButtons.add(new Button(1,3,0, "#FFA500"));
        expectedButtons.add(new Button(2,3,0, "#800080"));
        expectedButtons.add(new Button(3,3,10, "#FFFFFF"));
        Assertions.assertEquals(expectedButtons, buttons);
    }

    @Test
    void getCracks() {
        List<Crack> cracks = gameplay.getCracks();
        List<Crack> expectedCracks = new ArrayList<>();
        expectedCracks.add(new Crack(0,4, "#FFFFFF", false));
        expectedCracks.add(new Crack(1,4, "#FFFFFF", true));
        Assertions.assertEquals(expectedCracks, cracks);
    }

    @Test
    void getDoors() {
        List<Door> doors = gameplay.getDoors();
        List<Door> expectedDoors = new ArrayList<>();
        expectedDoors.add(new Door(0,5, "#FFFFFF"));
        expectedDoors.add(new Door(1,5, "#FFFFFF"));
        expectedDoors.add(new Door(2,5, "#FFFFFF"));
        expectedDoors.add(new Door(3,5, "#FFFFFF"));
        expectedDoors.add(new Door(4,5, "#FFFFFF"));
        Assertions.assertEquals(expectedDoors, doors);
    }

    @Test
    void getStars() {
        List<Star> stars = gameplay.getStars();
        List<Star> expectedStars = new ArrayList<>();
        expectedStars.add(new Star(0,6, "#FFFFFF"));
        expectedStars.add(new Star(1,6, "#FFFFFF"));
        Assertions.assertEquals(expectedStars, stars);
        expectedStars.add(new Star(2,6, "#FFFFFF"));
        Assertions.assertNotEquals(expectedStars, stars);
    }

    @Test
    void getHearts() {
        List<Heart> hearts = gameplay.getHearts();
        List<Heart> expectedHearts = new ArrayList<>();
        expectedHearts.add(new Heart(0,7, "#FFFFFF"));
        expectedHearts.add(new Heart(1,7, "#FFFFFF"));
        Assertions.assertEquals(expectedHearts, hearts);
    }

    @Test
    void getWinners() {
        List<Winner> winners = gameplay.getWinners();
        List<Winner> expectedWinners = new ArrayList<>();
        expectedWinners.add(new Winner(0,8, "#FFFFFF"));
        expectedWinners.add(new Winner(1,8, "#FFFFFF"));
        Assertions.assertEquals(expectedWinners, winners);
        expectedWinners.add(new Winner(2,8, "#FFFFFF"));
        Assertions.assertNotEquals(expectedWinners, winners);
    }

    @Test
    void getCheckpoints() {
        List<Checkpoint> checkpoints = gameplay.getCheckpoints();
        List<Checkpoint> expectedCheckpoints = new ArrayList<>();
        expectedCheckpoints.add(new Checkpoint(0,9, "#FFFFFF"));
        expectedCheckpoints.add(new Checkpoint(1,9, "#FFFFFF"));
        Assertions.assertEquals(expectedCheckpoints, checkpoints);
        expectedCheckpoints.add(new Checkpoint(2,9, "#FFFFFF"));
        Assertions.assertNotEquals(expectedCheckpoints, checkpoints);
    }

    @Test
    void getArrows() {
        List<Arrow> arrows = gameplay.getArrows();
        List<Arrow> expectedArrows = new ArrayList<>();
        expectedArrows.add(new Arrow(0, 10, "", ""));
        expectedArrows.add(new Arrow(1, 10, "", ""));
        Assertions.assertEquals(expectedArrows, arrows);
    }
}
