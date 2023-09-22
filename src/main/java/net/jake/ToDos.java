package net.jake;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

public class ToDos {
    @Getter
    @Setter
    ArrayList<String> toDoList = new ArrayList<String>();
    public ToDos()
    {
        toDoList.add("line 0");
        toDoList.add("line 1");
        toDoList.add("line 2");
        toDoList.add("line 3");
        toDoList.add("line 4");
    }
}