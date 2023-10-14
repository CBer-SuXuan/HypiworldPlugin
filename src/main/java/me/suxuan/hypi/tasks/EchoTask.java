package me.suxuan.hypi.tasks;

import me.suxuan.hypi.settings.Config;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.remain.Remain;

import java.util.List;

public class EchoTask implements Runnable {
	private List<String> messages = Config.MESSAGES;
	private int number = 0;

	@Override
	public void run() {
		for (Player player : Remain.getOnlinePlayers()) {
			if (messages.size() == number) number = 0;
			Common.tellNoPrefix(player, messages.get(number));
			number++;
		}
	}

}
