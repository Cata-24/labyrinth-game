package boygirl.viewer.elements;

import boygirl.guihelp.LanternaGui;
import boygirl.model.elements.Element;

import javax.swing.text.View;

public class BoyView implements ElementView {
    @Override
    public void draw(Element element, LanternaGui gui, String color) {
        gui.drawString(element.getX(), element.getY(), "`", color);
    }
}
