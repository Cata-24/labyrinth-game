package boygirl.viewer.general;

import boygirl.guihelp.LanternaGui;
import boygirl.model.elements.Arrow;
import boygirl.model.elements.Door;
import boygirl.model.general.Gameplay;
import boygirl.model.general.OutModel;
import boygirl.viewer.elements.*;

public class ViewerGameplay extends Viewer<Gameplay> {

    public ViewerGameplay(Gameplay outModel) {super(outModel);}

    @Override
    public void draw(LanternaGui gui) {
        drawElements(gui, getOutModel().getWalls(), new WallView());
        drawElements(gui, getOutModel().getCracks(), new CrackView());
        drawElements(gui, getOutModel().getMonsters(), new MonsterView());
        drawElements(gui, getOutModel().getButtons(), new ButtonView());
        drawElements(gui, getOutModel().getCheckpoints(), new CheckpointView());
        drawElements(gui, getOutModel().getHearts(), new HeartView());
        drawElements(gui, getOutModel().getStars(), new StarView());
        for (Door door: getOutModel().getDoors()) {
            if (!door.isOpen()) {drawElement(gui, door, new DoorView());}
        }

        ArrowView arrowView = new ArrowView();

        for (Arrow arrow: getOutModel().getArrows()) {
            arrowView.draw(arrow, gui);
        }

        drawElement(gui, getOutModel().getBoy(), new BoyView());
        drawElement(gui, getOutModel().getGirl(), new GirlView());

        gui.drawString(0, getOutModel().getWalls().getLast().getY() + 2, "BOY LIVES: " + getOutModel().getBoy().getLives(), "#FFFFFF");
        gui.drawString(0, getOutModel().getWalls().getLast().getY() + 3, "GIRL LIVES: " + getOutModel().getGirl().getLives(), "#FFFFFF");

    }
}
