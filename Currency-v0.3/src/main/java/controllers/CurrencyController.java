package controllers;

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
import services.currency.CurrencyService;

@Controller
public class CurrencyController {

	@Autowired
	CurrencyService currencyService;

	@RequestMapping(value = "/currency", method = RequestMethod.GET)
	public String currencies(Model model) {
		
		Collection<Currency> currencyList = currencyService.getAll();
		model.addAttribute("currencyList", currencyList);
		return "currency";
	}
	
	@RequestMapping(value = "/currency", method = RequestMethod.POST)
	public String search(Model model, @ModelAttribute("name") String name) {
		Collection<Currency> currencyList = currencyService.getAllLike(name);
		model.addAttribute("currencyList", currencyList);
		model.addAttribute("searchedValue", name);
		return "currency";
	}

	@RequestMapping(value = "/currency/edit", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam(value = "id", required = true) int id) {
		
		Currency currency = currencyService.getById(id);
		model.addAttribute("currency", currency);
		
		return "currency-edit";
	}

	@RequestMapping(value = "/currency/edit", method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute RequestData currencyRequest) {
		
		String floatRegexValidator = "^[0-9.]{1,15}$";

		if (currencyRequest.getName().equals("") 
				|| currencyRequest.getBuy().equals("")
				|| currencyRequest.getSell().equals("")
				|| !currencyRequest.getBuy().matches(floatRegexValidator)
				|| !currencyRequest.getSell().matches(floatRegexValidator)) {
			model.addAttribute("error", "All fields must be valid!");

			return edit(model, currencyRequest.getId());
		} else {
		
		
		Currency currency = new Currency.Builder()
				.id(currencyRequest.getId())
				.name(currencyRequest.getName())
				.buy(currencyRequest.getBuy())
				.sell(currencyRequest.getSell())
				.build();

		currencyService.update(currency);


		return "redirect:/currency";
		}
	}
	
	
	
	@RequestMapping(value = "/currency/add", method = RequestMethod.GET)
	public String add(Model model) {
		
		return "currency-add";
	}
	
	@RequestMapping(value = "/currency/add", method = RequestMethod.POST)
	public String save(Model model, @ModelAttribute RequestData currencyRequest) {
		
		String floatRegexValidator = "^[0-9.]{1,15}$";

		if (currencyRequest.getName().equals("") 
				|| currencyRequest.getBuy().equals("")
				|| currencyRequest.getSell().equals("")
				|| !currencyRequest.getBuy().matches(floatRegexValidator)
				|| !currencyRequest.getSell().matches(floatRegexValidator)) {
			model.addAttribute("error", "All fields must be valid!");

			return add(model);
			
		} else {
		Currency currency = new Currency.Builder()
				.name(currencyRequest.getName())
				.buy(currencyRequest.getBuy())
				.sell(currencyRequest.getSell())
				.build();

		currencyService.add(currency);


		return "redirect:/currency";
		}
	}

	@RequestMapping(value = "/currency/delete", method = RequestMethod.GET)
	public String delete(Model model, @RequestParam(value = "id", required = true) int id) {
		
		currencyService.delete(id);
		
		Collection<Currency> currencyList = currencyService.getAll();
		model.addAttribute("currencyList", currencyList);
		
		return "redirect:/currency";
	}
}
