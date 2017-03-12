package de.neuland.jade4j.filter;

import de.neuland.jade4j.parser.node.Attr;
import org.jcoffeescript.JCoffeeScriptCompileException;
import org.jcoffeescript.JCoffeeScriptCompiler;

import java.util.List;

public class CoffeeScriptFilter extends CachingFilter {

	private static final String SCRIPT_START = "<script type=\"text/javascript\">";
	private static final String SCRIPT_END = "</script>";

	@Override
	protected String convert(String source, List<Attr> list) {
		JCoffeeScriptCompiler compiler = new JCoffeeScriptCompiler();
		try {
			return SCRIPT_START + compiler.compile(source) + SCRIPT_END;
		} catch (JCoffeeScriptCompileException e) {
			return e.toString();
		}
	}

}
