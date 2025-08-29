package boygirl.view;

import boygirl.guihelp.LanternaGui;
import boygirl.model.general.Gameplay;
import boygirl.viewer.general.ViewerGameplay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameplayViewTest {
    Gameplay gameplay;
    ViewerGameplay viewerGameplay;
    LanternaGui mockGUI;

    @BeforeEach
    void setUp() throws IOException {
        mockGUI = Mockito.mock(LanternaGui.class);
        gameplay = new Gameplay("/GameBuildTest.txt", 0);
        viewerGameplay = new ViewerGameplay(gameplay);
    }

    @Test
    void drawWalls() {
        viewerGameplay.draw(mockGUI);
        Mockito.verify(mockGUI, Mockito.times(3)).drawString(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq("'"), Mockito.anyString());
    }

    @Test
    void drawMonsters() {
        viewerGameplay.draw(mockGUI);
        Mockito.verify(mockGUI, Mockito.times(3)).drawString(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq("$"), Mockito.anyString());
    }

    @Test
    void drawButtons() {
        viewerGameplay.draw(mockGUI);
        Mockito.verify(mockGUI, Mockito.times(4)).drawString(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq("="), Mockito.anyString());
    }

    @Test
    void drawDoors() {
        viewerGameplay.draw(mockGUI);
        Mockito.verify(mockGUI, Mockito.times(5)).drawString(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq("&"), Mockito.anyString());
    }

    @Test
    void drawCracks() {
        viewerGameplay.draw(mockGUI);
        Mockito.verify(mockGUI, Mockito.times(2)).drawString(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq("}"), Mockito.anyString());
    }

    @Test
    void drawPlayers() {
        viewerGameplay.draw(mockGUI);
        Mockito.verify(mockGUI, Mockito.times(1)).drawString(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq("*"), Mockito.anyString());
        Mockito.verify(mockGUI, Mockito.times(1)).drawString(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq("`"), Mockito.anyString());
    }

    @Test
    void drawHearts() {
        viewerGameplay.draw(mockGUI);
        Mockito.verify(mockGUI, Mockito.times(2)).drawString(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq("{"), Mockito.anyString());
    }

    @Test
    void drawStars() {
        viewerGameplay.draw(mockGUI);
        Mockito.verify(mockGUI, Mockito.times(2)).drawString(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq("@"), Mockito.anyString());
    }

    @Test
    void drawCheckpoints() {
        viewerGameplay.draw(mockGUI);
        Mockito.verify(mockGUI, Mockito.times(2)).drawString(Mockito.anyInt(), Mockito.anyInt(), Mockito.eq("#"), Mockito.anyString());
    }
    @Test
    void drawArrows() {
        viewerGameplay.draw(mockGUI);
        Mockito.verify(mockGUI, Mockito.times(2)).drawString(Mockito.anyInt(), Mockito.anyInt(), Mockito.argThat(arg -> arg.equals("(") || arg.equals(")")), Mockito.anyString());
    }



}
