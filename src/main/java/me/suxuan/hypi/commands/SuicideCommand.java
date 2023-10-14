package me.suxuan.hypi.commands;

import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.List;

public final class SuicideCommand extends SimpleCommand {
	private static final SuicideCommand instance = new SuicideCommand();

	public SuicideCommand() {
		super("suicide");
		setAutoHandleHelp(false);
		setPermission(null);
	}

	@Override
	protected void onCommand() {
		if (args.length != 0) return;
		if (!(sender instanceof Player player)) {
			Common.tellNoPrefix(sender, "&c&l只有玩家可以使用这个命令");
			return;
		}
		player.setHealth(0);
		player.addScoreboardTag("suicide");
	}

	@Override
	protected List<String> tabComplete() {
		return NO_COMPLETE;
	}
}
