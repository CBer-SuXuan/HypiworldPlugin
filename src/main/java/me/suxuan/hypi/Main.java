package me.suxuan.hypi;

import cc.baka9.catseedlogin.bukkit.CatSeedLoginAPI;
import me.suxuan.hypi.commands.HatCommand;
import me.suxuan.hypi.commands.ReloadCommand;
import me.suxuan.hypi.commands.SearchCommand;
import me.suxuan.hypi.commands.SuicideCommand;
import me.suxuan.hypi.events.PlayerEvent;
import me.suxuan.hypi.settings.Config;
import me.suxuan.hypi.tasks.EchoTask;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;

public final class Main extends SimplePlugin {

	@Override
	protected void onPluginStart() {
		CatSeedLoginAPI.isLogin("test");
		registerCommand(new HatCommand());
		registerCommand(new SuicideCommand());
		registerCommand(new ReloadCommand());
		registerCommand(new SearchCommand());
		registerEvents(new PlayerEvent());
		Common.runTimer(Config.INTERVAL * 20, new EchoTask());
	}

	public static Main getInstance() {
		return (Main) SimplePlugin.getInstance();
	}

	@Override
	protected void onPluginReload() {
	}
}
