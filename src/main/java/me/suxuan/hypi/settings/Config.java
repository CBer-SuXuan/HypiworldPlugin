package me.suxuan.hypi.settings;

import org.mineacademy.fo.settings.YamlStaticConfig;

import java.util.List;

public class Config extends YamlStaticConfig {
	@Override
	protected void onLoad() {
		loadConfiguration("config.yml");
	}

	public static String JOIN_MESSAGE;
	public static Integer INTERVAL;
	public static List<String> MESSAGES;

	private static void init() {
		setPathPrefix(null);
		JOIN_MESSAGE = getString("Join");
		setPathPrefix("Echo");
		INTERVAL = getInteger("Interval");
		MESSAGES = getStringList("Messages");
	}
}
