package com.assign.domino.feign.stock.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StockResponse(Chart chart) {

	public List<Long> getTimeStamps() {
		return this.chart.result.get(0).timeStamps;
	}

	public List<Long> getOpens() {
		return this.getQuote().opens;
	}

	public List<Long> getCloses() {
		return this.getQuote().closes;
	}

	public List<Long> getHighs() {
		return this.getQuote().highs;
	}

	public List<Long> getLows() {
		return this.getQuote().lows;
	}

	public List<Long> getVolumes() {
		return this.getQuote().volumes;
	}

	private Chart.Result.Indicators.Quote getQuote() {
		return this.chart.result.get(0).indicators.quote.get(0);
	}

	public record Chart(List<Result> result) {
		public record Result(
			Meta meta,
			@JsonProperty("timestamp") List<Long> timeStamps,
			Indicators indicators) {
			public record Meta() {
			}

			public record Indicators(List<Quote> quote) {
				public record Quote(
					@JsonProperty("open") List<Long> opens,
					@JsonProperty("close") List<Long> closes,
					@JsonProperty("high") List<Long> highs,
					@JsonProperty("low") List<Long> lows,
					@JsonProperty("volume") List<Long> volumes
				) {
				}
			}
		}
	}
}
