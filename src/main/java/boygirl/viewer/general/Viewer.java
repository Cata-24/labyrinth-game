package boygirl.viewer.general;
import boygirl.guihelp.LanternaGui;
import boygirl.model.elements.Element;
import boygirl.model.general.OutModel;
import boygirl.viewer.elements.ElementView;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.List;

public abstract class Viewer<T extends OutModel> {
    private T outModel;

    public Viewer(T outModel) {
        this.outModel = outModel;
    }

    public T getOutModel() {
        return outModel;
    }

    public void run(LanternaGui gui) throws IOException {
        gui.clear();
        draw(gui);
        gui.refresh();
    }

    protected abstract void draw(LanternaGui gui);

    protected void drawElement(LanternaGui gui, Element element, ElementView view) {
        view.draw(element, gui, element.getColor());
    }

    protected <R extends Element> void drawElements(LanternaGui gui, List<R> elements, ElementView view) {
        for (R element : elements) view.draw(element, gui, element.getColor());
    }
}

