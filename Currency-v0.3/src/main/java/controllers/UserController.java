package controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.RequestData;
import model.currency.Currency;
import model.user.Role;
import model.user.User;
import model.user.UserRequestData;
import services.currency.CurrencyService;
import services.user.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getRegistration(Model model) {
		// Collection<String> roleList = new ArrayList<String>();
		// roleList.add("user");
		// roleList.add("admin");
		Collection<Role> roleList = userService.getRoles();

		model.addAttribute("roleList", roleList);

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String register(Model model, @ModelAttribute UserRequestData userRequest) {

		String regexValidator = "^[A-Za-z0-9_-]{3,15}$";

		if (userRequest.getUsername().matches(regexValidator)
				&& userRequest.getPassword().matches(regexValidator)) {

			User user = new User();
			user.setUsername(userRequest.getUsername());
			user.setPassword(userRequest.getPassword());
			user.setRole(Role.valueOf(userRequest.getRole().toUpperCase()));

			boolean isUserExisting = userService.isExisting(user);

			if (isUserExisting) {
				model.addAttribute("error", "Username is taken!");
			} else {
				userService.create(user);
				model.addAttribute("success", "Username successfully created!");
			}

		} else {
			model.addAttribute("error", "Username or password is not valid!");
		}

		// Collection<Currency> currencyList = currencyService.getAll();
		// model.addAttribute("currencyList", currencyList);

		// return "redirect:/registration";
		return getRegistration(model);
	}

}
