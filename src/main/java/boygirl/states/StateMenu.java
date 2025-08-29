package boygirl.states;

import boygirl.controler.general.Controller;
import boygirl.controler.general.MenuController;
import boygirl.controler.menu.MenuControll;
import boygirl.model.general.Menu;
import boygirl.viewer.general.Viewer;
import boygirl.viewer.general.ViewerMenu;

import java.io.IOException;

public class StateMenu extends State<Menu> {
    public StateMenu(Menu menu) throws IOException {
        super(menu);
    }

    @Override
    protected Viewer<Menu> getViewer() {return new ViewerMenu(getOutModel());}

    @Override
    protected Controller<Menu> getController() {return new MenuControll(getOutModel());}
}
