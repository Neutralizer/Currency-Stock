package model.stock;

import model.stock.Stock;

public class Stock {
	
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

		public Stock build() {
			Stock stock = new Stock();
			stock.id = this.id;
			stock.name = this.name;
			stock.buy = this.buy;
			stock.sell = this.sell;

			return stock;
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
