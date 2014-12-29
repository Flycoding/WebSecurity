package com.flyingh.app;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flyingh.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute User user, HttpSession session) {
		if ("admin".equals(user.getUsername()) && "password".equals(user.getPassword())) {
			session.setAttribute("user", user);
			return "redirect:/";
		}
		return "/login";
	}
}
