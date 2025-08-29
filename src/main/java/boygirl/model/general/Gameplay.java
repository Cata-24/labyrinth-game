package boygirl.model.general;

import boygirl.model.elements.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Gameplay extends OutModel{
    private List<Wall> walls = new ArrayList<>();;
    private List<Monster> monsters = new ArrayList<>();
    private List<Door> doors = new ArrayList<>();
    private List<Button> buttons = new ArrayList<>();
    private List<Arrow> arrows = new ArrayList<>();
    private List<Crack> cracks = new ArrayList<>();
    private List<Heart> hearts = new ArrayList<>();
    private List<Star> stars = new ArrayList<>();
    private List<Winner> winners = new ArrayList<>();
    private List <Checkpoint> checkpoints = new ArrayList<>();

    public Gameplay(String filename, int level) throws IOException {
        super(filename);
        createElements();
        this.level = level;
    }

    public Boy getBoy() {
        if (boy == null) return new Boy(80, 20, "#0000FF");
        else return boy;
    }
    public Girl getGirl() {
        if (girl == null) return new Girl(80, 24, "#FFC0CB");
        else return girl;
    }

    public List<Wall> getWalls() {return walls;}

    public List<Monster> getMonsters() {return monsters;}

    public List<Door> getDoors() {return doors;}

    public List<Button> getButtons() {return buttons;}

    public List<Arrow> getArrows() {return arrows;}

    public List<Crack> getCracks() {return cracks;}

    public List<Heart> getHearts() {return hearts;}

    public List<Star> getStars() {return stars;}

    public List<Winner> getWinners() {return winners;}

    public List<Checkpoint> getCheckpoints() {return checkpoints;}

    private void createElements() {
        for (int i = 0; i < getBackground().size(); i++) {
            for (int j = 0; j < getBackground().get(i).length(); j++) {
                if (getBackground().get(i).charAt(j) == '=') walls.add(new Wall(j, i, "#FFFFFF"));
                else if (getBackground().get(i).charAt(j) == 'm') monsters.add(new Monster(j, i, "#993333"));
                else if (getBackground().get(i).charAt(j) == 'é') doors.add(new Door(j, i,  "#ADD8E6"));
                else if (getBackground().get(i).charAt(j) == 'á') buttons.add(new Button(j, i, 0, "#ADD8E6"));
                else if (getBackground().get(i).charAt(j) == 'è') doors.add(new Door(j, i, "#FFA500"));
                else if (getBackground().get(i).charAt(j) == 'à') buttons.add(new Button(j, i, 0,  "#FFA500"));
                else if (getBackground().get(i).charAt(j) == 'ê') doors.add(new Door(j, i, "#800080"));
                else if (getBackground().get(i).charAt(j) == 'â') buttons.add(new Button(j, i, 0, "#800080"));
                else if (getBackground().get(i).charAt(j) == 'ẽ') doors.add(new Door(j, i, "#FFFFFF"));
                else if (getBackground().get(i).charAt(j) == 'ã') buttons.add(new Button(j, i, 10, "#FFFFFF"));
                else if (getBackground().get(i).charAt(j) == '|') arrows.add(new Arrow(j, i, "#800080", "up"));
                else if (getBackground().get(i).charAt(j) == '-') arrows.add(new Arrow(j, i, "#800080", "right"));
                else if (getBackground().get(i).charAt(j) == 'y') cracks.add(new Crack(j, i, "#FFFFFF", true));
                else if (getBackground().get(i).charAt(j) == 'n') cracks.add(new Crack(j, i, "#FFFFFF", false));
                else if (getBackground().get(i).charAt(j) == 'h') hearts.add(new Heart(j, i, "#993333"));
                else if (getBackground().get(i).charAt(j) == 's') stars.add(new Star(j, i, "#FFFF00"));
                else if (getBackground().get(i).charAt(j) == 'd') doors.add(new Door(j, i, "#FFFF00"));
                else if (getBackground().get(i).charAt(j) == '1') this.boy = new Boy(j, i, "#0000FF");
                else if (getBackground().get(i).charAt(j) == '2') this.girl = new Girl(j, i, "#FFC0CB");
                else if (getBackground().get(i).charAt(j) == 'w') winners.add(new Winner(j, i, "#000000"));
                else if (getBackground().get(i).charAt(j) == 'c') checkpoints.add(new Checkpoint(j, i, "#00FF00"));
            }
        }
    }

}
