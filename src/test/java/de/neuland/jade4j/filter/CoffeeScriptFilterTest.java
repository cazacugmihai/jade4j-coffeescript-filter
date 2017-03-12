package de.neuland.jade4j.filter;

import de.neuland.jade4j.IOUtils;
import de.neuland.jade4j.JadeConfiguration;
import org.junit.Test;

import java.io.IOException;

import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertEquals;

public class CoffeeScriptFilterTest {

	@Test
	public void jade() throws Exception {
		String expected = IOUtils.readFileContent("coffee.html");
		String actual = jadeToHtml("src/test/resources/coffee.jade");

		assertEquals(expected, actual);
	}

	private String jadeToHtml(String path) throws IOException {
		JadeConfiguration jade = new JadeConfiguration();
		jade.setFilter("coffeescript", new CoffeeScriptFilter());

		return jade.renderTemplate(jade.getTemplate(path), emptyMap());
	}

}
