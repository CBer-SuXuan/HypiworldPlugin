package me.suxuan.hypi.settings;

import org.mineacademy.fo.settings.YamlStaticConfig;

public class Messages extends YamlStaticConfig {


	@Override
	protected void onLoad() {
		loadConfiguration("messages.yml");
	}

	public final static class Hat {
		public static String NO_ITEM;

		private static void init() {
			setPathPrefix(null);
			Hat.NO_ITEM = getString("NO_ITEM_IN_HAND");
		}
	}

	public static String SUICIDE;

	private static void init() {
		setPathPrefix(null);
		SUICIDE = getString("SUICIDE_MESSAGE");
	}

}
