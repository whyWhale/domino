package com.assign.domino.config.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.assign.domino.domain.entity.StockType;

@Component
public class StockTypeConverter implements Converter<String, StockType> {
	@Override
	public StockType convert(String source) {
		return StockType.valueOf(source.toUpperCase());
	}
}
