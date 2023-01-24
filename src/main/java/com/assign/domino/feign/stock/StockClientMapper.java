package com.assign.domino.feign.stock;

import org.springframework.stereotype.Component;

import com.assign.domino.controller.dto.StockRequestDto;
import com.assign.domino.feign.stock.response.StockResponse;

@Component
public class StockClientMapper {

	public StockRequestDto toStockRequestDto(StockResponse stockResponse) {
		return StockRequestDto.builder()
			.opens(stockResponse.getOpens())
			.closes(stockResponse.getCloses())
			.highs(stockResponse.getHighs())
			.lows(stockResponse.getLows())
			.volumes(stockResponse.getVolumes())
			.timestamps(stockResponse.getTimeStamps())
			.build();
	}
}
