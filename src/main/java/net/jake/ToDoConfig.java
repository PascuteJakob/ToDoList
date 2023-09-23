package net.jake;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("ToDo")
public interface ToDoConfig extends Config
{
    @ConfigItem(
            position = 1,
            keyName = "toDoCSV",
            name = "testName1",
            description = "set the data",
            hidden = true
    )
    void setToDoCSV(String val);
   @ConfigItem(
           position = 1,
           keyName = "toDoCSV",
           name = "testName2",
           description = "CSV of to do data",
           hidden = false
   )
   //CSV structure = text, timestamp of last completion, interval
    default String toDoCSV() {return "Reminder 1, 10000000, 500\nReminder 2, 20000000, 500\nReminder 3, 30000000, 500";}
}