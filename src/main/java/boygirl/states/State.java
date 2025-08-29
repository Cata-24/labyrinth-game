package boygirl.states;

import boygirl.controler.general.Controller;
import boygirl.guihelp.LanternaGui;
import boygirl.model.general.OutModel;
import boygirl.viewer.general.Viewer;
import boygirl.Game;

import java.io.IOException;

public abstract class State<T extends OutModel> {
    private Controller<T> controller;
    private Viewer<T> viewer;
    private T outModel;

    public State(T outModel) throws IOException {
        this.outModel = outModel;
        this.viewer = getViewer();
        this.controller = getController();

    }

    protected T getOutModel() {return outModel;}

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public void run(Game game, LanternaGui gui, long time) throws IOException {
        LanternaGui.input input = gui.getInput();
        viewer.run(gui);
        controller.run(game, input, time);
    }
}