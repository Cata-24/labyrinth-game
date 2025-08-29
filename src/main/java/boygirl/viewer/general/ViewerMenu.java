package boygirl.viewer.general;

import boygirl.guihelp.LanternaGui;
import boygirl.model.general.Menu;
import boygirl.viewer.elements.BoyView;
import boygirl.viewer.elements.GirlView;

import java.util.List;

public class ViewerMenu extends Viewer<Menu> {

    public ViewerMenu(Menu outModel) {super(outModel);}

    @Override
    protected void draw(LanternaGui gui) {
        drawBackground(gui);
        drawElement(gui, getOutModel().getBoy(), new BoyView());
        drawElement(gui, getOutModel().getGirl(), new GirlView());
    }

    private void drawBackground(LanternaGui gui) {
        List<String> lines = getOutModel().getBackground();
        for (int i = 0; i < lines.size(); i++) {
            gui.drawString(0, i, lines.get(i), "#FFFFFF");
        }
    }

}
