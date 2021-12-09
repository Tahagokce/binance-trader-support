package com.binance.trader.support.business.Impl;

import com.binance.trader.support.business.TrackingService;
import com.binance.trader.support.models.entities.TrackingModel;
import com.binance.trader.support.repository.TrackingRepository;
import com.core.utilities.results.DataResult;
import com.core.utilities.results.Result;
import com.core.utilities.results.SuccessDataResult;
import com.core.utilities.results.SuccessResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TrackingImpl implements TrackingService {
    private final TrackingRepository trackingRepository;
    @Override
    public DataResult<TrackingModel> findById(Long id) {
       TrackingModel trackingModel = trackingRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new SuccessDataResult<>(trackingModel,"Success.");
    }

    @Override
    public DataResult<TrackingModel> save(TrackingModel entity) {
        TrackingModel trackingModel = trackingRepository.save(entity);
        return new SuccessDataResult<>(trackingModel,"Success");
    }

    @Override
    public DataResult<TrackingModel> update(TrackingModel entity) {
        return null;
    }

    public DataResult<TrackingModel> update(TrackingModel entity,Double price) {
        entity.setPrice(price);
        TrackingModel trackingModel = trackingRepository.save(entity);
        return new SuccessDataResult<>(trackingModel,"Success");
    }

    @Override
    public Result delete(TrackingModel entity) {
        this.trackingRepository.delete(entity);
        return new SuccessResult("Success");
    }

    @Override
    public DataResult<List<TrackingModel>> findAll() {
        List<TrackingModel> result = trackingRepository.findAll();
        return new SuccessDataResult<>(result,"Success");
    }
}
