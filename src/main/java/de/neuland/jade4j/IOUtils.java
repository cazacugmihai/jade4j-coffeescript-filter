package de.neuland.jade4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public final class IOUtils {

	private IOUtils() {
	}

	public static File readFile(String path) throws FileNotFoundException {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		URL resource = classLoader.getResource(path);

		if (resource == null) {
			throw new FileNotFoundException("Cannot find file " + path);
		}

		return new File(resource.getFile());
	}

	public static String readFileContent(String path) throws IOException {
		return new String(Files.readAllBytes(readFile(path).toPath()));
	}

}
