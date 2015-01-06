package com.flyingh.tags;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TokenTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		final JspContext jspContext = getJspContext();
		final UUID uuid = UUID.randomUUID();
		jspContext.setAttribute("token", uuid.toString(), PageContext.SESSION_SCOPE);
		jspContext.getOut().write(String.format("<input type='hidden' name='token' value='%s'>", uuid));
	}
}
