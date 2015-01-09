package com.flyingh.util;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Base64Util {
	private static final ScriptEngine ENGINE;
	static {
		ENGINE = new ScriptEngineManager().getEngineByName("JavaScript");
		try {
			ENGINE.eval(new FileReader(Base64Util.class.getResource("base64.js").getPath()));
		} catch (FileNotFoundException | ScriptException e) {
			e.printStackTrace();
		}
	}

	public static String encode(String content) throws ScriptException {
		return (String) ENGINE.eval("base64.encode('" + content + "')");
	}

	public static String decode(String encodedContent) throws ScriptException {
		return (String) ENGINE.eval("base64.decode('" + encodedContent + "')");
	}
}
