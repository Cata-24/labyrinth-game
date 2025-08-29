package boygirl.controler.general;

import boygirl.Game;
import boygirl.guihelp.LanternaGui;
import boygirl.model.general.OutModel;

import java.io.IOException;

public abstract class Controller<T extends OutModel> {
    private final T outModel;

    public Controller(T outModel) {
        this.outModel = outModel;
    }

    public T getOutModel() {return outModel;}

    public abstract void run(Game game, LanternaGui.input input, long time) throws IOException;
}
