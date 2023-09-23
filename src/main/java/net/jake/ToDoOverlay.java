package net.jake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;

import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.LineComponent;
import java.util.ArrayList;


class ToDoOverlay extends Overlay {
    private ToDoConfig config;
    private final PanelComponent panelComponent = new PanelComponent();
    private ToDoHelper todos;
    private Client client;



    public ToDoOverlay(Client client, ToDoConfig config) {
        setPosition(OverlayPosition.BOTTOM_LEFT);
        this.client = client;
        this.config = config;
        addMenuEntry(MenuAction.RUNELITE_OVERLAY, "Add item", "To Do", e -> addEntry());

        //Create list object and add to global var
        todos = new ToDoHelper(config);
        ArrayList<String> toDoList = todos.getToDoListText();
        //Iterate to add menu entries
        int count = 0;
        for(String i : toDoList)
        {
            final int index = count;
            addMenuEntry(MenuAction.RUNELITE_OVERLAY, "Complete item", "To Do: " + String.valueOf(count), e -> completeEntry(index));
            addMenuEntry(MenuAction.RUNELITE_OVERLAY, "Delete item", "To Do: " + String.valueOf(count), e -> deleteEntry(index));
            count += 1;
        }
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        panelComponent.getChildren().clear();
        String overlayTitle = "To Do";
        String lineOne = "this is a test line";

        //Build the overlay title
        panelComponent.getChildren().add(TitleComponent.builder()
                .text(overlayTitle)
                .color(Color.WHITE)
                .build());

        //Set the size of the overlay
        panelComponent.setPreferredSize(new Dimension(
                200,
                0));

        // Add lines
        int count = 0;
        ArrayList<String> toDoListText = todos.getToDoListText();
        for(String i : toDoListText)
        {
            panelComponent.getChildren().add(LineComponent.builder()
                    .left(String.valueOf(count) + ") " + i)
                    //.right("BIG TEST")
                    .build());
            count += 1;
        }

        return panelComponent.render(graphics);
    }
    private void addEntry()
    {
        client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "add", null);
    }
    private void deleteEntry(int index)
    {
        //client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", ToDoList[index], null);
        todos.getToDoListText().remove(index);

    }
    private void completeEntry(int index)
    {
        client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", todos.getToDoListText().get(index), null);
    }
}