package de.len;

import de.len.command.CommandView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class IDE {

    private RootView rootView = new RootView();

    public IDE() {
        JFrame jFrame = new JFrame("OrganicIDE");
        jFrame.setSize(900, 700);
        jFrame.setMinimumSize(new Dimension(900, 700));
        jFrame.setContentPane(rootView);
        jFrame.setLocationRelativeTo(null);
        jFrame.setFocusTraversalKeysEnabled(false);
        jFrame.invalidate();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Thread redraw = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                rootView.repaint();
            }
        });
        redraw.setName("Redraw");
        redraw.start();

        jFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                rootView.viewList.forEach(view -> view.key(e));
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        rootView.viewList.add(new CommandView());

        while (true) {

        }
    }

    private static class RootView extends JComponent {

        private List<View> viewList = new ArrayList<>();

        @Override
        protected void paintComponent(Graphics g1) {
            Graphics2D g = (Graphics2D) g1;
            g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

            g.setColor(new Color(100, 100, 100));
            g.fillRect(0, 0, getWidth(), getHeight());

            viewList.forEach(view -> view.draw(g));
        }

    }

}
