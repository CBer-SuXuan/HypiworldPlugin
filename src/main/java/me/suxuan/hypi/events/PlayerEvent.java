package me.suxuan.hypi.events;

import cc.baka9.catseedlogin.bukkit.CatSeedLoginAPI;
import me.suxuan.hypi.settings.Config;
import me.suxuan.hypi.settings.Messages;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.mineacademy.fo.Common;

public class PlayerEvent implements Listener {

	@EventHandler
	public void onPlayerDeathEvent(PlayerDeathEvent event) {
		Player player = event.getEntity();
		if (player.getScoreboardTags().contains("suicide")) {
			player.removeScoreboardTag("suicide");
			event.setDeathMessage(Common.colorize(Messages.SUICIDE.replace("{player}", player.getName())));
		}
	}

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		Common.tellNoPrefix(event.getPlayer(), Config.JOIN_MESSAGE.replace("{LoginOrRegister}",
				CatSeedLoginAPI.isRegister(event.getPlayer().getName()) ? "登录" : "注册"));
	}

}
