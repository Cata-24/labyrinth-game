package boygirl.model;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;

public class PositionTest {
    Position position;

    @Property
    void setY(@ForAll int x, @ForAll int y, @ForAll int z) {
        position = new Position(x, y);
        position.setY(z);
        Assertions.assertEquals(z, position.getY());
        Assertions.assertEquals(x, position.getX());
    }

    @Property
    void setX(@ForAll int x, @ForAll int y, @ForAll int z) {
        position = new Position(x, y);
        position.setX(z);
        Assertions.assertEquals(z, position.getX());
        Assertions.assertEquals(y, position.getY());
    }
}
