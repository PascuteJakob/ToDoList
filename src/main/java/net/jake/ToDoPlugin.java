package net.jake;


import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.ui.overlay.OverlayManager;



@PluginDescriptor(
	name = "ToDo",
	description = "A simple to do list"
)
public class ToDoPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ToDoOverlay overlay;

	@Inject
	private ToDoConfig config;

	@Provides
	ToDoConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ToDoConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}
}