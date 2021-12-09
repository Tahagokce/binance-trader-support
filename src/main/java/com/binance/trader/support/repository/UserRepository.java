package com.binance.trader.support.repository;
import com.binance.trader.support.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
