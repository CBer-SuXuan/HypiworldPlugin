package me.suxuan.hypi.commands;

import me.suxuan.hypi.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.model.SimpleComponent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SearchCommand extends SimpleCommand {
	private static final SearchCommand instance = new SearchCommand();

	public SearchCommand() {
		super("search-player");
		setAutoHandleHelp(false);
		setPermission(null);
	}

	@Override
	protected void onCommand() {
		if (!sender.hasPermission("hypi.command.hyreload")) {
			Common.tellNoPrefix(sender, "Unknown command. Type \"/help\" for help.");
			return;
		}
		if (args.length == 0) {
			Common.tellNoPrefix(sender, "&c&l请输入想查询的玩家姓名或UUID!");
		} else {
			String find = args[0];
			String rootStr = Main.getInstance().getServer().getWorldContainer().getAbsolutePath();
			String playerCache = rootStr.substring(0, rootStr.length() - 1) + "usercache.json";
			try {
				String caches = Files.readAllLines(Paths.get(playerCache)).get(0).replace("[", "").replace("]", "");
				String regex = "\\{([^}])*}";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(caches);
				while (matcher.find()) {
					if (matcher.group().contains(find)) {
						String[] cache = matcher.group().replace("\"", "").replace("{", "").replace("}", "").split(",");
						System.out.println(Arrays.toString(cache));
						Common.tellNoPrefix(sender, "&6&l该玩家信息:");
						for (String detail : cache) {
							String[] temp = detail.split(":");
							if (temp[0].equals("expiresOn")) temp[1] = detail.replace("expiresOn:", "");
							if (sender instanceof Player player) {
								TextComponent component = SimpleComponent.of("  &b" + temp[0] + "&7: &a" + temp[1] + "&7(点击可以复制)")
										.onClick(ClickEvent.Action.COPY_TO_CLIPBOARD, temp[1])
										.build(sender);
								player.spigot().sendMessage(component);
							} else {
								Common.tellNoPrefix(sender, "  &b" + temp[0] + "&7: &a" + temp[1]);
							}
						}
						return;
					}
				}
				Common.tellNoPrefix(sender, "&c&l未找到该玩家!");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	protected List<String> tabComplete() {
		return NO_COMPLETE;
	}
}
