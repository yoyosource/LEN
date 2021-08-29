package de.len;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class View {

    protected boolean visible = true;

    public final void setVisible(boolean visible) {
        this.visible = visible;
        if (!visible) hide();
    }

    public void hide() {

    }
    public abstract void draw(Graphics2D graphics2D);
    public abstract void key(KeyEvent keyEvent);
    public abstract void mouse(MouseEvent mouseEvent);
}
