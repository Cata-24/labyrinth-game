package boygirl.model.general;

import boygirl.model.elements.Boy;
import boygirl.model.elements.Girl;
import boygirl.model.elements.Monster;
import boygirl.model.elements.Wall;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class OutModel {
    protected Boy boy = null;
    protected Girl girl = null;
    protected List<String> background;
    protected int level;

    public OutModel(String filename) throws IOException {
        this.boy = getBoy();
        this.girl = getGirl();

        URL resource = OutModel.class.getResource(filename);
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        this.background = generateBack(br);
    }

    public abstract Boy getBoy();
    public abstract Girl getGirl();

    public List<String> getBackground() {return background;}

    private List<String> generateBack(BufferedReader br) throws IOException {
        List<String> result = new ArrayList<>();
        String line = br.readLine();
        while (line != null) {
            result.add(line);
            line = br.readLine();
        }
        return result;
    }

    public int getLevel() {
        return level;
    }

    public void increaseLevel() {
        this.level++;
    }
}
