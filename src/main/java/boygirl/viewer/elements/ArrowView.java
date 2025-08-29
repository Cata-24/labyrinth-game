package boygirl.viewer.elements;

import boygirl.guihelp.LanternaGui;
import boygirl.model.elements.Arrow;
import boygirl.model.elements.Element;

public class ArrowView {
    public void draw(Arrow arrow, LanternaGui gui) {
        String temp = "";
        switch (arrow.getDirection()) {
            case "up" -> temp = ")";
            case "down" -> temp = ",";
            case "left" -> temp = "_";
            case "right" -> temp = "(";
        }
        gui.drawString(arrow.getX(), arrow.getY(), temp, arrow.getColor());
    }
}
