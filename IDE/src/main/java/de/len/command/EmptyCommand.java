package de.len.command;

public class EmptyCommand implements Command {

    @Override
    public String command() {
        return "empty";
    }

    @Override
    public String[] preview() {
        return new String[]{command(), command() + " line <LINE>"};
    }

    @Override
    public boolean execute(String[] arguments) {
        return false;
    }
}
