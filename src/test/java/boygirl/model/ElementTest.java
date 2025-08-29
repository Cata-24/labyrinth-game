package boygirl.model;

import boygirl.model.elements.Boy;
import boygirl.model.elements.Element;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;

public class ElementTest {

    Element element;

    @Property
    void moveDown(@ForAll int x, @ForAll int y) {
        element = new Boy(x, y, "");

        Assertions.assertEquals(x, element.moveDown().getX());
        Assertions.assertEquals(y + 1, element.moveDown().getY());
    }

    @Property
    void moveLeft(@ForAll int x, @ForAll int y) {
        element = new Boy(x, y, "");

        Assertions.assertEquals(x - 1, element.moveLeft().getX());
        Assertions.assertEquals(y, element.moveLeft().getY());
    }

    @Property
    void moveUp(@ForAll int x, @ForAll int y) {
        element = new Boy(x, y, "");

        Assertions.assertEquals(x, element.moveUp().getX());
        Assertions.assertEquals(y - 1, element.moveUp().getY());
    }

    @Property
    void moveRight(@ForAll int x, @ForAll int y) {
        element = new Boy(x, y, "");

        Assertions.assertEquals(x + 1, element.moveRight().getX());
        Assertions.assertEquals(y, element.moveRight().getY());
    }
}
