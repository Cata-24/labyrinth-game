package boygirl.viewer.elements;

import boygirl.guihelp.LanternaGui;
import boygirl.model.elements.Element;

public interface ElementView {
    public void draw(Element element, LanternaGui gui, String color);
}
