package boygirl.guihelp;

import boygirl.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGui {
    public Screen screen;
    public enum input {wup, aleft, sdown, dright, up, left, down, right, back, enter, none};

    public LanternaGui(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        screen = createScreen(createTerminal(width,height, fontConfig));
    }

    public Screen getScreen() {return screen;}

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new
                DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square-final1.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public input getInput() throws IOException {
        KeyStroke ks = screen.pollInput();
        if (ks == null) return input.none;

        if (ks.getKeyType() == KeyType.Character) {
            if (ks.getCharacter() == 'w') return input.wup;
            else if (ks.getCharacter() == 'a') return input.aleft;
            else if (ks.getCharacter() == 's') return input.sdown;
            else if (ks.getCharacter() == 'd') return input.dright;
        }
        else if (ks.getKeyType() == KeyType.ArrowUp) return input.up;
        else if (ks.getKeyType() == KeyType.ArrowDown) return input.down;
        else if (ks.getKeyType() == KeyType.ArrowLeft) return input.left;
        else if (ks.getKeyType() == KeyType.ArrowRight) return input.right;
        else if (ks.getKeyType() == KeyType.Escape) return input.back;
        else if (ks.getKeyType() == KeyType.Enter) return input.enter;

        return input.none;
    }

    public void drawString(int x, int y, String string, String color) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(x, y, string);
    }

    public boolean hasChar(Position position) {
        return !getScreen().getFrontCharacter(position.getX(), position.getY()).getCharacterString().equals(" ");
    }

    public void clear() {screen.clear();}
    public void close() throws IOException {screen.close();}
    public void refresh() throws IOException {screen.refresh();}
}
