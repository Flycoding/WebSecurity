package com.flyingh.tags;

import java.io.IOException;

import javax.script.ScriptException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.flyingh.util.Base64Util;

public class UrlTag extends SimpleTagSupport {
	private String url;
	private String var;

	@Override
	public void doTag() throws JspException, IOException {
		try {
			int index = url.indexOf("?");
			String prefix = url.substring(0, index);
			Object suffix = Base64Util.encode(url.substring(index + 1));
			PageContext pageContext = (PageContext) getJspContext();
			HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
			String result = response.encodeURL(prefix + "?" + suffix);
			if (var != null) {
				pageContext.setAttribute(var, result);
			} else {
				pageContext.getOut().write(result);
			}
		} catch (ScriptException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setVar(String var) {
		this.var = var;
	}

}
