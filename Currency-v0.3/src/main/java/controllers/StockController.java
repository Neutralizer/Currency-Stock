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
import model.stock.Stock;
import services.stock.StockService;

@Controller
public class StockController {

	@Autowired
	StockService stockService;

	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	public String currencies(Model model) {

		Collection<Stock> stockList = stockService.getAll();
		model.addAttribute("stockList", stockList);
		return "stock";
	}

	@RequestMapping(value = "/stock", method = RequestMethod.POST)
	public String search(Model model, @ModelAttribute("name") String name) {

		Collection<Stock> stockList = stockService.getAllLike(name);
		model.addAttribute("stockList", stockList);
		model.addAttribute("searchedValue", name);
		return "stock";
	}

	@RequestMapping(value = "/stock/edit", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam(value = "id", required = true) int id) {

		Stock stock = stockService.getById(id);
		model.addAttribute("stock", stock);

		return "stock-edit";
	}

	@RequestMapping(value = "/stock/edit", method = RequestMethod.POST)
	public String update(Model model, @ModelAttribute RequestData stockRequest) {
		Stock stock = new Stock.Builder().id(stockRequest.getId()).name(stockRequest.getName())
				.buy(stockRequest.getBuy()).sell(stockRequest.getSell()).build();

		stockService.update(stock);

		Collection<Stock> stockList = stockService.getAll();
		model.addAttribute("stockList", stockList);

		return "redirect:/stock";
	}

	@RequestMapping(value = "/stock/add", method = RequestMethod.GET)
	public String add(Model model) {

		return "stock-add";
	}

	@RequestMapping(value = "/stock/add", method = RequestMethod.POST)
	public String save(Model model, @ModelAttribute RequestData stockRequest) {
		Stock stock = new Stock.Builder().name(stockRequest.getName()).buy(stockRequest.getBuy())
				.sell(stockRequest.getSell()).build();

		stockService.add(stock);

		Collection<Stock> stockList = stockService.getAll();
		model.addAttribute("stockList", stockList);

		return "redirect:/stock";
	}

	@RequestMapping(value = "/stock/delete", method = RequestMethod.GET)
	public String delete(Model model, @RequestParam(value = "id", required = true) int id) {

		stockService.delete(id);

		Collection<Stock> stockList = stockService.getAll();
		model.addAttribute("stockList", stockList);

		return "redirect:/stock";
	}
}
