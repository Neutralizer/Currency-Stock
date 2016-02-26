package services.currency;

import java.util.Collection;

import model.currency.Currency;

public interface CurrencyService {
	
	Collection<Currency> getAll();
	
	Collection<Currency> getAllLike(String key);
	
	Currency getById(int id);
	
	void add(Currency currency);

	void update(Currency currency);

	void delete(int id);
}
