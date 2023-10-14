package me.suxuan.hypi.commands;

import me.suxuan.hypi.settings.Messages;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.List;

public final class HatCommand extends SimpleCommand {

	public HatCommand() {
		super("hat");
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
		Material material = player.getInventory().getItemInMainHand().getType();
		if (material.equals(Material.AIR)) {
			Common.tellNoPrefix(player, Messages.Hat.NO_ITEM);
			return;
		}
		if (player.getInventory().getHelmet() == null) {
			ItemStack hat = new ItemStack(material, 1);
			player.getInventory().setHelmet(new ItemStack(hat));
			player.getInventory().removeItem(hat);
		} else {
			ItemStack newHat = new ItemStack(material, 1);
			ItemStack oldHat = new ItemStack(player.getInventory().getHelmet());
			player.getInventory().addItem(oldHat);
			player.getInventory().setHelmet(new ItemStack(newHat));
			player.getInventory().removeItem(newHat);
		}
	}

	@Override
	protected List<String> tabComplete() {
		return NO_COMPLETE;
	}
}
