package net.jake;

import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import java.util.ArrayList;


public class ToDoHelper {
    private ToDoConfig config;
    @Getter
    @Setter
    ArrayList<String> toDoListText = new ArrayList<String>();
    public ToDoHelper(ToDoConfig config)
    {
        this.config = config;
        String localString = config.toDoCSV();
        String[] splitString = localString.split("\n");
        for(String i : splitString)
        {
            String[] iSplit = i.split(",");
            toDoListText.add(iSplit[0]);
        }
    }
}