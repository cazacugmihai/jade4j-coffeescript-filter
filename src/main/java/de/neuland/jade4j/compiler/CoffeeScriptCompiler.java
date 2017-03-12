package de.neuland.jade4j.compiler;

import de.neuland.jade4j.IOUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public final class CoffeeScriptCompiler {

	private static Invocable invoker;
	private static Object coffeeScript;

	static {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
		invoker = (Invocable) engine;

		try {
			engine.eval(new FileReader(IOUtils.readFile("coffee-script.js")));
			coffeeScript = engine.eval("CoffeeScript");
		} catch (FileNotFoundException | ScriptException e) {
			throw new RuntimeException(e);
		}
	}

	private CoffeeScriptCompiler() {
	}

	public static String compile(String source) {
		try {
			return (String) invoker.invokeMethod(coffeeScript, "compile", source);
		} catch (NoSuchMethodException | ScriptException e) {
			throw new RuntimeException(e);
		}
	}

}
