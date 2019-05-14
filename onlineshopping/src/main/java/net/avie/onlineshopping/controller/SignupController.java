package net.avie.onlineshopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.avie.onlineshopping.model.User;
import net.avie.onlineshopping.service.UserService;

@Controller
public class SignupController {
	@Autowired
	public UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView showSignUp(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("signup");
		mav.addObject("user", new User());

		return mav;
	}

	@RequestMapping(value = "/signupProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	@ModelAttribute("user") User user) {

	userService.signup(user);

	return new ModelAndView("welcome", "firstname", user.getFirstName());
	}
}
