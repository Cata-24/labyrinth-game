package boygirl.states;

import boygirl.controler.game.GameController;
import boygirl.controler.general.Controller;
import boygirl.controler.general.GameplayController;
import boygirl.model.general.Gameplay;
import boygirl.viewer.general.Viewer;
import boygirl.viewer.general.ViewerGameplay;

import java.io.IOException;

public class StateGameplay extends State<Gameplay> {
    public StateGameplay(Gameplay outModel) throws IOException {
        super(outModel);
    }

    @Override
    protected Viewer<Gameplay> getViewer() {return new ViewerGameplay(getOutModel());}

    @Override
    protected Controller<Gameplay> getController() {return new GameController(getOutModel());}
}
