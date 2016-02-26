package model.currency;

public class Currency {
	private int id;
	private String name;
	private float buy;
	private float sell;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getBuy() {
		return buy;
	}

	public float getSell() {
		return sell;
	}

	public static class Builder {
		private int id;
		private String name;
		private float buy;
		private float sell;

		public Currency build() {
			Currency currency = new Currency();
			currency.id = this.id;
			currency.name = this.name;
			currency.buy = this.buy;
			currency.sell = this.sell;

			return currency;
		}

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder buy(float buy) {
			this.buy = buy;
			return this;
		}

		public Builder sell(float sell) {
			this.sell = sell;
			return this;
		}
	}
}
