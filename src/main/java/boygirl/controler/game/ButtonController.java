package boygirl.controler.game;

import boygirl.Game;
import boygirl.controler.general.GameplayController;
import boygirl.guihelp.LanternaGui;
import boygirl.model.elements.Button;
import boygirl.model.elements.Door;
import boygirl.model.general.Gameplay;

public class ButtonController extends GameplayController {

    public ButtonController(Gameplay outModel) {
        super(outModel);
    }

    public void run(Game game, LanternaGui.input input, long time) {
        for (Button button: getOutModel().getButtons()) {
            if (button.isOpen() && !button.getPosition().equals(getOutModel().getBoy().getPosition()) &&
                    !button.getPosition().equals(getOutModel().getGirl().getPosition())) {
                if (buttonColor(button.getColor()) && time - button.getLastcheck() > button.getTime() * 1000) {
                    changeDoor(button.getColor(), false);
                } if (time - button.getLastcheck() > button.getTime() * 1000) {
                    button.setOpen(false);
                }
            } else if (!button.isOpen() && (button.getPosition().equals(getOutModel().getBoy().getPosition()) |
            button.getPosition().equals(getOutModel().getGirl().getPosition()))) {
                changeDoor(button.getColor(), true);
                button.setOpen(true);
                button.setLastcheck(time);
            } else if (button.isOpen() && (button.getPosition().equals(getOutModel().getBoy().getPosition()) |
            button.getPosition().equals(getOutModel().getGirl().getPosition()))) {
                button.setLastcheck(time);
            }
        }
    }

    private void changeDoor(String color, boolean open) {
        for (Door door: getOutModel().getDoors()) {
            if (door.getColor().equals(color)) {
                door.setOpen(open);
            }
        }
    }

    private boolean buttonColor(String color) {
        for (Button button: getOutModel().getButtons()) {
            if (button.isOpen() && (button.getPosition().equals(getOutModel().getBoy().getPosition()) |
                    button.getPosition().equals(getOutModel().getGirl().getPosition())) && button.getColor().equals(color)) {
                return false;
            }
        }
        return true;
    }


}
