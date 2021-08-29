package de.len.command;

import java.util.List;

public interface Command {
    String command();
    default String[] preview() {
        return new String[]{command()};
    }
    boolean execute(String[] arguments);
}
