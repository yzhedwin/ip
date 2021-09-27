package duke.tasklist;
import duke.tasklist.task.Task;
import duke.tasklist.task.Deadlines;
import duke.tasklist.task.Todo;
import duke.tasklist.task.Events;
import duke.ui.Ui;
import java.util.ArrayList;

public class TaskList {

    protected int taskCount;

    public TaskList(ArrayList<Task> items) {
        loadTaskCount(items);
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void loadTaskCount(ArrayList<Task> items) {
        this.taskCount = items.size();
    }

    public void addEvent(ArrayList<Task> items, String description, String time) {
        Events newEvent = new Events(description, time);
        items.add(taskCount, newEvent);
    }

    public void addDeadline(ArrayList<Task> items, String description, String by) {
        Deadlines newDeadline = new Deadlines(description, by);
        items.add(taskCount, newDeadline);
    }

    public void addTodo(ArrayList<Task> items, String description) {
        Todo newTodo = new Todo(description);
        items.add(taskCount, newTodo);
    }

    public void removeItem(Ui ui, ArrayList<Task> items, int taskNum) {
        taskCount--;
        ui.removeTaskMessage(items.get(taskNum), taskCount);
        items.remove(taskNum);
    }

}

