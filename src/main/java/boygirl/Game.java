package boygirl;

import boygirl.guihelp.LanternaGui;
import boygirl.model.general.Menu;
import boygirl.states.State;
import boygirl.states.StateMenu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private LanternaGui gui;
    private State state;
    private State before = null;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGui(110,55);
        this.state = new StateMenu(new Menu("/background/Menu1.txt"));
    }

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException, FontFormatException {
        new Game().run();
    }

    public void run() throws IOException, InterruptedException {
        while(getState() != null) {
            long temp = System.currentTimeMillis();

            // set run method here
            getState().run(this, getGui(), temp);

            long runtime = System.currentTimeMillis() - temp;

            try {
                if (30 - runtime > 0) Thread.sleep(30 - runtime);
            } catch (InterruptedException e) {
            }
        }
        gui.close();
    }

    public LanternaGui getGui() {return gui;}
    public State getState() {return state;}
    public void setState(State state) {this.state = state;}
    public State getBefore() {return before;}
    public void setBefore(State before) {this.before = before;}
}