package iana;

import iana.command.Command;
import iana.exception.IanaException;
import iana.parser.Parser;
import iana.storage.Storage;
import iana.tasks.TaskList;
import iana.ui.Ui;

/**
 * Represents the command line interface Iana used to manage tasks.
 */
public class Iana {

    /** Task list */
    private TaskList tasks;

    /** Ui to show the program's response to user input */
    private Ui ui;

    /**
     * Constructor for Iana class to initialise Iana app.
     */
    public Iana() {
        tasks = new TaskList();
        ui = new Ui();
        try {
            tasks = Storage.load();
        } catch (IanaException e) {
            ui.say(e.getMessage());
        }
    }

    /**
     * Returns response from Iana given user input.
     *
     * @param input the user input to be responded to.
     * @return IANA's response.
     */
    public String getResponse(String input) {
        try {
            Command command = Parser.parse(input);
            return command.execute(tasks, ui);
        } catch (IanaException e) {
            return e.getMessage();
        }
    }

    /**
     * Returns a welcome message from Iana.
     *
     * @return the welcome message.
     */
    public String getHi() {
        return ui.sayHi();
    }

    /**
     * Returns help for app usage from Iana.
     *
     * @return string of available commands to input.
     */
    public String getHelp() {
        return ui.help();
    }

    /**
     * Checks if user input is an exit command.
     *
     * @param input the user input.
     * @return true if user input is exit command.
     */
    public boolean isExitCommand(String input) {
        try {
            Command command = Parser.parse(input);
            return command.isExit();
        } catch (IanaException e) {
            return false;
        }
    }
}