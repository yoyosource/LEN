package de.len.command;

import de.len.View;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandView extends View {

    private StringBuilder currentCommand = new StringBuilder();
    private List<Command> commandList = new ArrayList<>();

    public CommandView() {
        visible = false;

        commandList.add(new EmptyCommand());
    }

    @Override
    public void hide() {
        currentCommand = new StringBuilder();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        if (!visible) {
            return;
        }

        List<Command> commandList = this.commandList.stream().filter(command -> {
            String s = currentCommand.toString();
            if (s.contains(" ")) {
                return command.command().equals(s.split(" ")[0]);
            } else {
                return command.command().startsWith(s);
            }
        }).collect(Collectors.toList());
        if (currentCommand.length() == 0) commandList.clear();
        List<String> strings = commandList.stream().map(Command::preview).flatMap(Arrays::stream).collect(Collectors.toList());

        int width = graphics2D.getClipBounds().width;
        int height = graphics2D.getClipBounds().height;

        graphics2D.setColor(Color.GRAY);
        graphics2D.fillRoundRect(width / 2 - 300, 50, 600, 40 + strings.size() * 40, 5, 5);

        if (!commandList.isEmpty()) {
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawRoundRect(width / 2 - 300, 50, 600, 40, 5, 5);
        }

        graphics2D.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 24));
        if (!commandList.isEmpty()) {
            graphics2D.setColor(new Color(50, 50, 50));
            graphics2D.drawString(commandList.get(0).command(), width / 2 - 300 + 5, 50 + graphics2D.getFontMetrics().getHeight());
        }

        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(currentCommand.toString(), width / 2 - 300 + 5, 50 + graphics2D.getFontMetrics().getHeight());

        for (int i = 0; i < strings.size(); i++) {
            graphics2D.drawString(strings.get(i), width / 2 - 300 + 5, 50 + graphics2D.getFontMetrics().getHeight() + 40 * (i + 1));
        }
    }

    @Override
    public void key(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == '\t') {
            setVisible(true);
            return;
        }
        if (!visible) {
            return;
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            return;
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_SHIFT) {
            return;
        }
        if (keyEvent.getKeyChar() == '\n') {
            Command cmd = commandList.stream().filter(command -> {
                String s = currentCommand.toString();
                if (s.contains(" ")) {
                    return command.command().equals(s.split(" ")[0]);
                } else {
                    return command.command().startsWith(s);
                }
            }).findFirst().orElse(null);
            if (cmd == null) {
                return;
            }
            String[] strings = currentCommand.toString().split(" ");
            if (strings.length - 1 >= 0) System.arraycopy(strings, 1, strings, 0, strings.length - 1);
            if (cmd.execute(Arrays.copyOf(strings, strings.length - 1))) {
                setVisible(false);
            }
            return;
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_DELETE) {
            if (currentCommand.length() > 0) {
                currentCommand.deleteCharAt(currentCommand.length() - 1);
            }
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (currentCommand.length() > 0) {
                currentCommand.deleteCharAt(currentCommand.length() - 1);
            }
        } else {
            currentCommand.append(keyEvent.getKeyChar());
        }
    }

    @Override
    public void mouse(MouseEvent mouseEvent) {

    }
}
