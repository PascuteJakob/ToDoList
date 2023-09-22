package net.jake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.EnumSet;
import javax.inject.Inject;

import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.WorldType;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.LineComponent;

class ToDoOverlay extends Overlay {
    private final Client client;
    private final ToDoConfig config;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    private ToDoOverlay(Client client, ToDoConfig config) {
        setPosition(OverlayPosition.BOTTOM_LEFT);
        this.client = client;
        this.config = config;
        addMenuEntry(MenuAction.RUNELITE_OVERLAY, "Add item", "To Do", e -> addEntry());
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

        // Add line under title
        panelComponent.getChildren().add(LineComponent.builder()
                .left(lineOne)
                //.right("BIG TEST")
                .build());

        return panelComponent.render(graphics);
    }
    private void addEntry()
    {
        client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "test", null);
    }
}