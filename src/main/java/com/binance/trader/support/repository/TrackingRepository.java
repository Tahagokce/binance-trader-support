package com.binance.trader.support.repository;

import com.binance.trader.support.models.entities.TrackingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingRepository extends JpaRepository<TrackingModel,Long> {
}
