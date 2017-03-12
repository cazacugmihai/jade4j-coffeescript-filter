package de.neuland.jade4j.filter;

import de.neuland.jade4j.compiler.CoffeeScriptCompiler;
import de.neuland.jade4j.parser.node.Attr;

import java.util.List;

public class CoffeeScriptFilter extends CachingFilter {

	private static final String SCRIPT_START = "<script type=\"text/javascript\">";
	private static final String SCRIPT_END = "</script>";

	@Override
	protected String convert(String source, List<Attr> list) {
		return SCRIPT_START + CoffeeScriptCompiler.compile(source) + SCRIPT_END;
	}

}
