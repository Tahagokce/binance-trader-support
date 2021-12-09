package com.binance.trader.support.api.controller;

import com.binance.api.client.domain.market.TickerStatistics;
import com.binance.trader.support.business.TrackingService;
import com.binance.trader.support.business.abstracts.SymbolService;
import com.binance.trader.support.mapper.TrackingModelMapper;
import com.binance.trader.support.models.dtos.TrackingModelDto;
import com.binance.trader.support.models.entities.TrackingModel;
import com.core.utilities.results.DataResult;
import com.core.utilities.results.ErrorDataResult;
import com.core.utilities.results.ErrorResult;
import com.core.utilities.results.Result;
import com.core.utilities.results.SuccessDataResult;
import com.core.utilities.results.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("tracking")
@RequiredArgsConstructor
public class TrackingController {
    private final TrackingService trackingService;
    private final TrackingModelMapper trackingModelMapper;
    private final SymbolService symbolService;


    @PostMapping("save")
    public DataResult<TrackingModelDto> save(@RequestBody TrackingModelDto trackingModelDto) {
        if (Objects.nonNull(trackingModelDto)) {
            TrackingModel trackingModel = trackingModelMapper.toModel(trackingModelDto);
            trackingService.save(trackingModel);
            return new SuccessDataResult<>(trackingModelDto, "Success");
        }
        return new ErrorDataResult<>("Error");
    }

    @PostMapping("delete")
    public Result delete(@RequestBody TrackingModelDto trackingModelDto) {
        if (Objects.nonNull(trackingModelDto)) {
            TrackingModel trackingModel = trackingModelMapper.toModel(trackingModelDto);
            trackingService.delete(trackingModel);
            return new SuccessResult("Success");
        }
        return new ErrorResult("Error");
    }

    @PostMapping("update")
    public DataResult<TrackingModelDto> update(@RequestBody TrackingModelDto trackingModelDto) {
        if (Objects.nonNull(trackingModelDto)) {
            TrackingModel trackingModel = trackingModelMapper.toModel(trackingModelDto);
            trackingService.save(trackingModel);
            return new SuccessDataResult<>(trackingModelDto, "Success");
        }
        return new ErrorDataResult<>("Error");
    }

    @GetMapping("find-by-id")
    public DataResult<TrackingModelDto> findById(@RequestParam Long id) {
        TrackingModel trackingModel = this.trackingService.findById(id).getData();
        if (Objects.nonNull(trackingModel)) {
            TrackingModelDto trackingModelDto = trackingModelMapper.toDto(trackingModel);
            return new SuccessDataResult<>(trackingModelDto, "Success");
        }
        return new ErrorDataResult<>("Error");
    }

    @GetMapping("symbol-add")
    public DataResult<TickerStatistics> symbolAdd(@RequestParam String  symbol) {
          var a = symbolService.latestPriceOfSymbol(symbol).getData();
          return new SuccessDataResult<>(a);

    }

}
