package services.currency;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import dao.currency.CurrencyDao;
import model.currency.Currency;

public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	CurrencyDao currencyDao;

	public Collection<Currency> getAll() {

		// Currency currency = new Currency();
		// currency.setId(1);
		// currency.setName("Dollar");
		// currency.setBuy(1.35f);
		// currency.setSell(1.45f);

		Collection<Currency> currencies = currencyDao.findAll();
		// currencies.add(currency);

		return currencies;
	}

	public Collection<Currency> getAllLike(String key) {

		Collection<Currency> currencies = currencyDao.findAllLike(key);
		return currencies;
	}

	public Currency getById(int id) {
		return currencyDao.findById(id);
	}

	public void add(Currency currency) {
		currencyDao.insert(currency);

	}

	public void update(Currency currency) {
		currencyDao.update(currency);

	}

	public void delete(int id) {
		currencyDao.delete(id);
	}

}
