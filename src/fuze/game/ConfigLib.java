package fuze.game;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLib {

	private Properties	prop;
	@SuppressWarnings("unused")
	private String		curKey	= "";

	public ConfigLib() {
		prop = new Properties();
	}

	public void start() throws IOException {
		prop.load(new FileInputStream(new File("config.cfg")));
	}

	public ConfigLib cfg(String key) {

		return this;
	}

	public int asInt() {
		return 0;
	}

	public static class ConfigStatic {

		private static ConfigLib	lib	= null;

		public static ConfigLib cfg(String key) {

			return lib.cfg(key);
		}

		{
			lib = new ConfigLib();
		}

	}

}
