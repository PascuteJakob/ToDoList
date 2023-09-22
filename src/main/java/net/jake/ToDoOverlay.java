package net.jake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.EnumSet;
import javax.inject.Inject;
import net.runelite.api.Client;
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
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
        this.client = client;
        this.config = config;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        panelComponent.getChildren().clear();
        String overlayTitle = "To Do";

        //Build the overlay title
        panelComponent.getChildren().add(TitleComponent.builder()
                .text(overlayTitle)
                .color(Color.GREEN)
                .build());

        //Set the size of the overlay (width)
        panelComponent.setPreferredSize(new Dimension(
                graphics.getFontMetrics().stringWidth(overlayTitle) + 30,
                0));

        // Add a line on the overlay for world number
        panelComponent.getChildren().add(LineComponent.builder()
                .left("smol test")
                .right("BIG TEST")
                .build());

        return panelComponent.render(graphics);
    }
}