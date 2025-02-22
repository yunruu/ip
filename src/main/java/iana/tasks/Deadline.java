package iana.tasks;

import java.io.Serializable;

import iana.utils.DateTime;

/**
 * Deadline task.
 */
public class Deadline extends Task implements Serializable {

    /** The time that the deadline is over */
    protected String endTime;

    /**
     * Constructor for Deadline class.
     * 
     * @param task string of task description.
     * @param endTime deadline time.
     * @param isCompleted true if task has been completed
     */
    public Deadline(String task, String endTime, boolean isCompleted) {
        super(task, "deadline", isCompleted);
        this.endTime = DateTime.parseToString(endTime);
    }

    @Override
    public String toFileData() {
        return "D | " + super.toFileData() + "| " + this.endTime;
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), endTime);
    }
}
