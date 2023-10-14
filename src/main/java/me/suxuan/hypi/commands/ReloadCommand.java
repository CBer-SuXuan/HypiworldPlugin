package me.suxuan.hypi.commands;

import me.suxuan.hypi.Main;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.List;

public final class ReloadCommand extends SimpleCommand {
	private static final ReloadCommand instance = new ReloadCommand();

	public ReloadCommand() {
		super("hyreload");
		setAutoHandleHelp(false);
		setPermission(null);
	}

	@Override
	protected void onCommand() {
		if (args.length != 0) return;
		if (sender instanceof Player player) {
			if (!player.hasPermission("hypi.command.hyreload")) {
				Common.tellNoPrefix(player, "Unknown command. Type \"/help\" for help.");
				return;
			} else {
				Main.getInstance().reload();
				Common.tellNoPrefix(player, "&a&lHypiworld插件重载成功!");
			}
		} else {
			Main.getInstance().reload();
			Common.tellNoPrefix(sender, "&a&lHypiworld插件重载成功!");
		}
	}

	@Override
	protected List<String> tabComplete() {
		return NO_COMPLETE;
	}
}
