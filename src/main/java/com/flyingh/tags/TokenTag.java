package com.flyingh.tags;

import java.io.IOException;
import java.io.Writer;
import java.util.UUID;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TokenTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		getJspBody().invoke(null);
	}

	@Override
	public void setJspContext(JspContext jspContext) {
		super.setJspContext(jspContext);
		setJspBody(new JspFragment() {

			@Override
			public void invoke(Writer out) throws JspException, IOException {
				if (out == null) {
					invoke(jspContext.getOut());
				} else {
					final UUID uuid = UUID.randomUUID();
					jspContext.setAttribute("token", uuid.toString(), PageContext.SESSION_SCOPE);
					out.write(String.format("<input type='hidden' name='token' value='%s'>", uuid));
				}
			}

			@Override
			public JspContext getJspContext() {
				return jspContext;
			}
		});
	}
}
