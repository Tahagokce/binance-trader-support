package com.binance.trader.support.mapper;

import com.binance.trader.support.models.dtos.TrackingModelDto;
import com.binance.trader.support.models.entities.TrackingModel;
import org.springframework.stereotype.Component;

@Component
public class TrackingModelMapper implements BaseMapper<TrackingModel, TrackingModelDto> {
    @Override
    public TrackingModel toModel(TrackingModelDto trackingModelDto) {
        TrackingModel trackingModel = new TrackingModel();
        trackingModel.setId(trackingModel.getId());
        trackingModel.setSymbol(trackingModel.getSymbol());
        trackingModel.setPrice(trackingModel.getPrice());
        trackingModel.setOldPrice(trackingModel.getOldPrice());
        return trackingModel;
    }

    @Override
    public TrackingModelDto toDto(TrackingModel trackingModel) {
        TrackingModelDto trackingModelDto = new TrackingModelDto();
        trackingModelDto.setId(trackingModel.getId());
        trackingModelDto.setSymbol(trackingModel.getSymbol());
        trackingModelDto.setPrice(trackingModel.getPrice());
        trackingModelDto.setOldPrice(trackingModel.getOldPrice());
        return trackingModelDto;
    }
}
