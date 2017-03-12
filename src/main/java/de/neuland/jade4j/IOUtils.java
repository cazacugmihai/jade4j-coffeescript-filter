package de.neuland.jade4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public final class IOUtils {

	private IOUtils() {
	}

	public static String getResourceContent(String path) throws IOException {
		InputStream input = ClassLoader.getSystemClassLoader().getResourceAsStream(path);

		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
			return buffer.lines().collect(Collectors.joining("\n"));
		}
	}

}
