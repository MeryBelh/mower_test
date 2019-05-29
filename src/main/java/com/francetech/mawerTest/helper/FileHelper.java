package com.francetech.mawerTest.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;



public class FileHelper {


	public static List<String> readFile(final String fileName) throws IOException {
		List<String> lines = new ArrayList<>();

		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classloader.getResourceAsStream(fileName);

		InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

		try {
			BufferedReader reader = new BufferedReader(streamReader);

			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line.trim());
			}
		} catch (IOException exception) {
			throw new IllegalArgumentException("Invalid File content");
		}

		return lines;
	}

}

