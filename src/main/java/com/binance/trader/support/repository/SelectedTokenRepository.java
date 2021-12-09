package com.binance.trader.support.repository;

import com.binance.trader.support.models.entities.SelectedToken;
import com.binance.trader.support.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SelectedTokenRepository extends JpaRepository<SelectedToken,Integer> {
   List<SelectedToken> findByUser(User user);
}
