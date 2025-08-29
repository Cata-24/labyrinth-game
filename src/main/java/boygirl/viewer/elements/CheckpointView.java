package boygirl.viewer.elements;

import boygirl.guihelp.LanternaGui;
import boygirl.model.elements.Element;

public class CheckpointView implements ElementView {
    @Override
    public void draw(Element element, LanternaGui gui, String color) {
        gui.drawString(element.getX(), element.getY(), "#", color);
    }
}
